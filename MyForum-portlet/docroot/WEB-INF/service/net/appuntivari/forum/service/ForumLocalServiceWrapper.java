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
 * This class is a wrapper for {@link ForumLocalService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumLocalService
 * @generated
 */
public class ForumLocalServiceWrapper implements ForumLocalService,
	ServiceWrapper<ForumLocalService> {
	public ForumLocalServiceWrapper(ForumLocalService forumLocalService) {
		_forumLocalService = forumLocalService;
	}

	/**
	* Adds the forum to the database. Also notifies the appropriate model listeners.
	*
	* @param forum the forum
	* @return the forum that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.Forum addForum(
		net.appuntivari.forum.model.Forum forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.addForum(forum);
	}

	/**
	* Creates a new forum with the primary key. Does not add the forum to the database.
	*
	* @param id_forum the primary key for the new forum
	* @return the new forum
	*/
	public net.appuntivari.forum.model.Forum createForum(long id_forum) {
		return _forumLocalService.createForum(id_forum);
	}

	/**
	* Deletes the forum with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_forum the primary key of the forum
	* @return the forum that was removed
	* @throws PortalException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.Forum deleteForum(long id_forum)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.deleteForum(id_forum);
	}

	/**
	* Deletes the forum from the database. Also notifies the appropriate model listeners.
	*
	* @param forum the forum
	* @return the forum that was removed
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.Forum deleteForum(
		net.appuntivari.forum.model.Forum forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.deleteForum(forum);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _forumLocalService.dynamicQuery();
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
		return _forumLocalService.dynamicQuery(dynamicQuery);
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
		return _forumLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _forumLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _forumLocalService.dynamicQueryCount(dynamicQuery);
	}

	public net.appuntivari.forum.model.Forum fetchForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.fetchForum(id_forum);
	}

	/**
	* Returns the forum with the primary key.
	*
	* @param id_forum the primary key of the forum
	* @return the forum
	* @throws PortalException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.Forum getForum(long id_forum)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForum(id_forum);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the forums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @return the range of forums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.Forum> getForums(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForums(start, end);
	}

	/**
	* Returns the number of forums.
	*
	* @return the number of forums
	* @throws SystemException if a system exception occurred
	*/
	public int getForumsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForumsCount();
	}

	/**
	* Updates the forum in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forum the forum
	* @return the forum that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.Forum updateForum(
		net.appuntivari.forum.model.Forum forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.updateForum(forum);
	}

	/**
	* Updates the forum in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forum the forum
	* @param merge whether to merge the forum with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the forum that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.Forum updateForum(
		net.appuntivari.forum.model.Forum forum, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.updateForum(forum, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public net.appuntivari.forum.model.Forum getNewForum() {
		return _forumLocalService.getNewForum();
	}

	public net.appuntivari.forum.model.Forum createForumAdHoc(
		net.appuntivari.forum.model.Forum forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.createForumAdHoc(forum);
	}

	public java.util.List<net.appuntivari.forum.model.Forum> getForumsByCompanyId(
		long company_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForumsByCompanyId(company_id);
	}

	public java.util.List<net.appuntivari.forum.model.Forum> getForumsByCreateUserId(
		long create_user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForumsByCreateUserId(create_user_id);
	}

	public java.util.List<net.appuntivari.forum.model.Forum> getForumsByStatus(
		long create_user_id, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForumsByStatus(create_user_id, status);
	}

	public java.util.List<net.appuntivari.forum.model.Forum> getForumsByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumLocalService.getForumsByTimestamp(timestamp);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumLocalService getWrappedForumLocalService() {
		return _forumLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumLocalService(ForumLocalService forumLocalService) {
		_forumLocalService = forumLocalService;
	}

	public ForumLocalService getWrappedService() {
		return _forumLocalService;
	}

	public void setWrappedService(ForumLocalService forumLocalService) {
		_forumLocalService = forumLocalService;
	}

	private ForumLocalService _forumLocalService;
}