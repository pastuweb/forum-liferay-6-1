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

import com.liferay.portal.kernel.exception.SystemException;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.model.impl.ForumPostImpl;
import net.appuntivari.forum.model.impl.ForumUserImpl;
import net.appuntivari.forum.service.base.ForumUserLocalServiceBaseImpl;

/**
 * The implementation of the forum user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumUserLocalServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumUserLocalServiceUtil
 */
public class ForumUserLocalServiceImpl extends ForumUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link net.appuntivari.forum.service.ForumUserLocalServiceUtil} to access the forum user local service.
	 */
	public ForumUser getNewForumUser(){
		return new ForumUserImpl();
	}
	
	public ForumUser createForumUserAdHoc(ForumUser forumUser) throws SystemException{
		
		ForumUser newForumUser = forumUserPersistence.create(
				counterLocalService.increment(
						ForumUser.class.getName()));
		
		newForumUser.setId_forum(forumUser.getId_forum());
		newForumUser.setUser_id(newForumUser.getUser_id());
		newForumUser.setStatus(newForumUser.getStatus());
		
		forumUserPersistence.update(newForumUser, false);
		
		return newForumUser;
	}
	
	
	public List<ForumUser> getForumUsersByIdForum(long id_forum) throws SystemException{
		return forumUserPersistence.findByIdForum(id_forum);
	}
	public List<ForumUser> getForumUsersByUserId(long user_id) throws SystemException{
		return forumUserPersistence.findByUserId(user_id);
	}
	public List<ForumUser> getForumUsersByStatus(boolean status) throws SystemException{
		String strStatus = "DEACTIVE";
		if(status)
			strStatus = "ACTIVE";
		return forumUserPersistence.findByStatus(strStatus);
	}
	
}