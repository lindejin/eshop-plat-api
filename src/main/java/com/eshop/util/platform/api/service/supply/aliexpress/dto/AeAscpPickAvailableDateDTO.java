package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发备货单-创建揽收单时可揽收日期查询 DTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpPickAvailableDateDTO {

    // 发货单集合
    private String relatedOrderNumber;
}
