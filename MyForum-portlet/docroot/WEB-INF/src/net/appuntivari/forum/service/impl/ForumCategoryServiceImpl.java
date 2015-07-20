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

import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.base.ForumCategoryServiceBaseImpl;

/**
 * The implementation of the forum category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.telecomlab.forum.service.ForumCategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see com.telecomlab.forum.service.base.ForumCategoryServiceBaseImpl
 * @see com.telecomlab.forum.service.ForumCategoryServiceUtil
 */
@JSONWebService(mode = JSONWebServiceMode.MANUAL)
public class ForumCategoryServiceImpl extends ForumCategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumCategoryServiceUtil} to access the forum category remote service.
	 */
	
	private static Logger log = Logger.getLogger(ForumCategoryServiceImpl.class);
	
	@JSONWebService(value = "get-forumcategory-id", method = "GET")
	public ForumCategory getForumCategoryById(long id_category){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumcategory-id - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategory(id_category);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumcategory", method = "GET")
	public List<ForumCategory> getForumCategory(){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();

		try {
			log.info("call WS: get-forumcategory - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategories(0, ForumCategoryLocalServiceUtil.getForumCategoriesCount());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumcategory-idforum", method = "GET")
	public List<ForumCategory> getForumCategoryByIdForum(long id_forum){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumcategory-idforum - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(id_forum);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumcategory-idforum-status", method = "GET")
	public List<ForumCategory> getForumCategoryByIdForumStatus(long id_forum, boolean status){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumcategory-idforum-status - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumStatus(id_forum, status);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumcategory-owner", method = "GET")
	public List<ForumCategory> getForumCategoryByOwner(long userid_creator){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumcategory-owner - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategoriesByUserIdCreator(userid_creator);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumcategory-title", method = "GET")
	public List<ForumCategory> getForumCategoryByTitle(String title){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumcategory-title - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategoriesByTitle(title);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JSONWebService(value = "get-forumcategory-idforum-idcategoryparent", method = "GET")
	public List<ForumCategory> getForumCategoryByIdForumCategoryParent(long id_forum, long id_category_parent){
		
		long remote_userid =  PrincipalThreadLocal.getUserId();
		
		try {
			log.info("call WS: get-forumcategory-idforum-idcategoryparent - remote userId = "+remote_userid+" username = "+UserLocalServiceUtil.getUser(remote_userid).getScreenName());
			return ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(id_forum, id_category_parent);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}