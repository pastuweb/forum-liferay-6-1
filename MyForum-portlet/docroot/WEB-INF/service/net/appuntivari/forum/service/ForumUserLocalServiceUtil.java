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
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the forum user local service. This utility wraps {@link net.appuntivari.forum.service.impl.ForumUserLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumUserLocalService
 * @see net.appuntivari.forum.service.base.ForumUserLocalServiceBaseImpl
 * @see net.appuntivari.forum.service.impl.ForumUserLocalServiceImpl
 * @generated
 */
public class ForumUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.appuntivari.forum.service.impl.ForumUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the forum user to the database. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @return the forum user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser addForumUser(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addForumUser(forumUser);
	}

	/**
	* Creates a new forum user with the primary key. Does not add the forum user to the database.
	*
	* @param id_forum_user the primary key for the new forum user
	* @return the new forum user
	*/
	public static net.appuntivari.forum.model.ForumUser createForumUser(
		long id_forum_user) {
		return getService().createForumUser(id_forum_user);
	}

	/**
	* Deletes the forum user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user that was removed
	* @throws PortalException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser deleteForumUser(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteForumUser(id_forum_user);
	}

	/**
	* Deletes the forum user from the database. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @return the forum user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser deleteForumUser(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteForumUser(forumUser);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static net.appuntivari.forum.model.ForumUser fetchForumUser(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchForumUser(id_forum_user);
	}

	/**
	* Returns the forum user with the primary key.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user
	* @throws PortalException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser getForumUser(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUser(id_forum_user);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the forum users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @return the range of forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUsers(start, end);
	}

	/**
	* Returns the number of forum users.
	*
	* @return the number of forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int getForumUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUsersCount();
	}

	/**
	* Updates the forum user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @return the forum user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser updateForumUser(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateForumUser(forumUser);
	}

	/**
	* Updates the forum user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @param merge whether to merge the forum user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the forum user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser updateForumUser(
		net.appuntivari.forum.model.ForumUser forumUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateForumUser(forumUser, merge);
	}

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

	public static net.appuntivari.forum.model.ForumUser getNewForumUser() {
		return getService().getNewForumUser();
	}

	public static net.appuntivari.forum.model.ForumUser createForumUserAdHoc(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createForumUserAdHoc(forumUser);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByIdForum(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUsersByIdForum(id_forum);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUsersByUserId(user_id);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUsersByStatus(status);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByIdForumStatus(
		long id_forum, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumUsersByIdForumStatus(id_forum, status);
	}

	public static boolean isActive(long user_id, long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isActive(user_id, id_forum);
	}

	public static void changeStatusForumUser(long id_forum_user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().changeStatusForumUser(id_forum_user);
	}

	public static void joinUsersToForumByRole(java.lang.String role_name,
		long id_forum)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().joinUsersToForumByRole(role_name, id_forum);
	}

	public static void joinUserToForumByUserId(long user_id, long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().joinUserToForumByUserId(user_id, id_forum);
	}

	public static void clearService() {
		_service = null;
	}

	public static ForumUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ForumUserLocalService.class.getName());

			if (invokableLocalService instanceof ForumUserLocalService) {
				_service = (ForumUserLocalService)invokableLocalService;
			}
			else {
				_service = new ForumUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ForumUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ForumUserLocalService service) {
	}

	private static ForumUserLocalService _service;
}