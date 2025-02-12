package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductInventory;
import com.eshop.mapper.product.DhProductInventoryMapper;
import com.eshop.service.product.IDhProductInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品备货信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductInventoryServiceImpl extends ServiceImpl<DhProductInventoryMapper, DhProductInventory> implements IDhProductInventoryService {

}
