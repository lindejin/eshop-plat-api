package com.eshop.entity.logistics;

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
 * 物流方式
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_mode")
public class TbLogisticsMode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物流服务商(一对多)
     */
    private Long facilitatorId;

    /**
     * 回邮地址id
     */
    private Long mailingId;

    /**
     * 渠道名称/物流方式名称
     */
    private String channeName;

    /**
     * 渠道别名/分拣码
     */
    private String channeAlias;

    /**
     * 渠道类型
     */
    private String channelType;

    /**
     * 渠道代码
     */
    private String channelCode;

    /**
     * 运单过期时间(天)
     */
    private Long waybillNoExpirationTime;

    /**
     * 查询地址
     */
    private String queryAddress;

    /**
     * 折扣
     */
    private Double discount;

    /**
     * 运费类型(1:固定运费,2:自定义运费)
     */
    private Byte freightType;

    /**
     * 是否停用,1:未停用,2:已停用
     */
    private Byte channelStatus;

    /**
     * 是否快速出库
     */
    private Byte isFastDelivery;

    /**
     * 最大重量单位千克
     */
    private Double maxWeight;

    /**
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 最后修改人id
     */
    private Long lastUpdateId;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 申报类型,1:虚拟申报,2:实际重量申报
     */
    private Byte declarationType;

    /**
     * 是否计算预估运费（1.是 2.否）
     */
    private Byte isCountFreightFee;
}
