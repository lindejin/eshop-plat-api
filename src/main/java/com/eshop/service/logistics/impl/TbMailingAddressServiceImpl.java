package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbMailingAddress;
import com.eshop.mapper.logistics.TbMailingAddressMapper;
import com.eshop.service.logistics.ITbMailingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 回邮地址 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_logistics")
@Service
public class TbMailingAddressServiceImpl extends ServiceImpl<TbMailingAddressMapper, TbMailingAddress> implements ITbMailingAddressService {

}
