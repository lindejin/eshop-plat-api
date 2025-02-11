package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProduct;
import com.eshop.mapper.sds.TkProductMapper;
import com.eshop.service.sds.ITkProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TkProductServiceImpl extends ServiceImpl<TkProductMapper, TkProduct> implements ITkProductService {

}
