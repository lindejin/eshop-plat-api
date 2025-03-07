package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbQualityControlDetail;
import com.eshop.mapper.depot.TbQualityControlDetailMapper;
import com.eshop.service.depot.ITbQualityControlDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 质检单明细 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbQualityControlDetailServiceImpl extends ServiceImpl<TbQualityControlDetailMapper, TbQualityControlDetail> implements ITbQualityControlDetailService {

}
