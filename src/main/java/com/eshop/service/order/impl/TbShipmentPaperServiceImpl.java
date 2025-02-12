package com.eshop.service.order.impl;

import com.eshop.entity.order.TbShipmentPaper;
import com.eshop.mapper.order.TbShipmentPaperMapper;
import com.eshop.service.order.ITbShipmentPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 发货单纸张信息表 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbShipmentPaperServiceImpl extends ServiceImpl<TbShipmentPaperMapper, TbShipmentPaper> implements ITbShipmentPaperService {

}
