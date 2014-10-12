<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	%>
	<liferay-ui:error key="forum-not-updated" message="forum-not-updated" />
	<liferay-ui:success key="forum-created" message="forum-created" />
	

	<div>
		<strong style="font-size:20px;color:#FF0000;">Forums ACTIVE</strong><br>
		<div style="padding-left:10px;">
			Here you can find all active's forum.
		</div>
		<%
	 		PortletURL currentIteratorForumActiveURL = renderResponse.createRenderURL();
			currentIteratorForumActiveURL.setParameter("jspPage", "/forum-view/forum.jsp");
		%>
		<liferay-ui:search-container emptyResultsMessage="forums-active-company-empty" delta="10" iteratorURL="<%=currentIteratorForumActiveURL %>" >
	
			<!-- Active's Forum By CompanyId and statusForum=ACTIVE -->
	
	
	  	</liferay-ui:search-container>
		<br>
	</div>
	
	
	<div>
		<strong style="font-size:20px;color:#FF0000;">Categories <%= %></strong><br>
		<div style="padding-left:10px;">
			Here you can find all categorie's for forum selected
		</div>
		<%
	 		PortletURL currentIteratorCategoriesForumSelectedURL = renderResponse.createRenderURL();
		currentIteratorCategoriesForumSelectedURL.setParameter("jspPage", "/forum-view/forum.jsp");
		%>
		<liferay-ui:search-container emptyResultsMessage="rootcategories-active-forum-empty" delta="10" iteratorURL="<%=currentIteratorCategoriesForumSelectedURL %>" >
	
			<!-- Active's Categories By Selected Forum (up) and statusCategories=ACTIVE -->	
	
	  	</liferay-ui:search-container>
		<br>
	</div>
	
	<!-- 
	If you select an active Category, you will redirect to a new portlet
	
	In this new portlet you will see all sub-categories of root-categories and
	their own posts.
	 -->


 <%@include file="/forum-common/footer.jsp" %> 