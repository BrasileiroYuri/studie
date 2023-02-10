create table product
(
    sku      bigint      not null,
    name     varchar(255) not null,
    quantity bigint      not null,
    primary key (sku)
) engine=InnoDB charset = utf8mb4;

create table warehouse
(
    id       bigint auto_increment,
    locality varchar(255) not null,
    type     varchar(20)  not null,
    primary key (id)
) engine=InnoDB charset = utf8mb4;

create table inventory
(
    id           bigint auto_increment,
    quantity     bigint not null,
    product_sku  bigint not null,
    warehouse_id bigint not null,
    primary key (id),
    constraint product_fk foreign key (product_sku) references product (sku),
    constraint warehouse_fk foreign key (warehouse_id) references warehouse (id)
) engine=InnoDB charset=utf8mb4;
