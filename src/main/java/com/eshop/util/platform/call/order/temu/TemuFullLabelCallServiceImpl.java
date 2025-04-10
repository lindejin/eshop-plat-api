package com.eshop.util.platform.call.order.temu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.eshop.util.platform.api.service.order.temu.TemuFullLabelCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullGoodsCustomLabelReqDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullGoodsLabelV2ReqDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullLogisticsBoxMarkInfoReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullGoodsCustomLabelRespVO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullGoodsLabelV2RespVO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullLogisticsBoxMarkInfoRespVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TemuFullLabelCallServiceImpl implements TemuFullLabelCallService {

    @Resource
    private TemuFullLabelCall temuFullLabelCall;

    @Override
    public TemuFullGoodsLabelV2RespVO getGoodsLabelV2(TemuAppClientDTO tcDTO, TemuFullGoodsLabelV2ReqDTO reqDTO) throws Exception {
        JSONObject jsonParams = JSON.parseObject(JSON.toJSONString(reqDTO));
        String orderListBody = temuFullLabelCall.getGoodsLabelV2(tcDTO, jsonParams);
        TemuFullGoodsLabelV2RespVO respVO = JSON.parseObject(
                orderListBody,
                TemuFullGoodsLabelV2RespVO.class,
                Feature.IgnoreNotMatch  // 关键：允许字段缺失或为null
        );
        if (respVO == null) {
            respVO = new TemuFullGoodsLabelV2RespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    @Override
    public TemuFullGoodsCustomLabelRespVO getGoodsCustomLabel(TemuAppClientDTO tcDTO, TemuFullGoodsCustomLabelReqDTO reqDTO) throws Exception {
        JSONObject jsonParams = JSON.parseObject(JSON.toJSONString(reqDTO));
        String orderListBody = temuFullLabelCall.getGoodsCustomLabel(tcDTO, jsonParams);
        TemuFullGoodsCustomLabelRespVO respVO = JSON.parseObject(
                orderListBody,
                TemuFullGoodsCustomLabelRespVO.class,
                Feature.IgnoreNotMatch  // 关键：允许字段缺失或为null
        );
        if (respVO == null) {
            respVO = new TemuFullGoodsCustomLabelRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    @Override
    public TemuFullLogisticsBoxMarkInfoRespVO getLogisticsBoxMarkInfo(TemuAppClientDTO tcDTO, TemuFullLogisticsBoxMarkInfoReqDTO reqDTO) throws Exception {
        JSONObject jsonParams = JSON.parseObject(JSON.toJSONString(reqDTO));
        String orderListBody = temuFullLabelCall.getGoodsCustomLabel(tcDTO, jsonParams);
        TemuFullLogisticsBoxMarkInfoRespVO respVO = JSON.parseObject(
                orderListBody,
                TemuFullLogisticsBoxMarkInfoRespVO.class,
                Feature.IgnoreNotMatch  // 关键：允许字段缺失或为null
        );
        if (respVO == null) {
            respVO = new TemuFullLogisticsBoxMarkInfoRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }
}
