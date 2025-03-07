package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;


import com.eshop.entity.base.PlatformSyncInfoResponseVO;
import com.eshop.entity.base.ShopContextVO;
import com.eshop.entity.config.TbPlatform;
import com.eshop.entity.config.TbShop;
import com.eshop.entity.config.TbShopEmployee;
import com.eshop.entity.order.TbOrder;
import com.eshop.entity.order.TbOrderCancel;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSyncFilterService;
import com.eshop.util.RedisUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2023/6/26 15:21
 * @Description: ...
 * @Version 1.0
 */
@Service
public class OrderSyncFilterServiceImpl implements OrderSyncFilterService {

    private static final Logger logger = LoggerFactory.getLogger(OrderSyncFilterServiceImpl.class);

    private static final String ORDER_REDIS_SYN = ConstantRedis.ORDER_REDIS_SYN;

    private static final String ORDER_REDIS_UPDATE = ConstantRedis.ORDER_REDIS_UPDATE;

    private static final String ORDER_REDIS_CANCEL = ConstantRedis.ORDER_REDIS_CANCEL;

    private static final Long ORDER_SYN_CACHE_TIME = ConstantRedis.ORDER_SYN_CACHE_TIME;

    private static final Long ORDER_UPDATE_CACHE_TIME = ConstantRedis.ORDER_UPDATE_CACHE_TIME;

    private static final Long ORDER_CANCEL_CACHE_TIME = ConstantRedis.ORDER_CANCEL_CACHE_TIME;

    @Resource
    private OrderService orderService;

    @Resource
    private OrderCancelService orderCancelService;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 订单过滤 防止订单重复
     * redis 和 数据库双重保险过滤
     *
     * @param poList
     * @return
     */
    public List<PlatformSyncInfoResponseVO<TbOrder>> orderAddFilter(List<PlatformSyncInfoResponseVO<TbOrder>> poList, ShopContextVO shopContextVO) throws Exception {
        TbShop shop = psDto.getShop();
        TbPlatform tbPlatform = psDto.getPlatform();
        TbShopEmployee shopManager = psDto.getShopEmployee();
        //没有订单 就不过滤
        if (CollectionUtils.isEmpty(poList)) {
            return null;
        }
        List<PlatformSyncInfoResponseVO<TbOrder>> ordersNew = new ArrayList<>();
        Map<String, TbOrder> orderNoMap = getOrderNoMapOfDb(poList.stream().map(PlatformSyncInfoResponseVO::getInfo)
                .map(TbOrder::getOrderNo).collect(Collectors.toList()));
        poList.forEach(po -> {
            TbOrder order = po.getInfo();
            if (isNotExistOfDb(order, orderNoMap, psDto)) {
                isNotExistOfRedis(order);
                //平台信息
                order.setPlatformId(tbPlatform.getId());
                order.setPlatformName(tbPlatform.getPlatformName());
                //店铺信息
                order.setShopId(shop.getId());
                order.setMerchantId(shop.getMerchantId());
                order.setShopName(shop.getName());
                order.setShopownerId(shopManager.getEmployeeId());
                //设置订单状态 为待审核
                order.setOrderStatus((byte) 1);
                //设置订单类型 普通订单
                order.setOrderType((byte) 1);
                order.setShopownerId(shopManager.getEmployeeId());
                ordersNew.add(po);
            }
        });
        return ordersNew;
    }

    /**
     * 订单过滤 防止订单重复
     * redis 和 数据库双重保险过滤
     *
     * @param poList
     * @return
     */
    public List<PlatformSyncInfoResponseVO<TbOrder>> orderUpdateFilter(List<PlatformSyncInfoResponseVO<TbOrder>> poList, ShopContextVO shopContextVO) throws Exception {
        //没有订单 就不过滤
        if (CollectionUtils.isEmpty(poList)) {
            return null;
        }
        Map<String, TbOrder> orderNoMap = getOrderNoMapOfDb(poList.stream().map(PlatformSyncInfoResponseVO::getInfo).map(TbOrder::getOrderNo).collect(Collectors.toList()));

        List<PlatformSyncInfoResponseVO<TbOrder>> ordersNew = new ArrayList<>();
        for (PlatformSyncInfoResponseVO<TbOrder> po : poList) {
            TbOrder order = po.getInfo();
            redisUtils.set(ORDER_REDIS_UPDATE + order.getOrderNo(), "notNull", ORDER_UPDATE_CACHE_TIME);
            TbOrder orderByOrder = orderNoMap.get(order.getOrderNo());
            if (Objects.nonNull(orderByOrder) && !orderByOrder.getPlatformOrderStatus().equals(order.getPlatformOrderStatus())) {
                orderByOrder.setPlatformOrderStatus(order.getPlatformOrderStatus());
                ordersNew.add(po);
            }
        }
        return ordersNew;
    }

