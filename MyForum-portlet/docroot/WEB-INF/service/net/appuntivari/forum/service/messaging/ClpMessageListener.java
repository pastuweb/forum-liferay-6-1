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

package net.appuntivari.forum.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import net.appuntivari.forum.service.ClpSerializer;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.ForumCategoryServiceUtil;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;
import net.appuntivari.forum.service.ForumPostServiceUtil;
import net.appuntivari.forum.service.ForumServiceUtil;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;
import net.appuntivari.forum.service.ForumUserServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ForumLocalServiceUtil.clearService();

			ForumServiceUtil.clearService();
			ForumCategoryLocalServiceUtil.clearService();

			ForumCategoryServiceUtil.clearService();
			ForumPostLocalServiceUtil.clearService();

			ForumPostServiceUtil.clearService();
			ForumUserLocalServiceUtil.clearService();

			ForumUserServiceUtil.clearService();
		}
	}
}