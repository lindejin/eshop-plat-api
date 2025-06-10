package com.eshop.api2;

import com.alibaba.fastjson.JSONObject;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.im.dhpage.DhGateImCall;
import com.eshop.util.platform.api.service.im.dhpage.dto.DhContactListReqDTO;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


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
//        DhAppClientDTO dhAppClientDTO = getERP();
        //{"code":"2","message":"开发者权限不足","solution":"不足的ISV权限","subErrors":[{"code":"isv.invalid-permission","message":"权限不够、非法访问"}]}

        DhAppClientDTO dhAppClientDTO = getDH();
//      {"status":{"code":"00000000","message":"OK","solution":"","subErrors":[]},"contactList":[{"sessionId":"5da408639235861df04e8327612403131313a90f37861e12","toId":"ff8080817b2a456d017b537e69343ed2","nick":"isa.amazon3","avatar":null,"lastTime":1746067810050,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e83275fe84b434a80726aeb52d66e","toId":"2c93620e76a34fd20176a3648d7e040a","nick":"basti_z","avatar":null,"lastTime":1737301616536,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e832762d70cb6cea2ad7900ab8e24","toId":"d70fe5bc163340a98eea02e48fd34e6d","nick":"dokkum_x2A","avatar":null,"lastTime":1731611042611,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e83275f0f5a1f9235861ab6c63dcc","toId":"ff8080817347a6a5017353f284e63481","nick":"debbi.perkins","avatar":null,"lastTime":1707141725044,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e8327645316f6772bfb7ba85b9d1b","toId":"a9fe54e3021a482fae2827870c3f6fcc","nick":"3149207737","avatar":null,"lastTime":1703579283885,"lastMsg":".","remark":null,"read":1},{"sessionId":"5da408639235861df04e8327644875a223601e70a0af911c","toId":"572c313b8288494fb9fb6319443c4448","nick":"wendyzouzou","avatar":null,"lastTime":1701832836942,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e8327607e0ab84a80721c66ad2254","toId":"ff808081788c6b5c0178ec59dc67650c","nick":"erobgang","avatar":null,"lastTime":1701316814715,"lastMsg":null,"remark":null,"read":1},{"sessionId":"5da408639235861df04e83275edd745b4a8072740cb7bf5a","toId":"ff808081724b8ce80172910e7c5443f9","nick":"Jay Hindle","avatar":null,"lastTime":1701032864816,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e83276248a834bcdda17eecce112f","toId":"ff8080817fe8ef56017feb4213456087","nick":"lindamcd78","avatar":null,"lastTime":1700861434318,"lastMsg":"[Notification]","remark":null,"read":1},{"sessionId":"5da408639235861df04e832763a2078191e84c592e76a7ee","toId":"4511bcdce2c3489e8c131a03c2ea13f1","nick":"asunpolo2","avatar":null,"lastTime":1697991144600,"lastMsg":null,"remark":null,"read":1},{"sessionId":"5cb1d8b79235865fca1248145da408639235861df04e8327","toId":"ff808081684c9b4e016a168a5e0f040b","nick":"k_chancay","avatar":null,"lastTime":1695693456523,"lastMsg":"IM Message Confirm your addres...","remark":null,"read":1},{"sessionId":"5da408639235861df04e83275e44a1ff92358673ac653080","toId":"ff8080815e03d654015e1095678a35de","nick":"ninaaadiazzz","avatar":null,"lastTime":1695339408212,"lastMsg":"Does this have LV logo?","remark":null,"read":1},{"sessionId":"5da408639235861df04e832763a5375691e84c592ec19d4d","toId":"ba7aa01869d849a6acf4b905e5d8b6c7","nick":"erinbrereton","avatar":null,"lastTime":1692258780602,"lastMsg":"Click on the link to contact m...","remark":null,"read":1},{"sessionId":"5da408639235861df04e83276164af389829e071d71ae373","toId":"ff8080817c11fe1b017c714c6f002125","nick":"johnnygumz116","avatar":null,"lastTime":1692055637835,"lastMsg":null,"remark":null,"read":1},{"sessionId":"5da408639235861df04e832764c490a10da8c50418c131e0","toId":"73e0036955624eeaad1a192a9eeed820","nick":"NxGZois","avatar":null,"lastTime":1690792682520,"lastMsg":".","remark":null,"read":1},{"sessionId":"5da408639235861df04e83276226b47a9e03e9195967b803","toId":"ff8080817e6781b0017f67300b6d1502","nick":"1646703676264","avatar":null,"lastTime":1688640105299,"lastMsg":null,"remark":null,"read":1},{"sessionId":"5da408639235861df04e83275f8951434a80720e908d6805","toId":"ff808081752ba31201753065648d1969","nick":"shmookh3040","avatar":null,"lastTime":1685049282157,"lastMsg":null,"remark":null,"read":1},{"sessionId":"5d9fe0b24a80723f8e1960b65da408639235861df04e8327","toId":"ff8080816d5d8471016db7d6d9ef0326","nick":"reza.shirmast","avatar":null,"lastTime":1684301609714,"lastMsg":"IM Message Please check the or...","remark":null,"read":1},{"sessionId":"5d3db7089235863f75832fb55da408639235861df04e8327","toId":"ff8080816b1c6c25016c3912eee44334","nick":"nicomagri98","avatar":null,"lastTime":1683845146249,"lastMsg":null,"remark":null,"read":1},{"sessionId":"5da408639235861df04e83275f53b0e0923586094f6b7528","toId":"ff80808173e6751401745eeae44f4508","nick":"Dominika Košutková","avatar":null,"lastTime":1683817067066,"lastMsg":null,"remark":null,"read":1}]}

