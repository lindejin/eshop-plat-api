package com.eshop.util.platform.api.service.logistics.aliexpress;

import com.eshop.util.platform.api.service.logistics.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressLogisticsEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/6 16:54
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressLogisticsCallImpl implements AliexpressLogisticsCall {


    //商家地址信息查询
    //描述：本对本支持查询商家地址信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.local.getlogisticsselleraddresses");
request.addApiParameter("seller_address_query", "pickup");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String getLogisticsSellerAddresses(AeAppClientDTO acDTO, AeLogisticsSellerAddressesDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.LOCAL_GET_LOGISTICS_SELLER_ADDRESSES.getApiName());
        request.addApiParameter("seller_address_query", reqDto.getSeller_address_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //列出所有的商家可见解决方案
    //描述：本对本列出所有的商家可见解决方案
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.local.listlogisticsservice");
request.addApiParameter("locale", "es_ES");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String localListLogisticsService(AeAppClientDTO acDTO, AeLogisticsLocalListLogisticsServiceDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.LOCAL_LIST_LOGISTICS_SERVICE.getApiName());
        request.addApiParameter("locale", reqDto.getLocale());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //读取下一级别的地址信息
    //描述：读取下一级别的地址信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getnextleveladdressdata");
request.addApiParameter("area_id", "1");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String getNextLevelAddressData(AeAppClientDTO acDTO, AeLogisticsNextLevelAddressDataDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_NEXT_LEVEL_ADDRESS_DATA.getApiName());
        request.addApiParameter("area_id", reqDto.getArea_id());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //面向海外物流ISV/合作伙伴获取速卖通订单发货信息的API
    //描述：面向海外物流ISV/合作伙伴获取速卖通订单发货信息的API
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.order.delivery.info.get");
request.addApiParameter("single_order_query", "{\"order_id\":\"3006413871042162\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String getOrderDeliveryInfo(AeAppClientDTO acDTO, AeLogisticsOrderDeliveryInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.ORDER_DELIVERY_INFO_GET.getApiName());
        request.addApiParameter("single_order_query", reqDto.getSingle_order_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //修改声明发货
    //描述：修改声明发货
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.sellermodifiedshipmentfortop");
request.addApiParameter("tracking_website", "www.17track.com");
request.addApiParameter("old_service_name", "EMS");
request.addApiParameter("new_service_name", "EMS");
request.addApiParameter("old_logistics_no", "LA111166611CN");
request.addApiParameter("description", "memo");
request.addApiParameter("new_logistics_no", "LA11111111CN");
request.addApiParameter("send_type", "part");
request.addApiParameter("out_ref", "60769040695804");
request.addApiParameter("package_type", "consolidation");
request.addApiParameter("actual_carrier", "tnt");
request.addApiParameter("locale", "ae_ES");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String sellerModifiedShipmentForTop(AeAppClientDTO acDTO, AeLogisticsSellerModifiedShipmentForTopDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.SELLER_MODIFIED_SHIPMENT_FOR_TOP.getApiName());
        request.addApiParameter("tracking_website", reqDto.getTracking_website());
        request.addApiParameter("old_service_name", reqDto.getOld_service_name());
        request.addApiParameter("new_service_name", reqDto.getNew_service_name());
        request.addApiParameter("old_logistics_no", reqDto.getOld_logistics_no());
        request.addApiParameter("description", reqDto.getDescription());
        request.addApiParameter("new_logistics_no", reqDto.getNew_logistics_no());
        request.addApiParameter("send_type", reqDto.getSend_type());
        request.addApiParameter("out_ref", reqDto.getOut_ref());
        request.addApiParameter("package_type", reqDto.getPackage_type());
        request.addApiParameter("actual_carrier", reqDto.getActual_carrier());
        request.addApiParameter("locale", reqDto.getLocale());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //列出平台所支持的物流服务列表
    //描述：此接口返回的物流服务于线上发货物流服务不同。此接口返回的物流服务用语卖家设置运费模板和声明发货，不能用于线上发货。请注意！
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.listlogisticsservice");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getListLogisticsService(AeAppClientDTO acDTO, AeLogisticsGetListLogisticsServiceDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.LIST_LOGISTICS_SERVICE.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //创建子交易单线上物流订单
    //描述：创建线上发货物流订单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.order.createorder");
request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", "false");
request.addApiParameter("oaid", "JciHsGTZP3uab180s4tRPw");
request.addApiParameter("pickup_type", "DOOR_PICKUP");
request.addApiParameter("address_d_t_os", "{\"receiver\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"sender\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"pickup\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"refund\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"}}");
request.addApiParameter("declare_product_d_t_os", "[{\"category_cn_desc\":\"\u8FDE\u8863\u88D9\",\"product_weight\":\"1.5\",\"aneroid_markup\":\"false\",\"product_num\":\"2\",\"only_battery\":\"false\",\"contains_special_goods\":\"false\",\"hs_code\":\"77234\",\"child_order_id\":\"1000172130022100\",\"product_declare_amount\":\"1.3\",\"sc_item_code\":\"scItem code\",\"sku_value\":\"sku value\",\"sc_item_name\":\"scItem name\",\"category_en_desc\":\"dress\",\"product_id\":\"1000\",\"breakable\":\"false\",\"sku_code\":\"sku code\",\"contains_battery\":\"false\",\"sc_item_id\":\"1000\"}]");
request.addApiParameter("domestic_logistics_company", "SF");
request.addApiParameter("domestic_logistics_company_id", "505");
request.addApiParameter("domestic_tracking_no", "L12345899");
request.addApiParameter("package_num", "1");
request.addApiParameter("trade_order_from", "ESCROW");
request.addApiParameter("trade_order_id", "66715700375804");
request.addApiParameter("undeliverable_decision", "0");
request.addApiParameter("warehouse_carrier_service", "CPAM_WLB_FPXSZ;CPAM_WLB_CPHSH;CPAM_WLB_ZTOBJ;HRB_WLB_ZTOGZ;HRB_WLB_ZTOSH");
request.addApiParameter("invoice_number", "38577123");
request.addApiParameter("top_user_key", "xxxxxxx");
request.addApiParameter("insurance_coverage", "{\"cent\":\"99\",\"currency_code\":\"USD\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String createOrder(AeAppClientDTO acDTO, AeLogisticsCreateOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.CREATE_ORDER.getApiName());
        request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", reqDto.getIs_agree_upgrade_reverse_parcel_insure());
        request.addApiParameter("oaid", reqDto.getOaid());
        request.addApiParameter("pickup_type", reqDto.getPickup_type());
        request.addApiParameter("address_d_t_os", reqDto.getAddress_d_t_os());
        request.addApiParameter("declare_product_d_t_os", reqDto.getDeclare_product_d_t_os());
        request.addApiParameter("domestic_logistics_company", reqDto.getDomestic_logistics_company());
        request.addApiParameter("domestic_logistics_company_id", reqDto.getDomestic_logistics_company_id());
        request.addApiParameter("domestic_tracking_no", reqDto.getDomestic_tracking_no());
        request.addApiParameter("package_num", reqDto.getPackage_num());
        request.addApiParameter("trade_order_from", reqDto.getTrade_order_from());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("undeliverable_decision", reqDto.getUndeliverable_decision());
        request.addApiParameter("warehouse_carrier_service", reqDto.getWarehouse_carrier_service());
        request.addApiParameter("invoice_number", reqDto.getInvoice_number());
        request.addApiParameter("top_user_key", reqDto.getTop_user_key());
        request.addApiParameter("insurance_coverage", reqDto.getInsurance_coverage());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //创建线上物流订单
    //描述：创建线上发货物流订单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.createwarehouseorder");
request.addApiParameter("declare_product_d_t_os", "[{\"category_cn_desc\":\"\u8FDE\u8863\u88D9\",\"product_weight\":\"1.5\",\"aneroid_markup\":\"false\",\"product_num\":\"2\",\"only_battery\":\"false\",\"contains_special_goods\":\"false\",\"hs_code\":\"77234\",\"child_order_id\":\"1000172130022100\",\"product_declare_amount\":\"1.3\",\"sc_item_code\":\"scItem code\",\"sku_value\":\"sku value\",\"sc_item_name\":\"scItem name\",\"category_en_desc\":\"dress\",\"product_id\":\"1000\",\"breakable\":\"false\",\"sku_code\":\"sku code\",\"contains_battery\":\"false\",\"sc_item_id\":\"1000\"}]");
request.addApiParameter("domestic_logistics_company", "tiantiankuaidi");
request.addApiParameter("domestic_logistics_company_id", "505");
request.addApiParameter("domestic_tracking_no", "L12345899");
request.addApiParameter("package_num", "1");
request.addApiParameter("trade_order_from", "ESCROW");
request.addApiParameter("trade_order_id", "66715700375804");
request.addApiParameter("undeliverable_decision", "0");
request.addApiParameter("warehouse_carrier_service", "CPAM_WLB_FPXSZ;CPAM_WLB_CPHSH;CPAM_WLB_ZTOBJ;HRB_WLB_ZTOGZ;HRB_WLB_ZTOSH");
request.addApiParameter("address_d_t_os", "{\"receiver\":{\"member_type\":\"\u7C7B\u578B\",\"street_address\":\"street address\",\"country\":\"RU\",\"city\":\"Moscow\",\"mobile\":\"18766234324\",\"county\":\"county\",\"address_id\":\"1000\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"sender\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"pickup\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"from_warehouse_code\":\"AML001\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"refund\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"}}");
request.addApiParameter("invoice_number", "38577123");
request.addApiParameter("top_user_key", "xxxxxxx");
request.addApiParameter("insurance_coverage", "{\"cent\":\"99\",\"currency_code\":\"USD\"}");
request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", "true");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String createWarehouseOrder(AeAppClientDTO acDTO, AeLogisticsCreateWarehouseOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.CREATE_WAREHOUSE_ORDER.getApiName());
        request.addApiParameter("declare_product_d_t_os", reqDto.getDeclare_product_d_t_os());
        request.addApiParameter("domestic_logistics_company", reqDto.getDomestic_logistics_company());
        request.addApiParameter("domestic_logistics_company_id", reqDto.getDomestic_logistics_company_id());
        request.addApiParameter("domestic_tracking_no", reqDto.getDomestic_tracking_no());
        request.addApiParameter("package_num", reqDto.getPackage_num());
        request.addApiParameter("trade_order_from", reqDto.getTrade_order_from());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("undeliverable_decision", reqDto.getUndeliverable_decision());
        request.addApiParameter("warehouse_carrier_service", reqDto.getWarehouse_carrier_service());
        request.addApiParameter("address_d_t_os", reqDto.getAddress_d_t_os());
        request.addApiParameter("invoice_number", reqDto.getInvoice_number());
        request.addApiParameter("top_user_key", reqDto.getTop_user_key());
        request.addApiParameter("insurance_coverage", reqDto.getInsurance_coverage());
        request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", reqDto.getIs_agree_upgrade_reverse_parcel_insure());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //声明发货接口
    //描述：填写发货通知
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.sellershipmentfortop");
request.addApiParameter("logistics_no", "LA88887777CN");
request.addApiParameter("description", "memo");
request.addApiParameter("send_type", "part");
request.addApiParameter("out_ref", "888877779999");
request.addApiParameter("tracking_website", "www.17track.com");
request.addApiParameter("service_name", "EMS");
request.addApiParameter("package_type", "consolidation");
request.addApiParameter("actual_carrier", "tnt");
request.addApiParameter("ioss", "XX1234567890");
request.addApiParameter("locale", "es_ES");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String sellerShipmentForTop(AeAppClientDTO acDTO, AeLogisticsSellerShipmentForTopDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.SELLER_SHIPMENT_FOR_TOP.getApiName());
        request.addApiParameter("logistics_no", reqDto.getLogistics_no());
        request.addApiParameter("description", reqDto.getDescription());
        request.addApiParameter("send_type", reqDto.getSend_type());
        request.addApiParameter("out_ref", reqDto.getOut_ref());
        request.addApiParameter("tracking_website", reqDto.getTracking_website());
        request.addApiParameter("service_name", reqDto.getService_name());
        request.addApiParameter("package_type", reqDto.getPackage_type());
        request.addApiParameter("actual_carrier", reqDto.getActual_carrier());
        request.addApiParameter("ioss", reqDto.getIoss());
        request.addApiParameter("locale", reqDto.getLocale());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //子单修改声明发货
    //描述：支持对子订单进行修改声明发货的接口
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.order.modifyshipment");
request.addApiParameter("sub_trade_order_list", "[{\"send_type\":\"part\",\"shipment_list\":[{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"http://ems.com\",\"logistics_no\":\"LV87654321CN\",\"service_name\":\"EMS\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"},{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"http://ems.com\",\"logistics_no\":\"LV87654321CN\",\"service_name\":\"EMS\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"}],\"sub_trade_order_index\":\"1\"}]");
request.addApiParameter("old_logistics_no", "LV87654321CN");
request.addApiParameter("trade_order_id", "888887777766");
request.addApiParameter("old_service_name", "EMS");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String modifyShipment(AeAppClientDTO acDTO, AeLogisticsModifyShipmentDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.MODIFY_SHIPMENT.getApiName());
        request.addApiParameter("sub_trade_order_list", reqDto.getSub_trade_order_list());
        request.addApiParameter("old_logistics_no", reqDto.getOld_logistics_no());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("old_service_name", reqDto.getOld_service_name());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //子单声明发货
    //描述：子单申明发货
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.order.shipment");
request.addApiParameter("param_aeop_seller_shipment_sub_trade_order_request", "{\"sub_trade_order_list\":[{\"send_type\":\"part\",\"ioss\":\"ioss\",\"shipment_list\":[{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"},{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"}],\"sub_trade_order_index\":\"12345601\"},{\"send_type\":\"part\",\"ioss\":\"ioss\",\"shipment_list\":[{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"},{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"}],\"sub_trade_order_index\":\"12345601\"}],\"trade_order_id\":\"123456\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String declareShipment(AeAppClientDTO acDTO, AeLogisticsDeclareShipmentDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.DECLARE_SHIPMENT.getApiName());
        request.addApiParameter("param_aeop_seller_shipment_sub_trade_order_request", reqDto.getParam_aeop_seller_shipment_sub_trade_order_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //批量获取线上发货标签
    //描述：批量获取线上发货标签(线上物流发货专用接口)
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getprintinfos");
request.addApiParameter("print_detail", "false");
request.addApiParameter("warehouse_order_query_d_t_os", "[{\"international_logistics_id\":\"RE700150389CN\",\"id\":\"123432423\"}]");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getOnlineShipmentLabelList(AeAppClientDTO acDTO, AeLogisticsGetPrintInfosDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_PRINT_INFOS.getApiName());
        request.addApiParameter("print_detail", reqDto.getPrint_detail());
        request.addApiParameter("warehouse_order_query_d_t_os", reqDto.getWarehouse_order_query_d_t_os());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //支持子订单声明发货接口
    //描述：支持子订单声明发货接口
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.sellershipmentsupportsubtradeorder");
request.addApiParameter("sub_trade_order_list", "[{\"send_type\":\"part\",\"ioss\":\"XX1234567890\",\"sub_trade_order_index\":\"1\",\"shipment_list\":[{\"tracking_web_site\":\"www.baidu.com\",\"logistics_no\":\"LT123456789CN\",\"service_name\":\"CAINIAO_STANDARD\"},{\"tracking_web_site\":\"www.baidu.com\",\"logistics_no\":\"LT123456789CN\",\"service_name\":\"CAINIAO_STANDARD\"}]}]");
request.addApiParameter("trade_order_id", "778824234234");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String sellerShipmentSupportSubTradeOrder(AeAppClientDTO acDTO, AeLogisticsSellerShipmentDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.SELLER_SHIPMENT_SUPPORT_SUB_TRADE_ORDER.getApiName());
        request.addApiParameter("sub_trade_order_list", reqDto.getSub_trade_order_list());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //支持对子订单进行修改声明发货的接口
    //描述：支持对子订单进行修改声明发货的接口
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.sellermodifiedshipmentsupportsubtradeorder");
request.addApiParameter("sub_trade_order_list", "[{\"send_type\":\"part\",\"shipment_list\":[{\"tracking_web_site\":\"http://ems.com\",\"logistics_no\":\"LV87654321CN\",\"service_name\":\"EMS\"},{\"tracking_web_site\":\"http://ems.com\",\"logistics_no\":\"LV87654321CN\",\"service_name\":\"EMS\"}],\"sub_trade_order_index\":\"1\"}]");
request.addApiParameter("old_logistics_no", "LV87654321CN");
request.addApiParameter("trade_order_id", "888887777766");
request.addApiParameter("old_service_name", "EMS");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String sellerModifiedShipmentSupportSubTradeOrder(AeAppClientDTO acDTO, AeLogisticsSellerModifiedShipmentDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.SELLER_MODIFIED_SHIPMENT_SUPPORT_SUB_TRADE_ORDER.getApiName());
        request.addApiParameter("sub_trade_order_list", reqDto.getSub_trade_order_list());
        request.addApiParameter("old_logistics_no", reqDto.getOld_logistics_no());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("old_service_name", reqDto.getOld_service_name());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //本对本创建线上物流订单
    //描述：本对本创建线上发货物流订单，目前只支持巴西本对本业务
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.local.createwarehouseorder");
request.addApiParameter("address_d_t_os", "{\"receiver\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"sender\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"}}");
request.addApiParameter("declare_product_d_t_os", "[{\"category_cn_desc\":\"\u8FDE\u8863\u88D9\",\"product_weight\":\"1.5\",\"aneroid_markup\":\"false\",\"product_num\":\"2\",\"only_battery\":\"false\",\"contains_special_goods\":\"false\",\"hs_code\":\"77234\",\"child_order_id\":\"1000172130022100\",\"product_declare_amount\":\"1.3\",\"sc_item_code\":\"scItem code\",\"sku_value\":\"sku value\",\"sc_item_name\":\"scItem name\",\"category_en_desc\":\"dress\",\"product_id\":\"1000\",\"breakable\":\"false\",\"sku_code\":\"sku code\",\"contains_battery\":\"false\",\"sc_item_id\":\"1000\"}]");
request.addApiParameter("package_num", "1");
request.addApiParameter("trade_order_from", "ESCROW");
request.addApiParameter("trade_order_id", "66715700375804");
request.addApiParameter("undeliverable_decision", "0");
request.addApiParameter("invoice_number", "38577123");
request.addApiParameter("top_user_key", "xxxxxxx");
request.addApiParameter("insurance_coverage", "{\"cent\":\"99\",\"currency_code\":\"USD\"}");
request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", "true");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String localCreateWarehouseOrder(AeAppClientDTO acDTO, AeLogisticsLocalCreateWarehouseOrderDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.LOCAL_CREATE_WAREHOUSE_ORDER.getApiName());
        request.addApiParameter("address_d_t_os", reqDto.getAddress_d_t_os());
        request.addApiParameter("declare_product_d_t_os", reqDto.getDeclare_product_d_t_os());
        request.addApiParameter("package_num", reqDto.getPackage_num());
        request.addApiParameter("trade_order_from", reqDto.getTrade_order_from());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("invoice_number", reqDto.getInvoice_number());
        request.addApiParameter("top_user_key", reqDto.getTop_user_key());
        request.addApiParameter("insurance_coverage", reqDto.getInsurance_coverage());
        request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", reqDto.getIs_agree_upgrade_reverse_parcel_insure());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询仓发物流订单信息
    //描述：查询仓发物流订单信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.warehouse.querydetail");
request.addApiParameter("consign_type", "DOMESTIC");
request.addApiParameter("current_page", "1");
request.addApiParameter("domestic_logistics_num", "CN123456789RU");
request.addApiParameter("gmt_create_end_str", "2016-09-09 00:00:00");
request.addApiParameter("gmt_create_start_str", "2016-09-09 00:00:00");
request.addApiParameter("international_logistics_num", "CN98989898US");
request.addApiParameter("logistics_status", "pickup_success");
request.addApiParameter("page_size", "20");
request.addApiParameter("trade_order_id", "8972343764328");
request.addApiParameter("warehouse_carrier_service", "E_PACKET");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String warehouseQueryDetail(AeAppClientDTO acDTO, AeLogisticsWarehouseQueryDetailDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.WAREHOUSE_QUERY_DETAIL.getApiName());
        request.addApiParameter("consign_type", reqDto.getConsign_type());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        request.addApiParameter("domestic_logistics_num", reqDto.getDomestic_logistics_num());
        request.addApiParameter("gmt_create_end_str", reqDto.getGmt_create_end_str());
        request.addApiParameter("gmt_create_start_str", reqDto.getGmt_create_start_str());
        request.addApiParameter("international_logistics_num", reqDto.getInternational_logistics_num());
        request.addApiParameter("logistics_status", reqDto.getLogistics_status());
        request.addApiParameter("page_size", reqDto.getPage_size());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("warehouse_carrier_service", reqDto.getWarehouse_carrier_service());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //查询声明发货信息
    //描述：查询声明发货信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.querysellershipmentinfo");
request.addApiParameter("logistics_no", "LT123456789CN");
request.addApiParameter("trade_order_id", "8899213123123");
request.addApiParameter("service_name", "CAINIAO_STANDARD");
request.addApiParameter("sub_trade_order_index", "1");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String querySellerShipmentInfo(AeAppClientDTO acDTO, AeLogisticsQuerySellerShipmentInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_SELLER_SHIPMENT_INFO.getApiName());
        request.addApiParameter("logistics_no", reqDto.getLogistics_no());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("service_name", reqDto.getService_name());
        request.addApiParameter("sub_trade_order_index", reqDto.getSub_trade_order_index());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询头程信息需要的枚举信息（国家，仓代码等）
    //描述：提供查询头程信息需要的枚举信息（国家，仓码等）
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.query.enum");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String queryEnum(AeAppClientDTO acDTO, AeLogisticsQueryEnumDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_ENUM.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //查询物流订单信息（推荐）
    //描述：该接口可以根据查询条件查询对应的物流订单的基本信息。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.querylogisticsorderdetail");
request.addApiParameter("current_page", "1");
request.addApiParameter("domestic_logistics_num", "CN123456789RU");
request.addApiParameter("gmt_create_end_str", "2016-09-09 00:00:00");
request.addApiParameter("gmt_create_start_str", "2016-09-10 00:00:00");
request.addApiParameter("international_logistics_num", "CN98989898US");
request.addApiParameter("logistics_status", "pickup_success");
request.addApiParameter("page_size", "20");
request.addApiParameter("trade_order_id", "8972343764328");
request.addApiParameter("warehouse_carrier_service", "E_PACKET");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String queryLogisticsOrderDetail(AeAppClientDTO acDTO, AeLogisticsQueryLogisticsOrderDetailDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_LOGISTICS_ORDER_DETAIL.getApiName());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        request.addApiParameter("domestic_logistics_num", reqDto.getDomestic_logistics_num());
        request.addApiParameter("gmt_create_end_str", reqDto.getGmt_create_end_str());
        request.addApiParameter("gmt_create_start_str", reqDto.getGmt_create_start_str());
        request.addApiParameter("international_logistics_num", reqDto.getInternational_logistics_num());
        request.addApiParameter("logistics_status", reqDto.getLogistics_status());
        request.addApiParameter("page_size", reqDto.getPage_size());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("warehouse_carrier_service", reqDto.getWarehouse_carrier_service());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询物流追踪信息
    //描述：查询物流追踪信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.querytrackingresult");
request.addApiParameter("logistics_no", "20100810142400000-0700");
request.addApiParameter("origin", "ESCROW");
request.addApiParameter("out_ref", "1160045240183009");
request.addApiParameter("service_name", "UPS");
request.addApiParameter("to_area", "DE");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String queryTrackingResult(AeAppClientDTO acDTO, AeLogisticsQueryTrackingDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_TRACKING_RESULT.getApiName());
        request.addApiParameter("logistics_no", reqDto.getLogistics_no());
        request.addApiParameter("origin", reqDto.getOrigin());
        request.addApiParameter("out_ref", reqDto.getOut_ref());
        request.addApiParameter("service_name", reqDto.getService_name());
        request.addApiParameter("to_area", reqDto.getTo_area());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //查询网规等物流信息
    //描述：查询网规等物流信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("/aliexpress/logistics/query/rule/info");
request.addApiParameter("param1", "{\"type\":\"serviceNetRule\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String queryRuleInfo(AeAppClientDTO acDTO, AeLogisticsQueryRuleInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_RULE_INFO.getApiName());
        request.addApiParameter("param1", reqDto.getParam1());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //根据交易单查询可用物流方案
    //描述：根据交易单查询可用物流方案
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.service.query");
request.addApiParameter("interface_request", "{\"goods_length\":\"1\",\"goods_height\":\"1\",\"goods_width\":\"1\",\"sub_order_list\":[{\"goods_length\":\"1\",\"goods_height\":\"1\",\"goods_width\":\"1\",\"locale\":\"zh_CN\",\"order_id\":\"8001498863155804\",\"goods_weight\":\"0.1\"},{\"goods_length\":\"1\",\"goods_height\":\"1\",\"goods_width\":\"1\",\"locale\":\"zh_CN\",\"order_id\":\"8001498863155804\",\"goods_weight\":\"0.1\"}],\"locale\":\"zh_CN\",\"order_id\":\"8001498863145804\",\"goods_weight\":\"0.1\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String queryLogisticsService(AeAppClientDTO acDTO, AeLogisticsQueryLogisticsServiceDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_LOGISTICS_SERVICE.getApiName());
        request.addApiParameter("interface_request", reqDto.getInterface_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //根据交易订单获取线上发货物流服务列表
    //描述："根据交易订单获取线上发货物流服务列表，线上发货物流服务仅能用于线上发货，请了解！ 以下包裹信息是不支持线上发货的，获取方案可能为空： 1、长\宽\高 加起来 不能大于90; 2、长宽高最大的一条边不能大于60cm; 3、包裹重量不能超过2KG; 4、已操作线下物流发货的订单。"
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getonlinelogisticsservicelistbyorderid");
request.addApiParameter("goods_width", "1");
request.addApiParameter("goods_height", "1");
request.addApiParameter("goods_weight", "1.5");
request.addApiParameter("goods_length", "1");
request.addApiParameter("order_id", "897234324234234");
request.addApiParameter("locale", "ru_RU");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getOnlineLogisticsServiceListByOrderId(AeAppClientDTO acDTO, AeLogisticsGetOnlineLogisticsServiceListByOrderIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_ONLINE_LOGISTICS_SERVICE_LIST_BY_ORDER_ID.getApiName());
        request.addApiParameter("goods_width", reqDto.getGoods_width());
        request.addApiParameter("goods_height", reqDto.getGoods_height());
        request.addApiParameter("goods_weight", reqDto.getGoods_weight());
        request.addApiParameter("goods_length", reqDto.getGoods_length());
        request.addApiParameter("order_id", reqDto.getOrder_id());
        request.addApiParameter("locale", reqDto.getLocale());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //物流包裹货值保费估算接口
    //描述：商家对包裹货值进行投保，预估算包裹保费费率
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.valueadded.insurance.estimate");
request.addApiParameter("agree_upgrade_reverse_parcel_insure", "true");
request.addApiParameter("trade_order_id", "400345345345");
request.addApiParameter("insurance_coverage", "4500");
request.addApiParameter("solution_code", "CAINIAO_STANDARD");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String estimateInsurance(AeAppClientDTO acDTO, AeLogisticsEstimateInsuranceDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.VALUE_ADDED_INSURANCE_ESTIMATE.getApiName());

        request.addApiParameter("agree_upgrade_reverse_parcel_insure", reqDto.getAgree_upgrade_reverse_parcel_insure());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        request.addApiParameter("insurance_coverage", reqDto.getInsurance_coverage());
        request.addApiParameter("solution_code", reqDto.getSolution_code());

        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取中国省份信息列表
    //描述：获取中国省份信息列表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getallprovince");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getAllProvince(AeAppClientDTO acDTO, AeLogisticsGetAllProvinceDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_ALL_PROVINCE.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取买家收货CPF信息
    //描述：获取买家收货CPF信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.getwlmailingaddresssnapshotdto");
request.addApiParameter("trade_order_id", "888899943434");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */


    @Override
    public String getBuyerCPFInfo(AeAppClientDTO acDTO, AeLogisticsBuyerCPFInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_WL_MAILING_ADDRESS_SNAPSHOT_DTO.getApiName());
        request.addApiParameter("trade_order_id", reqDto.getTrade_order_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取卖家地址
    //获取卖家地址
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getlogisticsselleraddresses");
request.addApiParameter("seller_address_query", "sender,pickup,refund");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getSellerAddresses(AeAppClientDTO acDTO, AeLogisticsSellerAddressDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_LOGISTICS_SELLER_ADDRESSES.getApiName());
        request.addApiParameter("seller_address_query", reqDto.getSeller_address_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取开展国内物流业务的物流公司
    //获取开展国内物流业务的物流公司
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.qureywlbdomesticlogisticscompany");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String queryWlbDomesticLogisticsCompany(AeAppClientDTO acDTO, AeLogisticsQueryWlbDomesticLogisticsCompanyDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.QUERY_WLB_DOMESTIC_LOGISTICS_COMPANY.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取打印面单的字段
    //获取打印面单的字段
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getfieldinfoforprint");
request.addApiParameter("international_logistics_id", "UR837927903YP");
request.addApiParameter("id", "3000001");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getFieldInfoForPrint(AeAppClientDTO acDTO, AeLogisticsGetFieldInfoForPrintDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_FIELD_INFO_FOR_PRINT.getApiName());
        request.addApiParameter("international_logistics_id", reqDto.getInternational_logistics_id());
        request.addApiParameter("id", reqDto.getId());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取物流公告信息
    //获取物流公告信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.getannouncement");
request.addApiParameter("seller_id", "200042360");
request.addApiParameter("start_time", "1622517071000");
request.addApiParameter("end_time", "1627787471000");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getAnnouncement(AeAppClientDTO acDTO, AeLogisticsAnnouncementDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_ANNOUNCEMENT.getApiName());

        request.addApiParameter("seller_id", reqDto.getSeller_id());
        request.addApiParameter("start_time", reqDto.getStart_time());
        request.addApiParameter("end_time", reqDto.getEnd_time());

        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取线上发货标签
    //获取线上发货标签
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getprintinfo");
request.addApiParameter("international_logistics_id", "RE700150389CN");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    @Override
    public String getOnlineShipmentLabel(AeAppClientDTO acDTO, AeLogisticsGetDeliveryLabelDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_PRINT_INFO.getApiName());
        request.addApiParameter("international_logistics_id", reqDto.getInternational_logistics_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取线上发货物流订单信息
    //描述：线上物流发货专用接口
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.redefining.getonlinelogisticsinfo");
request.addApiParameter("logistics_order_code", "LP00038357949881");
request.addApiParameter("china_logistics_id", "SF0000000000");
request.addApiParameter("international_logistics_id", "LC051733827CN");
request.addApiParameter("logistics_status", "CLOSED");
request.addApiParameter("gmt_create_end_str", "2016-06-27 18:15:00");
request.addApiParameter("page_size", "10");
request.addApiParameter("query_express_order", "false");
request.addApiParameter("current_page", "1");
request.addApiParameter("order_id", "60015640573917");
request.addApiParameter("gmt_create_start_str", "2016-06-27 18:20:00");
request.addApiParameter("logistics_order_id", "12424222");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String getOnlineLogisticsInfo(AeAppClientDTO acDTO, AeLogisticsGetOnlineLogisticsInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_ONLINE_LOGISTICS_INFO.getApiName());
        request.addApiParameter("logistics_order_code", reqDto.getLogistics_order_code());
        request.addApiParameter("china_logistics_id", reqDto.getChina_logistics_id());
        request.addApiParameter("international_logistics_id", reqDto.getInternational_logistics_id());
        request.addApiParameter("logistics_status", reqDto.getLogistics_status());
        request.addApiParameter("gmt_create_end_str", reqDto.getGmt_create_end_str());
        request.addApiParameter("page_size", reqDto.getPage_size());
        request.addApiParameter("query_express_order", reqDto.getQuery_express_order());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        request.addApiParameter("order_id", reqDto.getOrder_id());
        request.addApiParameter("gmt_create_start_str", reqDto.getGmt_create_start_str());
        request.addApiParameter("logistics_order_id", reqDto.getLogistics_order_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //面单云打印
    //描述：使用云打印功能打印面单
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.logistics.getpdfsbycloudprint");
request.addApiParameter("print_detail", "true");
request.addApiParameter("warehouse_order_query_d_t_os", "[{\"extend_data\":\"[{\\\"imageUrl\\\":\\\"http://xxxxxx\\\",\\\"productDescription\\\":\\\"ALIBAB\\\\r\\\\nALIBABA\\\\r\\\\nALIBABA\\\"}]\",\"international_logistics_id\":\"LM2342342CN\",\"id\":\"3546234234\"}]");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 使用云打印功能打印面单
     */
    @Override
    public String getPrintCloudLabel(AeAppClientDTO acDTO, AeLogisticsCloudPrintDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressLogisticsEnu.GET_PDFS_BY_CLOUD_PRINT.getApiName());

        request.addApiParameter("print_detail", reqDto.getPrint_detail());
        request.addApiParameter("warehouse_order_query_d_t_os", reqDto.getWarehouse_order_query_d_t_os());

        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
