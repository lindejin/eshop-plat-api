package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.service.product.temu.dto.TemuSizeChartGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuSizeChartGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuSizeChartCall {


    /**
     * 查询尺码表模板
     * 更新时间：2025-03-13 15:57:43
     * 接口介绍：查询已创建的尺码表模板
     * bg.goods.sizecharts.get
     * CN
     */
    TemuSizeChartGetRespVO sizeChartGet(TemuAppClientDTO temuAcDTO, TemuSizeChartGetReqDTO reqDTO) throws Exception;

}
