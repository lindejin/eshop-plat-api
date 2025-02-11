package com.eshop.util.platform.api.service.media.aliexpress;

import com.eshop.util.platform.api.service.media.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/6 15:03
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressImageCall {

    //上传图片到临时目录
    String uploadTempImage(AeAppClientDTO aeAppClientDTO, AePhotoBankUploadTempImageDTO reqDto) throws ApiException;

    //上传图片到临时目录(推荐使用)
    String uploadTempImageForSdk(AeAppClientDTO aeAppClientDTO, AePhotoBankUploadTempImageDTO reqDto) throws ApiException;

    //上传图片到图片银行
    String uploadImage(AeAppClientDTO aeAppClientDTO, AePhotoBankUploadImageDTO reqDto) throws ApiException;

    //上传图片到图片银行(推荐使用)
    String uploadImageForSdk(AeAppClientDTO aeAppClientDTO, AePhotoBankUploadImageDTO reqDto) throws ApiException;

    //删除未被引用图片
    String deleteUnUsePhoto(AeAppClientDTO aeAppClientDTO, AePhotoBankDeleteUnUsePhotoDTO reqDto) throws ApiException;

    //图片银行列表分页查询
    String listImagePagination(AeAppClientDTO aeAppClientDTO, AePhotoBankListImagePaginationDTO reqDto) throws ApiException;

    //查询图片银行分组信息
    String listGroup(AeAppClientDTO aeAppClientDTO, AePhotoBankListGroupDTO reqDto) throws ApiException;

    //根据path查询图片信息
    String queryPhotoBankImageByPaths(AeAppClientDTO aeAppClientDTO, AePhotoBankQueryPhotoBankImageByPathsDTO reqDto) throws ApiException;

    //获取图片银行信息
    String getPhotoBankInfo(AeAppClientDTO aeAppClientDTO, AePhotoBankGetPhotoBankInfoDTO reqDto) throws ApiException;

    //获取白底图
    String getWbImage(AeAppClientDTO aeAppClientDTO, AePhotoBankGetWbImageDTO reqDto) throws ApiException;
}
