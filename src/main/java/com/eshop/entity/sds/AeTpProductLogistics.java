package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 速卖通产品物流信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("ae_tp_product_logistics")
public class AeTpProductLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 是否自定义计重.true(数据库存储1)为自定义计重,false(数据库存储0)反之.
     */
    private Byte isPackSell;

    /**
     * isPackSell为true时,此项必填。 每增加件数.取值范围1-1000。
     */
    private Integer addUnit;

    /**
     * isPackSell为true时,此项必填。 对应增加的重量.取值范围:0.001-500.000,保留三位小数,采用进位制,单位:公斤。
     */
    private BigDecimal addWeight;

    /**
     * isPackSell为true时,此项必填。购买几件以内不增加运费。取值范围1-1000
     */
    private Integer baseUnit;

    /**
     * 备货期(发货期)。取值范围:1-7;单位:天。 部分特殊类目是1-30天
     */
    private Byte deliveryTime;

    /**
     * 商品毛重,取值范围:0.001-500.000,保留三位小数,采用进位制,单位:公斤。
     */
    private BigDecimal grossWeight;

    /**
     * 商品包装高度。取值范围:1-700,单位:厘米。
     */
    private Integer packageHeight;

    /**
     * 商品包装长度。取值范围:1-700,单位:厘米。产品包装尺寸的最大值+2×（第二大值+第三大值）不能超过2700厘米。
     */
    private Integer packageLength;

    /**
     * 商品包装宽度。取值范围:1-700,单位:厘米。
     */
    private Integer packageWidth;

    /**
     * 服务模板设置。
     */
    private Integer promiseTemplateId;

    /**
     * 运费模版ID。通过运费接口listFreightTemplate获取。
     */
    private Long freightTemplateId;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
