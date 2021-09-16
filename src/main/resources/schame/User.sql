create table tb_user (
     id                          bigint auto_increment not null comment 'id',
     name                        varchar(50) not null default '' comment '姓名',
     w_kno                       varchar(50) not null default '' comment '工号',
     constraint pk_tb_card primary key (id)
)engine=innodb default charset=utf8mb4 comment 'use';
