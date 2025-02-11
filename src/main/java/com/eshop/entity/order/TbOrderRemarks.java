package com.eshop.entity.order;

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
 * 订单备注信息
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_remarks")
public class TbOrderRemarks implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父留言,如果为0为第一层留言
     */
    private Integer parentId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 备注内容
     */
    private String remark;

    /**
     * 创建人_id
     */
    private Integer createId;

    /**
     * 备注时间
     */
    private LocalDateTime createTime;
}
