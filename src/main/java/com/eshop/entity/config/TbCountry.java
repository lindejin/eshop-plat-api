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
@TableName("tb_country")
public class TbCountry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 国家代码缩写 (两位)
     */
    private String countryTwoCode;

    /**
     * 国家代码缩写 (三位)
     */
    private String countryThreeCode;

    /**
     * 国家中文名
     */
    private String countryCnName;

    /**
     * 国家英文名
     */
    private String countryEnName;

    /**
     * 所属大陆/洲
     */
    private String continentName;

    /**
     * 电话代码/国家区号
     */
    private String phoneCode;

    /**
     * 排序
     */
    private Byte sort;
}
