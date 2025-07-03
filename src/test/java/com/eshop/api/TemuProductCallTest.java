package com.eshop.api;

import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.product.temu.TemuProductCall;
import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsDetailGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsDetailGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class TemuProductCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuProductCall temuProductCall;


    @Test
    void goodsDetailGet() throws Exception {
        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuGoodsDetailGetReqDTO reqDTO = new TemuGoodsDetailGetReqDTO();
        reqDTO.setProductId(9920019805L);
        TemuGoodsDetailGetRespVO respVO = temuProductCall.goodsDetailGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        //{"result":{"productId":187202732,"productWhExtAttr":{"productOrigin":{"region2Id":null,"region1ShortName":"CN"}},"categories":{"catType":null,"cat8":{"catId":0,"catName":""},"cat9":{"catId":0,"catName":""},"cat6":{"catId":0,"catName":""},"cat7":{"catId":0,"catName":""},"cat4":{"catId":3883,"catName":"电脑影音设备"},"cat5":{"catId":3884,"catName":"电脑音箱"},"cat2":{"catId":3715,"catName":"电脑及配件"},"cat3":{"catId":3716,"catName":"外设产品"},"cat10":{"catId":0,"catName":""},"cat1":{"catId":2542,"catName":"电子"},"leafCat":{"catId":3884,"catName":"电脑音箱"}},"goodsLayerDecorationList":[{"floorId":15535299073,"priority":0,"type":"text","lang":"zh","contentList":[{"imgUrl":"https://img.cdnfe.com/product/1fee580b40/f887ce00-45d8-4a53-997f-5e3290ed0327_750x257.png","textModuleDetails":{"backgroundColor":"#ffffff","fontFamily":null,"fontSize":12,"align":"left","fontColor":"#333333"},"width":750,"text":"Notice:\nKeep away from infants and young children, watch for falls, and keep away from open flames\nIf there is no sound when the product is used for the first time, please adjust the volume button of the speaker.\n","height":257}],"key":"DecImage"},{"floorId":15535299105,"priority":1,"type":"image","lang":"zh","contentList":[{"imgUrl":"https://img.cdnfe.com/product/fancy/fa6660b7-4496-4736-88dd-8472686e7b39.jpg","textModuleDetails":{"backgroundColor":null,"fontFamily":null,"fontSize":null,"align":null,"fontColor":null},"width":800,"text":null,"height":800}],"key":"DecImage"},{"floorId":15535299137,"priority":2,"type":"image","lang":"zh","contentList":[{"imgUrl":"https://img.cdnfe.com/product/fancy/2e062dc4-253f-4fef-bd18-41e44afc1ff3.jpg","textModuleDetails":{"backgroundColor":null,"fontFamily":null,"fontSize":null,"align":null,"fontColor":null},"width":800,"text":null,"height":800}],"key":"DecImage"},{"floorId":15535299169,"priority":3,"type":"image","lang":"zh","contentList":[{"imgUrl":"https://img.cdnfe.com/product/fancy/d86b3a93-b623-44c2-882d-c22fa379e1f0.jpg","textModuleDetails":{"backgroundColor":null,"fontFamily":null,"fontSize":null,"align":null,"fontColor":null},"width":1000,"text":null,"height":1000}],"key":"DecImage"},{"floorId":15535299201,"priority":4,"type":"image","lang":"zh","contentList":[{"imgUrl":"https://img.cdnfe.com/product/fancy/90b9d052-b26d-4647-acea-3ce7a57970b5.jpg","textModuleDetails":{"backgroundColor":null,"fontFamily":null,"fontSize":null,"align":null,"fontColor":null},"width":800,"text":null,"height":800}],"key":"DecImage"},{"floorId":15535321633,"priority":5,"type":"image","lang":"zh","contentList":[{"imgUrl":"https://img.cdnfe.com/product/fancy/530fe795-9622-4acd-9937-12552284b92f.jpg","textModuleDetails":{"backgroundColor":null,"fontFamily":null,"fontSize":null,"align":null,"fontColor":null},"width":1000,"text":null,"height":1000}],"key":"DecImage"}],"productName":"电脑扬声器 PC 音箱 HIFI 立体声 USB 有线 带LED 灯 适用于台式电脑 笔记本电脑"},"success":true,"requestId":"cn-a0cd7525-6b05-49b1-b164-a1ac14688a6b","errorCode":1000000,"errorMsg":""}
    }
}
