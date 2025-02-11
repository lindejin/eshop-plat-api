package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillSite;
import com.eshop.mapper.order.TbWaybillSiteMapper;
import com.eshop.service.order.ITbWaybillSiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 运单地址 / 收货地址 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillSiteServiceImpl extends ServiceImpl<TbWaybillSiteMapper, TbWaybillSite> implements ITbWaybillSiteService {

}
