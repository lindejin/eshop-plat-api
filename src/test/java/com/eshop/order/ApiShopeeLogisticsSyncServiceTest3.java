package com.eshop.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eshop.entity.order.TbOrderBillPlatform;
import com.eshop.service.config.ITbShopService;
import com.eshop.service.order.ITbOrderBillPlatformService;
import com.eshop.util.MurmurHashUtil;
import com.eshop.util.shop.PlatformAppClientUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ApiShopeeLogisticsSyncServiceTest3 {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbOrderBillPlatformService iTbOrderBillPlatformService;

    @Resource
    private ITbShopService iTbShopService;

    @Test
    void contextLoads() throws Exception {
        LambdaQueryWrapper<TbOrderBillPlatform> lqWrapper = Wrappers.<TbOrderBillPlatform>lambdaQuery();
        lqWrapper.eq(TbOrderBillPlatform::getOrderNo, "250519AQ62BNVJ");
        List<TbOrderBillPlatform> list = iTbOrderBillPlatformService.list(lqWrapper);

        TbOrderBillPlatform tbOrderBillPlatform001 = list.get(0);
        TbOrderBillPlatform tbOrderBillPlatform002 = list.get(1);

        String respBody001 = tbOrderBillPlatform001.getResponseBody();
        String respBody002 = tbOrderBillPlatform002.getResponseBody();
        for (TbOrderBillPlatform tbOrderBillPlatform1 : list) {
            if (tbOrderBillPlatform1.getBillType().equals(tbOrderBillPlatform001.getBillType())) {
                String responseBody = tbOrderBillPlatform1.getResponseBody();
                System.out.println(compareHashesBody(respBody001, responseBody));
            }

        }

        System.out.println("GG");
        for (TbOrderBillPlatform tbOrderBillPlatform1 : list) {


            if (tbOrderBillPlatform1.getBillType().equals(tbOrderBillPlatform002.getBillType())) {
                String responseBody = tbOrderBillPlatform1.getResponseBody();
                System.out.println(compareHashesBody(respBody002, responseBody));
            }
        }
    }

    /**
     * 哈希值比对工具方法
     *
     * @return true-数据相同 false-数据不同或空值
     */
    public boolean compareHashesBody(String respBody, String responseBody) {
        respBody = deleteRequestId(respBody);
        responseBody = deleteRequestId(responseBody);

        String hash128Temp = MurmurHashUtil.murmur3_128HashString(respBody);
        String hash128 = MurmurHashUtil.murmur3_128HashString(responseBody);

        if (hash128Temp == null || hash128 == null) {
            return false;
        }
        return StringUtils.equals(hash128Temp, hash128);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 删除 JSON 字符串中的 RequestId 键
     */
    private String deleteRequestId(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return jsonStr;
        }

        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            if (rootNode.isObject()) {
                ObjectNode objectNode = (ObjectNode) rootNode;
                objectNode.remove("requestId"); // 删除键
                return objectMapper.writeValueAsString(objectNode);
            }
            return jsonStr;
        } catch (Exception e) {
            // JSON 解析失败时返回原始字符串（或根据需求处理）
            return jsonStr;
        }
    }
}
