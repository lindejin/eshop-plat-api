package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductDepot;
import com.eshop.mapper.product.TbProductDepotMapper;
import com.eshop.service.product.ITbProductDepotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品发货仓库 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductDepotServiceImpl extends ServiceImpl<TbProductDepotMapper, TbProductDepot> implements ITbProductDepotService {

}
