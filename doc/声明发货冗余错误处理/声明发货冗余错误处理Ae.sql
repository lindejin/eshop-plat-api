# 删除已声明
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_waybill_syn_record
    WHERE tb_waybill_syn_record.parcel_no = tb_waybill_syn_err.parcel_no
) and platform_id = 3;
# 删除多余
DELETE FROM tb_waybill_syn_err
WHERE is_delete = 1;

# 删除自己创建的订单
DELETE FROM tb_waybill_syn_err
WHERE order_no LIKE '9000000%';

# 虾皮平台 删除订单 订单作废
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      and tb_order.platform_id = 3
      AND tb_order.order_status = -1
);
-- jit
-- 单据状态
-- 10:待确认
-- 15:已确认
-- 17:待发货
-- 20:待收货
-- 21:已到仓
-- 30:部分收货
-- 40:收货完成
-- -99:已取消,不传则返回所有状态的采购单
# AE平台 jit 删除订单取消
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '99'
      and tb_order.platform_id = 3
);

# AE平台 jit 删除收货完成
DELETE FROM tb_waybill_syn_err
WHERE EXISTS (
    SELECT 1
    FROM tb_order
    WHERE tb_order.order_no = tb_waybill_syn_err.order_no
      AND tb_order.platform_order_status = '40'
      and tb_order.platform_id = 3
);