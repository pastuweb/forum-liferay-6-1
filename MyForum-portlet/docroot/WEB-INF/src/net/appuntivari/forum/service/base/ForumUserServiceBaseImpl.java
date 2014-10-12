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

package net.appuntivari.forum.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import net.appuntivari.forum.model.ForumUser;
import net.appuntivari.forum.service.ForumCategoryLocalService;
import net.appuntivari.forum.service.ForumCategoryService;
import net.appuntivari.forum.service.ForumLocalService;
import net.appuntivari.forum.service.ForumPostLocalService;
import net.appuntivari.forum.service.ForumPostService;
import net.appuntivari.forum.service.ForumService;
import net.appuntivari.forum.service.ForumUserLocalService;
import net.appuntivari.forum.service.ForumUserService;
import net.appuntivari.forum.service.persistence.ForumCategoryPersistence;
import net.appuntivari.forum.service.persistence.ForumPersistence;
import net.appuntivari.forum.service.persistence.ForumPostPersistence;
import net.appuntivari.forum.service.persistence.ForumUserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the forum user remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.appuntivari.forum.service.impl.ForumUserServiceImpl}.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see net.appuntivari.forum.service.impl.ForumUserServiceImpl
 * @see net.appuntivari.forum.service.ForumUserServiceUtil
 * @generated
 */
