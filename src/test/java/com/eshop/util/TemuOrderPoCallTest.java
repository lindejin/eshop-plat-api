package com.eshop.util;

import com.eshop.util.platform.api.service.order.temu.TemuOrderPoCall;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TemuOrderPoCallTest {

    @Resource
    private TemuOrderPoCall temuOrderPoCall;

    /**
     * 指定店铺id 获取temu店铺物流商
     */
    @Test
    void getModeList() throws Exception {

    }
}
