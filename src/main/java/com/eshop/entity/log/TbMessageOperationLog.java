package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消息操作日志表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_message_operation_log")
public class TbMessageOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息记录表
     */
    private Integer messageRecordId;

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
    private LocalDateTime operateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageRecordId() {
        return messageRecordId;
    }

    public void setMessageRecordId(Integer messageRecordId) {
        this.messageRecordId = messageRecordId;
    }

    public String getOperationProperty() {
        return operationProperty;
    }

    public void setOperationProperty(String operationProperty) {
        this.operationProperty = operationProperty;
    }

    public String getOperationDetail() {
        return operationDetail;
    }

    public void setOperationDetail(String operationDetail) {
        this.operationDetail = operationDetail;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "TbMessageOperationLog{" +
        ", id = " + id +
        ", messageRecordId = " + messageRecordId +
        ", operationProperty = " + operationProperty +
        ", operationDetail = " + operationDetail +
        ", operator = " + operator +
        ", operateTime = " + operateTime +
        "}";
    }
}
