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
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pasturenzi Francesco
 */
public class ForumCategoryClp extends BaseModelImpl<ForumCategory>
	implements ForumCategory {
	public ForumCategoryClp() {
	}

	public Class<?> getModelClass() {
		return ForumCategory.class;
	}

	public String getModelClassName() {
		return ForumCategory.class.getName();
	}

	public long getPrimaryKey() {
		return _id_category;
	}

	public void setPrimaryKey(long primaryKey) {
		setId_category(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id_category);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_category", getId_category());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("id_forum", getId_forum());
		attributes.put("id_category_parent", getId_category_parent());
		attributes.put("timestamp", getTimestamp());
		attributes.put("user_id_creator", getUser_id_creator());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_category = (Long)attributes.get("id_category");

		if (id_category != null) {
			setId_category(id_category);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long id_forum = (Long)attributes.get("id_forum");

		if (id_forum != null) {
			setId_forum(id_forum);
		}

		Long id_category_parent = (Long)attributes.get("id_category_parent");

		if (id_category_parent != null) {
			setId_category_parent(id_category_parent);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Long user_id_creator = (Long)attributes.get("user_id_creator");

		if (user_id_creator != null) {
			setUser_id_creator(user_id_creator);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getId_category() {
		return _id_category;
	}

	public void setId_category(long id_category) {
		_id_category = id_category;

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setId_category", long.class);

				method.invoke(_forumCategoryRemoteModel, id_category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_forumCategoryRemoteModel, title);
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

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_forumCategoryRemoteModel, description);
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

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setId_forum", long.class);

				method.invoke(_forumCategoryRemoteModel, id_forum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getId_category_parent() {
		return _id_category_parent;
	}

	public void setId_category_parent(long id_category_parent) {
		_id_category_parent = id_category_parent;

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setId_category_parent",
						long.class);

				method.invoke(_forumCategoryRemoteModel, id_category_parent);
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

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTimestamp", Date.class);

				method.invoke(_forumCategoryRemoteModel, timestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUser_id_creator() {
		return _user_id_creator;
	}

	public void setUser_id_creator(long user_id_creator) {
		_user_id_creator = user_id_creator;

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUser_id_creator", long.class);

				method.invoke(_forumCategoryRemoteModel, user_id_creator);
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

		if (_forumCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _forumCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_forumCategoryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getForumCategoryRemoteModel() {
		return _forumCategoryRemoteModel;
	}

	public void setForumCategoryRemoteModel(
		BaseModel<?> forumCategoryRemoteModel) {
		_forumCategoryRemoteModel = forumCategoryRemoteModel;
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

		Class<?> remoteModelClass = _forumCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_forumCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ForumCategoryLocalServiceUtil.addForumCategory(this);
		}
		else {
			ForumCategoryLocalServiceUtil.updateForumCategory(this);
		}
	}

	@Override
	public ForumCategory toEscapedModel() {
		return (ForumCategory)ProxyUtil.newProxyInstance(ForumCategory.class.getClassLoader(),
			new Class[] { ForumCategory.class }, new AutoEscapeBeanHandler(this));
	}

	public ForumCategory toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ForumCategoryClp clone = new ForumCategoryClp();

		clone.setId_category(getId_category());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setId_forum(getId_forum());
		clone.setId_category_parent(getId_category_parent());
		clone.setTimestamp(getTimestamp());
		clone.setUser_id_creator(getUser_id_creator());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ForumCategory forumCategory) {
		int value = 0;

		if (getId_category() < forumCategory.getId_category()) {
			value = -1;
		}
		else if (getId_category() > forumCategory.getId_category()) {
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

		if (!(obj instanceof ForumCategoryClp)) {
			return false;
		}

		ForumCategoryClp forumCategory = (ForumCategoryClp)obj;

		long primaryKey = forumCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{id_category=");
		sb.append(getId_category());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", id_forum=");
		sb.append(getId_forum());
		sb.append(", id_category_parent=");
		sb.append(getId_category_parent());
		sb.append(", timestamp=");
		sb.append(getTimestamp());
		sb.append(", user_id_creator=");
		sb.append(getUser_id_creator());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("net.appuntivari.forum.model.ForumCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_category</column-name><column-value><![CDATA[");
		sb.append(getId_category());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_forum</column-name><column-value><![CDATA[");
		sb.append(getId_forum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_category_parent</column-name><column-value><![CDATA[");
		sb.append(getId_category_parent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timestamp</column-name><column-value><![CDATA[");
		sb.append(getTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id_creator</column-name><column-value><![CDATA[");
		sb.append(getUser_id_creator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_category;
	private String _title;
	private String _description;
	private long _id_forum;
	private long _id_category_parent;
	private Date _timestamp;
	private long _user_id_creator;
	private String _status;
	private BaseModel<?> _forumCategoryRemoteModel;
}