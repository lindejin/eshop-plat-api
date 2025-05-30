package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoInitRespVO extends BaseResponseVO {

    //
    private String sign;

    /**
     * 成功时不返回
     */
    private Integer error_code;

    /**
     * 错误消息
     */
    private String error_msg;
}
