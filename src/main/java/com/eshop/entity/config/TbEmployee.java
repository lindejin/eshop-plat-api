package com.eshop.entity.config;

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
 * 用户表
 * </p>
 *
 * @author config
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_employee")
public class TbEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户id
     */
    private Long merchantId;

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
    private Long avatarId;

    /**
     * 状态：
1、在岗
 2、离岗
     */
    private Byte status;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除人
     */
    private Long deleteId;

    /**
     * 逻辑删除字段(1: 删除, 2: 未删除)
     */
    private Byte isDelete;
}
