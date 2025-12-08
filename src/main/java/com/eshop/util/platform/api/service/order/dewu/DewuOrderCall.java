package com.eshop.util.platform.api.service.order.dewu;

import com.eshop.util.platform.api.client.dewu.DewuApiInvoker;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.service.order.dewu.dto.DewuExpressSheetReqDTO;
import com.eshop.util.platform.api.service.order.dewu.vo.DewuExpressSheetRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DewuOrderCall {

    @Autowired
    private DewuApiInvoker dewuApiInvoker;

    /**
     * 直发订单获取打印面单v2【品牌直发/众筹直发/拍卖直发】
     * /dop/api/v2/order/brand_deliver/express_sheet
     *
     */
    public DewuExpressSheetRespVO getExpressSheet(DewuAppClientDTO acDTO, DewuExpressSheetReqDTO reqDTO) throws Exception {
        String method = "/dop/api/v2/order/brand_deliver/express_sheet";
        return dewuApiInvoker.execute(
                acDTO,
                method,
                DewuExpressSheetRespVO.class,
                reqDTO
        );
    }
}
