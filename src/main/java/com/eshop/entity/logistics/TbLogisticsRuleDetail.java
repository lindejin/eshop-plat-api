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
 * 
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_rule_detail")
public class TbLogisticsRuleDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 明细ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联到规则ID，外键
     */
    private Long logisticsRuleId;

    /**
     * 国家代码缩写 (两位)
     */
    private String countryTwoCode;

    /**
     * 小于等于金额
     */
    private BigDecimal minAmount;

    /**
     * 大于等于金额
     */
    private BigDecimal maxAmount;

    /**
     * 材质，逗号分隔的集合
     */
    private String materialIds;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否激活（1是 0否）
     */
    private Byte isActive;
}
