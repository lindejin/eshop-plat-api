package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSkuInven;
import com.eshop.mapper.product.TbProductSkuInvenMapper;
import com.eshop.service.product.ITbProductSkuInvenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sku各仓库销售信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSkuInvenServiceImpl extends ServiceImpl<TbProductSkuInvenMapper, TbProductSkuInven> implements ITbProductSkuInvenService {

}
