package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbMaterialDetail;
import com.eshop.mapper.sds.TbMaterialDetailMapper;
import com.eshop.service.sds.ITbMaterialDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 素材明细 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbMaterialDetailServiceImpl extends ServiceImpl<TbMaterialDetailMapper, TbMaterialDetail> implements ITbMaterialDetailService {

}
