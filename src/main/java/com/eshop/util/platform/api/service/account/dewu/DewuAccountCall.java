package com.eshop.util.platform.api.service.account.dewu;

import com.eshop.util.platform.api.client.dewu.DewuApiInvoker;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.service.account.dewu.dto.DewuMerchantBaseInfoReqDTO;
import com.eshop.util.platform.api.service.account.dewu.vo.DewuMerchantBaseInfoRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DewuAccountCall {

    @Autowired
    private DewuApiInvoker dewuApiInvoker;

    /**
     * 查询商户基础信息
     * /dop/api/v1/common/merchant/base/info
     *
     */
    public DewuMerchantBaseInfoRespVO getMerchantBaseInfo(DewuAppClientDTO acDTO, DewuMerchantBaseInfoReqDTO reqDTO) throws Exception {
        String method = "/dop/api/v1/common/merchant/base/info";
        DewuMerchantBaseInfoRespVO respVO = dewuApiInvoker.execute(
                acDTO,
                method,
                DewuMerchantBaseInfoRespVO.class,
                reqDTO
        );
        if (respVO!=null&& respVO.getData()!=null){
            respVO.setMerchant_id(respVO.getData().getMerchant_id());
            respVO.setType_id(respVO.getData().getType_id());
        }
        return respVO;
    }
}
