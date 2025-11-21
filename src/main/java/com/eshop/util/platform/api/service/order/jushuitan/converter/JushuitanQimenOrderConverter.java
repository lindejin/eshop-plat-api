package com.eshop.util.platform.api.service.order.jushuitan.converter;

import com.eshop.util.platform.api.service.order.jushuitan.converter.vo.JushuitanErpOrderVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoOrderListRespVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JushuitanQimenOrderConverter implements JushuitanErpOrderConverter<JushuitanTaoOrderListRespVO> {

    @Override
    public List<JushuitanErpOrderVO> convert(JushuitanTaoOrderListRespVO source) {
        // 处理奇门订单数据结构
        JushuitanErpOrderVO erpOrder = new JushuitanErpOrderVO();
//        erpOrder.setOrderNo(source.getQimenOrderCode());
        // ... 奇门特有的字段处理逻辑
        return null;
    }
}
