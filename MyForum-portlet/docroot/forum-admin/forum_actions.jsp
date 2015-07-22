<%@include file="/init.jsp" %>

<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Forum myForum = (Forum) row.getObject();
	String name = Forum.class.getName();
	String primKey = String.valueOf(myForum.getPrimaryKey());
%>

<liferay-ui:icon-menu>
    
    <%if(remote_userid == myForum.getUser_id_creator() ){ %>
    <portlet:actionURL name="editForum" var="editForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit"  message="Edit" url="<%= editForumURL.toString() %>" />
    <%} %>
      
    <portlet:actionURL name="viewForumCategory" var="viewForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="category" message="Categories" url="<%= viewForumCategoryURL.toString() %>" />
    
    
    <%if(remote_userid == myForum.getUser_id_creator()){ %>
    <portlet:actionURL name="deleteForum" var="deleteForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= deleteForumURL.toString() %>" />	
    <%} %>
    
    
    <portlet:actionURL name="forumCommunity" var="forumCommunityURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="user_icon" message="Community" url="<%= forumCommunityURL.toString() %>" />
    
    <%if(remote_userid == myForum.getUser_id_creator()){ %>
    <portlet:actionURL name="active_deactiveForum" var="active_deactiveForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="activate" message="Toogle Status" url="<%= active_deactiveForumURL.toString() %>" />
	<%} %>
	
</liferay-ui:icon-menu>

