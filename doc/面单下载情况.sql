ALTER TABLE `eshop_order`.`tb_waybill_label_download`
    ADD INDEX `idx_download_status` (`download_status`);

# 使用范围查询：如果 download_status 是数值类型，可以改为范围查询


SELECT * FROM `eshop_order`.`tb_waybill_label_download`
WHERE `download_status` < '5' OR `download_status` > '5'

    为什么

使用范围查询来替代 <>（不等于）条件，主要是为了提高查询性能，尤其是在某些情况下可以更好地利用索引。以下是详细原因和解释：


数据库索引（如B+树索引）通常对等值查询（=）和范围查询（<、>、BETWEEN）有较好的支持，但对于 <>（不等于）条件的支持较弱。原因如下：

​等值查询：索引可以直接定位到特定值，效率很高。
​范围查询：索引可以快速定位到一个范围内的值，效率也较高。
​不等于查询：索引需要扫描所有不等于指定值的记录，效率较低。



ALTER TABLE `eshop_order`.`tb_waybill_face_sheet_task`
    ADD INDEX `idx_is_download` (`is_download`);

SELECT * FROM `eshop_order`.`tb_waybill_face_sheet_task`
WHERE `is_download` = '2'
    LIMIT 0,1000;