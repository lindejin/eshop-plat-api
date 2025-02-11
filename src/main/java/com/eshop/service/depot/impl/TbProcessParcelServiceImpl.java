package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessParcel;
import com.eshop.mapper.depot.TbProcessParcelMapper;
import com.eshop.service.depot.ITbProcessParcelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工包裹 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbProcessParcelServiceImpl extends ServiceImpl<TbProcessParcelMapper, TbProcessParcel> implements ITbProcessParcelService {

}
