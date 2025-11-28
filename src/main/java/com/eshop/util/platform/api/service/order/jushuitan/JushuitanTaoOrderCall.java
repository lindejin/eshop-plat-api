package com.eshop.util.platform.api.service.order.jushuitan;

import com.eshop.util.platform.api.client.jushuitan.QimenCustomApiInvoker;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoConfirmDeliveryOrderReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoReceiverInfoReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoSaleOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoConfirmDeliveryOrderRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoOrderListRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoReceiverInfoRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoSaleOrderListRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JushuitanTaoOrderCall {

    @Autowired
    private QimenCustomApiInvoker qimenCustomApiInvoker;

    /**
     * 淘系 订单查询
     */
    public JushuitanTaoOrderListRespVO getOrderList(QimenCustomAppClientDTO acDTO, JushuitanTaoOrderListReqDTO reqDTO) throws Exception {
        String method = "jushuitan.order.list.query";
        return qimenCustomApiInvoker.execute(
                acDTO,
                method,
                JushuitanTaoOrderListRespVO.class,
                reqDTO
        );
    }

    /**
     * 淘系 销售订单查询
     */
    public JushuitanTaoSaleOrderListRespVO getSaleOrderList(QimenCustomAppClientDTO acDTO, JushuitanTaoSaleOrderListReqDTO reqDTO) throws Exception {
        String method = "jushuitan.saleout.list.query";
        return qimenCustomApiInvoker.execute(
                acDTO,
                method,
                JushuitanTaoSaleOrderListRespVO.class,
                reqDTO
        );
    }

    /**
     * 淘系 销售订单地址解密
     */
    public JushuitanTaoReceiverInfoRespVO queryReceiverInfo(QimenCustomAppClientDTO acDTO, JushuitanTaoReceiverInfoReqDTO reqDTO) throws Exception {
        String method = "taobao.qimen.receiverinfo.query";
        return qimenCustomApiInvoker.execute(
                acDTO,
                method,
                JushuitanTaoReceiverInfoRespVO.class,
                reqDTO
        );
    }

    /**
     * 发货单确认接口
     */
    public JushuitanTaoConfirmDeliveryOrderRespVO confirmDeliveryOrder(QimenCustomAppClientDTO acDTO, JushuitanTaoConfirmDeliveryOrderReqDTO reqDTO) throws Exception {
        String method = "taobao.qimen.deliveryorder.confirm";
        return qimenCustomApiInvoker.execute(
                acDTO,
                method,
                JushuitanTaoConfirmDeliveryOrderRespVO.class,
                reqDTO
        );
    }
}