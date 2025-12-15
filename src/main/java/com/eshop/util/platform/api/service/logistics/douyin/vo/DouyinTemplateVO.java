package com.eshop.util.platform.api.service.logistics.douyin.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class DouyinTemplateVO {

    /**
     * 物流公司
     */
    private String logistics_code;

    /**
     * 模板信息
     */
    private List<DouyinTemplateInfoVO> template_infos;

}
