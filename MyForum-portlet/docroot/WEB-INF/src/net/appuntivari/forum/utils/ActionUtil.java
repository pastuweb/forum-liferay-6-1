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
		forum.setCreate_user_id(ParamUtil.getLong(request, "create_user_id")); 
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
		
		if (Validator.isNull(forum.getCreate_user_id())) {
			errors.add("mandatory-create-user-id");
			valid = false;
		}
		
		if (Validator.isNull(forum.getCompany_id())) {
			errors.add("mandatory-company-id");
			valid = false;
		}
		
		return valid;
	}
	
}
