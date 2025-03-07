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
 * 规则-阶段表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("rule_stage")
public class RuleStage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 阶段名称
     */
    private String name;

    /**
     * 阶段天数
     */
    private Long day;

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
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
