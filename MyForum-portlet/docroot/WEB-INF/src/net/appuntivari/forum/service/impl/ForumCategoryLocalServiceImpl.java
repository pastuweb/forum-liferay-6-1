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

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.impl.ForumCategoryImpl;
import net.appuntivari.forum.model.impl.ForumImpl;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.base.ForumCategoryLocalServiceBaseImpl;

/**
 * The implementation of the forum category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.appuntivari.forum.service.ForumCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.base.ForumCategoryLocalServiceBaseImpl
 * @see net.appuntivari.forum.service.ForumCategoryLocalServiceUtil
 */
public class ForumCategoryLocalServiceImpl
extends ForumCategoryLocalServiceBaseImpl {
/*
 * NOTE FOR DEVELOPERS:
 *
 * Never reference this interface directly. Always use {@link com.telecomlab.nhapi.service.ForumCategoryLocalServiceUtil} to access the forum category local service.
 */
private static Logger log = Logger.getLogger(ForumCategoryLocalServiceImpl.class);

public ForumCategory getNewForumCategory(){
	return new ForumCategoryImpl();
}


public ForumCategory createForumCategoryAdHoc(ForumCategory forumCategory) throws SystemException{
	
	ForumCategory newForumCategory = forumCategoryPersistence.create(
			counterLocalService.increment(
					ForumCategory.class.getName()));
	
	newForumCategory.setTitle(forumCategory.getTitle());
	newForumCategory.setDescription(forumCategory.getDescription());
	newForumCategory.setId_category_parent(forumCategory.getId_category_parent());
	newForumCategory.setUser_id_creator(forumCategory.getUser_id_creator());
	newForumCategory.setId_forum(forumCategory.getId_forum());
	newForumCategory.setTimestamp(forumCategory.getTimestamp());
	newForumCategory.setStatus(forumCategory.getStatus());
			
	return forumCategoryPersistence.update(newForumCategory, false);
}

public List<ForumCategory> getForumCategoriesByTimestamp(Date timestamp) throws SystemException{
	return forumCategoryPersistence.findByTimestamp(timestamp);
}

public List<ForumCategory> getForumCategoriesByTitle(String title) throws SystemException{
	return forumCategoryPersistence.findByTitle(title);
}

public List<ForumCategory> getForumCategoriesByUserIdCreator(long user_id_creator) throws SystemException{
	return forumCategoryPersistence.findByUserIdCreator(user_id_creator);
}

public List<ForumCategory> getForumCategoriesByIdForum(long id_forum) throws SystemException{
	
	List<ForumCategory> result = new ArrayList<ForumCategory>();
	List<ForumCategory> tempList = forumCategoryPersistence.findByIdForum(id_forum);
	for (ForumCategory forumCategory : tempList) {
		if(forumCategory.getId_category() == forumCategory.getId_category_parent()){
			result.add(forumCategory);
		}
	}
	
	return result;
}

public boolean isActive(long id_category, long id_forum) throws SystemException{
	
	ForumCategory forumCategory;
	try {
		forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(id_category);
		List<ForumCategory> result =  forumCategoryPersistence.findByIdForumStatus(id_forum,"ACTIVE");
		if(result.contains(forumCategory)){
			return true;
		}else{
			return false;
		}
	} catch (PortalException e) {
		e.printStackTrace();
		return false;
	}
	
	
}

public List<ForumCategory> getForumCategoriesByIdForumIdCategoryParent(long id_forum, long id_category_parent) throws SystemException{
			
	List<ForumCategory> temp = forumCategoryPersistence.findByIdForumIdCategoryParent(id_forum, id_category_parent);
	List<ForumCategory> result = new ArrayList<ForumCategory>();
	
	for (ForumCategory forumCategory : temp) {
		if(forumCategory.getId_category() != forumCategory.getId_category_parent()){
			result.add(forumCategory);
		}
	}

	return result;
}

public void changeStatusForumCategory(long id_category) throws SystemException, PortalException{
	ForumCategory forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(id_category);
	if(forumCategory.getStatus().equals("ACTIVE")){
		forumCategory.setStatus("DEACTIVE");
		ForumCategoryLocalServiceUtil.updateForumCategory(forumCategory, true);
	}else{
		forumCategory.setStatus("ACTIVE");
		ForumCategoryLocalServiceUtil.updateForumCategory(forumCategory, true);
	}
}

public boolean isMaxLevelOne(long id_category) throws PortalException, SystemException{
	
	ForumCategory forumCategory = ForumCategoryLocalServiceUtil.getForumCategory(id_category);
	if(id_category == forumCategory.getId_category_parent()){
		//log.info("Level 0");
		return false;
	}else{
		//log.info("Level 1 - is Max Level Permitted");
		return true;
	}
	
}


public List<ForumCategory> getForumCategoriesByIdForumStatus(long id_forum, boolean status) throws SystemException{
	String strStatus = "DEACTIVE";
	if(status){
		strStatus = "ACTIVE";
	}
	return forumCategoryPersistence.findByIdForumStatus(id_forum,strStatus);
}
}