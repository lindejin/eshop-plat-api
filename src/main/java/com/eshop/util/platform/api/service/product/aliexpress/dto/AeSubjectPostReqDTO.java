package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AeSubjectPostReqDTO
 * @Description 商品标题
 * @Author xxs
 * @Date 2024/6/25 14:16
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeSubjectPostReqDTO {

//    locale	String	是	语种 ：en_US
    private String locale;
//    value	String	是	多语言标题内容
    private String value;
}
