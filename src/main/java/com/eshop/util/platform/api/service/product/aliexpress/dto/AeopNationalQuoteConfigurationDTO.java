package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:50
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopNationalQuoteConfigurationDTO {
    //configuration_data	String	否	jsonArray格式的分国家定价规则数据。 [{"absoluteQuoteMap":{"14:173":"1.0"},"shiptoCountry":"RU"},{"absoluteQuoteMap":{"14:173":"2.0"},"shiptoCountry":"US"}] 其中shiptoCountry：ISO两位的国家编码（目前支持国家：RU US CA ES FR UK NL IL BR CL AU UA BY JP TH SG KR ID MY PH VN IT DE SA AE PL TR）， absoluteQuoteMap：价格调整信息，为map结构，其中的key为商品查询sku中的id字段，示例为"<none>", "14:173", "14:173;3:2034781"；值则为具体的按照configuration_type设置的数据 percentage：相对于基准价的调价比例（百分比整数，支持负数，当前限制>=-50）; relative: 相对基准价的调整值，支持负数; absolute：直接设置具体数值，必须大于零。注意计算得到的分国家报价必须大于零，不能传空。
    private String configuration_data;
    //configuration_type	String	否	分国家定价规则类型[percentage：基于基准价格按比例配置; relative:相对原价涨或跌多少；absolute：按照具体报价配置 ;delete ：删除分国家报价]
    private String configuration_type;
}
