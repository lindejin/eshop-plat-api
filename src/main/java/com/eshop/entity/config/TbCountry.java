package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 国家代码,区号
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_country")
public class TbCountry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryTwoCode() {
        return countryTwoCode;
    }

    public void setCountryTwoCode(String countryTwoCode) {
        this.countryTwoCode = countryTwoCode;
    }

    public String getCountryThreeCode() {
        return countryThreeCode;
    }

    public void setCountryThreeCode(String countryThreeCode) {
        this.countryThreeCode = countryThreeCode;
    }

    public String getCountryCnName() {
        return countryCnName;
    }

    public void setCountryCnName(String countryCnName) {
        this.countryCnName = countryCnName;
    }

    public String getCountryEnName() {
        return countryEnName;
    }

    public void setCountryEnName(String countryEnName) {
        this.countryEnName = countryEnName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "TbCountry{" +
        ", id = " + id +
        ", countryTwoCode = " + countryTwoCode +
        ", countryThreeCode = " + countryThreeCode +
        ", countryCnName = " + countryCnName +
        ", countryEnName = " + countryEnName +
        ", continentName = " + continentName +
        ", phoneCode = " + phoneCode +
        ", sort = " + sort +
        "}";
    }
}
