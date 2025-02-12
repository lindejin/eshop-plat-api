package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductChartVal;
import com.eshop.mapper.sds.ScmProductChartValMapper;
import com.eshop.service.sds.IScmProductChartValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品尺码对照表值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductChartValServiceImpl extends ServiceImpl<ScmProductChartValMapper, ScmProductChartVal> implements IScmProductChartValService {

}
