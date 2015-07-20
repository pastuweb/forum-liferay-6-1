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

package net.appuntivari.forum.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the forum post remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPostServiceUtil
 * @see net.appuntivari.forum.service.base.ForumPostServiceBaseImpl
 * @see net.appuntivari.forum.service.impl.ForumPostServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ForumPostService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ForumPostServiceUtil} to access the forum post remote service. Add custom service methods to {@link net.appuntivari.forum.service.impl.ForumPostServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public net.appuntivari.forum.model.ForumPost getForumPostById(long id_post);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPost();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdCategory(
		long id_category);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdCategoryUserId(
		long id_category, long user_id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByIdPostParent(
		long id_post);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByUserId(
		long user_id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.ForumPost> getForumPostByUserIdParent(
		long user_id_post_parent);
}