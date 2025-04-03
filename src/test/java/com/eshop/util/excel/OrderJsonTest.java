package com.eshop.util.excel;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eshop.entity.config.TbShop;
import com.eshop.entity.order.TbOrder;
import com.eshop.service.config.ITbShopService;
import com.eshop.service.order.ITbOrderService;
import com.eshop.util.ShopeeOrderDetailReqDTO;
import com.eshop.util.ShopeeOrderDetailRespVO;
import com.eshop.util.platform.api.service.order.shopee.ShopeeOrderCall;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Service
public class OrderJsonTest {

    @Resource
    private ShopeeOrderCall shopeeOrderCall;

    @Resource
    private ITbShopService iTbShopService;

    @Resource
    private ITbOrderService iTbOrderService;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;


    public List<ShopeeOrderDetailRespVO> getOrderJSON(Set<String> orderNos) throws Exception {
        LambdaQueryWrapper<TbOrder> lqWrapper = Wrappers.<TbOrder>lambdaQuery();
        lqWrapper.in(TbOrder::getOrderNo, orderNos);
        List<TbOrder> tempList = iTbOrderService.list(lqWrapper);

        Set<Long> shopIds = tempList.stream().map(TbOrder::getShopId).collect(Collectors.toSet());

        LambdaQueryWrapper<TbShop> shopWrapper = Wrappers.<TbShop>lambdaQuery();
        shopWrapper.in(TbShop::getId, shopIds);
        List<TbShop> shopList = iTbShopService.list(shopWrapper);

        Map<Long, ShopeeAppClientDTO> clienMap = new HashMap<>();
        Map<Long, TbShop> shopMap = new HashMap<>();
        for (TbShop shopDO : shopList) {
            try {
                ShopeeAppClientDTO clientDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
                clienMap.put(shopDO.getId(), clientDTO);
                shopMap.put(shopDO.getId(), shopDO);
            } catch (Exception e) {
            }
        }
//        Map<String, ShopeeOrderDetailRespVO> respMap = new HashMap<>();
//        for (TbOrder tbOrder : list) {
//            String orderNo = tbOrder.getOrderNo();
//            ShopeeAppClientDTO clientDTO = clienMap.get(tbOrder.getShopId());
//            ShopeeOrderDetailRespVO orderDetail = getOrderDetail(clientDTO, orderNo);
//            respMap.put(orderNo, orderDetail);
//        }

        List<CompletableFuture<List<ShopeeOrderDetailRespVO>>> futures = tempList.stream()
                .map(tbOrder -> CompletableFuture.supplyAsync(() -> {
                    try {
                        String orderNo = tbOrder.getOrderNo();
                        ShopeeAppClientDTO clientDTO = clienMap.get(tbOrder.getShopId());
                        ShopeeOrderDetailRespVO orderDetail = getOrderDetail(clientDTO, orderNo);

                        if (ObjectUtil.isEmpty(orderDetail)) {
                            return Collections.emptyList();
                        }
                        List<ShopeeOrderDetailRespVO> result = new ArrayList<>();
                        result.add(orderDetail);
                        return result;
                    } catch (Exception e) {
                        // 处理异常
                        e.printStackTrace();
                        return Collections.emptyList();
                    }
                }, excelTaskPool))
                .map(future -> future.thenApply(list -> list.stream().map(ShopeeOrderDetailRespVO.class::cast).collect(Collectors.toList())))
                .collect(Collectors.toList());

        List<ShopeeOrderDetailRespVO> results = futures.stream()
                .map(CompletableFuture::join) // 等待所有任务完成
                .filter(p -> ObjectUtil.isNotEmpty(p))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<ShopeeOrderDetailRespVO> ppList = results.stream().filter(p -> ObjectUtil.isNotEmpty(p)).collect(Collectors.toList());
        return ppList;
    }


    private ShopeeOrderDetailRespVO getOrderDetail(ShopeeAppClientDTO publicDTO, String orderNo) throws Exception {
        ShopeeAppClientDTO scDTO = publicDTO;
        ShopeeOrderDetailReqDTO reqDTO = getOrderDetailDTO(orderNo);
        ShopeeOrderDetailRespVO respVO = getOrderDetail(scDTO, reqDTO);
        return respVO;
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
}
