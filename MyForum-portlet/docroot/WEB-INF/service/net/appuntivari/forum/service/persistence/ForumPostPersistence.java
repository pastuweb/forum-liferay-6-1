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

import net.appuntivari.forum.model.ForumPost;

/**
 * The persistence interface for the forum post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPostPersistenceImpl
 * @see ForumPostUtil
 * @generated
 */
public interface ForumPostPersistence extends BasePersistence<ForumPost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ForumPostUtil} to access the forum post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the forum post in the entity cache if it is enabled.
	*
	* @param forumPost the forum post
	*/
	public void cacheResult(net.appuntivari.forum.model.ForumPost forumPost);

	/**
	* Caches the forum posts in the entity cache if it is enabled.
	*
	* @param forumPosts the forum posts
	*/
	public void cacheResult(
		java.util.List<net.appuntivari.forum.model.ForumPost> forumPosts);

	/**
	* Creates a new forum post with the primary key. Does not add the forum post to the database.
	*
	* @param id_post the primary key for the new forum post
	* @return the new forum post
	*/
	public net.appuntivari.forum.model.ForumPost create(long id_post);

	/**
	* Removes the forum post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post that was removed
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost remove(long id_post)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	public net.appuntivari.forum.model.ForumPost updateImpl(
		net.appuntivari.forum.model.ForumPost forumPost, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum post with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumPostException} if it could not be found.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByPrimaryKey(long id_post)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the forum post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_post the primary key of the forum post
	* @return the forum post, or <code>null</code> if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByPrimaryKey(long id_post)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the forum posts where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum posts where timestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timestamp the timestamp
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByTimestamp(
		java.util.Date timestamp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts where timestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timestamp the timestamp
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByTimestamp(
		java.util.Date timestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum post in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the first forum post in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum post in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the last forum post in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum posts before and after the current forum post in the ordered set where timestamp = &#63;.
	*
	* @param id_post the primary key of the current forum post
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost[] findByTimestamp_PrevAndNext(
		long id_post, java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns all the forum posts where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByUserId(
		long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum posts where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByUserId(
		long user_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByUserId(
		long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum post in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByUserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the first forum post in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByUserId_First(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum post in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByUserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the last forum post in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByUserId_Last(
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum posts before and after the current forum post in the ordered set where user_id = &#63;.
	*
	* @param id_post the primary key of the current forum post
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost[] findByUserId_PrevAndNext(
		long id_post, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns all the forum posts where user_id_post_parent = &#63;.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @return the matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByUserIdPostParent(
		long user_id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum posts where user_id_post_parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_post_parent the user_id_post_parent
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByUserIdPostParent(
		long user_id_post_parent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts where user_id_post_parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_post_parent the user_id_post_parent
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByUserIdPostParent(
		long user_id_post_parent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum post in the ordered set where user_id_post_parent = &#63;.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByUserIdPostParent_First(
		long user_id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the first forum post in the ordered set where user_id_post_parent = &#63;.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByUserIdPostParent_First(
		long user_id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum post in the ordered set where user_id_post_parent = &#63;.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByUserIdPostParent_Last(
		long user_id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the last forum post in the ordered set where user_id_post_parent = &#63;.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByUserIdPostParent_Last(
		long user_id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum posts before and after the current forum post in the ordered set where user_id_post_parent = &#63;.
	*
	* @param id_post the primary key of the current forum post
	* @param user_id_post_parent the user_id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost[] findByUserIdPostParent_PrevAndNext(
		long id_post, long user_id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns all the forum posts where id_category = &#63;.
	*
	* @param id_category the id_category
	* @return the matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdCategory(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum posts where id_category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_category the id_category
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdCategory(
		long id_category, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts where id_category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_category the id_category
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdCategory(
		long id_category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum post in the ordered set where id_category = &#63;.
	*
	* @param id_category the id_category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByIdCategory_First(
		long id_category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the first forum post in the ordered set where id_category = &#63;.
	*
	* @param id_category the id_category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByIdCategory_First(
		long id_category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum post in the ordered set where id_category = &#63;.
	*
	* @param id_category the id_category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByIdCategory_Last(
		long id_category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the last forum post in the ordered set where id_category = &#63;.
	*
	* @param id_category the id_category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByIdCategory_Last(
		long id_category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum posts before and after the current forum post in the ordered set where id_category = &#63;.
	*
	* @param id_post the primary key of the current forum post
	* @param id_category the id_category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost[] findByIdCategory_PrevAndNext(
		long id_post, long id_category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns all the forum posts where id_category = &#63; and user_id = &#63;.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @return the matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdCategoryUserId(
		long id_category, long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum posts where id_category = &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdCategoryUserId(
		long id_category, long user_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts where id_category = &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdCategoryUserId(
		long id_category, long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum post in the ordered set where id_category = &#63; and user_id = &#63;.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByIdCategoryUserId_First(
		long id_category, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the first forum post in the ordered set where id_category = &#63; and user_id = &#63;.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByIdCategoryUserId_First(
		long id_category, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum post in the ordered set where id_category = &#63; and user_id = &#63;.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByIdCategoryUserId_Last(
		long id_category, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the last forum post in the ordered set where id_category = &#63; and user_id = &#63;.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByIdCategoryUserId_Last(
		long id_category, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum posts before and after the current forum post in the ordered set where id_category = &#63; and user_id = &#63;.
	*
	* @param id_post the primary key of the current forum post
	* @param id_category the id_category
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost[] findByIdCategoryUserId_PrevAndNext(
		long id_post, long id_category, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns all the forum posts where id_post_parent = &#63;.
	*
	* @param id_post_parent the id_post_parent
	* @return the matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdPostParent(
		long id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum posts where id_post_parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_post_parent the id_post_parent
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @return the range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdPostParent(
		long id_post_parent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts where id_post_parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_post_parent the id_post_parent
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findByIdPostParent(
		long id_post_parent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum post in the ordered set where id_post_parent = &#63;.
	*
	* @param id_post_parent the id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByIdPostParent_First(
		long id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the first forum post in the ordered set where id_post_parent = &#63;.
	*
	* @param id_post_parent the id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByIdPostParent_First(
		long id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum post in the ordered set where id_post_parent = &#63;.
	*
	* @param id_post_parent the id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost findByIdPostParent_Last(
		long id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns the last forum post in the ordered set where id_post_parent = &#63;.
	*
	* @param id_post_parent the id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost fetchByIdPostParent_Last(
		long id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum posts before and after the current forum post in the ordered set where id_post_parent = &#63;.
	*
	* @param id_post the primary key of the current forum post
	* @param id_post_parent the id_post_parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum post
	* @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumPost[] findByIdPostParent_PrevAndNext(
		long id_post, long id_post_parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumPostException;

	/**
	* Returns all the forum posts.
	*
	* @return the forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumPost> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of forum posts
	* @param end the upper bound of the range of forum posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of forum posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts where timestamp = &#63; from the database.
	*
	* @param timestamp the timestamp
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts where user_id_post_parent = &#63; from the database.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdPostParent(long user_id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts where id_category = &#63; from the database.
	*
	* @param id_category the id_category
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdCategory(long id_category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts where id_category = &#63; and user_id = &#63; from the database.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdCategoryUserId(long id_category, long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts where id_post_parent = &#63; from the database.
	*
	* @param id_post_parent the id_post_parent
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdPostParent(long id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the number of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts where user_id_post_parent = &#63;.
	*
	* @param user_id_post_parent the user_id_post_parent
	* @return the number of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdPostParent(long user_id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts where id_category = &#63;.
	*
	* @param id_category the id_category
	* @return the number of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdCategory(long id_category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts where id_category = &#63; and user_id = &#63;.
	*
	* @param id_category the id_category
	* @param user_id the user_id
	* @return the number of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdCategoryUserId(long id_category, long user_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts where id_post_parent = &#63;.
	*
	* @param id_post_parent the id_post_parent
	* @return the number of matching forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdPostParent(long id_post_parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum posts.
	*
	* @return the number of forum posts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}