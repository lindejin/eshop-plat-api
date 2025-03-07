package com.eshop.entity.logistics;

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
 * 物流服务商对接信息
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_facilitator_join")
public class TbFacilitatorJoin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物流服务商id
     */
    private Long facilitatorId;

    /**
     * 授权日期
     */
    private Date joinDate;

    /**
     * 调用参数
     */
    private String paramJson;
}
