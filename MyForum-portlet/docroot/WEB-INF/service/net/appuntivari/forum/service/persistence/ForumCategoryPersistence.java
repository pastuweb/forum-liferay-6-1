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

import net.appuntivari.forum.model.ForumCategory;

/**
 * The persistence interface for the forum category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumCategoryPersistenceImpl
 * @see ForumCategoryUtil
 * @generated
 */
public interface ForumCategoryPersistence extends BasePersistence<ForumCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ForumCategoryUtil} to access the forum category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the forum category in the entity cache if it is enabled.
	*
	* @param forumCategory the forum category
	*/
	public void cacheResult(
		net.appuntivari.forum.model.ForumCategory forumCategory);

	/**
	* Caches the forum categories in the entity cache if it is enabled.
	*
	* @param forumCategories the forum categories
	*/
	public void cacheResult(
		java.util.List<net.appuntivari.forum.model.ForumCategory> forumCategories);

	/**
	* Creates a new forum category with the primary key. Does not add the forum category to the database.
	*
	* @param id_category the primary key for the new forum category
	* @return the new forum category
	*/
	public net.appuntivari.forum.model.ForumCategory create(long id_category);

	/**
	* Removes the forum category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_category the primary key of the forum category
	* @return the forum category that was removed
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory remove(long id_category)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	public net.appuntivari.forum.model.ForumCategory updateImpl(
		net.appuntivari.forum.model.ForumCategory forumCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum category with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumCategoryException} if it could not be found.
	*
	* @param id_category the primary key of the forum category
	* @return the forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByPrimaryKey(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the forum category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_category the primary key of the forum category
	* @return the forum category, or <code>null</code> if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByPrimaryKey(
		long id_category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the forum categories where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByTimestamp(
		java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByTimestamp(
		java.util.Date timestamp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByTimestamp(
		java.util.Date timestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the first forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByTimestamp_First(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the last forum category in the ordered set where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByTimestamp_Last(
		java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumCategory[] findByTimestamp_PrevAndNext(
		long id_category, java.util.Date timestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns all the forum categories where title = &#63;.
	*
	* @param title the title
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the first forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the last forum category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumCategory[] findByTitle_PrevAndNext(
		long id_category, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns all the forum categories where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForum(
		long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForum(
		long id_forum, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForum(
		long id_forum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByIdForum_First(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByIdForum_Last(
		long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumCategory[] findByIdForum_PrevAndNext(
		long id_category, long id_forum,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns all the forum categories where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByUserIdCreator(
		long user_id_creator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forum categories where user_id_creator = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_creator the user_id_creator
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @return the range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByUserIdCreator(
		long user_id_creator, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forum categories where user_id_creator = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param user_id_creator the user_id_creator
	* @param start the lower bound of the range of forum categories
	* @param end the upper bound of the range of forum categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByUserIdCreator(
		long user_id_creator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first forum category in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByUserIdCreator_First(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the first forum category in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByUserIdCreator_First(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last forum category in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory findByUserIdCreator_Last(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the last forum category in the ordered set where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByUserIdCreator_Last(
		long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the forum categories before and after the current forum category in the ordered set where user_id_creator = &#63;.
	*
	* @param id_category the primary key of the current forum category
	* @param user_id_creator the user_id_creator
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next forum category
	* @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory[] findByUserIdCreator_PrevAndNext(
		long id_category, long user_id_creator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns all the forum categories where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForumStatus(
		long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findByIdForumStatus(
		long id_forum, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumCategory findByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the first forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByIdForumStatus_First(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumCategory findByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns the last forum category in the ordered set where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.appuntivari.forum.model.ForumCategory fetchByIdForumStatus_Last(
		long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public net.appuntivari.forum.model.ForumCategory[] findByIdForumStatus_PrevAndNext(
		long id_category, long id_forum, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.appuntivari.forum.NoSuchForumCategoryException;

	/**
	* Returns all the forum categories.
	*
	* @return the forum categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.appuntivari.forum.model.ForumCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum categories where timestamp = &#63; from the database.
	*
	* @param timestamp the timestamp
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum categories where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum categories where id_forum = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum categories where user_id_creator = &#63; from the database.
	*
	* @param user_id_creator the user_id_creator
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdCreator(long user_id_creator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum categories where id_forum = &#63; and status = &#63; from the database.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdForumStatus(long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forum categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum categories where timestamp = &#63;.
	*
	* @param timestamp the timestamp
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTimestamp(java.util.Date timestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum categories where title = &#63;.
	*
	* @param title the title
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum categories where id_forum = &#63;.
	*
	* @param id_forum the id_forum
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdForum(long id_forum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum categories where user_id_creator = &#63;.
	*
	* @param user_id_creator the user_id_creator
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdCreator(long user_id_creator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum categories where id_forum = &#63; and status = &#63;.
	*
	* @param id_forum the id_forum
	* @param status the status
	* @return the number of matching forum categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdForumStatus(long id_forum, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forum categories.
	*
	* @return the number of forum categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}