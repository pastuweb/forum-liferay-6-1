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
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import net.appuntivari.forum.model.ForumCategoryClp;
import net.appuntivari.forum.model.ForumClp;
import net.appuntivari.forum.model.ForumPostClp;
import net.appuntivari.forum.model.ForumUserClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"MyForum-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"MyForum-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "MyForum-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ForumClp.class.getName())) {
			return translateInputForum(oldModel);
		}

		if (oldModelClassName.equals(ForumCategoryClp.class.getName())) {
			return translateInputForumCategory(oldModel);
		}

		if (oldModelClassName.equals(ForumPostClp.class.getName())) {
			return translateInputForumPost(oldModel);
		}

		if (oldModelClassName.equals(ForumUserClp.class.getName())) {
			return translateInputForumUser(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputForum(BaseModel<?> oldModel) {
		ForumClp oldClpModel = (ForumClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getForumRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputForumCategory(BaseModel<?> oldModel) {
		ForumCategoryClp oldClpModel = (ForumCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getForumCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputForumPost(BaseModel<?> oldModel) {
		ForumPostClp oldClpModel = (ForumPostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getForumPostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputForumUser(BaseModel<?> oldModel) {
		ForumUserClp oldClpModel = (ForumUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getForumUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"net.appuntivari.forum.model.impl.ForumImpl")) {
			return translateOutputForum(oldModel);
		}

		if (oldModelClassName.equals(
					"net.appuntivari.forum.model.impl.ForumCategoryImpl")) {
			return translateOutputForumCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"net.appuntivari.forum.model.impl.ForumPostImpl")) {
			return translateOutputForumPost(oldModel);
		}

		if (oldModelClassName.equals(
					"net.appuntivari.forum.model.impl.ForumUserImpl")) {
			return translateOutputForumUser(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("net.appuntivari.forum.NoSuchForumException")) {
			return new net.appuntivari.forum.NoSuchForumException();
		}

		if (className.equals(
					"net.appuntivari.forum.NoSuchForumCategoryException")) {
			return new net.appuntivari.forum.NoSuchForumCategoryException();
		}

		if (className.equals("net.appuntivari.forum.NoSuchForumPostException")) {
			return new net.appuntivari.forum.NoSuchForumPostException();
		}

		if (className.equals("net.appuntivari.forum.NoSuchForumUserException")) {
			return new net.appuntivari.forum.NoSuchForumUserException();
		}

		return throwable;
	}

	public static Object translateOutputForum(BaseModel<?> oldModel) {
		ForumClp newModel = new ForumClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setForumRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputForumCategory(BaseModel<?> oldModel) {
		ForumCategoryClp newModel = new ForumCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setForumCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputForumPost(BaseModel<?> oldModel) {
		ForumPostClp newModel = new ForumPostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setForumPostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputForumUser(BaseModel<?> oldModel) {
		ForumUserClp newModel = new ForumUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setForumUserRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}