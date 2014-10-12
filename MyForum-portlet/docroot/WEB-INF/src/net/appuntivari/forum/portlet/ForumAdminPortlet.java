package net.appuntivari.forum.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.utils.ActionUtil;

public class ForumAdminPortlet extends MVCPortlet {
		 
	private static Logger log = Logger.getLogger(ForumAdminPortlet.class);
	
	protected String adminForumJSP = "/forum-admin/adminForum.jsp";
	
	public void createForum(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
		    ArrayList<String> errors = new ArrayList<String>();
		    
			Forum forum = ActionUtil.forumFromRequest(request);
			long creatorUSerId = forum.getCreate_user_id();
			
			 if (ActionUtil.validateForumInInsert(forum, errors) ) {
				 
				 ForumLocalServiceUtil.createForumAdHoc(forum);
		         SessionMessages.add(request, "forum-created");
				 
				 response.setRenderParameter("jspPage", adminForumJSP);
			 }else{
				 SessionErrors.add(request, "mandatory-fields");
				 for (String error : errors) {
					 SessionErrors.add(request, error);
				 }
				 response.setRenderParameter("jspPage", adminForumJSP);
			 }
			
	        
	       
	 }
	

}
