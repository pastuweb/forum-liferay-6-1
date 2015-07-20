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
 * This class is a wrapper for {@link ForumUserService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumUserService
 * @generated
 */
public class ForumUserServiceWrapper implements ForumUserService,
	ServiceWrapper<ForumUserService> {
	public ForumUserServiceWrapper(ForumUserService forumUserService) {
		_forumUserService = forumUserService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumUserService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumUserService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumUserService.invokeMethod(name, parameterTypes, arguments);
	}

	public net.appuntivari.forum.model.ForumUser getForumUserById(
		long id_forum_user) {
		return _forumUserService.getForumUserById(id_forum_user);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUser() {
		return _forumUserService.getForumUser();
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUserByIdForum(
		long id_forum) {
		return _forumUserService.getForumUserByIdForum(id_forum);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUserByIdForumStatus(
		long id_forum, boolean status) {
		return _forumUserService.getForumUserByIdForumStatus(id_forum, status);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUserByStatus(
		boolean status) {
		return _forumUserService.getForumUserByStatus(status);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUserByUserId(
		long userid) {
		return _forumUserService.getForumUserByUserId(userid);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumUserService getWrappedForumUserService() {
		return _forumUserService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumUserService(ForumUserService forumUserService) {
		_forumUserService = forumUserService;
	}

	public ForumUserService getWrappedService() {
		return _forumUserService;
	}

	public void setWrappedService(ForumUserService forumUserService) {
		_forumUserService = forumUserService;
	}

	private ForumUserService _forumUserService;
}