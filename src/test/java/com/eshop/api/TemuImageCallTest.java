package com.eshop.api;

import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.media.temu.TemuImageCall;
import com.eshop.util.platform.api.service.media.temu.dto.TemuGoodsTextToPictureAddReqDTO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddRespVO;
import com.eshop.util.platform.api.service.product.temu.TemuProductCall;
import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsDetailGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsDetailGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


    @SpringBootTest
    public class TemuImageCallTest {

        @Resource
        private PlatformAppClientUtils platformAppClientUtils;

        @Resource
        private ITbShopService shopService;

        @Resource
        private TemuImageCall temuImageCall;


        // ok
        @Test
        void goodsTextToPictureAdd() throws Exception {
            Long shopId = 2325L;
            TbShop shopDO = shopService.getById(shopId);
            String shopLocation = "CN";
            TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

            TemuGoodsTextToPictureAddReqDTO reqDTO = new TemuGoodsTextToPictureAddReqDTO();
            reqDTO.setBackColor("#ffffff");
            reqDTO.setText("你妈妈的");
            reqDTO.setAlign("left");
            reqDTO.setFontColor("#606266");
            reqDTO.setFont("Source Han Serif Heavy");
            TemuGoodsTextToPictureAddRespVO respVO = temuImageCall.goodsTextToPictureAdd(clientDTO, reqDTO);
            System.out.println(respVO.getRespBody());
        }
}
