package com.eshop.hash;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eshop.entity.log.TbOrderRespLog;
import com.eshop.entity.order.TbOrderCostShopee;
import com.eshop.service.log.ITbOrderRespLogService;
import com.eshop.service.order.ITbOrderCostShopeeService;
import com.eshop.util.MurmurHashUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@SpringBootTest
public class HashControllerUpTest {

    @Autowired
    private ITbOrderRespLogService iTbOrderRespLogService;

    @Autowired
    private ITbOrderCostShopeeService iTbOrderCostShopeeService;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;


    @Test
    public void upShopOrder() throws Exception {

        // 使用MyBatis-Plus的LambdaQueryWrapper查询
        List<TbOrderCostShopee> list = iTbOrderCostShopeeService.list();

        // 虾皮订单费用请求日志入库
        List<TbOrderRespLog> logList = getRespLogList(list);
        if (ObjectUtil.isNotEmpty(logList)) {
            saveRespLogList(logList); // 使用saveBatch批量保存
        }
    }


    private List<TbOrderRespLog> getRespLogList(List<TbOrderCostShopee> listDOS) {
        Date date = new Date();
        String operatorName = "sys";

        List<TbOrderRespLog> respLogList = new ArrayList<>();
        for (TbOrderCostShopee syncDTO : listDOS) {
            String orderNo = syncDTO.getOrderNo();
            Long shopId = syncDTO.getShopId();
            Long platformId = syncDTO.getPlatformId();
            if (platformId == null){
                continue;
            }
            String respBody = syncDTO.getResponseBody();

            TbOrderRespLog respLog = new TbOrderRespLog();
            respLog.setOrderNo(orderNo);
            respLog.setPlatformId(platformId);
            respLog.setShopId(shopId);
            respLog.setOperateProperty("虾皮订单费用");
            if (ObjectUtil.isEmpty(respBody)) {
                respLog.setDescription("获取虾皮订单费用失败");
            } else {
                respLog.setDescription("获取成功");
            }
            respLog.setRespBody(respBody);
            respLog.setOperator(operatorName);
            respLog.setOperateTime(date);

            respLogList.add(respLog);
        }
        return respLogList;
    }

    public void saveRespLogList(List<TbOrderRespLog> respLogList) throws Exception {
        if (ObjectUtil.isEmpty(respLogList)) {
            return;
        }
        for (TbOrderRespLog respLog : respLogList) {
            String respBody = respLog.getRespBody();
            String orderNo = respLog.getOrderNo();
            if (StringUtils.isBlank(respLog.getRespBody())){
                continue;
            }
            TbOrderRespLog upLog = fun01(respLog, respBody, orderNo);
            if (upLog == null) {
                upLog = fun02(respLog, respBody, orderNo);
            }

            if (upLog == null) {
                continue;
            }
            respLog.setHash(upLog.getHash());
            respLog.setHash128(upLog.getHash128());
        }
        iTbOrderRespLogService.saveBatch(respLogList,2000);
    }


    private static TbOrderRespLog fun01(TbOrderRespLog respLog, String respBody, String orderNo) {
        JSONObject root = JSON.parseObject(respBody);
        JSONObject orderIncomeJson = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("response"))
                .map(r -> r.getJSONObject("order_income")).orElse(null);

        String orderSn = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("response"))
                .map(r -> r.getString("order_sn")).orElse(null);


        if (orderIncomeJson == null) {
            return null;
        }

        if (orderSn == null) {
            return null;
        }

        if (!orderSn.equals(orderNo)) {
            return null;
        }
        // 转回 String 并保留 null 值
        String orderIncomeStr = JSON.toJSONString(
                orderIncomeJson,
                SerializerFeature.WriteMapNullValue // 关键：保留 null 字段
        );

        Byte[] hash128 = MurmurHashUtil.generateUniqueHashByte(orderIncomeStr + orderSn);

        TbOrderRespLog upLog = new TbOrderRespLog();
        upLog.setId(respLog.getId());
        upLog.setHash128(hash128);
        return upLog;
    }

    private static TbOrderRespLog fun02(TbOrderRespLog respLog, String respBody, String orderNo) {
        JSONObject root = JSON.parseObject(respBody);
        JSONObject orderIncomeJson = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("escrow_detail"))
                .map(r -> r.getJSONObject("order_income")).orElse(null);

        String orderSn = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("escrow_detail"))
                .map(r -> r.getString("order_sn")).orElse(null);


        if (orderIncomeJson == null) {
            return null;
        }

        if (orderSn == null) {
            return null;
        }

        if (!orderSn.equals(orderNo)) {
            return null;
        }
        // 转回 String 并保留 null 值
        String orderIncomeStr = JSON.toJSONString(
                orderIncomeJson,
                SerializerFeature.WriteMapNullValue // 关键：保留 null 字段
        );

        Byte[] hash128 = MurmurHashUtil.generateUniqueHashByte(orderIncomeStr + orderSn);

        TbOrderRespLog upLog = new TbOrderRespLog();
        upLog.setId(respLog.getId());
        upLog.setHash128(hash128);
        return upLog;
    }
}
