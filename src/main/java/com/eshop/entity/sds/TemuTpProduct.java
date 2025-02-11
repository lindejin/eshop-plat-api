package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * temu模版基础信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_tp_product")
public class TemuTpProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模版id
     */
    private Integer templateId;

    /**
     * 平台类目id
     */
    private String cateId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品名称(英文)
     */
    private String productNameEn;

    /**
     * 货品关务标签名称
     */
    private String goodsLabelName;

    /**
     * 是否使用推荐标签
     */
    private Byte isRecommendedTag;

    /**
     * 货品产地国家二字码(日本站点发品必须传产地)
     */
    private String countryShortName;

    /**
     * 站外商品链接
     */
    private String outerGoodsUrl;

    /**
     * 外包装类型(0:硬包装, 1:软包装+硬物, 2:软包装+软物)
     */
    private Byte packageType;

    /**
     * 外包装形状(0:不规则形状, 1:长方体, 2:圆柱体)
     */
    private Byte packageShape;

    /**
     * 是否定制品(0:非定制品, 1:定制品)
     */
    private Byte personalizationSwitch;

    /**
     * 运费模板id(半托商品配送信息)
     */
    private String freightTemplateId;

    /**
     * 承诺发货时间(单位:s)可选值：86400(2天)，172800(4天)
     */
    private String shipmentLimitSecond;

    /**
     * 发品渠道
     */
    private Integer addProductChannelType;

    /**
     * 模版类型 1.半托 2.全托
     */
    private Byte templateType;

    /**
     * 尺码表Id
     */
    private String sizeTemplateId;

    /**
     * 模特Id
     */
    private Long modelId;

    /**
     * 模特试穿心得  1:舒适,2:紧身,3:宽松
     */
    private Integer tryOnResult;

    /**
     * 模特试穿尺码名称
     */
    private String sizeValName;

    /**
     * 套装尺码表展示, 尺码表模板id入参
     */
    private String showSizeTemplateIds;

    /**
     * 站点Id
     */
    private Integer siteId;

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 产地省份
     */
    private String region2Id;
}
