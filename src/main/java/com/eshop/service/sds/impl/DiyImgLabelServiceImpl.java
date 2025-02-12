package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DiyImgLabel;
import com.eshop.mapper.sds.DiyImgLabelMapper;
import com.eshop.service.sds.IDiyImgLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 图库标签中间表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DiyImgLabelServiceImpl extends ServiceImpl<DiyImgLabelMapper, DiyImgLabel> implements IDiyImgLabelService {

}
