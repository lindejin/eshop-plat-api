
# dh订单 取消 查询订单商品
SELECT op.*
FROM tb_order o
JOIN tb_order_products op ON o.order_no = op.order_no
WHERE o.platform_id = 1
  AND o.platform_order_status = 111000
  AND (op.product_sku IS NULL OR op.product_sku = '')
GROUP BY o.id;


# dh订单取消
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 1
  AND o.platform_order_status = 111000
  AND (op.product_sku IS NULL OR op.product_sku = '');

# dh订单交易成功
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 1
  AND o.platform_order_status = 102111
  AND (op.product_sku IS NULL OR op.product_sku = '');

# dh订单交易关闭
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 1
  AND o.platform_order_status = 111111
  AND (op.product_sku IS NULL OR op.product_sku = '');