# 订单取消
DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
LEFT JOIN tb_order AS t2 ON t1.order_id = t2.id
WHERE t2.platform_order_status = '111000';

# 交易关闭
DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
LEFT JOIN tb_order AS t2 ON t1.order_id = t2.id
WHERE t2.platform_order_status = '111111';

# 交易成功
DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
LEFT JOIN tb_order AS t2 ON t1.order_id = t2.id
WHERE t2.platform_order_status = '102111';

DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
LEFT JOIN tb_order AS t2 ON t1.order_id = t2.id
WHERE t2.order_status = -1

DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
WHERE t1.order_id is null

# 虾皮 tk
DELETE t
FROM eshop_order.tb_waybill_shipment_err AS t
LEFT JOIN eshop_depot.tb_process_parcel AS t1 ON t1.parcel_no = t.parcel_no
WHERE t1.parcel_no is not null

# 虾皮 取消
DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
LEFT JOIN tb_order AS t2 ON t1.order_id = t2.id
WHERE t2.platform_order_status = '1008' and t2.platform_id = 5;


# tk 取消
DELETE t
FROM tb_waybill_shipment_err AS t
LEFT JOIN tb_order_waybill AS t1 ON t1.waybill_id = t.waybill_id
LEFT JOIN tb_order AS t2 ON t1.order_id = t2.id
WHERE t2.platform_order_status = '130' and t2.platform_id = 7;


# 删除子表没关联到主表
DELETE d
FROM tb_waybill_shipment_err_detail d
LEFT JOIN tb_waybill_shipment_err e ON d.waybill_shipment_err_id = e.id
WHERE e.id IS NULL;

# 删除子表旧数据 只留下最新的
DELETE d1
FROM tb_waybill_shipment_err_detail d1
LEFT JOIN tb_waybill_shipment_err_detail d2
ON d1.waybill_shipment_err_id = d2.waybill_shipment_err_id AND d1.err_time < d2.err_time
WHERE d2.id IS NOT NULL;


-- 删除 tb_waybill_shipment_err 表中 is_delete = 1 的记录
DELETE FROM tb_waybill_shipment_err
WHERE is_delete = 1;
