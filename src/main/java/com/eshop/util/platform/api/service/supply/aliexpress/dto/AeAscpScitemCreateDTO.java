package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:34
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpScitemCreateDTO {
    //        request.addApiParameter("scitem_create_request", "{\"item_code\":\"23432\",\"origin_box_package\":\"true\",\"biz_type\":\"288000\",\"length\":\"1\",\"specification\":\"test-\u89C4\u683C\",\"weight\":\"1\",\"customs_unit_price\":\"1.2\",\"title\":\"\u8D27\u54C1\u540D\u79F0\",\"is_hygroscopic\":\"true\",\"gweight\":\"1\",\"whc_bar_code\":\"123\",\"is_danger\":\"true\",\"dangerous_type\":\"air_embargo\",\"feature\":\"{\\\"key\\\":\\\"value\\\"}\",\"width\":\"1\",\"nweight\":\"1\",\"include_battery\":\"1\",\"height\":\"1\"}");
    private String scitem_create_request;

}
