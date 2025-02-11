package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcel;
import com.eshop.mapper.depot.TbParcelMapper;
import com.eshop.service.depot.ITbParcelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbParcelServiceImpl extends ServiceImpl<TbParcelMapper, TbParcel> implements ITbParcelService {

}
