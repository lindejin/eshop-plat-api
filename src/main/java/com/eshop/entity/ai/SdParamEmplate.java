package com.eshop.entity.ai;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * sd img2img请求参数模版
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 */
@TableName("sd_param_emplate")
public class SdParamEmplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型：1.换背景 2.换模特
     */
    private Byte type;

    /**
     * 正面描述
     */
    private String prompt;

    /**
     * 反面描述
     */
    private String negativePrompt;

    /**
     * CILP跳过层
     */
    private Integer nIter;

    /**
     * 蒙版边缘模糊度
     */
    private Integer maskBlur;

    /**
     * 仅蒙版区域下边缘预留像素
     */
    private Integer inpaintFullResPadding;

    /**
     * 迭代步数
     */
    private Integer steps;

    /**
     * 采样方式
     */
    private String styles;

    /**
     * 重绘尺寸倍数
     */
    private Integer imageCfgScale;

    /**
     * 提示词引导系数
     */
    private Integer cfgScale;

    /**
     * 预处理器
     */
    private String module;

    /**
     * controlNet模型
     */
    private String model;

    /**
     * 中文简称
     */
    private String chinaName;

    /**
     * 重绘类型：0.整张图片 1.仅蒙版区域
     */
    private Boolean inpaintingFill;

    /**
     * 重绘幅度
     */
    private String denoisingStrength;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 是否删除 1.是 2.否
     */
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getNegativePrompt() {
        return negativePrompt;
    }

    public void setNegativePrompt(String negativePrompt) {
        this.negativePrompt = negativePrompt;
    }

    public Integer getnIter() {
        return nIter;
    }

    public void setnIter(Integer nIter) {
        this.nIter = nIter;
    }

    public Integer getMaskBlur() {
        return maskBlur;
    }

    public void setMaskBlur(Integer maskBlur) {
        this.maskBlur = maskBlur;
    }

    public Integer getInpaintFullResPadding() {
        return inpaintFullResPadding;
    }

    public void setInpaintFullResPadding(Integer inpaintFullResPadding) {
        this.inpaintFullResPadding = inpaintFullResPadding;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public Integer getImageCfgScale() {
        return imageCfgScale;
    }

    public void setImageCfgScale(Integer imageCfgScale) {
        this.imageCfgScale = imageCfgScale;
    }

    public Integer getCfgScale() {
        return cfgScale;
    }

    public void setCfgScale(Integer cfgScale) {
        this.cfgScale = cfgScale;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    public Boolean getInpaintingFill() {
        return inpaintingFill;
    }

    public void setInpaintingFill(Boolean inpaintingFill) {
        this.inpaintingFill = inpaintingFill;
    }

    public String getDenoisingStrength() {
        return denoisingStrength;
    }

    public void setDenoisingStrength(String denoisingStrength) {
        this.denoisingStrength = denoisingStrength;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "SdParamEmplate{" +
        ", id = " + id +
        ", type = " + type +
        ", prompt = " + prompt +
        ", negativePrompt = " + negativePrompt +
        ", nIter = " + nIter +
        ", maskBlur = " + maskBlur +
        ", inpaintFullResPadding = " + inpaintFullResPadding +
        ", steps = " + steps +
        ", styles = " + styles +
        ", imageCfgScale = " + imageCfgScale +
        ", cfgScale = " + cfgScale +
        ", module = " + module +
        ", model = " + model +
        ", chinaName = " + chinaName +
        ", inpaintingFill = " + inpaintingFill +
        ", denoisingStrength = " + denoisingStrength +
        ", createTime = " + createTime +
        ", isDelete = " + isDelete +
        "}";
    }
}
