package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.service.product.temu.dto.TemuModelInfoGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuModelInfoGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuModelCall {


    /**
     * bg.modelinfo.get
     * 模特信息查询
     * 更新时间：2025-03-26 14:33:26
     * 接口介绍：模特信息查询
     * CN
     */
    TemuModelInfoGetRespVO modelInfoGet(TemuAppClientDTO publicDto, TemuModelInfoGetReqDTO reqDTO) throws Exception;

}
