package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * temu模版基础信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_product")
public class TemuProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 模版id
     */
    private Long templateId;

    /**
     * 类目id
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
     * 承诺发货时间(单位:s)可选值：86400(1天)，172800(2天)
     */
    private String shipmentLimitSecond;

    /**
     * 发品渠道
     */
    private Long addProductChannelType;

    /**
     * 模特Id
     */
    private Long modelId;

    /**
     * 模特试穿心得  1:舒适,2:紧身,3:宽松
     */
    private Long tryOnResult;

    /**
     * 模特试穿尺码名称
     */
    private String sizeValName;

    /**
     * 套装尺码表展示, 尺码表模板id入参
     */
    private String showSizeTemplateIds;

    /**
     * 店铺Id
     */
    private Long shopId;

    /**
     * 商品类型1.半托 2.全托
     */
    private Byte productType;

    /**
     * 站点Id
     */
    private Long siteId;

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 刊登时间
     */
    private Date publicTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 是否已刊登到店铺1: 待刊登, 2: 刊登成功 3.刊登失败
     */
    private Byte isPublish;

    /**
     * 素材图
     */
    private Long materialImgId;

    /**
     * 尺码表Id
     */
    private String sizeTemplateId;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 产品刊登错误信息
     */
    private String publishErrMsg;

    /**
     * 平台产品id
     */
    private String platformProductId;

    /**
     * 模版类型1.铺货模版 2.精品模版
     */
    private Byte templateType;

    /**
     * 类目类型(1:服装类目,0:非服装)
     */
    private Byte catType;

    /**
     * 产地省份
     */
    private String region2Id;
}
