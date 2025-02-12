package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductClip;
import com.eshop.mapper.sds.ScmProductClipMapper;
import com.eshop.service.sds.IScmProductClipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品定位价格 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductClipServiceImpl extends ServiceImpl<ScmProductClipMapper, ScmProductClip> implements IScmProductClipService {

}
