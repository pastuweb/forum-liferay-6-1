<%@include file="/init.jsp" %>
<%@include file="/forum-common/headerPortal.jsp" %>
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	Forum forumSelected = (Forum)request.getAttribute("forumSelected");	
	%>

	<div>
		<div class="portlet-msg-info">
			<img src="<%=request.getContextPath()%>/images/forum.png" alt="Forums" style="width:20px;"/> Forums
		</div>	
		<%
	 		PortletURL currentIteratorForumActiveURL = renderResponse.createRenderURL();
			currentIteratorForumActiveURL.setParameter("jspPage", "/forum-view/forum.jsp");
		%>
		<liferay-ui:search-container emptyResultsMessage="forums-company-empty" delta="10" iteratorURL="<%=currentIteratorForumActiveURL %>" >
				
			<liferay-ui:search-container-results>
		    <%	    
		    List<Forum> forumList = ForumLocalServiceUtil.getForumsByCompanyId(themeDisplay.getCompanyId());

		    results = ListUtil.subList(forumList, searchContainer.getStart(), searchContainer.getEnd());
		    total = forumList.size();
		
		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
		    %>
	    	</liferay-ui:search-container-results>
	
		    <liferay-ui:search-container-row
		        className="net.appuntivari.forum.model.Forum"
		        keyProperty="id_forum"
		        modelVar="forum">
		        
		      <liferay-ui:search-container-column-text
		          name="description"
		          property="description" />
		          
		      <liferay-ui:search-container-column-text
			          name="owner" 
			          value="<%=UserLocalServiceUtil.getUserById(forum.getUser_id_creator()).getScreenName() %>"/>
			          
		          
		      <liferay-ui:search-container-column-jsp 
		          path="/forum-view/forumPortal_actions.jsp"
		          align="right" />
		     
		    </liferay-ui:search-container-row>
	
	    	<liferay-ui:search-iterator />
	    	
	  	</liferay-ui:search-container>
		<br>
	</div>
	
	<%
	if(forumSelected != null && (ForumUserLocalServiceUtil.isActive(remote_userid, forumSelected.getId_forum()) || remote_userid==forumSelected.getUser_id_creator())){ 
		ForumCategory forumCategorySelected = (ForumCategory)request.getAttribute("forumCategorySelected");
	%>
	<div>
		<div class="portlet-msg-info">
			<img src="<%=request.getContextPath()%>/images/category.png" alt="Categories" style="width:20px;"/> Categories of <span style="color:#3871CF"><%=forumSelected.getDescription() %></span>
		</div>
		<%	
		PortletURL currentIteratorCategoriesForumSelectedURL = renderResponse.createRenderURL();
		currentIteratorCategoriesForumSelectedURL.setParameter("jspPage", "/forum-view/forum.jsp");
		%>
		<liferay-ui:search-container emptyResultsMessage="forum-categories-empty" delta="10" iteratorURL="<%=currentIteratorCategoriesForumSelectedURL %>" >
	
	
			<liferay-ui:search-container-results>
		    <%	    
		    List<ForumCategory> forumCategoryList = (List<ForumCategory>)request.getAttribute("forumCategoryList");
		
		    results = ListUtil.subList(forumCategoryList, searchContainer.getStart(), searchContainer.getEnd());
		    total = forumCategoryList.size();
		
		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
		    %>
	    	</liferay-ui:search-container-results>
	
		    <liferay-ui:search-container-row
	        className="net.appuntivari.forum.model.ForumCategory"
	        keyProperty="id_category"
	        modelVar="forumcategory">
	        
		      <liferay-ui:search-container-column-text
		          name="title"
		          property="title" />
		          
   
		      <liferay-ui:search-container-column-text
			          name="owner" 
			          value="<%=UserLocalServiceUtil.getUserById(forumSelected.getUser_id_creator()).getScreenName() %>"/>
		    
		          
		      <liferay-ui:search-container-column-jsp 
		          path="/forum-view/forumCategoryPortal_actions.jsp"
		          align="right" />
		     
		    </liferay-ui:search-container-row>
	
	    	<liferay-ui:search-iterator />
	    	
	  	</liferay-ui:search-container>
		<br>
	</div>
	
		<%
		if(forumCategorySelected != null){ 
		%>
		<div>
		
			<div class="portlet-msg-alert">
				<img src="<%=request.getContextPath()%>/images/sub_category.png" alt="Sub-categories" style="width:20px;"/> Sub-Categories of <span style="color:#3871CF"><%=forumCategorySelected.getTitle() %></span>
				<span style="color:#FF0000">(last level)</span>
			</div>
			<%
		 		PortletURL currentIteratorSubCategoriesForumSelectedURL = renderResponse.createRenderURL();
			currentIteratorSubCategoriesForumSelectedURL.setParameter("jspPage", "/forum-view/forum.jsp");
			%>
			<liferay-ui:search-container emptyResultsMessage="forum-sub-categories-empty" delta="10" iteratorURL="<%=currentIteratorSubCategoriesForumSelectedURL %>" >
		
			<liferay-ui:search-container-results>
		    <%	    
		    List<ForumCategory> forumSubCategoryList = (List<ForumCategory>)request.getAttribute("forumSubCategoryList");
		
		    results = ListUtil.subList(forumSubCategoryList, searchContainer.getStart(), searchContainer.getEnd());
		    total = forumSubCategoryList.size();
		
		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
		    %>
	    	</liferay-ui:search-container-results>
	
		    <liferay-ui:search-container-row
	        className="net.appuntivari.forum.model.ForumCategory"
	        keyProperty="id_category"
	        modelVar="forumcategory">
	        
		      <liferay-ui:search-container-column-text
		          name="title"
		          property="title" />
		          		          
		      <liferay-ui:search-container-column-text
		          name="category_parent"
		          value="<%=ForumCategoryLocalServiceUtil.getForumCategory(forumcategory.getId_category_parent()).getTitle() %>" />
		          			  
		          
		      <liferay-ui:search-container-column-jsp 
		          path="/forum-view/forumCategoryPortal_actions.jsp"
		          align="right" />
		     
		    </liferay-ui:search-container-row>
	
	    	<liferay-ui:search-iterator />
		  	</liferay-ui:search-container>
			<br>
		</div>
		<%} %>
	
	<%} %>

 <%@include file="/forum-common/footer.jsp" %> 