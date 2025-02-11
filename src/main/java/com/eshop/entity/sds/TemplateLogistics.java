package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模版物流通道
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("template_logistics")
public class TemplateLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模版Id
     */
    private Integer templateId;

    /**
     * 大小 ID
     */
    private Integer sizeId;

    /**
     * 运费
     */
    private BigDecimal shippingFee;

    /**
     * 是否为此项目启用通道（0.否 1.是）
     */
    private Byte enabled;

    /**
     * 频道的 ID
     */
    private Integer logisticId;

    /**
     * 是否为买家支付运费（0.否 1.是）
     */
    private Byte isFree;
}
