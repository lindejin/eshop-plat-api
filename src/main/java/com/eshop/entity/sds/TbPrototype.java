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
 * 样机
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype")
public class TbPrototype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 样机名称
     */
    private String prototypeName;

    /**
     * 类目_id
     */
    private Long categoryId;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 最大合成数量
     */
    private Long maxSyntheticNumber;

    /**
     * 词典_id(api绘画)
     */
    private Long dictId;

    /**
     * 素材分类_id
     */
    private Long classifyId;

    /**
     * 文本描述
     */
    private String textDescribe;

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
     * 修改时间
     */
    private Date updateTime;
}
