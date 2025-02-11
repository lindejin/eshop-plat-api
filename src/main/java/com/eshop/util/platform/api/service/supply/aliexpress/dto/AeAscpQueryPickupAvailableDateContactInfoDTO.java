package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xxs
 * @date 2024/9/19
 * @Description: 创建揽收单时可揽收日期查询
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpQueryPickupAvailableDateContactInfoDTO {
    private String area;
    private String address;
    private Number area_id;
    private String phone;
    private String name;
    private String address_context;
    private Number street_id;
}
