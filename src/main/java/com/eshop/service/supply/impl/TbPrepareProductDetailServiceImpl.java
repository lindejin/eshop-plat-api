package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPrepareProductDetail;
import com.eshop.mapper.supply.TbPrepareProductDetailMapper;
import com.eshop.service.supply.ITbPrepareProductDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 备货单详情  服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_supply")
@Service
public class TbPrepareProductDetailServiceImpl extends ServiceImpl<TbPrepareProductDetailMapper, TbPrepareProductDetail> implements ITbPrepareProductDetailService {

}
