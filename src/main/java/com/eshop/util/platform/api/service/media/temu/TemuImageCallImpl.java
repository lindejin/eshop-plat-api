package com.eshop.util.platform.api.service.media.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.media.temu.dto.TemuGoodsTextToPictureAddReqDTO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuImageCallImpl implements TemuImageCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuGoodsTextToPictureAddRespVO goodsTextToPictureAdd(TemuAppClientDTO temuAcDTO, TemuGoodsTextToPictureAddReqDTO reqDTO) throws Exception {
        String type = "bg.goods.texttopicture.add";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuGoodsTextToPictureAddRespVO.class,
                reqDTO
        );
    }
}
