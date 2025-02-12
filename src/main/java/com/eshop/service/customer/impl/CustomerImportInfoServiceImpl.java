package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerImportInfo;
import com.eshop.mapper.customer.CustomerImportInfoMapper;
import com.eshop.service.customer.ICustomerImportInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 导入的客户信息表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_customer")
@Service
public class CustomerImportInfoServiceImpl extends ServiceImpl<CustomerImportInfoMapper, CustomerImportInfo> implements ICustomerImportInfoService {

}
