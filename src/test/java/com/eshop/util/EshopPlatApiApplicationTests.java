package com.eshop.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.order.shopee.ShopeeOrderCall;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class EshopPlatApiApplicationTests {

    @Resource
    private ShopeeOrderCall shopeeOrderCall;

    @Test
    void contextLoads() throws Exception {
        String token = "{\"partnerKey\":\"4b725764696e6b6b5262784b4450744c545a6249714367794f4c7275785a6465\",\"partnerId\":\"2005429\",\"accessToken\":\"4c484c7159464d726863664b64657663\",\"url\":\"https://openplatform.shopee.cn\",\"platformShopId\":\"745782182\",\"refreshToken\":\"68594551636d6c54674165695a507059\"}\n";
        token = "{\"partnerKey\":\"4b725764696e6b6b5262784b4450744c545a6249714367794f4c7275785a6465\",\"partnerId\":\"2005429\",\"accessToken\":\"5054766c737059727955474271514c79\",\"url\":\"https://openplatform.shopee.cn\",\"platformShopId\":\"976023964\",\"refreshToken\":\"45596e4b70614f695274587161755678\"}\n";

        token = "{\"partnerKey\":\"4b725764696e6b6b5262784b4450744c545a6249714367794f4c7275785a6465\",\"partnerId\":\"2005429\",\"accessToken\":\"7250796551565974464b5151786d504b\",\"url\":\"https://openplatform.shopee.cn\",\"platformShopId\":\"977697527\",\"refreshToken\":\"6b596e654961666568507956507a6f74\"}\n";
        ShopeeAppClientDTO publicDTO = JSON.parseObject(token, ShopeeAppClientDTO.class);

        JSONObject orderDetail = getOrderDetail(publicDTO, "250208MXFF5MHP");
        System.out.println(orderDetail);
    }

    private JSONObject getOrderDetail(ShopeeAppClientDTO publicDTO, String orderNo) throws Exception {
        ShopeeAppClientDTO scDTO = publicDTO;
        ShopeeOrderDetailReqDTO reqDTO = getOrderDetailDTO(orderNo);
        ShopeeOrderDetailRespVO respVO = getOrderDetail(scDTO, reqDTO);
        JSONObject jsonObject = JSONObject.parseObject(respVO.getRespBody());
        return jsonObject;
    }

    public ShopeeOrderDetailReqDTO getOrderDetailDTO(String orderNo) {
        ShopeeOrderDetailReqDTO reqDTO = new ShopeeOrderDetailReqDTO();
        //order_sn_list order_sn集。如果有多个order_sn，则需要使用英文逗号将它们连接起来。限制 [1，50]
        List<String> longs1 = Arrays.asList(orderNo);
        String orderSnList = longs1.stream()
                .collect(Collectors.joining(","));
//        params.put("order_sn_list", orderSnList);
        reqDTO.setOrder_sn_list(orderSnList);
        //添加响应字段
        List<String> longs2 = Arrays.asList(
                "order_sn",
                "region",
                "currency",
                "cod",
                "total_amount",
                "order_status",
                "shipping_carrier",
                "payment_method",
                "estimated_shipping_fee",
                "message_to_seller",
                "create_time",
                "update_time",
                "days_to_ship",
                "ship_by_date",
                "buyer_user_id",
                "buyer_username",
                "recipient_address",
                "actual_shipping_fee",
                "goods_to_declare",
                "note",
                "note_update_time",
                "item_list",
                "pay_time",
                "dropshipper",
                "dropshipper_phone",
                "split_up",
                "buyer_cancel_reason",
                "cancel_by",
                "cancel_reason",
                "actual_shipping_fee_confirmed",
                "buyer_cpf_id",
                "fulfillment_flag",
                "pickup_done_time",
                "package_list",
                "invoice_data",
                "checkout_shipping_carrier",
                "reverse_shipping_fee",
                "order_chargeable_weight_gram",
                "edt_from",
                "edt_to",
                "prescription_images",
                "prescription_check_status"
        );
        String responseOptionalFields = longs2.stream()
                .collect(Collectors.joining(","));
//        params.put("response_optional_fields", responseOptionalFields);
        reqDTO.setResponse_optional_fields(responseOptionalFields);
        return reqDTO;
    }

    public ShopeeOrderDetailRespVO getOrderDetail(ShopeeAppClientDTO dcDTO, ShopeeOrderDetailReqDTO orderDetailReqDTO) throws Exception {
        Map<String, Object> businessDTO = getOrderDetailReqDTO(orderDetailReqDTO);
        String respBody = shopeeOrderCall.getOrderDetail(dcDTO, businessDTO);
        ShopeeOrderDetailRespVO respVO = new ShopeeOrderDetailRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    private Map<String, Object> getOrderDetailReqDTO(ShopeeOrderDetailReqDTO reqDTO) {
        Map<String, Object> businessDTO = new HashMap<>();
        //Request Parameters
        //Collapse
        //Name	Type	Required	Sample	Description
        //order_sn_list	string	True	201214JAJXU6G7,201214JASXYXY6	The set of order_sn. If there are multiple order_sn, you need to use English comma to connect them. limit [1,50]
        businessDTO.put("order_sn_list", reqDTO.getOrder_sn_list());
        //request_order_status_pending	boolean	False	true	Compatible parameter during migration period, send True will let API support PENDING status and return  pending_terms, send False or don’t send will fallback to old logic
        businessDTO.put("request_order_status_pending", reqDTO.getRequest_order_status_pending());
        //response_optional_fields	string	False	total_amount	a response fields you want to get. Please select from the below response parameters. If you input an object field, all the params under it will be included automatically in the response. If there are multiple response fields you want to get, you need to use English comma to connect them. Available values: buyer_user_id,buyer_username,estimated_shipping_fee,recipient_address,actual_shipping_fee ,goods_to_declare,note,note_update_time,item_list,pay_time,dropshipper, dropshipper_phone,split_up,buyer_cancel_reason,cancel_by,cancel_reason,actual_shipping_fee_confirmed,buyer_cpf_id,fulfillment_flag,pickup_done_time,package_list,shipping_carrier,payment_method,total_amount,buyer_username,invoice_data,no_plastic_packing,order_chargeable_weight_gram,edt,return_due_date
        businessDTO.put("response_optional_fields", reqDTO.getResponse_optional_fields());
        return businessDTO;
    }
}
