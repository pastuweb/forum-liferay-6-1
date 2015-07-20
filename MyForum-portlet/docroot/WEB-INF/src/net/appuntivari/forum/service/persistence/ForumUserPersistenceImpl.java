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

import net.appuntivari.forum.NoSuchForumUserException;
import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.model.impl.ForumUserImpl;
import net.appuntivari.forum.model.impl.ForumUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the forum user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumUserPersistence
 * @see ForumUserUtil
 * @generated
 */
public class ForumUserPersistenceImpl extends BasePersistenceImpl<ForumUser>
	implements ForumUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ForumUserUtil} to access the forum user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ForumUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUM = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdForum",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdForum",
			new String[] { Long.class.getName() },
			ForumUserModelImpl.ID_FORUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDFORUM = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdForum",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ForumUserModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			ForumUserModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMSTATUS =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdForumStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdForumStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			ForumUserModelImpl.ID_FORUM_COLUMN_BITMASK |
			ForumUserModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDFORUMSTATUS = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdForumStatus",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdForumUserIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS =
		new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdForumUserIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ForumUserModelImpl.ID_FORUM_COLUMN_BITMASK |
			ForumUserModelImpl.USER_ID_COLUMN_BITMASK |
			ForumUserModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDFORUMUSERIDSTATUS = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdForumUserIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, ForumUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the forum user in the entity cache if it is enabled.
	 *
	 * @param forumUser the forum user
	 */
	public void cacheResult(ForumUser forumUser) {
		EntityCacheUtil.putResult(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserImpl.class, forumUser.getPrimaryKey(), forumUser);

		forumUser.resetOriginalValues();
	}

	/**
	 * Caches the forum users in the entity cache if it is enabled.
	 *
	 * @param forumUsers the forum users
	 */
	public void cacheResult(List<ForumUser> forumUsers) {
		for (ForumUser forumUser : forumUsers) {
			if (EntityCacheUtil.getResult(
						ForumUserModelImpl.ENTITY_CACHE_ENABLED,
						ForumUserImpl.class, forumUser.getPrimaryKey()) == null) {
				cacheResult(forumUser);
			}
			else {
				forumUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all forum users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ForumUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ForumUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the forum user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ForumUser forumUser) {
		EntityCacheUtil.removeResult(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserImpl.class, forumUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ForumUser> forumUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ForumUser forumUser : forumUsers) {
			EntityCacheUtil.removeResult(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
				ForumUserImpl.class, forumUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new forum user with the primary key. Does not add the forum user to the database.
	 *
	 * @param id_forum_user the primary key for the new forum user
	 * @return the new forum user
	 */
	public ForumUser create(long id_forum_user) {
		ForumUser forumUser = new ForumUserImpl();

		forumUser.setNew(true);
		forumUser.setPrimaryKey(id_forum_user);

		return forumUser;
	}

	/**
	 * Removes the forum user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_forum_user the primary key of the forum user
	 * @return the forum user that was removed
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser remove(long id_forum_user)
		throws NoSuchForumUserException, SystemException {
		return remove(Long.valueOf(id_forum_user));
	}

	/**
	 * Removes the forum user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the forum user
	 * @return the forum user that was removed
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumUser remove(Serializable primaryKey)
		throws NoSuchForumUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ForumUser forumUser = (ForumUser)session.get(ForumUserImpl.class,
					primaryKey);

			if (forumUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchForumUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(forumUser);
		}
		catch (NoSuchForumUserException nsee) {
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
	protected ForumUser removeImpl(ForumUser forumUser)
		throws SystemException {
		forumUser = toUnwrappedModel(forumUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, forumUser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(forumUser);

		return forumUser;
	}

	@Override
	public ForumUser updateImpl(
		net.appuntivari.forum.model.ForumUser forumUser, boolean merge)
		throws SystemException {
		forumUser = toUnwrappedModel(forumUser);

		boolean isNew = forumUser.isNew();

		ForumUserModelImpl forumUserModelImpl = (ForumUserModelImpl)forumUser;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, forumUser, merge);

			forumUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ForumUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((forumUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumUserModelImpl.getOriginalId_forum())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM,
					args);

				args = new Object[] {
						Long.valueOf(forumUserModelImpl.getId_forum())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM,
					args);
			}

			if ((forumUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumUserModelImpl.getOriginalUser_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(forumUserModelImpl.getUser_id())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((forumUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						forumUserModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { forumUserModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((forumUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumUserModelImpl.getOriginalId_forum()),
						
						forumUserModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(forumUserModelImpl.getId_forum()),
						
						forumUserModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS,
					args);
			}

			if ((forumUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumUserModelImpl.getOriginalId_forum()),
						Long.valueOf(forumUserModelImpl.getOriginalUser_id()),
						
						forumUserModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMUSERIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(forumUserModelImpl.getId_forum()),
						Long.valueOf(forumUserModelImpl.getUser_id()),
						
						forumUserModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMUSERIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
			ForumUserImpl.class, forumUser.getPrimaryKey(), forumUser);

		return forumUser;
	}

	protected ForumUser toUnwrappedModel(ForumUser forumUser) {
		if (forumUser instanceof ForumUserImpl) {
			return forumUser;
		}

		ForumUserImpl forumUserImpl = new ForumUserImpl();

		forumUserImpl.setNew(forumUser.isNew());
		forumUserImpl.setPrimaryKey(forumUser.getPrimaryKey());

		forumUserImpl.setId_forum_user(forumUser.getId_forum_user());
		forumUserImpl.setId_forum(forumUser.getId_forum());
		forumUserImpl.setUser_id(forumUser.getUser_id());
		forumUserImpl.setStatus(forumUser.getStatus());

		return forumUserImpl;
	}

	/**
	 * Returns the forum user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum user
	 * @return the forum user
	 * @throws com.liferay.portal.NoSuchModelException if a forum user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum user with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumUserException} if it could not be found.
	 *
	 * @param id_forum_user the primary key of the forum user
	 * @return the forum user
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a forum user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser findByPrimaryKey(long id_forum_user)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByPrimaryKey(id_forum_user);

		if (forumUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_forum_user);
			}

			throw new NoSuchForumUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_forum_user);
		}

		return forumUser;
	}

	/**
	 * Returns the forum user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum user
	 * @return the forum user, or <code>null</code> if a forum user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_forum_user the primary key of the forum user
	 * @return the forum user, or <code>null</code> if a forum user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByPrimaryKey(long id_forum_user)
		throws SystemException {
		ForumUser forumUser = (ForumUser)EntityCacheUtil.getResult(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
				ForumUserImpl.class, id_forum_user);

		if (forumUser == _nullForumUser) {
			return null;
		}

		if (forumUser == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				forumUser = (ForumUser)session.get(ForumUserImpl.class,
						Long.valueOf(id_forum_user));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (forumUser != null) {
					cacheResult(forumUser);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ForumUserModelImpl.ENTITY_CACHE_ENABLED,
						ForumUserImpl.class, id_forum_user, _nullForumUser);
				}

				closeSession(session);
			}
		}

		return forumUser;
	}

	/**
	 * Returns all the forum users where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @return the matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumUser> findByIdForum(long id_forum)
		throws SystemException {
		return findByIdForum(id_forum, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<ForumUser> findByIdForum(long id_forum, int start, int end)
		throws SystemException {
		return findByIdForum(id_forum, start, end, null);
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
	public List<ForumUser> findByIdForum(long id_forum, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM;
			finderArgs = new Object[] { id_forum };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUM;
			finderArgs = new Object[] { id_forum, start, end, orderByComparator };
		}

		List<ForumUser> list = (List<ForumUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumUser forumUser : list) {
				if ((id_forum != forumUser.getId_forum())) {
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

			query.append(_SQL_SELECT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_IDFORUM_ID_FORUM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				list = (List<ForumUser>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first forum user in the ordered set where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser findByIdForum_First(long id_forum,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByIdForum_First(id_forum, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
	}

	/**
	 * Returns the first forum user in the ordered set where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByIdForum_First(long id_forum,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumUser> list = findByIdForum(id_forum, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser findByIdForum_Last(long id_forum,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByIdForum_Last(id_forum, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
	}

	/**
	 * Returns the last forum user in the ordered set where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByIdForum_Last(long id_forum,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIdForum(id_forum);

		List<ForumUser> list = findByIdForum(id_forum, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser[] findByIdForum_PrevAndNext(long id_forum_user,
		long id_forum, OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = findByPrimaryKey(id_forum_user);

		Session session = null;

		try {
			session = openSession();

			ForumUser[] array = new ForumUserImpl[3];

			array[0] = getByIdForum_PrevAndNext(session, forumUser, id_forum,
					orderByComparator, true);

			array[1] = forumUser;

			array[2] = getByIdForum_PrevAndNext(session, forumUser, id_forum,
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

	protected ForumUser getByIdForum_PrevAndNext(Session session,
		ForumUser forumUser, long id_forum,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMUSER_WHERE);

		query.append(_FINDER_COLUMN_IDFORUM_ID_FORUM_2);

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
			query.append(ForumUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_forum);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum users where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumUser> findByUserId(long user_id) throws SystemException {
		return findByUserId(user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumUser> findByUserId(long user_id, int start, int end)
		throws SystemException {
		return findByUserId(user_id, start, end, null);
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
	public List<ForumUser> findByUserId(long user_id, int start, int end,
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

		List<ForumUser> list = (List<ForumUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumUser forumUser : list) {
				if ((user_id != forumUser.getUser_id())) {
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

			query.append(_SQL_SELECT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				list = (List<ForumUser>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first forum user in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser findByUserId_First(long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByUserId_First(user_id, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
	}

	/**
	 * Returns the first forum user in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByUserId_First(long user_id,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumUser> list = findByUserId(user_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser findByUserId_Last(long user_id,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByUserId_Last(user_id, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
	}

	/**
	 * Returns the last forum user in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByUserId_Last(long user_id,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(user_id);

		List<ForumUser> list = findByUserId(user_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser[] findByUserId_PrevAndNext(long id_forum_user,
		long user_id, OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = findByPrimaryKey(id_forum_user);

		Session session = null;

		try {
			session = openSession();

			ForumUser[] array = new ForumUserImpl[3];

			array[0] = getByUserId_PrevAndNext(session, forumUser, user_id,
					orderByComparator, true);

			array[1] = forumUser;

			array[2] = getByUserId_PrevAndNext(session, forumUser, user_id,
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

	protected ForumUser getByUserId_PrevAndNext(Session session,
		ForumUser forumUser, long user_id, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMUSER_WHERE);

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
			query.append(ForumUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum users where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumUser> findByStatus(String status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumUser> findByStatus(String status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
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
	public List<ForumUser> findByStatus(String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<ForumUser> list = (List<ForumUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumUser forumUser : list) {
				if (!Validator.equals(status, forumUser.getStatus())) {
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

			query.append(_SQL_SELECT_FORUMUSER_WHERE);

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_STATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_STATUS_STATUS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (status != null) {
					qPos.add(status);
				}

				list = (List<ForumUser>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first forum user in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser findByStatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByStatus_First(status, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
	}

	/**
	 * Returns the first forum user in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user, or <code>null</code> if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByStatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumUser> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser findByStatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByStatus_Last(status, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
	}

	/**
	 * Returns the last forum user in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum user, or <code>null</code> if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser fetchByStatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		List<ForumUser> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser[] findByStatus_PrevAndNext(long id_forum_user,
		String status, OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = findByPrimaryKey(id_forum_user);

		Session session = null;

		try {
			session = openSession();

			ForumUser[] array = new ForumUserImpl[3];

			array[0] = getByStatus_PrevAndNext(session, forumUser, status,
					orderByComparator, true);

			array[1] = forumUser;

			array[2] = getByStatus_PrevAndNext(session, forumUser, status,
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

	protected ForumUser getByStatus_PrevAndNext(Session session,
		ForumUser forumUser, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMUSER_WHERE);

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_1);
		}
		else {
			if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			query.append(ForumUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (status != null) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum users where id_forum = &#63; and status = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @return the matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumUser> findByIdForumStatus(long id_forum, String status)
		throws SystemException {
		return findByIdForumStatus(id_forum, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<ForumUser> findByIdForumStatus(long id_forum, String status,
		int start, int end) throws SystemException {
		return findByIdForumStatus(id_forum, status, start, end, null);
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
	public List<ForumUser> findByIdForumStatus(long id_forum, String status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS;
			finderArgs = new Object[] { id_forum, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMSTATUS;
			finderArgs = new Object[] {
					id_forum, status,
					
					start, end, orderByComparator
				};
		}

		List<ForumUser> list = (List<ForumUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumUser forumUser : list) {
				if ((id_forum != forumUser.getId_forum()) ||
						!Validator.equals(status, forumUser.getStatus())) {
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

			query.append(_SQL_SELECT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_IDFORUMSTATUS_ID_FORUM_2);

			if (status == null) {
				query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				if (status != null) {
					qPos.add(status);
				}

				list = (List<ForumUser>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first forum user in the ordered set where id_forum = &#63; and status = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum user
	 * @throws net.appuntivari.forum.NoSuchForumUserException if a matching forum user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumUser findByIdForumStatus_First(long id_forum, String status,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByIdForumStatus_First(id_forum, status,
				orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
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
	public ForumUser fetchByIdForumStatus_First(long id_forum, String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumUser> list = findByIdForumStatus(id_forum, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser findByIdForumStatus_Last(long id_forum, String status,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByIdForumStatus_Last(id_forum, status,
				orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
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
	public ForumUser fetchByIdForumStatus_Last(long id_forum, String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIdForumStatus(id_forum, status);

		List<ForumUser> list = findByIdForumStatus(id_forum, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser[] findByIdForumStatus_PrevAndNext(long id_forum_user,
		long id_forum, String status, OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = findByPrimaryKey(id_forum_user);

		Session session = null;

		try {
			session = openSession();

			ForumUser[] array = new ForumUserImpl[3];

			array[0] = getByIdForumStatus_PrevAndNext(session, forumUser,
					id_forum, status, orderByComparator, true);

			array[1] = forumUser;

			array[2] = getByIdForumStatus_PrevAndNext(session, forumUser,
					id_forum, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumUser getByIdForumStatus_PrevAndNext(Session session,
		ForumUser forumUser, long id_forum, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMUSER_WHERE);

		query.append(_FINDER_COLUMN_IDFORUMSTATUS_ID_FORUM_2);

		if (status == null) {
			query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_1);
		}
		else {
			if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_3);
			}
			else {
				query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_2);
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
			query.append(ForumUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_forum);

		if (status != null) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public List<ForumUser> findByIdForumUserIdStatus(long id_forum,
		long user_id, String status) throws SystemException {
		return findByIdForumUserIdStatus(id_forum, user_id, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumUser> findByIdForumUserIdStatus(long id_forum,
		long user_id, String status, int start, int end)
		throws SystemException {
		return findByIdForumUserIdStatus(id_forum, user_id, status, start, end,
			null);
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
	public List<ForumUser> findByIdForumUserIdStatus(long id_forum,
		long user_id, String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS;
			finderArgs = new Object[] { id_forum, user_id, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMUSERIDSTATUS;
			finderArgs = new Object[] {
					id_forum, user_id, status,
					
					start, end, orderByComparator
				};
		}

		List<ForumUser> list = (List<ForumUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumUser forumUser : list) {
				if ((id_forum != forumUser.getId_forum()) ||
						(user_id != forumUser.getUser_id()) ||
						!Validator.equals(status, forumUser.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_ID_FORUM_2);

			query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_USER_ID_2);

			if (status == null) {
				query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				qPos.add(user_id);

				if (status != null) {
					qPos.add(status);
				}

				list = (List<ForumUser>)QueryUtil.list(q, getDialect(), start,
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
	public ForumUser findByIdForumUserIdStatus_First(long id_forum,
		long user_id, String status, OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByIdForumUserIdStatus_First(id_forum,
				user_id, status, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", user_id=");
		msg.append(user_id);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
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
	public ForumUser fetchByIdForumUserIdStatus_First(long id_forum,
		long user_id, String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<ForumUser> list = findByIdForumUserIdStatus(id_forum, user_id,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser findByIdForumUserIdStatus_Last(long id_forum,
		long user_id, String status, OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = fetchByIdForumUserIdStatus_Last(id_forum,
				user_id, status, orderByComparator);

		if (forumUser != null) {
			return forumUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", user_id=");
		msg.append(user_id);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumUserException(msg.toString());
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
	public ForumUser fetchByIdForumUserIdStatus_Last(long id_forum,
		long user_id, String status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByIdForumUserIdStatus(id_forum, user_id, status);

		List<ForumUser> list = findByIdForumUserIdStatus(id_forum, user_id,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumUser[] findByIdForumUserIdStatus_PrevAndNext(
		long id_forum_user, long id_forum, long user_id, String status,
		OrderByComparator orderByComparator)
		throws NoSuchForumUserException, SystemException {
		ForumUser forumUser = findByPrimaryKey(id_forum_user);

		Session session = null;

		try {
			session = openSession();

			ForumUser[] array = new ForumUserImpl[3];

			array[0] = getByIdForumUserIdStatus_PrevAndNext(session, forumUser,
					id_forum, user_id, status, orderByComparator, true);

			array[1] = forumUser;

			array[2] = getByIdForumUserIdStatus_PrevAndNext(session, forumUser,
					id_forum, user_id, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumUser getByIdForumUserIdStatus_PrevAndNext(Session session,
		ForumUser forumUser, long id_forum, long user_id, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMUSER_WHERE);

		query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_ID_FORUM_2);

		query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_USER_ID_2);

		if (status == null) {
			query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_1);
		}
		else {
			if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_3);
			}
			else {
				query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_2);
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
			query.append(ForumUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_forum);

		qPos.add(user_id);

		if (status != null) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum users.
	 *
	 * @return the forum users
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ForumUser> findAll(int start, int end,
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

		List<ForumUser> list = (List<ForumUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORUMUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORUMUSER.concat(ForumUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ForumUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ForumUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the forum users where id_forum = &#63; from the database.
	 *
	 * @param id_forum the id_forum
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdForum(long id_forum) throws SystemException {
		for (ForumUser forumUser : findByIdForum(id_forum)) {
			remove(forumUser);
		}
	}

	/**
	 * Removes all the forum users where user_id = &#63; from the database.
	 *
	 * @param user_id the user_id
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long user_id) throws SystemException {
		for (ForumUser forumUser : findByUserId(user_id)) {
			remove(forumUser);
		}
	}

	/**
	 * Removes all the forum users where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(String status) throws SystemException {
		for (ForumUser forumUser : findByStatus(status)) {
			remove(forumUser);
		}
	}

	/**
	 * Removes all the forum users where id_forum = &#63; and status = &#63; from the database.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdForumStatus(long id_forum, String status)
		throws SystemException {
		for (ForumUser forumUser : findByIdForumStatus(id_forum, status)) {
			remove(forumUser);
		}
	}

	/**
	 * Removes all the forum users where id_forum = &#63; and user_id = &#63; and status = &#63; from the database.
	 *
	 * @param id_forum the id_forum
	 * @param user_id the user_id
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdForumUserIdStatus(long id_forum, long user_id,
		String status) throws SystemException {
		for (ForumUser forumUser : findByIdForumUserIdStatus(id_forum, user_id,
				status)) {
			remove(forumUser);
		}
	}

	/**
	 * Removes all the forum users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ForumUser forumUser : findAll()) {
			remove(forumUser);
		}
	}

	/**
	 * Returns the number of forum users where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @return the number of matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdForum(long id_forum) throws SystemException {
		Object[] finderArgs = new Object[] { id_forum };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDFORUM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_IDFORUM_ID_FORUM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDFORUM,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum users where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the number of matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long user_id) throws SystemException {
		Object[] finderArgs = new Object[] { user_id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMUSER_WHERE);

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
	 * Returns the number of forum users where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(String status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMUSER_WHERE);

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_STATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_STATUS_STATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum users where id_forum = &#63; and status = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @return the number of matching forum users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdForumStatus(long id_forum, String status)
		throws SystemException {
		Object[] finderArgs = new Object[] { id_forum, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_IDFORUMSTATUS_ID_FORUM_2);

			if (status == null) {
				query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_IDFORUMSTATUS_STATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByIdForumUserIdStatus(long id_forum, long user_id,
		String status) throws SystemException {
		Object[] finderArgs = new Object[] { id_forum, user_id, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDFORUMUSERIDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FORUMUSER_WHERE);

			query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_ID_FORUM_2);

			query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_USER_ID_2);

			if (status == null) {
				query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				qPos.add(user_id);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDFORUMUSERIDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum users.
	 *
	 * @return the number of forum users
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORUMUSER);

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
	 * Initializes the forum user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.appuntivari.forum.model.ForumUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ForumUser>> listenersList = new ArrayList<ModelListener<ForumUser>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<ForumUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ForumUserImpl.class.getName());
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
	private static final String _SQL_SELECT_FORUMUSER = "SELECT forumUser FROM ForumUser forumUser";
	private static final String _SQL_SELECT_FORUMUSER_WHERE = "SELECT forumUser FROM ForumUser forumUser WHERE ";
	private static final String _SQL_COUNT_FORUMUSER = "SELECT COUNT(forumUser) FROM ForumUser forumUser";
	private static final String _SQL_COUNT_FORUMUSER_WHERE = "SELECT COUNT(forumUser) FROM ForumUser forumUser WHERE ";
	private static final String _FINDER_COLUMN_IDFORUM_ID_FORUM_2 = "forumUser.id_forum = ?";
	private static final String _FINDER_COLUMN_USERID_USER_ID_2 = "forumUser.user_id = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "forumUser.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "forumUser.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(forumUser.status IS NULL OR forumUser.status = ?)";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_ID_FORUM_2 = "forumUser.id_forum = ? AND ";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_STATUS_1 = "forumUser.status IS NULL";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_STATUS_2 = "forumUser.status = ?";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_STATUS_3 = "(forumUser.status IS NULL OR forumUser.status = ?)";
	private static final String _FINDER_COLUMN_IDFORUMUSERIDSTATUS_ID_FORUM_2 = "forumUser.id_forum = ? AND ";
	private static final String _FINDER_COLUMN_IDFORUMUSERIDSTATUS_USER_ID_2 = "forumUser.user_id = ? AND ";
	private static final String _FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_1 = "forumUser.status IS NULL";
	private static final String _FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_2 = "forumUser.status = ?";
	private static final String _FINDER_COLUMN_IDFORUMUSERIDSTATUS_STATUS_3 = "(forumUser.status IS NULL OR forumUser.status = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "forumUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ForumUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ForumUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ForumUserPersistenceImpl.class);
	private static ForumUser _nullForumUser = new ForumUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ForumUser> toCacheModel() {
				return _nullForumUserCacheModel;
			}
		};

	private static CacheModel<ForumUser> _nullForumUserCacheModel = new CacheModel<ForumUser>() {
			public ForumUser toEntityModel() {
				return _nullForumUser;
			}
		};
}