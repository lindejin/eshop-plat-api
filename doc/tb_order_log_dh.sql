SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
   sr.order_no is  null;



DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  sr.order_no is  null;