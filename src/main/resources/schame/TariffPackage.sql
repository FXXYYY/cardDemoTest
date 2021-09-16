create table tb_tariff_package (
     id                             bigint auto_increment not null comment 'id',
     name                           varchar(50) not null default '' comment '套餐包名称',
     supplier_pkg_id                varchar(50) not null default '' comment '供应商外键',
     supplier_product_id            varchar(50) not null default '' comment '供应生产商外键',
     supplier_attr_id               bigint not null default -1 comment '',
     supplier_value                 varchar(50) not null default '' comment '',
     create_time                    varchar(20) not null  comment '创建时间',
     modify_time                    varchar(20) not null  comment '修改时间',
     constraint pk_tb_tariff_package primary key (id)
)engine=innodb default charset=utf8mb4 comment 'tariff_package';
