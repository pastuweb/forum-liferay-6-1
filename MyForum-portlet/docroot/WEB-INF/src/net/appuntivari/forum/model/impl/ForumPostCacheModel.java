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

import net.appuntivari.forum.model.ForumPost;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ForumPost in entity cache.
 *
 * @author Pasturenzi Francesco
 * @see ForumPost
 * @generated
 */
public class ForumPostCacheModel implements CacheModel<ForumPost>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_post=");
		sb.append(id_post);
		sb.append(", post=");
		sb.append(post);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", id_category=");
		sb.append(id_category);
		sb.append(", id_post_parent=");
		sb.append(id_post_parent);
		sb.append(", user_id_post_parent=");
		sb.append(user_id_post_parent);
		sb.append("}");

		return sb.toString();
	}

	public ForumPost toEntityModel() {
		ForumPostImpl forumPostImpl = new ForumPostImpl();

		forumPostImpl.setId_post(id_post);

		if (post == null) {
			forumPostImpl.setPost(StringPool.BLANK);
		}
		else {
			forumPostImpl.setPost(post);
		}

		if (timestamp == Long.MIN_VALUE) {
			forumPostImpl.setTimestamp(null);
		}
		else {
			forumPostImpl.setTimestamp(new Date(timestamp));
		}

		forumPostImpl.setUser_id(user_id);
		forumPostImpl.setId_category(id_category);
		forumPostImpl.setId_post_parent(id_post_parent);
		forumPostImpl.setUser_id_post_parent(user_id_post_parent);

		forumPostImpl.resetOriginalValues();

		return forumPostImpl;
	}

	public long id_post;
	public String post;
	public long timestamp;
	public long user_id;
	public long id_category;
	public long id_post_parent;
	public long user_id_post_parent;
}