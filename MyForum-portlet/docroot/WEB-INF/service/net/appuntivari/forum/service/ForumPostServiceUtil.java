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
 * The utility for the forum post remote service. This utility wraps {@link net.appuntivari.forum.service.impl.ForumPostServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPostService
 * @see net.appuntivari.forum.service.base.ForumPostServiceBaseImpl
 * @see net.appuntivari.forum.service.impl.ForumPostServiceImpl
 * @generated
 */
public class ForumPostServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.appuntivari.forum.service.impl.ForumPostServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static net.appuntivari.forum.model.ForumPost getForumPostById(
		long id_post) {
		return getService().getForumPostById(id_post);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPost() {
		return getService().getForumPost();
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdCategory(
		long id_category) {
		return getService().getForumPostByIdCategory(id_category);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdCategoryUserId(
		long id_category, long user_id) {
		return getService().getForumPostByIdCategoryUserId(id_category, user_id);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdPostParent(
		long id_post) {
		return getService().getForumPostByIdPostParent(id_post);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByUserId(
		long user_id) {
		return getService().getForumPostByUserId(user_id);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByUserIdParent(
		long user_id_post_parent) {
		return getService().getForumPostByUserIdParent(user_id_post_parent);
	}

	public static void clearService() {
		_service = null;
	}

	public static ForumPostService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ForumPostService.class.getName());

			if (invokableService instanceof ForumPostService) {
				_service = (ForumPostService)invokableService;
			}
			else {
				_service = new ForumPostServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ForumPostServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ForumPostService service) {
	}

	private static ForumPostService _service;
}