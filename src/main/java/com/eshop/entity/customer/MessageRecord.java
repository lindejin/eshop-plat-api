package com.eshop.entity.customer;

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
 * 消息记录表
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("message_record")
public class MessageRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 店铺_id
     */
    private Long shopId;

    /**
     * 店长/负责人_id
     */
    private Long shopownerId;

    /**
     * 客户_id  (客户信息主键Id)
     */
    private Long customerInfoId;

    /**
     * 平台上的店铺ID
     */
    private String platformShopId;

    /**
     * 平台上的信息标题
     */
    private String platformMessageTitle;

    /**
     * 平台上的收信ID
     */
    private String platformRecieverId;

    /**
     * 平台上的发信ID  (客户信息平台Id)
     */
    private String platformSenderId;

    /**
     * 平台上的消息ID
     */
    private Long platformMessageId;

    /**
     * 平台上的消息类型
     */
    private String platformMessageType;

    /**
     * 平台消息json
     */
    private String platformMessageJson;

    /**
     * 数据来源类型(1: 订单2:站内信3:人工创建)
     */
    private Byte messageSourceType;

    /**
     * 消息状态
     */
    private Byte messageStatus;

    /**
     * 是否作废
     */
    private Byte isDeprecated;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 回复处理人
     */
    private Long replierId;

    /**
     * 发送人是否已读(1是 ,0否)
     */
    private Byte senderRead;

    /**
     * 接收人是否否已读(1是 ,0否)
     */
    private Byte receiverRead;
}
