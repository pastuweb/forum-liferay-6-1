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

import net.appuntivari.forum.model.ForumUser;

import java.io.Serializable;

/**
 * The cache model class for representing ForumUser in entity cache.
 *
 * @author Pasturenzi Francesco
 * @see ForumUser
 * @generated
 */
public class ForumUserCacheModel implements CacheModel<ForumUser>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_forum_user=");
		sb.append(id_forum_user);
		sb.append(", id_forum=");
		sb.append(id_forum);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public ForumUser toEntityModel() {
		ForumUserImpl forumUserImpl = new ForumUserImpl();

		forumUserImpl.setId_forum_user(id_forum_user);
		forumUserImpl.setId_forum(id_forum);
		forumUserImpl.setUser_id(user_id);

		if (status == null) {
			forumUserImpl.setStatus(StringPool.BLANK);
		}
		else {
			forumUserImpl.setStatus(status);
		}

		forumUserImpl.resetOriginalValues();

		return forumUserImpl;
	}

	public long id_forum_user;
	public long id_forum;
	public long user_id;
	public String status;
}