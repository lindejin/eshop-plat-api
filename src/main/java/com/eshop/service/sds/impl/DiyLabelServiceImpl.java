package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DiyLabel;
import com.eshop.mapper.sds.DiyLabelMapper;
import com.eshop.service.sds.IDiyLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 图库标签 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class DiyLabelServiceImpl extends ServiceImpl<DiyLabelMapper, DiyLabel> implements IDiyLabelService {

}
