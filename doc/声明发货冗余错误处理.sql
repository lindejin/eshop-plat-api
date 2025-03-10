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

# 删除订单关闭
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '111111'
);
# 删除订单取消
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '111000'
);

# 删除订单 交易成功
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '102111'
);
# 删除自己创建的订单
DELETE FROM tb_waybill_syn_err
WHERE order_no LIKE '9000000%';