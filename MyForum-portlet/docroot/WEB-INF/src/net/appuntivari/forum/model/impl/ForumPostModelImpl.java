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

package net.appuntivari.forum.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.model.ForumPostModel;
import net.appuntivari.forum.model.ForumPostSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ForumPost service. Represents a row in the &quot;PW_ForumPost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.appuntivari.forum.model.ForumPostModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ForumPostImpl}.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumPostImpl
 * @see net.appuntivari.forum.model.ForumPost
 * @see net.appuntivari.forum.model.ForumPostModel
 * @generated
 */
@JSON(strict = true)
public class ForumPostModelImpl extends BaseModelImpl<ForumPost>
	implements ForumPostModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a forum post model instance should use the {@link net.appuntivari.forum.model.ForumPost} interface instead.
	 */
	public static final String TABLE_NAME = "PW_ForumPost";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_post", Types.BIGINT },
			{ "post", Types.VARCHAR },
			{ "timestamp", Types.TIMESTAMP },
			{ "user_id", Types.BIGINT },
			{ "id_category", Types.BIGINT },
			{ "id_post_parent", Types.BIGINT },
			{ "user_id_post_parent", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table PW_ForumPost (id_post LONG not null primary key,post VARCHAR(75) null,timestamp DATE null,user_id LONG,id_category LONG,id_post_parent LONG,user_id_post_parent LONG)";
	public static final String TABLE_SQL_DROP = "drop table PW_ForumPost";
	public static final String ORDER_BY_JPQL = " ORDER BY forumPost.id_post DESC";
	public static final String ORDER_BY_SQL = " ORDER BY PW_ForumPost.id_post DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.appuntivari.forum.model.ForumPost"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.appuntivari.forum.model.ForumPost"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.net.appuntivari.forum.model.ForumPost"),
			true);
	public static long ID_CATEGORY_COLUMN_BITMASK = 1L;
	public static long TIMESTAMP_COLUMN_BITMASK = 2L;
	public static long USER_ID_COLUMN_BITMASK = 4L;
	public static long USER_ID_POST_PARENT_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ForumPost toModel(ForumPostSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ForumPost model = new ForumPostImpl();

		model.setId_post(soapModel.getId_post());
		model.setPost(soapModel.getPost());
		model.setTimestamp(soapModel.getTimestamp());
		model.setUser_id(soapModel.getUser_id());
		model.setId_category(soapModel.getId_category());
		model.setId_post_parent(soapModel.getId_post_parent());
		model.setUser_id_post_parent(soapModel.getUser_id_post_parent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ForumPost> toModels(ForumPostSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ForumPost> models = new ArrayList<ForumPost>(soapModels.length);

		for (ForumPostSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.appuntivari.forum.model.ForumPost"));

	public ForumPostModelImpl() {
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

	public Class<?> getModelClass() {
		return ForumPost.class;
	}

	public String getModelClassName() {
		return ForumPost.class.getName();
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

	@JSON
	public long getId_post() {
		return _id_post;
	}

	public void setId_post(long id_post) {
		_columnBitmask = -1L;

		_id_post = id_post;
	}

	@JSON
	public String getPost() {
		if (_post == null) {
			return StringPool.BLANK;
		}
		else {
			return _post;
		}
	}

	public void setPost(String post) {
		_post = post;
	}

	@JSON
	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_columnBitmask |= TIMESTAMP_COLUMN_BITMASK;

		if (_originalTimestamp == null) {
			_originalTimestamp = _timestamp;
		}

		_timestamp = timestamp;
	}

	public Date getOriginalTimestamp() {
		return _originalTimestamp;
	}

	@JSON
	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_columnBitmask |= USER_ID_COLUMN_BITMASK;

		if (!_setOriginalUser_id) {
			_setOriginalUser_id = true;

			_originalUser_id = _user_id;
		}

		_user_id = user_id;
	}

	public long getOriginalUser_id() {
		return _originalUser_id;
	}

	@JSON
	public long getId_category() {
		return _id_category;
	}

	public void setId_category(long id_category) {
		_columnBitmask |= ID_CATEGORY_COLUMN_BITMASK;

		if (!_setOriginalId_category) {
			_setOriginalId_category = true;

			_originalId_category = _id_category;
		}

		_id_category = id_category;
	}

	public long getOriginalId_category() {
		return _originalId_category;
	}

	@JSON
	public long getId_post_parent() {
		return _id_post_parent;
	}

	public void setId_post_parent(long id_post_parent) {
		_id_post_parent = id_post_parent;
	}

	@JSON
	public long getUser_id_post_parent() {
		return _user_id_post_parent;
	}

	public void setUser_id_post_parent(long user_id_post_parent) {
		_columnBitmask |= USER_ID_POST_PARENT_COLUMN_BITMASK;

		if (!_setOriginalUser_id_post_parent) {
			_setOriginalUser_id_post_parent = true;

			_originalUser_id_post_parent = _user_id_post_parent;
		}

		_user_id_post_parent = user_id_post_parent;
	}

	public long getOriginalUser_id_post_parent() {
		return _originalUser_id_post_parent;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ForumPost.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ForumPost toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ForumPost)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public ForumPost toUnescapedModel() {
		return (ForumPost)this;
	}

	@Override
	public Object clone() {
		ForumPostImpl forumPostImpl = new ForumPostImpl();

		forumPostImpl.setId_post(getId_post());
		forumPostImpl.setPost(getPost());
		forumPostImpl.setTimestamp(getTimestamp());
		forumPostImpl.setUser_id(getUser_id());
		forumPostImpl.setId_category(getId_category());
		forumPostImpl.setId_post_parent(getId_post_parent());
		forumPostImpl.setUser_id_post_parent(getUser_id_post_parent());

		forumPostImpl.resetOriginalValues();

		return forumPostImpl;
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

		if (!(obj instanceof ForumPost)) {
			return false;
		}

		ForumPost forumPost = (ForumPost)obj;

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
	public void resetOriginalValues() {
		ForumPostModelImpl forumPostModelImpl = this;

		forumPostModelImpl._originalTimestamp = forumPostModelImpl._timestamp;

		forumPostModelImpl._originalUser_id = forumPostModelImpl._user_id;

		forumPostModelImpl._setOriginalUser_id = false;

		forumPostModelImpl._originalId_category = forumPostModelImpl._id_category;

		forumPostModelImpl._setOriginalId_category = false;

		forumPostModelImpl._originalUser_id_post_parent = forumPostModelImpl._user_id_post_parent;

		forumPostModelImpl._setOriginalUser_id_post_parent = false;

		forumPostModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ForumPost> toCacheModel() {
		ForumPostCacheModel forumPostCacheModel = new ForumPostCacheModel();

		forumPostCacheModel.id_post = getId_post();

		forumPostCacheModel.post = getPost();

		String post = forumPostCacheModel.post;

		if ((post != null) && (post.length() == 0)) {
			forumPostCacheModel.post = null;
		}

		Date timestamp = getTimestamp();

		if (timestamp != null) {
			forumPostCacheModel.timestamp = timestamp.getTime();
		}
		else {
			forumPostCacheModel.timestamp = Long.MIN_VALUE;
		}

		forumPostCacheModel.user_id = getUser_id();

		forumPostCacheModel.id_category = getId_category();

		forumPostCacheModel.id_post_parent = getId_post_parent();

		forumPostCacheModel.user_id_post_parent = getUser_id_post_parent();

		return forumPostCacheModel;
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

	private static ClassLoader _classLoader = ForumPost.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ForumPost.class
		};
	private long _id_post;
	private String _post;
	private Date _timestamp;
	private Date _originalTimestamp;
	private long _user_id;
	private long _originalUser_id;
	private boolean _setOriginalUser_id;
	private long _id_category;
	private long _originalId_category;
	private boolean _setOriginalId_category;
	private long _id_post_parent;
	private long _user_id_post_parent;
	private long _originalUser_id_post_parent;
	private boolean _setOriginalUser_id_post_parent;
	private long _columnBitmask;
	private ForumPost _escapedModel;
}