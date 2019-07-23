-- 存放项目中的创建表的语句
create table carsapp.user
(
    id       bigint auto_increment
        primary key,
    username varchar(20) not null,
    password varchar(50) not null,
    constraint User_username_uindex
        unique (username)
);
