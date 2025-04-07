SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_waybill_syn_record`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.order_no is not null;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  INNER JOIN `eshop_order`.`tb_waybill_syn_record` as sr
    ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%';


# 作废订单
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 5 and sr.`order_status` = -1;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 5 and sr.`order_status` = -1;

# 取消订单

SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 5 and sr.`platform_order_status` = '1008';

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 5 and sr.`platform_order_status` = '1008';


# 订单已完成

SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 5 and sr.`platform_order_status` = '1010';

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 5 and sr.`platform_order_status` = '1010';