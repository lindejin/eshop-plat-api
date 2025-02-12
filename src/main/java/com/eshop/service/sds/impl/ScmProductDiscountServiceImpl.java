package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductDiscount;
import com.eshop.mapper.sds.ScmProductDiscountMapper;
import com.eshop.service.sds.IScmProductDiscountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品等级折扣 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductDiscountServiceImpl extends ServiceImpl<ScmProductDiscountMapper, ScmProductDiscount> implements IScmProductDiscountService {

}
