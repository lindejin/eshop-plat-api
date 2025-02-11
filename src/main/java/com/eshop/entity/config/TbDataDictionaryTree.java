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
 * 数据词典树
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_data_dictionary_tree")
public class TbDataDictionaryTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 词典值
     */
    private String dictionaryVal;

    /**
     * 层级(1: 是最高层级)
     */
    private Byte level;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 是否有子级(1: 是, 2: 否)
     */
    private Boolean isChild;
}
