package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsFacilitator;
import com.eshop.mapper.logistics.TbLogisticsFacilitatorMapper;
import com.eshop.service.logistics.ITbLogisticsFacilitatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流服务商 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbLogisticsFacilitatorServiceImpl extends ServiceImpl<TbLogisticsFacilitatorMapper, TbLogisticsFacilitator> implements ITbLogisticsFacilitatorService {

}
