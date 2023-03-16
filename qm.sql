# create databases
create database qm_main;
use qm_main;
create table hot_app
(
    id          bigint       not null comment '编号'
        primary key,
    name        varchar(100) not null comment '名称',
    url         varchar(500) not null comment '网址',
    create_time datetime     not null comment '发布时间'
)
    comment '热门APP';

create table qm_main.report
(
    id          bigint       not null comment '公告编号'
        primary key,
    title       varchar(500) not null comment '公告名称',
    text        varchar(500) not null comment '公告内容',
    create_time datetime     not null comment '公告时间'
)
    comment '公告表';

create database qm_student;
use qm_student;
create table client_message
(
    id          varchar(200) not null comment '主键'
        primary key,
    name        varchar(10)  not null comment '称呼',
    phone       char(11)     not null comment '手机号',
    message     varchar(500) null comment '留言',
    create_time datetime     not null comment '创建时间'
)
    comment '家教信息表';

create table feedback
(
    id          varchar(200)  not null comment '主键'
        primary key,
    text        varchar(1000) not null comment '反馈信息',
    create_time datetime      not null comment '创建时间'
)
    comment '反馈表';

create table resource
(
    id          varchar(200) not null comment '主键'
        primary key,
    title       varchar(100) not null comment '标题',
    url         varchar(200) not null comment '链接',
    password    varchar(50)  null comment '提取码',
    create_time datetime     not null comment '创建时间'
)
    comment '学习资源表';

create database qm_teacher;
use qm_teacher;

create table member
(
    id          bigint           not null comment '家教平台编号'
        primary key,
    name        varchar(100)     not null comment '家教平台名称',
    sort        int              not null comment '排序',
    status      char default '1' not null comment '家教平台状态',
    create_time datetime         not null comment '平台创建时间'
)
    comment '家教平台表';

create table message
(
    id          bigint auto_increment comment '家教信息编号'
        primary key,
    member_id   bigint           not null comment '家教平台id',
    text        varchar(500)     not null comment '家教信息',
    status      char default '1' not null comment '家教信息状态',
    create_time datetime         not null comment '家教信息创建时间',
    sort        int  default 1   not null comment '排序'
)
    comment '家教信息表';

create table ord
(
    id          bigint       not null comment '订单编号'
        primary key,
    username    varchar(100) not null comment '用户id',
    message_id  bigint       not null comment '家教id',
    create_time datetime     not null comment '下单时间'
)
    comment '订单表';

create table user
(
    id          bigint           not null comment '用户编号'
        primary key,
    username    varchar(30)      not null comment '用户名',
    password    varchar(30)      not null comment '密码',
    status      char default '1' not null comment '用户状态',
    create_time datetime         not null comment '用户创建时间',
    constraint username
        unique (username)
)
    comment '管理端用户表';