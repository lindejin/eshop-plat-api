package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillLabelDownload;
import com.eshop.mapper.order.TbWaybillLabelDownloadMapper;
import com.eshop.service.order.ITbWaybillLabelDownloadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 面单阶段下载 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillLabelDownloadServiceImpl extends ServiceImpl<TbWaybillLabelDownloadMapper, TbWaybillLabelDownload> implements ITbWaybillLabelDownloadService {

}
