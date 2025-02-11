package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbMaterialClip;
import com.eshop.mapper.sds.TbMaterialClipMapper;
import com.eshop.service.sds.ITbMaterialClipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 素材建议定位 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbMaterialClipServiceImpl extends ServiceImpl<TbMaterialClipMapper, TbMaterialClip> implements ITbMaterialClipService {

}
