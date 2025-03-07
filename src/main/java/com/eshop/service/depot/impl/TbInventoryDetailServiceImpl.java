package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbInventoryDetail;
import com.eshop.mapper.depot.TbInventoryDetailMapper;
import com.eshop.service.depot.ITbInventoryDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 盘点详情 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbInventoryDetailServiceImpl extends ServiceImpl<TbInventoryDetailMapper, TbInventoryDetail> implements ITbInventoryDetailService {

}
