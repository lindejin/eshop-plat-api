package com.eshop.entity.logistics;

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
 * 物流服务商对接信息
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_facilitator_join")
public class TbFacilitatorJoin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物流服务商id
     */
    private Integer facilitatorId;

    /**
     * 授权日期
     */
    private LocalDateTime joinDate;

    /**
     * 调用参数
     */
    private String paramJson;
}
