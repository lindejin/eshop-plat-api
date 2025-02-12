package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbCommonLogisticsMode;
import com.eshop.mapper.logistics.TbCommonLogisticsModeMapper;
import com.eshop.service.logistics.ITbCommonLogisticsModeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 共用_物流方式 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbCommonLogisticsModeServiceImpl extends ServiceImpl<TbCommonLogisticsModeMapper, TbCommonLogisticsMode> implements ITbCommonLogisticsModeService {

}
