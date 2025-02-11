package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerIdentifierDetail;
import com.eshop.mapper.customer.CustomerIdentifierDetailMapper;
import com.eshop.service.customer.ICustomerIdentifierDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户标识明细表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_customer")
@Service
public class CustomerIdentifierDetailServiceImpl extends ServiceImpl<CustomerIdentifierDetailMapper, CustomerIdentifierDetail> implements ICustomerIdentifierDetailService {

}
