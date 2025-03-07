package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerInfo;
import com.eshop.mapper.customer.CustomerInfoMapper;
import com.eshop.service.customer.ICustomerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_customer")
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService {

}
