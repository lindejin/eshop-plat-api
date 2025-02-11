package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductLabelDetail;
import com.eshop.mapper.product.TbProductLabelDetailMapper;
import com.eshop.service.product.ITbProductLabelDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品-标签详情 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductLabelDetailServiceImpl extends ServiceImpl<TbProductLabelDetailMapper, TbProductLabelDetail> implements ITbProductLabelDetailService {

}
