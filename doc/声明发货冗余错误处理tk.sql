// 删除已声明
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_waybill_syn_record
    WHERE tb_waybill_syn_record.parcel_no = tb_waybill_syn_err.parcel_no
      AND tb_waybill_syn_record.waybill_no = tb_waybill_syn_err.waybill_no
);
# 删除多余
DELETE FROM tb_waybill_syn_err
WHERE is_delete = 1;

# 删除订单 已交付
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '122'
      and tb_order.platform_id = 7
);
# 删除订单 已完成
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '130'
      and tb_order.platform_id = 7
);

# 删除订单 取消
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '140'
      and tb_order.platform_id = 7
);

# 删除订单 等待收集
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '112'
      and tb_order.platform_id = 7
);

# 删除订单 中转
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '121'
      and tb_order.platform_id = 7
);

# 删除自己创建的订单
DELETE FROM tb_waybill_syn_err
WHERE order_no LIKE '9000000%';


# 删除订单 订单作废
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.order_status = -1
);