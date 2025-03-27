SELECT * FROM `eshop_log`.`tb_order_log`
WHERE `description` LIKE '加工包裹声明发货声明发货失败%'
and `order_no` like 'PONY%';

# 仓发
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_waybill_syn_record`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and log.`order_no` LIKE 'PONY%';

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_waybill_syn_record` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and log.`order_no` LIKE 'PONY%';

  # JIT
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_waybill_syn_record`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and log.`order_no` LIKE 'PON%';

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_waybill_syn_record` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and log.`order_no` LIKE 'PON%';


# 作废订单
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 3 and sr.`order_status` = -1;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '加工包裹声明发货声明发货失败%'
  and sr.`platform_id` = 3 and sr.`order_status` = -1;