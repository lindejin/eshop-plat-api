package com.eshop.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 物流方式&平台中间表
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_platform_facilitator_mode")
public class TbPlatformFacilitatorMode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物流方式_id
     */
    private Long modeId;

    /**
     * 平台认可物流_id
     */
    private Long transportId;
}
