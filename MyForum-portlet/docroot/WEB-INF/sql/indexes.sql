create index IX_D9D1C720 on PW_Forum (company_id);
create index IX_8B51188F on PW_Forum (create_user_id);
create index IX_6F315875 on PW_Forum (create_user_id, status);
create index IX_2FFE9E35 on PW_Forum (status);
create index IX_BD030D97 on PW_Forum (timestamp);

create index IX_1FB6D52D on PW_ForumCategory (create_user_id);
create index IX_ED481F5E on PW_ForumCategory (id_forum);
create index IX_68182044 on PW_ForumCategory (id_forum, status);
create index IX_70C56639 on PW_ForumCategory (timestamp);
create index IX_81BD777B on PW_ForumCategory (title);

create index IX_D1ACE123 on PW_ForumPost (id_category);
create index IX_A522F557 on PW_ForumPost (timestamp);
create index IX_9E937D0 on PW_ForumPost (user_id);
create index IX_A0A7DFBA on PW_ForumPost (user_id_post_parent);

create index IX_D9AD1F2B on PW_ForumUser (id_forum);
create index IX_95DB0311 on PW_ForumUser (id_forum, status);
create index IX_814E67E0 on PW_ForumUser (status);
create index IX_381BCBC5 on PW_ForumUser (user_id);