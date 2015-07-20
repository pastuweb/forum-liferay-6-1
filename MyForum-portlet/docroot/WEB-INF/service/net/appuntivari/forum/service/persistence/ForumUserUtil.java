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

import net.appuntivari.forum.model.ForumUser;

import java.util.List;

/**
 * The persistence utility for the forum user service. This utility wraps {@link ForumUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumUserPersistence
 * @see ForumUserPersistenceImpl
 * @generated
 */
public class ForumUserUtil {
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
	public static void clearCache(ForumUser forumUser) {
		getPersistence().clearCache(forumUser);
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
	public static List<ForumUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ForumUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ForumUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ForumUser update(ForumUser forumUser, boolean merge)
		throws SystemException {
		return getPersistence().update(forumUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ForumUser update(ForumUser forumUser, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(forumUser, merge, serviceContext);
	}

	/**
	* Caches the forum user in the entity cache if it is enabled.
	*
	* @param forumUser the forum user
	*/
	public static void cacheResult(
		net.appuntivari.forum.model.ForumUser forumUser) {
		getPersistence().cacheResult(forumUser);
	}

	/**
	* Caches the forum users in the entity cache if it is enabled.
	*
	* @param forumUsers the forum users
	*/
	public static void cacheResult(
		java.util.List<net.appuntivari.forum.model.ForumUser> forumUsers) {
		getPersistence().cacheResult(forumUsers);
	}

	/**
	* Creates a new forum user with the primary key. Does not add the forum user to the database.
	*
	* @param id_forum_user the primary key for the new forum user
	* @return the new forum user
	*/
	public static net.appuntivari.forum.model.ForumUser create(
		long id_forum_user) {
		return getPersistence().create(id_forum_user);
	}

	/**
	* Removes the forum user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user that was removed
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser remove(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().remove(id_forum_user);
	}

	public static net.appuntivari.forum.model.ForumUser updateImpl(
		net.appuntivari.forum.model.ForumUser forumUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(forumUser, merge);
	}

	/**
	* Returns the forum user with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumUserException} if it could not be found.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByPrimaryKey(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByPrimaryKey(id_forum_user);
	}

	/**
	* Returns the forum user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user, or <code>null</code> if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByPrimaryKey(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_forum_user);
	}

	/**
	* Returns all the forum users where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForum(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForum(id_forum);
	}

	/**
	* Returns a range of all the forum users where id_forum = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @return the range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForum(
		long id_forum, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForum(id_forum, start, end);
	}

	/**
	* Returns an ordered range of all the forum users where id_forum = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForum(
		long id_forum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForum(id_forum, start, end, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByIdForum_First(id_forum, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdForum_First(id_forum, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByIdForum_Last(id_forum, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdForum_Last(id_forum, orderByComparator);
	}

	/**
	* Returns the forum users before and after the current forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum_user the primary key of the current forum user
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser[] findByIdForum_PrevAndNext(
		long id_forum_user, long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForum_PrevAndNext(id_forum_user, id_forum,
			orderByComparator);
	}

	/**
	* Returns all the forum users where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(user_id);
	}

	/**
	* Returns a range of all the forum users where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @return the range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByUserId(
		long user_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(user_id, start, end);
	}

	/**
	* Returns an ordered range of all the forum users where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByUserId(
		long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(user_id, start, end, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByUserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByUserId_First(user_id, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByUserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(user_id, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByUserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByUserId_Last(user_id, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByUserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(user_id, orderByComparator);
	}

	/**
	* Returns the forum users before and after the current forum user in the ordered set where user_id = &#63;.
	*
	* @param id_forum_user the primary key of the current forum user
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser[] findByUserId_PrevAndNext(
		long id_forum_user, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByUserId_PrevAndNext(id_forum_user, user_id,
			orderByComparator);
	}

	/**
	* Returns all the forum users where status = &#63;.
	*
	* @param status the status
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the forum users where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @return the range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the forum users where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the forum users before and after the current forum user in the ordered set where status = &#63;.
	*
	* @param id_forum_user the primary key of the current forum user
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser[] findByStatus_PrevAndNext(
		long id_forum_user, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByStatus_PrevAndNext(id_forum_user, status,
			orderByComparator);
	}

	/**
	* Returns all the forum users where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumStatus(
		long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForumStatus(id_forum, status);
	}

	/**
	* Returns a range of all the forum users where id_forum = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @return the range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIdForumStatus(id_forum, status, start, end);
	}

	/**
	* Returns an ordered range of all the forum users where id_forum = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForumStatus(id_forum, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForumStatus_First(id_forum, status,
			orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIdForumStatus_First(id_forum, status,
			orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForumStatus_Last(id_forum, status, orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIdForumStatus_Last(id_forum, status,
			orderByComparator);
	}

	/**
	* Returns the forum users before and after the current forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum_user the primary key of the current forum user
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser[] findByIdForumStatus_PrevAndNext(
		long id_forum_user, long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForumStatus_PrevAndNext(id_forum_user, id_forum,
			status, orderByComparator);
	}

	/**
	* Returns all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumUserIdStatus(
		long id_forum, long user_id, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForumUserIdStatus(id_forum, user_id, status);
	}

	/**
	* Returns a range of all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @return the range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumUserIdStatus(
		long id_forum, long user_id, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForumUserIdStatus(id_forum, user_id, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumUserIdStatus(
		long id_forum, long user_id, java.lang.String status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIdForumUserIdStatus(id_forum, user_id, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByIdForumUserIdStatus_First(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForumUserIdStatus_First(id_forum, user_id, status,
			orderByComparator);
	}

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByIdForumUserIdStatus_First(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIdForumUserIdStatus_First(id_forum, user_id, status,
			orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser findByIdForumUserIdStatus_Last(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForumUserIdStatus_Last(id_forum, user_id, status,
			orderByComparator);
	}

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser fetchByIdForumUserIdStatus_Last(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIdForumUserIdStatus_Last(id_forum, user_id, status,
			orderByComparator);
	}

	/**
	* Returns the forum users before and after the current forum user in the ordered set where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum_user the primary key of the current forum user
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.appuntivari.forum.model.ForumUser[] findByIdForumUserIdStatus_PrevAndNext(
		long id_forum_user, long id_forum, long user_id,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException {
		return getPersistence()
				   .findByIdForumUserIdStatus_PrevAndNext(id_forum_user,
			id_forum, user_id, status, orderByComparator);
	}

	/**
	* Returns all the forum users.
	*
	* @return the forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the forum users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forum users
	* @param end the upper bound of the range of forum users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of forum users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.appuntivari.forum.model.ForumUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the forum users where id_forum = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIdForum(id_forum);
	}

	/**
	* Removes all the forum users where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(user_id);
	}

	/**
	* Removes all the forum users where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the forum users where id_forum = &#63; and status = &#63; from the database.
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
	* Removes all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIdForumUserIdStatus(long id_forum, long user_id,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIdForumUserIdStatus(id_forum, user_id, status);
	}

	/**
	* Removes all the forum users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of forum users where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdForum(id_forum);
	}

	/**
	* Returns the number of forum users where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(user_id);
	}

	/**
	* Returns the number of forum users where status = &#63;.
	*
	* @param status the status
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of forum users where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdForumStatus(long id_forum,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdForumStatus(id_forum, status);
	}

	/**
	* Returns the number of forum users where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdForumUserIdStatus(long id_forum, long user_id,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByIdForumUserIdStatus(id_forum, user_id, status);
	}

	/**
	* Returns the number of forum users.
	*
	* @return the number of forum users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ForumUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ForumUserPersistence)PortletBeanLocatorUtil.locate(net.appuntivari.forum.service.ClpSerializer.getServletContextName(),
					ForumUserPersistence.class.getName());

			ReferenceRegistry.registerReference(ForumUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ForumUserPersistence persistence) {
	}

	private static ForumUserPersistence _persistence;
}