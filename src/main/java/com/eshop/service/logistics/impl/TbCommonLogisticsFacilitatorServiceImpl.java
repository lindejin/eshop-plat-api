package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbCommonLogisticsFacilitator;
import com.eshop.mapper.logistics.TbCommonLogisticsFacilitatorMapper;
import com.eshop.service.logistics.ITbCommonLogisticsFacilitatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 共用_物流服务商 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_logistics")
@Service
public class TbCommonLogisticsFacilitatorServiceImpl extends ServiceImpl<TbCommonLogisticsFacilitatorMapper, TbCommonLogisticsFacilitator> implements ITbCommonLogisticsFacilitatorService {

}
