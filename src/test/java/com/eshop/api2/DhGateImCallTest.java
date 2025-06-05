package com.eshop.api2;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbShop;
import com.eshop.order.OkImageDownloader;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.im.dhpage.DhGateImCall;
import com.eshop.util.platform.api.service.im.dhpage.dto.DhContactListReqDTO;
import com.eshop.util.platform.api.service.media.temu.TemuVideoCall;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
public class DhGateImCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private ITbShopService iTbShopService;

    @Resource
    private DhGateImCall dhGateImCall;

    @Test
    void getContactList() throws Exception {
        DhContactListReqDTO reqDTO = new DhContactListReqDTO();
        int size = 20;
        reqDTO.setSize(size);
        reqDTO.setPage(1);
//        if (ObjectUtil.isNotEmpty(dto.getFilter())) {
//            reqDTO.setFilter(dto.getFilter());
//        }
//        if (ObjectUtil.isNotEmpty(dto.getSearch())) {
//            reqDTO.setFilter(dto.getSearch());
//        }
        DhAppClientDTO dhAppClientDTO = getDH();
        JSONObject businessDto = FastJsonUtil.toJsonToJsonObj(reqDTO);
        String contactList = dhGateImCall.getContactList(dhAppClientDTO, businessDto);
        System.out.println(contactList);
    }

    private DhAppClientDTO getERP() {
        String appKey = "";
        String appSecret = "";

        String accessToken = "";
        String refreshToken = "";

        DhAppClientDTO dhAppClientDTO = new DhAppClientDTO();
        dhAppClientDTO.setAppKey(appKey);
        dhAppClientDTO.setAppSecret(appSecret);
        dhAppClientDTO.setAccessToken(accessToken);
        dhAppClientDTO.setRefreshToken(refreshToken);
        return dhAppClientDTO;
    }

    private DhAppClientDTO getDH() {
        //{"appKey": "QrStYilYajlkjzTjd6Uy","appSecret": "Xj1ZCz51a38FrOl1WpuyVtPjtbHd9rNR"}
        String appKey = "QrStYilYajlkjzTjd6Uy";
        String appSecret = "Xj1ZCz51a38FrOl1WpuyVtPjtbHd9rNR";

        //"{\"accessToken\":\"5FBNMUZKGpZeAeAYtxuBgtVyAyP2wJmxUrAS6jqY\",\"refreshToken\":\"aWhDA31PVTblrI10mVQWyTtyvwM5kPRyzTOqwGr2\"}"
        String accessToken = "5FBNMUZKGpZeAeAYtxuBgtVyAyP2wJmxUrAS6jqY";
        String refreshToken = "aWhDA31PVTblrI10mVQWyTtyvwM5kPRyzTOqwGr2";

        DhAppClientDTO dhAppClientDTO = new DhAppClientDTO();
        dhAppClientDTO.setAppKey(appKey);
        dhAppClientDTO.setAppSecret(appSecret);
        dhAppClientDTO.setAccessToken(accessToken);
        dhAppClientDTO.setRefreshToken(refreshToken);
        return dhAppClientDTO;
    }
}