package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotPosition;
import com.eshop.mapper.depot.TbDepotPositionMapper;
import com.eshop.service.depot.ITbDepotPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 仓位 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbDepotPositionServiceImpl extends ServiceImpl<TbDepotPositionMapper, TbDepotPosition> implements ITbDepotPositionService {

}
