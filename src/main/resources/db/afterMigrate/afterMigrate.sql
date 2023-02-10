 set foreign_key_checks = 0;
 delete from product;
 delete from warehouse;
 delete from inventory;
 set foreign_key_checks = 1;
 alter table product auto_increment =1;
 alter table warehouse auto_increment =1;
 alter table inventory auto_increment =1;

insert into product(sku, name, quantity) values (4343, "SH Elseve", 20);
insert into warehouse (locality, type) values ("São Paulo", "ECOMMERCE");
insert into warehouse (locality, type) values ("Moema", "PHYSICAL_STORE");
insert into inventory(quantity, product_sku, warehouse_id) values (12, 4343, 1);
insert into inventory(quantity, product_sku, warehouse_id) values (8, 4343, 2);
