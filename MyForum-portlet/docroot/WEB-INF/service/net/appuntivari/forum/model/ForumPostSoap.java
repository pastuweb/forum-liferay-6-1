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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link net.appuntivari.forum.service.http.ForumPostServiceSoap}.
 *
 * @author    Pasturenzi Francesco
 * @see       net.appuntivari.forum.service.http.ForumPostServiceSoap
 * @generated
 */
public class ForumPostSoap implements Serializable {
	public static ForumPostSoap toSoapModel(ForumPost model) {
		ForumPostSoap soapModel = new ForumPostSoap();

		soapModel.setId_post(model.getId_post());
		soapModel.setPost(model.getPost());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setUser_id(model.getUser_id());
		soapModel.setId_category(model.getId_category());
		soapModel.setId_post_parent(model.getId_post_parent());
		soapModel.setUser_id_post_parent(model.getUser_id_post_parent());

		return soapModel;
	}

	public static ForumPostSoap[] toSoapModels(ForumPost[] models) {
		ForumPostSoap[] soapModels = new ForumPostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ForumPostSoap[][] toSoapModels(ForumPost[][] models) {
		ForumPostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ForumPostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ForumPostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ForumPostSoap[] toSoapModels(List<ForumPost> models) {
		List<ForumPostSoap> soapModels = new ArrayList<ForumPostSoap>(models.size());

		for (ForumPost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ForumPostSoap[soapModels.size()]);
	}

	public ForumPostSoap() {
	}

	public long getPrimaryKey() {
		return _id_post;
	}

	public void setPrimaryKey(long pk) {
		setId_post(pk);
	}

	public long getId_post() {
		return _id_post;
	}

	public void setId_post(long id_post) {
		_id_post = id_post;
	}

	public String getPost() {
		return _post;
	}

	public void setPost(String post) {
		_post = post;
	}

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;
	}

	public long getId_category() {
		return _id_category;
	}

	public void setId_category(long id_category) {
		_id_category = id_category;
	}

	public long getId_post_parent() {
		return _id_post_parent;
	}

	public void setId_post_parent(long id_post_parent) {
		_id_post_parent = id_post_parent;
	}

	public long getUser_id_post_parent() {
		return _user_id_post_parent;
	}

	public void setUser_id_post_parent(long user_id_post_parent) {
		_user_id_post_parent = user_id_post_parent;
	}

	private long _id_post;
	private String _post;
	private Date _timestamp;
	private long _user_id;
	private long _id_category;
	private long _id_post_parent;
	private long _user_id_post_parent;
}