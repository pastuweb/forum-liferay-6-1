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

package net.appuntivari.forum.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import net.appuntivari.forum.service.ForumPostServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link net.appuntivari.forum.service.ForumPostServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link net.appuntivari.forum.model.ForumPostSoap}.
 * If the method in the service utility returns a
 * {@link net.appuntivari.forum.model.ForumPost}, that is translated to a
 * {@link net.appuntivari.forum.model.ForumPostSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumPostServiceHttp
 * @see       net.appuntivari.forum.model.ForumPostSoap
 * @see       net.appuntivari.forum.service.ForumPostServiceUtil
 * @generated
 */
public class ForumPostServiceSoap {
	public static net.appuntivari.forum.model.ForumPostSoap getForumPostById(
		long id_post) throws RemoteException {
		try {
			net.appuntivari.forum.model.ForumPost returnValue = ForumPostServiceUtil.getForumPostById(id_post);

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumPostSoap[] getForumPost()
		throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumPost> returnValue = ForumPostServiceUtil.getForumPost();

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumPostSoap[] getForumPostByIdCategory(
		long id_category) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumPost> returnValue = ForumPostServiceUtil.getForumPostByIdCategory(id_category);

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumPostSoap[] getForumPostByIdCategoryUserId(
		long id_category, long user_id) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumPost> returnValue = ForumPostServiceUtil.getForumPostByIdCategoryUserId(id_category,
					user_id);

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumPostSoap[] getForumPostByIdPostParent(
		long id_post) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumPost> returnValue = ForumPostServiceUtil.getForumPostByIdPostParent(id_post);

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumPostSoap[] getForumPostByUserId(
		long user_id) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumPost> returnValue = ForumPostServiceUtil.getForumPostByUserId(user_id);

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumPostSoap[] getForumPostByUserIdParent(
		long user_id_post_parent) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumPost> returnValue = ForumPostServiceUtil.getForumPostByUserIdParent(user_id_post_parent);

			return net.appuntivari.forum.model.ForumPostSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ForumPostServiceSoap.class);
}