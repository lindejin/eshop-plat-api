package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsMailAddress;
import com.eshop.mapper.logistics.TbLogisticsMailAddressMapper;
import com.eshop.service.logistics.ITbLogisticsMailAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流方式与邮寄地址关联表 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbLogisticsMailAddressServiceImpl extends ServiceImpl<TbLogisticsMailAddressMapper, TbLogisticsMailAddress> implements ITbLogisticsMailAddressService {

}
