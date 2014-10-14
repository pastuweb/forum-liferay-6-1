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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ForumCategory}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumCategory
 * @generated
 */
public class ForumCategoryWrapper implements ForumCategory,
	ModelWrapper<ForumCategory> {
	public ForumCategoryWrapper(ForumCategory forumCategory) {
		_forumCategory = forumCategory;
	}

	public Class<?> getModelClass() {
		return ForumCategory.class;
	}

	public String getModelClassName() {
		return ForumCategory.class.getName();
	}

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

	/**
	* Returns the primary key of this forum category.
	*
	* @return the primary key of this forum category
	*/
	public long getPrimaryKey() {
		return _forumCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this forum category.
	*
	* @param primaryKey the primary key of this forum category
	*/
	public void setPrimaryKey(long primaryKey) {
		_forumCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_category of this forum category.
	*
	* @return the id_category of this forum category
	*/
	public long getId_category() {
		return _forumCategory.getId_category();
	}

	/**
	* Sets the id_category of this forum category.
	*
	* @param id_category the id_category of this forum category
	*/
	public void setId_category(long id_category) {
		_forumCategory.setId_category(id_category);
	}

	/**
	* Returns the title of this forum category.
	*
	* @return the title of this forum category
	*/
	public java.lang.String getTitle() {
		return _forumCategory.getTitle();
	}

	/**
	* Sets the title of this forum category.
	*
	* @param title the title of this forum category
	*/
	public void setTitle(java.lang.String title) {
		_forumCategory.setTitle(title);
	}

	/**
	* Returns the description of this forum category.
	*
	* @return the description of this forum category
	*/
	public java.lang.String getDescription() {
		return _forumCategory.getDescription();
	}

	/**
	* Sets the description of this forum category.
	*
	* @param description the description of this forum category
	*/
	public void setDescription(java.lang.String description) {
		_forumCategory.setDescription(description);
	}

	/**
	* Returns the id_forum of this forum category.
	*
	* @return the id_forum of this forum category
	*/
	public long getId_forum() {
		return _forumCategory.getId_forum();
	}

	/**
	* Sets the id_forum of this forum category.
	*
	* @param id_forum the id_forum of this forum category
	*/
	public void setId_forum(long id_forum) {
		_forumCategory.setId_forum(id_forum);
	}

	/**
	* Returns the id_category_parent of this forum category.
	*
	* @return the id_category_parent of this forum category
	*/
	public long getId_category_parent() {
		return _forumCategory.getId_category_parent();
	}

	/**
	* Sets the id_category_parent of this forum category.
	*
	* @param id_category_parent the id_category_parent of this forum category
	*/
	public void setId_category_parent(long id_category_parent) {
		_forumCategory.setId_category_parent(id_category_parent);
	}

	/**
	* Returns the timestamp of this forum category.
	*
	* @return the timestamp of this forum category
	*/
	public java.util.Date getTimestamp() {
		return _forumCategory.getTimestamp();
	}

	/**
	* Sets the timestamp of this forum category.
	*
	* @param timestamp the timestamp of this forum category
	*/
	public void setTimestamp(java.util.Date timestamp) {
		_forumCategory.setTimestamp(timestamp);
	}

	/**
	* Returns the user_id_creator of this forum category.
	*
	* @return the user_id_creator of this forum category
	*/
	public long getUser_id_creator() {
		return _forumCategory.getUser_id_creator();
	}

	/**
	* Sets the user_id_creator of this forum category.
	*
	* @param user_id_creator the user_id_creator of this forum category
	*/
	public void setUser_id_creator(long user_id_creator) {
		_forumCategory.setUser_id_creator(user_id_creator);
	}

	/**
	* Returns the status of this forum category.
	*
	* @return the status of this forum category
	*/
	public java.lang.String getStatus() {
		return _forumCategory.getStatus();
	}

	/**
	* Sets the status of this forum category.
	*
	* @param status the status of this forum category
	*/
	public void setStatus(java.lang.String status) {
		_forumCategory.setStatus(status);
	}

	public boolean isNew() {
		return _forumCategory.isNew();
	}

	public void setNew(boolean n) {
		_forumCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _forumCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_forumCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _forumCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _forumCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_forumCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _forumCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_forumCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ForumCategoryWrapper((ForumCategory)_forumCategory.clone());
	}

	public int compareTo(
		net.appuntivari.forum.model.ForumCategory forumCategory) {
		return _forumCategory.compareTo(forumCategory);
	}

	@Override
	public int hashCode() {
		return _forumCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.appuntivari.forum.model.ForumCategory> toCacheModel() {
		return _forumCategory.toCacheModel();
	}

	public net.appuntivari.forum.model.ForumCategory toEscapedModel() {
		return new ForumCategoryWrapper(_forumCategory.toEscapedModel());
	}

	public net.appuntivari.forum.model.ForumCategory toUnescapedModel() {
		return new ForumCategoryWrapper(_forumCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _forumCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _forumCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_forumCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ForumCategoryWrapper)) {
			return false;
		}

		ForumCategoryWrapper forumCategoryWrapper = (ForumCategoryWrapper)obj;

		if (Validator.equals(_forumCategory, forumCategoryWrapper._forumCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ForumCategory getWrappedForumCategory() {
		return _forumCategory;
	}

	public ForumCategory getWrappedModel() {
		return _forumCategory;
	}

	public void resetOriginalValues() {
		_forumCategory.resetOriginalValues();
	}

	private ForumCategory _forumCategory;
}