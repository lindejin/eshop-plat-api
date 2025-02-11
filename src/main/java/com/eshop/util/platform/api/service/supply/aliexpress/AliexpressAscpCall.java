package com.eshop.util.platform.api.service.supply.aliexpress;

import com.eshop.util.platform.api.service.supply.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author xxs
 * @date 2024/9/06
 * @Description: 速卖通全托管接口对接
 * @Version 1.0
 */
public interface AliexpressAscpCall {

    /**
     * "Query 3pl warehouse address info"
     */
    String warehouseAddressGet(AeAppClientDTO acDTO, AeWarehouseAddressGetDTO reqDTO) throws ApiException;

    /**
     * 描述："create or update item"
     */
    String warehouseItemCreatePost(AeAppClientDTO acDTO, AeWarehouseItemCreatePostDTO reqDTO) throws ApiException;

    /**
     * 描述："Cancel warehouse return order"
     */
    String warehouseReturnFoCancelPost(AeAppClientDTO acDTO, AeWarehouseReturnFoCancelPostDTO reqDTO) throws ApiException;

    /**
     * 描述："warehouse return order async post"
     */
    String warehouseReturnFoCreatePost(AeAppClientDTO acDTO, AeWarehouseReturnFoCreatePostDTO reqDTO) throws ApiException;

    /**
     * 描述："Cancel Reverse Warehouse Order"
     */
    String warehouseReverseFoCancelPost(AeAppClientDTO acDTO, AeWarehouseReverseFoCancelPostDTO reqDTO) throws ApiException;

    /**
     * "Reverse warehouse order async post"
     */
    String warehouseReverseFoCreatePost(AeAppClientDTO acDTO, AeWarehouseReverseFoCreatePostDTO reqDTO) throws ApiException;

    /**
     * 描述："query warehouse info"
     */
    String qimenWarehouseBaseInfoGet(AeAppClientDTO acDTO, AeQimenWarehouseBaseInfoGetDTO reqDTO) throws ApiException;

    /**
     * 描述："Calculate the shipping fee"
     */
    String qimenWarehouseCalculateFeeGet(AeAppClientDTO acDTO, AeQimenWarehouseCalculateFeeGetDTO reqDTO) throws ApiException;

    /**
     * 描述："qimen.aliexpress.warehouse.fo.cancel.post"
     */
    String qimenWarehouseFoCancelPost(AeAppClientDTO acDTO, AeQimenWarehouseFoCancelPostDTO reqDTO) throws ApiException;

    /**
     * 描述："qimen.aliexpress.warehouse.fo.detail.get"
     */
    String qimenWarehouseFoDetailGet(AeAppClientDTO acDTO, AeQimenWarehouseFoDetailGetDTO reqDTO) throws ApiException;

    /**
     * 描述："qimen.aliexpress.warehouse.fo.intercept.post"
     */
    String qimenWarehouseFoInterceptPost(AeAppClientDTO acDTO, AeQimenWarehouseFoInterceptPostDTO reqDTO) throws ApiException;

    /**
     * 描述："qimen.aliexpress.warehouse.fo.modify.post"
     */
    String qimenWarehouseFoModifyPost(AeAppClientDTO acDTO, AeQimenWarehouseFoModifyPostDTO reqDTO) throws ApiException;

    /**
     * 描述："query warehosue inventory"
     */
    String qimenWarehouseInventoryGet(AeAppClientDTO acDTO, AeQimenWarehouseInventoryGetDTO reqDTO) throws ApiException;

    /**
     * 描述："query logistics"
     */
    String qimenWarehouseLogisticsGet(AeAppClientDTO acDTO, AeQimenWarehouseLogisticsGetDTO reqDTO) throws ApiException;

    /**
     * 描述："none"
     */
    String qimenWarehouseOwnerIdCheckGet(AeAppClientDTO acDTO, AeQimenWarehouseOwnerIdCheckGetDTO reqDTO) throws ApiException;

