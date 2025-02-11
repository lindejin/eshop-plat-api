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
 * 平台内部消息
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_eshopmessage")
public class TbEshopmessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String name;

    /**
     * 模块
     */
    private String module;

    /**
     * 内容
     */
    private String detail;

    /**
     * 有效期
     */
    private LocalDateTime expiryTime;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     * 是否开启,1:开启, 2:关闭
     */
    private Byte flag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人Id
     */
    private Integer createOperId;

    /**
     * 是否置顶,1:置顶,2:不置顶
     */
    private Byte top;
}
