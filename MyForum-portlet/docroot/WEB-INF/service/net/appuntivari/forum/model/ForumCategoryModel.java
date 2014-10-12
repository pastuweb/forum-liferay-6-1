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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ForumCategory service. Represents a row in the &quot;PW_ForumCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.appuntivari.forum.model.impl.ForumCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.appuntivari.forum.model.impl.ForumCategoryImpl}.
 * </p>
 *
 * @author Pasturenzi Francesco
 * @see ForumCategory
 * @see net.appuntivari.forum.model.impl.ForumCategoryImpl
 * @see net.appuntivari.forum.model.impl.ForumCategoryModelImpl
 * @generated
 */
public interface ForumCategoryModel extends BaseModel<ForumCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a forum category model instance should use the {@link ForumCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this forum category.
	 *
	 * @return the primary key of this forum category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this forum category.
	 *
	 * @param primaryKey the primary key of this forum category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_category of this forum category.
	 *
	 * @return the id_category of this forum category
	 */
	public long getId_category();

	/**
	 * Sets the id_category of this forum category.
	 *
	 * @param id_category the id_category of this forum category
	 */
	public void setId_category(long id_category);

	/**
	 * Returns the title of this forum category.
	 *
	 * @return the title of this forum category
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this forum category.
	 *
	 * @param title the title of this forum category
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this forum category.
	 *
	 * @return the description of this forum category
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this forum category.
	 *
	 * @param description the description of this forum category
	 */
	public void setDescription(String description);

	/**
	 * Returns the id_forum of this forum category.
	 *
	 * @return the id_forum of this forum category
	 */
	public long getId_forum();

	/**
	 * Sets the id_forum of this forum category.
	 *
	 * @param id_forum the id_forum of this forum category
	 */
	public void setId_forum(long id_forum);

	/**
	 * Returns the id_category_parent of this forum category.
	 *
	 * @return the id_category_parent of this forum category
	 */
	public long getId_category_parent();

	/**
	 * Sets the id_category_parent of this forum category.
	 *
	 * @param id_category_parent the id_category_parent of this forum category
	 */
	public void setId_category_parent(long id_category_parent);

	/**
	 * Returns the timestamp of this forum category.
	 *
	 * @return the timestamp of this forum category
	 */
	public Date getTimestamp();

	/**
	 * Sets the timestamp of this forum category.
	 *
	 * @param timestamp the timestamp of this forum category
	 */
	public void setTimestamp(Date timestamp);

	/**
	 * Returns the create_user_id of this forum category.
	 *
	 * @return the create_user_id of this forum category
	 */
	public long getCreate_user_id();

	/**
	 * Sets the create_user_id of this forum category.
	 *
	 * @param create_user_id the create_user_id of this forum category
	 */
	public void setCreate_user_id(long create_user_id);

	/**
	 * Returns the status of this forum category.
	 *
	 * @return the status of this forum category
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this forum category.
	 *
	 * @param status the status of this forum category
	 */
	public void setStatus(String status);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ForumCategory forumCategory);

	public int hashCode();

	public CacheModel<ForumCategory> toCacheModel();

	public ForumCategory toEscapedModel();

	public ForumCategory toUnescapedModel();

	public String toString();

	public String toXmlString();
}