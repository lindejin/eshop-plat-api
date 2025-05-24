package com.eshop.api;

import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.marketing.temu.TemuActivityCall;
import com.eshop.util.platform.api.service.marketing.temu.vo.TemuActivityListRespVO;
import com.eshop.util.platform.api.service.user.shop.temu.TemuOrderPoShopCall;
import com.eshop.util.platform.api.service.user.shop.temu.vo.TemuOpenAccessTokenInfoGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class TemuOrderPoShopCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderPoShopCall temuOrderPoShopCall;

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Test
    void marketingActivityListGet() throws Exception {
        Long shopId = 3127L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuOpenAccessTokenInfoGetRespVO temuActivityListRespVO = temuOrderPoShopCall.openAccessTokenInfoGet(clientDTO, null);
        System.out.println(temuActivityListRespVO.getRespBody());


        // 使用示例
        String type = "bg.open.accesstoken.info.get";
        TemuOpenAccessTokenInfoGetRespVO respVO = temuApiInvoker.execute(
                clientDTO,
                type,
                TemuOpenAccessTokenInfoGetRespVO.class,
                null
        );
        System.out.println(respVO.getRespBody());
    }
}
