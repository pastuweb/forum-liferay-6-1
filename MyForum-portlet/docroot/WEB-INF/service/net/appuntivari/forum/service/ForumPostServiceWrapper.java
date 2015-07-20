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
 * This class is a wrapper for {@link ForumPostService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumPostService
 * @generated
 */
public class ForumPostServiceWrapper implements ForumPostService,
	ServiceWrapper<ForumPostService> {
	public ForumPostServiceWrapper(ForumPostService forumPostService) {
		_forumPostService = forumPostService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumPostService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumPostService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumPostService.invokeMethod(name, parameterTypes, arguments);
	}

	public net.appuntivari.forum.model.ForumPost getForumPostById(long id_post) {
		return _forumPostService.getForumPostById(id_post);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPost() {
		return _forumPostService.getForumPost();
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdCategory(
		long id_category) {
		return _forumPostService.getForumPostByIdCategory(id_category);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdCategoryUserId(
		long id_category, long user_id) {
		return _forumPostService.getForumPostByIdCategoryUserId(id_category,
			user_id);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdPostParent(
		long id_post) {
		return _forumPostService.getForumPostByIdPostParent(id_post);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByUserId(
		long user_id) {
		return _forumPostService.getForumPostByUserId(user_id);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByUserIdParent(
		long user_id_post_parent) {
		return _forumPostService.getForumPostByUserIdParent(user_id_post_parent);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumPostService getWrappedForumPostService() {
		return _forumPostService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumPostService(ForumPostService forumPostService) {
		_forumPostService = forumPostService;
	}

	public ForumPostService getWrappedService() {
		return _forumPostService;
	}

	public void setWrappedService(ForumPostService forumPostService) {
		_forumPostService = forumPostService;
	}

	private ForumPostService _forumPostService;
}