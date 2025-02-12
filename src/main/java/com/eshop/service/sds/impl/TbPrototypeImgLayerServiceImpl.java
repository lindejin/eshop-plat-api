package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeImgLayer;
import com.eshop.mapper.sds.TbPrototypeImgLayerMapper;
import com.eshop.service.sds.ITbPrototypeImgLayerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模特图图层 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbPrototypeImgLayerServiceImpl extends ServiceImpl<TbPrototypeImgLayerMapper, TbPrototypeImgLayer> implements ITbPrototypeImgLayerService {

}
