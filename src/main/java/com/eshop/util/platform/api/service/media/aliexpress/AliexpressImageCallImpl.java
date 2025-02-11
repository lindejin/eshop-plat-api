package com.eshop.util.platform.api.service.media.aliexpress;

import com.eshop.util.platform.api.service.media.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressImageEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import com.global.iop.util.FileItem;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/6 15:03
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressImageCallImpl implements AliexpressImageCall {


    //上传图片到临时目录
    /**    {
     IopClient client = new IopClient(url, appkey, appSecret);
     IopRequest request = new IopRequest();
     request.setApiName("aliexpress.image.redefining.uploadtempimage");
     request.addFileParameter("file_data",new FileItem("/Users/D ocuments/book.jpg"));
     request.addApiParameter("src_file_name", "1.jpg");
     IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     System.out.println(response.getBody());
     Thread.sleep(10);
     }
     **/
    /**
     * 上传图片到临时目录
     */
    @Override
    public String uploadTempImage(AeAppClientDTO acDTO, AePhotoBankUploadTempImageDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.UPLOAD_TEMP_IMAGE.getApiName());
        request.addFileParameter("file_data", new FileItem(reqDto.getFile_name(), reqDto.getFile_data()));
        request.addApiParameter("src_file_name", reqDto.getFile_name());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //上传图片到临时目录(推荐使用)

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.image.redefining.uploadtempimageforsdk");
     * request.addFileParameter("file_data",new FileItem("/Users/D ocuments/book.jpg"));
     * request.addApiParameter("src_file_name", "1.jpg");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String uploadTempImageForSdk(AeAppClientDTO acDTO, AePhotoBankUploadTempImageDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.UPLOAD_TEMP_IMAGE_FOR_SDK.getApiName());
        request.addFileParameter("file_data", new FileItem(reqDto.getFile_name(), reqDto.getFile_data()));
        request.addApiParameter("src_file_name", reqDto.getFile_name());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //上传图片到图片银行

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.uploadimage");
     * request.addApiParameter("file_name", "0");
     * request.addApiParameter("group_id", "0");
     * request.addFileParameter("image_bytes",new FileItem("/Users/D ocuments/book.jpg"));
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String uploadImage(AeAppClientDTO acDTO, AePhotoBankUploadImageDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.UPLOAD_IMAGE.getApiName());
        request.addApiParameter("file_name", reqDto.getSrc_file_name());
        request.addApiParameter("group_id", reqDto.getGroup_id());
        request.addFileParameter("image_bytes", new FileItem(reqDto.getSrc_file_name(), reqDto.getFile_data()));
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //上传图片到图片银行(推荐使用)

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.uploadimageforsdk");
     * request.addApiParameter("group_id", "0");
     * request.addFileParameter("image_bytes",new FileItem("/Users/D ocuments/book.jpg"));
     * request.addApiParameter("file_name", "0");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String uploadImageForSdk(AeAppClientDTO acDTO, AePhotoBankUploadImageDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.UPLOAD_IMAGE_FOR_SDK.getApiName());
        request.addApiParameter("file_name", reqDto.getSrc_file_name());
        request.addApiParameter("group_id", reqDto.getGroup_id());
        request.addFileParameter("image_bytes", new FileItem(reqDto.getSrc_file_name(), reqDto.getFile_data()));
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //删除未被引用图片

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.delunusephoto");
     * request.addApiParameter("aeop_delete_image_request", "{\"image_repository_id\":\"100403959\"}");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String deleteUnUsePhoto(AeAppClientDTO acDTO, AePhotoBankDeleteUnUsePhotoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.DELETE_UNUSE_PHOTO.getApiName());
        request.addApiParameter("aeop_delete_image_request", reqDto.getAeop_delete_image_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //图片银行列表分页查询

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.listimagepagination");
     * request.addApiParameter("aeop_image_pagination_request", "{\"group_id\":\"0\",\"current_page\":\"0\",\"location_type\":\"0\",\"page_size\":\"0\"}");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String listImagePagination(AeAppClientDTO acDTO, AePhotoBankListImagePaginationDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.LIST_IMAGE_PAGINATION.getApiName());
        request.addApiParameter("aeop_image_pagination_request", reqDto.getAeop_image_pagination_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //查询图片银行分组信息

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.listgroup");
     * request.addApiParameter("group_id", "8401");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String listGroup(AeAppClientDTO acDTO, AePhotoBankListGroupDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.LIST_GROUP.getApiName());
        request.addApiParameter("group_id", reqDto.getGroup_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //根据path查询图片信息

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.queryphotobankimagebypaths");
     * request.addApiParameter("paths", "HTB1rxqmHpXXXXXBXFXXq6xXFXXXm.jpg,HBA1rxqmHpXXXXXBXFXXq6xXFXXXm.jpg");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String queryPhotoBankImageByPaths(AeAppClientDTO acDTO, AePhotoBankQueryPhotoBankImageByPathsDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.QUERY_PHOTO_BANK_IMAGE_BY_PATHS.getApiName());
        request.addApiParameter("paths", reqDto.getPaths());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //获取图片银行信息

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.getphotobankinfo");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String getPhotoBankInfo(AeAppClientDTO acDTO, AePhotoBankGetPhotoBankInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.GET_PHOTO_BANK_INFO.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取白底图

    /**
     * {
     * IopClient client = new IopClient(url, appkey, appSecret);
     * IopRequest request = new IopRequest();
     * request.setApiName("aliexpress.photobank.redefining.wbimage.get");
     * request.addApiParameter("get_wb_image_request", "{\"original_image_url\":\"https://ae01.alicdn.com/kf/H401119d45e2e4e0ab21a28e3e304b65dT.png\"}");
     * IopResponse response = client.execute(request, accessToken, Protocol.TOP);
     * System.out.println(response.getBody());
     * Thread.sleep(10);
     * }
     **/
    @Override
    public String getWbImage(AeAppClientDTO acDTO, AePhotoBankGetWbImageDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressImageEnu.GET_WB_IMAGE.getApiName());
        request.addApiParameter("get_wb_image_request", reqDto.getGet_wb_image_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