    /**
     * 描述："query warehouse sales"
     */
    String qimenWarehouseSalesGet(AeAppClientDTO acDTO, AeQimenWarehouseSalesGetDTO reqDTO) throws ApiException;

    /**
     * 描述："add sku bindlist"
     */
    String qimenWarehouseSkuBindListPost(AeAppClientDTO acDTO, AeQimenWarehouseSkuBindListPostDTO reqDTO) throws ApiException;

    /**
     * 描述："query sku detail info"
     */
    String qimenWarehouseSkuListInfoGet(AeAppClientDTO acDTO, AeQimenWarehouseSkuListInfoGetDTO reqDTO) throws ApiException;

    /**
     * 描述："query goods owner relationship"
     */
    String qimenWarehouseSubscribeGet(AeAppClientDTO acDTO, AeQimenWarehouseSubscribeGetDTO reqDTO) throws ApiException;


    /**
     * 描述：AliExpress入库单创建API
     */
    String ascpPoCreate(AeAppClientDTO acDTO, AeAscpPoCreateDTO reqDTO) throws ApiException;

    /**
     * 描述：AliExpress入库单取消API
     */

    String ascpPoCancel(AeAppClientDTO acDTO, AeAscpPoCancelDTO reqDTO) throws ApiException;

    /**
     * 描述：AE履约发货单明细分页查询
     */
    String ascpFfoItemQuery(AeAppClientDTO acDTO, AeAscpFfoItemQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AE 履约发货单分页查询接口
     */
    String ascpFfoQuery(AeAppClientDTO acDTO, AeAscpFfoQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：商品绑定货品
     */
    String ascpItemBind(AeAppClientDTO acDTO, AeAscpItemBindDTO reqDTO) throws ApiException;

    /**
     * 描述：商品解绑货品
     */
    String ascpItemUnBind(AeAppClientDTO acDTO, AeAscpItemUnBindDTO reqDTO) throws ApiException;

    /**
     * 描述：AliExpress在仓库存查询查询API
     */
    String ascpWarehouseInventoryQuery(AeAppClientDTO acDTO, AeAscpWarehouseInventoryQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AliExpress在途库存查询API
     */
    String ascpOnwayInventoryQuery(AeAppClientDTO acDTO, AeAscpOnwayInventoryQueryDTO reqDTO) throws ApiException;


    /**
     * 描述：AliExpress库存流水查询API
     */
    String ascpInventoryLogQuery(AeAppClientDTO acDTO, AeAscpInventoryLogQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AliExpress货品创建API
     */
    String ascpScitemCreate(AeAppClientDTO acDTO, AeAscpScitemCreateDTO reqDTO) throws ApiException;

    /**
     * 描述：AE货品查询API
     */
    String ascpItemQuery(AeAppClientDTO acDTO, AeAscpItemQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AliExpress货品编辑API
     */
    String ascpScitemUpdate(AeAppClientDTO acDTO, AeAscpScitemUpdateDTO reqDTO) throws ApiException;

    /**
     * 描述：AE 供应链仓发 采购单明细查询
     */
    String ascpPoItemQuery(AeAppClientDTO acDTO, AeAscpPoItemQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AE仓发业务采购单查询
     */
    String ascpPoQuery(AeAppClientDTO acDTO, AeAscpPoQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AE履约销退单明细查询API
     */
    String ascpFroItemQuery(AeAppClientDTO acDTO, AeAscpFroItemQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AE履约销退单查询接口
     */
    String ascpFroQuery(AeAppClientDTO acDTO, AeAscpFroQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AE仓发 单个退供单明细查询
     */
    String ascpRoItemQuery(AeAppClientDTO acDTO, AeAscpRoItemQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：AE仓发商家单个退供单查询接口
     */
    String ascpRoQuery(AeAppClientDTO acDTO, AeAscpRoQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：create or deactivate owner to isv
     */
    String warehouseOwnerCreatePost(AeAppClientDTO acDTO, AeWarehouseOwnerCreatePostDTO reqDTO) throws ApiException;

    /**
     * 描述："create fulfillment order async"
     */
    String qimenWarehouseFoCreateAsyncPost(AeAppClientDTO acDTO, AeQimenWarehouseFoCreateAsyncPostDTO reqDTO) throws ApiException;

    /**
     * 描述：test reverse api
     */
    String qimenWarehouseTestPost(AeAppClientDTO acDTO, AeQimenWarehouseTestPostDTO reqDTO) throws ApiException;

    /**
     * 描述：修改自寄（送）单信息
     */
    String ascpPoUpdateSelfdelivery(AeAppClientDTO acDTO, AeAscpPoUpdateSelfdeliveryDTO reqDTO) throws ApiException;

    /**
     * 描述：创建揽收单
     */
    String ascpPoCreatePickupOrder(AeAppClientDTO acDTO, AeAscpPoCreatePickupOrderDTO reqDTO) throws ApiException;

    /**
     * 描述：取消揽收单
     */
    String ascpPoCancelPickupOrder(AeAppClientDTO acDTO, AeAscpPoCancelPickupOrderDTO reqDTO) throws ApiException;

    /**
     * 描述：取消自送单
     */
    String ascpPoCancelSelfDelivery(AeAppClientDTO acDTO, AeAscpPoCancelSelfDeliveryDTO reqDTO) throws ApiException;

    /**
     * 描述：库存变更获取
     */
    String ecowarehouseInventoryChangeGet(AeAppClientDTO acDTO, AeEcowarehouseInventoryChangeGetDTO reqDTO) throws ApiException;

    /**
     * 描述：库存售罄 & 恢复 & 预警同步
     */
    String ecowarehouseInventoryNotifyGet(AeAppClientDTO acDTO, AeEcowarehouseInventoryNotifyGetDTO reqDTO) throws ApiException;

    /**
     * 描述：打印揽收面单
     */
    String ascpPoCreatePickupShippingMarkPdf(AeAppClientDTO acDTO, AeAscpPoCreatePickupShippingMarkPdfDTO reqDTO) throws ApiException;

    /**
     * 描述：打印箱唛
     */
    String ascpPoQueryCreateShippingMarkPdf(AeAppClientDTO acDTO, AeAscpPoQueryCreateShippingMarkPdfDTO reqDTO) throws ApiException;

    /**
     * 描述：打印自送面单
     */
    String ascpPoPrintSelfDeliveryMarkPdf(AeAppClientDTO acDTO, AeAscpPoPrintSelfDeliveryMarkPdfDTO reqDTO) throws ApiException;

    /**
     * 描述：打印货品标签
     */
    String ascpPoCreateScItemBarcodePdf(AeAppClientDTO acDTO, AeAscpPoCreateScItemBarcodePdfDTO reqDTO) throws ApiException;

    /**
     * 描述：批量填写自行发货信息生成自送面单
     */
    String ascpPoSelfDelivery(AeAppClientDTO acDTO, AeAscpPoSelfDeliveryDTO reqDTO) throws ApiException;

    /**
     * 描述：揽收单预估费用
     */
    String aidcPickupCostEstimate(AeAppClientDTO acDTO, AeAidcPickupCostEstimateDTO reqDTO) throws ApiException;

    /**
     * 描述：查看自寄（送）单
     */
    String ascpPoQuerysSelfdelivery(AeAppClientDTO acDTO, AeAscpPoQuerysSelfdeliveryDTO reqDTO) throws ApiException;


    /**
     * 描述：查询揽收单
     */
    String ascpPoQueryPickupOrder(AeAppClientDTO acDTO, AeAscpPoQueryPickupOrderDTO reqDTO) throws ApiException;

    /**
     * 描述：生态仓对账上传csv文件
     */
    String ecowarehouseReverseOrderUpload(AeAppClientDTO acDTO, AeEcowarehouseReverseOrderUploadDTO reqDTO) throws ApiException;

    /**
     * 描述：生态仓物流订单状态通知
     */
    String ecowarehouseOrderStatusPost(AeAppClientDTO acDTO, AeEcowarehouseOrderStatusPostDTO reqDTO) throws ApiException;

    /**
     * 生态仓逆向物流订单状态通知 描述：Reverse order status call back
     */
    String ecowarehouseReverseOrderStatusPost(AeAppClientDTO acDTO, AeEcowarehouseReverseOrderStatusPostDTO reqDTO) throws ApiException;

    /**
     * 描述：货品详情查询
     */
    String ascpItemDetail(AeAppClientDTO acDTO, AeAscpItemDetailDTO reqDTO) throws ApiException;

    /**
     * 逆向单据费用回传 描述：Reverse order fee callback
     */
    String ecowarehouseReverseOrderFeePost(AeAppClientDTO acDTO, AeEcowarehouseReverseOrderFeePostDTO reqDTO) throws ApiException;

    /**
     * 描述：采购单分页查询
     */
    String ascpPoPageQuery(AeAppClientDTO acDTO, AeAscpPoPageQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：采购单确认
     */
    String ascpPoConfirmPurchaseOrder(AeAppClientDTO acDTO, AeAscpPoConfirmPurchaseOrderDTO reqDTO) throws ApiException;


    /**
     * 仓发接口
     * 1.备货单查询
     * ALIEXPRESS_ASCP_PO_ERP_PAGE_QUERY (AE仓发备货单-分页查询单据)
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpPoErpPageQuery(AeAppClientDTO acDTO, AeAscpPoErpPageQueryDTO reqDto) throws ApiException;



    /**
     * ALIEXPRESS_ASCP_PO_ERP_PAGE_QUERY_ITEM（AE仓发备货单-分页查询货品）
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpPoErpPageQueryItem(AeAppClientDTO acDTO, AeAscpPoErpPageQueryItemDTO reqDto) throws ApiException;


    /**
     * 2.确认接单
     * ALIEXPRESS_ASCP_PO_ERP_CONFIRM  （AE仓发备货单-确认接单）
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpPoErpConfirm(AeAppClientDTO acDTO, AeAscpPoErpConfirmDTO reqDto) throws ApiException;


    /**
     * 3.创建发货单
     * ALIEXPRESS_ASCP_CO_ERP_CREATE (AE仓发发货单-创建发货单)
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpCoErpCreate(AeAppClientDTO acDTO, AeAscpCoErpCreateDTO reqDto) throws ApiException;


    /**
     * ALIEXPRESS_ASCP_CO_ERP_CANCEL（AE仓发发货单-取消发货单）
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpCoErpCancel(AeAppClientDTO acDTO, AeAscpPoErpCancelDTO reqDto) throws ApiException;


    /**
     * ALIEXPRESS_ASCP_CO_ERP_PAGE_QUERY（AE仓发发货单-分页查询单据）
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpCoErpPageQuery(AeAppClientDTO acDTO, AeAscpCoErpPageQueryDTO reqDto) throws ApiException;


    /**
     * ALIEXPRESS_ASCP_CO_ERP_PAGE_QUERY_ITEM（AE仓发发货单-分页查询货品）
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpCoErpPageQueryItem(AeAppClientDTO acDTO, AeAscpCoErpPageQueryItemDTO reqDto) throws ApiException;


    /**
     * 4.揽收可约日历接口
     * ALIEXPRESS_ASCP_PICKUP_QUERY_PICKUP_AVAILABLE_DATE(可揽收日期查询)
     * @param acDTO
     * @param reqDto
     * @return
     */
    String ascpPickupQueryPickupAvailableDate(AeAppClientDTO acDTO, AeAscpQueryPickupAvailableDateDTO reqDto) throws ApiException;
}
