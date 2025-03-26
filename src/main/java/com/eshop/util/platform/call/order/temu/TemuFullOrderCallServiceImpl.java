package com.eshop.util.platform.call.order.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.order.temu.TemuFullOrderCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullOrderPurchaseOrderV2ReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullOrderPurchaseOrderV2RespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuFullOrderCallServiceImpl implements TemuFullOrderCallService {

    @Autowired
    private TemuFullOrderCall temuFullOrderCall;

    @Override
    public TemuFullOrderPurchaseOrderV2RespVO getPurchaseOrderV2(TemuAppClientDTO tcDTO, TemuFullOrderPurchaseOrderV2ReqDTO reqDTO) throws Exception {
        JSONObject jsonParams = getPurchaseOrderV2Json(reqDTO);
        String orderListBody = temuFullOrderCall.getPurchaseOrderV2(tcDTO, jsonParams);
        TemuFullOrderPurchaseOrderV2RespVO respVO = JSONObject.parseObject(orderListBody, TemuFullOrderPurchaseOrderV2RespVO.class);
        if (respVO == null) {
            respVO = new TemuFullOrderPurchaseOrderV2RespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getPurchaseOrderV2Json(TemuFullOrderPurchaseOrderV2ReqDTO reqDTO) throws Exception {
        JSONObject jsonParams = new JSONObject();
        return jsonParams;
    }
}
