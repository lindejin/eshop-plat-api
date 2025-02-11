package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotBasket;
import com.eshop.mapper.depot.TbDepotBasketMapper;
import com.eshop.service.depot.ITbDepotBasketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 篮子 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbDepotBasketServiceImpl extends ServiceImpl<TbDepotBasketMapper, TbDepotBasket> implements ITbDepotBasketService {

}