    /**
     * 订单过滤 防止订单申请取消重复
     *
     * @param poList
     * @return
     */
    @Override
    public List<PlatformSyncInfoResponseVO<TbOrder>> orderInCancelFilter(List<PlatformSyncInfoResponseVO<TbOrder>> poList, ShopContextVO shopContextVO) throws Exception {
        if (CollectionUtils.isEmpty(poList)) {
            return null;
        }
        Map<String, TbOrderCancel> orderCancelMap = getOrderCancelMap(poList.stream().map(PlatformSyncInfoResponseVO::getInfo).map(TbOrder::getOrderNo).collect(Collectors.toList()));
        List<PlatformSyncInfoResponseVO<TbOrder>> ordersNew = new ArrayList<>();
        for (PlatformSyncInfoResponseVO<TbOrder> po : poList) {
            TbOrder order = po.getInfo();
            redisUtils.set(ORDER_REDIS_CANCEL + order.getOrderNo(), "notNull", ORDER_CANCEL_CACHE_TIME);
            TbOrderCancel orderCancel = orderCancelMap.get(order.getOrderNo());
            if (Objects.nonNull(orderCancel)) {
                ordersNew.add(po);
            }
        }
        return ordersNew;
    }

    /**
     * 判断redis是否已存在当前获取到的订单
     *
     * @param order
     * @return
     */
    private boolean isNotExistOfRedis(TbOrder order) {
        String value = redisUtils.get(ORDER_REDIS_SYN + order.getOrderNo());
        //若已存在该订单 返回false
        if (StringUtils.isNotBlank(value)) {
            return false;
        }
        //设置失效时间为一小时
        redisUtils.set(ORDER_REDIS_SYN + order.getOrderNo(), "notNull", ORDER_SYN_CACHE_TIME);
        return true;
    }

    /**
     * 判断db是否已存在当前获取到的订单
     *
     * @param order
     * @return
     */
    private boolean isNotExistOfDb(TbOrder order, Map<String, TbOrder> orderNoMap, PlatformSyncDTO psDto) {
        Long shopId = psDto.getShop().getId();
        String orderNo = order.getOrderNo();
        //订单号为空 返回false 防错
        if (StringUtils.isBlank(orderNo)) {
            return false;
        }
        TbOrder oldOrder = orderNoMap.get(orderNo);

        //不存在
        if (oldOrder == null) {
            return true;
        }
        //店铺不一样
        if (shopId != (long) oldOrder.getShopId()) {
            logger.error("重复订单号：" + orderNo);
            logger.error("问题店铺：" + shopId + "已存在订单店铺：" + oldOrder.getShopId());
            return false;
        }
        return false;
    }

    /**
     * 判断db是否已存在当前获取到的订单
     *
     * @param orderNos
     * @return
     */
    private Map<String, TbOrder> getOrderNoMapOfDb(List<String> orderNos) throws Exception {
        Map<String, TbOrder> rtMap = new HashMap<>();
        if (CollectionUtils.isEmpty(orderNos)) {
            return rtMap;
        }
        TbOrder order = new TbOrder();
        order.setOrderNoList(orderNos);

        List<TbOrder> result = orderService.selectByExample(order, null, null, null, null);
        //若已存在该订单 返回false
        if (CollectionUtils.isEmpty(result)) {
            return rtMap;
        }
        return result.stream().collect(Collectors.toMap(TbOrder::getOrderNo, o -> o, (oldValue, newValue) -> newValue));
    }

    /**
     * 获取订单取消表信息(根据订单号)
     *
     * @param orderNos
     * @return
     * @throws Exception
     */
    private Map<String, TbOrderCancel> getOrderCancelMap(List<String> orderNos) throws Exception {
        List<TbOrderCancel> tbOrderCancels = orderCancelService.selectInByProperty(TbOrderCancel::getOrderNo, orderNos);
        if (CollectionUtils.isEmpty(tbOrderCancels)) {
            return new HashMap<>();
        }
        return tbOrderCancels.stream().collect(Collectors.toMap(TbOrderCancel::getOrderNo, o -> o, (oldValue, newValue) -> newValue));
    }

}
