
UPDATE tb_order_products op
SET op.product_sku = null
WHERE op.product_sku = 'CANCELLED';


UPDATE tb_order_products op
SET op.shop_sku = null
WHERE op.shop_sku IS NULL OR op.shop_sku = '';