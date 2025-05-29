package com.eshop.api;

import com.eshop.entity.config.TbShop;
import com.eshop.order.ImageUtil;
import com.eshop.order.OkImageDownloader;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.media.temu.TemuImageCall;
import com.eshop.util.platform.api.service.media.temu.dto.TemuGoodsTextToPictureAddReqDTO;
import com.eshop.util.platform.api.service.media.temu.dto.TemuImageUploadOptionsDTO;
import com.eshop.util.platform.api.service.media.temu.dto.TemuImageUploadReqDTO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsImageUploadRespVO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddRespVO;
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
        System.out.println(respVO.getImageUrl());
        //{"result":{"imageUrl":"https://img.cdnfe.com/product/dc9beaf5/17260147-4a2f-48b4-a45b-cbe5352a04e2.jpeg"},"success":true,"requestId":"cn-fb92c2cd-4eb3-46b5-b86b-53cb63e6b809","errorCode":1000000,"errorMsg":""}
    }

    @Resource
    private OkImageDownloader okImageDownloader;
    // ok
    @Test
    void goodsImageUpload() throws Exception {
        String imgUrl = "https://file.vogocm.com:9000/eshop/eshop_img/10001/20201120/10/A003.png";

        Integer imageBizType = 0;
        String imgType = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
        String cateId = "30469";
        byte[] imageData = okImageDownloader.downloadImageWithRetry(imgUrl);
        String imgBase64 = ImageUtil.imgConvertBase64(imageData);

        TemuImageUploadReqDTO upImgDTO = new TemuImageUploadReqDTO();
        //  // 0、1，入参1返回的url用以货品发布时的外包装使用
        upImgDTO.setImageBizType(imageBizType);
        upImgDTO.setImage("data:image/" + imgType + ";base64," + imgBase64);
        TemuImageUploadOptionsDTO upImgOptionDTO = new TemuImageUploadOptionsDTO();
        upImgOptionDTO.setBoost(true);
        upImgOptionDTO.setCateId(cateId);
        upImgOptionDTO.setDoIntelligenceCrop(true);
        upImgOptionDTO.setSizeMode(0);
        upImgDTO.setOptions(upImgOptionDTO);


        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuGoodsImageUploadRespVO respVO = temuImageCall.goodsImageUpload(clientDTO, upImgDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(respVO.getImageUrl());
    }
}
