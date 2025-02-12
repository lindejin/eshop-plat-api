package com.eshop.entity.log;

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
 * 
 * </p>
 *
 * @author log
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_log")
public class TbLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业编号
     */
    private Long companyId;

    /**
     * 类型:用户登录日志:1,订单:11,采购:12,商品:13,模板:14,主商品:15,平台商品:16,
     */
    private Byte type;

    /**
     * 业务Id
     */
    private Long sourceId;

    /**
     * 日志格式以json格式保存，并压缩:{"description":"描述","operId":"操作员","timeCreated":"2021-04-01 06:36:28","type":11}
     */
    private String content;

    /**
     * 创建时间
     */
    private Date timeCreated;

    /**
     * 创建时间Unix格式
     */
    private Long timeCreatedUnix;
}
