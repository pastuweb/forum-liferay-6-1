<%@include file="/init.jsp" %>

<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Forum myForum = (Forum) row.getObject();
	String name = Forum.class.getName();
	String primKey = String.valueOf(myForum.getPrimaryKey());

%>


<liferay-ui:icon-menu>
	
	<%if( (ForumLocalServiceUtil.isActive(myForum.getId_forum()) &&  ForumUserLocalServiceUtil.isActive(remote_userid,myForum.getId_forum()) )  ||  myForum.getUser_id_creator() == remote_userid   ){%>
    <portlet:actionURL name="viewPortalForumCategory" var="viewPortalForumCategoryURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="category" message="Categories"  url="<%= viewPortalForumCategoryURL.toString() %>" />
    <%} %>
    
    <%if( (!ForumLocalServiceUtil.isActive(myForum.getId_forum()) ||  !ForumUserLocalServiceUtil.isActive(remote_userid,myForum.getId_forum()) )  && myForum.getUser_id_creator() != remote_userid ){%>
    	<liferay-ui:icon image="lock" message="You can't Enter"  />
 	<%} %>
 	
</liferay-ui:icon-menu>

