# 删除tb_waybill_shipment_err 没有关联到tb_order_waybill表的数据

DELETE FROM tb_waybill_shipment_err
WHERE NOT EXISTS (
    SELECT 1
    FROM tb_order_waybill
    WHERE tb_order_waybill.waybill_id = tb_waybill_shipment_err.waybill_id
);


# 删除tb_waybill_shipment_err_detail无法关联tb_waybill_shipment_err的数据

DELETE FROM tb_waybill_shipment_err_detail
WHERE NOT EXISTS (
    SELECT 1
    FROM tb_waybill_shipment_err
    WHERE tb_waybill_shipment_err.id = tb_waybill_shipment_err_detail.waybill_shipment_err_id
);
# 删除作废订单
DELETE err
FROM tb_waybill_shipment_err err
JOIN tb_order_waybill ow ON err.waybill_id = ow.waybill_id
JOIN tb_order o ON ow.order_id = o.id
WHERE o.order_status = -1;

# 删除订单关闭
DELETE err
FROM tb_waybill_shipment_err err
JOIN tb_order_waybill ow ON err.waybill_id = ow.waybill_id
JOIN tb_order o ON ow.order_id = o.id
WHERE o.platform_order_status = '111111'

# 删除订单取消
DELETE err
FROM tb_waybill_shipment_err err
JOIN tb_order_waybill ow ON err.waybill_id = ow.waybill_id
JOIN tb_order o ON ow.order_id = o.id
WHERE o.platform_order_status = '111000'

# 删除订单 交易成功
DELETE err
FROM tb_waybill_shipment_err err
JOIN tb_order_waybill ow ON err.waybill_id = ow.waybill_id
JOIN tb_order o ON ow.order_id = o.id
WHERE o.platform_order_status = '102111'

# 删除订单 等待买家确认收货
DELETE err
FROM tb_waybill_shipment_err err
JOIN tb_order_waybill ow ON err.waybill_id = ow.waybill_id
JOIN tb_order o ON ow.order_id = o.id
WHERE o.platform_order_status = '101009'

# 删除订单 已发货
DELETE err
FROM tb_waybill_shipment_err err
JOIN tb_order_waybill ow ON err.waybill_id = ow.waybill_id
JOIN tb_order o ON ow.order_id = o.id
WHERE o.platform_order_status = '102111'


# 推送到仓库 就删除
DELETE wse
FROM eshop_order.tb_waybill_shipment_err wse
JOIN eshop_depot.tb_parcel p ON wse.parcel_no = p.parcel_no
WHERE p.parcel_no is not null

# 删除本身删除的数据
DELETE FROM tb_waybill_shipment_err
WHERE is_delete = 1;