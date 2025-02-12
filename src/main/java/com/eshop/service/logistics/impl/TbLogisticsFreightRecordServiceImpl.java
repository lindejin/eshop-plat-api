package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsFreightRecord;
import com.eshop.mapper.logistics.TbLogisticsFreightRecordMapper;
import com.eshop.service.logistics.ITbLogisticsFreightRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流资费历史记录 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbLogisticsFreightRecordServiceImpl extends ServiceImpl<TbLogisticsFreightRecordMapper, TbLogisticsFreightRecord> implements ITbLogisticsFreightRecordService {

}
