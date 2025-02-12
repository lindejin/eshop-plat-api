package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductClipRange;
import com.eshop.mapper.sds.ScmProductClipRangeMapper;
import com.eshop.service.sds.IScmProductClipRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 定位加工递增百分比 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductClipRangeServiceImpl extends ServiceImpl<ScmProductClipRangeMapper, ScmProductClipRange> implements IScmProductClipRangeService {

}
