package com.eshop.order;

import cn.hutool.core.util.ObjectUtil;
import com.eshop.constant.ConstantPlatform;
import com.eshop.logistics.service.YourService;
import com.eshop.order.client.OrderClient;
import com.eshop.order.factory.OrderClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderClientFactoryTest {

    private final OrderClientFactory orderClientFactory;

    @Autowired
    public OrderClientFactoryTest(OrderClientFactory orderClientFactory) {
        this.orderClientFactory = orderClientFactory;
    }

    @Test
    void contextLoads() throws Exception {
        extracted(ConstantPlatform.DH);
        extracted(ConstantPlatform.SHOPEE);
        extracted(ConstantPlatform.TIKTOK);
        extracted(ConstantPlatform.ALIEXPRESS);
        extracted(ConstantPlatform.TEMU);
    }

    private void extracted(String platformCode) {
        List<OrderClient> orderClients = orderClientFactory.getClient(platformCode);
        if (ObjectUtil.isEmpty(orderClients)) {
            return;
        }
        for (OrderClient orderClient : orderClients) {
            System.out.println(orderClient.process(platformCode));
        }
    }
}
