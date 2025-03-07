package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.temu;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.service.api.marketplace.order.call.temu.TemuOrderPoCallService;
import com.eshop.api.modules.service.api.marketplace.order.call.temu.dto.TemuOrderPoDetailReqDTO;
import com.eshop.api.modules.service.api.marketplace.order.call.temu.dto.TemuOrderPoListReqDTO;
import com.eshop.api.modules.service.api.marketplace.order.call.temu.dto.TemuOrderPoOrderShippingInfoReqDTO;
import com.eshop.api.modules.service.api.marketplace.order.call.temu.vo.*;
import com.eshop.api.modules.util.shop.PlatformAppClientUtils;
import com.eshop.db.logistics.service.LogModeService;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_logistics.TbLogisticsMode;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import com.eshop.util.platform.utils.order.TemuOrderPoOrderUtils;
import com.eshop.util.platform.utils.order.TemuRegionEnum;
import com.eshop.util.platform.utils.status.TemuOrderPoStatusUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@StrategyKey(ConstantPlatform.TEMU)
@Slf4j
@Service
public class TemuPoOrderClientImpl implements TemuPoOrderClient {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private TemuOrderPoCallService temuOrderPoCallService;

    @Resource
    private OrderWaybillUtils orderWaybillUtils;

    @Resource
    private TemuOrderPoStatusUtils temuOrderPoStatusUtils;

    @Resource
    private TemuOrderPoOrderUtils temuOrderPoOrderUtils;

    @Autowired
    private LogModeService logModeService;

    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize) throws Exception {
        TbShop shopDO = dto.getShop();
        TemuOrderPoListRespVO respVO = getOrderList(shopDO, dto.getShopLocation(), orderSyncDTO, pageNo, pageSize);
        if (respVO != null && respVO.getResult() != null && respVO.getResult().getResult() != null) {
            TemuOrderPoListResultBaseVO resultBaseVO = respVO.getResult();
            TemuOrderPoListResultResultVO resultResultVO = resultBaseVO.getResult();
            Integer count = resultResultVO.getTotalItemNum();
            if (count == null || count == 0) {
                count = 1;
            }
            return new PageUtil(pageSize, count);
        } else {
            Integer count = 1;
            return new PageUtil(pageSize, count);
        }

    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = dto.getShop();
        TemuOrderPoListRespVO respVO = getOrderList(shopDO, dto.getShopLocation(), orderSyncDTO, pageNo, pageSize);
        String respBody = respVO.getRespBody();
        List<TemuOrderPoListPageItemVO> pageItems = null;
        if (respVO != null && respVO.getResult() != null && respVO.getResult().getResult() != null) {
            TemuOrderPoListResultBaseVO resultBaseVO = respVO.getResult();
            TemuOrderPoListResultResultVO resultResultVO = resultBaseVO.getResult();
            pageItems = resultResultVO.getPageItems();
        }
        JSONObject jsonObject = FastJsonUtil.parseJson(respBody);
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrderVOList(pageItems);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDTO, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDTO) throws Exception {
        TbShop shopDO = psDTO.getShop();
        TemuOrderPoListRespVO respVO = getOrderList(shopDO, psDTO.getShopLocation(), osDTO, pageNo, pageSize);
        String respBody = respVO.getRespBody();
        List<TemuOrderPoListPageItemVO> pageItems = null;
        if (respVO != null && respVO.getResult() != null && respVO.getResult().getResult() != null) {
            TemuOrderPoListResultBaseVO resultBaseVO = respVO.getResult();
            TemuOrderPoListResultResultVO resultResultVO = resultBaseVO.getResult();
            pageItems = resultResultVO.getPageItems();
        }
        JSONObject jsonObject = FastJsonUtil.parseJson(respBody);
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrderVOList(pageItems);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = psDto.getShop();
        TemuOrderPoListRespVO respVO = getOrderList(shopDO, psDto.getShopLocation(), osDto, pageNo, pageSize);
        String respBody = respVO.getRespBody();
        List<TemuOrderPoListPageItemVO> pageItems = null;
        if (respVO != null && respVO.getResult() != null && respVO.getResult().getResult() != null) {
            TemuOrderPoListResultBaseVO resultBaseVO = respVO.getResult();
            TemuOrderPoListResultResultVO resultResultVO = resultBaseVO.getResult();
            pageItems = resultResultVO.getPageItems();
        }
        JSONObject jsonObject = FastJsonUtil.parseJson(respBody);
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrderVOList(pageItems);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);
        return result;
    }

    private TemuOrderPoListRespVO getOrderList(TbShop shopDO, String shopLocation, OrderSyncDTO posDto, Integer pageNo, Integer pageSize) throws Exception {
        TemuAppClientDTO scDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);
        TemuOrderPoListReqDTO reqDTO = getOrderListDTO(posDto, pageNo, pageSize);
        TemuOrderPoListRespVO respVO = temuOrderPoCallService.getOrderList(scDTO, reqDTO);
        return respVO;
    }

    private TemuOrderPoListReqDTO getOrderListDTO(OrderSyncDTO posDto, Integer pageNo, Integer pageSize) {
        List<String> fulfillmentTypeList = new ArrayList<>();
        fulfillmentTypeList.add("fulfillBySeller");
        fulfillmentTypeList.add("fulfillByCooperativeWarehouse");

        TemuOrderPoListReqDTO reqDTO = new TemuOrderPoListReqDTO();
        reqDTO.setPageSize(pageSize);
        reqDTO.setPageNumber(pageNo);

        Integer timeType = getTimeType(posDto);
        //add
        if (timeType.intValue() == 1 || timeType.intValue() == 2) {
            //父单创建时间开始查询时间，格式是秒时间戳
            reqDTO.setCreateAfter(posDto.getStartDate().getTime() / 1000);
            //父单创建时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
            reqDTO.setCreateBefore(posDto.getEndDate().getTime() / 1000);
        }
        //update
        if (timeType.intValue() == 3) {
            //订单更新时间开始查询时间，格式是秒时间戳
            reqDTO.setUpdateAtStart(posDto.getStartDate().getTime() / 1000);
            //订单更新时间结束查询时间，格式是秒时间戳。
            reqDTO.setUpdateAtEnd(posDto.getEndDate().getTime() / 1000);
        }
//        reqDTO.setFulfillmentTypeList(fulfillmentTypeList);
        return reqDTO;
    }

    private TemuOrderPoDetailRespVO getOrderDetail(TbShop shopDO, String shopLocation, String orderNo) throws Exception {
        TemuAppClientDTO scDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);
        TemuOrderPoDetailReqDTO reqDTO = getOrderDetailDTO(orderNo);
        TemuOrderPoDetailRespVO respVO = temuOrderPoCallService.getOrderDetail(scDTO, reqDTO);
