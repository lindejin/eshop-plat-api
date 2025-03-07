package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillObtainRecord;
import com.eshop.mapper.order.TbWaybillObtainRecordMapper;
import com.eshop.service.order.ITbWaybillObtainRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹运单号获取记录 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbWaybillObtainRecordServiceImpl extends ServiceImpl<TbWaybillObtainRecordMapper, TbWaybillObtainRecord> implements ITbWaybillObtainRecordService {

}
