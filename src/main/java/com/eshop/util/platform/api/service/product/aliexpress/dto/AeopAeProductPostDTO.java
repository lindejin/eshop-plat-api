package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ldj
 * @date 2024/3/2 16:28
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductPostDTO {
    //名称	类型	是否必须	描述

    //aeop_qualification_struct_list	Object[]	否	资质信息，
    private List<AeopQualificationStructDTO> aeop_qualification_struct_list;
    //msr_eu_id	String	否	欧盟责任人id，需要调用查询欧盟责任人列表接口：aliexpress.category.eu.responsible.persons.list，获取对应的欧盟责任人列表
    private Number msr_eu_id;
    //ext_param	String	否	json结构的字符串，商品扩展字段。1、当卖家使用了类目预测接口时，不管卖家是否采纳都请传"category_forecast" 参数给我，value是类目预测接口预测的top10类目id按照分数降序并用";"分割。方便后续类目预测算法迭代升级
    private String ext_param;
    //add_unit	Number	否	isPackSell为true时,此项必填。 每增加件数.取值范围1-1000。
    private Number add_unit;
    //add_weight	String	否	isPackSell为true时,此项必填。 对应增加的重量.取值范围:0.001-500.000,保留三位小数,采用进位制,单位:公斤。
    private String add_weight;
    //aeop_a_e_multimedia	Object	否	多媒体对象
    private AeopAeMultimediaDTO aeop_a_e_multimedia;
    //aeop_ae_product_propertys	Object[]	否	产品属性，以json格式进行封装后提交。参看aeopAeProductPropertys数据结构。此字段是否必填，需从类目接口getChildAttributesResultByPostCateIdAndPath获取（即获取到的required来判断属性是否必填），该项只输入普通类目属性数据，不可输入sku类目属性。 对于类目属性包含子类目属性的情况，此处不确认父属性和子属性，即选择任何属性，都以该对象提交。 对于一个属性多个选中值的情况，以多个该对象存放。 其中"attrNameId","attrValueId"为整型(Integer), "attrName", "attrValue"为字符串类型(String)。 1. 当设置一些系统属性时，如果类目自定义了一些候选值，只需要提供"attrNameId"和"attrValueId"即可。例如：{"attrNameId":494, "attrValueId":284}。 2. 当设置一些需要手工输入属性内容时，只需要提供"attrNameId"和"attrValue"即可。例如：{"attrNameId": 1000, "attrValue": "test"} 3. 当设置自定义属性时，需要提供"attrName"和"attrValue"即可。例如: {"attrName": "Color", "attrValue": "red"} 4. 当设置一个Other属性时，需要提供"attrNameId", "attrValueId", "attrValue"三个参数。例如：{"attrNameId": 1000, "attrValueId": 4, "attrValue": "Other Value"}。
    private List<AeopAeProductPropertyDTO> aeop_ae_product_propertys;
    //aeop_ae_product_s_k_us	Object[]	否	列表类型，以json格式来表达。参看aeopAeProductSKUs数据结构。特别提示：新增SKU实际可售库存属性ipmSkuStock，该属性值的合理取值范围为0~999999，如该商品有SKU时，请确保至少有一个SKU是有货状态，也就是ipmSkuStock取值是1~999999，在整个商品纬度库存值的取值范围是1~999999。
    private List<AeopAeProductSkuDTO> aeop_ae_product_s_k_us;
    //aeop_national_quote_configuration	Object	否	商品分国家报价的配置，想删除分国家报价需要传指定的参数： configuration_type = delete：{"configurationType":"delete","configurationData":""}，计算之后的分国家报价不能小于 sku价格（sku_price和aeop_s_k_u_national_discount_price）的 50%，计算后的分国家报价不能小于0也不能为"null"，请isv做好前置校验
    private AeopNationalQuoteConfigurationDTO aeop_national_quote_configuration;
    //base_unit	Number	否	isPackSell为true时,此项必填。购买几件以内不增加运费。取值范围1-1000
    private Number base_unit;
    //bulk_discount	Number	否	批发折扣。扩大100倍，存整数。取值范围:1-99。注意：这是折扣，不是打折率。 如,打68折,则存32。批发最小数量和批发折扣需同时有值或无值。
    private Number bulk_discount;
    //bulk_order	Number	否	批发最小数量 。取值范围2-100000。批发最小数量和批发折扣需同时有值或无值。
    private Number bulk_order;
    //category_id	Number	是	商品所属类目ID。必须是叶子类目，通过类目接口获取。
    private Number category_id;
    //currency_code	String	否	货币单位。如果不提供该值信息，则默认为"USD"；非俄罗斯卖家这个属性值可以不提供。对于俄罗斯海外卖家，该单位值必须提供，如: "RUB"。
    private String currency_code;
    //delivery_time	Number	是	备货期。取值范围:1-7;单位:天。 部分特殊类目是1-30天
    private Number delivery_time;
    //detail_source_list	Object[]	是	商品详描
    private List<AeopDetailSourceDTO> detail_source_list;
    //gross_weight	String	是	商品毛重,取值范围:0.001-500.000,保留三位小数,采用进位制,单位:公斤。
    private String gross_weight;
    //group_id	Number	否	这个产品需要关联的产品分组ID. 只能关联一个产品分组，如果想关联多个产品分组，请使用api.setGroups接口。
    private Number group_id;
    //image_u_r_ls	String	是	产品的主图URL列表。如果这个产品有多张主图，那么这些URL之间使用英文分号(";")隔开。一个产品最多只能有6张主图。图片格式JPEG，文件大小5M以内；图片像素建议大于800*800；横向和纵向比例建议1:1到1:1.3之间；图片中产品主体占比建议大于70%；背景白色或纯色，风格统一；如果有LOGO，建议放置在左上角，不宜过大。不建议自行添加促销标签或文字。切勿盗用他人图片，以免受网规处罚。更多说明请至http://seller.aliexpress.com/so/tupianguifan.php进行了解。图片格式只允许jpg、png、jpeg这3种格式
    private String image_u_r_ls;
    //is_pack_sell	Boolean	否	是否自定义计重.true为自定义计重,false反之.
    private Boolean is_pack_sell;
    //locale	String	是	商品原发locale，标记商品的发布初始locale，用于标记初始发布语种
    private String locale;
    //lot_num	Number	否	每包件数。 打包销售情况，lotNum>1,非打包销售情况,lotNum=1
    private Number lot_num;
    //package_height	Number	是	商品包装高度。取值范围:1-700,单位:厘米。
    private Number package_height;
    //package_length	Number	是	商品包装长度。取值范围:1-700,单位:厘米。产品包装尺寸的最大值+2×（第二大值+第三大值）不能超过2700厘米。
    private Number package_length;
    //package_type	Boolean	是	打包销售: true 非打包销售:false
    private Boolean package_type;
    //package_width	Number	是	商品包装宽度。取值范围:1-700,单位:厘米。
    private Number package_width;
    //product_price	String	否	商品默认价格。取值范围:0-100000,保留两位小数;单位:美元。如:200.07，表示:200美元7分。需要在正确的价格区间内。上传多属性产品的时候，有好几个SKU和价格，productprice无需填写。
    private String product_price;
    //product_unit	Number	否	商品单位 (存储单位编号) 100000000:袋 (bag/bags)100000001:桶 (barrel/barrels)100000002:蒲式耳 (bushel/bushels)100078580:箱 (carton)100078581:厘米 (centimeter)100000003:立方米 (cubic meter)100000004:打 (dozen)100078584:英尺 (feet)100000005:加仑 (gallon)100000006:克 (gram)100078587:英寸 (inch)100000007:千克 (kilogram)100078589:千升 (kiloliter)100000008:千米 (kilometer)100078559:升 (liter/liters)100000009:英吨 (long ton)100000010:米 (meter)100000011:公吨 (metric ton)100078560:毫克 (milligram)100078596:毫升 (milliliter)100078597:毫米 (millimeter)100000012:盎司 (ounce)100000014:包 (pack/packs)100000013:双 (pair)100000015:件/个 (piece/pieces)100000016:磅 (pound)100078603:夸脱 (quart)100000017:套 (set/sets)100000018:美吨 (short ton)100078606:平方英尺 (square feet)100078607:平方英寸 (square inch)100000019:平方米 (square meter)100078609:平方码 (square yard)100000020:吨 (ton)100078558:码 (yard/yards)
    private Number product_unit;
    //promise_template_id	Number	是	服务模板设置。（需和服务模板查询接口api.queryPromiseTemplateById进行关联使用）
    private Number promise_template_id;
    //reduce_strategy	String	是	库存扣减策略，总共有2种：下单减库存(place_order_withhold)和支付减库存(payment_success_deduct)。
    private String reduce_strategy;
    //sizechart_id	Number	否	尺码表模版ID。必须选择当前类目下的尺码模版。
    private Number sizechart_id;
    //subject_list	Object[]	是	商品多语言标题
    private List<AeopSubjectDTO> subject_list;
    //ws_valid_num	Number	否	商品有效天数。取值范围:1-7,单位:天。
    private Number ws_valid_num;
    //market_images	Object[]	否	营销图列表
    private List<AeopMarketImageDTO> market_images;
    //freight_template_id	Number	否	运费模版ID。通过运费接口listFreightTemplate获取。
    private Number freight_template_id;
    //mode_size_chart_list	Object[]	否	模特尺码标，最多支持5个,单位厘米
    private List<AeopModeSizeChartDTO> mode_size_chart_list;
}
