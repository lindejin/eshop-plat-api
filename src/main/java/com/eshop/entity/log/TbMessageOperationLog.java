package com.eshop.entity.log;

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
 * 消息操作日志表
 * </p>
 *
 * @author log
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_message_operation_log")
public class TbMessageOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 消息记录表
     */
    private Long messageRecordId;

    /**
     * 运行属性/运行描述
     */
    private String operationProperty;

    /**
     * 描述
     */
    private String operationDetail;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private Date operateTime;
}
