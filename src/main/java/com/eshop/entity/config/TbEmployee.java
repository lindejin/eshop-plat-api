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
 * 用户表
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_employee")
public class TbEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 密码(MD5)
     */
    private String password;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 邮箱地址
     */
    private String emailAddress;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户头像id
     */
    private Integer avatarId;

    /**
     * 状态：
1、在岗
 2、离岗
     */
    private Byte status;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除人
     */
    private Long deleteId;

    /**
     * 逻辑删除字段(1: 删除, 2: 未删除)
     */
    private Byte isDelete;
}
