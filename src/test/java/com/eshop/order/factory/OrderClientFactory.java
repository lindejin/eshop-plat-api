package com.eshop.order.factory;


import com.eshop.order.client.OrderClient;

import java.util.List;

/**
 * @author ldj
 * @date 2023/11/17 14:57
 * @Description: ...
 * @Version 1.0
 */
public interface OrderClientFactory {

    /**
     * 获取平台同步订单接口服务
     *
     * @param platformCode
     * @return
     */
    List<OrderClient> getClient(String platformCode);

}
