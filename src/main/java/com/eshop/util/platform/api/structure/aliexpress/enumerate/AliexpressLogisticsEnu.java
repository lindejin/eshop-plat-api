package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/28 14:25
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressLogisticsEnu {
    //request.setApiName("aliexpress.logistics.local.getlogisticsselleraddresses");
    //商家地址信息查询
    LOCAL_GET_LOGISTICS_SELLER_ADDRESSES("aliexpress.logistics.local.getlogisticsselleraddresses"),
    //request.setApiName("aliexpress.logistics.local.listlogisticsservice");
    //列出所有的商家可见解决方案
    LOCAL_LIST_LOGISTICS_SERVICE("aliexpress.logistics.local.listlogisticsservice"),
    //request.setApiName("aliexpress.logistics.redefining.getnextleveladdressdata");
    //读取下一级别的地址信息
    GET_NEXT_LEVEL_ADDRESS_DATA("aliexpress.logistics.redefining.getnextleveladdressdata"),
    //request.setApiName("aliexpress.solution.order.delivery.info.get");
    //获取速卖通订单发货信息
    ORDER_DELIVERY_INFO_GET("aliexpress.solution.order.delivery.info.get"),
    //request.setApiName("aliexpress.logistics.sellermodifiedshipmentfortop");
    //修改声明发货
    SELLER_MODIFIED_SHIPMENT_FOR_TOP("aliexpress.logistics.sellermodifiedshipmentfortop"),
    //request.setApiName("aliexpress.logistics.redefining.listlogisticsservice");
    //列出平台所支持的物流服务列表
    LIST_LOGISTICS_SERVICE("aliexpress.logistics.redefining.listlogisticsservice"),
    //request.setApiName("aliexpress.logistics.order.createorder");
    //创建子交易单线上物流订单
    CREATE_ORDER("aliexpress.logistics.order.createorder"),
    //request.setApiName("aliexpress.logistics.createwarehouseorder");
    //创建线上物流订单
    CREATE_WAREHOUSE_ORDER("aliexpress.logistics.createwarehouseorder"),
    //request.setApiName("aliexpress.logistics.sellershipmentfortop");
    //声明发货接口
    SELLER_SHIPMENT_FOR_TOP("aliexpress.logistics.sellershipmentfortop"),
    //request.setApiName("aliexpress.logistics.order.modifyshipment");
    //子单修改声明发货
    MODIFY_SHIPMENT("aliexpress.logistics.order.modifyshipment"),
    //request.setApiName("aliexpress.logistics.order.shipment");
    //子单声明发货
    DECLARE_SHIPMENT("aliexpress.logistics.order.shipment"),
    //request.setApiName("aliexpress.logistics.redefining.getprintinfos");
    //批量获取线上发货标签
    GET_PRINT_INFOS("aliexpress.logistics.redefining.getprintinfos"),
    //request.setApiName("aliexpress.logistics.sellershipmentsupportsubtradeorder");
    //支持子订单声明发货接口
    SELLER_SHIPMENT_SUPPORT_SUB_TRADE_ORDER("aliexpress.logistics.sellershipmentsupportsubtradeorder"),
    //request.setApiName("aliexpress.logistics.redefining.sellermodifiedshipmentsupportsubtradeorder");
    //支持对子订单进行修改声明发货的接口
    SELLER_MODIFIED_SHIPMENT_SUPPORT_SUB_TRADE_ORDER("aliexpress.logistics.redefining.sellermodifiedshipmentsupportsubtradeorder"),
    //request.setApiName("aliexpress.logistics.local.createwarehouseorder");
    //本对本创建线上物流订单
    LOCAL_CREATE_WAREHOUSE_ORDER("aliexpress.logistics.local.createwarehouseorder"),
    //request.setApiName("aliexpress.logistics.warehouse.querydetail");
    //查询仓发物流订单信息
    WAREHOUSE_QUERY_DETAIL("aliexpress.logistics.warehouse.querydetail"),
    //request.setApiName("aliexpress.logistics.querysellershipmentinfo");
    //查询声明发货信息
    QUERY_SELLER_SHIPMENT_INFO("aliexpress.logistics.querysellershipmentinfo"),
    //request.setApiName("aliexpress.logistics.query.enum");
    //查询头程信息需要的枚举信息（国家，仓代码等）
    QUERY_ENUM("aliexpress.logistics.query.enum"),
    //request.setApiName("aliexpress.logistics.querylogisticsorderdetail");
    //查询物流订单信息（推荐）
    QUERY_LOGISTICS_ORDER_DETAIL("aliexpress.logistics.querylogisticsorderdetail"),
    //request.setApiName("aliexpress.logistics.redefining.querytrackingresult");
    //查询物流追踪信息
    QUERY_TRACKING_RESULT("aliexpress.logistics.redefining.querytrackingresult"),
    //request.setApiName("/aliexpress/logistics/query/rule/info");
    //查询网规等物流信息
    QUERY_RULE_INFO("aliexpress.logistics.query.rule.info"),
    //request.setApiName("aliexpress.logistics.service.query");
    //根据交易单查询可用物流方案
    QUERY_LOGISTICS_SERVICE("aliexpress.logistics.service.query"),
    //request.setApiName("aliexpress.logistics.redefining.getonlinelogisticsservicelistbyorderid");
    //根据交易订单获取线上发货物流服务列表
    GET_ONLINE_LOGISTICS_SERVICE_LIST_BY_ORDER_ID("aliexpress.logistics.redefining.getonlinelogisticsservicelistbyorderid"),
    //request.setApiName("aliexpress.logistics.valueadded.insurance.estimate");
    //物流包裹货值保费估算接口
    VALUE_ADDED_INSURANCE_ESTIMATE("aliexpress.logistics.valueadded.insurance.estimate"),
    //request.setApiName("aliexpress.logistics.redefining.getallprovince");
    //获取中国省份信息列表
    GET_ALL_PROVINCE("aliexpress.logistics.redefining.getallprovince"),
    //request.setApiName("aliexpress.logistics.getwlmailingaddresssnapshotdto");
    //获取买家收货CPF信息
    GET_WL_MAILING_ADDRESS_SNAPSHOT_DTO("aliexpress.logistics.getwlmailingaddresssnapshotdto"),
    //request.setApiName("aliexpress.logistics.redefining.getlogisticsselleraddresses");
    //获取卖家地址
    GET_LOGISTICS_SELLER_ADDRESSES("aliexpress.logistics.redefining.getlogisticsselleraddresses"),
    //request.setApiName("aliexpress.logistics.redefining.qureywlbdomesticlogisticscompany");
    //获取开展国内物流业务的物流公司
    QUERY_WLB_DOMESTIC_LOGISTICS_COMPANY("aliexpress.logistics.redefining.qureywlbdomesticlogisticscompany"),
    //request.setApiName("aliexpress.logistics.redefining.getfieldinfoforprint");
    //获取打印面单的字段
    GET_FIELD_INFO_FOR_PRINT("aliexpress.logistics.redefining.getfieldinfoforprint"),
    //request.setApiName("aliexpress.logistics.getannouncement");
    //获取物流公告信息
    GET_ANNOUNCEMENT("aliexpress.logistics.getannouncement"),
    //request.setApiName("aliexpress.logistics.redefining.getprintinfo");
    //获取线上发货标签
    GET_PRINT_INFO("aliexpress.logistics.redefining.getprintinfo"),
    //request.setApiName("aliexpress.logistics.redefining.getonlinelogisticsinfo");
    //获取线上发货物流订单信息
    GET_ONLINE_LOGISTICS_INFO("aliexpress.logistics.redefining.getonlinelogisticsinfo"),
    //request.setApiName("aliexpress.logistics.getpdfsbycloudprint");
    //使用云打印功能打印面单
    GET_PDFS_BY_CLOUD_PRINT("aliexpress.logistics.getpdfsbycloudprint");

    private final String apiName;

    AliexpressLogisticsEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
