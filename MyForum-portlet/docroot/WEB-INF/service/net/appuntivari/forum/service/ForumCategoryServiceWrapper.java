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

package net.appuntivari.forum.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ForumCategoryService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumCategoryService
 * @generated
 */
public class ForumCategoryServiceWrapper implements ForumCategoryService,
	ServiceWrapper<ForumCategoryService> {
	public ForumCategoryServiceWrapper(
		ForumCategoryService forumCategoryService) {
		_forumCategoryService = forumCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumCategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public net.appuntivari.forum.model.ForumCategory getForumCategoryById(
		long id_category) {
		return _forumCategoryService.getForumCategoryById(id_category);
	}

	public java.util.List<net.appuntivari.forum.model.ForumCategory> getForumCategory() {
		return _forumCategoryService.getForumCategory();
	}

	public java.util.List<net.appuntivari.forum.model.ForumCategory> getForumCategoryByIdForum(
		long id_forum) {
		return _forumCategoryService.getForumCategoryByIdForum(id_forum);
	}

	public java.util.List<net.appuntivari.forum.model.ForumCategory> getForumCategoryByIdForumStatus(
		long id_forum, boolean status) {
		return _forumCategoryService.getForumCategoryByIdForumStatus(id_forum,
			status);
	}

	public java.util.List<net.appuntivari.forum.model.ForumCategory> getForumCategoryByOwner(
		long userid_creator) {
		return _forumCategoryService.getForumCategoryByOwner(userid_creator);
	}

	public java.util.List<net.appuntivari.forum.model.ForumCategory> getForumCategoryByTitle(
		java.lang.String title) {
		return _forumCategoryService.getForumCategoryByTitle(title);
	}

	public java.util.List<net.appuntivari.forum.model.ForumCategory> getForumCategoryByIdForumCategoryParent(
		long id_forum, long id_category_parent) {
		return _forumCategoryService.getForumCategoryByIdForumCategoryParent(id_forum,
			id_category_parent);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumCategoryService getWrappedForumCategoryService() {
		return _forumCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumCategoryService(
		ForumCategoryService forumCategoryService) {
		_forumCategoryService = forumCategoryService;
	}

	public ForumCategoryService getWrappedService() {
		return _forumCategoryService;
	}

	public void setWrappedService(ForumCategoryService forumCategoryService) {
		_forumCategoryService = forumCategoryService;
	}

	private ForumCategoryService _forumCategoryService;
}