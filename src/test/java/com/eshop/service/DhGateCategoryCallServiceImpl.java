package com.eshop.service;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.category.dhgate.DhGateCategoryCall;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuOrderPoListRespVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DhGateCategoryCallServiceImpl implements DhGateCategoryCallService{

    @Resource
    private DhGateCategoryCall dhGateCategoryCall;

    @Override
    public DhCategoryListVO getCategoryList(DhAppClientDTO publicDto, DhCategoryListDTO dto) throws Exception {
        JSONObject jsonParams = getCategoryListJsonParams(dto);
        String reBody = dhGateCategoryCall.getCategoryList(publicDto, jsonParams);
        DhCategoryListVO respVO = JSONObject.parseObject(reBody, DhCategoryListVO.class);
        if (respVO == null) {
            respVO = new DhCategoryListVO();
        }
        System.out.println(reBody);
        respVO.setRespBody(reBody);
        return respVO;
    }

    private JSONObject getCategoryListJsonParams(DhCategoryListDTO dto) throws Exception {
        JSONObject jsonParams = new JSONObject();
        jsonParams.put("parentId",dto.getParentId());
        return jsonParams;
    }
}
