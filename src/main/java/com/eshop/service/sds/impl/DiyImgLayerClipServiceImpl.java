package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DiyImgLayerClip;
import com.eshop.mapper.sds.DiyImgLayerClipMapper;
import com.eshop.service.sds.IDiyImgLayerClipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 图层定位 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class DiyImgLayerClipServiceImpl extends ServiceImpl<DiyImgLayerClipMapper, DiyImgLayerClip> implements IDiyImgLayerClipService {

}
