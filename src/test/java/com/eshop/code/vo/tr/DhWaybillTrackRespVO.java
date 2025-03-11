package com.eshop.code.vo.tr;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DhWaybillTrackRespVO {

    /**
     * 物流信息列表

     */
    private List<DhWaybillFrtTrackInfoListItem> frtTrackInfoList;

}