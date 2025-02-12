package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsLbxShipment;
import com.eshop.mapper.depot.AmsLbxShipmentMapper;
import com.eshop.service.depot.IAmsLbxShipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * ams的lbx货运信息表，用于存储货物的相关信息 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class AmsLbxShipmentServiceImpl extends ServiceImpl<AmsLbxShipmentMapper, AmsLbxShipment> implements IAmsLbxShipmentService {

}
