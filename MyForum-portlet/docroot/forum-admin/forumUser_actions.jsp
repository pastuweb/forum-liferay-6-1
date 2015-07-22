<%@include file="/init.jsp" %>

<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    ForumUser myForumUser = (ForumUser) row.getObject();
	String name = ForumUser.class.getName();
	String primKey = String.valueOf(myForumUser.getPrimaryKey());
%>

<liferay-ui:icon-menu>
 
    <portlet:actionURL name="deleteForumUser" var="deleteForumUserURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= deleteForumUserURL.toString() %>" />	
    
    <portlet:actionURL name="active_deactiveForumUser" var="active_deactiveForumUserURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="activate" message="Toogle Status" url="<%= active_deactiveForumUserURL.toString() %>" />
	
</liferay-ui:icon-menu>

