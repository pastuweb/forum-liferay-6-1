<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@include file="/init.jsp" %>

<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ForumCategory myForumCategory = (ForumCategory) row.getObject();
	String name = ForumCategory.class.getName();
	String primKey = String.valueOf(myForumCategory.getPrimaryKey());
%>


<liferay-ui:icon-menu>
    
    <%if(remote_userid == myForumCategory.getUser_id_creator() ){ %>
    <portlet:actionURL name="editForumCategory" var="editForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit"  message="Edit" url="<%= editForumCategoryURL.toString() %>" />
    <%} %>
    
     <%if(ForumCategoryLocalServiceUtil.isMaxLevelOne(myForumCategory.getId_category()) == false){%>
    <portlet:actionURL name="viewSubForumCategory" var="viewSubForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="category" message="Sub Categories" url="<%= viewSubForumCategoryURL.toString() %>" />
    <%} %>
    
    <%if(remote_userid == myForumCategory.getUser_id_creator() ){ %>
    <portlet:actionURL name="deleteForumCategory" var="deleteForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= deleteForumCategoryURL.toString() %>" />	
    <%} %>
    
    <%if(remote_userid == myForumCategory.getUser_id_creator() ){ %>
    <portlet:actionURL name="active_deactiveForumCategory" var="active_deactiveForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="activate" message="Toogle Status" url="<%= active_deactiveForumCategoryURL.toString() %>" />	
	<%} %>
	
</liferay-ui:icon-menu>

