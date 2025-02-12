package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoListResultResultVO {
    // "totalItemNum": 400,
    private Integer totalItemNum;
    // "pageItems":[]
    private List<TemuOrderPoListPageItemVO> pageItems;
}
