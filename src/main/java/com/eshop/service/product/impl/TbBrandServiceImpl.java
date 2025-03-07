package com.eshop.service.product.impl;

import com.eshop.entity.product.TbBrand;
import com.eshop.mapper.product.TbBrandMapper;
import com.eshop.service.product.ITbBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements ITbBrandService {

}
