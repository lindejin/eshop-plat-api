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
 * 平台
 * </p>
 *
 * @author config
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_platform")
public class TbPlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 状态：(1: 开启, 2: 关闭)
     */
    private Byte status;

    /**
     * 接口地址
     */
    private String apiPath;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
