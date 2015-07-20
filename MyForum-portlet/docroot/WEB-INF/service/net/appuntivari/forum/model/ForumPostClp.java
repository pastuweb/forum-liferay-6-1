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
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pasturenzi Francesco
 */
public class ForumPostClp extends BaseModelImpl<ForumPost> implements ForumPost {
	public ForumPostClp() {
	}

	public Class<?> getModelClass() {
		return ForumPost.class;
	}

	public String getModelClassName() {
		return ForumPost.class.getName();
	}

	public long getPrimaryKey() {
		return _id_post;
	}

	public void setPrimaryKey(long primaryKey) {
		setId_post(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id_post);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_post", getId_post());
		attributes.put("post", getPost());
		attributes.put("timestamp", getTimestamp());
		attributes.put("user_id", getUser_id());
		attributes.put("id_category", getId_category());
		attributes.put("id_post_parent", getId_post_parent());
		attributes.put("user_id_post_parent", getUser_id_post_parent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_post = (Long)attributes.get("id_post");

		if (id_post != null) {
			setId_post(id_post);
		}

		String post = (String)attributes.get("post");

		if (post != null) {
			setPost(post);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		Long id_category = (Long)attributes.get("id_category");

		if (id_category != null) {
			setId_category(id_category);
		}

		Long id_post_parent = (Long)attributes.get("id_post_parent");

		if (id_post_parent != null) {
			setId_post_parent(id_post_parent);
		}

		Long user_id_post_parent = (Long)attributes.get("user_id_post_parent");

		if (user_id_post_parent != null) {
			setUser_id_post_parent(user_id_post_parent);
		}
	}

	public long getId_post() {
		return _id_post;
	}

	public void setId_post(long id_post) {
		_id_post = id_post;

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setId_post", long.class);

				method.invoke(_forumPostRemoteModel, id_post);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPost() {
		return _post;
	}

	public void setPost(String post) {
		_post = post;

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setPost", String.class);

				method.invoke(_forumPostRemoteModel, post);
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

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setTimestamp", Date.class);

				method.invoke(_forumPostRemoteModel, timestamp);
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

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setUser_id", long.class);

				method.invoke(_forumPostRemoteModel, user_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getId_category() {
		return _id_category;
	}

	public void setId_category(long id_category) {
		_id_category = id_category;

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setId_category", long.class);

				method.invoke(_forumPostRemoteModel, id_category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getId_post_parent() {
		return _id_post_parent;
	}

	public void setId_post_parent(long id_post_parent) {
		_id_post_parent = id_post_parent;

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setId_post_parent", long.class);

				method.invoke(_forumPostRemoteModel, id_post_parent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUser_id_post_parent() {
		return _user_id_post_parent;
	}

	public void setUser_id_post_parent(long user_id_post_parent) {
		_user_id_post_parent = user_id_post_parent;

		if (_forumPostRemoteModel != null) {
			try {
				Class<?> clazz = _forumPostRemoteModel.getClass();

				Method method = clazz.getMethod("setUser_id_post_parent",
						long.class);

				method.invoke(_forumPostRemoteModel, user_id_post_parent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getForumPostRemoteModel() {
		return _forumPostRemoteModel;
	}

	public void setForumPostRemoteModel(BaseModel<?> forumPostRemoteModel) {
		_forumPostRemoteModel = forumPostRemoteModel;
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

		Class<?> remoteModelClass = _forumPostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_forumPostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ForumPostLocalServiceUtil.addForumPost(this);
		}
		else {
			ForumPostLocalServiceUtil.updateForumPost(this);
		}
	}

	@Override
	public ForumPost toEscapedModel() {
		return (ForumPost)ProxyUtil.newProxyInstance(ForumPost.class.getClassLoader(),
			new Class[] { ForumPost.class }, new AutoEscapeBeanHandler(this));
	}

	public ForumPost toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ForumPostClp clone = new ForumPostClp();

		clone.setId_post(getId_post());
		clone.setPost(getPost());
		clone.setTimestamp(getTimestamp());
		clone.setUser_id(getUser_id());
		clone.setId_category(getId_category());
		clone.setId_post_parent(getId_post_parent());
		clone.setUser_id_post_parent(getUser_id_post_parent());

		return clone;
	}

	public int compareTo(ForumPost forumPost) {
		int value = 0;

		if (getId_post() < forumPost.getId_post()) {
			value = -1;
		}
		else if (getId_post() > forumPost.getId_post()) {
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

		if (!(obj instanceof ForumPostClp)) {
			return false;
		}

		ForumPostClp forumPost = (ForumPostClp)obj;

		long primaryKey = forumPost.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id_post=");
		sb.append(getId_post());
		sb.append(", post=");
		sb.append(getPost());
		sb.append(", timestamp=");
		sb.append(getTimestamp());
		sb.append(", user_id=");
		sb.append(getUser_id());
		sb.append(", id_category=");
		sb.append(getId_category());
		sb.append(", id_post_parent=");
		sb.append(getId_post_parent());
		sb.append(", user_id_post_parent=");
		sb.append(getUser_id_post_parent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("net.appuntivari.forum.model.ForumPost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_post</column-name><column-value><![CDATA[");
		sb.append(getId_post());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>post</column-name><column-value><![CDATA[");
		sb.append(getPost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timestamp</column-name><column-value><![CDATA[");
		sb.append(getTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_category</column-name><column-value><![CDATA[");
		sb.append(getId_category());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_post_parent</column-name><column-value><![CDATA[");
		sb.append(getId_post_parent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id_post_parent</column-name><column-value><![CDATA[");
		sb.append(getUser_id_post_parent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_post;
	private String _post;
	private Date _timestamp;
	private long _user_id;
	private long _id_category;
	private long _id_post_parent;
	private long _user_id_post_parent;
	private BaseModel<?> _forumPostRemoteModel;
}