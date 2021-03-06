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

import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.ForumCategoryModel;
import net.appuntivari.forum.model.ForumCategorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ForumCategory service. Represents a row in the &quot;PW_ForumCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.appuntivari.forum.model.ForumCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ForumCategoryImpl}.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumCategoryImpl
 * @see net.appuntivari.forum.model.ForumCategory
 * @see net.appuntivari.forum.model.ForumCategoryModel
 * @generated
 */
@JSON(strict = true)
public class ForumCategoryModelImpl extends BaseModelImpl<ForumCategory>
	implements ForumCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a forum category model instance should use the {@link net.appuntivari.forum.model.ForumCategory} interface instead.
	 */
	public static final String TABLE_NAME = "PW_ForumCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_category", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "id_forum", Types.BIGINT },
			{ "id_category_parent", Types.BIGINT },
			{ "timestamp", Types.TIMESTAMP },
			{ "user_id_creator", Types.BIGINT },
			{ "status", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table PW_ForumCategory (id_category LONG not null primary key,title VARCHAR(100) null,description VARCHAR(250) null,id_forum LONG,id_category_parent LONG,timestamp DATE null,user_id_creator LONG,status VARCHAR(10) null)";
	public static final String TABLE_SQL_DROP = "drop table PW_ForumCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY forumCategory.id_category ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PW_ForumCategory.id_category ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.appuntivari.forum.model.ForumCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.appuntivari.forum.model.ForumCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.net.appuntivari.forum.model.ForumCategory"),
			true);
	public static long ID_CATEGORY_PARENT_COLUMN_BITMASK = 1L;
	public static long ID_FORUM_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long TIMESTAMP_COLUMN_BITMASK = 8L;
	public static long TITLE_COLUMN_BITMASK = 16L;
	public static long USER_ID_CREATOR_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ForumCategory toModel(ForumCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ForumCategory model = new ForumCategoryImpl();

		model.setId_category(soapModel.getId_category());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setId_forum(soapModel.getId_forum());
		model.setId_category_parent(soapModel.getId_category_parent());
		model.setTimestamp(soapModel.getTimestamp());
		model.setUser_id_creator(soapModel.getUser_id_creator());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ForumCategory> toModels(ForumCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ForumCategory> models = new ArrayList<ForumCategory>(soapModels.length);

		for (ForumCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.appuntivari.forum.model.ForumCategory"));

	public ForumCategoryModelImpl() {
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

	public Class<?> getModelClass() {
		return ForumCategory.class;
	}

	public String getModelClassName() {
		return ForumCategory.class.getName();
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

	@JSON
	public long getId_category() {
		return _id_category;
	}

	public void setId_category(long id_category) {
		_columnBitmask = -1L;

		_id_category = id_category;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public long getId_forum() {
		return _id_forum;
	}

	public void setId_forum(long id_forum) {
		_columnBitmask |= ID_FORUM_COLUMN_BITMASK;

		if (!_setOriginalId_forum) {
			_setOriginalId_forum = true;

			_originalId_forum = _id_forum;
		}

		_id_forum = id_forum;
	}

	public long getOriginalId_forum() {
		return _originalId_forum;
	}

	@JSON
	public long getId_category_parent() {
		return _id_category_parent;
	}

	public void setId_category_parent(long id_category_parent) {
		_columnBitmask |= ID_CATEGORY_PARENT_COLUMN_BITMASK;

		if (!_setOriginalId_category_parent) {
			_setOriginalId_category_parent = true;

			_originalId_category_parent = _id_category_parent;
		}

		_id_category_parent = id_category_parent;
	}

	public long getOriginalId_category_parent() {
		return _originalId_category_parent;
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
	public long getUser_id_creator() {
		return _user_id_creator;
	}

	public void setUser_id_creator(long user_id_creator) {
		_columnBitmask |= USER_ID_CREATOR_COLUMN_BITMASK;

		if (!_setOriginalUser_id_creator) {
			_setOriginalUser_id_creator = true;

			_originalUser_id_creator = _user_id_creator;
		}

		_user_id_creator = user_id_creator;
	}

	public long getOriginalUser_id_creator() {
		return _originalUser_id_creator;
	}

	@JSON
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ForumCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ForumCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ForumCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public ForumCategory toUnescapedModel() {
		return (ForumCategory)this;
	}

	@Override
	public Object clone() {
		ForumCategoryImpl forumCategoryImpl = new ForumCategoryImpl();

		forumCategoryImpl.setId_category(getId_category());
		forumCategoryImpl.setTitle(getTitle());
		forumCategoryImpl.setDescription(getDescription());
		forumCategoryImpl.setId_forum(getId_forum());
		forumCategoryImpl.setId_category_parent(getId_category_parent());
		forumCategoryImpl.setTimestamp(getTimestamp());
		forumCategoryImpl.setUser_id_creator(getUser_id_creator());
		forumCategoryImpl.setStatus(getStatus());

		forumCategoryImpl.resetOriginalValues();

		return forumCategoryImpl;
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

		if (!(obj instanceof ForumCategory)) {
			return false;
		}

		ForumCategory forumCategory = (ForumCategory)obj;

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
	public void resetOriginalValues() {
		ForumCategoryModelImpl forumCategoryModelImpl = this;

		forumCategoryModelImpl._originalTitle = forumCategoryModelImpl._title;

		forumCategoryModelImpl._originalId_forum = forumCategoryModelImpl._id_forum;

		forumCategoryModelImpl._setOriginalId_forum = false;

		forumCategoryModelImpl._originalId_category_parent = forumCategoryModelImpl._id_category_parent;

		forumCategoryModelImpl._setOriginalId_category_parent = false;

		forumCategoryModelImpl._originalTimestamp = forumCategoryModelImpl._timestamp;

		forumCategoryModelImpl._originalUser_id_creator = forumCategoryModelImpl._user_id_creator;

		forumCategoryModelImpl._setOriginalUser_id_creator = false;

		forumCategoryModelImpl._originalStatus = forumCategoryModelImpl._status;

		forumCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ForumCategory> toCacheModel() {
		ForumCategoryCacheModel forumCategoryCacheModel = new ForumCategoryCacheModel();

		forumCategoryCacheModel.id_category = getId_category();

		forumCategoryCacheModel.title = getTitle();

		String title = forumCategoryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			forumCategoryCacheModel.title = null;
		}

		forumCategoryCacheModel.description = getDescription();

		String description = forumCategoryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			forumCategoryCacheModel.description = null;
		}

		forumCategoryCacheModel.id_forum = getId_forum();

		forumCategoryCacheModel.id_category_parent = getId_category_parent();

		Date timestamp = getTimestamp();

		if (timestamp != null) {
			forumCategoryCacheModel.timestamp = timestamp.getTime();
		}
		else {
			forumCategoryCacheModel.timestamp = Long.MIN_VALUE;
		}

		forumCategoryCacheModel.user_id_creator = getUser_id_creator();

		forumCategoryCacheModel.status = getStatus();

		String status = forumCategoryCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			forumCategoryCacheModel.status = null;
		}

		return forumCategoryCacheModel;
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

	private static ClassLoader _classLoader = ForumCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ForumCategory.class
		};
	private long _id_category;
	private String _title;
	private String _originalTitle;
	private String _description;
	private long _id_forum;
	private long _originalId_forum;
	private boolean _setOriginalId_forum;
	private long _id_category_parent;
	private long _originalId_category_parent;
	private boolean _setOriginalId_category_parent;
	private Date _timestamp;
	private Date _originalTimestamp;
	private long _user_id_creator;
	private long _originalUser_id_creator;
	private boolean _setOriginalUser_id_creator;
	private String _status;
	private String _originalStatus;
	private long _columnBitmask;
	private ForumCategory _escapedModel;
}