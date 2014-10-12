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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link net.appuntivari.forum.service.http.ForumUserServiceSoap}.
 *
 * @author    Pasturenzi Francesco
 * @see       net.appuntivari.forum.service.http.ForumUserServiceSoap
 * @generated
 */
public class ForumUserSoap implements Serializable {
	public static ForumUserSoap toSoapModel(ForumUser model) {
		ForumUserSoap soapModel = new ForumUserSoap();

		soapModel.setId_forum_user(model.getId_forum_user());
		soapModel.setId_forum(model.getId_forum());
		soapModel.setUser_id(model.getUser_id());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ForumUserSoap[] toSoapModels(ForumUser[] models) {
		ForumUserSoap[] soapModels = new ForumUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ForumUserSoap[][] toSoapModels(ForumUser[][] models) {
		ForumUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ForumUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ForumUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ForumUserSoap[] toSoapModels(List<ForumUser> models) {
		List<ForumUserSoap> soapModels = new ArrayList<ForumUserSoap>(models.size());

		for (ForumUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ForumUserSoap[soapModels.size()]);
	}

	public ForumUserSoap() {
	}

	public long getPrimaryKey() {
		return _id_forum_user;
	}

	public void setPrimaryKey(long pk) {
		setId_forum_user(pk);
	}

	public long getId_forum_user() {
		return _id_forum_user;
	}

	public void setId_forum_user(long id_forum_user) {
		_id_forum_user = id_forum_user;
	}

	public long getId_forum() {
		return _id_forum;
	}

	public void setId_forum(long id_forum) {
		_id_forum = id_forum;
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _id_forum_user;
	private long _id_forum;
	private long _user_id;
	private String _status;
}