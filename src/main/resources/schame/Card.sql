create table tb_card (
    id                          bigint auto_increment not null comment 'id',
    msisdn                      varchar(50) not null comment '移动用户的isdn号码',
    iccid                       varchar(50) not null  comment '集成电路卡识别码',
    imsi                        varchar(50)  comment '国际移动用户识别码',
    carrier_type                varchar(5) not null  comment '运营商',
    pkg_id                      bigint not null default -1 comment '套餐包-关联外键',
    remark                      varchar(255) comment '备注',
    version                     bigint not null,
    create_time                 varchar(20) not null  comment '创建时间',
    modify_time                 varchar(20) not null  comment '修改时间',
    constraint ck_tb_card_carrier_type check (carrier_type in ('CMCC','CUCC','CTCC')),
    constraint pk_tb_card primary key (id)
)engine=innodb default charset=utf8mb4 comment 'card';
