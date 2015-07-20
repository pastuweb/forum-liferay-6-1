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
 * The interface for the forum remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumServiceUtil
 * @see net.appuntivari.forum.service.base.ForumServiceBaseImpl
 * @see net.appuntivari.forum.service.impl.ForumServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ForumService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ForumServiceUtil} to access the forum remote service. Add custom service methods to {@link net.appuntivari.forum.service.impl.ForumServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	public net.appuntivari.forum.model.Forum getForumById(long id_forum);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.Forum> getForum(
		long id_forum);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.Forum> getForumByCompanyId(
		long company_id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.Forum> getForumByOwner(
		long userid_creator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<net.appuntivari.forum.model.Forum> getForumByOwnerStatus(
		long userid_creator, boolean status);
}