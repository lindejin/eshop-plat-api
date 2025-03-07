package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.tiktok;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.util.SpuCodeUtils;
import com.eshop.api.modules.util.TikTokApiUtil;
import com.eshop.api.modules.util.log.OrderLogGenerator;
import com.eshop.api.modules.util.tkapi.TikTokPackageUtil;
import com.eshop.api.modules.util.tkapi.order.TKOrderCancelApiUtil;
import com.eshop.api.modules.util.tkapi.order.TikTokOrderUtil;
import com.eshop.db.logistics.service.LogModeService;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.platform.config.PlatformOrder3plVO;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.entry.tiktok.dto.CommonPageDTO;
import com.eshop.modal.entry.tiktok.dto.TiktokAuthBaseInfoDTO;
import com.eshop.modal.entry.tiktok.dto.order.OrderListNewDTO;
import com.eshop.modal.entry.tiktok.dto.reverse.OrderCancelPageDTO;
import com.eshop.modal.entry.tiktok.vo.CommonPageVO;
import com.eshop.modal.entry.tiktok.vo.order.*;
import com.eshop.modal.entry.tiktok.vo.order.orderInfo.DistrictInfoVO;
import com.eshop.modal.entry.tiktok.vo.order.orderInfo.LineItemsVO;
import com.eshop.modal.entry.tiktok.vo.packages.PackageInfoVO;
import com.eshop.modal.entry.tiktok.vo.packages.PackageOrderVO;
import com.eshop.modal.entry.tiktok.vo.reverse.OrderCancelPageVO;
import com.eshop.modal.enumerate.tkplatform.TkOrderStatusEnum;
import com.eshop.modal.exception.OrderException;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_logistics.TbLogisticsMode;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.BigDecimalUtils;
import com.eshop.util.WaybillUtils;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.utils.status.TiktokStatusUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2024/3/18 14:19
 * @Description: ...
 * @Version 1.0
 */
@StrategyKey(ConstantPlatform.TIKTOK)
@Service
public class TikTokOrderClientImpl implements TikTokOrderClient {

