package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 速卖通商品
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_product")
public class AeProduct implements Serializable {

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
     * 模版Id
     */
    private Long templateId;

    /**
     * 类目id
     */
    private String categoryId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 半托管一阶段提交草稿ID
     */
    private Long draftId;

    /**
     * 产品状态1.无托管 2.半托管 3.全托管
     */
    private Byte productStatus;

    /**
     * 是否执行过刊登 0.未执行过(默认) 1.执行过
     */
    private Byte isExecutedPublish;

    /**
     * 产品刊登错误信息
     */
    private String printErrMsg;

    /**
     * 资质信息
     */
    private String aeopQualificationStructList;

    /**
     * 欧盟责任人id
     */
    private Long msrEuId;

    /**
     * jsonArray格式的分国家定价规则数据。
     */
    private String configurationData;

    /**
     * json结构的字符串，商品扩展字段
     */
    private String extParam;

    /**
     * 批发折扣。扩大100倍，存整数。取值范围:1-99。注意：这是折扣，不是打折率。 如,打68折,则存32。批发最小数量和批发折扣需同时有值或无值。
     */
    private Byte bulkDiscount;

    /**
     * 批发最小数量 。取值范围2-100000。批发最小数量和批发折扣需同时有值或无值。
     */
    private Long bulkOrder;

    /**
     * 货币单位。如果不提供该值信息，则默认为"USD"；非俄罗斯卖家这个属性值可以不提供。对于俄罗斯海外卖家，该单位值必须提供，如: "RUB"。
     */
    private String currencyCode;

    /**
     * 这个产品需要关联的产品分组ID. 只能关联一个产品分组，如果想关联多个产品分组，请使用api.setGroups接口。
     */
    private Long groupId;

    /**
     * 商品原发locale，标记商品的发布初始locale，用于标记初始发布语种
     */
    private String locale;

    /**
     * 每包件数。 打包销售情况，lotNum>1,非打包销售情况,lotNum=1
     */
    private Byte lotNum;

    /**
     * 打包销售: true(数据库存储1) 非打包销售:false(数据库存储0)
     */
    private Byte packageType;

    /**
     * 商品默认价格。取值范围:0-100000,保留两位小数;单位:美元
     */
    private BigDecimal productPrice;

    /**
     * 商品单位 (存储单位编号) 100000000:袋 (bag/bags)
     */
    private Long productUnit;

    /**
     * 库存扣减策略，总共有2种：下单减库存(place_order_withhold)和支付减库存(payment_success_deduct)。
     */
    private String reduceStrategy;

    /**
     * 尺码表模版ID。必须选择当前类目下的尺码模版。
     */
    private Long sizechartId;

    /**
     * 商品有效天数。取值范围:1-7,单位:天。
     */
    private Byte wsValidNum;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 刊登时间
     */
    private Date publicTime;

    /**
     * 是否已刊登到店铺1: 是, 2: 否 3.仍需手动重新刊登 4.已上架 5.上架失败 6.已下架 7.下架失败
     */
    private Byte isPublish;

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
     * 平台商品状态 平台商品状态，包括onSelling（正在销售），offline（已下架），auditing（审核中），editingRequired（审核不通过）
     */
    private String platProductStatus;

    /**
     * 托管状态 1.无状态 2.保存草稿成功 3.保存草稿失败 4.半托管成功 5.半托管失败 6.全托管上架成功 7.全托管上架失败
     */
    private Byte tutelageStatus;
}
