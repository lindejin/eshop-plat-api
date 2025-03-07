package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbOutboundDetail;
import com.eshop.mapper.depot.TbOutboundDetailMapper;
import com.eshop.service.depot.ITbOutboundDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 出库明细 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbOutboundDetailServiceImpl extends ServiceImpl<TbOutboundDetailMapper, TbOutboundDetail> implements ITbOutboundDetailService {

}
