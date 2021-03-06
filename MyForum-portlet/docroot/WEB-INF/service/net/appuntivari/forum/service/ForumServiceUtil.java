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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the forum remote service. This utility wraps {@link net.appuntivari.forum.service.impl.ForumServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumService
 * @see net.appuntivari.forum.service.base.ForumServiceBaseImpl
 * @see net.appuntivari.forum.service.impl.ForumServiceImpl
 * @generated
 */
public class ForumServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.appuntivari.forum.service.impl.ForumServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static net.appuntivari.forum.model.Forum getForumById(long id_forum) {
		return getService().getForumById(id_forum);
	}

	public static java.util.List<net.appuntivari.forum.model.Forum> getForum(
		long id_forum) {
		return getService().getForum(id_forum);
	}

	public static java.util.List<net.appuntivari.forum.model.Forum> getForumByCompanyId(
		long company_id) {
		return getService().getForumByCompanyId(company_id);
	}

	public static java.util.List<net.appuntivari.forum.model.Forum> getForumByOwner(
		long userid_creator) {
		return getService().getForumByOwner(userid_creator);
	}

	public static java.util.List<net.appuntivari.forum.model.Forum> getForumByOwnerStatus(
		long userid_creator, boolean status) {
		return getService().getForumByOwnerStatus(userid_creator, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static ForumService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ForumService.class.getName());

			if (invokableService instanceof ForumService) {
				_service = (ForumService)invokableService;
			}
			else {
				_service = new ForumServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ForumServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ForumService service) {
	}

	private static ForumService _service;
}