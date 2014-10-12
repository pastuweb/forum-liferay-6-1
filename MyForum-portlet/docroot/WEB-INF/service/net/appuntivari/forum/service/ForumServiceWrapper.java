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
 * This class is a wrapper for {@link ForumService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumService
 * @generated
 */
public class ForumServiceWrapper implements ForumService,
	ServiceWrapper<ForumService> {
	public ForumServiceWrapper(ForumService forumService) {
		_forumService = forumService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumService getWrappedForumService() {
		return _forumService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumService(ForumService forumService) {
		_forumService = forumService;
	}

	public ForumService getWrappedService() {
		return _forumService;
	}

	public void setWrappedService(ForumService forumService) {
		_forumService = forumService;
	}

	private ForumService _forumService;
}