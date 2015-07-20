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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.model.impl.ForumPostImpl;
import net.appuntivari.forum.model.impl.ForumUserImpl;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;
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
	 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumUserLocalServiceUtil} to access the forum user local service.
	 */
	public ForumUser getNewForumUser(){
		return new ForumUserImpl();
	}
	
	public ForumUser createForumUserAdHoc(ForumUser forumUser) throws SystemException{
		
		ForumUser newForumUser = forumUserPersistence.create(
				counterLocalService.increment(
						ForumUser.class.getName()));
		
		newForumUser.setId_forum(forumUser.getId_forum());
		newForumUser.setUser_id(forumUser.getUser_id());
		newForumUser.setStatus(forumUser.getStatus());

		return forumUserPersistence.update(newForumUser, false);
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
	public List<ForumUser> getForumUsersByIdForumStatus(long id_forum, boolean status) throws SystemException{
		String strStatus = "DEACTIVE";
		if(status)
			strStatus = "ACTIVE";
		return forumUserPersistence.findByIdForumStatus(id_forum,strStatus);
	}
	
	public boolean isActive(long user_id, long id_forum) throws SystemException{
		
		List<ForumUser> result =  forumUserPersistence.findByIdForumUserIdStatus(id_forum,user_id,"ACTIVE");
		
		return (result != null && result.size() > 0) ? true : false;
	}
	
	public void changeStatusForumUser(long id_forum_user) throws SystemException, PortalException{
		ForumUser forumUser = ForumUserLocalServiceUtil.getForumUser(id_forum_user);
		if(forumUser.getStatus().equals("ACTIVE")){
			forumUser.setStatus("DEACTIVE");
			ForumUserLocalServiceUtil.updateForumUser(forumUser, true);
		}else{
			forumUser.setStatus("ACTIVE");
			ForumUserLocalServiceUtil.updateForumUser(forumUser, true);
		}
	}
	
	
	public void joinUsersToForumByRole(String role_name, long id_forum) throws PortalException, SystemException{
		
		List<User> userList = new ArrayList<User>();
		
		List<ForumUser> forumUserList = ForumUserLocalServiceUtil.getForumUsersByIdForum(id_forum);
		List<Long> forumUserIdList = new ArrayList<Long>();
		for (ForumUser item : forumUserList) {
			forumUserIdList.add(Long.valueOf(item.getUser_id()));
		}
		
		//check if the Forum exist
		Forum forum = ForumLocalServiceUtil.getForum(id_forum);
		if(forum != null){
			//check if the Role Name exist
			Role role = RoleLocalServiceUtil.getRole(forum.getCompany_id(), role_name);
			if(role != null){
				userList = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
				for (User user : userList) {
					//get all user with that role
					if(user.getRoles().contains(role)){
						
						if(!forumUserIdList.contains(Long.valueOf(user.getUserId()))  ){
							
							//add new Forum User (with that role) for that Forum Id
							ForumUser newForumUser = ForumUserLocalServiceUtil.getNewForumUser();
							newForumUser.setId_forum(id_forum);
							newForumUser.setUser_id(user.getUserId());
							newForumUser.setStatus("ACTIVE");
							
							ForumUserLocalServiceUtil.createForumUserAdHoc(newForumUser);
							
						}
						
						
					}
				}
	
			}
		}

	}
	
	public void joinUserToForumByUserId(long user_id, long id_forum) throws SystemException{
		
		List<ForumUser> forumUserList = ForumUserLocalServiceUtil.getForumUsersByIdForum(id_forum);
		List<Long> forumUserIdList = new ArrayList<Long>();
		for (ForumUser item : forumUserList) {
			forumUserIdList.add(Long.valueOf(item.getUser_id()));
		}
		
		if(!forumUserIdList.contains(Long.valueOf(user_id))  ){
			
			//add new Forum User (with that role) for that Forum Id
			ForumUser newForumUser = ForumUserLocalServiceUtil.getNewForumUser();
			newForumUser.setId_forum(id_forum);
			newForumUser.setUser_id(user_id);
			newForumUser.setStatus("ACTIVE");
			
			ForumUserLocalServiceUtil.createForumUserAdHoc(newForumUser);
			
		}
		
		
		
	}
	
}