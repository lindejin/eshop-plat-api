package com.eshop.util.platform.api.service.im.dhpage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel(value = "查询联系人列表 Dto")
public class DhContactListReqDTO {
    //    @ApiModelProperty(value = "第几页,默认第1页", required = false)
    private Integer page;
    //    @ApiModelProperty(value = "每页条数,默认30，最大30", required = false)
    private Integer size;
    //    @ApiModelProperty(value = "按昵称搜索", required = false)
    private String search;
    //    @ApiModelProperty(value = "状态 onlyUnreply：未回复，onlyUnread：未读", required = false, allowableValues = "onlyUnreply, onlyUnread")
    private String filter;
    //    @ApiModelProperty(value = "店铺id", readOnly = false)
    private Long shopId;
}
