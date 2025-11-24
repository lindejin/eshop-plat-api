package com.eshop.util.platform.api.service.order.jushuitan;


import com.eshop.util.platform.api.client.jushuitan.JushuitanApiInvoker;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanSaleOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanOrderListRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanSaleOrderListRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JushuitanOrderCall {

    @Autowired
    private JushuitanApiInvoker jushuitanApiInvoker;

    /**
     * 订单查询
     */
    public JushuitanOrderListRespVO getOrderList(JushuitanAppClientDTO temuAcDTO, JushuitanOrderListReqDTO reqDTO) throws Exception {
        String method = "/open/orders/single/query";
        return jushuitanApiInvoker.execute(
                temuAcDTO,
                method,
                JushuitanOrderListRespVO.class,
                reqDTO
        );
    }

    /**
     * 销售出库查询
     */
    public JushuitanSaleOrderListRespVO getSaleOrderList(JushuitanAppClientDTO temuAcDTO, JushuitanSaleOrderListReqDTO reqDTO) throws Exception {
        String method = "/open/orders/out/simple/query";
        return jushuitanApiInvoker.execute(
                temuAcDTO,
                method,
                JushuitanSaleOrderListRespVO.class,
                reqDTO
        );
    }
}
