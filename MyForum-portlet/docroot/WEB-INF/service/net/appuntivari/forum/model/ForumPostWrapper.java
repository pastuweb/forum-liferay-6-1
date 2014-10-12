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
 * This class is a wrapper for {@link ForumPost}.
 * </p>
 *
 * @author    Pasturenzi Francesco
 * @see       ForumPost
 * @generated
 */
public class ForumPostWrapper implements ForumPost, ModelWrapper<ForumPost> {
	public ForumPostWrapper(ForumPost forumPost) {
		_forumPost = forumPost;
	}

	public Class<?> getModelClass() {
		return ForumPost.class;
	}

	public String getModelClassName() {
		return ForumPost.class.getName();
	}

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

	/**
	* Returns the primary key of this forum post.
	*
	* @return the primary key of this forum post
	*/
	public long getPrimaryKey() {
		return _forumPost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this forum post.
	*
	* @param primaryKey the primary key of this forum post
	*/
	public void setPrimaryKey(long primaryKey) {
		_forumPost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_post of this forum post.
	*
	* @return the id_post of this forum post
	*/
	public long getId_post() {
		return _forumPost.getId_post();
	}

	/**
	* Sets the id_post of this forum post.
	*
	* @param id_post the id_post of this forum post
	*/
	public void setId_post(long id_post) {
		_forumPost.setId_post(id_post);
	}

	/**
	* Returns the post of this forum post.
	*
	* @return the post of this forum post
	*/
	public java.lang.String getPost() {
		return _forumPost.getPost();
	}

	/**
	* Sets the post of this forum post.
	*
	* @param post the post of this forum post
	*/
	public void setPost(java.lang.String post) {
		_forumPost.setPost(post);
	}

	/**
	* Returns the timestamp of this forum post.
	*
	* @return the timestamp of this forum post
	*/
	public java.util.Date getTimestamp() {
		return _forumPost.getTimestamp();
	}

	/**
	* Sets the timestamp of this forum post.
	*
	* @param timestamp the timestamp of this forum post
	*/
	public void setTimestamp(java.util.Date timestamp) {
		_forumPost.setTimestamp(timestamp);
	}

	/**
	* Returns the user_id of this forum post.
	*
	* @return the user_id of this forum post
	*/
	public long getUser_id() {
		return _forumPost.getUser_id();
	}

	/**
	* Sets the user_id of this forum post.
	*
	* @param user_id the user_id of this forum post
	*/
	public void setUser_id(long user_id) {
		_forumPost.setUser_id(user_id);
	}

	/**
	* Returns the id_category of this forum post.
	*
	* @return the id_category of this forum post
	*/
	public long getId_category() {
		return _forumPost.getId_category();
	}

	/**
	* Sets the id_category of this forum post.
	*
	* @param id_category the id_category of this forum post
	*/
	public void setId_category(long id_category) {
		_forumPost.setId_category(id_category);
	}

	/**
	* Returns the id_post_parent of this forum post.
	*
	* @return the id_post_parent of this forum post
	*/
	public long getId_post_parent() {
		return _forumPost.getId_post_parent();
	}

	/**
	* Sets the id_post_parent of this forum post.
	*
	* @param id_post_parent the id_post_parent of this forum post
	*/
	public void setId_post_parent(long id_post_parent) {
		_forumPost.setId_post_parent(id_post_parent);
	}

	/**
	* Returns the user_id_post_parent of this forum post.
	*
	* @return the user_id_post_parent of this forum post
	*/
	public long getUser_id_post_parent() {
		return _forumPost.getUser_id_post_parent();
	}

	/**
	* Sets the user_id_post_parent of this forum post.
	*
	* @param user_id_post_parent the user_id_post_parent of this forum post
	*/
	public void setUser_id_post_parent(long user_id_post_parent) {
		_forumPost.setUser_id_post_parent(user_id_post_parent);
	}

	public boolean isNew() {
		return _forumPost.isNew();
	}

	public void setNew(boolean n) {
		_forumPost.setNew(n);
	}

	public boolean isCachedModel() {
		return _forumPost.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_forumPost.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _forumPost.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _forumPost.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_forumPost.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _forumPost.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_forumPost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ForumPostWrapper((ForumPost)_forumPost.clone());
	}

	public int compareTo(net.appuntivari.forum.model.ForumPost forumPost) {
		return _forumPost.compareTo(forumPost);
	}

	@Override
	public int hashCode() {
		return _forumPost.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.appuntivari.forum.model.ForumPost> toCacheModel() {
		return _forumPost.toCacheModel();
	}

	public net.appuntivari.forum.model.ForumPost toEscapedModel() {
		return new ForumPostWrapper(_forumPost.toEscapedModel());
	}

	public net.appuntivari.forum.model.ForumPost toUnescapedModel() {
		return new ForumPostWrapper(_forumPost.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _forumPost.toString();
	}

	public java.lang.String toXmlString() {
		return _forumPost.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_forumPost.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ForumPostWrapper)) {
			return false;
		}

		ForumPostWrapper forumPostWrapper = (ForumPostWrapper)obj;

		if (Validator.equals(_forumPost, forumPostWrapper._forumPost)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ForumPost getWrappedForumPost() {
		return _forumPost;
	}

	public ForumPost getWrappedModel() {
		return _forumPost;
	}

	public void resetOriginalValues() {
		_forumPost.resetOriginalValues();
	}

	private ForumPost _forumPost;
}