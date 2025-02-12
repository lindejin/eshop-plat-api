package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerCategory;
import com.eshop.mapper.customer.CustomerCategoryMapper;
import com.eshop.service.customer.ICustomerCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户分类表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_customer")
@Service
public class CustomerCategoryServiceImpl extends ServiceImpl<CustomerCategoryMapper, CustomerCategory> implements ICustomerCategoryService {

}
