package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:37
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpScitemUpdateDTO {
    //        request.addApiParameter("scitem_update_request", "{\"channel_user_id\":\"111\",\"origin_box_package\":\"true\",\"biz_type\":\"288000\",\"length\":\"1\",\"specification\":\"test\u89C4\u683C\",\"weight\":\"1\",\"customs_unit_price\":\"1.2\",\"title\":\"\u6D4B\u8BD5-title\",\"is_hygroscopic\":\"true\",\"is_danger\":\"true\",\"GWeight\":\"1\",\"dangerous_type\":\"air_embargo\",\"feature\":\"{\\\"key\\\":\\\"value\\\"}\",\"width\":\"1\",\"include_battery\":\"1\",\"NWeight\":\"1\",\"sc_item_id\":\"2123423\",\"height\":\"1\"}");
    private String scitem_update_request;
}
