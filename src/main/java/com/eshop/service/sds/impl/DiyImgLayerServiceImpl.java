package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DiyImgLayer;
import com.eshop.mapper.sds.DiyImgLayerMapper;
import com.eshop.service.sds.IDiyImgLayerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 图库图层 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DiyImgLayerServiceImpl extends ServiceImpl<DiyImgLayerMapper, DiyImgLayer> implements IDiyImgLayerService {

}
