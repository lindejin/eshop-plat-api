package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessParcelRecord;
import com.eshop.mapper.depot.TbProcessParcelRecordMapper;
import com.eshop.service.depot.ITbProcessParcelRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工包裹操作记录 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbProcessParcelRecordServiceImpl extends ServiceImpl<TbProcessParcelRecordMapper, TbProcessParcelRecord> implements ITbProcessParcelRecordService {

}