public abstract class ForumUserServiceBaseImpl extends BaseServiceImpl
	implements ForumUserService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link net.appuntivari.forum.service.ForumUserServiceUtil} to access the forum user remote service.
	 */

	/**
	 * Returns the forum local service.
	 *
	 * @return the forum local service
	 */
	public ForumLocalService getForumLocalService() {
		return forumLocalService;
	}

	/**
	 * Sets the forum local service.
	 *
	 * @param forumLocalService the forum local service
	 */
	public void setForumLocalService(ForumLocalService forumLocalService) {
		this.forumLocalService = forumLocalService;
	}

	/**
	 * Returns the forum remote service.
	 *
	 * @return the forum remote service
	 */
	public ForumService getForumService() {
		return forumService;
	}

	/**
	 * Sets the forum remote service.
	 *
	 * @param forumService the forum remote service
	 */
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	/**
	 * Returns the forum persistence.
	 *
	 * @return the forum persistence
	 */
	public ForumPersistence getForumPersistence() {
		return forumPersistence;
	}

	/**
	 * Sets the forum persistence.
	 *
	 * @param forumPersistence the forum persistence
	 */
	public void setForumPersistence(ForumPersistence forumPersistence) {
		this.forumPersistence = forumPersistence;
	}

	/**
	 * Returns the forum category local service.
	 *
	 * @return the forum category local service
	 */
	public ForumCategoryLocalService getForumCategoryLocalService() {
		return forumCategoryLocalService;
	}

	/**
	 * Sets the forum category local service.
	 *
	 * @param forumCategoryLocalService the forum category local service
	 */
	public void setForumCategoryLocalService(
		ForumCategoryLocalService forumCategoryLocalService) {
		this.forumCategoryLocalService = forumCategoryLocalService;
	}

	/**
	 * Returns the forum category remote service.
	 *
	 * @return the forum category remote service
	 */
	public ForumCategoryService getForumCategoryService() {
		return forumCategoryService;
	}

	/**
	 * Sets the forum category remote service.
	 *
	 * @param forumCategoryService the forum category remote service
	 */
	public void setForumCategoryService(
		ForumCategoryService forumCategoryService) {
		this.forumCategoryService = forumCategoryService;
	}

	/**
	 * Returns the forum category persistence.
	 *
	 * @return the forum category persistence
	 */
	public ForumCategoryPersistence getForumCategoryPersistence() {
		return forumCategoryPersistence;
	}

	/**
	 * Sets the forum category persistence.
	 *
	 * @param forumCategoryPersistence the forum category persistence
	 */
	public void setForumCategoryPersistence(
		ForumCategoryPersistence forumCategoryPersistence) {
		this.forumCategoryPersistence = forumCategoryPersistence;
	}

	/**
	 * Returns the forum post local service.
	 *
	 * @return the forum post local service
	 */
	public ForumPostLocalService getForumPostLocalService() {
		return forumPostLocalService;
	}

	/**
	 * Sets the forum post local service.
	 *
	 * @param forumPostLocalService the forum post local service
	 */
	public void setForumPostLocalService(
		ForumPostLocalService forumPostLocalService) {
		this.forumPostLocalService = forumPostLocalService;
	}

	/**
	 * Returns the forum post remote service.
	 *
	 * @return the forum post remote service
	 */
	public ForumPostService getForumPostService() {
		return forumPostService;
	}

	/**
	 * Sets the forum post remote service.
	 *
	 * @param forumPostService the forum post remote service
	 */
	public void setForumPostService(ForumPostService forumPostService) {
		this.forumPostService = forumPostService;
	}

	/**
	 * Returns the forum post persistence.
	 *
	 * @return the forum post persistence
	 */
	public ForumPostPersistence getForumPostPersistence() {
		return forumPostPersistence;
	}

	/**
	 * Sets the forum post persistence.
	 *
	 * @param forumPostPersistence the forum post persistence
	 */
	public void setForumPostPersistence(
		ForumPostPersistence forumPostPersistence) {
		this.forumPostPersistence = forumPostPersistence;
	}

	/**
	 * Returns the forum user local service.
	 *
	 * @return the forum user local service
	 */
	public ForumUserLocalService getForumUserLocalService() {
		return forumUserLocalService;
	}

	/**
	 * Sets the forum user local service.
	 *
	 * @param forumUserLocalService the forum user local service
	 */
	public void setForumUserLocalService(
		ForumUserLocalService forumUserLocalService) {
		this.forumUserLocalService = forumUserLocalService;
	}

	/**
	 * Returns the forum user remote service.
	 *
	 * @return the forum user remote service
	 */
	public ForumUserService getForumUserService() {
		return forumUserService;
	}

	/**
	 * Sets the forum user remote service.
	 *
	 * @param forumUserService the forum user remote service
	 */
	public void setForumUserService(ForumUserService forumUserService) {
		this.forumUserService = forumUserService;
	}

	/**
	 * Returns the forum user persistence.
	 *
	 * @return the forum user persistence
	 */
	public ForumUserPersistence getForumUserPersistence() {
		return forumUserPersistence;
	}

	/**
	 * Sets the forum user persistence.
	 *
	 * @param forumUserPersistence the forum user persistence
	 */
	public void setForumUserPersistence(
		ForumUserPersistence forumUserPersistence) {
		this.forumUserPersistence = forumUserPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return ForumUser.class;
	}

	protected String getModelClassName() {
		return ForumUser.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = forumUserPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ForumLocalService.class)
	protected ForumLocalService forumLocalService;
	@BeanReference(type = ForumService.class)
	protected ForumService forumService;
	@BeanReference(type = ForumPersistence.class)
	protected ForumPersistence forumPersistence;
	@BeanReference(type = ForumCategoryLocalService.class)
	protected ForumCategoryLocalService forumCategoryLocalService;
	@BeanReference(type = ForumCategoryService.class)
	protected ForumCategoryService forumCategoryService;
	@BeanReference(type = ForumCategoryPersistence.class)
	protected ForumCategoryPersistence forumCategoryPersistence;
	@BeanReference(type = ForumPostLocalService.class)
	protected ForumPostLocalService forumPostLocalService;
	@BeanReference(type = ForumPostService.class)
	protected ForumPostService forumPostService;
	@BeanReference(type = ForumPostPersistence.class)
	protected ForumPostPersistence forumPostPersistence;
	@BeanReference(type = ForumUserLocalService.class)
	protected ForumUserLocalService forumUserLocalService;
	@BeanReference(type = ForumUserService.class)
	protected ForumUserService forumUserService;
	@BeanReference(type = ForumUserPersistence.class)
	protected ForumUserPersistence forumUserPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ForumUserServiceClpInvoker _clpInvoker = new ForumUserServiceClpInvoker();
}