package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsHandoverInfo;
import com.eshop.mapper.depot.AmsHandoverInfoMapper;
import com.eshop.service.depot.IAmsHandoverInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 交接单表，用于ams lbx 交接单的相关信息 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class AmsHandoverInfoServiceImpl extends ServiceImpl<AmsHandoverInfoMapper, AmsHandoverInfo> implements IAmsHandoverInfoService {

}
