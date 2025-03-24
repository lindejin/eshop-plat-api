
# 清除已推送包裹
UPDATE eshop_order.tb_waybill_label_download t
LEFT JOIN eshop_depot.tb_process_parcel o ON t.parcel_no = o.parcel_no
SET t.download_status = '5'
WHERE t.download_status <> '5'
	AND t.platform_id = '5'
	AND o.parcel_status is not null;

# 作废订单处理
UPDATE tb_waybill_label_download t
LEFT JOIN tb_order o ON t.order_no = o.order_no
SET t.download_status = '5'
WHERE t.download_status <> '5'
	AND t.platform_id = '5'
and o.order_status = -1;

# 虾皮订单已取消
UPDATE tb_waybill_label_download t
LEFT JOIN tb_order o ON t.order_no = o.order_no
SET t.download_status = '5'
WHERE t.download_status <> '5'
	AND t.platform_id = '5'
	AND o.platform_order_status = 1008;