package com.eshop.util.platform.api.service.order.xiaohongshu;

import com.eshop.util.platform.api.client.xiaohongshu.XiaohongshuApiInvoker;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.order.xiaohongshu.dto.XiaohongshuOrderDetailReqDTO;
import com.eshop.util.platform.api.service.order.xiaohongshu.vo.XiaohongshuOrderDetailRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class XiaohongshuOrderCall {

    @Autowired
    private XiaohongshuApiInvoker xiaohongshuApiInvoker;

    /**
     * 订单详情
     * order.getOrderDetail
     *
     */
    public XiaohongshuOrderDetailRespVO getOrderDetail(XiaohongshuAppClientDTO acDTO, XiaohongshuOrderDetailReqDTO reqDTO) throws Exception {
        String method = "order.getOrderDetail";
        return xiaohongshuApiInvoker.execute(
                acDTO,
                method,
                XiaohongshuOrderDetailRespVO.class,
                reqDTO
        );
    }
}
