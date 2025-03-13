
# 批量删除
DELETE FROM `eshop_log`.`tb_order_err_log`
WHERE `err_describe` LIKE '新增 订单过滤后为空！%'
    LIMIT 1000;


# 批量删除
DELETE FROM `eshop_log`.`tb_order_err_log`
WHERE `err_describe` LIKE '更新 订单过滤后为空！%'
    LIMIT 1000;