package com.eshop.util.platform.api.service.marketing.temu;

import com.eshop.util.platform.api.service.marketing.temu.dto.TemuActivityListReqDTO;
import com.eshop.util.platform.api.service.marketing.temu.vo.TemuActivityListRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuActivityCall {

    /**
     * 卖家端查询活动列表接口
     */
    TemuActivityListRespVO marketingActivityListGet(TemuAppClientDTO publicDto, TemuActivityListReqDTO reqDTO) throws Exception;
}
