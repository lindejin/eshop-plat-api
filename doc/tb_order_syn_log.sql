# 批量删除
DELETE FROM `eshop_log`.`tb_order_syn_log`
WHERE `exception_log` LIKE '%已取消%'
LIMIT 10000;

# 批量删除
DELETE FROM `eshop_log`.`tb_order_syn_log`
WHERE `exception_log` LIKE '%交货截止时间为0%'
LIMIT 10000;

# 批量删除
DELETE FROM `eshop_log`.`tb_order_syn_log`
WHERE `exception_log` LIKE '%未付款%'
    LIMIT 10000;

# 批量删除
DELETE FROM `eshop_log`.`tb_order_syn_log`
WHERE `exception_log` LIKE '%未支付%'
    LIMIT 10000;

# 订单主表存在
DELETE sol
FROM eshop_log.tb_order_syn_log sol
left JOIN eshop_order.tb_order o ON sol.order_no = o.order_no
where o.order_no is not null and sol.operate_property = '增量';
