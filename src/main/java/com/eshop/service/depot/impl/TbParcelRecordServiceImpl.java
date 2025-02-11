package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcelRecord;
import com.eshop.mapper.depot.TbParcelRecordMapper;
import com.eshop.service.depot.ITbParcelRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹操作记录 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbParcelRecordServiceImpl extends ServiceImpl<TbParcelRecordMapper, TbParcelRecord> implements ITbParcelRecordService {

}
