package com.eshop.util.platform.api.service.product.aliexpress;

import com.eshop.util.platform.api.service.product.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/6 17:14
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressProductCall {

    //批量产品价格更新
    String batchProductPriceUpdate(AeAppClientDTO aeAppClientDTO, AeProductBatchProductPriceUpdateDTO reqDto) throws ApiException;

    //用于编辑产品
    //用于编辑产品的API，为海外商家定制。此 API 的大多数输入字段与 aliexpress.solution.product.post 类似。对于编辑，只需填写您要编辑的字段，其他字段留空即可
    String productEdit(AeAppClientDTO aeAppClientDTO, AeProductProductEditDTO reqDto) throws ApiException;

    //获取单一产品信息
    String productInfoGet(AeAppClientDTO aeAppClientDTO, AeProductProductInfoGetDTO reqDto) throws ApiException;

    //获取产品列表
    String productListGet(AeAppClientDTO aeAppClientDTO, AeProductProductListGetDTO reqDto) throws ApiException;

    //特定 Feed 失效
    //用于根据作业 ID 使特定 Feed 失效的 API。请使用 （aliexpress.solution.feed.list.get） 来确定需要发送哪些作业 ID 进行失效。
    String feedInvalidate(AeAppClientDTO aeAppClientDTO, AeProductFeedInvalidateDTO reqDto) throws ApiException;

    //产品发布 API
    //面向海外商家的产品发布API，简化了卖家和商家面临的整合复杂性。例如，这些卖家可以使用自己的类别和属性，而不是映射 AE 中的类别和属性。
    String productPost(AeAppClientDTO aeAppClientDTO, AeProductProductPostDTO reqDto) throws ApiException;

    //基于json schema实例上传产品
    //基于json schema实例上传产品。该接口的QPS（Invoke per s）每个appkey限制为100个，每个卖家限制为50个。
    String schemaProductInstancePost(AeAppClientDTO aeAppClientDTO, AeProductSchemaProductInstancePostDTO reqDto) throws ApiException;

    //查询草稿箱里的产品信息
    //描述：根据商品id查询单个商品的详细信息。
    String draftProductGet(AeAppClientDTO aeAppClientDTO, AeProductDraftProductGetDTO reqDto) throws ApiException;

    //删除除草稿框外的在线产品
    //该接口用于删除除草稿框外的在线产品。请注意，没有相反的方法可以检索已删除的产品。谨慎使用此 API。
    String batchProductDelete(AeAppClientDTO aeAppClientDTO, AeProductBatchProductDeleteDTO reqDto) throws ApiException;

    //面向海外卖家的批量产品库存更新 API。卖家可以在一次通话中更新多个产品中的多个 SKU。最多可以同时更新 20 个产品，一个产品最多可以更新 200 个 SKU。
    //批量产品库存更新
    String batchProductInventoryUpdate(AeAppClientDTO aeAppClientDTO, AeProductBatchProductInventoryUpdateDTO reqDto) throws ApiException;

    //查询属于卖家的 Feed 列表
    //描述：查询属于卖家的 Feed 列表的 API
    String feedListGet(AeAppClientDTO aeAppClientDTO, AeProductFeedListGetDTO reqDto) throws ApiException;

    //查询Feed执行结果
    //用于查询Feed执行结果的API
    String feedQuery(AeAppClientDTO aeAppClientDTO, AeProductFeedQueryDTO reqDto) throws ApiException;

    //供商家提交 Feed 数据
    //供商家提交 Feed 数据的 API。请注意，对于每个卖家，每 24 小时为每operation_type提交的 Feed 建议数量应大于 150 条，否则处理 Feed 可能会遇到明显的延迟。
    String feedSubmit(AeAppClientDTO aeAppClientDTO, AeProductFeedSubmitDTO reqDto) throws ApiException;

    //物流ISV的API，用于根据产品类别获取hscode。
    //用于根据产品类别获取hscode
    String hsCodeQuery(AeAppClientDTO aeAppClientDTO, AeProductHsCodeQueryDTO reqDto) throws ApiException;

    //海外卖家获取正常信息
    //描述：API为海外卖家获取正常信息，如店铺ID、注册国家代码等。
    String merchantProfileGet(AeAppClientDTO aeAppClientDTO, AeProductMerchantProfileGetDTO reqDto) throws ApiException;

    //产品全量更新
    //产品全量更新的架构接口。该接口的QPS（Invoke per s）每个appkey限制为100个，每个卖家限制为50个。
    String schemaProductFullUpdate(AeAppClientDTO aeAppClientDTO, AeProductSchemaProductFullUpdateDTO reqDto) throws ApiException;

    //获取产品架构
    //提供一种新的模式方式来发布产品。使用一对 API，一个用于获取架构，一个用于发布实例
    String productSchemaGet(AeAppClientDTO aeAppClientDTO, AeProductProductSchemaGetDTO reqDto) throws ApiException;

    //修改商品所引用的尺码模板
    //描述：修改商品所引用的尺码模板
    String setSizeChart(AeAppClientDTO aeAppClientDTO, AeProductSetSizeChartDTO reqDto) throws ApiException;

    //修改编辑商品信息
    //描述：商品编辑接口（修改任何一个商品信息时，必须将其他所有信息进行填写全面后再提交，否则会出现报错或数据丢失问题）
    String editAeProduct(AeAppClientDTO aeAppClientDTO, AeProductEditAeProductDTO reqDto) throws ApiException;

    //分页查询待优化商品列表
    //描述：分页查询待优化商品列表
    String productDiagnosisPageQueryProblem(AeAppClientDTO aeAppClientDTO, AeProductProductDiagnosisPageQueryProblemDTO reqDto) throws ApiException;

    //创建产品分组
    //描述：创建一个新的产品分组.一个用户的一级分组最多有10个，二级分组最多有10个。
    String createProductGroup(AeAppClientDTO aeAppClientDTO, AeProductCreateProductGroupDTO reqDto) throws ApiException;

    //发布产品信息
    //描述：post产品并且返回post成功后的产品的id
    String postAeProduct(AeAppClientDTO aeAppClientDTO, AeProductPostAeProductDTO reqDto) throws ApiException;

    //发布多语言产品(试用)
    //描述：多语言原发接口。卖家可以通过这个接口发布一个多语言商品。一次只能发布一种多语言商品，例如：俄文。
    String postMultiLanguageAeProduct(AeAppClientDTO aeAppClientDTO, AeProductPostMultiLanguageAeProductDTO reqDto) throws ApiException;

    //商品上架
    //述：上架一个或者多个商品，待上架的产品ID通过参数productIds指定，产品ID之间使用英文分号（;)隔开, 最多一次只能上架50个商品
    String onlineAeProduct(AeAppClientDTO aeAppClientDTO, AeProductOnlineAeProductDTO reqDto) throws ApiException;

    //商品下架
    //描述：商品下架接口。需要下架的商品的通过productIds参数指定，多个商品之间用英文分号隔开。
    String offlineAeProduct(AeAppClientDTO aeAppClientDTO, AeProductOfflineAeProductDTO reqDto) throws ApiException;

    //商品分组设置
    //描述：设置单个产品的产品分组信息，最多设置三十个分组。
    String setGroups(AeAppClientDTO aeAppClientDTO, AeProductSetGroupsDTO reqDto) throws ApiException;

    //商品列表查询接口
    //描述：商品列表查询接口。主账号可查询所有商品，子账号只可查询自身所属商品。
    String findProductInfoListQuery(AeAppClientDTO aeAppClientDTO, AeProductFindProductInfoListQueryDTO reqDto) throws ApiException;

    //商品删除接口
    //描述：商品删除接口，注意：删除的商品不能恢复，请慎重删除
    String productDelete(AeAppClientDTO aeAppClientDTO, AeProductProductDeleteDTO reqDto) throws ApiException;

    //商品发布新接口
    //描述：post产品并且返回post成功后的产品的id
    String productPostNew(AeAppClientDTO aeAppClientDTO, AeProductProductPostNewDTO reqDto) throws ApiException;

    //商品新的编辑接口
    //描述：商品编辑接口（修改任何一个商品信息时，必须将其他所有信息进行填写全面后再提交，否则会出现报错情况出现。）营销图功能上线，增加字段
    String productEditNew(AeAppClientDTO aeAppClientDTO, AeProductProductEditNewDTO reqDto) throws ApiException;

    //商品查询新接口
    //描述：根据商品id查询单个商品的详细信息。
    String productDetailQueryNew(AeAppClientDTO aeAppClientDTO, AeProductProductQueryNewDTO reqDto) throws ApiException;

    //商品橱窗设置
    //描述：商品橱窗设置
    String setShopWindowProduct(AeAppClientDTO aeAppClientDTO, AeProductSetShopWindowProductDTO reqDto) throws ApiException;

    //商品违禁词查询（暂停维护，返回空集合）
    //描述：“调用发布商品接口api.postaeproduct前，针对商品标题等信息做违禁词相关信息查询接口。 当前支持的违禁词查询范围包括：1.商品的标题，2.商品的关键字, 3.商品的类目属性, 4.商品的详细描述。用户提供以上四个参数以及商品的类目ID来查询标题、关键字、类目属性、详细描述中是否包含了当前类目的违禁词。 发布产品时平台提供的违禁词查询只供参考和引导的作用，同时由于是系统检测并不能判断实际词语应用的场景，所以还需请您不断仔细检查相关词语的应用情况，可点此进入知识产权的相关学习：http://seller.aliexpress.com/education/rules/ipr31.html?tracelog=ipr01zscqzq”
    String findAeProductProhibitedWords(AeAppClientDTO aeAppClientDTO, AeProductFindAeProductProhibitedWordsDTO reqDto) throws ApiException;

    //将指定的尺码模版信息复制到具有相同的模型的目标叶子类目下面
    //描述：复制所有尺码模版的所有信息 尺码模版与目标叶子类目具有相同的模型
    String copySizeTemplate(AeAppClientDTO aeAppClientDTO, AeProductCopySizeTemplateDTO reqDto) throws ApiException;

    //延长商品有效期
    //描述：“卖家post商品时可选择商品有效期。 每次延长的有效期=post商品时卖家选择的商品有效期”
    String renewExpire(AeAppClientDTO aeAppClientDTO, AeProductRenewExpireDTO reqDto) throws ApiException;

    //批量更新商品绑定车型信息
    //描述：批量更新商品绑定车型信息
    String carModelUpdateProductCarInfo(AeAppClientDTO aeAppClientDTO, AeProductCarModelUpdateProductCarInfoDTO reqDto) throws ApiException;

    //批量查询车型库数据
    //描述：根据条件批量查询车型库数据
    String carModelFindByTecIds(AeAppClientDTO aeAppClientDTO, AeProductCarModelFindByTecIdsDTO reqDto) throws ApiException;

    //新增商品主图短视频
    //描述：根据商品id和视频url完成商品头图视频的更新
    String ugcProductVideoUpload(AeAppClientDTO aeAppClientDTO, AeProductUgcProductVideoUploadDTO reqDto) throws ApiException;

    //服务模板查询
    //描述：服务模板查询API
    String queryPromiseTemplateById(AeAppClientDTO aeAppClientDTO, AeProductQueryPromiseTemplateByIdDTO reqDto) throws ApiException;

    //查询主商品搭配列表
    //描述：查询商品搭配列表,这个接口是以主商品来作为查询的统计维度的？比如要查10条记录，其实是查10个主商品，这10个主商品的所有搭配记录都会查出来，所以实际上查出来的搭配数量实际上要比10大，由于每个主商品最多可以有三个搭配，所以如果查询10个主商品，一次最多可能会查询出30条搭配记录
    String queryBundle(AeAppClientDTO aeAppClientDTO, AeProductQueryBundleDTO reqDto) throws ApiException;

    //查询信息模板列表
    //描述：查询信息模板列表
    String findAeProductDetailModuleListByQuery(AeAppClientDTO aeAppClientDTO, AeProductFindAeProductDetailModuleListByQueryDTO reqDto) throws ApiException;

    //查询单个信息模板详情
    //描述：“根据模块id查询模块，模块在detail详情中显示格式：<kse：widget data-widget-type=”“widget”“ id=”“1004”“ title=”“Specification ”“ type=”“relation”“></kse：widget> 标签属性id=“”1004“”对应返回值中的id，标签属性type=“”relation“”对应返回值中的type， 标签属性title=“”Specification “”对应返回值中的name.”
    String findAeProductModuleById(AeAppClientDTO aeAppClientDTO, AeProductFindAeProductModuleByIdDTO reqDto) throws ApiException;

    //查询商品状态
    //描述：查询商品状态，商品供三种状态。审核通过：approved;审核中：auditing;审核不通过：refuse
    String findAeProductStatusById(AeAppClientDTO aeAppClientDTO, AeProductFindAeProductStatusByIdDTO reqDto) throws ApiException;

    //查询商品绑定的车型信息
    //描述：查询商品绑定的车型库信息
    String carModelFindListByProductId(AeAppClientDTO aeAppClientDTO, AeProductCarModelFindListByProductIdDTO reqDto) throws ApiException;

    //查询商家下已优化商品
    //描述：查询商家下已优化商品，包括优化时间和优化来源
    String productDiagnosisResultList(AeAppClientDTO aeAppClientDTO, AeProductProductDiagnosisResultListDTO reqDto) throws ApiException;

    //查询商家下待优化的商品问题类型列表
    //描述：查询商家下待优化的商品问题类型列表 包含问题类型和问题描述
    String productDiagnosisQueryProblem(AeAppClientDTO aeAppClientDTO, AeProductProductDiagnosisQueryProblemDTO reqDto) throws ApiException;

    //查询指定商品ID所在产品分组
    //描述：查询指定商品id所在产品分组
    String queryProductGroupIdByProductId(AeAppClientDTO aeAppClientDTO, AeProductQueryProductGroupIdByProductIdDTO reqDto) throws ApiException;

    //查询草稿箱里的产品信息
    //描述：根据商品id查询单个商品的详细信息。
    String draftProductGetNew(AeAppClientDTO aeAppClientDTO, AeProductDraftProductGetNewDTO reqDto) throws ApiException;

    //查询草稿箱里的商品列表
    //描述：草稿箱商品列表查询接口。主账号可查询所有商品，子账号只可查询自身所属商品。
    String draftProductsGet(AeAppClientDTO aeAppClientDTO, AeProductDraftProductsGetDTO reqDto) throws ApiException;

    //查询车型库支持的品牌
    //描述：查询车型库支持的品牌
    String carModelGetBrand(AeAppClientDTO aeAppClientDTO, AeProductCarModelGetBrandDTO reqDto) throws ApiException;

    //查询车型库支持的国家
    //描述：查询车型库支持的所有国家列表
    String carModelGetCountry(AeAppClientDTO aeAppClientDTO, AeProductCarModelGetCountryDTO reqDto) throws ApiException;

    //查询零配件关联的TEC车型ID
    //描述：查询零配件关联的车型信息
    String carModelGetLinkTarget(AeAppClientDTO aeAppClientDTO, AeProductCarModelGetLinkTargetDTO reqDto) throws ApiException;

    //根据OE号查询零配件信息
    //描述：根据OE号等条件查询零配件信息
    String carModelGetArticle(AeAppClientDTO aeAppClientDTO, AeProductCarModelGetArticleDTO reqDto) throws ApiException;

    //根据tecId查询车型库数据
    //描述：根据TEC ID查询车型库数据
    String carModelFindByTecId(AeAppClientDTO aeAppClientDTO, AeProductCarModelFindByTecIdDTO reqDto) throws ApiException;

    //根据类目id获得适用的尺码表信息列表（不推荐使用）
    //描述：查询当前用户在指定类目下可用的尺码模版信息。不推荐使用，请使用aliexpress.offer.redefining.getsizetemplatesbycategoryid
    String getSizeChartInfoByCategoryId(AeAppClientDTO aeAppClientDTO, AeProductGetSizeChartInfoByCategoryIdDTO reqDto) throws ApiException;

    //类目预测，可以筛选卖家已经通过准入申请的类目
    //描述：类目预测，根据商品标题和图片预测商品的叶子类目，可以筛选已经通过准入申请的类目
    String categoryForecast(AeAppClientDTO aeAppClientDTO, AeProductCategoryForecastDTO reqDto) throws ApiException;

    //编辑单商品多sku价格
    //描述：编辑单商品多sku价格
    String editMultipleProductSkuPrices(AeAppClientDTO aeAppClientDTO, AeProductProductSkuPricesEditDTO reqDto) throws ApiException;

    //编辑单商品多个SKU的库存
    //描述：编辑单个商品的一个或者多个SKU可售库存。将要修改的SKU的库存值保存在skuStocks参数中（Map类型数据），其中key为SKU ID（字符串）， value为对应的库存值（Longtype）。
    String editMultipleSkuStocks(AeAppClientDTO aeAppClientDTO, AeProductEditMultipleSkuStocksDTO reqDto) throws ApiException;

    //编辑商品单个SKU价格
    //描述：编辑商品的单个SKU价格信息。
    String editSingleSkuPrice(AeAppClientDTO aeAppClientDTO, AeProductEditSingleSkuPriceDTO reqDto) throws ApiException;

    //编辑商品单个SKU库存
    //描述：编辑商品单个SKU的库存信息.
    String editSingleSkuStock(AeAppClientDTO aeAppClientDTO, AeProductEditSingleSkuStockDTO reqDto) throws ApiException;

    //编辑商品的单个字段
    //描述：编辑商品的单个字段（目前使用api.editSimpleProductFiled这个接口 暂不支持商品分组、商品属性、SKU、服务模板的修改。请注意！)
    String editSimpleProductFiled(AeAppClientDTO aeAppClientDTO, AeProductEditSimpleProductFiledDTO reqDto) throws ApiException;

    //编辑商品的多语言标题或详描
    //描述：原发编辑商品多语言标题或详描描述（英文版本除外）。试用
    String editMultiLanguageProduct(AeAppClientDTO aeAppClientDTO, AeProductEditMultiLanguageProductDTO reqDto) throws ApiException;

    //编辑商品类目属性
    //描述：编辑商品的类目属性，用给定的类目属性覆盖原有的类目属性。(试用)
    String editProductCategoryAttributes(AeAppClientDTO aeAppClientDTO, AeProductEditProductCategoryAttributesDTO reqDto) throws ApiException;

    //获取单个产品信息
    //描述：根据商品id查询单个商品的详细信息。
    String findAeProductById(AeAppClientDTO aeAppClientDTO, AeProductFindAeProductByIdDTO reqDto) throws ApiException;

    //获取叶子类目下尺码模版列表
    //描述：获取当前用户下入驻叶子类目尺码模版列表，分页，每页最多20条记录。
    String getSizeTemplatesByCategoryId(AeAppClientDTO aeAppClientDTO, AeProductGetSizeTemplatesByCategoryIdDTO reqDto) throws ApiException;

    //获取当前会员的产品分组（不推荐使用）
    //描述：获取当前会员的产品分组。该接口存在问题导致SDK无法使用，自己解析json的方式目前仍可以使用，但后期会下线掉。建议使用新API：aliexpress.product.productgroups.get，https：//developers.aliexpress.com/doc.htm#？docType=2&docId=35300。
    String getProductGroupList(AeAppClientDTO aeAppClientDTO, AeProductGetProductGroupListDTO reqDto) throws ApiException;

    //获取当前会员的产品分组（新）
    //描述：获取当前会员的产品分组
    String productGroupsGet(AeAppClientDTO aeAppClientDTO, AeProductProductGroupsGetDTO reqDto) throws ApiException;

    //通过商品ID初始化商品搭配
    //描述：通过商品ID初始化商品搭配，这个接口初始化的搭配信息不回保存到数据库，只有调用了aliexpress.offer.redefining.createbundle接口后才会保存
    String initialNewBundle(AeAppClientDTO aeAppClientDTO, AeProductInitialNewBundleDTO reqDto) throws ApiException;
}