//        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        return respVO;
    }

    private TemuOrderPoDetailReqDTO getOrderDetailDTO(String orderNo) {
        List<String> fulfillmentTypeList = new ArrayList<>();
        fulfillmentTypeList.add("fulfillBySeller");
        fulfillmentTypeList.add("fulfillByCooperativeWarehouse");

        TemuOrderPoDetailReqDTO reqDTO = new TemuOrderPoDetailReqDTO();
        reqDTO.setParentOrderSn(orderNo);
        reqDTO.setFulfillmentTypeList(fulfillmentTypeList);
        return reqDTO;
    }

    private List<PlatformSyncInfoResponseVO<TbOrder>> getOrderVOList(List<TemuOrderPoListPageItemVO> pageItems) throws Exception {
        if(CollectionUtils.isEmpty(pageItems)){
            return Collections.emptyList();
        }
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();

        for (TemuOrderPoListPageItemVO pageItem : pageItems) {
            // 将 Java 对象转换为 JSON 对象
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(pageItem);

            TemuOrderPoListParentOrderMapVO parentOrderMap = pageItem.getParentOrderMap();
            String orderSn = parentOrderMap.getParentOrderSn();
            TbOrder order = new TbOrder();
            order.setOrderNo(orderSn);

            PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
            response.setInfo(order);
            response.setJsonObj(jsonObject);
            orderList.add(response);
        }
        return orderList;
    }

    /**
     * 获取订单同步 运行日志
     */
    public TbOrderLog getOrderOperateLog(TbOrder order, TbPlatform tbPlatform, String operator, String type) {
        String operateProperty = "";
        String description = "";
        String logType = "";
        if ("1".equals(type)) {
            logType = "导入订单";
            description = "平台导入信息";
        }
        if ("2".equals(type)) {
            logType = "更新订单";
            description = "平台更新信息";
        }
        TbOrderLog vo = new TbOrderLog();
        vo.setOrderNo(order.getOrderNo());
        if ("sys".equals(operator)) {
            operateProperty = "系统" + logType;
        } else {
            operateProperty = "手动" + logType;
        }
        vo.setOperateProperty(operateProperty);
        vo.setDescription(tbPlatform.getPlatformName() + description);
        vo.setOperator(operator);
        vo.setOperateTime(new Date());

        return vo;
    }

    private List<TbWaybillTrack> getOrderTrackInfoList() {
        List<TbWaybillTrack> waybillTracks = new ArrayList<>();
        return waybillTracks;
    }

    private TemuOrderPoDetailResultResultVO getResultResultVO(TemuOrderPoDetailRespVO respVO) {
        if (respVO == null) {
            return null;
        }
        TemuOrderPoDetailResultBaseVO result = respVO.getResult();
        if (result == null) {
            return null;
        }
        TemuOrderPoDetailResultResultVO resultResultVO = result.getResult();
        return resultResultVO;

    }

    private TbOrderCostDetail getOrderCostDetail(String orderNo) {
        return temuOrderPoOrderUtils.getOrderCostDetail(orderNo);
    }

    /**
     *
     */
    private TbOrder handleTemuOrderDetail(TbOrder orderOld, TemuOrderPoDetailParentOrderMapVO parentOrderMap, String respBody, String shopLocation) {
        //拷贝orderOld
        TbOrder order = new TbOrder();
        BeanUtils.copyProperties(orderOld, order);
        //订单号
        String orderNo = parentOrderMap.getParentOrderSn();
        // TODO 订单状态
        String orderStatus = "";

        //父单下单时间
        Long parentOrderTime = parentOrderMap.getParentOrderTime();
        // 处理父单下单时间
        if (parentOrderTime != null) {
            parentOrderTime = convertToMillis(parentOrderTime);
        } else {
            throw new IllegalArgumentException("Parent order time is null");
        }

        // 处理最晚发货时间
        Long expectShipLatestTime = parentOrderMap.getExpectShipLatestTime();
        if (expectShipLatestTime != null) {
            expectShipLatestTime = convertToMillis(expectShipLatestTime);
        } else {
            throw new IllegalArgumentException("(最晚发货时间L)Expect ship latest time is null");
        }

        String tradeOrderId = orderNo;
        Integer parentOrderStatus = parentOrderMap.getParentOrderStatus();
        //订单创建时间
        if (ObjectUtil.isNotEmpty(parentOrderTime)) {
            order.setOrderTime(cn.hutool.core.date.DateUtil.date(parentOrderTime));
        }
        //当前状态超时日期
        if (ObjectUtil.isNotEmpty(expectShipLatestTime)) {
            order.setDeliveryDeadlineTime(cn.hutool.core.date.DateUtil.date(expectShipLatestTime));
        }
        //如果付款时间不存在  使用订单创建时间作为付款时间
        if (order.getPaymentTime() == null) {
            order.setPaymentTime(cn.hutool.core.date.DateUtil.date(parentOrderTime));
        }
        // 交易主单号
        if (ObjectUtil.isNotEmpty(tradeOrderId)) {
            order.setTransactionNo(tradeOrderId);
        }


        order.setOrderDetail(FastJsonUtil.parseJson(respBody));
        order.setOrderNo(orderNo);
        order.setPlatformOrderStatus(parentOrderStatus);
        order.setOrderType(1);
        //设置平台订单类型
        order.setPlatformOrderType("TemuSemi-" + shopLocation);
        return order;
    }

    private List<TbWaybill> getWaybills(String orderNo, List<TemuOrderPoDetailOrderListVO> orderList) {
        String whcOrderNo = null;
        //收货地址信息
        Long logisticsModeId = null;
        List<TbWaybill> waybills = new ArrayList<>();
        for (TemuOrderPoDetailOrderListVO orderPalVO : orderList) {
            String orderSn = orderPalVO.getOrderSn();

            TbWaybill tbWaybill = orderWaybillUtils.generateNewWaybill();
            if (ObjectUtil.isNotEmpty(whcOrderNo)) {
                tbWaybill.setWaybillNo(whcOrderNo);
            }
            tbWaybill.setOrderNo(orderNo);
            //买家自选物流
            tbWaybill.setBuyerOptionalLogistics("买家自选物流-无");
            //默认设置为0 正式插入时获取
            tbWaybill.setParcelNo(BigInteger.ZERO);
            //平台 物流服务提供商
            tbWaybill.setCheckoutShippingCarrier("物流服务提供商-无");

            tbWaybill.setLogisticsModeId(getLogisticsModeId("temu_01"));
            //运单第三方_id
            tbWaybill.setWaybillExternalId(orderSn);
            waybills.add(tbWaybill);
        }

        return waybills;
    }

    private TbWaybillSite getWaybillSite(TbShop shopDO, String shopLocation, String orderNo) {
        //地址的收件人姓名。
        //string
        String name = "";
        //电话。
        String phone = "";
        //手机号
        String mobileNo = "";
        //地址1
        String address = "";
        //地址2
        String address2 = "";
        //地址3
        String address3 = "";
        //城市
        String city = null;
        //省份
        String state = null;
        //国家/地区
        String country = null;
        //邮编
        String zipcode = null;

        try {
            TemuOrderPoOrderShippingInfoRespVO respVO = getShippingInfoRespVO(shopDO, shopLocation, orderNo);

            if (respVO == null || respVO.getResult() == null || respVO.getResult().getResult() == null) {
                log.error("订单收货地址查询异常!");
            }
            TemuOrderPoOrderShippingInfoResultResultVO resultResultVO = respVO.getResult().getResult();

            name = resultResultVO.getReceiptName();
            //城市
            city = resultResultVO.getRegionName3();
            //省份
            state = resultResultVO.getRegionName2();
            //国家/地区
            country = resultResultVO.getRegionName1();
            //邮编
            zipcode = resultResultVO.getPostCode();
            //收货人手机号
            mobileNo = resultResultVO.getMobile();
            address = resultResultVO.getAddressLine1();
            address2 = resultResultVO.getAddressLine2();
            address3 = resultResultVO.getAddressLine3();

        } catch (Exception exception) {
            log.error("订单收货地址查询异常!");
        }

        TbWaybillSite waybillSite = new TbWaybillSite();
        if (StringUtils.isNotBlank(name)) {
            waybillSite.setFirstName(name);
        }
        if (StringUtils.isNotBlank(phone)) {
            waybillSite.setPhone(phone);
        }
        if (StringUtils.isNotBlank(mobileNo)) {
            waybillSite.setMobile(mobileNo);
        }
        if (StringUtils.isNotBlank(zipcode)) {
            waybillSite.setPostcode(zipcode);
        }
        if (StringUtils.isNotBlank(country)) {
            waybillSite.setCountry(country);
        }
        if (StringUtils.isNotBlank(state)) {
            waybillSite.setProvinceOrState(state);
        }

        if (StringUtils.isNotBlank(city)) {
            waybillSite.setCity(city);
        }

        if (StringUtils.isNotBlank(address)) {
            waybillSite.setDetailedAddress(address);
        }
        if (StringUtils.isNotBlank(address2)) {
            waybillSite.setReserveAddress(address2);
        }

        waybillSite.setLastName(name);
        waybillSite.setFirstName(name);
        waybillSite.setSiteStatus(0);
        return waybillSite;
    }

    private TemuOrderPoOrderShippingInfoRespVO getShippingInfoRespVO(TbShop shopDO, String shopLocation, String orderNo) throws Exception {
        TemuAppClientDTO scDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);
        TemuOrderPoOrderShippingInfoReqDTO reqDTO = new TemuOrderPoOrderShippingInfoReqDTO();
        reqDTO.setParentOrderSn(orderNo);
        TemuOrderPoOrderShippingInfoRespVO respVO = temuOrderPoCallService.getOrderShippingInfo(scDTO, reqDTO);
        return respVO;
    }

    private TbOrderBuyerInfo getOrderBuyerInfo(String orderNo, TemuOrderPoDetailParentOrderMapVO parentOrderMap, List<TemuOrderPoDetailOrderListVO> orderList) {
        //区域ID (用来找国家)
        Long regionId = parentOrderMap.getRegionId();
        String temuRegionEnNameById = TemuRegionEnum.getTemuRegionEnNameById(regionId);

        TemuOrderPoDetailOrderListVO baseVO = null;
        if (CollectionUtils.isNotEmpty(orderList)) {
            baseVO = orderList.get(0);
        }
        String inventoryDeductionWarehouseName = baseVO.getInventoryDeductionWarehouseName();
        String inventoryDeductionWarehouseId = baseVO.getInventoryDeductionWarehouseId();

        TbOrderBuyerInfo orderBuyer = new TbOrderBuyerInfo();
        //buyer_user_id 此订单买家的用户ID  交易主单号先作为买家id
        String tradeOrderId = null;
        if (StringUtils.isNotBlank(tradeOrderId)) {
            tradeOrderId = tradeOrderId.trim();
        }
        orderBuyer.setEmail(tradeOrderId);
        // 国际物流单号作为  卖家手机号
        orderBuyer.setContactPhone("");
        // 仓库code 作为买家id
        orderBuyer.setBuyerId(inventoryDeductionWarehouseId);
        //buyer_username 买家姓名        仓库名称作为买家姓名
        String buyerNickName = inventoryDeductionWarehouseName;
        if (StringUtils.isNotBlank(buyerNickName)) {
            buyerNickName = buyerNickName.trim();
        }
        orderBuyer.setBuyerName(buyerNickName);
        orderBuyer.setCountry(temuRegionEnNameById);

        orderBuyer.setOrderNo(orderNo);

        return orderBuyer;
    }

    private List<TbOrderProducts> getOrderProductsList(List<TemuOrderPoDetailOrderListVO> orderList, String orderNo, List<TbWaybill> waybills) {
        Map<String, TbWaybill> waybillMap = waybills.stream().collect(Collectors.toMap(TbWaybill::getWaybillExternalId, Function.identity(), (o1, o2) -> o1));
        List<TbOrderProducts> opList = new ArrayList<>();

        for (TemuOrderPoDetailOrderListVO poVO : orderList) {
            String thumbUrl = poVO.getThumbUrl();
            String spec = poVO.getSpec();
            String goodsName = poVO.getGoodsName();
            Long quantity = poVO.getQuantity();
            Long originalOrderQuantity = poVO.getOriginalOrderQuantity();

            //商品skuId
            Long skuId = poVO.getSkuId();
            //商品id
            Long goodsId = poVO.getGoodsId();

            String orderSn = poVO.getOrderSn();

            TbOrderProducts orderProducts = new TbOrderProducts();
            //订单编号
            orderProducts.setOrderNo(orderNo);
            // 货品id 就是商品标签里面的 一维码图下面小的
            orderProducts.setProductId(goodsId);
            orderProducts.setPlatformSkuId(skuId);
            orderProducts.setShopSku(spec);
            orderProducts.setProductEnName(goodsName);
//                orderProducts.setBasisWeight(weight);
            orderProducts.setNumber(quantity.intValue());
            //原价
            orderProducts.setUnitPrice(new BigDecimal(0));
            //成本价格
            orderProducts.setCostPrice(BigDecimal.ZERO);
            //商品类型
            orderProducts.setProductType(1);
            orderProducts.setProperty(spec);
            orderProducts.setGoodsImgeUrl(thumbUrl);
//            orderProducts.setPoLineId((Long) coVO.getPo_line_id());
            //运单第三方_id
            orderProducts.setWaybillExternalId(orderSn);
            opList.add(orderProducts);

            waybillMap.get(orderSn).setProducts(Arrays.asList(orderProducts));
        }

        return opList;
    }

    @Override
    public TbOrderInfo getAddOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbShop shop = psDto.getShop();
        TbPlatform platform = psDto.getPlatform();
        String operator = psDto.getCreator();
        TbOrder order = po.getInfo();

        //订单详情获取
        TemuOrderPoDetailRespVO respVO = getOrderDetail(shop, psDto.getShopLocation(), order.getOrderNo());
        String respBody = respVO.getRespBody();

        TemuOrderPoDetailResultResultVO resultResultVO = getResultResultVO(respVO);
        TemuOrderPoDetailParentOrderMapVO parentOrderMap = resultResultVO.getParentOrderMap();
        List<TemuOrderPoDetailOrderListVO> orderList = resultResultVO.getOrderList();
        String parentOrderSn = parentOrderMap.getParentOrderSn();

        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单表
        order = handleTemuOrderDetail(order, parentOrderMap, respBody, psDto.getShopLocation());
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(order.getOrderNo(), parentOrderMap, orderList));
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(order, platform, operator, "1"));
        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(parentOrderSn));
        //运单表
        List<TbWaybill> waybills = getWaybills(order.getOrderNo(), orderList);
        orderInfo.setWaybills(waybills);
        //运单地址表
        orderInfo.setWaybillSite(getWaybillSite(shop, psDto.getShopLocation(), order.getOrderNo()));
        //买家信息装配 买家信息补充
        if (StringUtils.isNotBlank(orderInfo.getOrderBuyer().getCountry())) {
            orderInfo.getOrderBuyer().setCountry(orderInfo.getOrderBuyer().getCountry().toUpperCase());
        }
        //订单轨迹
        orderInfo.setWaybillTracks(getOrderTrackInfoList());
        //订单商品信息
        List<TbOrderProducts> orderProductsList = getOrderProductsList(orderList, order.getOrderNo(), waybills);
        orderInfo.setOrderProducts(orderProductsList);

        JSONObject baseJson = FastJsonUtil.parseJson(respVO.getRespBody());
        //订单详情 respJson
        if (baseJson != null) {
            orderInfo.setOrderDetailRespJson(baseJson.toJSONString());
        }
        //订单产品 respJson
        JSONArray array = baseJson.getJSONArray("item_list");
        if (array != null) {
            orderInfo.setOrderProductRespJson(array.toJSONString());
        }
        //订单号
        String orderSn = baseJson.getString("order_sn");
        orderInfo.setOrderNo(orderSn);


        //erp 状态处理转化
        Integer platformOrderStatus = parentOrderMap.getParentOrderStatus();
        String platformOrderStatusStr = temuOrderPoStatusUtils.getPlatformOrderStatusStr(platformOrderStatus);
        String abnormalCause = temuOrderPoStatusUtils.getAbnormalCause(platformOrderStatus);
