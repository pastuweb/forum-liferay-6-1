package net.appuntivari.forum.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;
import net.appuntivari.forum.utils.ActionUtil;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ForumAdminPortlet extends MVCPortlet {
		 
	private static Logger log = Logger.getLogger(ForumAdminPortlet.class);
	
	protected String adminForumJSP = "/forum-admin/adminForum.jsp";
	protected String adminForumCategoryJSP = "/forum-admin/adminForumCategory.jsp";
	protected String previewInfoJSP = "/forum-admin/previewInfo.jsp";
	protected String forumStatisticsJSP = "/forum-admin/forumStatistics.jsp";
	protected String forumCommunityJSP = "/forum-admin/forumCommunity.jsp";
	
	public void createForum(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
		    ArrayList<String> errors = new ArrayList<String>();
		    
			Forum forum = ActionUtil.forumFromRequest(request);
			
			if (ActionUtil.validateForum(forum, errors) ) {
				 
				 ForumLocalServiceUtil.createForumAdHoc(forum);
		         SessionMessages.add(request, "forum-created");
				 
		         request.setAttribute("forumEdit", null);
				 response.setRenderParameter("jspPage", adminForumJSP);
			 }else{
				 SessionErrors.add(request, "mandatory-fields");
				 for (String error : errors) {
					 SessionErrors.add(request, error);
				 }
				 request.setAttribute("forumEdit", null);
				 request.setAttribute("forumInInsert", forum);
				 response.setRenderParameter("jspPage", adminForumJSP);
			 }
  
	 }
	
	
	public void createForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
		    ArrayList<String> errors = new ArrayList<String>();
		    
			ForumCategory forumCategory = ActionUtil.forumCategoryFromRequest(request);
			Forum forumSelected =ForumLocalServiceUtil.getForum(forumCategory.getId_forum());
			
			 if (ActionUtil.validateForumCategory(forumCategory, errors) ) {
				 
				 ForumCategory temp = ForumCategoryLocalServiceUtil.createForumCategoryAdHoc(forumCategory);
				 	if(! (forumCategory.getId_category_parent() > 0) ){
				 		temp.setId_category_parent(temp.getId_category());
				 		ForumCategoryLocalServiceUtil.updateForumCategory(temp);//update with ID_CATEGORY_PARENT correct.
				 	}
		         SessionMessages.add(request, "forum-category-created");
				 
		         request.setAttribute("forumSelected", forumSelected);
		         if(! (forumCategory.getId_category_parent() > 0) ){
		        	 request.setAttribute("forumCategory", null);
		         }else{
		        	 request.setAttribute("forumCategory", ForumCategoryLocalServiceUtil.getForumCategory(forumCategory.getId_category_parent()));
		         }
		         request.setAttribute("forumCategoryEdit", null);
				 response.setRenderParameter("jspPage", adminForumCategoryJSP);
			 }else{
				 SessionErrors.add(request, "mandatory-fields");
				 for (String error : errors) {
					 SessionErrors.add(request, error);
				 }
				 request.setAttribute("forumSelected", forumSelected);
		         request.setAttribute("forumCategory", null);
		         request.setAttribute("forumCategoryEdit", null);
				 response.setRenderParameter("jspPage", adminForumCategoryJSP);
			 }
  
	 }
	
	
	
	public void editForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");

		
        if (Validator.isNotNull(resourcePrimKey)) {
        	ForumCategory forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey);
        	Forum forumSelected =ForumLocalServiceUtil.getForum(forumCategory.getId_forum());
            request.setAttribute("forumCategoryEdit", forumCategory);
            request.setAttribute("forumSelected", forumSelected);
            response.setRenderParameter("jspPage", adminForumCategoryJSP);
        }
	        
	}
	
	public void updateForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		 ArrayList<String> errors = new ArrayList<String>();
		 long id_category = ParamUtil.getLong(request, "id_category");
		 ForumCategory originalForumCategory = ForumCategoryLocalServiceUtil.getForumCategory(id_category);
		 Forum forumSelected =ForumLocalServiceUtil.getForum(originalForumCategory.getId_forum());
		 
		 ForumCategory forumCategory = ActionUtil.forumCategoryFromRequest(request);
		 
		 
		 if (ActionUtil.validateForumCategory(forumCategory, errors) ) {
			 
			 originalForumCategory.setTitle(forumCategory.getTitle());
			 originalForumCategory.setDescription(forumCategory.getDescription());
			 originalForumCategory.setTimestamp(new Date());
			 
			 ForumCategoryLocalServiceUtil.updateForumCategory(originalForumCategory);
			 SessionMessages.add(request, "forum-category-updated");
			 
	         request.setAttribute("forumCategoryEdit", null);
	         request.setAttribute("forumSelected", forumSelected);
			 response.setRenderParameter("jspPage", adminForumCategoryJSP);
		 }else{
			 
			 SessionErrors.add(request, "mandatory-fields");
			 for (String error : errors) {
				 SessionErrors.add(request, error);
			 }
			 request.setAttribute("forumCategoryEdit", forumCategory);
			 request.setAttribute("forumSelected", forumSelected);
			 response.setRenderParameter("jspPage", adminForumCategoryJSP);
			 
		 }
	     
	}
	
	public void editForum(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");

        if (Validator.isNotNull(resourcePrimKey)) {
        	Forum forum = ForumLocalServiceUtil.getForum(resourcePrimKey);
            request.setAttribute("forumEdit", forum);
            response.setRenderParameter("jspPage", adminForumJSP);
        }
	        
	}
	
	
	
	public void updateForum(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		 ArrayList<String> errors = new ArrayList<String>();
		 long id_forum = ParamUtil.getLong(request, "id_forum");
	     Forum originalForum = ForumLocalServiceUtil.getForum(id_forum);
		 
	     Forum forum = ActionUtil.forumFromRequest(request);

		 if (ActionUtil.validateForum(forum, errors) ) {
			 
			 originalForum.setDescription(forum.getDescription());
			 originalForum.setCompany_id(forum.getCompany_id());
			 
			 ForumLocalServiceUtil.updateForum(originalForum);
	         SessionMessages.add(request, "forum-updated");
			 
	         request.setAttribute("forumEdit", null);
			 response.setRenderParameter("jspPage", adminForumJSP);
		 }else{
			 SessionErrors.add(request, "mandatory-fields");
			 for (String error : errors) {
				 SessionErrors.add(request, error);
			 }
			 request.setAttribute("forumEdit", forum);
			 response.setRenderParameter("jspPage", adminForumJSP);
		 }
		
	}
	
	public void viewForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		    
		    if (Validator.isNotNull(resourcePrimKey)) {
	        	Forum forumSelected =ForumLocalServiceUtil.getForum(resourcePrimKey);
	            request.setAttribute("forumSelected", forumSelected);
	            request.setAttribute("forumCategory", null);
	            response.setRenderParameter("jspPage", adminForumCategoryJSP);
	        }
		    
	}
	
	public void viewSubForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		    
		    if (Validator.isNotNull(resourcePrimKey)) {
		    	ForumCategory forumCategorySelected = ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey);
		    	Forum forum = ForumLocalServiceUtil.getForum(forumCategorySelected.getId_forum());
		        request.setAttribute("forumSelected", forum);
		        request.setAttribute("forumCategory", forumCategorySelected);
		        response.setRenderParameter("jspPage", adminForumCategoryJSP);
	        }
		    
	}
	
	public void infoForum(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		    
		    if (Validator.isNotNull(resourcePrimKey)) {
	        	Forum forumInfo =ForumLocalServiceUtil.getForum(resourcePrimKey);
	            request.setAttribute("forumInfo", forumInfo);
	            response.setRenderParameter("jspPage", previewInfoJSP);
	        }
		    
	}
	
	public void infoForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		    
		    if (Validator.isNotNull(resourcePrimKey)) {
		    	ForumCategory forumCategoryInfo = ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey);
	            request.setAttribute("forumCategoryInfo", forumCategoryInfo);
	            response.setRenderParameter("jspPage", previewInfoJSP);
	        }
		    
	}
	
	public void backToForum(ActionRequest request, ActionResponse response)
	        throws Exception {			
	            response.setRenderParameter("jspPage", adminForumJSP);    
	}
	
	public void backToForumCategoryParent(ActionRequest request, ActionResponse response)
	        throws Exception {			
		
		long idForumCategoryParent = ParamUtil.getLong(request, "idForumCategoryParent");
		
		ForumCategory forumCategorySelected = ForumCategoryLocalServiceUtil.getForumCategory(idForumCategoryParent);
		
		if(forumCategorySelected.getId_category() == forumCategorySelected.getId_category_parent()){
			request.setAttribute("forumCategory", null);
		}else{
			request.setAttribute("forumCategory", forumCategorySelected);
		}
		request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(forumCategorySelected.getId_forum()));
			response.setRenderParameter("jspPage", adminForumCategoryJSP);    
	}
	
	public void deleteForum(ActionRequest request, ActionResponse response)
	        throws Exception {			
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		if (Validator.isNotNull(resourcePrimKey)) {
			//get all Categories of that Forum and delete them (and sub Categories)
			List<ForumCategory> forumCategories = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(resourcePrimKey);
			for (ForumCategory forumCategory : forumCategories) {
					
				//get all Posts of that Category and delete them
				List<ForumPost> forumPosts = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory.getId_category());
				for (ForumPost forumPost : forumPosts) {
					ForumPostLocalServiceUtil.deleteForumPost(forumPost.getId_post());
				}
				
				//delete Category
				ForumCategoryLocalServiceUtil.deleteForumCategory(forumCategory.getId_category());
				
			}
	
			//delete Forum
			ForumLocalServiceUtil.deleteForum(resourcePrimKey);		
			SessionMessages.add(request, "forum-deleted");
		    response.setRenderParameter("jspPage", adminForumJSP); 
		}
	}
	
	public void deleteForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		if (Validator.isNotNull(resourcePrimKey)) {
			Forum forumSelected = ForumLocalServiceUtil.getForum(ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey).getId_forum());
			
			//get all SubCategories of that Category and delete them
			List<ForumCategory> forumCategories = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(forumSelected.getId_forum(),resourcePrimKey);
			for (ForumCategory forumCategory : forumCategories) {
					
				//get all Posts of that SubCategory and delete them
				List<ForumPost> forumPosts = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory.getId_category());
				for (ForumPost forumPost : forumPosts) {
					ForumPostLocalServiceUtil.deleteForumPost(forumPost.getId_post());
				}
				
				//delete SubCategory
				ForumCategoryLocalServiceUtil.deleteForumCategory(forumCategory.getId_category());
			}
			
			//get all Posts of that Category and delete them
			List<ForumPost> forumPosts = ForumPostLocalServiceUtil.getForumPostsByIdCategory(resourcePrimKey);
			for (ForumPost forumPost : forumPosts) {
				ForumPostLocalServiceUtil.deleteForumPost(forumPost.getId_post());
			}
	
			//delete Category
			ForumCategoryLocalServiceUtil.deleteForumCategory(resourcePrimKey);		
			
			request.setAttribute("forumSelected", forumSelected);
	        request.setAttribute("forumCategory", null);
	        SessionMessages.add(request, "forum-category-deleted");
			 
	        response.setRenderParameter("jspPage", adminForumCategoryJSP);
		}
	}
	
	public void deleteForumUser(ActionRequest request, ActionResponse response)
	        throws Exception {			
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		if (Validator.isNotNull(resourcePrimKey)) {
			ForumUser forumUser = ForumUserLocalServiceUtil.getForumUser(resourcePrimKey);
			Forum forumSelected = ForumLocalServiceUtil.getForum(forumUser.getId_forum());
			
			//get all Posts of that User Id
			List<ForumPost> forumPosts = ForumPostLocalServiceUtil.getForumPostsByUserId(forumUser.getUser_id());
			for (ForumPost forumPost : forumPosts) {
				ForumPostLocalServiceUtil.deleteForumPost(forumPost.getId_post());
			}
			
			//delete ForumUser from Community
			ForumUserLocalServiceUtil.deleteForumUser(forumUser);
			
			request.setAttribute("forumSelected", forumSelected);
	        SessionMessages.add(request, "user-forum-deleted");
			 
	        response.setRenderParameter("jspPage", forumCommunityJSP);
		}
	}
	
	public void deleteForumUserRole(ActionRequest request, ActionResponse response)
	        throws Exception {			
		
		String role_name = ParamUtil.getString(request, "role_name");
		
		
		if (!role_name.equals("-1")) {
			Forum forumSelected = ForumLocalServiceUtil.getForum(ParamUtil.getLong(request, "id_forum"));
			List<ForumUser> forumUserListToDelete = ForumUserLocalServiceUtil.getForumUsersByIdForum(forumSelected.getId_forum());
			
			Role role = RoleLocalServiceUtil.getRole(forumSelected.getCompany_id(), role_name);
			
			for (ForumUser forumUser : forumUserListToDelete) {
							
				if(UserLocalServiceUtil.getUser(forumUser.getUser_id()).getRoles().contains(role)) {
					//get all Posts of that User Id
					List<ForumPost> forumPosts = ForumPostLocalServiceUtil.getForumPostsByUserId(forumUser.getUser_id());
					for (ForumPost forumPost : forumPosts) {
						ForumPostLocalServiceUtil.deleteForumPost(forumPost.getId_post());
					}
					
					//delete ForumUser from Community
					ForumUserLocalServiceUtil.deleteForumUser(forumUser);
				}
				
			}
			
			
			request.setAttribute("forumSelected", forumSelected);
	        SessionMessages.add(request, "user-forum-role-deleted");
			 
	        response.setRenderParameter("jspPage", forumCommunityJSP);
		}
	}
	
	public void active_deactiveForum(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		if (Validator.isNotNull(resourcePrimKey)) {
			
			ForumLocalServiceUtil.changeStatusForum(resourcePrimKey);
			
			response.setRenderParameter("jspPage", adminForumJSP); 
		}
		
	}
	
	public void active_deactiveForumUser(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		if (Validator.isNotNull(resourcePrimKey)) {
			
			ForumUserLocalServiceUtil.changeStatusForumUser(resourcePrimKey);
			
			ForumUser forumUser = ForumUserLocalServiceUtil.getForumUser(resourcePrimKey);
			request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(forumUser.getId_forum()));
			response.setRenderParameter("jspPage", forumCommunityJSP); 
		}
		
	}
	
	public void active_deactiveForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		if (Validator.isNotNull(resourcePrimKey)) {
			Forum forumSelected = ForumLocalServiceUtil.getForum(ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey).getId_forum());
			
			ForumCategoryLocalServiceUtil.changeStatusForumCategory(resourcePrimKey);
			
			request.setAttribute("forumSelected", forumSelected);
	        request.setAttribute("forumCategory", null);
	        response.setRenderParameter("jspPage", adminForumCategoryJSP);
		}
		
	}
	
	public void forumStatistics(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		Forum forumSelected = ForumLocalServiceUtil.getForum(resourcePrimKey);
		request.setAttribute("forumSelected", forumSelected);
		
		response.setRenderParameter("jspPage", forumStatisticsJSP);
		
	}
	
	public void forumCommunity(ActionRequest request, ActionResponse response)
	        throws Exception {	
		
		long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		
		Forum forumSelected = ForumLocalServiceUtil.getForum(resourcePrimKey);
		request.setAttribute("forumSelected", forumSelected);
		
		response.setRenderParameter("jspPage", forumCommunityJSP);
		
	}
	
	public void joinUserToFoum(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		
		ArrayList<String> errors = new ArrayList<String>();
	    
		ForumUser forumUser = ActionUtil.forumUserFromRequest(request);
		Forum forumSelected = ForumLocalServiceUtil.getForum(forumUser.getId_forum());
		
		if (ActionUtil.validateForumUser(forumUser, errors) ) {
			 
			 ForumUserLocalServiceUtil.joinUserToForumByUserId(forumUser.getUser_id(), forumUser.getId_forum());
	         SessionMessages.add(request, "user-forum-associated");
			 
	         request.setAttribute("forumSelected", forumSelected);
			 response.setRenderParameter("jspPage", forumCommunityJSP);
		 }else{
			 SessionErrors.add(request, "mandatory-fields");
			 SessionMessages.add(request, "user-forum-not-associated");
			 for (String error : errors) {
				 SessionErrors.add(request, error);
			 }
			 request.setAttribute("forumSelected", forumSelected);
			 response.setRenderParameter("jspPage", forumCommunityJSP);
		 }

		
	}
	
	public void joinUsersRoleToFoum(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		
		ArrayList<String> errors = new ArrayList<String>();
		String role_name = ParamUtil.getString(request, "role_name");
		Forum forumSelected = ForumLocalServiceUtil.getForum(ParamUtil.getLong(request, "id_forum"));
		
		if ( role_name != null && !role_name.equals("-1") ) {
			 
			 ForumUserLocalServiceUtil.joinUsersToForumByRole(role_name, ParamUtil.getLong(request, "id_forum"));
	         SessionMessages.add(request, "user-forum-role-associated");
			 
	         request.setAttribute("forumSelected", forumSelected);
			 response.setRenderParameter("jspPage", forumCommunityJSP);
		 }else{
			 SessionErrors.add(request, "mandatory-fields");
			 SessionMessages.add(request, "user-forum-role-not-associated");
			 for (String error : errors) {
				 SessionErrors.add(request, error);
			 }
			 request.setAttribute("forumSelected", forumSelected);
			 response.setRenderParameter("jspPage", forumCommunityJSP);
		 }
		
	}
	

}
