package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xxs
 * @date 2024/9/19
 * @Description: 创建揽收单时可揽收日期查询
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpQueryPickupAvailableDateDTO {
    private List<String> related_order_number_list;
    private Number biz_type;
    private Number channel_user_id;
    private AeAscpQueryPickupAvailableDateContactInfoDTO contact_info_dto;
    private String biz_order_type;
}
