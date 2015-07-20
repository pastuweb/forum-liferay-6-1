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

package net.appuntivari.forum.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.appuntivari.forum.service.ClpSerializer;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pasturenzi Francesco
 */
public class ForumUserClp extends BaseModelImpl<ForumUser> implements ForumUser {
	public ForumUserClp() {
	}

	public Class<?> getModelClass() {
		return ForumUser.class;
	}

	public String getModelClassName() {
		return ForumUser.class.getName();
	}

	public long getPrimaryKey() {
		return _id_forum_user;
	}

	public void setPrimaryKey(long primaryKey) {
		setId_forum_user(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id_forum_user);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_forum_user", getId_forum_user());
		attributes.put("id_forum", getId_forum());
		attributes.put("user_id", getUser_id());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_forum_user = (Long)attributes.get("id_forum_user");

		if (id_forum_user != null) {
			setId_forum_user(id_forum_user);
		}

		Long id_forum = (Long)attributes.get("id_forum");

		if (id_forum != null) {
			setId_forum(id_forum);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getId_forum_user() {
		return _id_forum_user;
	}

	public void setId_forum_user(long id_forum_user) {
		_id_forum_user = id_forum_user;

		if (_forumUserRemoteModel != null) {
			try {
				Class<?> clazz = _forumUserRemoteModel.getClass();

				Method method = clazz.getMethod("setId_forum_user", long.class);

				method.invoke(_forumUserRemoteModel, id_forum_user);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getId_forum() {
		return _id_forum;
	}

	public void setId_forum(long id_forum) {
		_id_forum = id_forum;

		if (_forumUserRemoteModel != null) {
			try {
				Class<?> clazz = _forumUserRemoteModel.getClass();

				Method method = clazz.getMethod("setId_forum", long.class);

				method.invoke(_forumUserRemoteModel, id_forum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;

		if (_forumUserRemoteModel != null) {
			try {
				Class<?> clazz = _forumUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUser_id", long.class);

				method.invoke(_forumUserRemoteModel, user_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;

		if (_forumUserRemoteModel != null) {
			try {
				Class<?> clazz = _forumUserRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_forumUserRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getForumUserRemoteModel() {
		return _forumUserRemoteModel;
	}

	public void setForumUserRemoteModel(BaseModel<?> forumUserRemoteModel) {
		_forumUserRemoteModel = forumUserRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _forumUserRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_forumUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ForumUserLocalServiceUtil.addForumUser(this);
		}
		else {
			ForumUserLocalServiceUtil.updateForumUser(this);
		}
	}

	@Override
	public ForumUser toEscapedModel() {
		return (ForumUser)ProxyUtil.newProxyInstance(ForumUser.class.getClassLoader(),
			new Class[] { ForumUser.class }, new AutoEscapeBeanHandler(this));
	}

	public ForumUser toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ForumUserClp clone = new ForumUserClp();

		clone.setId_forum_user(getId_forum_user());
		clone.setId_forum(getId_forum());
		clone.setUser_id(getUser_id());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ForumUser forumUser) {
		int value = 0;

		if (getId_forum_user() < forumUser.getId_forum_user()) {
			value = -1;
		}
		else if (getId_forum_user() > forumUser.getId_forum_user()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ForumUserClp)) {
			return false;
		}

		ForumUserClp forumUser = (ForumUserClp)obj;

		long primaryKey = forumUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_forum_user=");
		sb.append(getId_forum_user());
		sb.append(", id_forum=");
		sb.append(getId_forum());
		sb.append(", user_id=");
		sb.append(getUser_id());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("net.appuntivari.forum.model.ForumUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_forum_user</column-name><column-value><![CDATA[");
		sb.append(getId_forum_user());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_forum</column-name><column-value><![CDATA[");
		sb.append(getId_forum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_forum_user;
	private long _id_forum;
	private long _user_id;
	private String _status;
	private BaseModel<?> _forumUserRemoteModel;
}