SELECT
  ooo.*
FROM
  `tb_waybill` AS www
  left join tb_order_waybill as ooww on ooww.waybill_id = www.id
  left join tb_order as ooo on ooo.id = ooww.order_id
WHERE
  www.parcel_no = 10000998435

