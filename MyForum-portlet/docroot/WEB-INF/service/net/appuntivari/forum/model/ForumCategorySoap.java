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
 * This class is used by SOAP remote services, specifically {@link net.appuntivari.forum.service.http.ForumCategoryServiceSoap}.
 *
 * @author    Pasturenzi Francesco
 * @see       net.appuntivari.forum.service.http.ForumCategoryServiceSoap
 * @generated
 */
public class ForumCategorySoap implements Serializable {
	public static ForumCategorySoap toSoapModel(ForumCategory model) {
		ForumCategorySoap soapModel = new ForumCategorySoap();

		soapModel.setId_category(model.getId_category());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setId_forum(model.getId_forum());
		soapModel.setId_category_parent(model.getId_category_parent());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setUser_id_creator(model.getUser_id_creator());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ForumCategorySoap[] toSoapModels(ForumCategory[] models) {
		ForumCategorySoap[] soapModels = new ForumCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ForumCategorySoap[][] toSoapModels(ForumCategory[][] models) {
		ForumCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ForumCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ForumCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ForumCategorySoap[] toSoapModels(List<ForumCategory> models) {
		List<ForumCategorySoap> soapModels = new ArrayList<ForumCategorySoap>(models.size());

		for (ForumCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ForumCategorySoap[soapModels.size()]);
	}

	public ForumCategorySoap() {
	}

	public long getPrimaryKey() {
		return _id_category;
	}

	public void setPrimaryKey(long pk) {
		setId_category(pk);
	}

	public long getId_category() {
		return _id_category;
	}

	public void setId_category(long id_category) {
		_id_category = id_category;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getId_forum() {
		return _id_forum;
	}

	public void setId_forum(long id_forum) {
		_id_forum = id_forum;
	}

	public long getId_category_parent() {
		return _id_category_parent;
	}

	public void setId_category_parent(long id_category_parent) {
		_id_category_parent = id_category_parent;
	}

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;
	}

	public long getUser_id_creator() {
		return _user_id_creator;
	}

	public void setUser_id_creator(long user_id_creator) {
		_user_id_creator = user_id_creator;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _id_category;
	private String _title;
	private String _description;
	private long _id_forum;
	private long _id_category_parent;
	private Date _timestamp;
	private long _user_id_creator;
	private String _status;
}