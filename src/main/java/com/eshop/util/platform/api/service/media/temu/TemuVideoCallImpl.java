package com.eshop.util.platform.api.service.media.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.media.temu.dto.*;
import com.eshop.util.platform.api.service.media.temu.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuVideoCallImpl implements TemuVideoCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuVideoUploadSignRespVO goodsVideoUploadSignGet(TemuAppClientDTO temuAcDTO, TemuVideoUploadSignReqDTO reqDTO) throws Exception {
        String type = "bg.goods.video.upload.sign.get";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuVideoUploadSignRespVO.class,
                reqDTO
        );
    }

    @Override
    public TemuVideoUploadResultRespVO goodsBigVideoUploadResultGet(TemuAppClientDTO temuAcDTO, TemuVideoUploadResultReqDTO reqDTO) throws Exception {
        String type = "bg.goods.big.video.upload.result.get";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuVideoUploadResultRespVO.class,
                reqDTO
        );
    }


    @Override
    public TemuVideoStoreVideoUploadRespVO uploadStoreVideo(TemuAppClientDTO appClientDTO, TemuVideoStoreVideoUploadReqDTO uploadReqDTO) throws Exception {
        return null;
    }

    @Override
    public TemuVideoInitRespVO initVideoUpload(TemuAppClientDTO appClientDTO, TemuVideoInitReqDTO initReqDTO) throws Exception {
        return null;
    }

    @Override
    public TemuVideoUploadPartRespVO uploadVideoPart(TemuAppClientDTO appClientDTO, TemuVideoUploadPartReqDTO partReqDTO) throws Exception {
        return null;
    }

    @Override
    public TemuVideoUploadCompleteRespVO completeVideoUpload(TemuAppClientDTO appClientDTO, TemuVideoUploadCompleteReqDTO completeReqDTO) throws Exception {
        return null;
    }

}
