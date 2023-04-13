create schema if not exists jooqtest;

create type sex_enum as enum ('MALE', 'FEMALE');

create table account
(
    id   uuid                         default gen_random_uuid(),
    name varchar(255) unique not null,
    city varchar(255)        null     default null,
    sex  sex_enum            not null default 'MALE',
    primary key (id)
);

create table book
(
    id          uuid                          default gen_random_uuid(),
    author uuid references account (id),
    name        varchar(255) unique      not null,
    description varchar(255)             null default null,
    date        timestamp with time zone not null,
    primary key (id)
);