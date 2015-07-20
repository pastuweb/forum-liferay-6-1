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

import com.liferay.portal.service.persistence.BasePersistence;

import net.appuntivari.forum.model.ForumUser;

/**
 * The persistence interface for the forum user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumUserPersistenceImpl
 * @see ForumUserUtil
 * @generated
 */
public interface ForumUserPersistence extends BasePersistence<ForumUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ForumUserUtil} to access the forum user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the forum user in the entity cache if it is enabled.
	*
	* @param forumUser the forum user
	*/
	public void cacheResult(net.appuntivari.forum.model.ForumUser forumUser);

	/**
	* Caches the forum users in the entity cache if it is enabled.
	*
	* @param forumUsers the forum users
	*/
	public void cacheResult(
		java.util.List<net.appuntivari.forum.model.ForumUser> forumUsers);

	/**
	* Creates a new forum user with the primary key. Does not add the forum user to the database.
	*
	* @param id_forum_user the primary key for the new forum user
	* @return the new forum user
	*/
	public net.appuntivari.forum.model.ForumUser create(long id_forum_user);

	/**
	* Removes the forum user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user that was removed
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser remove(long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	public net.appuntivari.forum.model.ForumUser updateImpl(
		net.appuntivari.forum.model.ForumUser forumUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum user with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumUserException} if it could not be found.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByPrimaryKey(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the forum user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_forum_user the primary key of the forum user
	* @return the forum user, or <code>null</code> if a forum user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByPrimaryKey(
		long id_forum_user)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the forum users where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForum(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForum(
		long id_forum, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForum(
		long id_forum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser[] findByIdForum_PrevAndNext(
		long id_forum_user, long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns all the forum users where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByUserId(
		long user_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByUserId(
		long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByUserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the first forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByUserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByUserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the last forum user in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByUserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser[] findByUserId_PrevAndNext(
		long id_forum_user, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns all the forum users where status = &#63;.
	*
	* @param status the status
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the first forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user
	* @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the last forum user in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser[] findByStatus_PrevAndNext(
		long id_forum_user, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns all the forum users where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumStatus(
		long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser findByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the first forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser findByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns the last forum user in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumUser fetchByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser[] findByIdForumStatus_PrevAndNext(
		long id_forum_user, long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @return the matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumUserIdStatus(
		long id_forum, long user_id, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumUserIdStatus(
		long id_forum, long user_id, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findByIdForumUserIdStatus(
		long id_forum, long user_id, java.lang.String status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser findByIdForumUserIdStatus_First(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

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
	public net.appuntivari.forum.model.ForumUser fetchByIdForumUserIdStatus_First(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser findByIdForumUserIdStatus_Last(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

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
	public net.appuntivari.forum.model.ForumUser fetchByIdForumUserIdStatus_Last(
		long id_forum, long user_id, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumUser[] findByIdForumUserIdStatus_PrevAndNext(
		long id_forum_user, long id_forum, long user_id,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumUserException;

	/**
	* Returns all the forum users.
	*
	* @return the forum users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum users where id_forum = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum users where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum users where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum users where id_forum = &#63; and status = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdForumStatus(long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdForumUserIdStatus(long id_forum, long user_id,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum users where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum users where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum users where status = &#63;.
	*
	* @param status the status
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum users where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdForumStatus(long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum users where id_forum = &#63; and user_id = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param user_id the user_id
	* @param status the status
	* @return the number of matching forum users
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdForumUserIdStatus(long id_forum, long user_id,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum users.
	*
	* @return the number of forum users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}