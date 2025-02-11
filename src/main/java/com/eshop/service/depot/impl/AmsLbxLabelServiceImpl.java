package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsLbxLabel;
import com.eshop.mapper.depot.AmsLbxLabelMapper;
import com.eshop.service.depot.IAmsLbxLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * ams LBX面单信息表 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class AmsLbxLabelServiceImpl extends ServiceImpl<AmsLbxLabelMapper, AmsLbxLabel> implements IAmsLbxLabelService {

}
