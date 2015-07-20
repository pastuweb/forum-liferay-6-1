<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	
	Forum forum = ForumLocalServiceUtil.getNewForum();
	ForumCategory forumCategory = ForumCategoryLocalServiceUtil.getNewForumCategory();
	String info = "";
	
	if(request.getAttribute("forumInfo") != null){
		forum = (Forum)request.getAttribute("forumInfo");
		info = "<p style=\"font-size:16px;\"><strong>"+forum.getDescription()+"</strong> <br><br> ["+forum.getStatus()+"] <br><br> created in "+forum.getTimestamp()+"</p>" ;
	}else if(request.getAttribute("forumCategoryInfo") != null){
		forumCategory = (ForumCategory)request.getAttribute("forumCategoryInfo");
		info = "<p style=\"font-size:16px;\"><strong>"+forumCategory.getTitle()+"</strong> <br>"+forumCategory.getDescription()+" <br><br> ["+forumCategory.getStatus()+"] <br><br> created in "+forumCategory.getTimestamp()+"</p>" ;
	}	
	%>
	
	<div style="position:relative;">
		
		<c:out value="<%=info%>" escapeXml="false"></c:out>
	
	</div>
	
	
		<portlet:actionURL name="backToForum" var="backToForumURL"/>
		<%if(request.getAttribute("forumInfo") != null){%>
			<aui:button type="button" value="Back to Forum" onClick="<%= backToForumURL.toString() %>" />
		<%}else if(request.getAttribute("forumCategoryInfo") != null){%>
			<portlet:actionURL name="backToForumCategoryParent" var="backToForumCategoryParentURL">
				<portlet:param name="idForumCategoryParent" value="<%=String.valueOf(forumCategory.getId_category_parent())%>"/>
			</portlet:actionURL>
			<aui:button type="button" value="Back to Forum" onClick="<%= backToForumURL.toString() %>" />
			<aui:button type="button" value="Back to Category Parent" onClick="<%= backToForumCategoryParentURL.toString() %>" />
	  	<%} %>

 <%@include file="/forum-common/footer.jsp" %> 