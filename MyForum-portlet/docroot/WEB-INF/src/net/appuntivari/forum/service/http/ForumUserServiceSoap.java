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

import net.appuntivari.forum.service.ForumUserServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link net.appuntivari.forum.service.ForumUserServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link net.appuntivari.forum.model.ForumUserSoap}.
 * If the method in the service utility returns a
 * {@link net.appuntivari.forum.model.ForumUser}, that is translated to a
 * {@link net.appuntivari.forum.model.ForumUserSoap}. Methods that SOAP cannot
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
 * @see       ForumUserServiceHttp
 * @see       net.appuntivari.forum.model.ForumUserSoap
 * @see       net.appuntivari.forum.service.ForumUserServiceUtil
 * @generated
 */
public class ForumUserServiceSoap {
	public static net.appuntivari.forum.model.ForumUserSoap getForumUserById(
		long id_forum_user) throws RemoteException {
		try {
			net.appuntivari.forum.model.ForumUser returnValue = ForumUserServiceUtil.getForumUserById(id_forum_user);

			return net.appuntivari.forum.model.ForumUserSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumUserSoap[] getForumUser()
		throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumUser> returnValue = ForumUserServiceUtil.getForumUser();

			return net.appuntivari.forum.model.ForumUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumUserSoap[] getForumUserByIdForum(
		long id_forum) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumUser> returnValue = ForumUserServiceUtil.getForumUserByIdForum(id_forum);

			return net.appuntivari.forum.model.ForumUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumUserSoap[] getForumUserByIdForumStatus(
		long id_forum, boolean status) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumUser> returnValue = ForumUserServiceUtil.getForumUserByIdForumStatus(id_forum,
					status);

			return net.appuntivari.forum.model.ForumUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumUserSoap[] getForumUserByStatus(
		boolean status) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumUser> returnValue = ForumUserServiceUtil.getForumUserByStatus(status);

			return net.appuntivari.forum.model.ForumUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumUserSoap[] getForumUserByUserId(
		long userid) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumUser> returnValue = ForumUserServiceUtil.getForumUserByUserId(userid);

			return net.appuntivari.forum.model.ForumUserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ForumUserServiceSoap.class);
}