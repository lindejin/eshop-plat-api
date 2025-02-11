package com.eshop.util.platform.api.service.product.aliexpress;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.eshop.util.platform.api.service.product.aliexpress.dto.AeCheckCategoryReqDTO;
import com.eshop.util.platform.api.service.product.aliexpress.dto.AeProductCategoryPostReqDTO;
import com.eshop.util.platform.api.service.product.aliexpress.dto.AeProductChoicePostReqDTO;
import com.eshop.util.platform.api.service.product.aliexpress.dto.AeProductChoiceQueryReqDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressProductEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import org.springframework.stereotype.Service;

/**
 * @author rch
 * @date 2024/6/24 17:14
 * @Description: 全托管
 * @Version 1.0
 */
@Service
public class AliexpressFullProductCallImpl implements AliexpressFullProductCall {

    // 1.查询全托管店铺channelSellerld     global.seller.relation.query
    public String channelSellerld(AeAppClientDTO acDTO) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.SELLER_RELATION_QUERY.getApiName());
        request.setHttpMethod("GET");
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    // 2.通过channelSellerld查询有权限类目aliexpress.category.tree.list
    public String categoryTreeList(AeAppClientDTO acDTO, AeCheckCategoryReqDTO reqDto) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setHttpMethod("GET");
        request.setApiName(AliexpressProductEnu.AE_CATEGORY_TREE_LIST.getApiName());
        if (ObjectUtil.isNotEmpty(reqDto.getChannelSellerId())) {
            request.addApiParameter("channel_seller_id", String.valueOf(reqDto.getChannelSellerId()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getOnlyWithPermission())) {
            request.addApiParameter("only_with_permission", String.valueOf(reqDto.getOnlyWithPermission()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getChannel())) {
            request.addApiParameter("channel", String.valueOf(reqDto.getChannel()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getCategoryId())) {
            request.addApiParameter("category_id", String.valueOf(reqDto.getCategoryId()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    // 3.通过channelSellerld查询类目下属性和品牌信息
    // aliexpress.category.redefining.getchildattributesresultbypostcateidandpath
    public String channelSellerld(AeAppClientDTO acDTO, AeProductCategoryPostReqDTO reqDto) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.AE_CATEGORY_REDEFINING_GETCHILDATTRIBUTESRESULTBYPOSTCATEIDANDPATH.getApiName());
        if (ObjectUtil.isNotEmpty(reqDto.getChannel())) {
            request.addApiParameter("channel", String.valueOf(reqDto.getChannel()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getProductType())) {
            request.addApiParameter("locale", String.valueOf(reqDto.getLocale()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getLocale())) {
            request.addApiParameter("product_type", String.valueOf(reqDto.getProductType()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getChannelSellerId())) {
            request.addApiParameter("channel_seller_id", String.valueOf(reqDto.getChannelSellerId()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getParam1())) {
            request.addApiParameter("param1", String.valueOf(reqDto.getParam1()));
        }
        if (ObjectUtil.isNotEmpty(reqDto.getParam2())) {
            request.addApiParameter("param2", String.valueOf(reqDto.getParam2()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    // 4.调用统一商品发布接口                   aliexpress.choice.product.post
    public String productPost(AeAppClientDTO acDTO, AeProductChoicePostReqDTO reqDto) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.AE_CHOICE_PRODUCT_POST.getApiName());
        request.addApiParameter("channel", String.valueOf(reqDto.getChannel()));
        request.addApiParameter("channel_seller_id", String.valueOf(reqDto.getChannel_seller_id()));
        String jsonString = JSONUtil.toJsonStr(reqDto.getOne_stop_service_product_dto());
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode jsonNode = mapper.readTree(jsonString);
//            // 获取 detail_source_list 数组
//            JsonNode detailSourceList = jsonNode.get("detail_source_list");
//            // 遍历数组
//            for (JsonNode detailSource : detailSourceList) {
//                // 获取 mobile_detail 字段并转换为 JSON 对象
//                String mobileDetailStr = detailSource.get("mobile_detail").asText();
//                JsonNode mobileDetailJson = mapper.readTree(mobileDetailStr);
//                // 将转换后的 JSON 对象放回去
//                ((ObjectNode) detailSource).set("mobile_detail", mobileDetailJson);
//            }
//            // 输出处理后的 JSON 字符串
//            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        request.addApiParameter("one_stop_service_product_dto", jsonString);
        if (ObjectUtil.isNotEmpty(reqDto.getVersion())) {
            request.addApiParameter("version", String.valueOf(reqDto.getVersion()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    // 5.查询全托管商品列表                       aliexpress.choice.products.list

    // 6.查询全托管商品仓库编码                aliexpress.choice.product.stocks.query


    // 全托管店铺-查询单个商品详情                  aliexpress.choice.product.post
    public String choiceProductQuery(AeAppClientDTO acDTO, AeProductChoiceQueryReqDTO reqDto) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.AE_CHOICE_PRODUCT_QUERY.getApiName());
        request.addApiParameter("channel", String.valueOf(reqDto.getChannel()));
        request.addApiParameter("channel_seller_id", String.valueOf(reqDto.getChannel_seller_id()));
        request.addApiParameter("product_id", reqDto.getProduct_id().toString());
        if (ObjectUtil.isNotEmpty(reqDto.getVersion())) {
            request.addApiParameter("version", String.valueOf(reqDto.getVersion()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
