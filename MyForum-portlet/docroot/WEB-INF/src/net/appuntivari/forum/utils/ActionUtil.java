package net.appuntivari.forum.utils;

import java.util.ArrayList;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.service.ForumLocalServiceUtil;

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
		
		boolean valid = false;
				
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
	
}
