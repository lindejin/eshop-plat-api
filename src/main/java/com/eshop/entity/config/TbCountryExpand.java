package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 国家代码,区号
 * </p>
 *
 * @author config
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_country_expand")
public class TbCountryExpand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long countryId;

    /**
     * 国家英文名
     */
    private String countryEnName;
}
