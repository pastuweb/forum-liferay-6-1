<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<jsp:useBean id="forumSelected" scope="request" type="net.appuntivari.forum.model.Forum" />
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	%>
	
	<div style="text-align:center;">
		<h2 style="color:#000000;">
			Statistics of Forum
			<br>
			<span style="color:#FF0000;">
			<%=forumSelected.getDescription()%>
			</span>
		</h2>
	</div>
	
	<div style="position:relative;">
		
		<p style="font-size:16px;"><strong>Summary</strong> - <span style="color:#3871CF">Categories/SubCategories </span>and <span style="color:#3871CF">Posts</span>:</p>
		<div id="chart1" style="margin:auto;height:320px;"></div>
		<br>
		<p style="font-size:16px;"><strong>Community</strong> - <span style="color:#3871CF">Users ACTIVE</span> and <span style="color:#3871CF">DEACTIVE</span>:</p>
		<div id="chart2" style="margin:auto;text-align:center;width:500px"></div>
		<br>
		<p style="font-size:16px;"><strong>Posts</strong> - <span style="color:#3871CF">Categories</span> and <span style="color:#3871CF">Sub Categories</span>:</p>
		<div id="chart3" style="margin:auto;width:500px;float:left;"></div>
		<div id="chart4" style="margin:auto;width:500px;float:left;"></div>
		<div style="clear:left;"></div>
		<br>
		<p style="font-size:16px;"><strong>Posts</strong> - by <span style="color:#3871CF">Users</span></p>
		<div id="chart5" style="margin:auto;width:500px;"></div>
	</div>
	
	<script type="text/javascript">
			
		
		function drawChart1() { //BarChart: SubCategories and Post (by Forum and Category)
	        var data = google.visualization.arrayToDataTable([
	          ['Category', 'SubCategories', 'Posts'],
	          <%
	          List<StatisticTotSubCatPostModel> chart1 = StatisticUtil.getStatisticTotSubCatPostByForum(forumSelected.getId_forum());
	          for(StatisticTotSubCatPostModel item : chart1){
	          %>
	      	  ['<%=ForumCategoryLocalServiceUtil.getForumCategory(item.getId_category()).getTitle()%>', <%=item.getTot_sub_categories()%>, <%=item.getTot_posts()%>],
	          <%}%>
	        ]);

	        var options = {
	          backgroundColor: '#EEF0F2',
	        };

	        var chart = new google.charts.Bar(document.getElementById('chart1'));

	        chart.draw(data, options);
	      }
		
		<%
		long community = ForumUserLocalServiceUtil.getForumUsersByIdForum(forumSelected.getId_forum()).size();
        long user_actives = ForumUserLocalServiceUtil.getForumUsersByIdForumStatus(forumSelected.getId_forum(), true).size();
        long user_deactives = ForumUserLocalServiceUtil.getForumUsersByIdForumStatus(forumSelected.getId_forum(), false).size();
        %>
        
		function drawChart2() { //GaugeChart: User Active and Deactive (by Forum)

	        var data = google.visualization.arrayToDataTable([
	          ['Forum Community', 'Tot'],
	          ['Community', <%=community%>],
	          ['ACTIVE', <%=user_actives%>],
	          ['DEACTIVE', <%=user_deactives%>]
	        ]);

	        var options = {
	          backgroundColor: '#EEF0F2',
	          width: 500, height: 300,
	          redFrom: 90, redTo: 100,
	          yellowFrom:75, yellowTo: 90,
	          minorTicks: 5	          
	         };

	        var chart = new google.visualization.Gauge(document.getElementById('chart2'));

	        chart.draw(data, options);
	      }
		
		 <%
         List<ForumCategory> forumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(forumSelected.getId_forum());
		 long count_post = 0;
		 long slice = 1;
         long count = 1;
         long max = 0;
		 %>
		function drawChart3() { //Posts in Category of the First Level

	        var data = google.visualization.arrayToDataTable([
	          ['Category', 'Tot Post'],
	          <%
	          slice = 1;
	          count = 1;
	          max = 0;
	          for(ForumCategory item : forumCategoryList){
	        	  if(item.getId_category() == item.getId_category_parent()){
		        	  count_post = ForumPostLocalServiceUtil.getForumPostsByIdCategory(item.getId_category()).size();
		        	  if(count_post > max){
		        		  slice = count;
		        		  max = count_post;
		        	  }else{
		        		  count++;
		        	  }
	        	  }
	          %>
	          ['<%=item.getDescription()%>',    <%=count_post%>],
	          <%}%>
	        ]);

	        var options = {
	          height: 320,
	          backgroundColor: '#EEF0F2',
			  title: 'Tot Posts about Categories',
			  is3D: true,
	          slices: {  <%=slice%>: {offset: 0.7} }
	        };

	        var chart = new google.visualization.PieChart(document.getElementById('chart3'));

	        chart.draw(data, options);
	      }
		
		
		function drawChart4() { //Posts in SubCategory of the Second Level

	        var data = google.visualization.arrayToDataTable([
	          ['SubCategory', 'Tot Post'],
	          
	          <%
	          slice = 1;
	          count = 1;
	          max = 0;
	          for(ForumCategory item : forumCategoryList){        	  
		          List<ForumCategory> subForumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(forumSelected.getId_forum(), item.getId_category());	          
		          for(ForumCategory item2 : subForumCategoryList){
		        	  count_post = ForumPostLocalServiceUtil.getForumPostsByIdCategory(item2.getId_category()).size();
		        	  if(count_post > max){
		        		  slice = count;
		        		  max = count_post;
		        	  }else{
		        		  count++;
		        	  }
		        	  
		      %>
	          ['<%=item.getDescription()%> - <%=item2.getDescription()%>',    <%=count_post%>],
	          <%}}%>
	          
	        ]);

	        var options = {
        		height: 320,
        		backgroundColor: '#EEF0F2',
        		title: 'Tot Posts about SubCategories',
        		pieHole: 0.4,
  	            slices: {  <%=slice%>: {offset: 0.7} }
	        };

	        var chart = new google.visualization.PieChart(document.getElementById('chart4'));

	        chart.draw(data, options);
	      }
		 function drawChart5() {
		        var data = new google.visualization.DataTable();
		        data.addColumn('string', 'User');
		        data.addColumn('number', 'Posts');
		        data.addRows([
				<%
				for(ForumUser item : ForumUserLocalServiceUtil.getForumUsersByIdForum(forumSelected.getId_forum())){ 
					List<ForumPost> forumPostList = ForumPostLocalServiceUtil.getForumPostsByUserId(item.getUser_id());
				%>
		          ['<%=UserLocalServiceUtil.getUserById(item.getUser_id()).getScreenName()%>',  <%=forumPostList.size()%>],
				<%
		 		}
				%>
		        ]);
		        
		        var table = new google.visualization.Table(document.getElementById('chart5'));

		        table.draw(data, {showRowNumber: false, sortColumn: 1, sort: true, sortAscending:false});
		}
		 
		google.setOnLoadCallback(drawChart1);
		google.setOnLoadCallback(drawChart2);
		google.setOnLoadCallback(drawChart3);
		google.setOnLoadCallback(drawChart4);
		google.setOnLoadCallback(drawChart5);
    </script>
    
	<portlet:actionURL name="backToForum" var="backToForumURL"/>
	<aui:button type="button" value="Back to Forums" onClick="<%= backToForumURL.toString() %>" />


 <%@include file="/forum-common/footer.jsp" %> 