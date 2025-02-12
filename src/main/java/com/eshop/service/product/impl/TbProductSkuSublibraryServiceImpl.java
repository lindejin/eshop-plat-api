package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSkuSublibrary;
import com.eshop.mapper.product.TbProductSkuSublibraryMapper;
import com.eshop.service.product.ITbProductSkuSublibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主库与子库sku对应中间表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSkuSublibraryServiceImpl extends ServiceImpl<TbProductSkuSublibraryMapper, TbProductSkuSublibrary> implements ITbProductSkuSublibraryService {

}
