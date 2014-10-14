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

import net.appuntivari.forum.NoSuchForumException;
import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.impl.ForumImpl;
import net.appuntivari.forum.model.impl.ForumModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the forum service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPersistence
 * @see ForumUtil
 * @generated
 */
public class ForumPersistenceImpl extends BasePersistenceImpl<Forum>
	implements ForumPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ForumUtil} to access the forum persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ForumImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMESTAMP =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimestamp",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimestamp",
			new String[] { Date.class.getName() },
			ForumModelImpl.TIMESTAMP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMESTAMP = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimestamp",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ForumModelImpl.COMPANY_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCREATOR =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdCreator",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdCreator",
			new String[] { Long.class.getName() },
			ForumModelImpl.USER_ID_CREATOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCREATOR = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdCreator",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCREATORSTATUS =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdCreatorStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATORSTATUS =
		new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdCreatorStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			ForumModelImpl.USER_ID_CREATOR_COLUMN_BITMASK |
			ForumModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCREATORSTATUS = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdCreatorStatus",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, ForumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the forum in the entity cache if it is enabled.
	 *
	 * @param forum the forum
	 */
	public void cacheResult(Forum forum) {
		EntityCacheUtil.putResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumImpl.class, forum.getPrimaryKey(), forum);

		forum.resetOriginalValues();
	}

	/**
	 * Caches the forums in the entity cache if it is enabled.
	 *
	 * @param forums the forums
	 */
	public void cacheResult(List<Forum> forums) {
		for (Forum forum : forums) {
			if (EntityCacheUtil.getResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
						ForumImpl.class, forum.getPrimaryKey()) == null) {
				cacheResult(forum);
			}
			else {
				forum.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all forums.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ForumImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ForumImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the forum.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Forum forum) {
		EntityCacheUtil.removeResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumImpl.class, forum.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Forum> forums) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Forum forum : forums) {
			EntityCacheUtil.removeResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
				ForumImpl.class, forum.getPrimaryKey());
		}
	}

	/**
	 * Creates a new forum with the primary key. Does not add the forum to the database.
	 *
	 * @param id_forum the primary key for the new forum
	 * @return the new forum
	 */
	public Forum create(long id_forum) {
		Forum forum = new ForumImpl();

		forum.setNew(true);
		forum.setPrimaryKey(id_forum);

		return forum;
	}

	/**
	 * Removes the forum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_forum the primary key of the forum
	 * @return the forum that was removed
	 * @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum remove(long id_forum)
		throws NoSuchForumException, SystemException {
		return remove(Long.valueOf(id_forum));
	}

	/**
	 * Removes the forum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the forum
	 * @return the forum that was removed
	 * @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Forum remove(Serializable primaryKey)
		throws NoSuchForumException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Forum forum = (Forum)session.get(ForumImpl.class, primaryKey);

			if (forum == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchForumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(forum);
		}
		catch (NoSuchForumException nsee) {
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
	protected Forum removeImpl(Forum forum) throws SystemException {
		forum = toUnwrappedModel(forum);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, forum);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(forum);

		return forum;
	}

	@Override
	public Forum updateImpl(net.appuntivari.forum.model.Forum forum,
		boolean merge) throws SystemException {
		forum = toUnwrappedModel(forum);

		boolean isNew = forum.isNew();

		ForumModelImpl forumModelImpl = (ForumModelImpl)forum;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, forum, merge);

			forum.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ForumModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((forumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						forumModelImpl.getOriginalTimestamp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP,
					args);

				args = new Object[] { forumModelImpl.getTimestamp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP,
					args);
			}

			if ((forumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumModelImpl.getOriginalCompany_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { Long.valueOf(forumModelImpl.getCompany_id()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((forumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumModelImpl.getOriginalUser_id_creator())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR,
					args);

				args = new Object[] {
						Long.valueOf(forumModelImpl.getUser_id_creator())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR,
					args);
			}

			if ((forumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATORSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumModelImpl.getOriginalUser_id_creator()),
						
						forumModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCREATORSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATORSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(forumModelImpl.getUser_id_creator()),
						
						forumModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCREATORSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATORSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
			ForumImpl.class, forum.getPrimaryKey(), forum);

		return forum;
	}

	protected Forum toUnwrappedModel(Forum forum) {
		if (forum instanceof ForumImpl) {
			return forum;
		}

		ForumImpl forumImpl = new ForumImpl();

		forumImpl.setNew(forum.isNew());
		forumImpl.setPrimaryKey(forum.getPrimaryKey());

		forumImpl.setId_forum(forum.getId_forum());
		forumImpl.setDescription(forum.getDescription());
		forumImpl.setTimestamp(forum.getTimestamp());
		forumImpl.setCompany_id(forum.getCompany_id());
		forumImpl.setUser_id_creator(forum.getUser_id_creator());
		forumImpl.setStatus(forum.getStatus());

		return forumImpl;
	}

	/**
	 * Returns the forum with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum
	 * @return the forum
	 * @throws com.liferay.portal.NoSuchModelException if a forum with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Forum findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumException} if it could not be found.
	 *
	 * @param id_forum the primary key of the forum
	 * @return the forum
	 * @throws net.appuntivari.forum.NoSuchForumException if a forum with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum findByPrimaryKey(long id_forum)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByPrimaryKey(id_forum);

		if (forum == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_forum);
			}

			throw new NoSuchForumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_forum);
		}

		return forum;
	}

	/**
	 * Returns the forum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum
	 * @return the forum, or <code>null</code> if a forum with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Forum fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_forum the primary key of the forum
	 * @return the forum, or <code>null</code> if a forum with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByPrimaryKey(long id_forum) throws SystemException {
		Forum forum = (Forum)EntityCacheUtil.getResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
				ForumImpl.class, id_forum);

		if (forum == _nullForum) {
			return null;
		}

		if (forum == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				forum = (Forum)session.get(ForumImpl.class,
						Long.valueOf(id_forum));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (forum != null) {
					cacheResult(forum);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ForumModelImpl.ENTITY_CACHE_ENABLED,
						ForumImpl.class, id_forum, _nullForum);
				}

				closeSession(session);
			}
		}

		return forum;
	}

	/**
	 * Returns all the forums where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public List<Forum> findByTimestamp(Date timestamp)
		throws SystemException {
		return findByTimestamp(timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<Forum> findByTimestamp(Date timestamp, int start, int end)
		throws SystemException {
		return findByTimestamp(timestamp, start, end, null);
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
	public List<Forum> findByTimestamp(Date timestamp, int start, int end,
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

		List<Forum> list = (List<Forum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Forum forum : list) {
				if (!Validator.equals(timestamp, forum.getTimestamp())) {
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

			query.append(_SQL_SELECT_FORUM_WHERE);

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
				query.append(ForumModelImpl.ORDER_BY_JPQL);
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

				list = (List<Forum>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first forum in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum
	 * @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum findByTimestamp_First(Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByTimestamp_First(timestamp, orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
	}

	/**
	 * Returns the first forum in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum, or <code>null</code> if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByTimestamp_First(Date timestamp,
		OrderByComparator orderByComparator) throws SystemException {
		List<Forum> list = findByTimestamp(timestamp, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum findByTimestamp_Last(Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByTimestamp_Last(timestamp, orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
	}

	/**
	 * Returns the last forum in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum, or <code>null</code> if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByTimestamp_Last(Date timestamp,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTimestamp(timestamp);

		List<Forum> list = findByTimestamp(timestamp, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum[] findByTimestamp_PrevAndNext(long id_forum, Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = findByPrimaryKey(id_forum);

		Session session = null;

		try {
			session = openSession();

			Forum[] array = new ForumImpl[3];

			array[0] = getByTimestamp_PrevAndNext(session, forum, timestamp,
					orderByComparator, true);

			array[1] = forum;

			array[2] = getByTimestamp_PrevAndNext(session, forum, timestamp,
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

	protected Forum getByTimestamp_PrevAndNext(Session session, Forum forum,
		Date timestamp, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUM_WHERE);

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
			query.append(ForumModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(forum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Forum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forums where company_id = &#63;.
	 *
	 * @param company_id the company_id
	 * @return the matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public List<Forum> findByCompanyId(long company_id)
		throws SystemException {
		return findByCompanyId(company_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Forum> findByCompanyId(long company_id, int start, int end)
		throws SystemException {
		return findByCompanyId(company_id, start, end, null);
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
	public List<Forum> findByCompanyId(long company_id, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { company_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { company_id, start, end, orderByComparator };
		}

		List<Forum> list = (List<Forum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Forum forum : list) {
				if ((company_id != forum.getCompany_id())) {
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

			query.append(_SQL_SELECT_FORUM_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANY_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(company_id);

				list = (List<Forum>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first forum in the ordered set where company_id = &#63;.
	 *
	 * @param company_id the company_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum
	 * @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum findByCompanyId_First(long company_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByCompanyId_First(company_id, orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("company_id=");
		msg.append(company_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
	}

	/**
	 * Returns the first forum in the ordered set where company_id = &#63;.
	 *
	 * @param company_id the company_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum, or <code>null</code> if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByCompanyId_First(long company_id,
		OrderByComparator orderByComparator) throws SystemException {
		List<Forum> list = findByCompanyId(company_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum findByCompanyId_Last(long company_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByCompanyId_Last(company_id, orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("company_id=");
		msg.append(company_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
	}

	/**
	 * Returns the last forum in the ordered set where company_id = &#63;.
	 *
	 * @param company_id the company_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum, or <code>null</code> if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByCompanyId_Last(long company_id,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(company_id);

		List<Forum> list = findByCompanyId(company_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum[] findByCompanyId_PrevAndNext(long id_forum, long company_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = findByPrimaryKey(id_forum);

		Session session = null;

		try {
			session = openSession();

			Forum[] array = new ForumImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, forum, company_id,
					orderByComparator, true);

			array[1] = forum;

			array[2] = getByCompanyId_PrevAndNext(session, forum, company_id,
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

	protected Forum getByCompanyId_PrevAndNext(Session session, Forum forum,
		long company_id, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUM_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANY_ID_2);

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
			query.append(ForumModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(company_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Forum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forums where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @return the matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public List<Forum> findByUserIdCreator(long user_id_creator)
		throws SystemException {
		return findByUserIdCreator(user_id_creator, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Forum> findByUserIdCreator(long user_id_creator, int start,
		int end) throws SystemException {
		return findByUserIdCreator(user_id_creator, start, end, null);
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
	public List<Forum> findByUserIdCreator(long user_id_creator, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR;
			finderArgs = new Object[] { user_id_creator };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCREATOR;
			finderArgs = new Object[] {
					user_id_creator,
					
					start, end, orderByComparator
				};
		}

		List<Forum> list = (List<Forum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Forum forum : list) {
				if ((user_id_creator != forum.getUser_id_creator())) {
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

			query.append(_SQL_SELECT_FORUM_WHERE);

			query.append(_FINDER_COLUMN_USERIDCREATOR_USER_ID_CREATOR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_creator);

				list = (List<Forum>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first forum in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum
	 * @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum findByUserIdCreator_First(long user_id_creator,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByUserIdCreator_First(user_id_creator,
				orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_creator=");
		msg.append(user_id_creator);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
	}

	/**
	 * Returns the first forum in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum, or <code>null</code> if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByUserIdCreator_First(long user_id_creator,
		OrderByComparator orderByComparator) throws SystemException {
		List<Forum> list = findByUserIdCreator(user_id_creator, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum findByUserIdCreator_Last(long user_id_creator,
		OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByUserIdCreator_Last(user_id_creator,
				orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_creator=");
		msg.append(user_id_creator);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
	}

	/**
	 * Returns the last forum in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum, or <code>null</code> if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum fetchByUserIdCreator_Last(long user_id_creator,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdCreator(user_id_creator);

		List<Forum> list = findByUserIdCreator(user_id_creator, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum[] findByUserIdCreator_PrevAndNext(long id_forum,
		long user_id_creator, OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = findByPrimaryKey(id_forum);

		Session session = null;

		try {
			session = openSession();

			Forum[] array = new ForumImpl[3];

			array[0] = getByUserIdCreator_PrevAndNext(session, forum,
					user_id_creator, orderByComparator, true);

			array[1] = forum;

			array[2] = getByUserIdCreator_PrevAndNext(session, forum,
					user_id_creator, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Forum getByUserIdCreator_PrevAndNext(Session session,
		Forum forum, long user_id_creator, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUM_WHERE);

		query.append(_FINDER_COLUMN_USERIDCREATOR_USER_ID_CREATOR_2);

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
			query.append(ForumModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id_creator);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Forum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forums where user_id_creator = &#63; and status = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param status the status
	 * @return the matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public List<Forum> findByUserIdCreatorStatus(long user_id_creator,
		String status) throws SystemException {
		return findByUserIdCreatorStatus(user_id_creator, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Forum> findByUserIdCreatorStatus(long user_id_creator,
		String status, int start, int end) throws SystemException {
		return findByUserIdCreatorStatus(user_id_creator, status, start, end,
			null);
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
	public List<Forum> findByUserIdCreatorStatus(long user_id_creator,
		String status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATORSTATUS;
			finderArgs = new Object[] { user_id_creator, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCREATORSTATUS;
			finderArgs = new Object[] {
					user_id_creator, status,
					
					start, end, orderByComparator
				};
		}

		List<Forum> list = (List<Forum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Forum forum : list) {
				if ((user_id_creator != forum.getUser_id_creator()) ||
						!Validator.equals(status, forum.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FORUM_WHERE);

			query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_USER_ID_CREATOR_2);

			if (status == null) {
				query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_creator);

				if (status != null) {
					qPos.add(status);
				}

				list = (List<Forum>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first forum in the ordered set where user_id_creator = &#63; and status = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum
	 * @throws net.appuntivari.forum.NoSuchForumException if a matching forum could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Forum findByUserIdCreatorStatus_First(long user_id_creator,
		String status, OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByUserIdCreatorStatus_First(user_id_creator, status,
				orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_creator=");
		msg.append(user_id_creator);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
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
	public Forum fetchByUserIdCreatorStatus_First(long user_id_creator,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Forum> list = findByUserIdCreatorStatus(user_id_creator, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum findByUserIdCreatorStatus_Last(long user_id_creator,
		String status, OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = fetchByUserIdCreatorStatus_Last(user_id_creator, status,
				orderByComparator);

		if (forum != null) {
			return forum;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_creator=");
		msg.append(user_id_creator);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumException(msg.toString());
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
	public Forum fetchByUserIdCreatorStatus_Last(long user_id_creator,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdCreatorStatus(user_id_creator, status);

		List<Forum> list = findByUserIdCreatorStatus(user_id_creator, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Forum[] findByUserIdCreatorStatus_PrevAndNext(long id_forum,
		long user_id_creator, String status, OrderByComparator orderByComparator)
		throws NoSuchForumException, SystemException {
		Forum forum = findByPrimaryKey(id_forum);

		Session session = null;

		try {
			session = openSession();

			Forum[] array = new ForumImpl[3];

			array[0] = getByUserIdCreatorStatus_PrevAndNext(session, forum,
					user_id_creator, status, orderByComparator, true);

			array[1] = forum;

			array[2] = getByUserIdCreatorStatus_PrevAndNext(session, forum,
					user_id_creator, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Forum getByUserIdCreatorStatus_PrevAndNext(Session session,
		Forum forum, long user_id_creator, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUM_WHERE);

		query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_USER_ID_CREATOR_2);

		if (status == null) {
			query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_1);
		}
		else {
			if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_3);
			}
			else {
				query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_2);
			}
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
			query.append(ForumModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id_creator);

		if (status != null) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Forum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forums.
	 *
	 * @return the forums
	 * @throws SystemException if a system exception occurred
	 */
	public List<Forum> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Forum> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Forum> findAll(int start, int end,
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

		List<Forum> list = (List<Forum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORUM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORUM.concat(ForumModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Forum>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Forum>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the forums where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTimestamp(Date timestamp) throws SystemException {
		for (Forum forum : findByTimestamp(timestamp)) {
			remove(forum);
		}
	}

	/**
	 * Removes all the forums where company_id = &#63; from the database.
	 *
	 * @param company_id the company_id
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long company_id) throws SystemException {
		for (Forum forum : findByCompanyId(company_id)) {
			remove(forum);
		}
	}

	/**
	 * Removes all the forums where user_id_creator = &#63; from the database.
	 *
	 * @param user_id_creator the user_id_creator
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserIdCreator(long user_id_creator)
		throws SystemException {
		for (Forum forum : findByUserIdCreator(user_id_creator)) {
			remove(forum);
		}
	}

	/**
	 * Removes all the forums where user_id_creator = &#63; and status = &#63; from the database.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserIdCreatorStatus(long user_id_creator, String status)
		throws SystemException {
		for (Forum forum : findByUserIdCreatorStatus(user_id_creator, status)) {
			remove(forum);
		}
	}

	/**
	 * Removes all the forums from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Forum forum : findAll()) {
			remove(forum);
		}
	}

	/**
	 * Returns the number of forums where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTimestamp(Date timestamp) throws SystemException {
		Object[] finderArgs = new Object[] { timestamp };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUM_WHERE);

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
	 * Returns the number of forums where company_id = &#63;.
	 *
	 * @param company_id the company_id
	 * @return the number of matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long company_id) throws SystemException {
		Object[] finderArgs = new Object[] { company_id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUM_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(company_id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forums where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @return the number of matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdCreator(long user_id_creator)
		throws SystemException {
		Object[] finderArgs = new Object[] { user_id_creator };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUM_WHERE);

			query.append(_FINDER_COLUMN_USERIDCREATOR_USER_ID_CREATOR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_creator);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forums where user_id_creator = &#63; and status = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param status the status
	 * @return the number of matching forums
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdCreatorStatus(long user_id_creator, String status)
		throws SystemException {
		Object[] finderArgs = new Object[] { user_id_creator, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDCREATORSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FORUM_WHERE);

			query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_USER_ID_CREATOR_2);

			if (status == null) {
				query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_creator);

				if (status != null) {
					qPos.add(status);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCREATORSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forums.
	 *
	 * @return the number of forums
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORUM);

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
	 * Initializes the forum persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.appuntivari.forum.model.Forum")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Forum>> listenersList = new ArrayList<ModelListener<Forum>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Forum>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ForumImpl.class.getName());
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
	private static final String _SQL_SELECT_FORUM = "SELECT forum FROM Forum forum";
	private static final String _SQL_SELECT_FORUM_WHERE = "SELECT forum FROM Forum forum WHERE ";
	private static final String _SQL_COUNT_FORUM = "SELECT COUNT(forum) FROM Forum forum";
	private static final String _SQL_COUNT_FORUM_WHERE = "SELECT COUNT(forum) FROM Forum forum WHERE ";
	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_1 = "forum.timestamp IS NULL";
	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2 = "forum.timestamp = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANY_ID_2 = "forum.company_id = ?";
	private static final String _FINDER_COLUMN_USERIDCREATOR_USER_ID_CREATOR_2 = "forum.user_id_creator = ?";
	private static final String _FINDER_COLUMN_USERIDCREATORSTATUS_USER_ID_CREATOR_2 =
		"forum.user_id_creator = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_1 = "forum.status IS NULL";
	private static final String _FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_2 = "forum.status = ?";
	private static final String _FINDER_COLUMN_USERIDCREATORSTATUS_STATUS_3 = "(forum.status IS NULL OR forum.status = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "forum.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Forum exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Forum exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ForumPersistenceImpl.class);
	private static Forum _nullForum = new ForumImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Forum> toCacheModel() {
				return _nullForumCacheModel;
			}
		};

	private static CacheModel<Forum> _nullForumCacheModel = new CacheModel<Forum>() {
			public Forum toEntityModel() {
				return _nullForum;
			}
		};
}