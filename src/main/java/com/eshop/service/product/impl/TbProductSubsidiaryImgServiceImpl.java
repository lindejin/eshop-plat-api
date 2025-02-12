package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSubsidiaryImg;
import com.eshop.mapper.product.TbProductSubsidiaryImgMapper;
import com.eshop.service.product.ITbProductSubsidiaryImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主库附属图片 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSubsidiaryImgServiceImpl extends ServiceImpl<TbProductSubsidiaryImgMapper, TbProductSubsidiaryImg> implements ITbProductSubsidiaryImgService {

}