    @Autowired
    private TiktokStatusUtils tiktokStatusUtils;
    @Autowired
    private OrderWaybillUtils orderWaybillUtils;
    //@Autowired
    //private ApiTikTokOrderService apiTikTokOrderService;
    @Autowired
    private LogModeService logModeService;
    @Autowired
    private TikTokApiUtil tikTokApiUtil;
    @Autowired
    private OrderLogGenerator orderLogGenerator;
    @Autowired
    private TKOrderCancelApiUtil tkOrderCancelApiUtil;
    @Autowired
    private TikTokOrderUtil tikTokOrderUtil;
    @Autowired
    private TikTokPackageUtil tikTokPackageUtil;


    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize) throws Exception {
        //游标的方式该方法不需要
        //TbShop shop = dto.getShop();
        //OrderPageNewVO orderPageVO = getOrderPageNewVO(dto, orderSyncDTO, pageSize, null);
        //if (Objects.nonNull(orderPageVO)) {
        //    Boolean more = orderPageVO.getMore();
        //    if (more == null) {
        //        logger.error("店铺:" + shop.getName() + "获取分页信息失败：");
        //        throw new OrderException("获取分页信息失败");
        //    }
        //} else {
        //    logger.error("店铺:" + shop.getName() + "获取分页信息失败");
        //    throw new OrderException("获取分页信息失败");
        //}
        return new PageUtil(pageSize, 1);
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        OrderPageVO orderPageVO = getOrderPageNewVO(dto, orderSyncDTO, pageSize, cursorDto);
        //结果转换Result
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        JSONArray ordersVos = orderPageVO.getOrders();
        if (CollectionUtils.isNotEmpty(ordersVos)) {
            int size = ordersVos.size();
            for (int i = 0; i < size; i++) {
                JSONObject orderObj = ordersVos.getJSONObject(i);
                orderObj.put("request_id", orderPageVO.getRequestId());
                TbOrder order = new TbOrder();
                order.setOrderNo(orderObj.getString("id"));
                PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
                response.setInfo(order);
                response.setJsonObj(orderObj);
                orderList.add(response);
            }
        }
        //返回结果
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setSyncList(orderList);
        //是否有下一页
        if (StringUtils.isNotBlank(orderPageVO.getNextPageToken())) {
            result.setMore(true);
        } else {
            result.setMore(false);
        }
        //下一页游标
        result.setNextCursor(orderPageVO.getNextPageToken());
        return result;
    }

    @Override
    public TbOrderInfo getAddOrderDetailSync(PlatformSyncDTO dto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbPlatform platform = dto.getPlatform();
        String operator = dto.getCreator();
        TbOrder order = po.getInfo();
        if (Objects.isNull(order)) {
            throw new OrderException("(Tiktok获取订单详情) 未获取到订单参数信息");
        }
        ;
        //授权信息
        TbShop shop = dto.getShop();
        TiktokAuthBaseInfoDTO authBaseInfoDTO = tikTokApiUtil.generateAuthBaseInfo(shop.getId());
        String logPrefix = "(Tiktok获取订单详情) ";
        JSONObject orderJSON = po.getJsonObj();
        if (Objects.isNull(orderJSON) || orderJSON.isEmpty()) {
            throw new OrderException(logPrefix + "未获取到订单信息");
        }

        OrderInfoVO orderInfoVO = orderJSON.toJavaObject(OrderInfoVO.class);
        orderInfoVO.setReturnJson(orderJSON);
        String status = orderInfoVO.getStatus();
        //过滤,没有付款信息的订单
        if (TkOrderStatusEnum.UNPAID.getStatus().equals(status)) {
            throw new OrderException("未付款订单不同步,当前订单状态" + TkOrderStatusEnum.UNPAID.getText());
        } else if (TkOrderStatusEnum.CANCELLED.getStatus().equals(status)
                && Objects.isNull(orderInfoVO.getPaidTime())) {
            throw new OrderException("未付款订单不同步,当前订单状态" + TkOrderStatusEnum.CANCELLED.getText());
        }
        //获取详细数据
        getOrder(order, orderInfoVO);
        //参数转换
        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单主信息
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(orderInfoVO));
        //订单日志
        orderInfo.setOrderLogs(orderLogGenerator.generateOrderLogInfo(order.getOrderNo(), platform.getPlatformName(),
                operator, "1", ""));
        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(orderInfoVO));
        //包裹信息,返回值全部存进数据库
        JSONArray waybillArray = new JSONArray();
        //运单表
        orderInfo.setWaybills(getWaybills(orderInfoVO, authBaseInfoDTO, waybillArray));
        //运单地址表
        orderInfo.setWaybillSite(getWaybillSite(orderInfoVO, shop.getCountryId()));
        //买家信息装配 买家信息补充
        orderInfo.getOrderBuyer().setCountry(orderInfo.getWaybillSite().getCountry());
        //订单轨迹
        orderInfo.setWaybillTracks(getOrderTrackInfoList(orderInfoVO));
        //运单是否妥投
        isDelivered(orderInfo.getWaybills(), orderInfo.getWaybillTracks());
        //HTTP 订单商品信息
        List<TbOrderProducts> orderProductsList = getOrderProductsList(orderInfo.getWaybills());
        orderInfo.setOrderProducts(orderProductsList);
        JSONObject returnResults = orderInfoVO.getReturnJson();
        returnResults.put("packageInfo", waybillArray);
        if (returnResults != null) {
            orderInfo.setOrderDetailRespJson(returnResults.toJSONString());
        }
        if (returnResults.getJSONArray("line_items") != null) {
            orderInfo.setOrderProductRespJson(returnResults.getJSONArray("line_items").toJSONString());
        }
        //订单号
        orderInfo.setOrderNo(orderInfoVO.getId());
        Integer platformOrderStatus = TkOrderStatusEnum.getCodeByStatus(orderInfoVO.getStatus());
        String abnormalCause = tiktokStatusUtils.getAbnormalCause(orderInfoVO.getCancellationInitiator(),
                orderInfoVO.getCancelReason());
        List<Long> orderTypeMiddles = tiktokStatusUtils.getOrderTypeMiddles(orderInfoVO);
        order.setPlatformOrderStatus(platformOrderStatus);
        // Tiktok 只有取消原因
        orderInfo.setAbnormalCause(abnormalCause);
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        orderInfo.setPlatformCode(platform.getPlatformCode());
        orderInfo.setAuthInfoDTO(JSONObject.parseObject(JSON.toJSONString(authBaseInfoDTO)));
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        OrderPageVO orderPageVO = getOrderPageNewVO(psDto, osDto, pageSize, cursorDto);
        //结果转换Result
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        JSONArray ordersVos = orderPageVO.getOrders();
        if (CollectionUtils.isNotEmpty(ordersVos)) {
            int size = ordersVos.size();
            for (int i = 0; i < size; i++) {
                JSONObject orderObj = ordersVos.getJSONObject(i);
                TbOrder order = new TbOrder();
                order.setOrderNo(orderObj.getString("id"));
                PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
                response.setInfo(order);
                response.setJsonObj(orderObj);
                orderList.add(response);
            }
        }
        //返回结果
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setSyncList(orderList);
        //是否有下一页
        if (StringUtils.isNotBlank(orderPageVO.getNextPageToken())) {
            result.setMore(true);
        }
        //下一页游标
        result.setNextCursor(orderPageVO.getNextPageToken());
        return result;
    }

    @Override
    public TbOrderInfo getUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbPlatform platform = psDto.getPlatform();
        String operator = psDto.getCreator();
        String logPrefix = "(Tiktok更新订单信息) ";
        TbOrder order = po.getInfo();
        if (Objects.isNull(order)) {
            throw new OrderException(logPrefix + "未获取到订单参数信息");
        }
        JSONObject orderJSON = po.getJsonObj();
        if (Objects.isNull(orderJSON) || orderJSON.isEmpty()) {
            throw new OrderException(logPrefix + "未获取到订单信息");
        }
        //获取详细数据
        OrderInfoVO returnOrderInfo = orderJSON.toJavaObject(OrderInfoVO.class);
        TbOrderInfo orderInfo = new TbOrderInfo();
        //主表
        getOrder(order, returnOrderInfo);
        orderInfo.setOrder(order);
        String orderStatusStr = returnOrderInfo.getStatus();
        //订单日志
        TbOrderLog tbOrderLog = orderLogGenerator.generateOrderLogInfo(order.getOrderNo(), platform.getPlatformName(),
                operator, "2", "");
        tbOrderLog.setDescription(TkOrderStatusEnum.getTextByStatus(orderStatusStr));
        orderInfo.setOrderLogs(tbOrderLog);
        //HTTP 获取订单详情 详情包含 费用明细 运单物流方式 运单地址
        //orderInfo.setWaybills(getWaybills(returnOrderInfo));
