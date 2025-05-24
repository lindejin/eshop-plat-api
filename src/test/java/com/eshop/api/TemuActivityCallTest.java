package com.eshop.api;

import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.marketing.temu.TemuActivityCall;
import com.eshop.util.platform.api.service.marketing.temu.vo.TemuActivityListRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TemuActivityCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuActivityCall temuActivityCall;

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Test
    void marketingActivityListGet() throws Exception {
        Long shopId = 3127L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuActivityListRespVO temuActivityListRespVO = temuActivityCall.marketingActivityListGet(clientDTO, null);
        System.out.println(temuActivityListRespVO.getRespBody());

        System.out.println("GG");

        // 使用示例
        TemuActivityListRespVO respVO = temuApiInvoker.execute(
                clientDTO,
                "bg.marketing.activity.list.get",
                TemuActivityListRespVO.class,
                null
        );
        System.out.println(respVO.getRespBody());
    }
}
