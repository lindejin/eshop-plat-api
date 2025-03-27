
SELECT
  *
FROM
  `eshop_config`.`tb_shop`
WHERE
  `id` IN (SELECT `shop_id` FROM `eshop_log`.`tb_shop_auth_log` WHERE `operate_property` = '授权失败' AND `operate_time` >= '2025-03-23 22:00:06' )
  order by `platform_code` DESC