//        //运单地址表
//        orderInfo.setWaybillSite(getWaybillSite(returnOrderInfo));
        //订单轨迹
        //orderInfo.setWaybillTracks(getOrderTrackInfoList(returnOrderInfo));
//        //运单是否妥投
        isDelivered(orderInfo.getWaybills(), orderInfo.getWaybillTracks());

        if (orderJSON != null) {
            orderInfo.setOrderDetailRespJson(orderJSON.toJSONString());
        }        //订单号
        orderInfo.setOrderNo(returnOrderInfo.getId());

        //erp 状态处理转化

        List<Long> orderTypeMiddles = tiktokStatusUtils.getOrderTypeMiddles(returnOrderInfo);

        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //授权信息
        TiktokAuthBaseInfoDTO authBaseInfoDTO = tikTokApiUtil.generateAuthBaseInfo(psDto.getShop().getId());
        orderInfo.setAuthInfoDTO(JSONObject.parseObject(JSON.toJSONString(authBaseInfoDTO)));
        if (TkOrderStatusEnum.CANCELLED.getStatus().equals(orderStatusStr)) {
            String abnormalCause = "平台订单取消";
            String abnormalCause1 = tiktokStatusUtils.getAbnormalCause(returnOrderInfo.getCancellationInitiator(),
                    returnOrderInfo.getCancelReason());
            if (StringUtils.isNotBlank(abnormalCause1)) {
                abnormalCause += "," + abnormalCause1;
            }
            orderInfo.setAbnormalCause(abnormalCause);
        } else if (TkOrderStatusEnum.IN_TRANSIT.getStatus().equals(orderStatusStr)) {
            //121状态记录揽收时间
            PlatformOrder3plVO platformOrder3plVO = new PlatformOrder3plVO();
            platformOrder3plVO.setCollectionId(1L);
            if (Objects.nonNull(returnOrderInfo.getCollectionTime())) {
                platformOrder3plVO.setCollectionTime(new Date(returnOrderInfo.getCollectionTime() * 1000));
            } else {
                platformOrder3plVO.setCollectionTime(new Date());
            }
            orderInfo.setPlatform3pl(platformOrder3plVO);
        }
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(
            PlatformSyncDTO psDto,
            OrderSyncDTO osDto,
            Integer pageNo,
            Integer pageSize,
            PlatformPageCursorDto cursorDto) throws Exception {
        TbPlatform platform = psDto.getPlatform();
        //授权信息
        TiktokAuthBaseInfoDTO authBaseInfoDTO = tikTokApiUtil.generateAuthBaseInfo(psDto.getShop().getId());
        CommonPageDTO commonPageDTO = new CommonPageDTO();
        commonPageDTO.setSortField("create_time");
        commonPageDTO.setSortOrder("DESC");
        if (Objects.nonNull(pageSize) && pageSize > 0) {
            commonPageDTO.setPageSize(pageSize.toString());
        }
        if (Objects.nonNull(cursorDto) && StringUtils.isNotBlank(cursorDto.getNextCursor())) {
            commonPageDTO.setPageToken(cursorDto.getNextCursor());
        }
        OrderCancelPageDTO pageDTO = new OrderCancelPageDTO();
        pageDTO.setCreateTimeGe(osDto.getStartDate().getTime());
        pageDTO.setCreateTimeLt(osDto.getEndDate().getTime());
        //pageDTO.setCancelStatus(osDto.getEndDate().getTime());
        CommonPageVO<OrderCancelPageVO> cancellations = tkOrderCancelApiUtil.getCancellations(commonPageDTO, pageDTO, authBaseInfoDTO);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(cancellations.getJsonObj());
        List<OrderCancelPageVO> datas = cancellations.getDatas();
        if (CollectionUtils.isNotEmpty(datas)) {
            List<PlatformSyncInfoResponseVO<TbOrder>> orders = datas.stream().map(e -> {
                TbOrder order = new TbOrder();
                order.setOrderNo(e.getOrderId());
                PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
                response.setInfo(order);
                return response;
            }).collect(Collectors.toList());
            result.setSyncList(orders);
        }
        String nextPageToken = cancellations.getNextPageToken();
        if (StringUtils.isNotBlank(nextPageToken)) {
            result.setMore(true);
            result.setNextCursor(cancellations.getNextPageToken());
        } else {
            result.setMore(false);
        }
        return result;
    }

    @Override
    public TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo) throws Exception {
        //后面在改
        return null;
        //TbPlatform platform = psDto.getPlatform();
        ////授权信息
        //TiktokAuthBaseInfoDTO authBaseInfoDTO = tikTokApiUtil.generateAuthBaseInfo(platform.getParamStaticJson(), psDto.getShop());
        //CommonPageDTO commonPageDTO = new CommonPageDTO();
        //commonPageDTO.setSortOrder("DESC");
        //OrderCancelPageDTO pageDTO = new OrderCancelPageDTO();
        //pageDTO.setOrderIds(Arrays.asList(orderNo));
        //CommonPageVO<OrderCancelPageVO> cancellations = tkOrderCancelApiUtil.getCancellations(commonPageDTO, pageDTO, authBaseInfoDTO);
        //TbOrderInfo orderInfo = new TbOrderInfo();
        //List<OrderCancelPageVO> datas = cancellations.getDatas();
        //
        //if (CollectionUtils.isEmpty(datas)) {
        //    throw new RuntimeException("未获取到对应取消订单信息,订单号: " + orderNo);
        //}
        //OrderCancelPageVO orderCancelPageVO = datas.get(0);
        //orderCancelPageVO.getCancelReason();
        //orderInfo.setOrderNo(orderNo);
        //String abnormalCause = tiktokStatusUtils.getAbnormalCause(orderCancelPageVO.getRole(),
        //        orderCancelPageVO.getCancelReasonText());
        //if (StringUtils.isNotBlank(orderCancelPageVO.getCancelReason())) {
        //    abnormalCause += ";" + orderCancelPageVO.getCancelReason();
        //}
        //orderInfo.setAbnormalCause(abnormalCause);
        //orderInfo.setBuyerCancelReason(abnormalCause);
        //Long createTime = orderCancelPageVO.getCreateTime();
        //if (Objects.nonNull(createTime)) {
        //    orderInfo.setApplyCancelTime(new Date(createTime));
        //} else {
        //    orderInfo.setApplyCancelTime(new Date());
        //}
        //orderInfo.setIsSync(1);
        //return orderInfo;
    }

    /**
     * 订单列表查询 参数封装及调用
     *
     * @param dto
     * @param orderSyncDTO
     * @param pageSize
     * @param cursorDto
     * @return com.eshop.modal.entry.tikTok.vo.order.OrderPageVO
     * @author sheng
     * @date 2023-11-03 18:04
     */
    private OrderPageVO getOrderPageNewVO(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageSize,
                                          PlatformPageCursorDto cursorDto) {
        //判断是否有下一页数据
        if (Objects.nonNull(cursorDto) && !cursorDto.getMore()) {
            return null;
        }
        //订单查询参数信息
        if (orderSyncDTO.getStartDate() == null) {
            throw new OrderException("时间范围开始时间不能为空!");
        }
        if (orderSyncDTO.getEndDate() == null) {
            throw new OrderException("时间范围结束时间不能为空！");
        }
        long startDate = orderSyncDTO.getStartDate().getTime() / 1000;
        long endDate = orderSyncDTO.getEndDate().getTime() / 1000;

        //授权信息
        TiktokAuthBaseInfoDTO authBaseInfoDTO =
                tikTokApiUtil.generateAuthBaseInfo( dto.getShop().getId());
        OrderListNewDTO orderDTO = new OrderListNewDTO();
        orderDTO.setPageSize(pageSize);
        orderDTO.setSortOrder("DESC");
        orderDTO.setSortField("create_time");
        //1指代创建时间, 2.指代更新时间
        //String queryTimeType = orderSyncDTO.getTimeType().toString();
        //if (StringUtils.isNotBlank(queryTimeType) && ("1".equals(queryTimeType) || "2".equals(queryTimeType))) {
        //    //订单增量改为修改时间查询
        //    orderDTO.setCreateTimeGe(startDate);
        //    orderDTO.setCreateTimeLt(endDate);
        //
        //} else {
        //    orderDTO.setUpdateTimeGe(startDate);
        //    orderDTO.setUpdateTimeLt(endDate);
        //}
        orderDTO.setUpdateTimeGe(startDate);
        orderDTO.setUpdateTimeLt(endDate);
        //光标
        if (Objects.nonNull(cursorDto) && StringUtils.isNotBlank(cursorDto.getNextCursor())) {
            orderDTO.setPageToken(cursorDto.getNextCursor());
        }
        return tikTokOrderUtil.getOrderPages(orderDTO, authBaseInfoDTO);
    }

    /**
     * 订单商品转换
     *
     * @param waybills
     * @return java.util.List<com.eshop.modal.modal.eshop_order.TbOrderProducts>
     * @author sheng
     * @date 2023-11-03 18:07
     */
    private List<TbOrderProducts> getOrderProductsList(List<TbWaybill> waybills) {
        if (CollectionUtils.isEmpty(waybills)) {
            return Collections.emptyList();
        }
        return waybills.stream().filter(e -> CollectionUtils.isNotEmpty(e.getProducts())).map(TbWaybill::getProducts).flatMap(Collection::stream).collect(Collectors.toList());
    }

    /**
     * 运单轨迹
     *
     * @param returnOrderInfo
     * @return java.util.List<com.eshop.modal.modal.eshop_order.TbWaybillTrack>
     * @author sheng
     * @date 2023-11-03 18:07
     */
    private List<TbWaybillTrack> getOrderTrackInfoList(OrderInfoVO returnOrderInfo) {
        List<TbWaybillTrack> waybillTracks = new ArrayList<>();
        return waybillTracks;
    }

    /**
     * 运单地址
     *
     * @param vo        订单信息
     * @param countryId 店铺所属国家
     * @return com.eshop.modal.modal.eshop_order.TbWaybillSite
     * @author sheng
     * @date 2023-11-10 18:59
     */
    private TbWaybillSite getWaybillSite(OrderInfoVO vo, Long countryId) {
        RecipientAddressVO addressVO = vo.getRecipientAddress();

        TbWaybillSite waybillSite = new TbWaybillSite();
        waybillSite.setFirstName(addressVO.getName());
        waybillSite.setPhone(addressVO.getPhoneNumber());
        waybillSite.setMobile(addressVO.getPhoneNumber());
        waybillSite.setPostcode(addressVO.getPostalCode());
        waybillSite.setDetailedAddress(addressVO.getAddressDetail());
        String addressLine = addressVO.getAddressLine1();
        if (StringUtils.isNotBlank(addressLine)) {
            waybillSite.setReserveAddress(addressLine);
        }
        //地区信息
        setWaybillSiteCountry(waybillSite, addressVO.getDistrictInfo(), countryId);
        waybillSite.setSiteStatus(0);
        return waybillSite;
    }

    /**
     * 国家获取地址
     *
     * @param waybillSite
     * @param districtInfoList
     * @author sheng
     * @date 2023-11-10 17:59
     */
    private void setWaybillSiteCountry(TbWaybillSite waybillSite, List<DistrictInfoVO> districtInfoList, Long countryId) {
        if (CollectionUtils.isEmpty(districtInfoList)) {
            return;
        }
        Map<String, DistrictInfoVO> VOMap =
                districtInfoList.stream().collect(Collectors.toMap(DistrictInfoVO::getAddressLevel,
                        e -> e, (oldVal, newVal) -> newVal));
        waybillSite.setCountry(getAddressNameByLevel(VOMap, "L0"));
        switch (countryId + "") {
            //菲律宾
            case "134":
                String detailed = getAddressNameByLevel(VOMap, "L1");
                if (StringUtils.isNotBlank(detailed)) {
                    detailed += ", ";
                }
                String barangay = getAddressNameByLevel(VOMap, "L4");
                if (StringUtils.isNotBlank(barangay)) {
                    detailed += barangay + ", ";
                }
                waybillSite.setProvinceOrState(getAddressNameByLevel(VOMap, "L2"));
                waybillSite.setCity(getAddressNameByLevel(VOMap, "L3"));
                if (StringUtils.isNotBlank(detailed)) {
                    waybillSite.setDetailedAddress(detailed + waybillSite.getDetailedAddress());
                    String reserveAddress = waybillSite.getReserveAddress();
                    if (StringUtils.isNotBlank(reserveAddress)) {
                        waybillSite.setReserveAddress(detailed + reserveAddress);
                    }
                }
                break;
            //泰国
            case "169":
                waybillSite.setProvinceOrState(getAddressNameByLevel(VOMap, "L1"));
                waybillSite.setCity(getAddressNameByLevel(VOMap, "L2"));
                break;
            default:
                //匹配不上通过默认的获取
                waybillSite.setProvinceOrState(getAddressNameByLevel(VOMap, "L1"));
                waybillSite.setCity(getAddressNameByLevel(VOMap, "L2"));
        }
    }

    /**
     * 更具下标获取区域名称
     *
     * @param voMap 地区信息
     * @param level 下标
     * @return java.lang.String
     * @author sheng
     * @date 2023-11-15 15:50
     */
    private String getAddressNameByLevel(Map<String, DistrictInfoVO> voMap, String level) {
        DistrictInfoVO districtInfoVO = voMap.get(level);
        if (Objects.isNull(districtInfoVO)) {
            return "";
        }
        return districtInfoVO.getAddressName();
    }

    /**
     * 运单信息转换 (包含商品信息,以及运单下载)
     *
     * @param returnOrderInfo
     * @return java.util.List<com.eshop.modal.modal.eshop_order.TbWaybill>
     * @author sheng
     * @date 2023-11-03 18:08
     */
    private List<TbWaybill> getWaybills(OrderInfoVO returnOrderInfo, TiktokAuthBaseInfoDTO authBaseInfoDTO, JSONArray waybillArray) {
        List<OrderPackagesVO> packageList = returnOrderInfo.getPackages();
        if (CollectionUtils.isEmpty(packageList)) {
            return Collections.emptyList();
        }
        //获取运单信息
        String orderNo = returnOrderInfo.getId();
        //商品信息
        List<LineItemsVO> orderLineList = returnOrderInfo.getLineItems();
        Map<String, LineItemsVO> skuMap = orderLineList.stream().collect(Collectors.toMap(LineItemsVO::getSkuId, e -> e,
                (newVal, oldVal) -> newVal));
        List<TbWaybill> waybills = new ArrayList<>();
        Integer size = packageList.size();
        for (int i = 0; i < size; i++) {
            OrderPackagesVO orderPackagesVO = packageList.get(i);
            String packageId = orderPackagesVO.getId();
            if (StringUtils.isBlank(packageId)) {
                throw new OrderException("未获取到包裹Id");
            }
            //获取包裹信息
            PackageInfoVO packageInfo = tikTokPackageUtil.getPackageDetail(packageId, authBaseInfoDTO);
            //PackageInfoVO packageInfo = apiTikTokPackageService.getPackageInfoByPackageId(packageId1, authBaseInfoDTO);
            waybillArray.add(packageInfo.getReturnJson());
            TbWaybill waybill = orderWaybillUtils.generateNewWaybill();
            //物流渠道匹配ERP
            TbLogisticsMode logisticsMode = logModeService.selectLogisticsModeByFacilitatorCodeAndChannelCode("TikTok", packageInfo.getShippingProviderId());
            if (Objects.nonNull(logisticsMode)) {
                waybill.setLogisticsModeId(logisticsMode.getId());
            }
            waybill.setOrderNo(orderNo);
            //运单号
            String trackingNumber = packageInfo.getTrackingNumber();
            //运单号
            waybill.setWaybillNo(trackingNumber);
            waybill.setWaybillExternalId(packageInfo.getPackageId());
            //默认设置为0 正式插入时获取
            waybill.setParcelNo(BigInteger.ZERO);
            //买家自选物流
            waybill.setBuyerOptionalLogistics(packageInfo.getShippingProviderName());
            //商品
            List<PackageOrderVO> orderInfoList = packageInfo.getOrders();
            if (CollectionUtils.isNotEmpty(orderInfoList)) {
                orderInfoList.stream().forEach(e -> {
                    if (orderNo.equals(e.getId())) {
                        List<TbOrderProducts> products = e.getSkus().stream().map(sku -> {
                            TbOrderProducts orderProducts = new TbOrderProducts();
                            orderProducts.setOrderNo(orderNo);
                            String skuId = sku.getId();
                            Integer quantity = sku.getQuantity();
                            if (Objects.nonNull(quantity)) {
                                orderProducts.setNumber(quantity);
                            }
                            LineItemsVO lineVO = skuMap.get(skuId);
                            if (Objects.isNull(lineVO)) {
                                throw new OrderException("未获取到sku");
                            }
                            orderProducts.setPlatformSkuId(Long.valueOf(lineVO.getSkuId()));
                            String sellerSku = lineVO.getSellerSku();
                            if (StringUtils.isNotBlank(sellerSku)) {
                                sellerSku = sellerSku.trim();
                                orderProducts.setProductEnName(SpuCodeUtils.captureSpuCode(sellerSku));
                            } else {
                                orderProducts.setProductEnName(lineVO.getProductName());
                            }
                            orderProducts.setShopSku(sellerSku);
                            orderProducts.setGoodsImgeUrl(lineVO.getSkuImage());
                            orderProducts.setProductId(Long.valueOf(lineVO.getProductId()));
                            //成本价格
                            orderProducts.setCostPrice(BigDecimal.ZERO);
                            //商品类型
                            orderProducts.setProductType(1);
                            orderProducts.setProperty(lineVO.getSkuName());
                            //原价
                            String salePrice = lineVO.getSalePrice();
                            if (StringUtils.isNotBlank(salePrice)) {
                                orderProducts.setUnitPrice(new BigDecimal(salePrice));
                            }
                            //商品类型
                            orderProducts.setProductType(1);
                            return orderProducts;
                        }).collect(Collectors.toList());
                        waybill.setProducts(products);
                    }
                });
            }
            waybills.add(waybill);
        }
        return waybills;
    }

    /**
     * 订单成本
     *
     * @param vo
     * @return com.eshop.modal.modal.eshop_order.TbOrderCostDetail
     * @author sheng
     * @date 2023-11-03 18:08
     */
    private TbOrderCostDetail getOrderCostDetail(OrderInfoVO vo) {
        TbOrderCostDetail detail = new TbOrderCostDetail();
        PaymentInfoVO payment = vo.getPayment();
        detail.setOrderNo(vo.getId());
        detail.setCurrency(payment.getCurrency());
        //商品总售价
        detail.setProductTotalPrice(payment.getSubTotal());
        if (Objects.nonNull(payment.getShippingFee())) {
            //应收运费
            detail.setReceivablePostage(payment.getShippingFee().abs());
        }
        //其他收入
        detail.setOtherRevenue(BigDecimal.ZERO);
        //商品成本价
        detail.setProductCostPrice(BigDecimal.ZERO);
        //物流支出
        detail.setLogisticsCosts(BigDecimal.ZERO);
        //包材费
        detail.setPackingFee(BigDecimal.ZERO);
        //平台佣金费
        detail.setPlatformCost(BigDecimal.ZERO);
        //转账手续费
        detail.setTransferCost(BigDecimal.ZERO);
        //广告费用
        detail.setAdvertisingRate(BigDecimal.ZERO);
        //推广费/测评费(刷单费)
        detail.setPromotionExpenses(BigDecimal.ZERO);
        //店铺优惠劵
        detail.setShopCoupon(BigDecimal.ZERO);
        //其他支出
        detail.setOtherExpenses(BigDecimal.ZERO);
        //退款金额
        detail.setRefundMoney(BigDecimal.ZERO);
        //买方付款金额
        detail.setBuyerPaymentAmount(BigDecimalUtils.add(payment.getSubTotal(), payment.getShippingFee().abs()));
        return detail;
    }

    /**
     * 订单主表信息
     *
     * @param order
     * @param vo
     * @return com.eshop.modal.modal.eshop_order.TbOrder
     * @author sheng
     * @date 2023-11-03 18:09
     */
    private void getOrder(TbOrder order, OrderInfoVO vo) {
        //订单号
        String orderSn = vo.getId();
        //创建订单的日期和时间的时间戳 --> 商品总售价
        Long createTime = vo.getCreateTime();
        if (createTime != null) {
            order.setOrderTime(new Date(createTime * 1000));
        }
        //时间使用最晚收集时间
        //Long shipByDate = vo.getTtsSla();
        Long shipByDate = vo.getTtsSlaTime();
        if (shipByDate != null) {
            order.setDeliveryDeadlineTime(new Date(shipByDate * 1000));
        }
        //付款时间
        Long payTime = vo.getPaidTime();
        if (payTime != null) {
            order.setPaymentTime(new Date(payTime * 1000));
        } else {
            //没有付款时间 使用创建时间
            order.setPaymentTime(new Date(createTime * 1000));
        }
        order.setOrderDetail(vo.getReturnJson());
        order.setPlatformMessage(vo.getBuyerMessage());
        order.setTransactionNo(orderSn);
        order.setOrderNo(orderSn);
        Integer platformOrderStatus = TkOrderStatusEnum.getCodeByStatus(vo.getStatus());
        order.setPlatformOrderStatus(platformOrderStatus);
    }

    /**
     * 订单关联用户
     *
     * @param vo
     * @return com.eshop.modal.modal.eshop_order.TbOrderBuyerInfo
     * @author sheng
     * @date 2023-11-14 13:51
     */
    private TbOrderBuyerInfo getOrderBuyerInfo(OrderInfoVO vo) {
        TbOrderBuyerInfo orderBuyer = new TbOrderBuyerInfo();
        String buyerId = vo.getUserId();
        if (StringUtils.isNotBlank(buyerId)) {
            buyerId = buyerId.trim();
        }
        orderBuyer.setBuyerId(buyerId);
        orderBuyer.setEmail(vo.getBuyerEmail());
        //buyer_username 买家姓名
        RecipientAddressVO recipientAddress = vo.getRecipientAddress();
        orderBuyer.setBuyerName(recipientAddress.getName());
        orderBuyer.setContactPhone(recipientAddress.getPhoneNumber());
        orderBuyer.setOrderNo(vo.getId());
        return orderBuyer;
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
}
