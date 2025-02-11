package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/4/13 14:42
 * @Description: 速卖通 供应链接口
 * @Version 1.0
 */
public enum AliexpressScpEnu {

    //● HSF
    // "aliexpress.warehouse.address.get"
    // /aliexpress/warehouse/address/get
    WAREHOUSE_ADDRESS_GET("/aliexpress/warehouse/address/get"),
    //● HSF
    // "aliexpress.warehouse.item.create.post
    // "/aliexpress/warehouse/item/create/post
    WAREHOUSE_ITEM_CREATE_POST("/aliexpress/warehouse/item/create/post"),
    //● HSF
    // "aliexpress.warehouse.return.fo.cancel.post"
    // /aliexpress/warehouse/return/fo/cancel/post
    WAREHOUSE_RETURN_FO_CANCEL_POST("/aliexpress/warehouse/return/fo/cancel/post"),
    //● HSF
    // "aliexpress.warehouse.return.fo.create.post"
    // /aliexpress/warehouse/return/fo/create/post
    WAREHOUSE_RETURN_FO_CREATE_POST("/aliexpress/warehouse/return/fo/create/post"),
    //● HSF
    // "aliexpress.warehouse.reverse.fo.cancel.post"
    // /aliexpress/warehouse/reverse/fo/cancel/post
    WAREHOUSE_REVERSE_FO_CANCEL_POST("/aliexpress/warehouse/reverse/fo/cancel/post"),
    //● HSF
    // "aliexpress.warehouse.reverse.fo.create.post"
    // /aliexpress/warehouse/reverse/fo/create/post
    WAREHOUSE_REVERSE_FO_CREATE_POST("/aliexpress/warehouse/reverse/fo/create/post"),
    //● HSF
    // "qimen.aliexpress.warehouse.baseinfo.get"
    // /qimen/aliexpress/warehouse/baseinfo/get
    QIMEN_WAREHOUSE_BASEINFO_GET("/qimen/aliexpress/warehouse/baseinfo/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.calculateFee.get"
    // /qimen/aliexpress/warehouse/calculateFee/get
    QIMEN_WAREHOUSE_CALCULATE_FEE_GET("/qimen/aliexpress/warehouse/calculateFee/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.fo.cancel.post"
    // /qimen/aliexpress/warehouse/fo/cancel/post
    QIMEN_WAREHOUSE_FO_CANCEL_POST("/qimen/aliexpress/warehouse/fo/cancel/post"),
    //● HSF
    // "qimen.aliexpress.warehouse.fo.detail.get"
    // /qimen/aliexpress/warehouse/fo/detail/get
    QIMEN_WAREHOUSE_FO_DETAIL_GET("/qimen/aliexpress/warehouse/fo/detail/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.fo.intercept.post"
    // /qimen/aliexpress/warehouse/fo/intercept/post
    QIMEN_WAREHOUSE_FO_INTERCEPT_POST("/qimen/aliexpress/warehouse/fo/intercept/post"),
    //● HSF
    // "qimen.aliexpress.warehouse.fo.modify.post"
    // /qimen/aliexpress/warehouse/fo/modify/post
    QIMEN_WAREHOUSE_FO_MODIFY_POST("/qimen/aliexpress/warehouse/fo/modify/post"),
    //● HSF
    // "qimen.aliexpress.warehouse.inventory.get"
    // /qimen/aliexpress/warehouse/inventory/get
    QIMEN_WAREHOUSE_INVENTORY_GET("/qimen/aliexpress/warehouse/inventory/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.logistics.get"
    // /qimen/aliexpress/warehouse/logistics/get
    QIMEN_WAREHOUSE_LOGISTICS_GET("/qimen/aliexpress/warehouse/logistics/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.owner.id.check.get"
    // /qimen/aliexpress/warehouse/owner/id/check/get
    QIMEN_WAREHOUSE_OWNER_ID_CHECK_GET("/qimen/aliexpress/warehouse/owner/id/check/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.sales.get"
    // /qimen/aliexpress/warehouse/sales/get
    QIMEN_WAREHOUSE_SALES_GET("/qimen/aliexpress/warehouse/sales/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.sku.bindlist.post"
    // /qimen/aliexpress/warehouse/sku/bindlist/post
    QIMEN_WAREHOUSE_SKU_BINDLIST_POST("/qimen/aliexpress/warehouse/sku/bindlist/post"),
    //● HSF
    // "qimen.aliexpress.warehouse.skulist.info.get"
    // /qimen/aliexpress/warehouse/skulist/info/get
    QIMEN_WAREHOUSE_SKULIST_INFO_GET("/qimen/aliexpress/warehouse/skulist/info/get"),
    //● HSF
    // "qimen.aliexpress.warehouse.subscribe.get"
    // /qimen/aliexpress/warehouse/subscribe/get
    QIMEN_WAREHOUSE_SUBSCRIBE_GET("/qimen/aliexpress/warehouse/subscribe/get"),

    //● POST
    // AliExpress入库单创建API
    // aliexpress.ascp.po.create
    ASCP_PO_CREATE("aliexpress.ascp.po.create"),
    //● POST
    // AliExpress入库单取消API
    // aliexpress.ascp.po.cancel
    ASCP_PO_CANCEL("aliexpress.ascp.po.cancel"),
    //● GET/POST
    // AliExpress发货单明细分页查询API
    // aliexpress.ascp.ffo.item.query
    ASCP_FFO_ITEM_QUERY("aliexpress.ascp.ffo.item.query"),
    //● GET/POST
    // AliExpress发货单查询API
    // aliexpress.ascp.ffo.query
    ASCP_FFO_QUERY("aliexpress.ascp.ffo.query"),
    //● POST
    // AliExpress商货绑定API
    // aliexpress.ascp.item.bind
    ASCP_ITEM_BIND("aliexpress.ascp.item.bind"),
    //● POST
    // AliExpress商货解绑API
    // aliexpress.ascp.item.unBind
    ASCP_ITEM_UNBIND("aliexpress.ascp.item.unBind"),
    //● GET/POST
    // AliExpress在仓库存查询API
    // aliexpress.ascp.warehouse.inventory.query
    ASCP_WAREHOUSE_INVENTORY_QUERY("aliexpress.ascp.warehouse.inventory.query"),
    //● GET/POST
    // AliExpress在途库存查询API
    // aliexpress.ascp.onway.inventory.query
    ASCP_ONWAY_INVENTORY_QUERY("aliexpress.ascp.onway.inventory.query"),
    //● GET/POST
    // AliExpress库存流水查询API
    // aliexpress.ascp.inventory.log.query
    ASCP_INVENTORY_LOG_QUERY("aliexpress.ascp.inventory.log.query"),
    //● POST
    // AliExpress货品创建API
    // aliexpress.ascp.scitem.create
    ASCP_SCITEM_CREATE("aliexpress.ascp.scitem.create"),
    //● GET/POST
    // AliExpress货品查询API
    // aliexpress.ascp.item.query
    ASCP_ITEM_QUERY("aliexpress.ascp.item.query"),
    //● POST
    // AliExpress货品编辑API
    // aliexpress.ascp.scitem.update
    ASCP_SCITEM_UPDATE("aliexpress.ascp.scitem.update"),
    //● GET/POST
    // AliExpress采购单明细查询API
    // aliexpress.ascp.po.item.query
    ASCP_PO_ITEM_QUERY("aliexpress.ascp.po.item.query"),
    //● GET/POST
    // AliExpress采购单查询API
    // aliexpress.ascp.po.query
    ASCP_PO_QUERY("aliexpress.ascp.po.query"),
    //● GET/POST aliexpress.ascp.fro.item.query
    // AE履约销退单明细查询API
    // aliexpress.ascp.fro.item.query
    ASCP_FRO_ITEM_QUERY("aliexpress.ascp.fro.item.query"),
    //● GET/POST aliexpress.ascp.fro.query
    // AE履约销退单查询接口
    // aliexpress.ascp.fro.query
    ASCP_FRO_QUERY("aliexpress.ascp.fro.query"),
    //● GET/POST aliexpress.ascp.ro.item.query
    //AE仓发 单个退供单明细查询
    // aliexpress.ascp.ro.item.query
    ASCP_RO_ITEM_QUERY("aliexpress.ascp.ro.item.query"),
    //● GET/POST aliexpress.ascp.ro.query
    //AE仓发商家单个退供单查询接口
    // aliexpress.ascp.ro.query
    ASCP_RO_QUERY("aliexpress.ascp.ro.query"),
    //● HSF aliexpress.warehouse.owner.create.post
    // create or deactivate owner to isv
    // /aliexpress/warehouse/owner/create/post
    WAREHOUSE_OWNER_CREATE_POST("/aliexpress/warehouse/owner/create/post"),
    //● HSF qimen.aliexpress.warehouse.fo.create.async.post
    // "create fulfillment order async"
    // /qimen/aliexpress/warehouse/fo/create/async/post
    QIMEN_WAREHOUSE_FO_CREATE_ASYNC_POST("/qimen/aliexpress/warehouse/fo/create/async/post"),
    //● HSF qimen.aliexpress.warehouse.test.post
    // test reverse api
    // /qimen/aliexpress/warehouse/test/post
    QIMEN_WAREHOUSE_TEST_POST("/qimen/aliexpress/warehouse/test/post"),
    //● GET/POST
    // 修改自寄（送）单信息
    // aliexpress.ascp.po.updateSelfdelivery
    ASCP_PO_UPDATE_SELFDELIVERY("aliexpress.ascp.po.updateSelfdelivery"),
    //● GET/POST
    // 创建揽收单
    // aliexpress.ascp.po.createPickupOrder
    ASCP_PO_CREATE_PICKUP_ORDER("aliexpress.ascp.po.createPickupOrder"),
    //● GET/POST
    // 取消揽收单
    // aliexpress.ascp.po.cancelPickupOrder
    ASCP_PO_CANCEL_PICKUP_ORDER("aliexpress.ascp.po.cancelPickupOrder"),
    //● GET/POST
    // 取消自送单
    // aliexpress.ascp.po.cancelSelfDelivery
    ASCP_PO_CANCEL_SELF_DELIVERY("aliexpress.ascp.po.cancelSelfDelivery"),
    //● GET/POST
    // 库存变更获取
    // aliexpress.ecowarehouse.inventory.change.get
    ECOWAREHOUSE_INVENTORY_CHANGE_GET("aliexpress.ecowarehouse.inventory.change.get"),
    //● POST
    // 库存售罄 & 恢复 & 预警同步
    // aliexpress.ecowarehouse.inventory.notify.get
    ECOWAREHOUSE_INVENTORY_NOTIFY_GET("aliexpress.ecowarehouse.inventory.notify.get"),
    //● GET/POST
    // 打印揽收面单
    // aliexpress.ascp.po.createPickupShippingMarkPdf
    ASCP_PO_CREATE_PICKUP_SHIPPING_MARK_PDF("aliexpress.ascp.po.createPickupShippingMarkPdf"),
    //● GET/POST
    // 打印箱唛
    // aliexpress.ascp.po.query.createShippingMarkPdf
    ASCP_PO_QUERY_CREATE_SHIPPING_MARK_PDF("aliexpress.ascp.po.query.createShippingMarkPdf"),
    //● GET
    // 打印自送面单
    // aliexpress.ascp.po.printSelfDeliveryMarkPdf
    ASCP_PO_PRINT_SELF_DELIVERY_MARK_PDF("aliexpress.ascp.po.printSelfDeliveryMarkPdf"),
    //● GET/POST
    // 打印货品标签
    // aliexpress.ascp.po.createScItemBarcodePdf
    ASCP_PO_CREATE_SC_ITEM_BARCODE_PDF("aliexpress.ascp.po.createScItemBarcodePdf"),
    //● POST
    // 批量填写自行发货信息
    // aliexpress.ascp.po.selfdelivery
    ASCP_PO_SELF_DELIVERY("aliexpress.ascp.po.selfdelivery"),
    //● GET/POST
    // 揽收单预估费用
    // aliexpress.aidc.pickup.costEstimate
    AIDC_PICKUP_COST_ESTIMATE("aliexpress.aidc.pickup.costEstimate"),
    //● GET/POST
    // 查看自寄（送）单
    // aliexpress.ascp.po.querysSelfdelivery
    ASCP_PO_QUERYS_SELFDELIVERY("aliexpress.ascp.po.querysSelfdelivery"),
    //● GET/POST
    // 查询揽收单
    // aliexpress.ascp.po.queryPickupOrder
    ASCP_PO_QUERY_PICKUP_ORDER("aliexpress.ascp.po.queryPickupOrder"),
    //● GET/POST
    // 生态仓对账上传csv文件
    // aliexpress.ecowarehouse.reverse.order.upload
    ECOWAREHOUSE_REVERSE_ORDER_UPLOAD("aliexpress.ecowarehouse.reverse.order.upload"),
    //● GET/POST
    // 生态仓物流订单状态通知
    // aliexpress.ecowarehouse.order.status.post
    ECOWAREHOUSE_ORDER_STATUS_POST("aliexpress.ecowarehouse.order.status.post"),
    //● GET/POST
    // 生态仓逆向物流订单状态通知
    // aliexpress.ecowarehouse.reverse.order.status.post
    ECOWAREHOUSE_REVERSE_ORDER_STATUS_POST("aliexpress.ecowarehouse.reverse.order.status.post"),
    //● GET货品详情
    // aliexpress.ascp.item.detail
    ASCP_ITEM_DETAIL("aliexpress.ascp.item.detail"),
    //● GET/POST
    // 逆向单据费用回传
    // aliexpress.ecowarehouse.reverse.order.fee.post
    ECOWAREHOUSE_REVERSE_ORDER_FEE_POST("aliexpress.ecowarehouse.reverse.order.fee.post"),
    //● GET/POST
    // 采购单分页查询
    // aliexpress.ascp.po.pageQuery
    ASCP_PO_PAGE_QUERY("aliexpress.ascp.po.pageQuery"),
    //● GET/POST
    // 采购单确认
    // aliexpress.ascp.po.confirmPurchaseOrder
    ASCP_PO_CONFIRM_PURCHASE_ORDER("aliexpress.ascp.po.confirmPurchaseOrder"),



// 1.备货单查询
      // aliexpress.ascp.po.erp.pageQuery (AE仓发备货单-分页查询单据)
      ALIEXPRESS_ASCP_PO_ERP_PAGE_QUERY("aliexpress.ascp.po.erp.pageQuery"),

      // aliexpress.ascp.po.erp.pageQueryItem（AE仓发备货单-分页查询货品）
      ALIEXPRESS_ASCP_PO_ERP_PAGE_QUERY_ITEM("aliexpress.ascp.po.erp.pageQueryItem"),

// 2.确认接单
      // aliexpress.ascp.po.erp.confirm  （AE仓发备货单-确认接单）
      ALIEXPRESS_ASCP_PO_ERP_CONFIRM("aliexpress.ascp.po.erp.confirm"),


// 3.创建发货单
      // aliexpress.ascp.co.erp.create (AE仓发发货单-创建发货单)
      ALIEXPRESS_ASCP_CO_ERP_CREATE("aliexpress.ascp.co.erp.create"),

      // aliexpress.ascp.co.erp.cancel（AE仓发发货单-取消发货单）
      ALIEXPRESS_ASCP_CO_ERP_CANCEL("aliexpress.ascp.co.erp.cancel"),

      // aliexpress.ascp.co.erp.pageQuery（AE仓发发货单-分页查询单据）
      ALIEXPRESS_ASCP_CO_ERP_PAGE_QUERY("aliexpress.ascp.co.erp.pageQuery"),

      // aliexpress.ascp.co.erp.pageQueryItem（AE仓发发货单-分页查询货品）
      ALIEXPRESS_ASCP_CO_ERP_PAGE_QUERY_ITEM("aliexpress.ascp.co.erp.pageQueryItem"),

//      // aliexpress.ascp.ffo.item.query (AliExpress发货单明细分页查询API)
//      ALIEXPRESS_ASCP_FFO_ITEM_QUERY("aliexpress.ascp.ffo.item.query"),

//      // aliexpress.ascp.ffo.query (AliExpress发货单查询API)
//      ALIEXPRESS_ASCP_FFO_QUERY("aliexpress.ascp.ffo.query"),

//4.揽收可约日历接口
      // aliexpress.ascp.pickup.queryPickupAvailableDate(可揽收日期查询)
      ALIEXPRESS_ASCP_PICKUP_QUERY_PICKUP_AVAILABLE_DATE("aliexpress.ascp.pickup.queryPickupAvailableDate");

//5.创建揽收单接口 (有3种发货方式)-待装箱
//      // aliexpress.ascp.po.createPickupOrder(创建揽收单)
//      ALIEXPRESS_ASCP_PO_CREATE_PICKUP_ORDER("aliexpress.ascp.po.createPickupOrder"),

//      // aliexpress.ascp.po.cancelPickupOrder(取消揽收单)
//      ALIEXPRESS_ASCP_PO_CANCEL_PICKUP_ORDER("aliexpress.ascp.po.cancelPickupOrder"),


//7.打印
//      // aliexpress.ascp.po.createScItemBarcodePdf(打印货品标签)
//      ALIEXPRESS_ASCP_PO_CREATESC_ITEM_BARCODE_PDF("aliexpress.ascp.po.createScItemBarcodePdf"),

//      // aliexpress.ascp.po.query.createShippingMarkPdf(打印箱唛)
//      ALIEXPRESS_ASCP_PO_QUERY_CREATE_SHIPPING_MARK_PDF("aliexpress.ascp.po.query.createShippingMarkPdf"),

//      // aliexpress.ascp.po.createPickupShippingMarkPdf(打印揽收面单)
//      ALIEXPRESS_ASCP_PO_CREATE_PICKUP_SHIPPING_MARK_PDF("aliexpress.ascp.po.createPickupShippingMarkPdf"),

//      // aliexpress.ascp.po.printSelfDeliveryMarkPdf(打印自送面单)
//      ALIEXPRESS_ASCP_PO_PRINT_SELFDelivery_MARK_PDF("aliexpress.ascp.po.printSelfDeliveryMarkPdf");

    private final String apiName;

    AliexpressScpEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
