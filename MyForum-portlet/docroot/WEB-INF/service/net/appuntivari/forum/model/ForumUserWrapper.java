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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ForumUser}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumUser
 * @generated
 */
public class ForumUserWrapper implements ForumUser, ModelWrapper<ForumUser> {
	public ForumUserWrapper(ForumUser forumUser) {
		_forumUser = forumUser;
	}

	public Class<?> getModelClass() {
		return ForumUser.class;
	}

	public String getModelClassName() {
		return ForumUser.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_forum_user", getId_forum_user());
		attributes.put("id_forum", getId_forum());
		attributes.put("user_id", getUser_id());
		attributes.put("status", getStatus());

		return attributes;
	}

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

	/**
	* Returns the primary key of this forum user.
	*
	* @return the primary key of this forum user
	*/
	public long getPrimaryKey() {
		return _forumUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this forum user.
	*
	* @param primaryKey the primary key of this forum user
	*/
	public void setPrimaryKey(long primaryKey) {
		_forumUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_forum_user of this forum user.
	*
	* @return the id_forum_user of this forum user
	*/
	public long getId_forum_user() {
		return _forumUser.getId_forum_user();
	}

	/**
	* Sets the id_forum_user of this forum user.
	*
	* @param id_forum_user the id_forum_user of this forum user
	*/
	public void setId_forum_user(long id_forum_user) {
		_forumUser.setId_forum_user(id_forum_user);
	}

	/**
	* Returns the id_forum of this forum user.
	*
	* @return the id_forum of this forum user
	*/
	public long getId_forum() {
		return _forumUser.getId_forum();
	}

	/**
	* Sets the id_forum of this forum user.
	*
	* @param id_forum the id_forum of this forum user
	*/
	public void setId_forum(long id_forum) {
		_forumUser.setId_forum(id_forum);
	}

	/**
	* Returns the user_id of this forum user.
	*
	* @return the user_id of this forum user
	*/
	public long getUser_id() {
		return _forumUser.getUser_id();
	}

	/**
	* Sets the user_id of this forum user.
	*
	* @param user_id the user_id of this forum user
	*/
	public void setUser_id(long user_id) {
		_forumUser.setUser_id(user_id);
	}

	/**
	* Returns the status of this forum user.
	*
	* @return the status of this forum user
	*/
	public java.lang.String getStatus() {
		return _forumUser.getStatus();
	}

	/**
	* Sets the status of this forum user.
	*
	* @param status the status of this forum user
	*/
	public void setStatus(java.lang.String status) {
		_forumUser.setStatus(status);
	}

	public boolean isNew() {
		return _forumUser.isNew();
	}

	public void setNew(boolean n) {
		_forumUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _forumUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_forumUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _forumUser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _forumUser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_forumUser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _forumUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_forumUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ForumUserWrapper((ForumUser)_forumUser.clone());
	}

	public int compareTo(net.appuntivari.forum.model.ForumUser forumUser) {
		return _forumUser.compareTo(forumUser);
	}

	@Override
	public int hashCode() {
		return _forumUser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.appuntivari.forum.model.ForumUser> toCacheModel() {
		return _forumUser.toCacheModel();
	}

	public net.appuntivari.forum.model.ForumUser toEscapedModel() {
		return new ForumUserWrapper(_forumUser.toEscapedModel());
	}

	public net.appuntivari.forum.model.ForumUser toUnescapedModel() {
		return new ForumUserWrapper(_forumUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _forumUser.toString();
	}

	public java.lang.String toXmlString() {
		return _forumUser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_forumUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ForumUserWrapper)) {
			return false;
		}

		ForumUserWrapper forumUserWrapper = (ForumUserWrapper)obj;

		if (Validator.equals(_forumUser, forumUserWrapper._forumUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ForumUser getWrappedForumUser() {
		return _forumUser;
	}

	public ForumUser getWrappedModel() {
		return _forumUser;
	}

	public void resetOriginalValues() {
		_forumUser.resetOriginalValues();
	}

	private ForumUser _forumUser;
}