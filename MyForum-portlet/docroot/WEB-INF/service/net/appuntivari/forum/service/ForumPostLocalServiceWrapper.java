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
 * This class is a wrapper for {@link ForumPostLocalService}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumPostLocalService
 * @generated
 */
public class ForumPostLocalServiceWrapper implements ForumPostLocalService,
	ServiceWrapper<ForumPostLocalService> {
	public ForumPostLocalServiceWrapper(
		ForumPostLocalService forumPostLocalService) {
		_forumPostLocalService = forumPostLocalService;
	}

	/**
	* Adds the forum post to the database. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @return the forum post that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost addForumPost(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.addForumPost(forumPost);
	}

	/**
	* Creates a new forum post with the primary key. Does not add the forum post to the database.
	*
	* @param id_post the primary key for the new forum post
	* @return the new forum post
	*/
	public net.appuntivari.forum.model.ForumPost createForumPost(long id_post) {
		return _forumPostLocalService.createForumPost(id_post);
	}

	/**
	* Deletes the forum post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post that was removed
	* @throws PortalException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost deleteForumPost(long id_post)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.deleteForumPost(id_post);
	}

	/**
	* Deletes the forum post from the database. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @return the forum post that was removed
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost deleteForumPost(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.deleteForumPost(forumPost);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _forumPostLocalService.dynamicQuery();
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
		return _forumPostLocalService.dynamicQuery(dynamicQuery);
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
		return _forumPostLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _forumPostLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _forumPostLocalService.dynamicQueryCount(dynamicQuery);
	}

	public net.appuntivari.forum.model.ForumPost fetchForumPost(long id_post)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.fetchForumPost(id_post);
	}

	/**
	* Returns the forum post with the primary key.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post
	* @throws PortalException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost getForumPost(long id_post)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPost(id_post);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the forum posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPosts(start, end);
	}

	/**
	* Returns the number of forum posts.
	*
	* @return the number of forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int getForumPostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPostsCount();
	}

	/**
	* Updates the forum post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @return the forum post that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost updateForumPost(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.updateForumPost(forumPost);
	}

	/**
	* Updates the forum post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @param merge whether to merge the forum post with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the forum post that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost updateForumPost(
		net.appuntivari.forum.model.ForumPost forumPost, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.updateForumPost(forumPost, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _forumPostLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_forumPostLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _forumPostLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public net.appuntivari.forum.model.ForumPost getNewForumPost() {
		return _forumPostLocalService.getNewForumPost();
	}

	public net.appuntivari.forum.model.ForumPost createForumPostAdHoc(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.createForumPostAdHoc(forumPost);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPostsByTimestamp(timestamp);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPostsByUserId(user_id);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByUserIdPostParent(
		long user_id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPostsByUserIdPostParent(user_id_post_parent);
	}

	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByIdCategory(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _forumPostLocalService.getForumPostsByIdCategory(id_category);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ForumPostLocalService getWrappedForumPostLocalService() {
		return _forumPostLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedForumPostLocalService(
		ForumPostLocalService forumPostLocalService) {
		_forumPostLocalService = forumPostLocalService;
	}

	public ForumPostLocalService getWrappedService() {
		return _forumPostLocalService;
	}

	public void setWrappedService(ForumPostLocalService forumPostLocalService) {
		_forumPostLocalService = forumPostLocalService;
	}

	private ForumPostLocalService _forumPostLocalService;
}