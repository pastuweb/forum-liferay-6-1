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

import net.appuntivari.forum.NoSuchForumCategoryException;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.impl.ForumCategoryImpl;
import net.appuntivari.forum.model.impl.ForumCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the forum category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumCategoryPersistence
 * @see ForumCategoryUtil
 * @generated
 */
public class ForumCategoryPersistenceImpl extends BasePersistenceImpl<ForumCategory>
	implements ForumCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ForumCategoryUtil} to access the forum category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ForumCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMESTAMP =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTimestamp",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTimestamp", new String[] { Date.class.getName() },
			ForumCategoryModelImpl.TIMESTAMP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMESTAMP = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimestamp",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTitle", new String[] { String.class.getName() },
			ForumCategoryModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUM = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdForum",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdForum", new String[] { Long.class.getName() },
			ForumCategoryModelImpl.ID_FORUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDFORUM = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdForum",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdForumIdCategoryParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdForumIdCategoryParent",
			new String[] { Long.class.getName(), Long.class.getName() },
			ForumCategoryModelImpl.ID_FORUM_COLUMN_BITMASK |
			ForumCategoryModelImpl.ID_CATEGORY_PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDFORUMIDCATEGORYPARENT = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdForumIdCategoryParent",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCREATOR =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdCreator",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdCreator", new String[] { Long.class.getName() },
			ForumCategoryModelImpl.USER_ID_CREATOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCREATOR = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdCreator",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMSTATUS =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdForumStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS =
		new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdForumStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			ForumCategoryModelImpl.ID_FORUM_COLUMN_BITMASK |
			ForumCategoryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDFORUMSTATUS = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdForumStatus",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED,
			ForumCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the forum category in the entity cache if it is enabled.
	 *
	 * @param forumCategory the forum category
	 */
	public void cacheResult(ForumCategory forumCategory) {
		EntityCacheUtil.putResult(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryImpl.class, forumCategory.getPrimaryKey(),
			forumCategory);

		forumCategory.resetOriginalValues();
	}

	/**
	 * Caches the forum categories in the entity cache if it is enabled.
	 *
	 * @param forumCategories the forum categories
	 */
	public void cacheResult(List<ForumCategory> forumCategories) {
		for (ForumCategory forumCategory : forumCategories) {
			if (EntityCacheUtil.getResult(
						ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ForumCategoryImpl.class, forumCategory.getPrimaryKey()) == null) {
				cacheResult(forumCategory);
			}
			else {
				forumCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all forum categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ForumCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ForumCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the forum category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ForumCategory forumCategory) {
		EntityCacheUtil.removeResult(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryImpl.class, forumCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ForumCategory> forumCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ForumCategory forumCategory : forumCategories) {
			EntityCacheUtil.removeResult(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ForumCategoryImpl.class, forumCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new forum category with the primary key. Does not add the forum category to the database.
	 *
	 * @param id_category the primary key for the new forum category
	 * @return the new forum category
	 */
	public ForumCategory create(long id_category) {
		ForumCategory forumCategory = new ForumCategoryImpl();

		forumCategory.setNew(true);
		forumCategory.setPrimaryKey(id_category);

		return forumCategory;
	}

	/**
	 * Removes the forum category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_category the primary key of the forum category
	 * @return the forum category that was removed
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory remove(long id_category)
		throws NoSuchForumCategoryException, SystemException {
		return remove(Long.valueOf(id_category));
	}

	/**
	 * Removes the forum category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the forum category
	 * @return the forum category that was removed
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumCategory remove(Serializable primaryKey)
		throws NoSuchForumCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ForumCategory forumCategory = (ForumCategory)session.get(ForumCategoryImpl.class,
					primaryKey);

			if (forumCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchForumCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(forumCategory);
		}
		catch (NoSuchForumCategoryException nsee) {
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
	protected ForumCategory removeImpl(ForumCategory forumCategory)
		throws SystemException {
		forumCategory = toUnwrappedModel(forumCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, forumCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(forumCategory);

		return forumCategory;
	}

	@Override
	public ForumCategory updateImpl(
		net.appuntivari.forum.model.ForumCategory forumCategory, boolean merge)
		throws SystemException {
		forumCategory = toUnwrappedModel(forumCategory);

		boolean isNew = forumCategory.isNew();

		ForumCategoryModelImpl forumCategoryModelImpl = (ForumCategoryModelImpl)forumCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, forumCategory, merge);

			forumCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ForumCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((forumCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						forumCategoryModelImpl.getOriginalTimestamp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP,
					args);

				args = new Object[] { forumCategoryModelImpl.getTimestamp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESTAMP,
					args);
			}

			if ((forumCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						forumCategoryModelImpl.getOriginalTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { forumCategoryModelImpl.getTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}

			if ((forumCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getOriginalId_forum())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM,
					args);

				args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getId_forum())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUM,
					args);
			}

			if ((forumCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getOriginalId_forum()),
						Long.valueOf(forumCategoryModelImpl.getOriginalId_category_parent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMIDCATEGORYPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT,
					args);

				args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getId_forum()),
						Long.valueOf(forumCategoryModelImpl.getId_category_parent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMIDCATEGORYPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT,
					args);
			}

			if ((forumCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getOriginalUser_id_creator())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR,
					args);

				args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getUser_id_creator())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCREATOR,
					args);
			}

			if ((forumCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getOriginalId_forum()),
						
						forumCategoryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(forumCategoryModelImpl.getId_forum()),
						
						forumCategoryModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ForumCategoryImpl.class, forumCategory.getPrimaryKey(),
			forumCategory);

		return forumCategory;
	}

	protected ForumCategory toUnwrappedModel(ForumCategory forumCategory) {
		if (forumCategory instanceof ForumCategoryImpl) {
			return forumCategory;
		}

		ForumCategoryImpl forumCategoryImpl = new ForumCategoryImpl();

		forumCategoryImpl.setNew(forumCategory.isNew());
		forumCategoryImpl.setPrimaryKey(forumCategory.getPrimaryKey());

		forumCategoryImpl.setId_category(forumCategory.getId_category());
		forumCategoryImpl.setTitle(forumCategory.getTitle());
		forumCategoryImpl.setDescription(forumCategory.getDescription());
		forumCategoryImpl.setId_forum(forumCategory.getId_forum());
		forumCategoryImpl.setId_category_parent(forumCategory.getId_category_parent());
		forumCategoryImpl.setTimestamp(forumCategory.getTimestamp());
		forumCategoryImpl.setUser_id_creator(forumCategory.getUser_id_creator());
		forumCategoryImpl.setStatus(forumCategory.getStatus());

		return forumCategoryImpl;
	}

	/**
	 * Returns the forum category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum category
	 * @return the forum category
	 * @throws com.liferay.portal.NoSuchModelException if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum category with the primary key or throws a {@link net.appuntivari.forum.NoSuchForumCategoryException} if it could not be found.
	 *
	 * @param id_category the primary key of the forum category
	 * @return the forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByPrimaryKey(long id_category)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByPrimaryKey(id_category);

		if (forumCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_category);
			}

			throw new NoSuchForumCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_category);
		}

		return forumCategory;
	}

	/**
	 * Returns the forum category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the forum category
	 * @return the forum category, or <code>null</code> if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ForumCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the forum category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_category the primary key of the forum category
	 * @return the forum category, or <code>null</code> if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByPrimaryKey(long id_category)
		throws SystemException {
		ForumCategory forumCategory = (ForumCategory)EntityCacheUtil.getResult(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ForumCategoryImpl.class, id_category);

		if (forumCategory == _nullForumCategory) {
			return null;
		}

		if (forumCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				forumCategory = (ForumCategory)session.get(ForumCategoryImpl.class,
						Long.valueOf(id_category));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (forumCategory != null) {
					cacheResult(forumCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ForumCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ForumCategoryImpl.class, id_category, _nullForumCategory);
				}

				closeSession(session);
			}
		}

		return forumCategory;
	}

	/**
	 * Returns all the forum categories where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByTimestamp(Date timestamp)
		throws SystemException {
		return findByTimestamp(timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<ForumCategory> findByTimestamp(Date timestamp, int start,
		int end) throws SystemException {
		return findByTimestamp(timestamp, start, end, null);
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
	public List<ForumCategory> findByTimestamp(Date timestamp, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumCategory forumCategory : list) {
				if (!Validator.equals(timestamp, forumCategory.getTimestamp())) {
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

			query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

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
				query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first forum category in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByTimestamp_First(Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByTimestamp_First(timestamp,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the first forum category in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByTimestamp_First(Date timestamp,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumCategory> list = findByTimestamp(timestamp, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory findByTimestamp_Last(Date timestamp,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByTimestamp_Last(timestamp,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the last forum category in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByTimestamp_Last(Date timestamp,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTimestamp(timestamp);

		List<ForumCategory> list = findByTimestamp(timestamp, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory[] findByTimestamp_PrevAndNext(long id_category,
		Date timestamp, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = findByPrimaryKey(id_category);

		Session session = null;

		try {
			session = openSession();

			ForumCategory[] array = new ForumCategoryImpl[3];

			array[0] = getByTimestamp_PrevAndNext(session, forumCategory,
					timestamp, orderByComparator, true);

			array[1] = forumCategory;

			array[2] = getByTimestamp_PrevAndNext(session, forumCategory,
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

	protected ForumCategory getByTimestamp_PrevAndNext(Session session,
		ForumCategory forumCategory, Date timestamp,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

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
			query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(forumCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum categories where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByTitle(String title)
		throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumCategory> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
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
	public List<ForumCategory> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumCategory forumCategory : list) {
				if (!Validator.equals(title, forumCategory.getTitle())) {
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

			query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first forum category in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByTitle_First(title,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the first forum category in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumCategory> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByTitle_Last(title, orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the last forum category in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		List<ForumCategory> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory[] findByTitle_PrevAndNext(long id_category,
		String title, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = findByPrimaryKey(id_category);

		Session session = null;

		try {
			session = openSession();

			ForumCategory[] array = new ForumCategoryImpl[3];

			array[0] = getByTitle_PrevAndNext(session, forumCategory, title,
					orderByComparator, true);

			array[1] = forumCategory;

			array[2] = getByTitle_PrevAndNext(session, forumCategory, title,
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

	protected ForumCategory getByTitle_PrevAndNext(Session session,
		ForumCategory forumCategory, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum categories where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @return the matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByIdForum(long id_forum)
		throws SystemException {
		return findByIdForum(id_forum, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<ForumCategory> findByIdForum(long id_forum, int start, int end)
		throws SystemException {
		return findByIdForum(id_forum, start, end, null);
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
	public List<ForumCategory> findByIdForum(long id_forum, int start, int end,
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

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumCategory forumCategory : list) {
				if ((id_forum != forumCategory.getId_forum())) {
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

			query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_IDFORUM_ID_FORUM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first forum category in the ordered set where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByIdForum_First(long id_forum,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByIdForum_First(id_forum,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the first forum category in the ordered set where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByIdForum_First(long id_forum,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumCategory> list = findByIdForum(id_forum, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory findByIdForum_Last(long id_forum,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByIdForum_Last(id_forum,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the last forum category in the ordered set where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByIdForum_Last(long id_forum,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIdForum(id_forum);

		List<ForumCategory> list = findByIdForum(id_forum, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory[] findByIdForum_PrevAndNext(long id_category,
		long id_forum, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = findByPrimaryKey(id_category);

		Session session = null;

		try {
			session = openSession();

			ForumCategory[] array = new ForumCategoryImpl[3];

			array[0] = getByIdForum_PrevAndNext(session, forumCategory,
					id_forum, orderByComparator, true);

			array[1] = forumCategory;

			array[2] = getByIdForum_PrevAndNext(session, forumCategory,
					id_forum, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ForumCategory getByIdForum_PrevAndNext(Session session,
		ForumCategory forumCategory, long id_forum,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

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
			query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_forum);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum categories where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @return the matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByIdForumIdCategoryParent(long id_forum,
		long id_category_parent) throws SystemException {
		return findByIdForumIdCategoryParent(id_forum, id_category_parent,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the forum categories where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param start the lower bound of the range of forum categories
	 * @param end the upper bound of the range of forum categories (not inclusive)
	 * @return the range of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByIdForumIdCategoryParent(long id_forum,
		long id_category_parent, int start, int end) throws SystemException {
		return findByIdForumIdCategoryParent(id_forum, id_category_parent,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the forum categories where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param start the lower bound of the range of forum categories
	 * @param end the upper bound of the range of forum categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByIdForumIdCategoryParent(long id_forum,
		long id_category_parent, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT;
			finderArgs = new Object[] { id_forum, id_category_parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDFORUMIDCATEGORYPARENT;
			finderArgs = new Object[] {
					id_forum, id_category_parent,
					
					start, end, orderByComparator
				};
		}

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumCategory forumCategory : list) {
				if ((id_forum != forumCategory.getId_forum()) ||
						(id_category_parent != forumCategory.getId_category_parent())) {
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

			query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_FORUM_2);

			query.append(_FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_CATEGORY_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				qPos.add(id_category_parent);

				list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first forum category in the ordered set where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByIdForumIdCategoryParent_First(long id_forum,
		long id_category_parent, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByIdForumIdCategoryParent_First(id_forum,
				id_category_parent, orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", id_category_parent=");
		msg.append(id_category_parent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the first forum category in the ordered set where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByIdForumIdCategoryParent_First(long id_forum,
		long id_category_parent, OrderByComparator orderByComparator)
		throws SystemException {
		List<ForumCategory> list = findByIdForumIdCategoryParent(id_forum,
				id_category_parent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forum category in the ordered set where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByIdForumIdCategoryParent_Last(long id_forum,
		long id_category_parent, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByIdForumIdCategoryParent_Last(id_forum,
				id_category_parent, orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", id_category_parent=");
		msg.append(id_category_parent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the last forum category in the ordered set where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByIdForumIdCategoryParent_Last(long id_forum,
		long id_category_parent, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByIdForumIdCategoryParent(id_forum, id_category_parent);

		List<ForumCategory> list = findByIdForumIdCategoryParent(id_forum,
				id_category_parent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the forum categories before and after the current forum category in the ordered set where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_category the primary key of the current forum category
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a forum category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory[] findByIdForumIdCategoryParent_PrevAndNext(
		long id_category, long id_forum, long id_category_parent,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = findByPrimaryKey(id_category);

		Session session = null;

		try {
			session = openSession();

			ForumCategory[] array = new ForumCategoryImpl[3];

			array[0] = getByIdForumIdCategoryParent_PrevAndNext(session,
					forumCategory, id_forum, id_category_parent,
					orderByComparator, true);

			array[1] = forumCategory;

			array[2] = getByIdForumIdCategoryParent_PrevAndNext(session,
					forumCategory, id_forum, id_category_parent,
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

	protected ForumCategory getByIdForumIdCategoryParent_PrevAndNext(
		Session session, ForumCategory forumCategory, long id_forum,
		long id_category_parent, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_FORUM_2);

		query.append(_FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_CATEGORY_PARENT_2);

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
			query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_forum);

		qPos.add(id_category_parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum categories where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @return the matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByUserIdCreator(long user_id_creator)
		throws SystemException {
		return findByUserIdCreator(user_id_creator, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ForumCategory> findByUserIdCreator(long user_id_creator,
		int start, int end) throws SystemException {
		return findByUserIdCreator(user_id_creator, start, end, null);
	}

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
	public List<ForumCategory> findByUserIdCreator(long user_id_creator,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumCategory forumCategory : list) {
				if ((user_id_creator != forumCategory.getUser_id_creator())) {
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

			query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_USERIDCREATOR_USER_ID_CREATOR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id_creator);

				list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first forum category in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByUserIdCreator_First(long user_id_creator,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByUserIdCreator_First(user_id_creator,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_creator=");
		msg.append(user_id_creator);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the first forum category in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByUserIdCreator_First(long user_id_creator,
		OrderByComparator orderByComparator) throws SystemException {
		List<ForumCategory> list = findByUserIdCreator(user_id_creator, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forum category in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByUserIdCreator_Last(long user_id_creator,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByUserIdCreator_Last(user_id_creator,
				orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id_creator=");
		msg.append(user_id_creator);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
	}

	/**
	 * Returns the last forum category in the ordered set where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forum category, or <code>null</code> if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory fetchByUserIdCreator_Last(long user_id_creator,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdCreator(user_id_creator);

		List<ForumCategory> list = findByUserIdCreator(user_id_creator,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public ForumCategory[] findByUserIdCreator_PrevAndNext(long id_category,
		long user_id_creator, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = findByPrimaryKey(id_category);

		Session session = null;

		try {
			session = openSession();

			ForumCategory[] array = new ForumCategoryImpl[3];

			array[0] = getByUserIdCreator_PrevAndNext(session, forumCategory,
					user_id_creator, orderByComparator, true);

			array[1] = forumCategory;

			array[2] = getByUserIdCreator_PrevAndNext(session, forumCategory,
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

	protected ForumCategory getByUserIdCreator_PrevAndNext(Session session,
		ForumCategory forumCategory, long user_id_creator,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

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
			query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id_creator);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(forumCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum categories where id_forum = &#63; and status = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @return the matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findByIdForumStatus(long id_forum, String status)
		throws SystemException {
		return findByIdForumStatus(id_forum, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<ForumCategory> findByIdForumStatus(long id_forum,
		String status, int start, int end) throws SystemException {
		return findByIdForumStatus(id_forum, status, start, end, null);
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
	public List<ForumCategory> findByIdForumStatus(long id_forum,
		String status, int start, int end, OrderByComparator orderByComparator)
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

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ForumCategory forumCategory : list) {
				if ((id_forum != forumCategory.getId_forum()) ||
						!Validator.equals(status, forumCategory.getStatus())) {
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

			query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

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
				query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first forum category in the ordered set where id_forum = &#63; and status = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forum category
	 * @throws net.appuntivari.forum.NoSuchForumCategoryException if a matching forum category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ForumCategory findByIdForumStatus_First(long id_forum,
		String status, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByIdForumStatus_First(id_forum,
				status, orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
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
	public ForumCategory fetchByIdForumStatus_First(long id_forum,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<ForumCategory> list = findByIdForumStatus(id_forum, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory findByIdForumStatus_Last(long id_forum, String status,
		OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = fetchByIdForumStatus_Last(id_forum,
				status, orderByComparator);

		if (forumCategory != null) {
			return forumCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_forum=");
		msg.append(id_forum);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForumCategoryException(msg.toString());
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
	public ForumCategory fetchByIdForumStatus_Last(long id_forum,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByIdForumStatus(id_forum, status);

		List<ForumCategory> list = findByIdForumStatus(id_forum, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ForumCategory[] findByIdForumStatus_PrevAndNext(long id_category,
		long id_forum, String status, OrderByComparator orderByComparator)
		throws NoSuchForumCategoryException, SystemException {
		ForumCategory forumCategory = findByPrimaryKey(id_category);

		Session session = null;

		try {
			session = openSession();

			ForumCategory[] array = new ForumCategoryImpl[3];

			array[0] = getByIdForumStatus_PrevAndNext(session, forumCategory,
					id_forum, status, orderByComparator, true);

			array[1] = forumCategory;

			array[2] = getByIdForumStatus_PrevAndNext(session, forumCategory,
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

	protected ForumCategory getByIdForumStatus_PrevAndNext(Session session,
		ForumCategory forumCategory, long id_forum, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORUMCATEGORY_WHERE);

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
			query.append(ForumCategoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(forumCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ForumCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the forum categories.
	 *
	 * @return the forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ForumCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ForumCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ForumCategory> findAll(int start, int end,
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

		List<ForumCategory> list = (List<ForumCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORUMCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORUMCATEGORY.concat(ForumCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ForumCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the forum categories where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTimestamp(Date timestamp) throws SystemException {
		for (ForumCategory forumCategory : findByTimestamp(timestamp)) {
			remove(forumCategory);
		}
	}

	/**
	 * Removes all the forum categories where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTitle(String title) throws SystemException {
		for (ForumCategory forumCategory : findByTitle(title)) {
			remove(forumCategory);
		}
	}

	/**
	 * Removes all the forum categories where id_forum = &#63; from the database.
	 *
	 * @param id_forum the id_forum
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdForum(long id_forum) throws SystemException {
		for (ForumCategory forumCategory : findByIdForum(id_forum)) {
			remove(forumCategory);
		}
	}

	/**
	 * Removes all the forum categories where id_forum = &#63; and id_category_parent = &#63; from the database.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdForumIdCategoryParent(long id_forum,
		long id_category_parent) throws SystemException {
		for (ForumCategory forumCategory : findByIdForumIdCategoryParent(
				id_forum, id_category_parent)) {
			remove(forumCategory);
		}
	}

	/**
	 * Removes all the forum categories where user_id_creator = &#63; from the database.
	 *
	 * @param user_id_creator the user_id_creator
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserIdCreator(long user_id_creator)
		throws SystemException {
		for (ForumCategory forumCategory : findByUserIdCreator(user_id_creator)) {
			remove(forumCategory);
		}
	}

	/**
	 * Removes all the forum categories where id_forum = &#63; and status = &#63; from the database.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdForumStatus(long id_forum, String status)
		throws SystemException {
		for (ForumCategory forumCategory : findByIdForumStatus(id_forum, status)) {
			remove(forumCategory);
		}
	}

	/**
	 * Removes all the forum categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ForumCategory forumCategory : findAll()) {
			remove(forumCategory);
		}
	}

	/**
	 * Returns the number of forum categories where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTimestamp(Date timestamp) throws SystemException {
		Object[] finderArgs = new Object[] { timestamp };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TIMESTAMP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMCATEGORY_WHERE);

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
	 * Returns the number of forum categories where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTitle(String title) throws SystemException {
		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMCATEGORY_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum categories where id_forum = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @return the number of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdForum(long id_forum) throws SystemException {
		Object[] finderArgs = new Object[] { id_forum };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDFORUM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMCATEGORY_WHERE);

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
	 * Returns the number of forum categories where id_forum = &#63; and id_category_parent = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param id_category_parent the id_category_parent
	 * @return the number of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdForumIdCategoryParent(long id_forum,
		long id_category_parent) throws SystemException {
		Object[] finderArgs = new Object[] { id_forum, id_category_parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDFORUMIDCATEGORYPARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FORUMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_FORUM_2);

			query.append(_FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_CATEGORY_PARENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_forum);

				qPos.add(id_category_parent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDFORUMIDCATEGORYPARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of forum categories where user_id_creator = &#63;.
	 *
	 * @param user_id_creator the user_id_creator
	 * @return the number of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdCreator(long user_id_creator)
		throws SystemException {
		Object[] finderArgs = new Object[] { user_id_creator };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDCREATOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORUMCATEGORY_WHERE);

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
	 * Returns the number of forum categories where id_forum = &#63; and status = &#63;.
	 *
	 * @param id_forum the id_forum
	 * @param status the status
	 * @return the number of matching forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdForumStatus(long id_forum, String status)
		throws SystemException {
		Object[] finderArgs = new Object[] { id_forum, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDFORUMSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FORUMCATEGORY_WHERE);

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
	 * Returns the number of forum categories.
	 *
	 * @return the number of forum categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORUMCATEGORY);

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
	 * Initializes the forum category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.appuntivari.forum.model.ForumCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ForumCategory>> listenersList = new ArrayList<ModelListener<ForumCategory>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<ForumCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ForumCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_FORUMCATEGORY = "SELECT forumCategory FROM ForumCategory forumCategory";
	private static final String _SQL_SELECT_FORUMCATEGORY_WHERE = "SELECT forumCategory FROM ForumCategory forumCategory WHERE ";
	private static final String _SQL_COUNT_FORUMCATEGORY = "SELECT COUNT(forumCategory) FROM ForumCategory forumCategory";
	private static final String _SQL_COUNT_FORUMCATEGORY_WHERE = "SELECT COUNT(forumCategory) FROM ForumCategory forumCategory WHERE ";
	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_1 = "forumCategory.timestamp IS NULL";
	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2 = "forumCategory.timestamp = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "forumCategory.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "forumCategory.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(forumCategory.title IS NULL OR forumCategory.title = ?)";
	private static final String _FINDER_COLUMN_IDFORUM_ID_FORUM_2 = "forumCategory.id_forum = ?";
	private static final String _FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_FORUM_2 =
		"forumCategory.id_forum = ? AND ";
	private static final String _FINDER_COLUMN_IDFORUMIDCATEGORYPARENT_ID_CATEGORY_PARENT_2 =
		"forumCategory.id_category_parent = ?";
	private static final String _FINDER_COLUMN_USERIDCREATOR_USER_ID_CREATOR_2 = "forumCategory.user_id_creator = ?";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_ID_FORUM_2 = "forumCategory.id_forum = ? AND ";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_STATUS_1 = "forumCategory.status IS NULL";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_STATUS_2 = "forumCategory.status = ?";
	private static final String _FINDER_COLUMN_IDFORUMSTATUS_STATUS_3 = "(forumCategory.status IS NULL OR forumCategory.status = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "forumCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ForumCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ForumCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ForumCategoryPersistenceImpl.class);
	private static ForumCategory _nullForumCategory = new ForumCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ForumCategory> toCacheModel() {
				return _nullForumCategoryCacheModel;
			}
		};

	private static CacheModel<ForumCategory> _nullForumCategoryCacheModel = new CacheModel<ForumCategory>() {
			public ForumCategory toEntityModel() {
				return _nullForumCategory;
			}
		};
}