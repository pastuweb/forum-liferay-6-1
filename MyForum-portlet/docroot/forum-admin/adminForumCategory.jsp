<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<jsp:useBean id="forumSelected" scope="request" type="net.appuntivari.forum.model.Forum" />

	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	ForumCategory forumCategory = (ForumCategory)request.getAttribute("forumCategory");
	ForumCategory forumCategoryEdit = (ForumCategory) request.getAttribute("forumCategoryEdit");
	%>
	
	<liferay-ui:error key="mandatory-title" message="mandatory-title" />
	<liferay-ui:error key="mandatory-description" message="mandatory-description" />
	<liferay-ui:error key="mandatory-fields" message="mandatory-fields" />
	
	<liferay-ui:error key="forum-category-not-created" message="forum-category-not-created" />
	<liferay-ui:error key="forum-category-not-updated" message="forum-category-not-updated" />
	<liferay-ui:success key="forum-category-created" message="forum-category-created" />
	<liferay-ui:success key="forum-category-updated" message="forum-category-updated" />
	<liferay-ui:success key="forum-category-deleted" message="forum-category-deleted" />
	
	<portlet:actionURL name="createForumCategory" var="createForumCategoryURL"/>
	<portlet:actionURL name="updateForumCategory" var="updateForumCategoryURL"/>
	
	
	<div style="text-align:center;">
		<h2 style="color:#000000;">
			Categories 
			<%if(forumCategory != null && forumCategory.getId_category() == forumCategory.getId_category_parent()){ %>
			for Category <br> <span style="color:#FF0000;"><%=forumCategory.getTitle()%></span><br>
			<%} %>
			of Forum
			<br>
			<span style="color:#FF0000;">
			<%=forumSelected.getDescription() %>
			</span>
		</h2>
	</div>
	
	<%if(remote_userid == forumSelected.getUser_id_creator() || RoleLocalServiceUtil.hasUserRole(remote_userid, RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Administrator").getRoleId())){ %>
	<div style="position:relative;">
		
		
		<%if(forumCategoryEdit == null){ 
			ForumCategory editForumCategoryInsert = (ForumCategory) request.getAttribute("forumCategoryInInsert");
		%>
		<p><strong style="color:#283eff;">INSERT</strong></p>
		<aui:form action="<%= createForumCategoryURL.toString() %>" method="post">
	
			<aui:fieldset>
				<%if(editForumCategoryInsert == null){ %>
					<aui:input name="title" type="text" value=""/>
					<aui:input name="description" type="text" size="150" value=""/>					
					
					<aui:input name="id_forum" type="hidden" value="<%=forumSelected.getId_forum() %>"/>
					<aui:input name="user_id_creator" type="hidden" value="<%=remote_userid %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					<%if(forumCategory != null){ %>
					<aui:input name="id_category_parent" type="hidden" value="<%=forumCategory.getId_category()%>"/>
					<%}%>
					
				<%}else{ %>
				
					<aui:input name="title" type="text" value="<%=editForumCategoryInsert.getTitle() %>"/>
					<aui:input name="description" type="text" size="200" value="<%=editForumCategoryInsert.getDescription() %>"/>					
					
					<aui:input name="id_forum" type="hidden" value="<%=editForumCategoryInsert.getId_forum() %>"/>
					<aui:input name="user_id_creator" type="hidden" value="<%=remote_userid %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					<%if(forumCategory != null){ %>
					<aui:input name="id_category_parent" type="hidden" value="<%=editForumCategoryInsert.getId_category()%>"/>
					<%}%>
				
				<%}%>
				<div>
					<liferay-ui:message key="campi-obbligatori" />
				</div>
				
				<aui:button-row>
					<aui:button type="submit" />
					<aui:button type="reset" value="Cancel" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>
		<%}else{ %>
		<p><strong style="color:#283eff;">EDIT</strong></p>
		<aui:form action="<%= updateForumCategoryURL.toString() %>" method="post">
	
	
			<aui:fieldset>
		
					<aui:input name="title" type="text" value="<%=forumCategoryEdit.getTitle() %>"/>
					<aui:input name="description" type="text" size="150" value="<%=forumCategoryEdit.getDescription() %>"/>					
					
					<aui:input name="id_forum" type="hidden" value="<%=forumCategoryEdit.getId_forum() %>"/>
					<aui:input name="user_id_creator" type="hidden" value="<%=remote_userid %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					<aui:input name="id_category_parent" type="hidden" value="<%=forumCategoryEdit.getId_category()%>"/>
					<aui:input name="id_category" type="hidden" value="<%=forumCategoryEdit.getId_category() %>"/>
				<div>
					<liferay-ui:message key="campi-obbligatori" />
				</div>
				
				<aui:button-row>
					<aui:button type="submit" />
					<aui:button type="reset" value="Cancel" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>
		<%} %>
		
		
	</div>
	
	<br>
	<div class="portlet-msg-alert">
		<p>
		You can add only <strong style="color:#FF0000;">ONE SUB-LEVEL</strong> for every Categories.<br><br>
		<strong style="color:#0026e8">For Instance:</strong><br>
		Forum<br>
		<span style="margin-left:10px;">Category 1</span><br>
		<span style="margin-left:20px;">SubCategory 1.1</span><br>
		<span style="margin-left:35px;color:#FF0000;">SubCategory 1.1.1 <strong>IS NOT PERMITTED</strong></span><br>
		</p>
	</div>
	<%} %>
	<br>
			
	<div style="position:relative;">	
	<%
	 PortletURL currentIteratorURL = renderResponse.createRenderURL();
	 currentIteratorURL.setParameter("jspPage", "/forum-admin/adminForumCategory.jsp");
	%>
	
	<liferay-ui:search-container emptyResultsMessage="forum-categories-empty" delta="10" iteratorURL="<%=currentIteratorURL %>" >
	
	    <liferay-ui:search-container-results>
	    <%	    
	    List<ForumCategory> forumList = new ArrayList<ForumCategory>();
	    if(forumCategory != null){
	    	forumList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(forumSelected.getId_forum(), forumCategory.getId_category());
	    }else{
	    	List<ForumCategory> temp = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(forumSelected.getId_forum());
	    	for(ForumCategory item : temp){
	    		if(item.getId_category() == item.getId_category_parent() ) {
	    			forumList.add(item);
	    		}
	    	}
	    }
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
	          name="forum"
	          value="<%=ForumLocalServiceUtil.getForum(forumcategory.getId_forum()).getDescription() %>" />
	          
	      <liferay-ui:search-container-column-text
	          name="category_parent"
	          value="<%=ForumCategoryLocalServiceUtil.getForumCategory(forumcategory.getId_category_parent()).getTitle() %>" />
	          
	      <liferay-ui:search-container-column-text
		          name="owner" 
		          value="<%=UserLocalServiceUtil.getUserById(forumSelected.getUser_id_creator()).getScreenName() %>"/>
		          
		  <liferay-ui:search-container-column-text
		          name="status" 
		          property="status"/>
	          
	      <liferay-ui:search-container-column-jsp 
	          path="/forum-admin/forumCategory_actions.jsp"
	          align="right" />
	     
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	
	  </liferay-ui:search-container>
	  
		<br>
		<portlet:actionURL name="backToForum" var="backToForumURL"/>
		<%if(forumCategory == null){ %>
			<aui:button type="button" value="Back to Forums" onClick="<%= backToForumURL.toString() %>" />
		<%}else { %>
			<portlet:actionURL name="backToForumCategoryParent" var="backToForumCategoryParentURL">
				<portlet:param name="idForumCategoryParent" value="<%=String.valueOf(forumCategory.getId_category_parent())%>"/>
			</portlet:actionURL>
			<aui:button type="button" value="Back to Forums" onClick="<%= backToForumURL.toString() %>" />
			<aui:button type="button" value="Back to Category Parent" onClick="<%= backToForumCategoryParentURL.toString() %>" />
	  	<%} %>
	</div>

 <%@include file="/forum-common/footer.jsp" %> 