package com.eshop.entity.customer;

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
 * 消息记录详情表
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("message_record_detail")
public class MessageRecordDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台_id
     */
    private Integer platformId;

    /**
     * 消息记录表
     */
    private Integer messageRecordId;

    /**
     * 平台上的消息ID
     */
    private Long platformMessageId;

    /**
     * 平台上的消息详情ID
     */
    private Long platformMessageDetailId;

    /**
     * 消息状态
     */
    private Byte platformMessageDetailStatus;

    /**
     * 平台消息详情json
     */
    private String platformMessageDetailJson;

    /**
     * 平台上的客户ID
     */
    private String platformCustomerId;

    /**
     * 平台上的发送人身份(1.系统 2.客户 3.店铺)
     */
    private Byte platformSenderIdentity;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private Integer createId;

    /**
     * 消息发送时间
     */
    private LocalDateTime sendTime;
}
