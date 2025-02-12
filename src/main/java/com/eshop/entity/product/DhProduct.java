package com.eshop.entity.product;

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
 * 敦煌商品
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_product")
public class DhProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品编码
     */
    private String spuCode;

    private Long templateId;

    /**
     * 店铺id(0: 从库id,其他: 店铺id)
     */
    private Long shopId;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 1.铺货产品 2.精品产品
     */
    private Byte type;

    /**
     * 产品运费模板id
     */
    private String shippingModelId;

    /**
     * 产品所属产品组id
     */
    private String itemGroupId;

    /**
     * 产品所属语言站点(默认为英文站点,参数值为：EN英文站点,RU俄语站点;示例值：EN)
     */
    private String siteId;

    /**
     * 产品有效期(有效期以天为单位：14,30,90),默认:90
     */
    private Long vaildDay;

    /**
     * 商品定制服务(1，定制logo，2，定制包装，3，定制外形，4，定制颜色，5，定制尺寸，6，定制款式。例如：定制logo和包装 示例值：1,2(用英文逗号隔开)	)
     */
    private String customType;

    /**
     * 产品售后模板id
     */
    private String afterSaleTemplateId;

    /**
     * 产品是否成人性质(2：成人性质商品 3：没有成人性质商品)
     */
    private Byte isSample;

    /**
     * 尺码模板id
     */
    private String sizeTemplateId;

    /**
     * 是否已刊登到店铺(1: 是, 2: 否)
     */
    private Byte isPublish;

    /**
     * 刊登时间
     */
    private Date publishTime;

    /**
     * 敦煌商品编码
     */
    private String itemCode;

    /**
     * 敦煌商品id
     */
    private String itemId;

    /**
     * 刊登失败原因
     */
    private String publishErrInfo;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
