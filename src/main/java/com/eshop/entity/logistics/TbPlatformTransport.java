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
 * 平台认可的物流方式
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_platform_transport")
public class TbPlatformTransport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台_编码
     */
    private String platformCode;

    /**
     * 物流方式_编码
     */
    private String transportCode;

    /**
     * 物流方式名称
     */
    private String transportName;

    /**
     * 备注
     */
    private String remark;
}
