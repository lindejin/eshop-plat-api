package com.eshop.util.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eshop.entity.order.TbOrderProducts;
import com.eshop.entity.order.TbOrderRequestBody;
import com.eshop.service.config.ITbShopService;
import com.eshop.service.order.ITbOrderProductsService;
import com.eshop.service.order.ITbOrderRequestBodyService;
import com.eshop.service.order.ITbOrderService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Excel读取工具类测试
 *
 * @author ldj
 * @date 2024/03/27
 */
@SpringBootTest
public class ExcelReaderTest2 {

    @Resource
    private ITbShopService shopService;

    @Resource
    private ITbOrderService iTbOrderService;

    @Resource
    private ITbOrderProductsService iTbOrderProductsService;

    @Resource
    private ITbOrderRequestBodyService iTbOrderRequestBodyService;

    public static void main(String[] args) {
        String url = "https://p16-oec-va.ibyteimg.com/tos-maliva-i-o3syd03w52-us/2f68d706399745d2bac21fc8dc5e074c~tplv-o3syd03w52-origin-jpeg.jpeg?dr=15568&nonce=33384&refresh_token=e50cf2c456e8cea46591974810f295e2&from=1413970683&idc=maliva&ps=933b5bde&shcp=3c3d9ffb&shp=54477afb&t=555f072d";
        System.out.println(url.length());
    }

    @Test
    public void testReadExcelToTbImg() throws Exception {
        String filePath = "F:\\op.xls"; // 测试时替换为实际的Excel文件路径

        // 调用ExcelReader读取Excel文件并转换为TbImg对象列表
        List<TbOrderProducts> imgList = ExcelReader.readExcel(filePath, TbOrderProducts.class);

        Set<String> orderNos = imgList.stream().map(TbOrderProducts::getOrderNo).collect(Collectors.toSet());

        LambdaQueryWrapper<TbOrderRequestBody> lqWrapper = Wrappers.<TbOrderRequestBody>lambdaQuery();
        lqWrapper.in(TbOrderRequestBody::getOrderNo, orderNos);
        lqWrapper.eq(TbOrderRequestBody::getRequestType, 3);
        List<TbOrderRequestBody> list = iTbOrderRequestBodyService.list(lqWrapper);

        Map<String, TbOrderRequestBody> collect = list.stream().collect(Collectors.toMap(TbOrderRequestBody::getOrderNo, Function.identity(), (o1, o2) -> o1));
        Map<String, String> skuImgMap = getSkuImgMap(list);
        for (TbOrderProducts op : imgList) {
            Long platformSkuId = op.getPlatformSkuId();
            String orderNo = op.getOrderNo();
            String url = skuImgMap.get(orderNo + platformSkuId);
            System.out.println(url);
        }
    }

    private Map<String, String> getSkuImgMap(List<TbOrderRequestBody> list) {
        Map<String, String> skuImgMap = new HashMap<>();
        for (TbOrderRequestBody body : list) {
            String orderNo = body.getOrderNo();
            String orderDetail = body.getOrderDetail();
            try {
                JSONArray array = JSONArray.parseArray(orderDetail);

                for (int i = 0; i < array.size(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = array.getJSONObject(i);
                        String sku_id = jsonObject.getString("sku_id");
                        String sku_image = jsonObject.getString("sku_image");
                        if (StringUtils.isBlank(sku_image)) {
                            continue;
                        }
                        if (StringUtils.isNotBlank(sku_id) && StringUtils.isNotBlank(sku_image)) {
                            skuImgMap.put(orderNo + sku_id, sku_image);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        String model_id = jsonObject.getString("model_id");
                        JSONObject imageInfo = jsonObject.getJSONObject("image_info");
                        if (imageInfo == null) {
                            continue;
                        }
                        String image_url = imageInfo.getString("image_url");
                        if (StringUtils.isBlank(image_url)) {
                            continue;
                        }
                        if (StringUtils.isNotBlank(model_id) && StringUtils.isNotBlank(image_url)) {
                            skuImgMap.put(orderNo + model_id, image_url);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        String platformSkuId = jsonObject.getString("platformSkuId");
                        String goodsImgeUrl = jsonObject.getString("goodsImgeUrl");
                        if (StringUtils.isBlank(goodsImgeUrl)) {
                            continue;
                        }
                        skuImgMap.put(orderNo + platformSkuId, goodsImgeUrl);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return skuImgMap;
    }
}