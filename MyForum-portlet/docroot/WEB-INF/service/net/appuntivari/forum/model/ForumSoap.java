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
 * This class is used by SOAP remote services, specifically {@link net.appuntivari.forum.service.http.ForumServiceSoap}.
 *
 * @author    Pasturenzi Francesco
 * @see       net.appuntivari.forum.service.http.ForumServiceSoap
 * @generated
 */
public class ForumSoap implements Serializable {
	public static ForumSoap toSoapModel(Forum model) {
		ForumSoap soapModel = new ForumSoap();

		soapModel.setId_forum(model.getId_forum());
		soapModel.setDescription(model.getDescription());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setCompany_id(model.getCompany_id());
		soapModel.setUser_id_creator(model.getUser_id_creator());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ForumSoap[] toSoapModels(Forum[] models) {
		ForumSoap[] soapModels = new ForumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ForumSoap[][] toSoapModels(Forum[][] models) {
		ForumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ForumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ForumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ForumSoap[] toSoapModels(List<Forum> models) {
		List<ForumSoap> soapModels = new ArrayList<ForumSoap>(models.size());

		for (Forum model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ForumSoap[soapModels.size()]);
	}

	public ForumSoap() {
	}

	public long getPrimaryKey() {
		return _id_forum;
	}

	public void setPrimaryKey(long pk) {
		setId_forum(pk);
	}

	public long getId_forum() {
		return _id_forum;
	}

	public void setId_forum(long id_forum) {
		_id_forum = id_forum;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;
	}

	public long getCompany_id() {
		return _company_id;
	}

	public void setCompany_id(long company_id) {
		_company_id = company_id;
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

	private long _id_forum;
	private String _description;
	private Date _timestamp;
	private long _company_id;
	private long _user_id_creator;
	private String _status;
}