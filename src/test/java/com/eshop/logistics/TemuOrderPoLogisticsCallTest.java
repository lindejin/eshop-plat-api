package com.eshop.logistics;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.temu.TemuOrderPoLogisticsCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.TemuOrderPoCallService;
import com.eshop.util.platform.call.order.temu.dto.TemuOrderPoLogisticsShipmentReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuOrderPoLogisticsShipmentRespVO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootTest
public class TemuOrderPoLogisticsCallTest {

    @Resource
    private TemuOrderPoLogisticsCall temuOrderPoLogisticsCall;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderPoCallService temuOrderPoCallService;


    @Test
    void contextLoads() throws Exception {
        TbShop shopDO = shopService.getById(1722L);
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, "GL");


        JSONObject businessDto = new JSONObject();
        String s = temuOrderPoLogisticsCall.logisticsWarehouseListGet(gl, businessDto);
        System.out.println(s);
    }
    @Test
    void logisticsShippingServicesGet() throws Exception {
        TbShop shopDO = shopService.getById(1722L);
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, "GL");


        //订单同步的包裹号
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("100-15802651077671153");

        JSONObject businessDto = new JSONObject();
        businessDto.put("warehouseId","WH-05731442565273016");
        //WH-01436465889433016
//        businessDto.put("warehouseId","WH-01436465889433016");

        businessDto.put("orderSnList", jsonArray);
        businessDto.put("weight","1.01");
        businessDto.put("weightUnit","kg");
        businessDto.put("length","1.01");
        businessDto.put("width","1.01");
        businessDto.put("height","1.01");
        businessDto.put("dimensionUnit","cm");
        String s = temuOrderPoLogisticsCall.logisticsShippingServicesGet(gl, businessDto);
        System.out.println(s);
    }

    @Test
    void logisticsShippingServicesGet2() throws Exception {
        TbShop shopDO = shopService.getById(2461L);
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, "US");


        //订单同步的包裹号
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("211-15763849943591129");

        JSONObject businessDto = new JSONObject();
//        businessDto.put("warehouseId","WH-05731442565273016");
        //WH-01436465889433016
        businessDto.put("warehouseId","WH-01436465889433016");

        businessDto.put("orderSnList", jsonArray);
        businessDto.put("weight","1.01");
        businessDto.put("weightUnit","lb");
        businessDto.put("length","1.01");
        businessDto.put("width","1.01");
        businessDto.put("height","1.01");
        businessDto.put("dimensionUnit","in");
        String s = temuOrderPoLogisticsCall.logisticsShippingServicesGet(gl, businessDto);
        System.out.println(s);
    }

    @Test
    void getLogisticsShipment() throws Exception {
        TbShop shopDO = shopService.getById(2461L);
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, "US");


        TemuOrderPoLogisticsShipmentReqDTO reqDTO = new TemuOrderPoLogisticsShipmentReqDTO();
        reqDTO.setParentOrderSn("PO-211-15763828972071129");
        reqDTO.setOrderSn("211-15763849943591129");

        TemuOrderPoLogisticsShipmentRespVO logisticsShipment = temuOrderPoCallService.getLogisticsShipment(clientDTO, reqDTO);

        System.out.println(logisticsShipment.getRespBody());
    }



}
