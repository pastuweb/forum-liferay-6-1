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

import net.appuntivari.forum.model.ForumCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ForumCategory in entity cache.
 *
 * @author Pasturenzi Francesco
 * @see ForumCategory
 * @generated
 */
public class ForumCategoryCacheModel implements CacheModel<ForumCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id_category=");
		sb.append(id_category);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", id_forum=");
		sb.append(id_forum);
		sb.append(", id_category_parent=");
		sb.append(id_category_parent);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", user_id_creator=");
		sb.append(user_id_creator);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public ForumCategory toEntityModel() {
		ForumCategoryImpl forumCategoryImpl = new ForumCategoryImpl();

		forumCategoryImpl.setId_category(id_category);

		if (title == null) {
			forumCategoryImpl.setTitle(StringPool.BLANK);
		}
		else {
			forumCategoryImpl.setTitle(title);
		}

		if (description == null) {
			forumCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			forumCategoryImpl.setDescription(description);
		}

		forumCategoryImpl.setId_forum(id_forum);
		forumCategoryImpl.setId_category_parent(id_category_parent);

		if (timestamp == Long.MIN_VALUE) {
			forumCategoryImpl.setTimestamp(null);
		}
		else {
			forumCategoryImpl.setTimestamp(new Date(timestamp));
		}

		forumCategoryImpl.setUser_id_creator(user_id_creator);

		if (status == null) {
			forumCategoryImpl.setStatus(StringPool.BLANK);
		}
		else {
			forumCategoryImpl.setStatus(status);
		}

		forumCategoryImpl.resetOriginalValues();

		return forumCategoryImpl;
	}

	public long id_category;
	public String title;
	public String description;
	public long id_forum;
	public long id_category_parent;
	public long timestamp;
	public long user_id_creator;
	public String status;
}