<%@include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ForumCategory myForumCategory = (ForumCategory) row.getObject();
	String name = ForumCategory.class.getName();
	String primKey = String.valueOf(myForumCategory.getPrimaryKey());
%>

<liferay-ui:icon-menu>
	
    <portlet:actionURL name="editForumCategory" var="editForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= editForumCategoryURL.toString() %>" />
    
    <portlet:actionURL name="statisticsForum" var="statisticsForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= statisticsForumURL.toString() %>" />
    
    <portlet:actionURL name="addSubCategoryForum" var="addSubCategoryForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= addSubCategoryForumURL.toString() %>" />
    
    <portlet:actionURL name="deleteCategroyForum" var="deleteCategoryForumURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%= deleteCategoryForumURL.toString() %>" />	

</liferay-ui:icon-menu>

