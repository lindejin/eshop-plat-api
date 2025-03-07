package com.eshop.entity.supply;

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
 * 采购平台账号授权
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_platform_account")
public class TbPlatformAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号id
     */
    private String userId;

    /**
     * 账号名称
     */
    private String userName;

    /**
     * 授权过期时间
     */
    private Date expirationTime;

    /**
     * 授权状态(1:有效,2:无效)
     */
    private Byte authorizationStatus;
}
