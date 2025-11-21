package com.eshop.util.platform.api.service.order.jushuitan.converter;

import cn.hutool.core.collection.CollectionUtil;
import com.eshop.util.BeanPlusUtil;
import com.eshop.util.platform.api.service.order.jushuitan.converter.vo.*;
import com.eshop.util.platform.api.service.order.jushuitan.request.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 聚水潭推送订单结构转换
 */
@Component
public class JushuitanPushOrderConverter implements JushuitanErpOrderConverter<JushuitanPushRequest> {

    /**
     * 转换为erp order
     */
    @Override
    public List<JushuitanErpOrderVO> convert(JushuitanPushRequest source) {
        // 处理推送回调的订单数据结构（可能与API结构完全不同）
        JushuitanErpOrderVO erpOrder = new JushuitanErpOrderVO();
        erpOrder.setOrderInfo(getOrderInfoVO(source));
        erpOrder.setSenderInfo(getSenderInfo(source));
        erpOrder.setReceiverInfo(getReceiverInfo(source));
        erpOrder.setOrderLines(getOrderLines(source));
        return Collections.singletonList(erpOrder);
    }

    /**
     * 转化订单信息
     */
    private JushuitanErpOrderInfoVO getOrderInfoVO(JushuitanPushRequest source) {
        JushuitanPushDeliveryOrder deliveryOrder = source.getDeliveryOrder();
        if (deliveryOrder == null) {
            return null;
        }
        return BeanPlusUtil.toBean(deliveryOrder, JushuitanErpOrderInfoVO.class);
    }

    /**
     * 转化订单发件人信息
     *
     * @param source
     * @return
     */
    private JushuitanErpOrderSenderInfoVO getSenderInfo(JushuitanPushRequest source) {
        JushuitanPushDeliveryOrder deliveryOrder = source.getDeliveryOrder();
        if (deliveryOrder == null) {
            return null;
        }
        JushuitanPushSenderInfo senderInfo = deliveryOrder.getSenderInfo();
        if (senderInfo == null) {
            return null;
        }
        return BeanPlusUtil.toBean(senderInfo, JushuitanErpOrderSenderInfoVO.class);
    }

    /**
     * 转发订单收件人信息
     *
     * @param source
     * @return
     */
    private JushuitanErpOrderReceiverInfo getReceiverInfo(JushuitanPushRequest source) {
        JushuitanPushDeliveryOrder deliveryOrder = source.getDeliveryOrder();
        if (deliveryOrder == null) {
            return null;
        }
        JushuitanPushReceiverInfo receiverInfo = deliveryOrder.getReceiverInfo();
        if (receiverInfo == null) {
            return null;
        }
        return BeanPlusUtil.toBean(receiverInfo, JushuitanErpOrderReceiverInfo.class);
    }

    /**
     * 转换订单商品行信息
     *
     * @param source
     * @return
     */
    private List<JushuitanErpOrderLineInfo> getOrderLines(JushuitanPushRequest source) {
        List<JushuitanPushDeliveryOrderLine> orderLines = source.getOrderLines();
        List<JushuitanErpOrderLineInfo> erpOrderLines = new ArrayList<>();
        if (CollectionUtil.isEmpty(orderLines)) {
            return erpOrderLines;
        }

        for (JushuitanPushDeliveryOrderLine orderLine : orderLines) {
            JushuitanPushDeliveryOrderLineExtendProps extendProps = orderLine.getExtendProps();
            JushuitanErpOrderLineInfo erpOrderLineInfo = BeanPlusUtil.toBean(orderLine, JushuitanErpOrderLineInfo.class);

            if (extendProps != null) {
                erpOrderLineInfo.setIsGift(extendProps.getIsGift());
                erpOrderLineInfo.setCombine_sku_id(extendProps.getCombine_sku_id());
                erpOrderLineInfo.setCombine_sku_quantity(extendProps.getCombine_sku_quantity());
                erpOrderLineInfo.setBuyer_paidamount(extendProps.getBuyer_paidamount());
                erpOrderLineInfo.setSellerIncome_amount(extendProps.getSellerIncome_amount());
                erpOrderLineInfo.setPlatform_freeamount(extendProps.getPlatform_freeamount());
                erpOrderLineInfo.setVenderFee(extendProps.getVenderFee());
            }
            erpOrderLines.add(erpOrderLineInfo);

        }
        return erpOrderLines;
    }
}
