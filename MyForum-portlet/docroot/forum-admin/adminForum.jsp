<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	%>
	<liferay-ui:error key="mandatory-description" message="mandatory-description" />
	<liferay-ui:error key="mandatory-status" message="mandatory-status" />
	<liferay-ui:error key="mandatory-create-user-id" message="mandatory-create-user-id" />
	<liferay-ui:error key="mandatory-company-id" message="mandatory-company-id" />
	<liferay-ui:error key="mandatory-fields" message="mandatory-fields" />
	<liferay-ui:error key="forum-not-created" message="forum-not-created" />
	<liferay-ui:error key="forum-not-updated" message="forum-not-updated" />
	<liferay-ui:success key="forum-created" message="forum-created" />
	<liferay-ui:success key="forum-updated" message="forum-updated" />
	
	<portlet:actionURL name="createForum" var="createForumURL"/>
	
	<div style="text-align:center;">
		<h2 style="color:#FF0000;">
			Forums
		</h2>
	</div>


	<div style="position:relative;">
		<aui:form action="<%= createForumURL.toString() %>" method="post">
	
			<aui:fieldset>
		
					<aui:input name="description" type="hidden" value=""/>					
					
					<!-- select a portal (or Company Id) -->
					<aui:select name="company_id">
					<%
					List<Company> companyList = CompanyLocalServiceUtil.getCompanies(0, CompanyLocalServiceUtil.getCompaniesCount());
					for(Company itemCompany : companyList){
					%>
						<aui:option value="<%=itemCompany.getCompanyId()%>"><%=itemCompany.getName()%></aui:option>
					<%} %>
					</aui:select>
										
					<aui:input name="create_user_id" type="hidden" value="<%=remote_userid %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					
				<div>
					<liferay-ui:message key="mandatory-fields" />
				</div>
				
				<aui:button-row>
					<aui:button type="submit" />
					<aui:button type="reset" value="Cancel" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>
	
	</div>
	
	<br><br>
		
	<div style="position:relative;">	
	<%
	 PortletURL currentIteratorURL = renderResponse.createRenderURL();
	 currentIteratorURL.setParameter("jspPage", "/forum-admin/adminForum.jsp");
	%>
	
	<liferay-ui:search-container emptyResultsMessage="forums-empty" delta="10" iteratorURL="<%=currentIteratorURL %>" >
	
	    <liferay-ui:search-container-results>
	    <%	    
	    List<Forum> forumList = null;
	    forumList = ForumLocalServiceUtil.getForums(0, ForumLocalServiceUtil.getForumsCount());
	
	    results = ListUtil.subList(forumList, searchContainer.getStart(), searchContainer.getEnd());
	    total = forumList.size();
	
	    pageContext.setAttribute("results", results);
	    pageContext.setAttribute("total", total);
	    %>
	    </liferay-ui:search-container-results>
	
	    <liferay-ui:search-container-row
	        className="net.appuntivari.forum.model.Forum"
	        keyProperty="id_forum"
	        modelVar="forum">
	        
	      <liferay-ui:search-container-column-text
	          name="description"
	          property="description" />

          <liferay-ui:search-container-column-text
	          name="timestamp"
	          property="timestamp" />

	      <liferay-ui:search-container-column-text
	          name="company_id"
	          value="<%=CompanyLocalServiceUtil.getCompanyById(company.getCompanyId()).getName() %>" />
	          
	      <liferay-ui:search-container-column-text
		          name="create_user_id" 
		          value="<%=UserLocalServiceUtil.getUserById(forum.getCreate_user_id()).getScreenName() %>"/>
		          
		  <liferay-ui:search-container-column-text
		          name="status" 
		          property="status"/>
	          
	      <liferay-ui:search-container-column-jsp 
	          path="/forum-admin/forum_actions.jsp"
	          align="right" />
	     
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	
	  </liferay-ui:search-container>
	  
	  <%-- 	
	    <portlet:renderURL var="backURL">
	  		<portlet:param name="jspPage" value="/forum-admin/adminForum.jsp" />
		</portlet:renderURL>
		<aui:button type="button" value="Back" onClick="<%= backURL.toString() %>" />
	  --%>
	
	
	</div>

 <%@include file="/forum-common/footer.jsp" %> 