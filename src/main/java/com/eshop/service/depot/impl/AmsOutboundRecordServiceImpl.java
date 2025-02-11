package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsOutboundRecord;
import com.eshop.mapper.depot.AmsOutboundRecordMapper;
import com.eshop.service.depot.IAmsOutboundRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * AMS出库记录 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class AmsOutboundRecordServiceImpl extends ServiceImpl<AmsOutboundRecordMapper, AmsOutboundRecord> implements IAmsOutboundRecordService {

}
