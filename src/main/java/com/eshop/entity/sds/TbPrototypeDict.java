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
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_dict")
public class TbPrototypeDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 样机_id
     */
    private Long prototypeId;

    /**
     * 词典_id
     */
    private Long dictId;

    /**
     * 词典值_id
     */
    private Long dictValId;

    /**
     * 款式商品_id
     */
    private Long styleProductId;
}
