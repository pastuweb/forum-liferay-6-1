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
    
    <%if( (!ForumCategoryLocalServiceUtil.isActive(myForumCategory.getId_category(),myForumCategory.getId_forum()) || 
    		!ForumCategoryLocalServiceUtil.isActive(myForumCategory.getId_category(),myForumCategory.getId_forum()) ) &&  myForumCategory.getUser_id_creator() != remote_userid  ){%>
    <liferay-ui:icon image="lock" message="Deactive for You"  />
 	<%} %>
  
    
    <%if( (ForumCategoryLocalServiceUtil.isActive(myForumCategory.getId_category(),myForumCategory.getId_forum())  
    		&& ForumCategoryLocalServiceUtil.isMaxLevelOne(myForumCategory.getId_category()) == false  ) || myForumCategory.getUser_id_creator() == remote_userid       ){%>
    <portlet:actionURL name="viewSubForumCategory" var="viewSubForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="category" message="Sub Categories" url="<%= viewSubForumCategoryURL.toString() %>" />
    <%} %>
    
    <%if( (ForumCategoryLocalServiceUtil.isActive(myForumCategory.getId_category(),myForumCategory.getId_forum()) &&
    		ForumCategoryLocalServiceUtil.isActive(myForumCategory.getId_category(),myForumCategory.getId_forum()) ) || myForumCategory.getUser_id_creator() == remote_userid){%>
    <portlet:actionURL name="postIn" var="postInURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="add_article"  message="Post In" url="<%= postInURL.toString() %>" />
    <%} %>

</liferay-ui:icon-menu>

