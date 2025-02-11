package com.eshop.service.customer.impl;

import com.eshop.entity.customer.CustomerPurchaseRecord;
import com.eshop.mapper.customer.CustomerPurchaseRecordMapper;
import com.eshop.service.customer.ICustomerPurchaseRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户购买记录表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_customer")
@Service
public class CustomerPurchaseRecordServiceImpl extends ServiceImpl<CustomerPurchaseRecordMapper, CustomerPurchaseRecord> implements ICustomerPurchaseRecordService {

}
