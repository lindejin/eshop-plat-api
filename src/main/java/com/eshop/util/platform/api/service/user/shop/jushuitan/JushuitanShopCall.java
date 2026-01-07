package com.eshop.util.platform.api.service.user.shop.jushuitan;

import com.eshop.util.platform.api.client.jushuitan.JushuitanApiInvoker;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanOrderListRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-05 15:30
 **/
@Component
public class JushuitanShopCall {

    @Autowired
    private JushuitanApiInvoker jushuitanApiInvoker;

    /**
     * 订单查询
     */
    public JushuitanOrderListRespVO getShopList(JushuitanAppClientDTO temuAcDTO, JushuitanOrderListReqDTO reqDTO) throws Exception {
        String method = "/open/shops/query";
        return jushuitanApiInvoker.execute(
                temuAcDTO,
                method,
                JushuitanOrderListRespVO.class,
                reqDTO
        );
    }
}
