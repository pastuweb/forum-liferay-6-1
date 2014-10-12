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

import com.liferay.portal.kernel.exception.SystemException;
import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.impl.ForumImpl;
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
	 * Never reference this interface directly. Always use {@link net.appuntivari.forum.service.ForumCategoryLocalServiceUtil} to access the forum category local service.
	 */
	public Forum getNewForumCategory(){
		return new ForumImpl();
	}
	
	public ForumCategory createForumCategoryAdHoc(ForumCategory forumCategory) throws SystemException{
		
		ForumCategory newForumCategory = forumCategoryPersistence.create(
				counterLocalService.increment(
						ForumCategory.class.getName()));
		
		newForumCategory.setTitle(forumCategory.getTitle());
		newForumCategory.setDescription(forumCategory.getDescription());
		newForumCategory.setId_category_parent(forumCategory.getId_category_parent());
		newForumCategory.setCreate_user_id(forumCategory.getCreate_user_id());
		newForumCategory.setId_forum(forumCategory.getId_forum());
		newForumCategory.setTimestamp(forumCategory.getTimestamp());
		newForumCategory.setStatus(forumCategory.getStatus());
		
		forumCategoryPersistence.update(newForumCategory, false);
		
		return newForumCategory;
	}
	
	public List<ForumCategory> getForumCategoriesByTimestamp(Date timestamp) throws SystemException{
		return forumCategoryPersistence.findByTimestamp(timestamp);
	}
	
	public List<ForumCategory> getForumCategoriesByTitle(String title) throws SystemException{
		return forumCategoryPersistence.findByTitle(title);
	}
	
	public List<ForumCategory> getForumCategoriesByIdForum(long id_forum) throws SystemException{
		return forumCategoryPersistence.findByIdForum(id_forum);
	}
	
	public List<ForumCategory> getForumCategoriesByCreateUserId(long create_user_id) throws SystemException{
		return forumCategoryPersistence.findByCreateUserId(create_user_id);
	}
}