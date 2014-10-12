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
 * The utility for the forum post local service. This utility wraps {@link net.appuntivari.forum.service.impl.ForumPostLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPostLocalService
 * @see net.appuntivari.forum.service.base.ForumPostLocalServiceBaseImpl
 * @see net.appuntivari.forum.service.impl.ForumPostLocalServiceImpl
 * @generated
 */
public class ForumPostLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.appuntivari.forum.service.impl.ForumPostLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the forum post to the database. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @return the forum post that was added
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumPost addForumPost(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addForumPost(forumPost);
	}

	/**
	* Creates a new forum post with the primary key. Does not add the forum post to the database.
	*
	* @param id_post the primary key for the new forum post
	* @return the new forum post
	*/
	public static net.appuntivari.forum.model.ForumPost createForumPost(
		long id_post) {
		return getService().createForumPost(id_post);
	}

	/**
	* Deletes the forum post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post that was removed
	* @throws PortalException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumPost deleteForumPost(
		long id_post)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteForumPost(id_post);
	}

	/**
	* Deletes the forum post from the database. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @return the forum post that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumPost deleteForumPost(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteForumPost(forumPost);
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

	public static net.appuntivari.forum.model.ForumPost fetchForumPost(
		long id_post)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchForumPost(id_post);
	}

	/**
	* Returns the forum post with the primary key.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post
	* @throws PortalException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumPost getForumPost(
		long id_post)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPost(id_post);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPosts(start, end);
	}

	/**
	* Returns the number of forum posts.
	*
	* @return the number of forum posts
	* @throws SystemException if a system exception occurred
	*/
	public static int getForumPostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPostsCount();
	}

	/**
	* Updates the forum post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @return the forum post that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumPost updateForumPost(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateForumPost(forumPost);
	}

	/**
	* Updates the forum post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param forumPost the forum post
	* @param merge whether to merge the forum post with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the forum post that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumPost updateForumPost(
		net.appuntivari.forum.model.ForumPost forumPost, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateForumPost(forumPost, merge);
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

	public static net.appuntivari.forum.model.ForumPost getNewForumPost() {
		return getService().getNewForumPost();
	}

	public static net.appuntivari.forum.model.ForumPost createForumPostAdHoc(
		net.appuntivari.forum.model.ForumPost forumPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createForumPostAdHoc(forumPost);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPostsByTimestamp(timestamp);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPostsByUserId(user_id);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByUserIdPostParent(
		long user_id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPostsByUserIdPostParent(user_id_post_parent);
	}

	public static java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostsByIdCategory(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForumPostsByIdCategory(id_category);
	}

	public static void clearService() {
		_service = null;
	}

	public static ForumPostLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ForumPostLocalService.class.getName());

			if (invokableLocalService instanceof ForumPostLocalService) {
				_service = (ForumPostLocalService)invokableLocalService;
			}
			else {
				_service = new ForumPostLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ForumPostLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ForumPostLocalService service) {
	}

	private static ForumPostLocalService _service;
}