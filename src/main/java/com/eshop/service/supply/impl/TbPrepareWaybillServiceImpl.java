package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPrepareWaybill;
import com.eshop.mapper.supply.TbPrepareWaybillMapper;
import com.eshop.service.supply.ITbPrepareWaybillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 备货单 运单信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_supply")
@Service
public class TbPrepareWaybillServiceImpl extends ServiceImpl<TbPrepareWaybillMapper, TbPrepareWaybill> implements ITbPrepareWaybillService {

}
