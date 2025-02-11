package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 样机&词典值
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_dict")
public class TbPrototypeDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 样机_id
     */
    private Integer prototypeId;

    /**
     * 词典_id
     */
    private Integer dictId;

    /**
     * 词典值_id
     */
    private Integer dictValId;

    /**
     * 款式商品_id
     */
    private Integer styleProductId;
}
