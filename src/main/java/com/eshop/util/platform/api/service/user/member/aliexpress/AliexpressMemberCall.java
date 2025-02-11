package com.eshop.util.platform.api.service.user.member.aliexpress;

import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberDsOrderDataSaveDTO;
import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberOauthAuthorizeDTO;
import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberQueryAccountLevelDTO;
import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberUicQueryTbNickDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/7 9:42
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressMemberCall {

    //查询淘宝的nickName
    //描述：通过AE的loginId查询淘宝的nickName

    /**
     * 查询淘宝的nickName
     */
    String uicQueryTbNick(AeAppClientDTO aeAppClientDTO, AeMemberUicQueryTbNickDTO reqDto) throws ApiException;

    //收集下单的用户和订单金额等信息
    //描述：收集dropshipper导购站点下单的用户和订单金额等信息

    /**
     * 收集下单的用户和订单金额等信息
     */
    String dsOrderDataSave(AeAppClientDTO aeAppClientDTO, AeMemberDsOrderDataSaveDTO reqDto) throws ApiException;

    //oauth授权
    //描述：该开放接口使用OK的authCode 映射到AE账号上进行Top平台的授权操作

    /**
     * oauth授权
     */
    String oauthAuthorize(AeAppClientDTO aeAppClientDTO, AeMemberOauthAuthorizeDTO reqDto) throws ApiException;

    //查询会员账户等级
    //描述：根据买家登录ID查询会员等级。平台对买家层级的标识，以A0-A4五个等级进行标注，数字越高，等级越高，买家越活跃，购买力越强,卖家朋友可根据买家分层更好的服务于买家。

    /**
     * 查询会员账户等级
     */
    String queryAccountLevel(AeAppClientDTO aeAppClientDTO, AeMemberQueryAccountLevelDTO reqDto) throws ApiException;
}
