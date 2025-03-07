package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessSkuRecord;
import com.eshop.mapper.depot.TbProcessSkuRecordMapper;
import com.eshop.service.depot.ITbProcessSkuRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工sku操作记录 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbProcessSkuRecordServiceImpl extends ServiceImpl<TbProcessSkuRecordMapper, TbProcessSkuRecord> implements ITbProcessSkuRecordService {

}
