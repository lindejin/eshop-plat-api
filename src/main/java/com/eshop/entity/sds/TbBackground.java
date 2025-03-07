package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 背景
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_background")
public class TbBackground implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 背景分类_id
     */
    private Long classifyId;

    /**
     * 背景名称
     */
    private String backgroundName;

    /**
     * 文件库_id
     */
    private Long fileId;

    /**
     * 背景宽度(px)
     */
    private BigDecimal backgroundWidth;

    /**
     * 背景高度(px)
     */
    private BigDecimal backgroundHeight;

    /**
     * 背景大小(字节 / b)
     */
    private Long backgroundSize;

    /**
     * 是否共享(1: 是, 2:否)
     */
    private Byte isShare;

    /**
     * 背景备注/描述
     */
    private String backgroundRemark;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
