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
 * This class is a wrapper for {@link Forum}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       Forum
 * @generated
 */
public class ForumWrapper implements Forum, ModelWrapper<Forum> {
	public ForumWrapper(Forum forum) {
		_forum = forum;
	}

	public Class<?> getModelClass() {
		return Forum.class;
	}

	public String getModelClassName() {
		return Forum.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_forum", getId_forum());
		attributes.put("description", getDescription());
		attributes.put("timestamp", getTimestamp());
		attributes.put("company_id", getCompany_id());
		attributes.put("user_id_creator", getUser_id_creator());
		attributes.put("status", getStatus());

		return attributes;
	}

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
	* Returns the primary key of this forum.
	*
	* @return the primary key of this forum
	*/
	public long getPrimaryKey() {
		return _forum.getPrimaryKey();
	}

	/**
	* Sets the primary key of this forum.
	*
	* @param primaryKey the primary key of this forum
	*/
	public void setPrimaryKey(long primaryKey) {
		_forum.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_forum of this forum.
	*
	* @return the id_forum of this forum
	*/
	public long getId_forum() {
		return _forum.getId_forum();
	}

	/**
	* Sets the id_forum of this forum.
	*
	* @param id_forum the id_forum of this forum
	*/
	public void setId_forum(long id_forum) {
		_forum.setId_forum(id_forum);
	}

	/**
	* Returns the description of this forum.
	*
	* @return the description of this forum
	*/
	public java.lang.String getDescription() {
		return _forum.getDescription();
	}

	/**
	* Sets the description of this forum.
	*
	* @param description the description of this forum
	*/
	public void setDescription(java.lang.String description) {
		_forum.setDescription(description);
	}

	/**
	* Returns the timestamp of this forum.
	*
	* @return the timestamp of this forum
	*/
	public java.util.Date getTimestamp() {
		return _forum.getTimestamp();
	}

	/**
	* Sets the timestamp of this forum.
	*
	* @param timestamp the timestamp of this forum
	*/
	public void setTimestamp(java.util.Date timestamp) {
		_forum.setTimestamp(timestamp);
	}

	/**
	* Returns the company_id of this forum.
	*
	* @return the company_id of this forum
	*/
	public long getCompany_id() {
		return _forum.getCompany_id();
	}

	/**
	* Sets the company_id of this forum.
	*
	* @param company_id the company_id of this forum
	*/
	public void setCompany_id(long company_id) {
		_forum.setCompany_id(company_id);
	}

	/**
	* Returns the user_id_creator of this forum.
	*
	* @return the user_id_creator of this forum
	*/
	public long getUser_id_creator() {
		return _forum.getUser_id_creator();
	}

	/**
	* Sets the user_id_creator of this forum.
	*
	* @param user_id_creator the user_id_creator of this forum
	*/
	public void setUser_id_creator(long user_id_creator) {
		_forum.setUser_id_creator(user_id_creator);
	}

	/**
	* Returns the status of this forum.
	*
	* @return the status of this forum
	*/
	public java.lang.String getStatus() {
		return _forum.getStatus();
	}

	/**
	* Sets the status of this forum.
	*
	* @param status the status of this forum
	*/
	public void setStatus(java.lang.String status) {
		_forum.setStatus(status);
	}

	public boolean isNew() {
		return _forum.isNew();
	}

	public void setNew(boolean n) {
		_forum.setNew(n);
	}

	public boolean isCachedModel() {
		return _forum.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_forum.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _forum.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _forum.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_forum.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _forum.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_forum.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ForumWrapper((Forum)_forum.clone());
	}

	public int compareTo(net.appuntivari.forum.model.Forum forum) {
		return _forum.compareTo(forum);
	}

	@Override
	public int hashCode() {
		return _forum.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.appuntivari.forum.model.Forum> toCacheModel() {
		return _forum.toCacheModel();
	}

	public net.appuntivari.forum.model.Forum toEscapedModel() {
		return new ForumWrapper(_forum.toEscapedModel());
	}

	public net.appuntivari.forum.model.Forum toUnescapedModel() {
		return new ForumWrapper(_forum.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _forum.toString();
	}

	public java.lang.String toXmlString() {
		return _forum.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_forum.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ForumWrapper)) {
			return false;
		}

		ForumWrapper forumWrapper = (ForumWrapper)obj;

		if (Validator.equals(_forum, forumWrapper._forum)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Forum getWrappedForum() {
		return _forum;
	}

	public Forum getWrappedModel() {
		return _forum;
	}

	public void resetOriginalValues() {
		_forum.resetOriginalValues();
	}

	private Forum _forum;
}