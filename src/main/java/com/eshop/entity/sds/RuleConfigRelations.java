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
 * 规则-配置表-具体配置关系表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("rule_config_relations")
public class RuleConfigRelations implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 配置分项id
     */
    private Long ruleItemConfigId;

    /**
     * 规则ids
     */
    private String configIds;

    /**
     * 条件类型 1.或 2.且 3非
     */
    private Long type;

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
}
