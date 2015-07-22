<%@page import="javax.portlet.ActionRequest"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	
	<%
	Forum forumSelected = (Forum) request.getAttribute("forumSelected");
	if(forumSelected == null){
		String forumIdSelected = (String)request.getParameter("forumSelected");
		forumSelected = ForumLocalServiceUtil.getForum(new Long(forumIdSelected));
	}
	%>

	<liferay-ui:error key="mandatory-user" message="mandatory-user" />
	<liferay-ui:error key="user-forum-not-associated" message="user-forum-not-associated" />
	<liferay-ui:success key="user-forum-associated" message="user-forum-associated" />
	<liferay-ui:success key="user-forum-deleted" message="user-forum-deleted" />
	
	<liferay-ui:success key="user-forum-role-deleted" message="user-forum-role-deleted" />
	<liferay-ui:success key="user-forum-role-associated" message="user-forum-role-associated" />
	<liferay-ui:error key="user-forum-role-not-associated" message="user-forum-role-not-associated" />
	
	<portlet:actionURL name="joinUserToFoum" var="joinUserToFoumURL"/>
	<portlet:actionURL name="joinUsersRoleToFoum" var="joinUsersRoleToFoumURL"/>
	<portlet:actionURL name="deleteForumUserRole" var="deleteForumUserRoleURL"/>

	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	List<User> userList = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
	Set<Role> roleList = new HashSet<Role>(RoleLocalServiceUtil.getRoles(0, RoleLocalServiceUtil.getRolesCount()));
	%>
	
	<div style="text-align:center;">
		<h2 style="color:#000000;">
			Community in Forum
			<br>
			<span style="color:#FF0000;">
			<%=forumSelected.getDescription() %>
			</span>
		</h2>
	</div>
	
	
	<div style="position:relative;">
	<div style="float:left;padding:10px;">
		<div class="portlet-msg-info"><span style="color:#283eff;"><liferay-ui:message key="assign-single-user" /></span></div>
		<aui:form action="<%= joinUserToFoumURL.toString() %>" method="post">
		
				<aui:fieldset>
					
						<aui:select name="user_id" label="username_obbl">
							<aui:option value="-1">choose...</aui:option>
						<%
						for(User userItem : userList){
						%>
							<aui:option value="<%=userItem.getUserId()%>"><%=userItem.getScreenName()%></aui:option>
						<%} %>
						</aui:select>
	
					<aui:input name="id_forum" type="hidden" value="<%=forumSelected.getId_forum() %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					
					<div>
						<liferay-ui:message key="mandatory-fields" />
					</div>
						
						<aui:button-row>
							<aui:button type="submit" value="Save"/>
							<aui:button type="reset" value="Reset" />
						</aui:button-row>
					</aui:fieldset>
		</aui:form>
	</div>
	<div style="margin-left:40px;float:left;padding:10px;">
		<div class="portlet-msg-info"><span style="color:#283eff;"><liferay-ui:message key="assign-single-role" /></span></div>
		<aui:form action="<%= joinUsersRoleToFoumURL.toString() %>" method="post">
		
				<aui:fieldset>
					
						<aui:select name="role_name" label="role_obbl">
							<aui:option value="-1">choose...</aui:option>
						
						<%
						for(Role roleItem : roleList){
						%>
							<aui:option value="<%=roleItem.getName()%>"><%=roleItem.getName()%>::<%=CompanyLocalServiceUtil.getCompany(roleItem.getCompanyId()).getName()%></aui:option>
							
						<%}%> 
						
					
						</aui:select>
						
			
					<aui:input name="id_forum" type="hidden" value="<%=forumSelected.getId_forum() %>"/>
					
					<div>
						<liferay-ui:message key="mandatory-fields" />
					</div>
						
						<aui:button-row>
							<aui:button type="submit" value="Save"/>
							<aui:button type="reset" value="Reset" />
						</aui:button-row>
					</aui:fieldset>
		
		</aui:form>
	</div>
	
	<div style="margin-left:40px;float:left;background:#FFEE99;padding:10px;">
		<div class="portlet-msg-alert"><span style="color:#283eff;"><liferay-ui:message key="delete-single-role" /></span></div>
		<aui:form action="<%= deleteForumUserRoleURL.toString() %>" method="post">
		
				<aui:fieldset>
					
						<aui:select name="role_name" label="role_obbl">
							<aui:option value="-1">choose...</aui:option>
						<%
						for(Role roleItem : roleList){
						%>
							<aui:option value="<%=roleItem.getName()%>"><%=roleItem.getName()%>::<%=CompanyLocalServiceUtil.getCompany(roleItem.getCompanyId()).getName()%></aui:option>
							
						<%}%>
						
						
						</aui:select>
						
			
					<aui:input name="id_forum" type="hidden" value="<%=forumSelected.getId_forum() %>"/>
					
					<div>
						<liferay-ui:message key="mandatory-fields" />
					</div>
						
						<aui:button-row>
							<aui:button type="submit" value="Submit"/>
							<aui:button type="reset" value="Reset" />
						</aui:button-row>
					</aui:fieldset>
		
		</aui:form>
	</div>
	<div style="clear:left;"></div>
	</div>
	
	<div style="position:relative;">
		
	<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/forum-admin/forumCommunity.jsp");
	iteratorURL.setParameter("forumSelected",new String(""+forumSelected.getId_forum()));
	%>
	<liferay-ui:search-container emptyResultsMessage="forum-community-empty" delta="10" iteratorURL="<%=iteratorURL %>">
	
	    <liferay-ui:search-container-results>
	    <%	    
	    List<ForumUser> forumList = null;
	    forumList = ForumUserLocalServiceUtil.getForumUsersByIdForum(forumSelected.getId_forum());
	
	    results = ListUtil.subList(forumList, searchContainer.getStart(), searchContainer.getEnd());
	    total = forumList.size();
	
	    pageContext.setAttribute("results", results);
	    pageContext.setAttribute("total", total);
	    %>
	    </liferay-ui:search-container-results>
	
	    <liferay-ui:search-container-row
	        className="net.appuntivari.forum.model.ForumUser"
	        keyProperty="id_forum_user"
	        modelVar="forumUser">
	        
	      <liferay-ui:search-container-column-text
	          name="forum"
	          value="<%=ForumLocalServiceUtil.getForum(forumUser.getId_forum()).getDescription() %>" />

	      <liferay-ui:search-container-column-text
	          name="user"
	          value="<%=UserLocalServiceUtil.getUser(forumUser.getUser_id()).getScreenName() %>" />
		          
		  <liferay-ui:search-container-column-text
		          name="status" 
		          property="status"/>
	          
	      <liferay-ui:search-container-column-jsp 
	          path="/forum-admin/forumUser_actions.jsp"
	          align="right" />
	     
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	
	  </liferay-ui:search-container>	
	
	</div>
	
	<portlet:actionURL name="backToForum" var="backToForumURL"/>
	<aui:button type="button" value="Back to Forums" onClick="<%= backToForumURL.toString() %>" />


 <%@include file="/forum-common/footer.jsp" %> 