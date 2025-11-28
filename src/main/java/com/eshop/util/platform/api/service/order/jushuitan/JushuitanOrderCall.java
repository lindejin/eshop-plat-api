package com.eshop.util.platform.api.service.order.jushuitan;


import com.eshop.util.platform.api.client.jushuitan.JushuitanApiInvoker;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanConfirmDeliverySaleOrderReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanSaleOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanConfirmDeliverySaleOrderRespVO;
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


    /**
     *
     * 出库发货
     * 调用出库发货会自动同步订单线上发货信息
     * 调用该接口发货需要先在系统【物流(快递)公司及打印模板】页面中配置对应的物流公司及编码
     */
    public JushuitanConfirmDeliverySaleOrderRespVO confirmDeliveryOrder(JushuitanAppClientDTO temuAcDTO, JushuitanConfirmDeliverySaleOrderReqDTO reqDTO) throws Exception {
        String method = "/open/orders/wms/sent/upload";
        return jushuitanApiInvoker.execute(
                temuAcDTO,
                method,
                JushuitanConfirmDeliverySaleOrderRespVO.class,
                reqDTO
        );
    }
}