//        DhAppClientDTO dhAppClientDTO = getTestDH();
        // {"code":"2","message":"开发者权限不足","solution":"不足的ISV权限","subErrors":[{"code":"isv.invalid-permission","message":"权限不够、非法访问"}]}

//        DhAppClientDTO dhAppClientDTO = getWjDH();
        //{"code":"2","message":"开发者权限不足","solution":"不足的ISV权限","subErrors":[{"code":"isv.invalid-permission","message":"权限不够、非法访问"}]}

        JSONObject businessDto = FastJsonUtil.toJsonToJsonObj(reqDTO);
        String contactList = dhGateImCall.getContactList(dhAppClientDTO, businessDto);
        System.out.println(contactList);
    }

    private DhAppClientDTO getERP() {
        // shop_id 1840
        // {"appKey": "9Ehe1J1FFrBUn1nfGyyy","appSecret": "49KpKV4EUfvPTeJwqZF30fONVcvneYRO"}
        String appKey = "9Ehe1J1FFrBUn1nfGyyy";
        String appSecret = "49KpKV4EUfvPTeJwqZF30fONVcvneYRO";

        String accessToken = "hMbDVLutVMt16bDIbfXKpAagL4XPCBB2Dm2UoTHr";
        String refreshToken = "hHLp2wuEcj3euAE8xeVg1J009k7qZQxSN3z3kkSQ";

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

    private DhAppClientDTO getTestDH() {
        // 3242

        //{"appKey": "PJMMXTY70PSBKmShzXVq","appSecret": "oegSC42y5HPCcNIjture0JpBgHnhKfeq"}
        String appKey = "PJMMXTY70PSBKmShzXVq";
        String appSecret = "oegSC42y5HPCcNIjture0JpBgHnhKfeq";


        //"{\"accessToken\":\"viEA8uRn1t4I8qUh1phXp8b5W1deCVXXURTmgsU6\",\"refreshToken\":\"dldjDX6GgNcXCUzb3KiUHSxwThsg90iorWNmf6Ou\"}"
        String accessToken = "viEA8uRn1t4I8qUh1phXp8b5W1deCVXXURTmgsU6";
        String refreshToken = "dldjDX6GgNcXCUzb3KiUHSxwThsg90iorWNmf6Ou";

        DhAppClientDTO dhAppClientDTO = new DhAppClientDTO();
        dhAppClientDTO.setAppKey(appKey);
        dhAppClientDTO.setAppSecret(appSecret);
        dhAppClientDTO.setAccessToken(accessToken);
        dhAppClientDTO.setRefreshToken(refreshToken);
        return dhAppClientDTO;
    }


    private DhAppClientDTO getWjDH() {
        // 546


        //{"appKey": "l24Kj3l9gywcbHwYmnH3","appSecret": "N8eIvrAw32i1y5oAEYGYHavGoSkdPIEz"}
        String appKey = "l24Kj3l9gywcbHwYmnH3";
        String appSecret = "N8eIvrAw32i1y5oAEYGYHavGoSkdPIEz";


        //"{\"accessToken\":\"QFQoe4dQSdANR1UDzp2XOJYrJc7Gp9jvE6BaNWGM\",\"refreshToken\":\"ol9wsCBYD3JQLpuf5ngE362y9j7rdG292ksFbIy1\"}"
        String accessToken = "QFQoe4dQSdANR1UDzp2XOJYrJc7Gp9jvE6BaNWGM";
        String refreshToken = "ol9wsCBYD3JQLpuf5ngE362y9j7rdG292ksFbIy1";

        DhAppClientDTO dhAppClientDTO = new DhAppClientDTO();
        dhAppClientDTO.setAppKey(appKey);
        dhAppClientDTO.setAppSecret(appSecret);
        dhAppClientDTO.setAccessToken(accessToken);
        dhAppClientDTO.setRefreshToken(refreshToken);
        return dhAppClientDTO;
    }
}