package com.eshop.util.platform.api.service.logistics.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @author ldj
 * @date 2023/10/18 9:58
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeLogisticsCall {

    /**
     * 获取发货参数 虾皮
     */
    String getShippingParameter(ShopeeAppClientDTO publicDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 获得可选择的面单类型和建议的面单类型 虾皮
     */
    String getShippingDocumentParameter(ShopeeAppClientDTO publicDTO, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 安排发货
     * 使用此 API 启动物流，包括为非集成物流渠道安排取件、下车或装运。
     * 应该先调用 v2.logistics.get_shipping_parameter 来获取所有必需的参数。
     * 建议在下订单后一小时启动物流，因为有一小时的窗口，买家可以取消任何订单，而无需向卖家提出要求。
     */
    String shipOrder(ShopeeAppClientDTO publicDTO, JSONObject businessDto) throws Exception;

    /**
     * 虾皮获取 运单号
     * 为集成渠道安排发货 （v2.logistics.ship_order） 后，
     * 使用此 API 获取tracking_number，这是创建发货标签的必需参数。
     * api 响应可以返回tracking_number空，因为此信息依赖于 3PL，
     * 因此允许在 5 分钟的间隔内继续调用 api，直到返回tracking_number。
     */
    String getTrackingNumber(ShopeeAppClientDTO publicDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 请求创建虾皮面单
     */
    String createShippingDocument(ShopeeAppClientDTO publicDTO, JSONObject businessDto) throws Exception;

    /**
     * 获取创建虾皮面单结果
     */
    String getShippingDocumentResult(ShopeeAppClientDTO publicDTO, JSONObject businessDto) throws Exception;

    /**
     * 下载面单
     * 必须先调用 v2.logistics.create_shipping_document 以创建新的装运单据任务，
     * 然后调用 v2.logistics.get_shipping_document_result 以获取任务状态
     */
    ResponseEntity<byte[]> downloadShippingDocument(ShopeeAppClientDTO publicDTO, JSONObject businessDto);

    /**
     * 使用此 API 获取订单的物流信息，这些信息可用于空运提单打印。
     * 专用于跨境SLS订单空运提单。
     * 可能不适用于本地航道空运提单。
     * 此外，此 API 支持将个人信息作为图像返回。
     */
    String getShippingDocumentDataInfo(ShopeeAppClientDTO publicDTO, JSONObject businessDto) throws Exception;
}
