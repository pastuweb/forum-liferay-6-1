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

package net.appuntivari.forum.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.appuntivari.forum.model.ForumCategory;

import java.util.List;

/**
 * The persistence utility for the forum category service. This utility wraps {@link ForumCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumCategoryPersistence
 * @see ForumCategoryPersistenceImpl
 * @generated
 */
public class ForumCategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ForumCategory forumCategory) {
		getPersistence().clearCache(forumCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ForumCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ForumCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ForumCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ForumCategory update(ForumCategory forumCategory,
		boolean merge) throws SystemException {
		return getPersistence().update(forumCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ForumCategory update(ForumCategory forumCategory,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(forumCategory, merge, serviceContext);
	}

	/**
	* Caches the forum category in the entity cache if it is enabled.
	*
	* @param forumCategory the forum category
	*/
	public static void cacheResult(
		net.appuntivari.forum.model.ForumCategory forumCategory) {
		getPersistence().cacheResult(forumCategory);
	}

	/**
	* Caches the forum categories in the entity cache if it is enabled.
	*
	* @param forumCategories the forum categories
	*/
	public static void cacheResult(
		java.util.List<net.appuntivari.forum.model.ForumCategory> forumCategories) {
		getPersistence().cacheResult(forumCategories);
	}

	/**
	* Creates a new forum category with the primary key. Does not add the forum category to the database.
	*
	* @param id_category the primary key for the new forum category
	* @return the new forum category
	*/
	public static net.appuntivari.forum.model.ForumCategory create(
		long id_category) {
		return getPersistence().create(id_category);
	}

	/**
	* Removes the forum category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_category the primary key of the forum category
	* @return the forum category that was removed
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory remove(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence().remove(id_category);
	}

	public static net.appuntivari.forum.model.ForumCategory updateImpl(
		net.appuntivari.forum.model.ForumCategory forumCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(forumCategory, merge);
	}

	/**
	* Returns the forum category with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumCategoryException} if it could not be found.
	*
	* @param id_category the primary key of the forum category
	* @return the forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByPrimaryKey(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence().findByPrimaryKey(id_category);
	}

	/**
	* Returns the forum category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_category the primary key of the forum category
	* @return the forum category, or <code>null</code> if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByPrimaryKey(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_category);
	}

	/**
	* Returns all the forum categories where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTimestamp(timestamp);
	}

	/**
	* Returns a range of all the forum categories where timestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timestamp the timestamp
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByTimestamp(
		java.util.Date timestamp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTimestamp(timestamp, start, end);
	}

	/**
	* Returns an ordered range of all the forum categories where timestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timestamp the timestamp
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByTimestamp(
		java.util.Date timestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTimestamp(timestamp, start, end, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByTimestamp_First(timestamp, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimestamp_First(timestamp, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByTimestamp_Last(timestamp, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimestamp_Last(timestamp, orderByComparator);
	}

	/**
	* Returns the forum categories before and after the current forum category in the ordered set where timestamp = &#63;.
	*
	* @param id_category the primary key of the current forum category
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory[] findByTimestamp_PrevAndNext(
		long id_category, java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByTimestamp_PrevAndNext(id_category, timestamp,
			orderByComparator);
	}

	/**
	* Returns all the forum categories where title = &#63;.
	*
	* @param title the title
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the forum categories where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the forum categories where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the forum categories before and after the current forum category in the ordered set where title = &#63;.
	*
	* @param id_category the primary key of the current forum category
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory[] findByTitle_PrevAndNext(
		long id_category, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByTitle_PrevAndNext(id_category, title,
			orderByComparator);
	}

	/**
	* Returns all the forum categories where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForum(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForum(id_forum);
	}

	/**
	* Returns a range of all the forum categories where id_forum = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForum(
		long id_forum, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForum(id_forum, start, end);
	}

	/**
	* Returns an ordered range of all the forum categories where id_forum = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForum(
		long id_forum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForum(id_forum, start, end, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence().findByIdForum_First(id_forum, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdForum_First(id_forum, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence().findByIdForum_Last(id_forum, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdForum_Last(id_forum, orderByComparator);
	}

	/**
	* Returns the forum categories before and after the current forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_category the primary key of the current forum category
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory[] findByIdForum_PrevAndNext(
		long id_category, long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByIdForum_PrevAndNext(id_category, id_forum,
			orderByComparator);
	}

	/**
	* Returns all the forum categories where create_user_id = &#63;.
	*
	* @param create_user_id the create_user_id
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByCreateUserId(
		long create_user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreateUserId(create_user_id);
	}

	/**
	* Returns a range of all the forum categories where create_user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param create_user_id the create_user_id
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByCreateUserId(
		long create_user_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreateUserId(create_user_id, start, end);
	}

	/**
	* Returns an ordered range of all the forum categories where create_user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param create_user_id the create_user_id
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByCreateUserId(
		long create_user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreateUserId(create_user_id, start, end,
			orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where create_user_id = &#63;.
	*
	* @param create_user_id the create_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByCreateUserId_First(
		long create_user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByCreateUserId_First(create_user_id, orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where create_user_id = &#63;.
	*
	* @param create_user_id the create_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByCreateUserId_First(
		long create_user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreateUserId_First(create_user_id, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where create_user_id = &#63;.
	*
	* @param create_user_id the create_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByCreateUserId_Last(
		long create_user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByCreateUserId_Last(create_user_id, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where create_user_id = &#63;.
	*
	* @param create_user_id the create_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByCreateUserId_Last(
		long create_user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreateUserId_Last(create_user_id, orderByComparator);
	}

	/**
	* Returns the forum categories before and after the current forum category in the ordered set where create_user_id = &#63;.
	*
	* @param id_category the primary key of the current forum category
	* @param create_user_id the create_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory[] findByCreateUserId_PrevAndNext(
		long id_category, long create_user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByCreateUserId_PrevAndNext(id_category, create_user_id,
			orderByComparator);
	}

	/**
	* Returns all the forum categories where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForumStatus(
		long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForumStatus(id_forum, status);
	}

	/**
	* Returns a range of all the forum categories where id_forum = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForumStatus(id_forum, status, start, end);
	}

	/**
	* Returns an ordered range of all the forum categories where id_forum = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForumStatus(id_forum, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByIdForumStatus_First(id_forum, status,
			orderByComparator);
	}

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIdForumStatus_First(id_forum, status,
			orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory findByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByIdForumStatus_Last(id_forum, status, orderByComparator);
	}

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory fetchByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIdForumStatus_Last(id_forum, status,
			orderByComparator);
	}

	/**
	* Returns the forum categories before and after the current forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_category the primary key of the current forum category
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumCategory[] findByIdForumStatus_PrevAndNext(
		long id_category, long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException {
		return getPersistence()
				   .findByIdForumStatus_PrevAndNext(id_category, id_forum,
			status, orderByComparator);
	}

	/**
	* Returns all the forum categories.
	*
	* @return the forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the forum categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the forum categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the forum categories where timestamp = &#63; from the database.
	*
	* @param timestamp the timestamp
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTimestamp(timestamp);
	}

	/**
	* Removes all the forum categories where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Removes all the forum categories where id_forum = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIdForum(id_forum);
	}

	/**
	* Removes all the forum categories where create_user_id = &#63; from the database.
	*
	* @param create_user_id the create_user_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreateUserId(long create_user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreateUserId(create_user_id);
	}

	/**
	* Removes all the forum categories where id_forum = &#63; and status = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIdForumStatus(long id_forum,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIdForumStatus(id_forum, status);
	}

	/**
	* Removes all the forum categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of forum categories where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTimestamp(timestamp);
	}

	/**
	* Returns the number of forum categories where title = &#63;.
	*
	* @param title the title
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns the number of forum categories where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdForum(id_forum);
	}

	/**
	* Returns the number of forum categories where create_user_id = &#63;.
	*
	* @param create_user_id the create_user_id
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreateUserId(long create_user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreateUserId(create_user_id);
	}

	/**
	* Returns the number of forum categories where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdForumStatus(long id_forum,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdForumStatus(id_forum, status);
	}

	/**
	* Returns the number of forum categories.
	*
	* @return the number of forum categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ForumCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ForumCategoryPersistence)PortletBeanLocatorUtil.locate(net.appuntivari.forum.service.ClpSerializer.getServletContextName(),
					ForumCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ForumCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ForumCategoryPersistence persistence) {
	}

	private static ForumCategoryPersistence _persistence;
}