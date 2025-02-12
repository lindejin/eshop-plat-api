package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSkuGift;
import com.eshop.mapper.product.TbProductSkuGiftMapper;
import com.eshop.service.product.ITbProductSkuGiftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品sku赠品关联表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSkuGiftServiceImpl extends ServiceImpl<TbProductSkuGiftMapper, TbProductSkuGift> implements ITbProductSkuGiftService {

}
