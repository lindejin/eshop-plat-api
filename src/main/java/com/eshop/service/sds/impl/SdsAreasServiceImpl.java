package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsAreas;
import com.eshop.mapper.sds.SdsAreasMapper;
import com.eshop.service.sds.ISdsAreasService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds地址基础数据 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class SdsAreasServiceImpl extends ServiceImpl<SdsAreasMapper, SdsAreas> implements ISdsAreasService {

}
