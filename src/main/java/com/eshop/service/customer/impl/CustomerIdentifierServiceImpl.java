package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerIdentifier;
import com.eshop.mapper.customer.CustomerIdentifierMapper;
import com.eshop.service.customer.ICustomerIdentifierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户标识表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_customer")
@Service
public class CustomerIdentifierServiceImpl extends ServiceImpl<CustomerIdentifierMapper, CustomerIdentifier> implements ICustomerIdentifierService {

}
