package com.eshop.util.platform.api.service.logistics.aliexpress;

import com.eshop.util.platform.api.service.logistics.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;


/**
 * @author ldj
 * @date 2024/3/6 16:53
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressLogisticsCall {
    //商家地址信息查询
    //描述：本对本支持查询商家地址信息

    String getLogisticsSellerAddresses(AeAppClientDTO acDTO, AeLogisticsSellerAddressesDTO reqDto) throws ApiException;


    //列出所有的商家可见解决方案
    //描述：本对本列出所有的商家可见解决方案


    String localListLogisticsService(AeAppClientDTO acDTO, AeLogisticsLocalListLogisticsServiceDTO reqDto) throws ApiException;


    //读取下一级别的地址信息
    //描述：读取下一级别的地址信息


    String getNextLevelAddressData(AeAppClientDTO acDTO, AeLogisticsNextLevelAddressDataDTO reqDto) throws ApiException;

    //面向海外物流ISV/合作伙伴获取速卖通订单发货信息的API
    //描述：面向海外物流ISV/合作伙伴获取速卖通订单发货信息的API


    String getOrderDeliveryInfo(AeAppClientDTO acDTO, AeLogisticsOrderDeliveryInfoDTO reqDto) throws ApiException;


    //修改声明发货
    //描述：修改声明发货


    String sellerModifiedShipmentForTop(AeAppClientDTO acDTO, AeLogisticsSellerModifiedShipmentForTopDTO reqDto) throws ApiException;

    //列出平台所支持的物流服务列表
    //描述：此接口返回的物流服务于线上发货物流服务不同。此接口返回的物流服务用语卖家设置运费模板和声明发货，不能用于线上发货。请注意！


    String getListLogisticsService(AeAppClientDTO acDTO, AeLogisticsGetListLogisticsServiceDTO reqDto) throws ApiException;


    //创建子交易单线上物流订单
    //描述：创建线上发货物流订单


    String createOrder(AeAppClientDTO acDTO, AeLogisticsCreateOrderDTO reqDto) throws ApiException;


    //创建线上物流订单
    //描述：创建线上发货物流订单

    String createWarehouseOrder(AeAppClientDTO acDTO, AeLogisticsCreateWarehouseOrderDTO reqDto) throws ApiException;

    //声明发货接口
    //描述：填写发货通知


    String sellerShipmentForTop(AeAppClientDTO acDTO, AeLogisticsSellerShipmentForTopDTO reqDto) throws ApiException;


    //子单修改声明发货
    //描述：支持对子订单进行修改声明发货的接口


    String modifyShipment(AeAppClientDTO acDTO, AeLogisticsModifyShipmentDTO reqDto) throws ApiException;


    //子单声明发货
    //描述：子单申明发货


    String declareShipment(AeAppClientDTO acDTO, AeLogisticsDeclareShipmentDTO reqDto) throws ApiException;


    //批量获取线上发货标签
    //描述：批量获取线上发货标签(线上物流发货专用接口)


    String getOnlineShipmentLabelList(AeAppClientDTO acDTO, AeLogisticsGetPrintInfosDTO reqDto) throws ApiException;


    //支持子订单声明发货接口
    //描述：支持子订单声明发货接口


    String sellerShipmentSupportSubTradeOrder(AeAppClientDTO acDTO, AeLogisticsSellerShipmentDTO reqDto) throws ApiException;


    //支持对子订单进行修改声明发货的接口
    //描述：支持对子订单进行修改声明发货的接口


    String sellerModifiedShipmentSupportSubTradeOrder(AeAppClientDTO acDTO, AeLogisticsSellerModifiedShipmentDTO reqDto) throws ApiException;


    //本对本创建线上物流订单
    //描述：本对本创建线上发货物流订单，目前只支持巴西本对本业务


    String localCreateWarehouseOrder(AeAppClientDTO acDTO, AeLogisticsLocalCreateWarehouseOrderDTO reqDto) throws ApiException;

    //查询仓发物流订单信息
    //描述：查询仓发物流订单信息


    String warehouseQueryDetail(AeAppClientDTO acDTO, AeLogisticsWarehouseQueryDetailDTO reqDto) throws ApiException;
    //查询声明发货信息
    //描述：查询声明发货信息


    String querySellerShipmentInfo(AeAppClientDTO acDTO, AeLogisticsQuerySellerShipmentInfoDTO reqDto) throws ApiException;

    //查询头程信息需要的枚举信息（国家，仓代码等）
    //描述：提供查询头程信息需要的枚举信息（国家，仓码等）


    String queryEnum(AeAppClientDTO acDTO, AeLogisticsQueryEnumDTO reqDto) throws ApiException;


    //查询物流订单信息（推荐）
    //描述：该接口可以根据查询条件查询对应的物流订单的基本信息。


    String queryLogisticsOrderDetail(AeAppClientDTO acDTO, AeLogisticsQueryLogisticsOrderDetailDTO reqDto) throws ApiException;

    //查询物流追踪信息
    //描述：查询物流追踪信息


    String queryTrackingResult(AeAppClientDTO acDTO, AeLogisticsQueryTrackingDTO reqDto) throws ApiException;


    //查询网规等物流信息
    //描述：查询网规等物流信息


    String queryRuleInfo(AeAppClientDTO acDTO, AeLogisticsQueryRuleInfoDTO reqDto) throws ApiException;

    //根据交易单查询可用物流方案
    //描述：根据交易单查询可用物流方案


    String queryLogisticsService(AeAppClientDTO acDTO, AeLogisticsQueryLogisticsServiceDTO reqDto) throws ApiException;


    //根据交易订单获取线上发货物流服务列表
    //描述："根据交易订单获取线上发货物流服务列表，线上发货物流服务仅能用于线上发货，请了解！ 以下包裹信息是不支持线上发货的，获取方案可能为空： 1、长\宽\高 加起来 不能大于90; 2、长宽高最大的一条边不能大于60cm; 3、包裹重量不能超过2KG; 4、已操作线下物流发货的订单。"


    String getOnlineLogisticsServiceListByOrderId(AeAppClientDTO acDTO, AeLogisticsGetOnlineLogisticsServiceListByOrderIdDTO reqDto) throws ApiException;

    //物流包裹货值保费估算接口
    //描述：商家对包裹货值进行投保，预估算包裹保费费率


    String estimateInsurance(AeAppClientDTO acDTO, AeLogisticsEstimateInsuranceDTO reqDto) throws ApiException;


    //获取中国省份信息列表
    //描述：获取中国省份信息列表


    String getAllProvince(AeAppClientDTO acDTO, AeLogisticsGetAllProvinceDTO reqDto) throws ApiException;


    //获取买家收货CPF信息
    //描述：获取买家收货CPF信息


    String getBuyerCPFInfo(AeAppClientDTO acDTO, AeLogisticsBuyerCPFInfoDTO reqDto) throws ApiException;


    //获取卖家地址
    //获取卖家地址


    String getSellerAddresses(AeAppClientDTO acDTO, AeLogisticsSellerAddressDTO reqDto) throws ApiException;

    //获取开展国内物流业务的物流公司
    //获取开展国内物流业务的物流公司


    String queryWlbDomesticLogisticsCompany(AeAppClientDTO acDTO, AeLogisticsQueryWlbDomesticLogisticsCompanyDTO reqDto) throws ApiException;

    //获取打印面单的字段
    //获取打印面单的字段


    String getFieldInfoForPrint(AeAppClientDTO acDTO, AeLogisticsGetFieldInfoForPrintDTO reqDto) throws ApiException;

    //获取物流公告信息
    //获取物流公告信息


    String getAnnouncement(AeAppClientDTO acDTO, AeLogisticsAnnouncementDTO reqDto) throws ApiException;


    //获取线上发货标签
    //获取线上发货标签


    String getOnlineShipmentLabel(AeAppClientDTO acDTO, AeLogisticsGetDeliveryLabelDTO reqDto) throws ApiException;


    //获取线上发货物流订单信息
    //描述：线上物流发货专用接口

    String getOnlineLogisticsInfo(AeAppClientDTO acDTO, AeLogisticsGetOnlineLogisticsInfoDTO reqDto) throws ApiException;

    //面单云打印
    //描述：使用云打印功能打印面单


    String getPrintCloudLabel(AeAppClientDTO acDTO, AeLogisticsCloudPrintDTO reqDto) throws ApiException;
}
