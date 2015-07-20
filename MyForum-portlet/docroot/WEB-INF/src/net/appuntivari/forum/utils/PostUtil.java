package net.appuntivari.forum.utils;

import java.util.List;

import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;


public class PostUtil {
	private static Logger log = Logger.getLogger(PostUtil.class);
	
	public static String getPosts(long remote_userid, List<ForumPost> posts){		
		
		String styleCssDivPost = "";
		String html = "";
		List<ForumPost> childPosts;
		
		for(ForumPost post: posts){
			
			try {
				childPosts = ForumPostLocalServiceUtil.getForumPostsByIdPostParent(post.getId_post());
				if(childPosts.size() == 0){
					//log.info("post "+post.getId_post() + " childPosts 0");
					html = html + getPostDiv(remote_userid,post, styleCssDivPost, "");
				}else{
					//log.info("post "+post.getId_post() + " childPosts " +childPosts.size());
					html = html + getPostDiv(remote_userid,post, styleCssDivPost, getPosts(remote_userid,childPosts));
				}
			} catch (SystemException e) {
				return html;
			}
		}
		
		return html;
	}
	
	

	public static String getPostDiv(long remote_userid, ForumPost post, String styleCssDivPost, String htmlChildPost){
		
		boolean hasReplys = ForumPostLocalServiceUtil.hasReplys(post.getId_post());
		ForumCategory forumCategory;
		boolean isOwner = false;
		long owner = 0L;
		try {
			forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(post.getId_category());
			owner = forumCategory.getUser_id_creator();
			if(owner == remote_userid){
				isOwner = true;
			}
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}

		User user;
		String html = "";
		String delete = "";
		String reply = "";
		String bg_color_post = "#AED0F3";
		String border_color_post = "#A9A9A9";
		String child_post = htmlChildPost;
		
		try {
			user = UserLocalServiceUtil.getUser(post.getUser_id());
		} catch (PortalException e) {
			e.printStackTrace();
			return html;
		} catch (SystemException e) {
			e.printStackTrace();
			return html;
		}
		
		if(!hasReplys && post.getId_post() == post.getId_post_parent() && remote_userid == post.getUser_id()){
			border_color_post = "#FF0000";
		}
		
		if(!hasReplys && post.getId_post() != post.getId_post_parent() && remote_userid == post.getUser_id()){
			border_color_post = "#FF0000";
		}
		
		
		if( (!hasReplys && remote_userid == post.getUser_id()) || isOwner){
			delete = "<strong><span class=\"delete\" title=\""+post.getId_post()+"\" style=\"cursor:pointer;margin-left:20px;color:#FF0000;\">DELETE</span></strong>";
		}else{
			delete = "";
		}
		
		if(remote_userid != post.getUser_id()){//replace Owner with && !Owner if you don't want to permit to Owner to reply to messages
			reply = "<strong><span class=\"reply\" title=\""+post.getId_post()+"\" style=\"cursor:pointer;margin-left:20px;color:#3871CF;\">REPLY</span></strong>";
			bg_color_post = "#AED0F3";
		
		}else if(remote_userid == post.getUser_id()){
			reply = "<strong><span class=\"reply\" title=\""+post.getId_post()+"\" style=\"cursor:pointer;margin-left:20px;color:#3871CF;\">REPLY</span></strong>";
			bg_color_post = "#6DD773";
		
		}else{
			bg_color_post = "#6DD773";
			reply = "";
		}
		
		if(isOwner){
			if(owner == post.getUser_id()){
				reply = "<strong><span class=\"reply\" title=\""+post.getId_post()+"\" style=\"cursor:pointer;margin-left:20px;color:#3871CF;\">REPLY</span></strong>";
				bg_color_post = "#6DD773";
			}else if(owner != post.getUser_id()){
				bg_color_post = "#AED0F3";
				reply = "<strong><span class=\"reply\" title=\""+post.getId_post()+"\" style=\"cursor:pointer;margin-left:20px;color:#3871CF;\">REPLY</span></strong>";
			}
		}
		
		
		
		html = "<div style=\"background:"+bg_color_post+";border:2px solid "+border_color_post+";padding:5px;margin:5px;"+styleCssDivPost+"%\">"+
			   "Posted by <strong>"+user.getScreenName()+"</strong><br>"+
				"<p style=\"font-size:16px;color:#6E6F71;\">"+
					post.getPost() +
				"</p>"+
				"<strong>"+post.getTimestamp()+"</strong>"+
				delete +			
				reply +
				child_post +
				"</div>";
		
		return html;
	}

}
