package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcelProduct;
import com.eshop.mapper.depot.TbParcelProductMapper;
import com.eshop.service.depot.ITbParcelProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹商品 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbParcelProductServiceImpl extends ServiceImpl<TbParcelProductMapper, TbParcelProduct> implements ITbParcelProductService {

}
