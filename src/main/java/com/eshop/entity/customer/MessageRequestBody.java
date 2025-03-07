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
 * 请求数据存储
 * </p>
 *
 * @author customer
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("message_request_body")
public class MessageRequestBody implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 平台请求参数
     */
    private String requestParams;

    /**
     * 请求类型
     */
    private Byte requestType;

    /**
     * 请求返回结果
     */
    private String responseDetail;

    /**
     * 请求日期
     */
    private Date requestTime;

    /**
     * 请求人
     */
    private Long requestId;
}
