package com.eshop.util.platform.api.service.order.dewu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class DewuExpressSheetRespVO extends BaseResponseVO {

    //    "code" int
    private Integer code;
    //    "msg" String
    private String msg;
    //    "data" list
    private List<DewuExpressSheetVO> data;
    //    "trace_id" String
    private String trace_id;
}
