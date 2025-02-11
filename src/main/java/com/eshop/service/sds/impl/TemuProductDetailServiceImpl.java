package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductDetail;
import com.eshop.mapper.sds.TemuProductDetailMapper;
import com.eshop.service.sds.ITemuProductDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品详情信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductDetailServiceImpl extends ServiceImpl<TemuProductDetailMapper, TemuProductDetail> implements ITemuProductDetailService {

}
