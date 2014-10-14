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

import java.util.Date;
import java.util.List;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.impl.ForumImpl;
import net.appuntivari.forum.service.base.ForumLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the forum local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumLocalServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumLocalServiceUtil
 */
public class ForumLocalServiceImpl extends ForumLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link net.appuntivari.forum.service.ForumLocalServiceUtil} to access the forum local service.
	 */
	
	public Forum getNewForum(){
		return new ForumImpl();
	}
	
	public Forum createForumAdHoc(Forum forum) throws SystemException{
		
		Forum newForum = forumPersistence.create(
				counterLocalService.increment(
						Forum.class.getName()));
		
		newForum.setDescription(forum.getDescription());
		newForum.setCompany_id(forum.getCompany_id());
		newForum.setUser_id_creator(forum.getUser_id_creator());
		newForum.setStatus(forum.getStatus());
		newForum.setTimestamp(forum.getTimestamp());
		
		forumPersistence.update(newForum, false);
		
		return newForum;
	}
	
	public List<Forum> getForumsByCompanyId(long company_id) throws SystemException{
		return forumPersistence.findByCompanyId(company_id);
	}
	
	public List<Forum> getForumsByCreateUserId(long user_id_creator) throws SystemException{
		return forumPersistence.findByUserIdCreator(user_id_creator);
	}
	
	public List<Forum> getForumsByStatus(long user_id_creator, boolean status) throws SystemException{
		String strStatus = "DEACTIVE";
		if(status){
			strStatus = "ACTIVE";
		}
		return forumPersistence.findByUserIdCreatorStatus(user_id_creator, strStatus);
	}
	
	public List<Forum> getForumsByTimestamp(Date timestamp) throws SystemException{
		return forumPersistence.findByTimestamp(timestamp);
	}
	
	
	
	
}