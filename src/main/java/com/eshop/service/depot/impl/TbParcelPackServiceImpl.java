package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcelPack;
import com.eshop.mapper.depot.TbParcelPackMapper;
import com.eshop.service.depot.ITbParcelPackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹打包 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbParcelPackServiceImpl extends ServiceImpl<TbParcelPackMapper, TbParcelPack> implements ITbParcelPackService {

}
