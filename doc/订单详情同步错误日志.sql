SELECT
    *
FROM
    `eshop_log`.`tb_order_syn_log`
WHERE
    `exception_log` LIKE '%java.lang.NullPointerException%'


DELETE sol
FROM eshop_log.tb_order_syn_log sol
WHERE
  sol.`exception_log` LIKE '%已取消%'

  DELETE sol
FROM eshop_log.tb_order_syn_log sol
WHERE
  sol.`exception_log` LIKE '%java.lang.NullPointerException%'


DELETE sol
FROM eshop_log.tb_order_syn_log sol
WHERE
  sol.`exception_log` LIKE '%交货截止时间为0'


DELETE sol
FROM eshop_log.tb_order_syn_log sol
WHERE
  sol.`exception_log` LIKE '%未付款订单不同步,当前订单状态未付款'


DELETE sol
FROM eshop_log.tb_order_syn_log sol
WHERE
  sol.operate_property LIKE '%订单回调失败'

DELETE sol
FROM eshop_log.tb_order_syn_log sol
INNER JOIN eshop_order.tb_order o ON sol.order_no = o.order_no
WHERE sol.operate_property = '订单回调失败';


DELETE sol
FROM eshop_log.tb_order_syn_log sol
INNER JOIN eshop_order.tb_order o ON sol.order_no = o.order_no
WHERE sol.operate_property = '增量';