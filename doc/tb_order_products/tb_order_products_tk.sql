# tk订单 取消 查询订单商品
SELECT op.*
FROM tb_order o
JOIN tb_order_products op ON o.order_no = op.order_no
WHERE o.platform_id = 7
  AND o.platform_order_status = 140
  AND (op.product_sku IS NULL OR op.product_sku = '')
GROUP BY o.id;


# tk订单取消
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 7
  AND o.platform_order_status = 140
  AND (op.product_sku IS NULL OR op.product_sku = '');


# tk订单已完成
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 7
  AND o.platform_order_status = 130
  AND (op.product_sku IS NULL OR op.product_sku = '');


# tk订单作废
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 7
  AND o.`order_status` = -1
  AND (op.product_sku IS NULL OR op.product_sku = '');