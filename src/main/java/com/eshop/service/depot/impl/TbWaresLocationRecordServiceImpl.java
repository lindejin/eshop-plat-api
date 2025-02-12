package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbWaresLocationRecord;
import com.eshop.mapper.depot.TbWaresLocationRecordMapper;
import com.eshop.service.depot.ITbWaresLocationRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 仓位商品记录 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbWaresLocationRecordServiceImpl extends ServiceImpl<TbWaresLocationRecordMapper, TbWaresLocationRecord> implements ITbWaresLocationRecordService {

}
