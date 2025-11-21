package com.eshop.util.platform.api.service.order.jushuitan;

import com.eshop.util.platform.api.client.jushuitan.QimenCustomApiInvoker;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoOrderListRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JushuitanTaoOrderCall {

    @Autowired
    private QimenCustomApiInvoker qimenCustomApiInvoker;

    public JushuitanTaoOrderListRespVO getOrderList(QimenCustomAppClientDTO acDTO, JushuitanTaoOrderListReqDTO reqDTO) throws Exception {
        String method = "jushuitan.order.list.query";
        return qimenCustomApiInvoker.execute(
                acDTO,
                method,
                JushuitanTaoOrderListRespVO.class,
                reqDTO
        );
    }
}