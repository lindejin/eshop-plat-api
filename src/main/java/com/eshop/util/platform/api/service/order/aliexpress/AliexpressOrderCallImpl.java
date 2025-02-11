package com.eshop.util.platform.api.service.order.aliexpress;

import com.eshop.util.platform.api.service.order.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressOrderEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/6 17:27
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressOrderCallImpl implements AliexpressOrderCall {

    //获取订单收据信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.order.receiptinfo.get");
request.addApiParameter("param1", "{\"order_id\":\"123456789\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取订单收据信息
     */
    @Override
    public String getSolutionOrderReceiptInfo(AeAppClientDTO acDTO, AeOrderGetReceiptInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.GET_SOLUTION_ORDER_RECEIPT_INFO.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //从速卖通获取订单清单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.order.get");
request.addApiParameter("create_date_end", "2017-10-12 12:12:12");
request.addApiParameter("create_date_start", "2017-10-12 12:12:12");
request.addApiParameter("modified_date_start", "2017-10-12 12:12:12");
request.addApiParameter("order_status_list", "SELLER_PART_SEND_GOODS");
request.addApiParameter("buyer_login_id", "test_id");
request.addApiParameter("page_size", "20");
request.addApiParameter("modified_date_end", "2017-10-12 12:12:12");
request.addApiParameter("current_page", "1");
request.addApiParameter("order_status", "SELLER_PART_SEND_GOODS");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 从速卖通获取订单清单
     */
    @Override
    public String getSolutionOrderList(AeAppClientDTO acDTO, AeOrderGetSolutionOrderListDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.GET_SOLUTION_ORDER_LIST.getApiName());
        request.addApiParameter("create_date_end", reqDto.getCreate_date_end());
        request.addApiParameter("create_date_start", reqDto.getCreate_date_start());
        request.addApiParameter("modified_date_start", reqDto.getModified_date_start());
        request.addApiParameter("order_status_list", reqDto.getOrder_status_list());
        request.addApiParameter("buyer_login_id", reqDto.getBuyer_login_id());
        request.addApiParameter("page_size", reqDto.getPage_size());
        request.addApiParameter("modified_date_end", reqDto.getModified_date_end());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        request.addApiParameter("order_status", reqDto.getOrder_status());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //为卖家配送订单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.order.fulfill");
request.addApiParameter("service_name", "EMS");
request.addApiParameter("tracking_website", "www.17track.com");
request.addApiParameter("out_ref", "888877779999");
request.addApiParameter("send_type", "part");
request.addApiParameter("description", "memo");
request.addApiParameter("logistics_no", "LA88887777CN");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 为卖家配送订单
     */
    @Override
    public String fulfillSolutionOrder(AeAppClientDTO acDTO, AeOrderFulfillSolutionOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FULFILL_SOLUTION_ORDER.getApiName());
        request.addApiParameter("service_name", reqDto.getService_name());
        request.addApiParameter("tracking_website", reqDto.getTracking_website());
        request.addApiParameter("out_ref", reqDto.getOut_ref());
        request.addApiParameter("send_type", reqDto.getSend_type());
        request.addApiParameter("description", reqDto.getDescription());
        request.addApiParameter("logistics_no", reqDto.getLogistics_no());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //买家订单物流详情解密
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.seller.order.decrypt");
request.addApiParameter("orderId", "8152891820014001");
request.addApiParameter("oaid", "MjAwMDQyMzYw-ssfsvnL3Nv%2B%2B54ABsv%2BaoQ");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 买家订单物流详情解密
     */
    @Override
    public String decryptOrder(AeAppClientDTO acDTO, AeOrderDecryptOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.DECRYPT_ORDER.getApiName());
        request.addApiParameter("orderId", reqDto.getOrderId());
        request.addApiParameter("oaid", reqDto.getOaid());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //卖家同意取消订单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.seller.order.acceptcancel");
request.addApiParameter("param_order_cancel_request", "{\"buyer_login_id\":\"test1\",\"order_id\":\"2345789067\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 卖家同意取消订单
     */
    @Override
    public String acceptCancelOrder(AeAppClientDTO acDTO, AeOrderAcceptCancelOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.ACCEPT_CANCEL_ORDER.getApiName());
        request.addApiParameter("param_order_cancel_request", reqDto.getParam_order_cancel_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //卖家拒绝取消订单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.seller.order.refusecancel");
request.addApiParameter("param_order_cancel_request", "{\"buyer_login_id\":\"test\",\"memo\":\"already send googds\",\"order_id\":\"33440956789\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 卖家拒绝取消订单
     */
    @Override
    public String refuseCancelOrder(AeAppClientDTO acDTO, AeOrderRefuseCancelOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.REFUSE_CANCEL_ORDER.getApiName());
        request.addApiParameter("param_order_cancel_request", reqDto.getParam_order_cancel_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //平台固定参数获取
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.taxation.platform.open.get");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 平台固定参数获取
     */
    @Override
    public String getTaxationPlatform(AeAppClientDTO acDTO, AeOrderGetTaxationPlatformDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.GET_TAXATION_PLATFORM.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //延长买家收货时间
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.redefining.extendsbuyeracceptgoodstime");
request.addApiParameter("param0", "123456789");
request.addApiParameter("param1", "5");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 延长买家收货时间
     */
    @Override
    public String extendsBuyerAcceptGoodsTime(AeAppClientDTO acDTO, AeOrderExtendsBuyerAcceptGoodsTimeDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.EXTENDS_BUYER_ACCEPT_GOODS_TIME.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //新版交易订单详情查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.new.redefining.findorderbyid");
request.addApiParameter("param1", "{\"show_id\":\"1\",\"ext_info_bit_flag\":\"111111\",\"field_list\":\"1\",\"order_id\":\"12345678\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 新版交易订单详情查询
     */
    @Override
    public String findOrderById(AeAppClientDTO acDTO, AeOrderFindOrderByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FIND_ORDER_BY_ID.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //查询卖家备注内容
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.merchant.redefining.queryremarks");
request.addApiParameter("biz_type", "0");
request.addApiParameter("remark_ids", "123123123,123123124");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询卖家备注内容
     */
    @Override
    public String queryRemarks(AeAppClientDTO acDTO, AeOrderQueryRemarksDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.QUERY_REMARKS.getApiName());
        request.addApiParameter("biz_type", reqDto.getBiz_type());
        request.addApiParameter("remark_ids", reqDto.getRemark_ids());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //查询订单卖家备注
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.merchant.redefining.queryremark");
request.addApiParameter("biz_type", "0");
request.addApiParameter("remark_id", "1234132345");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询订单卖家备注
     */
    @Override
    public String queryRemark(AeAppClientDTO acDTO, AeOrderQueryRemarkDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.QUERY_REMARK.getApiName());
        request.addApiParameter("biz_type", reqDto.getBiz_type());
        request.addApiParameter("remark_id", reqDto.getRemark_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询订单放款信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.redefining.findloanlistquery");
request.addApiParameter("param1", "{\"loan_status\":\"wait_loan\",\"create_date_end\":\"10/09/2013 00:00:00\",\"create_date_start\":\"10/08/2013 00:00:00\",\"page\":\"1\",\"order_id\":\"97191172200623\",\"page_size\":\"20\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询订单放款信息
     */
    @Override
    public String findLoanListQuery(AeAppClientDTO acDTO, AeOrderFindLoanListQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FIND_LOAN_LIST_QUERY.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //订单交易信息查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.redefining.findordertradeinfo");
request.addApiParameter("param1", "{\"buyer_aliid\":\"12345\",\"show_id\":\"12345\",\"seller_operator_aliid\":\"12345\",\"seller_aliid\":\"12345\",\"field_list\":\"12345\",\"ext_info_bit_flag\":\"12345\",\"order_id\":\"700459681162799\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 订单交易信息查询
     */
    @Override
    public String findOrderTradeInfo(AeAppClientDTO acDTO, AeOrderFindOrderTradeInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FIND_ORDER_TRADE_INFO.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //订单列表查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.seller.orderlist.get");
request.addApiParameter("param_aeop_order_query", "{\"modified_date_start\":\"2017-10-12 12:12:12\",\"modified_date_end\":\"2017-10-12 12:12:12\",\"order_status\":\"SELLER_PART_SEND_GOODS\",\"create_date_end\":\"2017-10-12 12:12:12\",\"create_date_start\":\"2017-10-12 12:12:12\",\"buyer_login_id\":\"test\",\"current_page\":\"1\",\"order_status_list\":[\"SELLER_PART_SEND_GOODS\",\"SELLER_PART_SEND_GOODS\"],\"page_size\":\"20\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 订单列表查询
     */
    @Override
    public String orderListGet(AeAppClientDTO acDTO, AeOrderOrderListGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.ORDER_LIST_GET.getApiName());
        request.addApiParameter("param_aeop_order_query", reqDto.getParam_aeop_order_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //订单列表简化查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.redefining.findorderlistsimplequery");
request.addApiParameter("param1", "{\"order_status\":\"PLACE_ORDER_SUCCESS\",\"create_date_end\":\"2015-07-10 00:00:00\",\"create_date_start\":\"2015-07-09 00:00:00\",\"page\":\"1\",\"order_status_list\":[\"PLACE_ORDER_SUCCESS\",\"WAIT_SELLER_SEND_GOODS\"],\"page_size\":\"20\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 订单列表简化查询
     */
    @Override
    public String findOrderListSimpleQuery(AeAppClientDTO acDTO, AeOrderFindOrderListSimpleQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FIND_ORDER_LIST_SIMPLE_QUERY.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //订单基础信息查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.redefining.findorderbaseinfo");
request.addApiParameter("param1", "{\"buyer_aliid\":\"12345\",\"show_id\":\"12345\",\"seller_operator_aliid\":\"12345\",\"seller_aliid\":\"12345\",\"field_list\":\"12345\",\"ext_info_bit_flag\":\"12345\",\"order_id\":\"123456789\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 订单基础信息查询
     */
    @Override
    public String findOrderBaseInfo(AeAppClientDTO acDTO, AeOrderFindOrderBaseInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FIND_ORDER_BASE_INFO.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //订单收货信息查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.trade.redefining.findorderreceiptinfo");
request.addApiParameter("param1", "{\"buyer_aliid\":\"100000\",\"show_id\":\"1\",\"seller_operator_aliid\":\"20000\",\"seller_aliid\":\"20000\",\"field_list\":\"orderAmount\",\"ext_info_bit_flag\":\"10100\",\"order_id\":\"123456789\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 订单收货信息查询
     */
    @Override
    public String findOrderReceiptInfo(AeAppClientDTO acDTO, AeOrderFindOrderReceiptInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.FIND_ORDER_RECEIPT_INFO.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //记录订单备注信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.merchant.redefining.saveremark");
request.addApiParameter("biz_type", "0");
request.addApiParameter("remark_id", "23432412341234");
request.addApiParameter("content", "hello");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 记录订单备注信息
     */
    @Override
    public String saveRemark(AeAppClientDTO acDTO, AeOrderSaveRemarkDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressOrderEnu.SAVE_REMARK.getApiName());
        request.addApiParameter("biz_type", reqDto.getBiz_type());
        request.addApiParameter("remark_id", reqDto.getRemark_id());
        request.addApiParameter("content", reqDto.getContent());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
