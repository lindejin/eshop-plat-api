package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbInventoryRecord;
import com.eshop.mapper.depot.TbInventoryRecordMapper;
import com.eshop.service.depot.ITbInventoryRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 盘点计划 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbInventoryRecordServiceImpl extends ServiceImpl<TbInventoryRecordMapper, TbInventoryRecord> implements ITbInventoryRecordService {

}
