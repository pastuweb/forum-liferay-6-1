<%@include file="/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Forum myForum = (Forum) row.getObject();
	String name = Forum.class.getName();
	String primKey = String.valueOf(myForum.getPrimaryKey());
%>

<liferay-ui:icon-menu>
	
    <portlet:actionURL name="editForum" var="editForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= editForumURL.toString() %>" />
    
    <portlet:actionURL name="statisticsForum" var="statisticsForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= statisticsForumURL.toString() %>" />
    
    <portlet:actionURL name="addCategoryForum" var="addCategoryForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= addCategoryForumURL.toString() %>" />
    
    <portlet:actionURL name="deleteForum" var="deleteForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= deleteForumURL.toString() %>" />	

</liferay-ui:icon-menu>