//        List<Long> orderTypeMiddles = temuOrderPoStatusUtils.getOrderTypeMiddles(platformOrderStatus, orderInfo, true);

        order.setPlatformOrderStatus(platformOrderStatus);
        orderInfo.setAbnormalCause(abnormalCause);
//        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //是否同步判断
        orderInfo.setIsSync(1);
        //不同步原因
        if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
            orderInfo.setSyncNotMsg("订单状态+" + platformOrderStatusStr);
        }

        return orderInfo;
    }

    @Override
    public TbOrderInfo getUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        return null;
    }

    @Override
    public TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo) throws Exception {
        return null;
    }

    // 方法：将时间戳统一转换为毫秒
    private static Long convertToMillis(Long timestamp) {
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }

        // 判断时间戳的长度
        if (String.valueOf(timestamp).length() == 10) {
            // 如果是秒，转换为毫秒
            return timestamp * 1000;
        } else if (String.valueOf(timestamp).length() == 13) {
            // 如果是毫秒，直接返回
            return timestamp;
        } else {
            // 如果时间戳长度不符合预期，抛出异常
            throw new IllegalArgumentException("Invalid timestamp length: " + timestamp);
        }
    }


    /**
     * 获取物流方式id
     */
    private Long getLogisticsModeId(String channelCode) {
        try {
            TbLogisticsMode logisticsMode = logModeService.selectOneByProperty(TbLogisticsMode::getChannelCode, channelCode);
            if (Objects.nonNull(logisticsMode)) {
                return logisticsMode.getId();
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("channelCode获取失败", e);
        }
    }

    private Integer getTimeType(OrderSyncDTO posDto) {
        Integer timeType = 1;
        if (posDto != null && posDto.getTimeType() != null) {
            timeType = posDto.getTimeType();
        }
        return timeType;
    }
}
