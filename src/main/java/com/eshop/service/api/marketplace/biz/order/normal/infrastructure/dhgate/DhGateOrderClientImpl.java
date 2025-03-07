package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.dhgate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.service.api.marketplace.order.call.dhgate.DhOrderCallService;
import com.eshop.api.modules.util.shop.PlatformAppClientUtils;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.api.marketplace.order.dto.DhOrderDetailReqDTO;
import com.eshop.modal.entry.api.marketplace.order.dto.DhOrderListReqDTO;
import com.eshop.modal.entry.api.marketplace.order.dto.DhOrderProductListReqDTO;
import com.eshop.modal.entry.api.marketplace.order.dto.DhOrderShipmentTrackingReqDTO;
import com.eshop.modal.entry.api.marketplace.order.vo.DhOrderDetailRespVO;
import com.eshop.modal.entry.api.marketplace.order.vo.DhOrderListRespVO;
import com.eshop.modal.entry.api.marketplace.order.vo.DhOrderProductListRespVO;
import com.eshop.modal.entry.api.marketplace.order.vo.DhOrderShipmentTrackingRespVO;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.DateUtil;
import com.eshop.util.JsonUtil;
import com.eshop.util.UuidUtis;
import com.eshop.util.WaybillUtils;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import com.eshop.util.platform.utils.order.DhgateOrderUtils;
import com.eshop.util.platform.utils.status.DhgateStatusUtils;
import com.google.common.base.Joiner;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2024/3/18 14:16
 * @Description: ...
 * @Version 1.0
 */
@StrategyKey(ConstantPlatform.DH)
@Service
public class DhGateOrderClientImpl implements DhGateOrderClient {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private DhOrderCallService dhOrderCallService;

    @Resource
    private DhgateOrderUtils dhgateOrderUtils;

