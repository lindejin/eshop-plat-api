package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbMailAddress;
import com.eshop.mapper.logistics.TbMailAddressMapper;
import com.eshop.service.logistics.ITbMailAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 寄件地址 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_logistics")
@Service
public class TbMailAddressServiceImpl extends ServiceImpl<TbMailAddressMapper, TbMailAddress> implements ITbMailAddressService {

}
