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

import net.appuntivari.forum.model.Forum;

import java.util.List;

/**
 * The persistence utility for the forum service. This utility wraps {@link ForumPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPersistence
 * @see ForumPersistenceImpl
 * @generated
 */
public class ForumUtil {
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
	public static void clearCache(Forum forum) {
		getPersistence().clearCache(forum);
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
	public static List<Forum> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Forum> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Forum> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Forum update(Forum forum, boolean merge)
		throws SystemException {
		return getPersistence().update(forum, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Forum update(Forum forum, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(forum, merge, serviceContext);
	}

	/**
	* Caches the forum in the entity cache if it is enabled.
	*
	* @param forum the forum
	*/
	public static void cacheResult(net.appuntivari.forum.model.Forum forum) {
		getPersistence().cacheResult(forum);
	}

	/**
	* Caches the forums in the entity cache if it is enabled.
	*
	* @param forums the forums
	*/
	public static void cacheResult(
		java.util.List<net.appuntivari.forum.model.Forum> forums) {
		getPersistence().cacheResult(forums);
	}

	/**
	* Creates a new forum with the primary key. Does not add the forum to the database.
	*
	* @param id_forum the primary key for the new forum
	* @return the new forum
	*/
	public static net.appuntivari.forum.model.Forum create(long id_forum) {
		return getPersistence().create(id_forum);
	}

	/**
	* Removes the forum with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_forum the primary key of the forum
	* @return the forum that was removed
	* @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum remove(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence().remove(id_forum);
	}

	public static net.appuntivari.forum.model.Forum updateImpl(
		net.appuntivari.forum.model.Forum forum, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(forum, merge);
	}

	/**
	* Returns the forum with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumException} if it could not be found.
	*
	* @param id_forum the primary key of the forum
	* @return the forum
	* @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByPrimaryKey(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence().findByPrimaryKey(id_forum);
	}

	/**
	* Returns the forum with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_forum the primary key of the forum
	* @return the forum, or <code>null</code> if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByPrimaryKey(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_forum);
	}

	/**
	* Returns all the forums where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTimestamp(timestamp);
	}

	/**
	* Returns a range of all the forums where timestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timestamp the timestamp
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @return the range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByTimestamp(
		java.util.Date timestamp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTimestamp(timestamp, start, end);
	}

	/**
	* Returns an ordered range of all the forums where timestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timestamp the timestamp
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByTimestamp(
		java.util.Date timestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTimestamp(timestamp, start, end, orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByTimestamp_First(timestamp, orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimestamp_First(timestamp, orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByTimestamp_Last(timestamp, orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimestamp_Last(timestamp, orderByComparator);
	}

	/**
	* Returns the forums before and after the current forum in the ordered set where timestamp = &#63;.
	*
	* @param id_forum the primary key of the current forum
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum
	* @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum[] findByTimestamp_PrevAndNext(
		long id_forum, java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByTimestamp_PrevAndNext(id_forum, timestamp,
			orderByComparator);
	}

	/**
	* Returns all the forums where company_id = &#63;.
	*
	* @param company_id the company_id
	* @return the matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByCompanyId(
		long company_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(company_id);
	}

	/**
	* Returns a range of all the forums where company_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param company_id the company_id
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @return the range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByCompanyId(
		long company_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(company_id, start, end);
	}

	/**
	* Returns an ordered range of all the forums where company_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param company_id the company_id
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByCompanyId(
		long company_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(company_id, start, end, orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where company_id = &#63;.
	*
	* @param company_id the company_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByCompanyId_First(
		long company_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByCompanyId_First(company_id, orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where company_id = &#63;.
	*
	* @param company_id the company_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByCompanyId_First(
		long company_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(company_id, orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where company_id = &#63;.
	*
	* @param company_id the company_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByCompanyId_Last(
		long company_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByCompanyId_Last(company_id, orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where company_id = &#63;.
	*
	* @param company_id the company_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByCompanyId_Last(
		long company_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(company_id, orderByComparator);
	}

	/**
	* Returns the forums before and after the current forum in the ordered set where company_id = &#63;.
	*
	* @param id_forum the primary key of the current forum
	* @param company_id the company_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum
	* @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum[] findByCompanyId_PrevAndNext(
		long id_forum, long company_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(id_forum, company_id,
			orderByComparator);
	}

	/**
	* Returns all the forums where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @return the matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByUserIdCreator(
		long user_id_creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdCreator(user_id_creator);
	}

	/**
	* Returns a range of all the forums where user_id_creator = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_creator the user_id_creator
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @return the range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByUserIdCreator(
		long user_id_creator, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdCreator(user_id_creator, start, end);
	}

	/**
	* Returns an ordered range of all the forums where user_id_creator = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_creator the user_id_creator
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByUserIdCreator(
		long user_id_creator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdCreator(user_id_creator, start, end,
			orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByUserIdCreator_First(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByUserIdCreator_First(user_id_creator, orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByUserIdCreator_First(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdCreator_First(user_id_creator,
			orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByUserIdCreator_Last(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByUserIdCreator_Last(user_id_creator, orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByUserIdCreator_Last(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdCreator_Last(user_id_creator, orderByComparator);
	}

	/**
	* Returns the forums before and after the current forum in the ordered set where user_id_creator = &#63;.
	*
	* @param id_forum the primary key of the current forum
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum
	* @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum[] findByUserIdCreator_PrevAndNext(
		long id_forum, long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByUserIdCreator_PrevAndNext(id_forum, user_id_creator,
			orderByComparator);
	}

	/**
	* Returns all the forums where user_id_creator = &#63; and status = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @return the matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByUserIdCreatorStatus(
		long user_id_creator, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdCreatorStatus(user_id_creator, status);
	}

	/**
	* Returns a range of all the forums where user_id_creator = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @return the range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByUserIdCreatorStatus(
		long user_id_creator, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdCreatorStatus(user_id_creator, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the forums where user_id_creator = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findByUserIdCreatorStatus(
		long user_id_creator, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdCreatorStatus(user_id_creator, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where user_id_creator = &#63; and status = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByUserIdCreatorStatus_First(
		long user_id_creator, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByUserIdCreatorStatus_First(user_id_creator, status,
			orderByComparator);
	}

	/**
	* Returns the first forum in the ordered set where user_id_creator = &#63; and status = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByUserIdCreatorStatus_First(
		long user_id_creator, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdCreatorStatus_First(user_id_creator, status,
			orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where user_id_creator = &#63; and status = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum
	* @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum findByUserIdCreatorStatus_Last(
		long user_id_creator, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByUserIdCreatorStatus_Last(user_id_creator, status,
			orderByComparator);
	}

	/**
	* Returns the last forum in the ordered set where user_id_creator = &#63; and status = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum, or <code>null</code> if a matching forum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum fetchByUserIdCreatorStatus_Last(
		long user_id_creator, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdCreatorStatus_Last(user_id_creator, status,
			orderByComparator);
	}

	/**
	* Returns the forums before and after the current forum in the ordered set where user_id_creator = &#63; and status = &#63;.
	*
	* @param id_forum the primary key of the current forum
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum
	* @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.Forum[] findByUserIdCreatorStatus_PrevAndNext(
		long id_forum, long user_id_creator, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumException {
		return getPersistence()
				   .findByUserIdCreatorStatus_PrevAndNext(id_forum,
			user_id_creator, status, orderByComparator);
	}

	/**
	* Returns all the forums.
	*
	* @return the forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<net.appuntivari.forum.model.Forum> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the forums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forums
	* @param end the upper bound of the range of forums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of forums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.Forum> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the forums where timestamp = &#63; from the database.
	*
	* @param timestamp the timestamp
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTimestamp(timestamp);
	}

	/**
	* Removes all the forums where company_id = &#63; from the database.
	*
	* @param company_id the company_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long company_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(company_id);
	}

	/**
	* Removes all the forums where user_id_creator = &#63; from the database.
	*
	* @param user_id_creator the user_id_creator
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdCreator(long user_id_creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdCreator(user_id_creator);
	}

	/**
	* Removes all the forums where user_id_creator = &#63; and status = &#63; from the database.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdCreatorStatus(long user_id_creator,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdCreatorStatus(user_id_creator, status);
	}

	/**
	* Removes all the forums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of forums where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the number of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTimestamp(timestamp);
	}

	/**
	* Returns the number of forums where company_id = &#63;.
	*
	* @param company_id the company_id
	* @return the number of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long company_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(company_id);
	}

	/**
	* Returns the number of forums where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @return the number of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdCreator(long user_id_creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdCreator(user_id_creator);
	}

	/**
	* Returns the number of forums where user_id_creator = &#63; and status = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param status the status
	* @return the number of matching forums
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdCreatorStatus(long user_id_creator,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdCreatorStatus(user_id_creator, status);
	}

	/**
	* Returns the number of forums.
	*
	* @return the number of forums
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ForumPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ForumPersistence)PortletBeanLocatorUtil.locate(net.appuntivari.forum.service.ClpSerializer.getServletContextName(),
					ForumPersistence.class.getName());

			ReferenceRegistry.registerReference(ForumUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ForumPersistence persistence) {
	}

	private static ForumPersistence _persistence;
}