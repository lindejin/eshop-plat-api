package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AeWarehousePostReqDTO
 * @Description 库存列表
 * @Author xxs
 * @Date 2024/6/25 14:12
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeWarehousePostReqDTO {
//    sellable_quantity	Number	否	可售库存
    private Number sellable_quantity;
//    warehouse_code	String	否	库存编码
    private String warehouse_code;
//    warehouse_name	String	否	库存名称
    private String warehouse_name;
}
