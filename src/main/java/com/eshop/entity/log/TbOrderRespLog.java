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
 * 订单请求日志
 * </p>
 *
 * @author log
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_resp_log")
public class TbOrderRespLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 返回json
     */
    private String respBody;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;
}
