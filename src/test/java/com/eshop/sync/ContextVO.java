package com.eshop.sync;

import com.eshop.entity.order.TbOrder;
import com.eshop.entity.order.TbWaybillSynErr;
import com.eshop.entity.order.TbWaybillSynRecord;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class ContextVO {
    List<TbWaybillSynErr> waybillSynErrList;
    Set<String> orderNos;
    List<TbOrder> orderList;
    Map<String, TbOrder> orderMap;
    Set<Long> shopIds;
    Map<Long, DhAppClientDTO> appClientDTOMap;
    List<TbWaybillSynRecord> waybillSynRecordList;
    Map<String, TbWaybillSynRecord> synRecordMap;
}
