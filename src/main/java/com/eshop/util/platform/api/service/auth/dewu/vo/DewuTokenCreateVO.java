package com.eshop.util.platform.api.service.auth.dewu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
public class DewuTokenCreateVO extends BaseResponseVO {
    private Long code;
    private String msg;
    private String trace_id;

    private DewuTokenVO data;
}
