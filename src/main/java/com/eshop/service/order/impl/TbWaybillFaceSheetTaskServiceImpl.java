package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillFaceSheetTask;
import com.eshop.mapper.order.TbWaybillFaceSheetTaskMapper;
import com.eshop.service.order.ITbWaybillFaceSheetTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 面单任务运行日志 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbWaybillFaceSheetTaskServiceImpl extends ServiceImpl<TbWaybillFaceSheetTaskMapper, TbWaybillFaceSheetTask> implements ITbWaybillFaceSheetTaskService {

}
