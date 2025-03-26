# 虾皮订单 取消 查询订单商品
SELECT op.*
FROM tb_order o
JOIN tb_order_products op ON o.order_no = op.order_no
WHERE o.platform_id = 5
  AND o.platform_order_status = 1008
  AND (op.product_sku IS NULL OR op.product_sku = '')
GROUP BY o.id;

# 虾皮取消订单
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 5
  AND o.platform_order_status = 1008
  AND (op.product_sku IS NULL OR op.product_sku = '');

  # 虾皮已完成订单
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 5
  AND o.platform_order_status = 1010
  AND (op.product_sku IS NULL OR op.product_sku = '');


# 虾皮订单作废
UPDATE tb_order_products op
JOIN tb_order o ON op.order_no = o.order_no
SET op.product_sku = 'CANCELLED'
WHERE o.platform_id = 5
  AND o.`order_status` = -1
  AND (op.product_sku IS NULL OR op.product_sku = '');