package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/28 17:18
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopEditAeProductMultiLanguageDTO {
    //detail	String	否	商品对应语种的详描
    private String detail;
    //locale	String	是	语种，合法的参数有: ru_RU(俄语);pt_BR(葡语);fr_FR(法语);es_ES(西班牙语);in_ID(印尼语);it_IT(意大利语);de_DE(德语);nl_NL(荷兰语);tr_TR(土耳其语);iw_IL(以色列语);ja_JP(日语);ar_MA(阿拉伯语);th_TH(泰语);vi_VN(越南语);ko_KR(韩语);
    private String locale;
    //mobile_detail	String	否	商品对应语种的无线端详描（json格式），如要清空无线详描请传""空串
    private String mobile_detail;
    //subject	String	否	商品对应语种的标题, 长度控制在1～218个字符之间。
    private String subject;
}
