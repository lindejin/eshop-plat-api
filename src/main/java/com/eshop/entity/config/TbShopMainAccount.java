package com.eshop.entity.config;

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
 * 店铺主账户
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_shop_main_account")
public class TbShopMainAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台应用_id
     */
    private Integer appId;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 主账号Id
     */
    private String mainAccountId;

    /**
     * 商户名称
     */
    private String name;

    /**
     * 授权状态,1:成功 2失败,-1:未授权
     */
    private Byte tokenFlag;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 密码(AES加密  CBC模式)
     */
    private String password;

    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;

    /**
     * 调用参数_静态_空值
     */
    private String paramStaticJson;

    /**
     * 调用参数_动态_空值
     */
    private String paramDynamicJson;

    /**
     * 创建人
     */
    private Integer createOperId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateOperId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除字段(1: 删除, 2: 未删除)
     */
    private Byte isDelete;

    /**
     * 删除人
     */
    private Long deleteUserId;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
