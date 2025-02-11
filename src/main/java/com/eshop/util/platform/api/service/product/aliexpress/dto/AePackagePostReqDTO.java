package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AePackagePostReqDTO
 * @Description 包裹信息
 * @Author xxs
 * @Date 2024/6/25 14:14
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AePackagePostReqDTO {

//    lot_num	Number	否	每包的数量
    private Number lot_num;
//    product_unit	Number	否	产品的单位
    private Number product_unit;
//    package_type	Boolean	否	打包销售: true 非打包销售:false
    private Boolean package_type;
}