    @Resource
    private DhgateStatusUtils dhgateStatusUtils;

    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize) throws Exception {
        TbShop shopDO = dto.getShop();

        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
        DhOrderListReqDTO reqDTO = orderListPageDTO(orderSyncDTO, pageNo, pageSize);
        DhOrderListRespVO respVO = dhOrderCallService.getOrderList(dcDTO, reqDTO);
        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        Integer count = jsonObject.getInteger("count");
        if (count == null || count == 0) {
            count = 1;
        }
        return new PageUtil(pageSize, count);
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = dto.getShop();
        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
        DhOrderListReqDTO reqDTO = orderListPageDTO(orderSyncDTO, pageNo, pageSize);
        DhOrderListRespVO respVO = dhOrderCallService.getOrderList(dcDTO, reqDTO);
        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        JSONArray orderBaseInfoList = jsonObject.getJSONArray("orderBaseInfoList");
        if (orderBaseInfoList == null || orderBaseInfoList.size() == 0) {
            return null;
        }
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrders(jsonObject);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = psDto.getShop();
        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
        DhOrderListReqDTO reqDTO = orderListPageDTO(osDto, pageNo, pageSize);
        DhOrderListRespVO respVO = dhOrderCallService.getOrderList(dcDTO, reqDTO);
        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        //返回数据解析装配
        JSONArray orderBaseInfoList = jsonObject.getJSONArray("orderBaseInfoList");
        if (orderBaseInfoList == null || orderBaseInfoList.size() == 0) {
            return null;
        }
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrders(jsonObject);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);

        return result;
    }


    @Override
    public TbOrderInfo getAddOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbShop shop = psDto.getShop();
        TbPlatform platform = psDto.getPlatform();
        String operator = psDto.getCreator();
        TbOrder order = po.getInfo();

        TbOrderInfo orderInfo = new TbOrderInfo();
        //主表
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(po.getJsonObj(), order.getOrderNo()));
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(order, platform, operator, "1"));
        //HTTP 获取订单详情 详情包含 费用明细 运单物流方式 运单地址
        getOrderDetailJsonList(order, shop, orderInfo);
        //税号
        assembleOrderBuyerInfos(orderInfo.getOrderBuyer(), order);
        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(order));
        //运单表
        orderInfo.setWaybills(dhgateOrderUtils.getWaybills(order));
        //运单地址表
        //买家信息装配 买家信息补充
        orderInfo.setWaybillSite(getWaybillSite(order));
        dhgateOrderUtils.assembleWaybillSiteToOrderBuyerInfo(orderInfo.getWaybillSite(), orderInfo.getOrderBuyer());
        //订单轨迹
        orderInfo.setWaybillTracks(getOrderTrackInfoList(orderInfo.getWaybills(), shop, orderInfo));
        //运单是否妥投
        isDelivered(orderInfo.getWaybills(), orderInfo.getWaybillTracks());
        //HTTP 订单商品信息
        List<TbOrderProducts> orderProductsList = getOrderProductsList(order, shop, orderInfo);

        if (CollectionUtils.isEmpty(orderProductsList)) {
            throw new RuntimeException("订单商品同步异常！");
        }
        //合并相同 shop_sku
        orderProductsList = mergeByShopSku(orderProductsList);

        orderInfo.setOrderProducts(orderProductsList);

        Integer dhgateOrderStatus = order.getPlatformOrderStatus();
        //erp 状态处理转化
        Integer platformOrderStatus = dhgateStatusUtils.getPlatformOrderStatus(dhgateOrderStatus);
        String abnormalCause = dhgateStatusUtils.getAbnormalCause(dhgateOrderStatus);
        List<Long> orderTypeMiddles = dhgateStatusUtils.getOrderTypeMiddles(dhgateOrderStatus, orderInfo, true);

        order.setPlatformOrderStatus(platformOrderStatus);
        orderInfo.setAbnormalCause(abnormalCause);
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);

        return orderInfo;
    }

    @Override
    public TbOrderInfo getUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        //平台相关信息
        TbPlatform tbPlatform = psDto.getPlatform();
        //操作人
        String operator = psDto.getCreator();
        //店铺
        TbShop shop = psDto.getShop();

        TbOrder order = po.getInfo();

        TbOrderInfo orderInfo = new TbOrderInfo();
        //主表
        orderInfo.setOrder(order);
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(order, tbPlatform, operator, "2"));
        //HTTP 获取订单详情 详情包含 费用明细 运单物流方式 运单地址
        getOrderDetailJsonList(order, shop, orderInfo);
        //运单表
        List<TbWaybill> waybills = dhgateOrderUtils.getWaybills(order);
        orderInfo.setWaybills(waybills);
        //订单轨迹
        List<TbWaybillTrack> orderTrackInfos = getOrderTrackInfoList(waybills, shop, orderInfo);
        orderInfo.setWaybillTracks(orderTrackInfos);
        //运单是否妥投
        isDelivered(waybills, orderTrackInfos);
        Integer dhgateOrderStatus = order.getPlatformOrderStatus();
        //erp 状态处理转化
        Integer platformOrderStatus = dhgateStatusUtils.getPlatformOrderStatus(dhgateOrderStatus);
        String abnormalCause = dhgateStatusUtils.getAbnormalCause(dhgateOrderStatus);
        List<Long> orderTypeMiddles = dhgateStatusUtils.getOrderTypeMiddles(dhgateOrderStatus, orderInfo, true);

        order.setPlatformOrderStatus(platformOrderStatus);
        orderInfo.setAbnormalCause(abnormalCause);
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        return null;
    }

    @Override
    public TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo) throws Exception {
        return null;
    }

    /**
     * 订单列表 初始化访问参数
     *
     * @param posDto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public JSONObject orderListPageDto(OrderSyncDTO posDto, Integer pageNo, Integer pageSize) {

        String startTimeStr = DateUtil.format(posDto.getStartDate());
        String endTimeStr = DateUtil.format(posDto.getEndDate());
        String queryTimeType = posDto.getTimeType().toString();

        JSONObject params = new JSONObject();
        //按哪种时间类型查询订单列表，值：1、下单时间 ,2、付款时间,3、更新时间 仅支持此三种时间类型查询
        params.put("querytimeType", queryTimeType);
        params.put("startDate", startTimeStr);
        params.put("endDate", endTimeStr);
        params.put("pageSize", pageSize);
        params.put("pageNo", pageNo);

        return params;
    }

    public DhOrderListReqDTO orderListPageDTO(OrderSyncDTO posDto, Integer pageNo, Integer pageSize) {

        String startTimeStr = DateUtil.format(posDto.getStartDate());
        String endTimeStr = DateUtil.format(posDto.getEndDate());
        String queryTimeType = posDto.getTimeType().toString();

        DhOrderListReqDTO reqDTO = new DhOrderListReqDTO();
        //按哪种时间类型查询订单列表，值：1、下单时间 ,2、付款时间,3、更新时间 仅支持此三种时间类型查询
//        params.put("querytimeType", queryTimeType);
        reqDTO.setQuerytimeType(queryTimeType);
//        params.put("startDate", startTimeStr);
        reqDTO.setStartDate(startTimeStr);
//        params.put("endDate", endTimeStr);
        reqDTO.setEndDate(endTimeStr);
//        params.put("pageSize", pageSize);
        reqDTO.setPageSize(pageSize);
//        params.put("pageNo", pageNo);
        reqDTO.setPageNo(pageNo);
        return reqDTO;
    }

    /**
     * 获取订单list
     *
     * @param obj
     * @return
     */
    private List<PlatformSyncInfoResponseVO<TbOrder>> getOrders(JSONObject obj) {
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        JSONObject jsonKeyObject = getTransformJson();
        JSONObject jsonObj = JsonUtil.changeJsonObj(obj, jsonKeyObject);
        List<TbOrder> tbOrders = Optional.ofNullable(jsonObj.getJSONArray("orderBaseInfoList"))
                .map(arr -> {
                    List<TbOrder> temp = JSONObject.parseArray(arr.toJSONString(), TbOrder.class);
                    for (int i = 0; i < temp.size(); i++) {
                        TbOrder order = temp.get(i);
                        JSONObject jsonObject = arr.getJSONObject(i);
                        PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
                        response.setInfo(order);
                        response.setJsonObj(jsonObject);
                        orderList.add(response);

                        //客户信息设置
                        TbOrderBuyerInfo orderBuyerInfo = getOrderBuyerInfo(jsonObject, order.getOrderNo());
                        temp.get(i).setBuyerInfo(orderBuyerInfo);
                    }
                    return temp;
                })
                .orElse(null);
        return orderList;
    }
    //_____________________转换规则_____________________//
    //_____________________转换规则_____________________//
    //_____________________转换规则_____________________//

    /**
     * 键值转换规则--订单基础信息
     *
     * @return
     */
    public JSONObject getTransformJson() {
        JSONObject jsonKeyObject = new JSONObject();
        JSONObject next = new JSONObject();
        //交易号
        next.put("orderId", "transactionNo");
        //下单时间
        next.put("startedDate", "orderTime");
        //发货时间
        next.put("deliveryDate", "deliverTime");
        //交货截止时间
        next.put("deliveryDeadline", "deliveryDeadlineTime");
        //订单状态 --> 平台订单状态
        next.put("orderStatus", "platformOrderStatus");
        //付款时间
        next.put("payDate", "paymentTime");
        jsonKeyObject.put("_next", next);
        return jsonKeyObject;
    }

    /**
     * 键值转换规则--订单商品基础信息
     *
     * @return
     */
    public JSONObject getTransformJsonByOrderProduct() {
        JSONObject jsonKeyObject = new JSONObject();
        JSONObject next = new JSONObject();
        //产品编号
        next.put("itemcode", "productId");
        //产品编号
        next.put("skuId", "platformSkuId");
        //商品编码Id -> 商品id
        //next.put("skuId","productId");
        //sku编码
        //next.put("skuCode","shopSku");
        next.put("skuCode", "shopSku");
        //产品名称-英文
        next.put("itemName", "productEnName");
        //属性
        next.put("itemAttr", "property");
        //包装重量 包装总重量
        next.put("grossWeight", "basisWeight");
        //产品数量
        next.put("itemCount", "number");
        //单价
        next.put("itemPrice", "unitPrice");

        //图片地址
        next.put("itemImage", "goodsImgeUrl");
        //买家留言
        next.put("buyerRemark", "buyerRemark");
        //
        jsonKeyObject.put("_next", next);
        return jsonKeyObject;
    }

    /**
     * 键值转换规则--收货人基础信息
     *
     * @return
     */
    public JSONObject getTransformJsonByOrderContact() {
        JSONObject jsonKeyObject = new JSONObject();
        //收货人firstName
        jsonKeyObject.put("firstName", "firstName");
        //收货人lastName
        jsonKeyObject.put("lastName", "lastName");
        //收货人国家
        jsonKeyObject.put("country", "country");
        //省(发货信息)
        jsonKeyObject.put("state", "provinceOrState");
        //城市(发货信息)
        jsonKeyObject.put("city", "city");
        //地址1 发货信息 -> 详细地址
        jsonKeyObject.put("addressLine1", "detailedAddress");
        //地址2 发货信息 -> 备用地址
        jsonKeyObject.put("addressLine2", "reserveAddress");
        //邮编(发货信息)
        jsonKeyObject.put("postalcode", "postcode");
        //电话(发货信息)
        jsonKeyObject.put("telephone", "mobile");
        //platform_remark
        jsonKeyObject.put("orderRemark", "platformRemark");
        return jsonKeyObject;
    }

    /**
     * 键值转换规则--订单商品基础信息
     *
     * @return
     */
    public JSONObject getTransformJsonByOrderTrackInfo() {
        JSONObject jsonKeyObject = new JSONObject();
        JSONObject next = new JSONObject();
        //运单号
        next.put("trackno", "waybillNo");
        //物流方式
        next.put("shippingtype", "shippingType");
        //语言
        next.put("language", "language");
        //发生时间
        next.put("occurDate", "occurDate");
        //发生事件
        next.put("info", "info");
        //发生地点
        next.put("place", "place");
        //
        jsonKeyObject.put("_next", next);
        return jsonKeyObject;
    }

    /**
     * 获取买家信息
     *
     * @param jsonObject
     * @return
     */
    public TbOrderBuyerInfo getOrderBuyerInfo(JSONObject jsonObject, String orderNo) {
        JSONObject obj = jsonObject;
        TbOrderBuyerInfo vo = new TbOrderBuyerInfo();
        String buyerId = obj.getString("buyerId");
        if (StringUtils.isNotBlank(buyerId)) {
            buyerId = buyerId.trim();
        }
        vo.setBuyerId(buyerId);
        String buyerNickName = obj.getString("buyerNickName");
        if (StringUtils.isNotBlank(buyerNickName)) {
            buyerNickName = buyerNickName.trim();
        }
        vo.setBuyerName(buyerNickName);
        vo.setOrderNo(orderNo);
        return vo;
    }

    /**
     * 获取订单同步 运行日志
     *
     * @param order
     * @param tbPlatform
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

    /**
     * 获取订单详情
     * 遍历orderList信息 补充缺少的信息
     */
    private void getOrderDetailJsonList(TbOrder bean, TbShop shopDO, TbOrderInfo orderInfo) throws Exception {
        //设置交易号
        bean.setTransactionNo(bean.getOrderNo());
        //设置平台留言
        bean.setPlatformMessage(bean.getPlatformRemark());

        String orderNo = bean.getOrderNo();
        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
        DhOrderDetailReqDTO reqDTO = new DhOrderDetailReqDTO();
        reqDTO.setOrderNo(orderNo);
        DhOrderDetailRespVO respVO = dhOrderCallService.getOrderDetail(dcDTO, reqDTO);
        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        //订单号
        String orderNoPost = jsonObject.getString("orderNo");
        if (!orderNo.equals(orderNoPost)) {
            throw new RuntimeException("获取订单详情异常：" + jsonObject.toString());
        }
        bean.setOrderDetail(jsonObject);
        if (jsonObject != null) {
            orderInfo.setOrderDetailRespJson(jsonObject.toJSONString());
        }

    }

    private void assembleOrderBuyerInfos(TbOrderBuyerInfo orderBuyer, TbOrder order) {
        String vatNumber = order.getOrderDetail().getJSONObject("orderContact").getString("vatNumber");
        String abn = order.getOrderDetail().getJSONObject("orderContact").getString("abn");

        if (StringUtils.isNotBlank(vatNumber)) {
            orderBuyer.setDutyParagraph(vatNumber);
            return;
        }
        if (StringUtils.isNotBlank(abn)) {
            orderBuyer.setDutyParagraph(abn);
            return;
        }
    }

    /**
     * 获取订单费用明细
     *
     * @param order
     */
    private TbOrderCostDetail getOrderCostDetail(TbOrder order) {
        TbOrderCostDetail orderCostDetail = dhgateOrderUtils.getOrderCostDetail(order.getOrderDetail());
        if (!order.getOrderNo().equals(orderCostDetail.getOrderNo())) {
            throw new RuntimeException("订单费用明细获取异常！");
        }
        return orderCostDetail;
    }

    /**
     * 获取订单 物流的地址
     *
     * @param order
     */
    private TbWaybillSite getWaybillSite(TbOrder order) {
        TbWaybillSite tbWaybillSite = null;
        JSONObject jsonObject = order.getOrderDetail();
        JSONObject orderContact = jsonObject.getJSONObject("orderContact");
        tbWaybillSite = Optional.ofNullable(orderContact).map(
                object -> {
                    JSONObject jsonKeyObject = getTransformJsonByOrderContact();
                    JSONObject jsonObj = JsonUtil.changeJsonObj(orderContact, jsonKeyObject);
                    String houseNumber = jsonObj.getString("houseNumber");
                    TbWaybillSite tbWaybillSites = JSONObject.parseObject(jsonObj.toJSONString(), TbWaybillSite.class);
                    String firstName = tbWaybillSites.getFirstName();
                    String lastName = tbWaybillSites.getLastName();
                    if (StringUtils.isBlank(firstName)) {
                        firstName = "";
                    }
                    if (StringUtils.isBlank(lastName)) {
                        lastName = "";
                    }
//                    tbWaybillSites.setCompanyName(firstName + " " + lastName);
                    tbWaybillSites.setConsigneeDoorNo(houseNumber);
                    return tbWaybillSites;
                }
        ).orElse(null);

        if (tbWaybillSite != null) {
            //设置地址状态(0:原收件地址.1:指定地址)
            tbWaybillSite.setSiteStatus(0);
        }
        return tbWaybillSite;
    }

    /**
     * 获取订单的商品信息
     */
    private List<TbOrderProducts> getOrderProductsList(TbOrder order, TbShop shopDO, TbOrderInfo orderInfo) throws Exception {
        String orderNo = order.getOrderNo();

        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
        DhOrderProductListReqDTO reqDTO = new DhOrderProductListReqDTO();
        reqDTO.setOrderNo(orderNo);
        DhOrderProductListRespVO respVO = dhOrderCallService.getOrderProductList(dcDTO, reqDTO);
        JSONObject resultJson = FastJsonUtil.parseJson(respVO.getRespBody());

        List<TbOrderProducts> result = new ArrayList<>();


        List<TbOrderProducts> tmp = null;
        JSONObject obj = resultJson;
        JSONObject jsonKeyObject = getTransformJsonByOrderProduct();
        JSONObject jsonObj = JsonUtil.changeJsonObj(obj, jsonKeyObject);

        JSONArray array = Optional.ofNullable(jsonObj.getJSONArray("orderProductList")).orElse(null);
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String itemImage = jsonObject.getString("itemImage");
            }
            tmp = JSONObject.parseArray(array.toJSONString(), TbOrderProducts.class);
        }
        if (CollectionUtils.isNotEmpty(tmp)) {
            //设置订单号和商品类型
            tmp.forEach(tempObj -> {
                tempObj.setOrderNo(orderNo);
                tempObj.setProductType(1);
                if (StringUtils.isBlank(tempObj.getShopSku())) {
                    tempObj.setShopSku("");
                }
            });
            result.addAll(tmp);
        }
        if (array != null) {
            orderInfo.setOrderProductRespJson(array.toJSONString());
        }


        //买家下单留言
        JSONObject jsonObject = order.getOrderDetail();
        String buyerRemark = jsonObject.getString("buyerRemark");
        if (StringUtils.isNotBlank(buyerRemark)) {
            order.setPlatformMessage(buyerRemark);
        }
        //买家留言处理
        List<String> buyerRemarks = result.stream().map(TbOrderProducts::getBuyerRemark).filter(Objects::nonNull).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(buyerRemarks)) {
            String platformMessage = order.getPlatformMessage();
            platformMessage = StringUtils.isBlank(platformMessage) ? "" : platformMessage;
            String remarks = Joiner.on(";").join(buyerRemarks);
            order.setPlatformMessage(platformMessage + remarks);
        }
        return result;
    }

    /**
     * 获取订单轨迹
     */
    private List<TbWaybillTrack> getOrderTrackInfoList(List<TbWaybill> waybills, TbShop shopDO, TbOrderInfo orderInfo) throws Exception {
        List<TbWaybillTrack> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(waybills)) {
            for (TbWaybill waybill : waybills) {
                String orderNo = waybill.getOrderNo();
                String shippingType = waybill.getShippingType();
                String waybillNo = waybill.getWaybillNo();
                if (StringUtils.isBlank(shippingType)) {
                    return null;
                }
                if (StringUtils.isBlank(waybillNo)) {
                    return null;
                }
                DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
                DhOrderShipmentTrackingReqDTO reqDTO = getTrackInfosDTO(waybill, shopDO);
                DhOrderShipmentTrackingRespVO respVO = dhOrderCallService.getOrderShipmentTracking(dcDTO, reqDTO);
                JSONObject resultJson = FastJsonUtil.parseJson(respVO.getRespBody());

                List<TbWaybillTrack> tmp = null;
                JSONObject obj = resultJson;
                JSONObject jsonKeyObject = getTransformJsonByOrderTrackInfo();
                JSONObject jsonObj = JsonUtil.changeJsonObj(obj, jsonKeyObject);

                JSONArray array = Optional.ofNullable(jsonObj.getJSONArray("frtTrackInfoList")).orElse(null);
                if (array != null && array.size() > 0) {
                    tmp = JSONObject.parseArray(array.toJSONString(), TbWaybillTrack.class);
                }
                if (CollectionUtils.isNotEmpty(tmp)) {
                    //设置订单号和商品类型
                    tmp.forEach(tempObj -> {
                        tempObj.setOrderNo(orderNo);
                    });
                    result.addAll(tmp);
                }
                if (array != null) {
                    orderInfo.setLogisticTrackRespJson(array.toJSONString());
                }
            }
        }


        return result;
    }

    /**
     * 判断产品是否妥投
     *
     * @param waybills
     * @param orderTrackInfos
     */
    private void isDelivered(List<TbWaybill> waybills, List<TbWaybillTrack> orderTrackInfos) {
        if (CollectionUtils.isEmpty(waybills)) {
            return;
        }
        if (CollectionUtils.isEmpty(orderTrackInfos)) {
            return;
        }
        Map<String, List<TbWaybillTrack>> orderTrackInfosMap = orderTrackInfos.stream().collect(Collectors.groupingBy(TbWaybillTrack::getWaybillNo));
        for (TbWaybill waybill : waybills) {
            List<TbWaybillTrack> tbWaybillTracks = orderTrackInfosMap.get(waybill.getWaybillNo());
            if (CollectionUtils.isEmpty(tbWaybillTracks)) {
                continue;
            }
            //info信息不为空 并且包含delivered单词  则已经妥投
            boolean isDelivered = tbWaybillTracks.stream().anyMatch(p -> WaybillUtils.isDelivered(p.getInfo()));
            if (isDelivered) {
                waybill.setIsDelivered(1);
            } else {
                waybill.setIsDelivered(2);
            }
        }
    }

    /**
     * 合并相同 shop_sku
     *
     * @param orderProductsList
     * @return
     */
    private List<TbOrderProducts> mergeByShopSku(List<TbOrderProducts> orderProductsList) {
        Map<String, TbOrderProducts> map = new HashMap<>();
        for (TbOrderProducts orderProduct : orderProductsList) {
            String shopSku = orderProduct.getShopSku();
            if (StringUtils.isNotBlank(shopSku)) {
                //去除前后空格
                shopSku = shopSku.trim();
                TbOrderProducts existingProduct = map.get(shopSku);
                if (existingProduct != null) {
                    int totalNumber = existingProduct.getNumber() + orderProduct.getNumber();
                    existingProduct.setNumber(totalNumber);
                } else {
                    map.put(shopSku, orderProduct);
                }
            } else {
                shopSku = "null" + UuidUtis.getUUID();
                TbOrderProducts existingProduct = map.get(shopSku);
                if (existingProduct != null) {
                    int totalNumber = existingProduct.getNumber() + orderProduct.getNumber();
                    existingProduct.setNumber(totalNumber);
                } else {
                    map.put(shopSku, orderProduct);
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    public DhOrderShipmentTrackingReqDTO getTrackInfosDTO(TbWaybill waybill, TbShop shop) {
        DhOrderShipmentTrackingReqDTO reqDTO = new DhOrderShipmentTrackingReqDTO();
//        //运单号
//        params.put("trackno", waybill.getWaybillNo());
        reqDTO.setTrackno(waybill.getWaybillNo());
//        //语言
//        params.put("language", ("EN"));
        reqDTO.setLanguage("EN");
//        //物流方式，
//        params.put("shippingtype", waybill.getShippingType());
        reqDTO.setShippingtype(waybill.getShippingType());
        return reqDTO;
    }
}
