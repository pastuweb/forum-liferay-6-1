<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@include file="/forum-common/header.jsp" %>
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	List<Company> companyList = CompanyLocalServiceUtil.getCompanies(0, CompanyLocalServiceUtil.getCompaniesCount());
	Forum forumEdit = (Forum) request.getAttribute("forumEdit");
	%>
	<liferay-ui:error key="mandatory-description" message="mandatory-description" />
	<liferay-ui:error key="mandatory-company-id" message="mandatory-company-id" />
	<liferay-ui:error key="mandatory-fields" message="mandatory-fields" />
	
	<liferay-ui:error key="forum-not-created" message="forum-not-created" />
	<liferay-ui:error key="forum-not-updated" message="forum-not-updated" />
	<liferay-ui:success key="forum-created" message="forum-created" />
	<liferay-ui:success key="forum-updated" message="forum-updated" />
	<liferay-ui:success key="forum-deleted" message="forum-deleted" />
	
	<portlet:actionURL name="createForum" var="createForumURL"/>
	<portlet:actionURL name="updateForum" var="updateForumURL"/>

	<div style="position:relative;">
		<%if(forumEdit == null){ 
			Forum editForumInsert = (Forum) request.getAttribute("forumInInsert");
		%>
		<p><strong style="color:#283eff;">INSERT</strong></p>
		<aui:form action="<%= createForumURL.toString() %>" method="post">
				<aui:fieldset>
					<%if(editForumInsert == null){ %>
						<aui:input name="description" label="description_obbl" size="45" value=""/>
						<!-- select a portal (or Company Id) -->
						<aui:select name="company_id">
						<%
						for(Company itemCompany : companyList){
						%>
							<aui:option value="<%=itemCompany.getCompanyId()%>"><%=itemCompany.getName()%></aui:option>
						<%} %>
						</aui:select>
					<%}else{ %>	
					
						<aui:input name="description" label="description_obbl" size="45" value="<%=editForumInsert.getDescription() %>"/>
						<aui:select name="company_id">
						<%
						for (Company itemCompany : companyList) {
						%>
								<aui:option selected='<%= itemCompany.getCompanyId() == editForumInsert.getCompany_id() %>'
								value="<%=itemCompany.getCompanyId()%>">
								<%=itemCompany.getName()%>
								</aui:option>
						<%
						}
						%>
						</aui:select>
					<%} %>
					<aui:input name="user_id_creator" type="hidden" value="<%=remote_userid %>"/>
					<aui:input name="status" type="hidden" value="ACTIVE"/>
					
					<div>
						<liferay-ui:message key="mandatory-fields" />
					</div>
						
						<aui:button-row>
							<aui:button type="submit" value="Save"/>
							<aui:button type="reset" value="Cancel" />
						</aui:button-row>
					</aui:fieldset>
		</aui:form>
		<%}else{ %>
		<p><strong style="color:#283eff;">EDIT</strong></p>
		<aui:form action="<%= updateForumURL.toString() %>" method="post">
					<aui:fieldset>
						<aui:input name="description" label="description_obbl" size="45" value="<%=forumEdit.getDescription() %>"/>
						<aui:select name="company_id">
						<%
						for (Company itemCompany : companyList) {
						%>
								<aui:option selected='<%= itemCompany.getCompanyId() == forumEdit.getCompany_id() %>'
								value="<%=itemCompany.getCompanyId()%>">
								<%=itemCompany.getName()%>
								</aui:option>
						<%
						}
						%>
						</aui:select>
						<aui:input name="id_forum" type="hidden" value="<%=forumEdit.getId_forum() %>"/>
						<aui:input name="user_id_creator" type="hidden" value="<%=remote_userid %>"/>
						<aui:input name="status" type="hidden" value="ACTIVE"/>
						
						<div>
							<liferay-ui:message key="mandatory-fields" />
						</div>
						
						<aui:button-row>
							<aui:button type="submit" value="Save"/>
							<aui:button type="reset" value="Cancel" />
						</aui:button-row>
					</aui:fieldset>
			</aui:form>
		<%} %>
	
	</div>
	
	<br>
	<div class="portlet-msg-alert">
		<p>
		Only <strong style="color:#FF0000;">Liferay "Administrator"</strong> can manage all Forums and Categories.
		</p>
	</div>
	
	<br>
		
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
	          name="company"
	          value="<%=CompanyLocalServiceUtil.getCompanyById(company.getCompanyId()).getName() %>" />
	          
	      <liferay-ui:search-container-column-text
		          name="owner" 
		          value="<%=UserLocalServiceUtil.getUserById(forum.getUser_id_creator()).getScreenName() %>"/>
		          
		  <liferay-ui:search-container-column-text
		          name="status" 
		          property="status"/>
	          
	      <liferay-ui:search-container-column-jsp 
	          path="/forum-admin/forum_actions.jsp"
	          align="right" />
	     
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	
	  </liferay-ui:search-container>	
	
	</div>

 <%@include file="/forum-common/footer.jsp" %> 