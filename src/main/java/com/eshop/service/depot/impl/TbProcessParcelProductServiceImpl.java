package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessParcelProduct;
import com.eshop.mapper.depot.TbProcessParcelProductMapper;
import com.eshop.service.depot.ITbProcessParcelProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工包裹商品 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbProcessParcelProductServiceImpl extends ServiceImpl<TbProcessParcelProductMapper, TbProcessParcelProduct> implements ITbProcessParcelProductService {

}
