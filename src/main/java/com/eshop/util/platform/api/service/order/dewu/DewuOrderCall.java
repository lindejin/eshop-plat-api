package com.eshop.util.platform.api.service.order.dewu;

import com.eshop.util.platform.api.client.dewu.DewuApiInvoker;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.client.xiaohongshu.XiaohongshuApiInvoker;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.order.dewu.dto.DewuOrderDetailReqDTO;
import com.eshop.util.platform.api.service.order.dewu.vo.DewuOrderDetailRespVO;
import com.eshop.util.platform.api.service.order.xiaohongshu.dto.XiaohongshuOrderDetailReqDTO;
import com.eshop.util.platform.api.service.order.xiaohongshu.vo.XiaohongshuOrderDetailRespVO;
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
    public DewuOrderDetailRespVO getExpressSheet(DewuAppClientDTO acDTO, DewuOrderDetailReqDTO reqDTO) throws Exception {
        String method = "/dop/api/v2/order/brand_deliver/express_sheet";
        return dewuApiInvoker.execute(
                acDTO,
                method,
                DewuOrderDetailRespVO.class,
                reqDTO
        );
    }
}
