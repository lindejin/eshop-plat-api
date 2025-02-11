package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AeDetailSourcePostReqDTO
 * @Description 详描列表
 * @Author xxs
 * @Date 2024/6/25 14:31
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeDetailSourcePostReqDTO {
//    mobile_detail	String	否	移动端详描内容，具体格式请参考： https://open.aliexpress.com/doc/doc.htm#/?docId=725
    private String mobile_detail;
//    locale	String	是	详描语种：en_US
    private String locale;
//    web_detail	String	是	PC 端详描内容，注意!!! 对于PC端详描内容校验规则：关联模块(relation)数量至多1个，PC端详描下总信息模块数至多3个，当type=”html"并且其content中包含关联模块(relation)或自定义模块(custom)时，其中的关联模块和自定义模块也会被参与计数，请isv自行排查"html"模块中是否有关联模块(relation)和自定义模块(custom),请isv们做好前置校验，避免重复计数。具体格式请参考：https://open.aliexpress.com/doc/doc.htm#/?docId=725
    private String web_detail;
}
