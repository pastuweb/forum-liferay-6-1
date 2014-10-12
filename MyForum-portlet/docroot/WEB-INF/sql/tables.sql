create table PW_Forum (
	id_forum LONG not null primary key,
	description VARCHAR(75) null,
	timestamp DATE null,
	company_id LONG,
	create_user_id LONG,
	status VARCHAR(75) null
);

create table PW_ForumCategory (
	id_category LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	id_forum LONG,
	id_category_parent LONG,
	timestamp DATE null,
	create_user_id LONG,
	status VARCHAR(75) null
);

create table PW_ForumPost (
	id_post LONG not null primary key,
	post VARCHAR(75) null,
	timestamp DATE null,
	user_id LONG,
	id_category LONG,
	id_post_parent LONG,
	user_id_post_parent LONG
);

create table PW_ForumUser (
	id_forum_user LONG not null primary key,
	id_forum LONG,
	user_id LONG,
	status VARCHAR(75) null
);