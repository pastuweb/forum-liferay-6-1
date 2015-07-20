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

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.impl.ForumServiceImpl;
import net.appuntivari.forum.service.base.ForumServiceBaseImpl;

/**
 * The implementation of the forum remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumServiceUtil
 */
@JSONWebService(mode = JSONWebServiceMode.MANUAL)
public class ForumServiceImpl extends ForumServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumServiceUtil} to access the forum remote service.
	 */
	
	private static Logger log = Logger.getLogger(ForumServiceImpl.class);
	
	@JSONWebService(value = "get-forum-id", method = "GET")
	public Forum getForumById(long id_forum){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forum-id - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumLocalServiceUtil.getForum(id_forum);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forum", method = "GET")
	public List<Forum> getForum(long id_forum){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forum - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumLocalServiceUtil.getForums(0, ForumLocalServiceUtil.getForumsCount());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forum-companyid", method = "GET")
	public List<Forum> getForumByCompanyId(long company_id){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forum-companyid - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumLocalServiceUtil.getForumsByCompanyId(company_id);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forum-owner", method = "GET")
	public List<Forum> getForumByOwner(long userid_creator){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forum-owner - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumLocalServiceUtil.getForumsByUserIdCreator(userid_creator);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forum-owner-status", method = "GET")
	public List<Forum> getForumByOwnerStatus(long userid_creator, boolean status){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forum-owner-status - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumLocalServiceUtil.getForumsByUserIdCreatorStatus(userid_creator,status);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}