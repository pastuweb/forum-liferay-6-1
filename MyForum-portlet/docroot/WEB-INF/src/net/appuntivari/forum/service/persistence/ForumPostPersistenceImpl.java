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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.appuntivari.forum.NoSuchForumPostException;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.model.impl.ForumPostImpl;
import net.appuntivari.forum.model.impl.ForumPostModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the forum post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPostPersistence
 * @see ForumPostUtil
 * @generated
 */
public class ForumPostPersistenceImpl extends BasePersistenceImpl<ForumPost>
	implements ForumPostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ForumPostUtil} to access the forum post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ForumPostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMESTAMP =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimestamp",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimestamp",
			new String[] { Date.class.getName() },
			ForumPostModelImpl.TIMESTAMP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMESTAMP = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimestamp",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ForumPostModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPOSTPARENT =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdPostParent",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPOSTPARENT =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdPostParent", new String[] { Long.class.getName() },
			ForumPostModelImpl.USER_ID_POST_PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPOSTPARENT = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdPostParent", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDCATEGORY =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdCategory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDCATEGORY =
		new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdCategory",
			new String[] { Long.class.getName() },
			ForumPostModelImpl.ID_CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDCATEGORY = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdCategory",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, ForumPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the forum post in the entity cache if it is enabled.
	 *
	 * @param forumPost the forum post
	 */
	public void cacheResult(ForumPost forumPost) {
		EntityCacheUtil.putResult(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostImpl.class, forumPost.getPrimaryKey(), forumPost);

		forumPost.resetOriginalValues();
	}

	/**
	 * Caches the forum posts in the entity cache if it is enabled.
	 *
	 * @param forumPosts the forum posts
	 */
	public void cacheResult(List<ForumPost> forumPosts) {
		for (ForumPost forumPost : forumPosts) {
			if (EntityCacheUtil.getResult(
						ForumPostModelImpl.ENTITY_CACHE_ENABLED,
						ForumPostImpl.class, forumPost.getPrimaryKey()) == null) {
				cacheResult(forumPost);
			}
			else {
				forumPost.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all forum posts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ForumPostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ForumPostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the forum post.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ForumPost forumPost) {
		EntityCacheUtil.removeResult(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostImpl.class, forumPost.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ForumPost> forumPosts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ForumPost forumPost : forumPosts) {
			EntityCacheUtil.removeResult(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
				ForumPostImpl.class, forumPost.getPrimaryKey());
		}
	}

	/**
	 * Creates a new forum post with the primary key. Does not add the forum post to the database.
	 *
	 * @param id_post the primary key for the new forum post
	 * @return the new forum post
	 */
	public ForumPost create(long id_post) {
		ForumPost forumPost = new ForumPostImpl();

		forumPost.setNew(true);
		forumPost.setPrimaryKey(id_post);

		return forumPost;
	}

	/**
	 * Removes the forum post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_post the primary key of the forum post
	 * @return the forum post that was removed
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost remove(long id_post)
		throws NoSuchForumPostException, SystemException {
		return remove(Long.valueOf(id_post));
	}

	/**
	 * Removes the forum post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the forum post
	 * @return the forum post that was removed
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumPost remove(Serializable primaryKey)
		throws NoSuchForumPostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ForumPost forumPost = (ForumPost)session.get(ForumPostImpl.class,
					primaryKey);

			if (forumPost == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchForumPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(forumPost);
		}
		catch (NoSuchForumPostException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ForumPost removeImpl(ForumPost forumPost)
		throws SystemException {
		forumPost = toUnwrappedModel(forumPost);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, forumPost);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(forumPost);

		return forumPost;
	}

	@Override
	public ForumPost updateImpl(
		net.appuntivari.forum.model.ForumPost forumPost, boolean merge)
		throws SystemException {
		forumPost = toUnwrappedModel(forumPost);

		boolean isNew = forumPost.isNew();

		ForumPostModelImpl forumPostModelImpl = (ForumPostModelImpl)forumPost;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, forumPost, merge);

			forumPost.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ForumPostModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((forumPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						forumPostModelImpl.getOriginalTimestamp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP,
					args);

				args = new Object[] { forumPostModelImpl.getTimestamp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP,
					args);
			}

			if ((forumPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumPostModelImpl.getOriginalUser_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(forumPostModelImpl.getUser_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((forumPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPOSTPARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumPostModelImpl.getOriginalUser_id_post_parent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPOSTPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPOSTPARENT,
					args);

				args = new Object[] {
						Long.valueOf(forumPostModelImpl.getUser_id_post_parent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPOSTPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPOSTPARENT,
					args);
			}

			if ((forumPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumPostModelImpl.getOriginalId_category())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDCATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(forumPostModelImpl.getId_category())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDCATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
			ForumPostImpl.class, forumPost.getPrimaryKey(), forumPost);

		return forumPost;
	}

	protected ForumPost toUnwrappedModel(ForumPost forumPost) {
		if (forumPost instanceof ForumPostImpl) {
			return forumPost;
		}

		ForumPostImpl forumPostImpl = new ForumPostImpl();

		forumPostImpl.setNew(forumPost.isNew());
		forumPostImpl.setPrimaryKey(forumPost.getPrimaryKey());

		forumPostImpl.setId_post(forumPost.getId_post());
		forumPostImpl.setPost(forumPost.getPost());
		forumPostImpl.setTimestamp(forumPost.getTimestamp());
		forumPostImpl.setUser_id(forumPost.getUser_id());
		forumPostImpl.setId_category(forumPost.getId_category());
		forumPostImpl.setId_post_parent(forumPost.getId_post_parent());
		forumPostImpl.setUser_id_post_parent(forumPost.getUser_id_post_parent());

		return forumPostImpl;
	}

	/**
	 * Returns the forum post with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum post
	 * @return the forum post
	 * @throws com.liferay.portal.NoSuchModelException if a forum post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumPost findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum post with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumPostException} if it could not be found.
	 *
	 * @param id_post the primary key of the forum post
	 * @return the forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a forum post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByPrimaryKey(long id_post)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByPrimaryKey(id_post);

		if (forumPost == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_post);
			}

			throw new NoSuchForumPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_post);
		}

		return forumPost;
	}

	/**
	 * Returns the forum post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum post
	 * @return the forum post, or <code>null</code> if a forum post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumPost fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_post the primary key of the forum post
	 * @return the forum post, or <code>null</code> if a forum post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByPrimaryKey(long id_post) throws SystemException {
		ForumPost forumPost = (ForumPost)EntityCacheUtil.getResult(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
				ForumPostImpl.class, id_post);

		if (forumPost == _nullForumPost) {
			return null;
		}

		if (forumPost == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				forumPost = (ForumPost)session.get(ForumPostImpl.class,
						Long.valueOf(id_post));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (forumPost != null) {
					cacheResult(forumPost);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ForumPostModelImpl.ENTITY_CACHE_ENABLED,
						ForumPostImpl.class, id_post, _nullForumPost);
				}

				closeSession(session);
			}
		}

		return forumPost;
	}

	/**
	 * Returns all the forum posts where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumPost> findByTimestamp(Date timestamp)
		throws SystemException {
		return findByTimestamp(timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<ForumPost> findByTimestamp(Date timestamp, int start, int end)
		throws SystemException {
		return findByTimestamp(timestamp, start, end, null);
	}

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
	public List<ForumPost> findByTimestamp(Date timestamp, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP;
			finderArgs = new Object[] { timestamp };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMESTAMP;
			finderArgs = new Object[] { timestamp, start, end, orderByComparator };
		}

		List<ForumPost> list = (List<ForumPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumPost forumPost : list) {
				if (!Validator.equals(timestamp, forumPost.getTimestamp())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FORUMPOST_WHERE);

			if (timestamp == null) {
				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_1);
			}
			else {
				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (timestamp != null) {
					qPos.add(CalendarUtil.getTimestamp(timestamp));
				}

				list = (List<ForumPost>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first forum post in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByTimestamp_First(Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByTimestamp_First(timestamp,
				orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the first forum post in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByTimestamp_First(Date timestamp,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumPost> list = findByTimestamp(timestamp, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forum post in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByTimestamp_Last(Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByTimestamp_Last(timestamp, orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the last forum post in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByTimestamp_Last(Date timestamp,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTimestamp(timestamp);

		List<ForumPost> list = findByTimestamp(timestamp, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public ForumPost[] findByTimestamp_PrevAndNext(long id_post,
		Date timestamp, OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = findByPrimaryKey(id_post);

		Session session = null;

		try {
			session = openSession();

			ForumPost[] array = new ForumPostImpl[3];

			array[0] = getByTimestamp_PrevAndNext(session, forumPost,
					timestamp, orderByComparator, true);

			array[1] = forumPost;

			array[2] = getByTimestamp_PrevAndNext(session, forumPost,
					timestamp, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumPost getByTimestamp_PrevAndNext(Session session,
		ForumPost forumPost, Date timestamp,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMPOST_WHERE);

		if (timestamp == null) {
			query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_1);
		}
		else {
			query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ForumPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (timestamp != null) {
			qPos.add(CalendarUtil.getTimestamp(timestamp));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum posts where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumPost> findByUserId(long user_id) throws SystemException {
		return findByUserId(user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ForumPost> findByUserId(long user_id, int start, int end)
		throws SystemException {
		return findByUserId(user_id, start, end, null);
	}

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
	public List<ForumPost> findByUserId(long user_id, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { user_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { user_id, start, end, orderByComparator };
		}

		List<ForumPost> list = (List<ForumPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumPost forumPost : list) {
				if ((user_id != forumPost.getUser_id())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FORUMPOST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				list = (List<ForumPost>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first forum post in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByUserId_First(long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByUserId_First(user_id, orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the first forum post in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByUserId_First(long user_id,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumPost> list = findByUserId(user_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forum post in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByUserId_Last(long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByUserId_Last(user_id, orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the last forum post in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByUserId_Last(long user_id,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(user_id);

		List<ForumPost> list = findByUserId(user_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public ForumPost[] findByUserId_PrevAndNext(long id_post, long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = findByPrimaryKey(id_post);

		Session session = null;

		try {
			session = openSession();

			ForumPost[] array = new ForumPostImpl[3];

			array[0] = getByUserId_PrevAndNext(session, forumPost, user_id,
					orderByComparator, true);

			array[1] = forumPost;

			array[2] = getByUserId_PrevAndNext(session, forumPost, user_id,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumPost getByUserId_PrevAndNext(Session session,
		ForumPost forumPost, long user_id, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMPOST_WHERE);

		query.append(_FINDER_COLUMN_USERID_USER_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ForumPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum posts where user_id_post_parent = &#63;.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @return the matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumPost> findByUserIdPostParent(long user_id_post_parent)
		throws SystemException {
		return findByUserIdPostParent(user_id_post_parent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ForumPost> findByUserIdPostParent(long user_id_post_parent,
		int start, int end) throws SystemException {
		return findByUserIdPostParent(user_id_post_parent, start, end, null);
	}

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
	public List<ForumPost> findByUserIdPostParent(long user_id_post_parent,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPOSTPARENT;
			finderArgs = new Object[] { user_id_post_parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPOSTPARENT;
			finderArgs = new Object[] {
					user_id_post_parent,
					
					start, end, orderByComparator
				};
		}

		List<ForumPost> list = (List<ForumPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumPost forumPost : list) {
				if ((user_id_post_parent != forumPost.getUser_id_post_parent())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FORUMPOST_WHERE);

			query.append(_FINDER_COLUMN_USERIDPOSTPARENT_USER_ID_POST_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_post_parent);

				list = (List<ForumPost>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first forum post in the ordered set where user_id_post_parent = &#63;.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByUserIdPostParent_First(long user_id_post_parent,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByUserIdPostParent_First(user_id_post_parent,
				orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_post_parent=");
		msg.append(user_id_post_parent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the first forum post in the ordered set where user_id_post_parent = &#63;.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByUserIdPostParent_First(long user_id_post_parent,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumPost> list = findByUserIdPostParent(user_id_post_parent, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forum post in the ordered set where user_id_post_parent = &#63;.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByUserIdPostParent_Last(long user_id_post_parent,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByUserIdPostParent_Last(user_id_post_parent,
				orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_post_parent=");
		msg.append(user_id_post_parent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the last forum post in the ordered set where user_id_post_parent = &#63;.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByUserIdPostParent_Last(long user_id_post_parent,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdPostParent(user_id_post_parent);

		List<ForumPost> list = findByUserIdPostParent(user_id_post_parent,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public ForumPost[] findByUserIdPostParent_PrevAndNext(long id_post,
		long user_id_post_parent, OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = findByPrimaryKey(id_post);

		Session session = null;

		try {
			session = openSession();

			ForumPost[] array = new ForumPostImpl[3];

			array[0] = getByUserIdPostParent_PrevAndNext(session, forumPost,
					user_id_post_parent, orderByComparator, true);

			array[1] = forumPost;

			array[2] = getByUserIdPostParent_PrevAndNext(session, forumPost,
					user_id_post_parent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumPost getByUserIdPostParent_PrevAndNext(Session session,
		ForumPost forumPost, long user_id_post_parent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMPOST_WHERE);

		query.append(_FINDER_COLUMN_USERIDPOSTPARENT_USER_ID_POST_PARENT_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ForumPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id_post_parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum posts where id_category = &#63;.
	 *
	 * @param id_category the id_category
	 * @return the matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumPost> findByIdCategory(long id_category)
		throws SystemException {
		return findByIdCategory(id_category, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ForumPost> findByIdCategory(long id_category, int start, int end)
		throws SystemException {
		return findByIdCategory(id_category, start, end, null);
	}

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
	public List<ForumPost> findByIdCategory(long id_category, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDCATEGORY;
			finderArgs = new Object[] { id_category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDCATEGORY;
			finderArgs = new Object[] { id_category, start, end, orderByComparator };
		}

		List<ForumPost> list = (List<ForumPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumPost forumPost : list) {
				if ((id_category != forumPost.getId_category())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FORUMPOST_WHERE);

			query.append(_FINDER_COLUMN_IDCATEGORY_ID_CATEGORY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_category);

				list = (List<ForumPost>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first forum post in the ordered set where id_category = &#63;.
	 *
	 * @param id_category the id_category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByIdCategory_First(long id_category,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByIdCategory_First(id_category,
				orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_category=");
		msg.append(id_category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the first forum post in the ordered set where id_category = &#63;.
	 *
	 * @param id_category the id_category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByIdCategory_First(long id_category,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumPost> list = findByIdCategory(id_category, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forum post in the ordered set where id_category = &#63;.
	 *
	 * @param id_category the id_category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post
	 * @throws net.appuntivari.forum.NoSuchForumPostException if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost findByIdCategory_Last(long id_category,
		OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = fetchByIdCategory_Last(id_category,
				orderByComparator);

		if (forumPost != null) {
			return forumPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_category=");
		msg.append(id_category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumPostException(msg.toString());
	}

	/**
	 * Returns the last forum post in the ordered set where id_category = &#63;.
	 *
	 * @param id_category the id_category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum post, or <code>null</code> if a matching forum post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumPost fetchByIdCategory_Last(long id_category,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIdCategory(id_category);

		List<ForumPost> list = findByIdCategory(id_category, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public ForumPost[] findByIdCategory_PrevAndNext(long id_post,
		long id_category, OrderByComparator orderByComparator)
		throws NoSuchForumPostException, SystemException {
		ForumPost forumPost = findByPrimaryKey(id_post);

		Session session = null;

		try {
			session = openSession();

			ForumPost[] array = new ForumPostImpl[3];

			array[0] = getByIdCategory_PrevAndNext(session, forumPost,
					id_category, orderByComparator, true);

			array[1] = forumPost;

			array[2] = getByIdCategory_PrevAndNext(session, forumPost,
					id_category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumPost getByIdCategory_PrevAndNext(Session session,
		ForumPost forumPost, long id_category,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMPOST_WHERE);

		query.append(_FINDER_COLUMN_IDCATEGORY_ID_CATEGORY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ForumPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_category);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum posts.
	 *
	 * @return the forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumPost> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumPost> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<ForumPost> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ForumPost> list = (List<ForumPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORUMPOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORUMPOST.concat(ForumPostModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ForumPost>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ForumPost>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the forum posts where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTimestamp(Date timestamp) throws SystemException {
		for (ForumPost forumPost : findByTimestamp(timestamp)) {
			remove(forumPost);
		}
	}

	/**
	 * Removes all the forum posts where user_id = &#63; from the database.
	 *
	 * @param user_id the user_id
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long user_id) throws SystemException {
		for (ForumPost forumPost : findByUserId(user_id)) {
			remove(forumPost);
		}
	}

	/**
	 * Removes all the forum posts where user_id_post_parent = &#63; from the database.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserIdPostParent(long user_id_post_parent)
		throws SystemException {
		for (ForumPost forumPost : findByUserIdPostParent(user_id_post_parent)) {
			remove(forumPost);
		}
	}

	/**
	 * Removes all the forum posts where id_category = &#63; from the database.
	 *
	 * @param id_category the id_category
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdCategory(long id_category) throws SystemException {
		for (ForumPost forumPost : findByIdCategory(id_category)) {
			remove(forumPost);
		}
	}

	/**
	 * Removes all the forum posts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ForumPost forumPost : findAll()) {
			remove(forumPost);
		}
	}

	/**
	 * Returns the number of forum posts where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTimestamp(Date timestamp) throws SystemException {
		Object[] finderArgs = new Object[] { timestamp };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMPOST_WHERE);

			if (timestamp == null) {
				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_1);
			}
			else {
				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (timestamp != null) {
					qPos.add(CalendarUtil.getTimestamp(timestamp));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum posts where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the number of matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long user_id) throws SystemException {
		Object[] finderArgs = new Object[] { user_id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMPOST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum posts where user_id_post_parent = &#63;.
	 *
	 * @param user_id_post_parent the user_id_post_parent
	 * @return the number of matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdPostParent(long user_id_post_parent)
		throws SystemException {
		Object[] finderArgs = new Object[] { user_id_post_parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDPOSTPARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMPOST_WHERE);

			query.append(_FINDER_COLUMN_USERIDPOSTPARENT_USER_ID_POST_PARENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_post_parent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDPOSTPARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum posts where id_category = &#63;.
	 *
	 * @param id_category the id_category
	 * @return the number of matching forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdCategory(long id_category) throws SystemException {
		Object[] finderArgs = new Object[] { id_category };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDCATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMPOST_WHERE);

			query.append(_FINDER_COLUMN_IDCATEGORY_ID_CATEGORY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_category);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDCATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum posts.
	 *
	 * @return the number of forum posts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORUMPOST);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the forum post persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.appuntivari.forum.model.ForumPost")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ForumPost>> listenersList = new ArrayList<ModelListener<ForumPost>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<ForumPost>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ForumPostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ForumPersistence.class)
	protected ForumPersistence forumPersistence;
	@BeanReference(type = ForumCategoryPersistence.class)
	protected ForumCategoryPersistence forumCategoryPersistence;
	@BeanReference(type = ForumPostPersistence.class)
	protected ForumPostPersistence forumPostPersistence;
	@BeanReference(type = ForumUserPersistence.class)
	protected ForumUserPersistence forumUserPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FORUMPOST = "SELECT forumPost FROM ForumPost forumPost";
	private static final String _SQL_SELECT_FORUMPOST_WHERE = "SELECT forumPost FROM ForumPost forumPost WHERE ";
	private static final String _SQL_COUNT_FORUMPOST = "SELECT COUNT(forumPost) FROM ForumPost forumPost";
	private static final String _SQL_COUNT_FORUMPOST_WHERE = "SELECT COUNT(forumPost) FROM ForumPost forumPost WHERE ";
	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_1 = "forumPost.timestamp IS NULL";
	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2 = "forumPost.timestamp = ?";
	private static final String _FINDER_COLUMN_USERID_USER_ID_2 = "forumPost.user_id = ?";
	private static final String _FINDER_COLUMN_USERIDPOSTPARENT_USER_ID_POST_PARENT_2 =
		"forumPost.user_id_post_parent = ?";
	private static final String _FINDER_COLUMN_IDCATEGORY_ID_CATEGORY_2 = "forumPost.id_category = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "forumPost.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ForumPost exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ForumPost exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ForumPostPersistenceImpl.class);
	private static ForumPost _nullForumPost = new ForumPostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ForumPost> toCacheModel() {
				return _nullForumPostCacheModel;
			}
		};

	private static CacheModel<ForumPost> _nullForumPostCacheModel = new CacheModel<ForumPost>() {
			public ForumPost toEntityModel() {
				return _nullForumPost;
			}
		};
}