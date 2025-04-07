SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_waybill_syn_record`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '声明发货%'
  and sr.order_no is not null;


DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  INNER JOIN `eshop_order`.`tb_waybill_syn_record` as sr
    ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货) %';


# 作废订单
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货)%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货)%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;


SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework.web.client.ResourceAccessException%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework.web.client.ResourceAccessException%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因: java.lang.RuntimeException%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因: java.lang.RuntimeException%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;


# 订单已完成
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework.web.client.HttpServerErrorException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework.web.client.HttpServerErrorException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

# 订单已完成
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货) 失败错误原因:%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货) 失败错误原因:%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

# 订单已完成
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常: (TK声明发货) %'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常: (TK声明发货) %'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

# 订单已完成
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'org.springframework.web.client.ResourceAccessException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'org.springframework.web.client.ResourceAccessException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

# 订单已完成
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因: java.lang.RuntimeException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因: java.lang.RuntimeException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 130;


# 订单已取消
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework.web.client.HttpServerErrorException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework.web.client.HttpServerErrorException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

# 订单已取消
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货) 失败错误原因:%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: (TK声明发货) 失败错误原因:%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

# 订单已取消
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常: (TK声明发货) %'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常: (TK声明发货) %'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;


# 订单已取消
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE 'org.springframework.web.client.ResourceAccessException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'org.springframework.web.client.ResourceAccessException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

# 订单已取消
SELECT
  log.id
FROM
  `eshop_log`.`tb_order_log` as log
  left join `eshop_order`.`tb_order`  as sr on log.order_no =sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因: java.lang.RuntimeException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因: java.lang.RuntimeException%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;



# 作废
DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常: %'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

  # 作废
DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: java.lang.InterruptedException: %'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

# 已交付
  DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常: %'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 122;

# 作废
#
DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因%'
  and sr.`platform_id` = 7 and sr.`order_status` = -1;

  # 取消
  DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '%绑定失败,原因%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;


  # 取消
  DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE '(TikTok运单同步) org.springframework%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;

    # 取消
  DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'org.springframework.web.client.ResourceAccessException:%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;


      # 取消
  DELETE log FROM
  `eshop_log`.`tb_order_log` as log
  left JOIN `eshop_order`.`tb_order` as sr ON log.order_no = sr.order_no
WHERE
  log.`description` LIKE 'java.lang.RuntimeException: 请求异常:%'
  and sr.`platform_id` = 7 and sr.`platform_order_status` = 140;


