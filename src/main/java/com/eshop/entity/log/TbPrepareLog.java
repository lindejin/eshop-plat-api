package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 备货单日志
 * </p>
 *
 * @author log
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_prepare_log")
public class TbPrepareLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 备货单号 
     */
    private Long prepareNo;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;
}
