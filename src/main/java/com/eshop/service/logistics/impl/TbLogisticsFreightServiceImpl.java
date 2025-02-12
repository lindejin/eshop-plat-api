package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsFreight;
import com.eshop.mapper.logistics.TbLogisticsFreightMapper;
import com.eshop.service.logistics.ITbLogisticsFreightService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流资费 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbLogisticsFreightServiceImpl extends ServiceImpl<TbLogisticsFreightMapper, TbLogisticsFreight> implements ITbLogisticsFreightService {

}
