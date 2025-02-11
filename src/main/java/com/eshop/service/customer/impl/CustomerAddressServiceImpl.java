package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerAddress;
import com.eshop.mapper.customer.CustomerAddressMapper;
import com.eshop.service.customer.ICustomerAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户地址表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_customer")
@Service
public class CustomerAddressServiceImpl extends ServiceImpl<CustomerAddressMapper, CustomerAddress> implements ICustomerAddressService {

}
