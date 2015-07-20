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

import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;
import net.appuntivari.forum.service.base.ForumUserServiceBaseImpl;

/**
 * The implementation of the forum user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumUserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumUserServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumUserServiceUtil
 */
@JSONWebService(mode = JSONWebServiceMode.MANUAL)
public class ForumUserServiceImpl extends ForumUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumUserServiceUtil} to access the forum user remote service.
	 */
	private static Logger log = Logger.getLogger(ForumUserServiceImpl.class);
	
	@JSONWebService(value = "get-forumuser-id", method = "GET")
	public ForumUser getForumUserById(long id_forum_user){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumuser-id - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumUserLocalServiceUtil.getForumUser(id_forum_user);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumuser", method = "GET")
	public List<ForumUser> getForumUser(){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumuser - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumUserLocalServiceUtil.getForumUsers(0, ForumUserLocalServiceUtil.getForumUsersCount());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumuser-idforum", method = "GET")
	public List<ForumUser> getForumUserByIdForum(long id_forum){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumuser-idforum - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumUserLocalServiceUtil.getForumUsersByIdForum(id_forum);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumuser-idforum-status", method = "GET")
	public List<ForumUser> getForumUserByIdForumStatus(long id_forum,boolean status){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumuser-idforum-status - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumUserLocalServiceUtil.getForumUsersByIdForumStatus(id_forum,status);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumuser-status", method = "GET")
	public List<ForumUser> getForumUserByStatus(boolean status){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumuser-status - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumUserLocalServiceUtil.getForumUsersByStatus(status);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumuser-userid", method = "GET")
	public List<ForumUser> getForumUserByUserId(long userid){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumuser-userid - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumUserLocalServiceUtil.getForumUsersByUserId(userid);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
}