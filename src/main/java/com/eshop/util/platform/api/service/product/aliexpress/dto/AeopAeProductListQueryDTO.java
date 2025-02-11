package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ldj
 * @date 2024/3/7 17:04
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductListQueryDTO {
    //current_page	Number	否	需要商品的当前页数。默认第一页。
    private Number current_page;
    //excepted_product_ids	Number[]	否	被排除在外的商品id,查询结果不返回填入的产品，多个产品id以数组形式填入
    private List<Number> excepted_product_ids;
    //off_line_time	Number	否	商品的剩余有效期。如果想查3天之内即将下架的商品，则offLineTime值为3。
    private Number off_line_time;
    //owner_member_id	String	否	商品所属人loginId
    private String owner_member_id;
    //page_size	Number	否	每页查询商品数量。输入值小于100，默认20。
    private Number page_size;
    //product_id	Number	否	商品id搜索字段。
    private Number product_id;
    //product_status_type	String	是	商品业务状态，目前提供6种，输入参数分别是：上架:onSelling ；下架:offline ；审核中:auditing ；审核不通过:editingRequired；客服删除:service_delete ; 所有删除商品：deleted；
    private String product_status_type;
    //subject	String	否	商品标题模糊搜索字段。只支持半角英数字，长度不超过128。
    private String subject;
    //ws_display	String	否	商品下架原因：expire_offline(过期下架)，user_offline(用户手工下架)、violate_offline(违规下架)、punish_offline(处罚下架)、degrade_offline(降级下架)、industry_offline(行业准入未续约下架)
    private String ws_display;
    //have_national_quote	String	否	是否有差异化报价: y有 n无
    private String have_national_quote;
    //group_id	Number	否	商品分组搜索字段。输入商品分组id(groupId).
    private Number group_id;
    //gmt_create_start	String	否	创建时间开始于，yyyy-MM-dd hh:mm:ss
    private String gmt_create_start;
    //gmt_create_end	String	否	创建时间结束于，yyyy-MM-dd hh:mm:ss
    private String gmt_create_end;
    //gmt_modified_start	String	否	修改时间开始于，yyyy-MM-dd hh:mm:ss
    private String gmt_modified_start;
    //gmt_modified_end	String	否	修改时间结束于，yyyy-MM-dd hh:mm:ss
    private String gmt_modified_end;
}
