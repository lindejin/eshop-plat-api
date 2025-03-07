package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbSupplierReceipt;
import com.eshop.mapper.supply.TbSupplierReceiptMapper;
import com.eshop.service.supply.ITbSupplierReceiptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应商收款账号信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbSupplierReceiptServiceImpl extends ServiceImpl<TbSupplierReceiptMapper, TbSupplierReceipt> implements ITbSupplierReceiptService {

}
