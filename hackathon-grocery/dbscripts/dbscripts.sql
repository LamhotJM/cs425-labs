INSERT INTO `gdm-srmdb`.`suppliers` (`contact_phone_number`, `name`, `supplier_number`) VALUES ('(602) 123-9987', 'United Agro-Allied Farms LLC', '100001');
INSERT INTO `gdm-srmdb`.`suppliers` (`contact_phone_number`, `name`, `supplier_number`) VALUES ('(214) 009-1292', 'El Segundo Partners', '100002');
INSERT INTO `gdm-srmdb`.`suppliers` (`name`, `supplier_number`) VALUES ('Organic Farms of West Des Moines', '100003');
INSERT INTO `gdm-srmdb`.`suppliers` (`contact_phone_number`, `name`, `supplier_number`) VALUES ('(778) 172-1099', 'Alliance of Omaha, Nebraska LLC', '100004');

-- -----------------------

INSERT INTO `gdm-srmdb`.`products` (`date_supplied`, `name`, `product_number`, `quantity_in_stock`, `unit_price`, `supplier_id`) VALUES ('2020-03-11', 'Bananas (medium, ripened)', '100000001', '48', '2.25', '3');
INSERT INTO `gdm-srmdb`.`products` (`date_supplied`, `name`, `product_number`, `quantity_in_stock`, `unit_price`, `supplier_id`) VALUES ('2020-02-29', 'Apples (Golden Delicious)', '100000002', '317', '1.05', '1');
INSERT INTO `gdm-srmdb`.`products` (`date_supplied`, `name`, `product_number`, `quantity_in_stock`, `unit_price`, `supplier_id`) VALUES ('2020-03-09', 'Avocados dos Oaxaca, Mexico', '100000003', '218', '4.48', '2');
INSERT INTO `gdm-srmdb`.`products` (`date_supplied`, `name`, `product_number`, `quantity_in_stock`, `unit_price`, `supplier_id`) VALUES ('2020-03-05', 'Pears (Organic, Green)', '100000004', '95', '2.56', '1');
INSERT INTO `gdm-srmdb`.`products` (`date_supplied`, `name`, `product_number`, `quantity_in_stock`, `unit_price`, `supplier_id`) VALUES ('2019-12-17', 'Eggs (Organic, Grade A, Extra Large)', '100000005', '14', '5.35', '3');
