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

import net.appuntivari.forum.service.ForumCategoryServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link net.appuntivari.forum.service.ForumCategoryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link net.appuntivari.forum.model.ForumCategorySoap}.
 * If the method in the service utility returns a
 * {@link net.appuntivari.forum.model.ForumCategory}, that is translated to a
 * {@link net.appuntivari.forum.model.ForumCategorySoap}. Methods that SOAP cannot
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
 * @see       ForumCategoryServiceHttp
 * @see       net.appuntivari.forum.model.ForumCategorySoap
 * @see       net.appuntivari.forum.service.ForumCategoryServiceUtil
 * @generated
 */
public class ForumCategoryServiceSoap {
	public static net.appuntivari.forum.model.ForumCategorySoap getForumCategoryById(
		long id_category) throws RemoteException {
		try {
			net.appuntivari.forum.model.ForumCategory returnValue = ForumCategoryServiceUtil.getForumCategoryById(id_category);

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumCategorySoap[] getForumCategory()
		throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumCategory> returnValue =
				ForumCategoryServiceUtil.getForumCategory();

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumCategorySoap[] getForumCategoryByIdForum(
		long id_forum) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumCategory> returnValue =
				ForumCategoryServiceUtil.getForumCategoryByIdForum(id_forum);

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumCategorySoap[] getForumCategoryByIdForumStatus(
		long id_forum, boolean status) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumCategory> returnValue =
				ForumCategoryServiceUtil.getForumCategoryByIdForumStatus(id_forum,
					status);

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumCategorySoap[] getForumCategoryByOwner(
		long userid_creator) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumCategory> returnValue =
				ForumCategoryServiceUtil.getForumCategoryByOwner(userid_creator);

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumCategorySoap[] getForumCategoryByTitle(
		java.lang.String title) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumCategory> returnValue =
				ForumCategoryServiceUtil.getForumCategoryByTitle(title);

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static net.appuntivari.forum.model.ForumCategorySoap[] getForumCategoryByIdForumCategoryParent(
		long id_forum, long id_category_parent) throws RemoteException {
		try {
			java.util.List<net.appuntivari.forum.model.ForumCategory> returnValue =
				ForumCategoryServiceUtil.getForumCategoryByIdForumCategoryParent(id_forum,
					id_category_parent);

			return net.appuntivari.forum.model.ForumCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ForumCategoryServiceSoap.class);
}