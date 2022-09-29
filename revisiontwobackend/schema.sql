-- drop database if exists
drop schema if exists contactlist;

-- create a new database
create schema contactlist;

-- select database
use contactlist;

-- create table
create table contacts (
    id varchar(128) not null,
    name varchar(128) not null,
    email varchar(128) not null,
    mobile varchar(16) not null, 
    
    primary key(id)
);
