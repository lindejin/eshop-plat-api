package com.eshop.entity.sds;

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
 * 关键词值
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_keyword_value")
public class TbKeywordValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户 id
     */
    private Integer merchantId;

    /**
     * 关键词分类 id
     */
    private Integer classifyId;

    /**
     * 关键词 id
     */
    private Integer keywordId;

    /**
     * 分类类型(1: 私有, 2: 公有)
     */
    private Byte copyrightType;

    /**
     * 关键词值
     */
    private String value;

    /**
     * 关键词值备注/描述
     */
    private String remark;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

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
}
