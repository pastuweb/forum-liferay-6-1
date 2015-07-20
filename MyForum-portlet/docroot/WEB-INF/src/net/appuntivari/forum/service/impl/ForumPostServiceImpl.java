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

import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceMode;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;
import net.appuntivari.forum.service.base.ForumPostServiceBaseImpl;

/**
 * The implementation of the forum post remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumPostService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumPostServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumPostServiceUtil
 */
@JSONWebService(mode = JSONWebServiceMode.MANUAL)
public class ForumPostServiceImpl extends ForumPostServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumPostServiceUtil} to access the forum post remote service.
	 */
	private static Logger log = Logger.getLogger(ForumPostServiceImpl.class);
	
	@JSONWebService(value = "get-forumpost-id", method = "GET")
	public ForumPost getForumPostById(long id_post){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost-id - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPost(id_post);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumpost", method = "GET")
	public List<ForumPost> getForumPost(){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPosts(0, ForumPostLocalServiceUtil.getForumPostsCount());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumpost-idcategory", method = "GET")
	public List<ForumPost> getForumPostByIdCategory(long id_category){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost-idcategory - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPostsByIdCategory(id_category);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumpost-idcategory-userid", method = "GET")
	public List<ForumPost> getForumPostByIdCategoryUserId(long id_category, long user_id){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost-idcategory-userid - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPostsByIdCategoryUserId(id_category, user_id);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumpost-idpostparent", method = "GET")
	public List<ForumPost> getForumPostByIdPostParent(long id_post){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost-idpostparent - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPostsByIdPostParent(id_post);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumpost-userid", method = "GET")
	public List<ForumPost> getForumPostByUserId(long user_id){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost-userid - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPostsByUserId(user_id);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumpost-useridparent", method = "GET")
	public List<ForumPost> getForumPostByUserIdParent(long user_id_post_parent){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumpost-useridparent - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumPostLocalServiceUtil.getForumPostsByUserIdPostParent(user_id_post_parent);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}