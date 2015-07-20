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
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ForumViewPortlet extends MVCPortlet {
		 
	private static Logger log = Logger.getLogger(ForumViewPortlet.class);
	
	protected String forumJSP = "/forum-view/forum.jsp";
	protected String forumPostsJSP = "/forum-view/posts.jsp";
	
	
	public void viewPortalForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		    
		    if (Validator.isNotNull(resourcePrimKey)) {
	        	Forum forumSelected =ForumLocalServiceUtil.getForum(resourcePrimKey);
	            request.setAttribute("forumSelected", forumSelected);
	            request.setAttribute("forumCategoryList", ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(resourcePrimKey));
	            response.setRenderParameter("jspPage", forumJSP);
	        }

	}
	
	
	public void viewSubForumCategory(ActionRequest request, ActionResponse response)
	        throws Exception {			
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
		    
		    if (Validator.isNotNull(resourcePrimKey)) {
	        	ForumCategory forumCategorySelected = ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey);
	            request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(forumCategorySelected.getId_forum()));
	            request.setAttribute("forumCategorySelected", forumCategorySelected);
	            request.setAttribute("forumCategoryList", ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(forumCategorySelected.getId_forum()));
	            request.setAttribute("forumSubCategoryList", ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(forumCategorySelected.getId_forum(), forumCategorySelected.getId_category()));
	            response.setRenderParameter("jspPage", forumJSP);
	        }
	
	}
	
	public void postIn(ActionRequest request, ActionResponse response)
	        throws Exception {
			
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
			List<ForumPost> posts = new ArrayList<ForumPost>();
			
			if (Validator.isNotNull(resourcePrimKey)) {
				ForumCategory forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(resourcePrimKey);
				
				
				if(forumCategory.getId_category() == forumCategory.getId_category_parent()){
					// Category (Level 0)
					request.setAttribute("forumCategorySelected", forumCategory);
				}else{
					//Category (Level 1 = SubCategory) 
					request.setAttribute("forumSubCategorySelected", forumCategory);
					request.setAttribute("forumCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(forumCategory.getId_category_parent()));
				}
				
				request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(forumCategory.getId_forum()));
				
				posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(forumCategory.getId_category());
				log.info("posts "+posts.size());
				request.setAttribute("posts", posts);
				
				response.setRenderParameter("jspPage", forumPostsJSP);
			}
	}
	
	
	public void addPost(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		List<ForumPost> posts = new ArrayList<ForumPost>();
		
		String post = ParamUtil.getString(request, "post");
		long idForumSelected = ParamUtil.getLong(request, "idForumSelected");
		long idCategorySelected = ParamUtil.getLong(request, "idCategorySelected");
		long idSubCategorySelected = ParamUtil.getLong(request, "idSubCategorySelected");
				
		if(post != null && post.length() > 0){
			
			ForumPost forumPost = ForumPostLocalServiceUtil.getNewForumPost();
			if(idSubCategorySelected > 0){
				forumPost.setId_category(idSubCategorySelected);
			}else{
				forumPost.setId_category(idCategorySelected);
			}
			forumPost.setPost(post);
			forumPost.setTimestamp(new Date());
			forumPost.setUser_id(remote_userid);
			forumPost.setUser_id_post_parent(remote_userid);
			
			ForumPost newPost = ForumPostLocalServiceUtil.createForumPostAdHoc(forumPost);
			newPost.setId_post_parent(newPost.getId_post());
			ForumPostLocalServiceUtil.updateForumPost(newPost);
			
			SessionMessages.add(request, "post-created");
		}else{
			SessionErrors.add(request, "post-not-created");
			SessionErrors.add(request, "post-empty");
		}
		request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(idForumSelected));
		request.setAttribute("forumCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idCategorySelected));
		if(idSubCategorySelected > 0){
			request.setAttribute("forumSubCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idSubCategorySelected));
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idSubCategorySelected);
		}else{
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idCategorySelected);
		}
		
		
		request.setAttribute("posts", posts);
		response.setRenderParameter("jspPage", forumPostsJSP);
	}
	
	public void refreshPosts(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		List<ForumPost> posts = new ArrayList<ForumPost>();
		
		long idForumSelected = ParamUtil.getLong(request, "idForumSelected");
		long idCategorySelected = ParamUtil.getLong(request, "idCategorySelected");
		long idSubCategorySelected = ParamUtil.getLong(request, "idSubCategorySelected");
				
		
		request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(idForumSelected));
		request.setAttribute("forumCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idCategorySelected));
		if(idSubCategorySelected > 0){
			request.setAttribute("forumSubCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idSubCategorySelected));
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idSubCategorySelected);
		}else{
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idCategorySelected);
		}
		
		request.setAttribute("posts", posts);
		
		SessionMessages.add(request, "posts-refreshed");
		
		response.setRenderParameter("jspPage", forumPostsJSP);
		
	}
	
	public void replyPost(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		List<ForumPost> posts = new ArrayList<ForumPost>();
		
		String post = ParamUtil.getString(request, "post");
		long idForumSelected = ParamUtil.getLong(request, "idForumSelected");
		long idPostParent = ParamUtil.getLong(request, "idPostParent");
		long idCategorySelected = ParamUtil.getLong(request, "idCategorySelected");
		long idSubCategorySelected = ParamUtil.getLong(request, "idSubCategorySelected");
				
		if(post != null && post.length() > 0){
			
			ForumPost forumPost = ForumPostLocalServiceUtil.getNewForumPost();
			if(idSubCategorySelected > 0){
				forumPost.setId_category(idSubCategorySelected);
			}else{
				forumPost.setId_category(idCategorySelected);
			}
			forumPost.setPost(post);
			forumPost.setTimestamp(new Date());
			forumPost.setUser_id(remote_userid);
			
			forumPost.setId_post_parent(idPostParent);
			forumPost.setUser_id_post_parent(ForumPostLocalServiceUtil.getForumPost(idPostParent).getUser_id());
			
			ForumPost newPost = ForumPostLocalServiceUtil.createForumPostAdHoc(forumPost);
			
			SessionMessages.add(request, "post-reply-created");
		}else{
			SessionErrors.add(request, "post-reply-not-created");
			SessionErrors.add(request, "post-reply-empty");
		}
		request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(idForumSelected));
		request.setAttribute("forumCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idCategorySelected));
		if(idSubCategorySelected > 0){
			request.setAttribute("forumSubCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idSubCategorySelected));
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idSubCategorySelected);
		}else{
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idCategorySelected);
		}
		
		
		request.setAttribute("posts", posts);
		response.setRenderParameter("jspPage", forumPostsJSP);
	}
	
	
	public void deletePost(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		List<ForumPost> posts = new ArrayList<ForumPost>();
		
		long idForumSelected = ParamUtil.getLong(request, "idForumSelected");
		long idPostSelected = ParamUtil.getLong(request, "idPostSelected");
		long idCategorySelected = ParamUtil.getLong(request, "idCategorySelected");
		long idSubCategorySelected = ParamUtil.getLong(request, "idSubCategorySelected");
		
		ForumCategory forumCategory;
		boolean isOwner = false;
		try {
			forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(idCategorySelected);
			long owner = forumCategory.getUser_id_creator();
			if(owner == remote_userid){
				isOwner = true;
			}
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		if(isOwner){
			deletePostAndChilds(ForumPostLocalServiceUtil.getForumPost(idPostSelected).getId_post_parent(),idPostSelected);
		}else{
			ForumPostLocalServiceUtil.deleteForumPost(idPostSelected);
		}

		request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(idForumSelected));
		request.setAttribute("forumCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idCategorySelected));
		if(idSubCategorySelected > 0){
			request.setAttribute("forumSubCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idSubCategorySelected));
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idSubCategorySelected);
		}else{
			posts = ForumPostLocalServiceUtil.getForumPostsRootByIdCategory(idCategorySelected);
		}
		
		
		request.setAttribute("posts", posts);
		SessionMessages.add(request, "post-deleted");
		
		response.setRenderParameter("jspPage", forumPostsJSP);
	}
	
	public void backToForumPosts(ActionRequest request, ActionResponse response)
	        throws Exception {
		
		long idForumSelected = ParamUtil.getLong(request, "idForumSelected");
		long idCategorySelected = ParamUtil.getLong(request, "idForumCategorySelected");
		long idSubCategorySelected = ParamUtil.getLong(request, "idForumSubCategorySelected");
		
		
		if(idForumSelected > 0 && idCategorySelected > 0){
			request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(idForumSelected));
			request.setAttribute("forumCategoryList", ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(idForumSelected));
		}else if(idForumSelected > 0 && idCategorySelected > 0 && idSubCategorySelected > 0){
			request.setAttribute("forumSelected", ForumLocalServiceUtil.getForum(idForumSelected));
			request.setAttribute("forumCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idCategorySelected));
			request.setAttribute("forumCategoryList", ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(idForumSelected));
			request.setAttribute("forumSubCategorySelected", ForumCategoryLocalServiceUtil.getForumCategory(idSubCategorySelected));
            request.setAttribute("forumSubCategoryList", ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(idForumSelected, idCategorySelected));
		}
		
		response.setRenderParameter("jspPage", forumJSP);
	}
	
	
	private List<ForumPost> getChildPost(long idPost){
		List<ForumPost> childPosts = null;
		try {
			childPosts = ForumPostLocalServiceUtil.getForumPostsByIdPostParent(idPost);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return childPosts;
	}
	
	/*
	 * 1->2->3->4 e 5
	 * 
	 */
	
	private void deletePostAndChilds(long idPostOriginParent, long idPostCurrently) throws PortalException, SystemException{
			log.info("idPostOriginParent "+idPostOriginParent+",idPostCurrently "+idPostCurrently);
			List<ForumPost> childPosts;

			if(idPostOriginParent != idPostCurrently){
			
				childPosts = getChildPost(idPostCurrently);
				if(childPosts.size() == 0){
					ForumPost post = ForumPostLocalServiceUtil.getForumPost(idPostCurrently);
					ForumPostLocalServiceUtil.deleteForumPost(post);
					log.info("delete post "+post.getPost());
					deletePostAndChilds(idPostOriginParent, post.getId_post_parent());
				}else{
					deletePostAndChilds(idPostOriginParent, childPosts.get(0).getId_post());
				}
				
			}

	}
	

}
