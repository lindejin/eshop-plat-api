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
 * 消息回复记录表
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("message_record_reply")
public class MessageRecordReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台_id
     */
    private Integer platformId;

    /**
     * 店铺_id
     */
    private Integer shopId;

    /**
     * 消息记录表id
     */
    private Integer messageRecordId;

    /**
     * 回复平台上的消息ID
     */
    private Long platformMessageId;

    /**
     * 平台上的客户ID
     */
    private String platformCustomerId;

    /**
     * 回复时间
     */
    private LocalDateTime replyTime;

    /**
     * 回复者
     */
    private Integer replyPersonId;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复状态
     */
    private Byte replyStatus;

    /**
     * 附件id集合 多个用逗号分隔
     */
    private String attachmentIds;

    /**
     * 附件id集合 多个用逗号分隔
     */
    private String attachmentUrl;
}
