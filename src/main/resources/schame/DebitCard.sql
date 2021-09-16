create table tb_debit_card (
     id                             bigint auto_increment not null comment 'id',
     user_id                        bigint not null default -1 comment '用户-关联外键',
     res_id                         bigint not null default -1 comment '供应商-关联外键',
     status                         integer(12) not null default -1 comment '状态 todo 此字段的用处？',
     is_delete                      integer(12) not null default -1 comment '0未删除，1删除',
     create_time                    varchar(20) not null  comment '创建时间',
     modify_time                    varchar(20) not null  comment '修改时间',
     constraint pk_tb_debit_card primary key (id)
)engine=innodb default charset=utf8mb4 comment 'debit_card';