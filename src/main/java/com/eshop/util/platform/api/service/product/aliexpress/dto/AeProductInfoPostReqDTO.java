package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AeProductInfoPostReqDTO
 * @Description 商品基本信息
 * @Author xxs
 * @Date 2024/6/25 14:15
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeProductInfoPostReqDTO {

//    subject_list	Object[]	是	商品标题
    private List<AeSubjectPostReqDTO> subject_list;
//    locale	String	是	商品原发语种：en_US
    private String locale;
//    currency_code	String	否	货币单位。如果不提供该值信息，则默认为"USD"；非俄罗斯卖家这个属性值可以不提供。对于俄罗斯海外卖家，该单位值必须提供，如: "RUB"。
    private String currency_code;
//    category_id	Number	是	类目id
    private Number category_id;
}
