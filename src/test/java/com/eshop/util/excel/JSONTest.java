package com.eshop.util.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class JSONTest {

    public static void main(String[] args) {
        String orderDetail = "[{\"unitPrice\":39.1,\"platformSkuId\":\"1091161670770528277\",\"productEnName\":\"Mens Fashion Tracksuits Casual Hoodie Sweatsuits Men&#039;s Sport Style Tracksuit Classic Print Jogging Gym Sweatpants Set Men Sweatsuit 23SS\",\"productId\":\"845205502\",\"length\":10.0,\"goodsImgeUrl\":\"f3/albu/jc/y/18/4c3000b9-9020-42e7-9bf9-9afde7586811.jpg\",\"basisWeight\":0.9,\"measureName\":\"Pièce\",\"categoryName\":\"Apparel\",\"packingQuantity\":1,\"number\":1,\"isCustomer\":0,\"shopSku\":\"183-58IYKJ-blue-XL\",\"property\":\"Blue,XL\",\"width\":10.0,\"itemUrl\":\"product/mens-fashion-tracksuits-casual-hoodie-sweatsuits/845205502.html\",\"height\":10.0},{\"unitPrice\":39.1,\"platformSkuId\":\"1091161670772559923\",\"productEnName\":\"Mens Fashion Tracksuits Casual Hoodie Sweatsuits Men&#039;s Sport Style Tracksuit Classic Print Jogging Gym Sweatpants Set Men Sweatsuit 23SS\",\"productId\":\"845205502\",\"length\":10.0,\"goodsImgeUrl\":\"f3/albu/jc/y/18/8d9058ac-e457-45d9-a258-7a6c581b775f.jpg\",\"basisWeight\":0.9,\"measureName\":\"Pièce\",\"categoryName\":\"Apparel\",\"packingQuantity\":1,\"number\":1,\"isCustomer\":0,\"shopSku\":\"183-58IYKJ-black-XL\",\"property\":\"XL,Black\",\"width\":10.0,\"itemUrl\":\"product/mens-fashion-tracksuits-casual-hoodie-sweatsuits/845205502.html\",\"height\":10.0}]";
        try {
            JSONArray array = JSONArray.parseArray(orderDetail);

            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                try {
                    String platformSkuId = jsonObject.getString("platformSkuId");
                    String goodsImgeUrl = jsonObject.getString("goodsImgeUrl");
                    if (StringUtils.isBlank(goodsImgeUrl)) {
                        continue;
                    }
                    System.out.println(goodsImgeUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
