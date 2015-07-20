Liferay.Service.register("Liferay.Service.APINH", "com.telecomlab.forum.service", "TelecomNHForum-portlet");

Liferay.Service.register("Liferay.Service.PW", "net.appuntivari.forum.service", "MyForum-portlet");

Liferay.Service.registerClass(
	Liferay.Service.PW, "Forum",
	{
		getForumById: true,
		getForum: true,
		getForumByCompanyId: true,
		getForumByOwner: true,
		getForumByOwnerStatus: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.PW, "ForumCategory",
	{
		getForumCategoryById: true,
		getForumCategory: true,
		getForumCategoryByIdForum: true,
		getForumCategoryByIdForumStatus: true,
		getForumCategoryByOwner: true,
		getForumCategoryByTitle: true,
		getForumCategoryByIdForumCategoryParent: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.PW, "ForumPost",
	{
		getForumPostById: true,
		getForumPost: true,
		getForumPostByIdCategory: true,
		getForumPostByIdCategoryUserId: true,
		getForumPostByIdPostParent: true,
		getForumPostByUserId: true,
		getForumPostByUserIdParent: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.PW, "ForumUser",
	{
		getForumUserById: true,
		getForumUser: true,
		getForumUserByIdForum: true,
		getForumUserByIdForumStatus: true,
		getForumUserByStatus: true,
		getForumUserByUserId: true
	}
);