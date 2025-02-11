package com.eshop.mapper;

import com.eshop.entity.config.TbShop;
import com.eshop.entity.log.TbShopAuthLog;
import com.eshop.mapper.config.TbShopMapper;
import com.eshop.mapper.log.TbShopAuthLogMapper;
import com.eshop.service.config.ITbShopService;
import com.eshop.service.log.ITbShopAuthLogService;
import com.eshop.util.platform.api.service.order.shopee.ShopeeOrderCall;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TbShopMapperTest {

    @Resource
    private ITbShopService iTbShopService;

    @Resource
    private ITbShopAuthLogService iTbShopAuthLogService;

    @Test
    void contextLoads() throws Exception {
        List<TbShop> tbShops = iTbShopService.list();
        List<TbShopAuthLog> tbShopAuthLogs = iTbShopAuthLogService.list();
        System.out.println(tbShops.size());
        System.out.println(tbShopAuthLogs.size());
        System.out.println("多数据库执行结束");
    }
}
