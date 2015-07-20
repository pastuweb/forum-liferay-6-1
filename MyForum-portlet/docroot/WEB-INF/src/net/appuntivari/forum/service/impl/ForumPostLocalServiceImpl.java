/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.appuntivari.forum.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.model.impl.ForumImpl;
import net.appuntivari.forum.model.impl.ForumPostImpl;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;
import net.appuntivari.forum.service.base.ForumPostLocalServiceBaseImpl;

/**
 * The implementation of the forum post local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumPostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumPostLocalServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumPostLocalServiceUtil
 */
public class ForumPostLocalServiceImpl extends ForumPostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumPostLocalServiceUtil} to access the forum post local service.
	 */
	public ForumPost getNewForumPost(){
		return new ForumPostImpl();
	}
	
	public ForumPost createForumPostAdHoc(ForumPost forumPost) throws SystemException{
		
		ForumPost newForumPost = forumPostPersistence.create(
				counterLocalService.increment(
						ForumPost.class.getName()));
		
		newForumPost.setPost(forumPost.getPost());
		newForumPost.setId_category(forumPost.getId_category());
		newForumPost.setUser_id(forumPost.getUser_id());
		newForumPost.setTimestamp(forumPost.getTimestamp());
		newForumPost.setId_post_parent(forumPost.getId_post_parent());
		newForumPost.setUser_id_post_parent(forumPost.getUser_id_post_parent());
		
		
		return forumPostPersistence.update(newForumPost, false);
	}
	
	
	public List<ForumPost> getForumPostsByTimestamp(Date timestamp) throws SystemException{
		return forumPostPersistence.findByTimestamp(timestamp);
	}
	public List<ForumPost> getForumPostsByUserId(long user_id) throws SystemException{
		return forumPostPersistence.findByUserId(user_id);
	}
	public List<ForumPost> getForumPostsByUserIdPostParent(long user_id_post_parent) throws SystemException{
		List<ForumPost> result = new ArrayList<ForumPost>();
		List<ForumPost> temp =  forumPostPersistence.findByUserIdPostParent(user_id_post_parent);
		
		for (ForumPost forumPost : temp) {
			if(forumPost.getId_post() != forumPost.getId_post_parent()){
				result.add(forumPost);
			}
		}
				
		return result;
	}
	public List<ForumPost> getForumPostsRootByIdCategory(long id_category) throws SystemException{
		List<ForumPost> result = new ArrayList<ForumPost>();
		List<ForumPost> temp =  forumPostPersistence.findByIdCategory(id_category);	
		
		for (ForumPost forumPost : temp) {
			if(forumPost.getId_post() == forumPost.getId_post_parent()){
				result.add(forumPost);
			}
		}
				
		return result;
	}
	public List<ForumPost> getForumPostsByIdCategory(long id_category) throws SystemException{
		return forumPostPersistence.findByIdCategory(id_category);	
	}
	public List<ForumPost> getForumPostsByIdCategoryUserId(long id_category, long user_id)throws SystemException{
		return forumPostPersistence.findByIdCategoryUserId(id_category,user_id);
	}
	public List<ForumPost> getForumPostsByIdPostParent(long id_post)throws SystemException{
		List<ForumPost> result = new ArrayList<ForumPost>();
		List<ForumPost> temp = forumPostPersistence.findByIdPostParent(id_post);
		for (ForumPost forumPost : temp) {
			if(forumPost.getId_post() != forumPost.getId_post_parent()){
				result.add(forumPost);
			}
		}
				
		return result;
	}
	
	public boolean hasReplys(long id_post){
		List<ForumPost> posts;
		try {
			posts = ForumPostLocalServiceUtil.getForumPostsByIdPostParent(id_post);
			if(posts.size() > 0){
				return true;
			}else{
				return false;
			}
		} catch (SystemException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}