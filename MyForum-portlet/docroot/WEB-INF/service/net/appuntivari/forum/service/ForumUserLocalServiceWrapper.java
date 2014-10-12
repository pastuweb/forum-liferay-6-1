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
 * This class is a wrapper for {@link ForumUserLocalService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumUserLocalService
 * @generated
 */
public class ForumUserLocalServiceWrapper implements ForumUserLocalService,
	ServiceWrapper<ForumUserLocalService> {
	public ForumUserLocalServiceWrapper(
		ForumUserLocalService forumUserLocalService) {
		_forumUserLocalService = forumUserLocalService;
	}

	/**
	* Adds the forum user to the database. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @return the forum user that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser addForumUser(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.addForumUser(forumUser);
	}

	/**
	* Creates a new forum user with the primary key. Does not add the forum user to the database.
	*
	* @param id_forum_user the primary key for the new forum user
	* @return the new forum user
	*/
	public net.appuntivari.forum.model.ForumUser createForumUser(
		long id_forum_user) {
		return _forumUserLocalService.createForumUser(id_forum_user);
	}

	/**
	* Deletes the forum user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user that was removed
	* @throws PortalException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser deleteForumUser(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.deleteForumUser(id_forum_user);
	}

	/**
	* Deletes the forum user from the database. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @return the forum user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser deleteForumUser(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.deleteForumUser(forumUser);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _forumUserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	public net.appuntivari.forum.model.ForumUser fetchForumUser(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.fetchForumUser(id_forum_user);
	}

	/**
	* Returns the forum user with the primary key.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user
	* @throws PortalException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser getForumUser(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getForumUser(id_forum_user);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getForumUsers(start, end);
	}

	/**
	* Returns the number of forum users.
	*
	* @return the number of forum users
	* @throws SystemException if a system exception occurred
	*/
	public int getForumUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getForumUsersCount();
	}

	/**
	* Updates the forum user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @return the forum user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser updateForumUser(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.updateForumUser(forumUser);
	}

	/**
	* Updates the forum user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumUser the forum user
	* @param merge whether to merge the forum user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the forum user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser updateForumUser(
		net.appuntivari.forum.model.ForumUser forumUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.updateForumUser(forumUser, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public net.appuntivari.forum.model.ForumUser getNewForumUser() {
		return _forumUserLocalService.getNewForumUser();
	}

	public net.appuntivari.forum.model.ForumUser createForumUserAdHoc(
		net.appuntivari.forum.model.ForumUser forumUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.createForumUserAdHoc(forumUser);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByIdForum(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getForumUsersByIdForum(id_forum);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getForumUsersByUserId(user_id);
	}

	public java.util.List<net.appuntivari.forum.model.ForumUser> getForumUsersByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumUserLocalService.getForumUsersByStatus(status);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumUserLocalService getWrappedForumUserLocalService() {
		return _forumUserLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumUserLocalService(
		ForumUserLocalService forumUserLocalService) {
		_forumUserLocalService = forumUserLocalService;
	}

	public ForumUserLocalService getWrappedService() {
		return _forumUserLocalService;
	}

	public void setWrappedService(ForumUserLocalService forumUserLocalService) {
		_forumUserLocalService = forumUserLocalService;
	}

	private ForumUserLocalService _forumUserLocalService;
}