package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsDeclare;
import com.eshop.mapper.logistics.TbLogisticsDeclareMapper;
import com.eshop.service.logistics.ITbLogisticsDeclareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 申报信息 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbLogisticsDeclareServiceImpl extends ServiceImpl<TbLogisticsDeclareMapper, TbLogisticsDeclare> implements ITbLogisticsDeclareService {

}
