<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<jsp:useBean id="forum" scope="request" type="net.appuntivari.forum.model.Forum" />
	<jsp:useBean id="forumCategory" scope="request" type="net.appuntivari.forum.model.ForumCategory" />

	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	%>
	
	<portlet:actionURL name="createCategory" var="createCategoryURL"/>
	
	<div style="text-align:center;">
		<h2 style="color:#000000;">
			Category 
			<%if(forumCategory != null){ %>
			for Category <br> <span style="color:#FF0000;"><%=forumCategory.getTitle()%></span><br>
			<%} %>
			for Forum
			<br>
			<span style="color:#FF0000;">
			<%=forum.getDescription() %>
			</span>
		</h2>
	</div>
	
	<div style="position:relative;">
		<aui:form action="<%= createCategoryURL.toString() %>" method="post">
	
			<aui:fieldset>
		
					<aui:input name="title" type="text" value=""/>
					<aui:input name="description" type="hidden" value=""/>					
					
					<aui:input name="id_forum" type="hidden" value="<%=forum.getId_forum() %>"/>
					<aui:input name="user_id_creator" type="hidden" value="<%=remote_userid %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					
				<div>
					<liferay-ui:message key="campi-obbligatori" />
				</div>
				
				<aui:button-row>
					<aui:button type="submit" />
					<aui:button type="reset" value="Cancel" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>
	
	</div>
	
	<br><br>
			
	<div style="position:relative;">	
	<%
	 PortletURL currentIteratorURL = renderResponse.createRenderURL();
	 currentIteratorURL.setParameter("jspPage", "/forum-admin/adminForumCategory.jsp");
	%>
	
	<liferay-ui:search-container emptyResultsMessage="forum-categories-empty" delta="10" iteratorURL="<%=currentIteratorURL %>" >
	
	    <liferay-ui:search-container-results>
	    <%	    
	    List<ForumCategory> forumList = null;
	    forumList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(forum.getId_forum());
	
	    results = ListUtil.subList(forumList, searchContainer.getStart(), searchContainer.getEnd());
	    total = forumList.size();
	
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
	          name="description"
	          property="description" />
	          
	      <liferay-ui:search-container-column-text
	          name="forum"
	          value="<%=ForumLocalServiceUtil.getForum(forumcategory.getId_forum()).getDescription() %>" />
	          
	      <liferay-ui:search-container-column-text
	          name="category_parent"
	          value="<%=ForumCategoryLocalServiceUtil.getForumCategory(forumcategory.getId_category_parent()).getTitle() %>" />

          <liferay-ui:search-container-column-text
	          name="timestamp"
	          property="timestamp" />
	          
	      <liferay-ui:search-container-column-text
		          name="user_id_creator" 
		          value="<%=UserLocalServiceUtil.getUserById(forum.getUser_id_creator()).getScreenName() %>"/>
		          
		  <liferay-ui:search-container-column-text
		          name="status" 
		          property="status"/>
	          
	      <liferay-ui:search-container-column-jsp 
	          path="/forum-admin/forumCategory_actions.jsp"
	          align="right" />
	     
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	
	  </liferay-ui:search-container>
	  
	  
	    <portlet:renderURL var="backURL">
	  		<portlet:param name="jspPage" value="/forum-admin/adminForum.jsp" />
		</portlet:renderURL>
		<aui:button type="button" value="Back" onClick="<%= backURL.toString() %>" />
	  
	
	</div>

 <%@include file="/forum-common/footer.jsp" %> 