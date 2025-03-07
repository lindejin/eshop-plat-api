package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillTrack;
import com.eshop.mapper.order.TbWaybillTrackMapper;
import com.eshop.service.order.ITbWaybillTrackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 运单轨迹 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbWaybillTrackServiceImpl extends ServiceImpl<TbWaybillTrackMapper, TbWaybillTrack> implements ITbWaybillTrackService {

}
