drop table if exists dmtask;
drop table if exists dmuser;

create table dmtask (
	id bigint generated by default as identity,
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
);

create table dmuser (
	id bigint generated by default as identity,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null,
	primary key (id)
);