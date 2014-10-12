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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.appuntivari.forum.model.Forum;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Forum in entity cache.
 *
 * @author Pasturenzi Francesco
 * @see Forum
 * @generated
 */
public class ForumCacheModel implements CacheModel<Forum>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id_forum=");
		sb.append(id_forum);
		sb.append(", description=");
		sb.append(description);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", company_id=");
		sb.append(company_id);
		sb.append(", create_user_id=");
		sb.append(create_user_id);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public Forum toEntityModel() {
		ForumImpl forumImpl = new ForumImpl();

		forumImpl.setId_forum(id_forum);

		if (description == null) {
			forumImpl.setDescription(StringPool.BLANK);
		}
		else {
			forumImpl.setDescription(description);
		}

		if (timestamp == Long.MIN_VALUE) {
			forumImpl.setTimestamp(null);
		}
		else {
			forumImpl.setTimestamp(new Date(timestamp));
		}

		forumImpl.setCompany_id(company_id);
		forumImpl.setCreate_user_id(create_user_id);

		if (status == null) {
			forumImpl.setStatus(StringPool.BLANK);
		}
		else {
			forumImpl.setStatus(status);
		}

		forumImpl.resetOriginalValues();

		return forumImpl;
	}

	public long id_forum;
	public String description;
	public long timestamp;
	public long company_id;
	public long create_user_id;
	public String status;
}