package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * @author rch
 * @date 2024/6/21 14:57
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryAttrQueryDTO {

    // 获取属性值文本对应的多语言信息
    private String locale;

    // 全托管商品备仓类型，channel_seller_id传全托管店铺id时生效，枚举： 0（国内备仓），1（JIT类型），2（海外备仓）。目前的区别是 0和1 查询没有发货地属性，2查询有发货地属性，并且海外仓发货地必填
    private String productType;

    // 叶子节点id
    private String categoryId;

    // 类目子属性路径,由该子属性上层的类目属性id和类目属性值id组成,格式参考示例，多个用逗号隔开，第二个属性及为第一个的属性值的子属性，第三个属性为第二个属性的子属性，以此类推。如需返回此类目对应的子属性，则需同cateid一起进行提交。
    private String[] param2;

    // 业务类型
    private Long shopId;
}