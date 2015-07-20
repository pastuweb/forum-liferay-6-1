package net.appuntivari.forum.utils;

import java.util.ArrayList;
import java.util.Date;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;

public class ActionUtil {

	
	public static Forum forumFromRequest(ActionRequest request) {
	       
		Forum forum = ForumLocalServiceUtil.getNewForum();

		forum.setDescription(ParamUtil.getString(request, "description")); 
		forum.setCompany_id(ParamUtil.getLong(request, "company_id"));
		forum.setUser_id_creator(ParamUtil.getLong(request, "user_id_creator")); 
		forum.setStatus(ParamUtil.getString(request, "status"));
		
		return forum;
	}
	
	public static boolean validateForumInInsert(Forum forum, ArrayList<String> errors){
		
		boolean valid = true;
				
		if (Validator.isNull(forum.getDescription())) {
			errors.add("mandatory-description");
			valid = false;
		}
		
		if (Validator.isNull(forum.getStatus())) {
			errors.add("mandatory-status");
			valid = false;
		}
		
		if (Validator.isNull(forum.getUser_id_creator())) {
			errors.add("mandatory-user-id-creator");
			valid = false;
		}
		
		if (Validator.isNull(forum.getCompany_id())) {
			errors.add("mandatory-company-id");
			valid = false;
		}
		
		return valid;
	}
	
	public static boolean validateForum(Forum forum, ArrayList<String> errors){
		
		boolean valid = true;
				
		if (Validator.isNull(forum.getDescription())) {
			errors.add("mandatory-description");
			valid = false;
		}
		
		if (Validator.isNull(forum.getStatus())) {
			errors.add("mandatory-status");
			valid = false;
		}
		
		if (Validator.isNull(forum.getUser_id_creator())) {
			errors.add("mandatory-user-id-creator");
			valid = false;
		}
		
		if (Validator.isNull(forum.getCompany_id())) {
			errors.add("mandatory-company-id");
			valid = false;
		}
		
		return valid;
	}
	
	public static ForumCategory forumCategoryFromRequest(ActionRequest request) {
	    
		ForumCategory forumCategory = ForumCategoryLocalServiceUtil.getNewForumCategory();

		forumCategory.setTitle(ParamUtil.getString(request, "title"));
		forumCategory.setDescription(ParamUtil.getString(request, "description")); 
		forumCategory.setId_forum(ParamUtil.getLong(request, "id_forum")); 
		forumCategory.setTimestamp(new Date());
		if(ParamUtil.getLong(request, "id_category_parent") > 0){
			forumCategory.setId_category_parent(ParamUtil.getLong(request, "id_category_parent"));
		}
		forumCategory.setUser_id_creator(ParamUtil.getLong(request, "user_id_creator")); 
		forumCategory.setStatus(ParamUtil.getString(request, "status"));
		
		return forumCategory;
	}

	public static boolean validateForumCategory(ForumCategory forumCategory, ArrayList<String> errors){
		
		boolean valid = true;
				
		if (Validator.isNull(forumCategory.getTitle())) {
			errors.add("mandatory-title");
			valid = false;
		}
		
		if (Validator.isNull(forumCategory.getDescription())) {
			errors.add("mandatory-description");
			valid = false;
		}
		
		return valid;
	}

	public static ForumUser forumUserFromRequest(ActionRequest request) {
	    
		ForumUser forumUser = ForumUserLocalServiceUtil.getNewForumUser();

		forumUser.setId_forum(ParamUtil.getLong(request, "id_forum"));
		forumUser.setUser_id(ParamUtil.getLong(request, "user_id")); 
		forumUser.setStatus(ParamUtil.getString(request, "status")); 

		return forumUser;
	}

	public static boolean validateForumUser(ForumUser forumUser, ArrayList<String> errors){
		
		boolean valid = true;
				
		if (Validator.isNull(forumUser.getUser_id()) || forumUser.getUser_id() == -1) {
			errors.add("mandatory-user");
			valid = false;
		}
		
		return valid;
	}
	
}
