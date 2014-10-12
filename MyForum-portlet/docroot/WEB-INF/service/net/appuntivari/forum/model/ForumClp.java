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
import net.appuntivari.forum.service.ForumLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pasturenzi Francesco
 */
public class ForumClp extends BaseModelImpl<Forum> implements Forum {
	public ForumClp() {
	}

	public Class<?> getModelClass() {
		return Forum.class;
	}

	public String getModelClassName() {
		return Forum.class.getName();
	}

	public long getPrimaryKey() {
		return _id_forum;
	}

	public void setPrimaryKey(long primaryKey) {
		setId_forum(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id_forum);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_forum", getId_forum());
		attributes.put("description", getDescription());
		attributes.put("timestamp", getTimestamp());
		attributes.put("company_id", getCompany_id());
		attributes.put("create_user_id", getCreate_user_id());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_forum = (Long)attributes.get("id_forum");

		if (id_forum != null) {
			setId_forum(id_forum);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Long company_id = (Long)attributes.get("company_id");

		if (company_id != null) {
			setCompany_id(company_id);
		}

		Long create_user_id = (Long)attributes.get("create_user_id");

		if (create_user_id != null) {
			setCreate_user_id(create_user_id);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getId_forum() {
		return _id_forum;
	}

	public void setId_forum(long id_forum) {
		_id_forum = id_forum;

		if (_forumRemoteModel != null) {
			try {
				Class<?> clazz = _forumRemoteModel.getClass();

				Method method = clazz.getMethod("setId_forum", long.class);

				method.invoke(_forumRemoteModel, id_forum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;

		if (_forumRemoteModel != null) {
			try {
				Class<?> clazz = _forumRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_forumRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;

		if (_forumRemoteModel != null) {
			try {
				Class<?> clazz = _forumRemoteModel.getClass();

				Method method = clazz.getMethod("setTimestamp", Date.class);

				method.invoke(_forumRemoteModel, timestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCompany_id() {
		return _company_id;
	}

	public void setCompany_id(long company_id) {
		_company_id = company_id;

		if (_forumRemoteModel != null) {
			try {
				Class<?> clazz = _forumRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany_id", long.class);

				method.invoke(_forumRemoteModel, company_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCreate_user_id() {
		return _create_user_id;
	}

	public void setCreate_user_id(long create_user_id) {
		_create_user_id = create_user_id;

		if (_forumRemoteModel != null) {
			try {
				Class<?> clazz = _forumRemoteModel.getClass();

				Method method = clazz.getMethod("setCreate_user_id", long.class);

				method.invoke(_forumRemoteModel, create_user_id);
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

		if (_forumRemoteModel != null) {
			try {
				Class<?> clazz = _forumRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_forumRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getForumRemoteModel() {
		return _forumRemoteModel;
	}

	public void setForumRemoteModel(BaseModel<?> forumRemoteModel) {
		_forumRemoteModel = forumRemoteModel;
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

		Class<?> remoteModelClass = _forumRemoteModel.getClass();

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

		Object returnValue = method.invoke(_forumRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ForumLocalServiceUtil.addForum(this);
		}
		else {
			ForumLocalServiceUtil.updateForum(this);
		}
	}

	@Override
	public Forum toEscapedModel() {
		return (Forum)ProxyUtil.newProxyInstance(Forum.class.getClassLoader(),
			new Class[] { Forum.class }, new AutoEscapeBeanHandler(this));
	}

	public Forum toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ForumClp clone = new ForumClp();

		clone.setId_forum(getId_forum());
		clone.setDescription(getDescription());
		clone.setTimestamp(getTimestamp());
		clone.setCompany_id(getCompany_id());
		clone.setCreate_user_id(getCreate_user_id());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(Forum forum) {
		int value = 0;

		if (getId_forum() < forum.getId_forum()) {
			value = -1;
		}
		else if (getId_forum() > forum.getId_forum()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof ForumClp)) {
			return false;
		}

		ForumClp forum = (ForumClp)obj;

		long primaryKey = forum.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id_forum=");
		sb.append(getId_forum());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", timestamp=");
		sb.append(getTimestamp());
		sb.append(", company_id=");
		sb.append(getCompany_id());
		sb.append(", create_user_id=");
		sb.append(getCreate_user_id());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("net.appuntivari.forum.model.Forum");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_forum</column-name><column-value><![CDATA[");
		sb.append(getId_forum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timestamp</column-name><column-value><![CDATA[");
		sb.append(getTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company_id</column-name><column-value><![CDATA[");
		sb.append(getCompany_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>create_user_id</column-name><column-value><![CDATA[");
		sb.append(getCreate_user_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_forum;
	private String _description;
	private Date _timestamp;
	private long _company_id;
	private long _create_user_id;
	private String _status;
	private BaseModel<?> _forumRemoteModel;
}