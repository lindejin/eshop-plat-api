package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotShelf;
import com.eshop.mapper.depot.TbDepotShelfMapper;
import com.eshop.service.depot.ITbDepotShelfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 货架 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbDepotShelfServiceImpl extends ServiceImpl<TbDepotShelfMapper, TbDepotShelf> implements ITbDepotShelfService {

}
