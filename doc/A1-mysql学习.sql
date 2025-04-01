-- 查看索引使用次数（MySQL 5.7+）
SELECT
  OBJECT_SCHEMA, OBJECT_NAME, INDEX_NAME,
  COUNT_READ  -- 索引被使用的次数
FROM performance_schema.table_io_waits_summary_by_index_usage
WHERE OBJECT_NAME = 'tb_waybill_syn_err';

