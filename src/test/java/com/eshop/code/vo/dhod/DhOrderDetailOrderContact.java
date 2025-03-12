package com.eshop.code.vo.dhod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DhOrderDetailOrderContact {
    /**
     * 收货人姓名(全称)
     * firstName+lastName
     */
    private String contactName;

    /**
     * 邮编(发货信息)
     * 示例值：100190
     */
    private String postalcode;

    /**
     * 省(发货信息)
     * 示例值：beijing,表示发货省份是北京
     */
    private String state;

    /**
     * 收货人名
     * 示例值：michael
     */
    private String firstName;

    /**
     * 城市(发货信息)
     * 示例值：beijing,表示发货城市是北京
     */
    private String city;

    /**
     * 地址2(发货信息)
     * 示例值：yousheng building, wudaokou street, haidian district,表示发货地址是海淀区五道口优盛大厦
     */
    private String addressLine2;

    /**
     * 地址1(发货信息)
     * 示例值：yousheng building, wudaokou street, haidian district,表示发货地址是海淀区五道口优盛大厦
     */
    private String addressLine1;

    /**
     * 收货人姓
     * 示例值：jackson
     */
    private String lastName;

    /**
     * 电话(发货信息)
     * 示例值：1380000000
     */
    private String telephone;

    /**
     * 收货人的邮件
     */
    private String email;

    /**
     * 买家别名
     * 买家昵称；示例值：zhangsan
     */
    private String buyerNickName;

    /**
     * 买家ID
     * 示例值：ff808081416839d5014168e43ab30033
     */
    private String buyerId;

    /**
     * 税号
     * 示例值：01041247842
     */
    private String vatNumber;

    /**
     * 发货国家
     * 示例值：china,表示发货国家是中国
     */
    private String country;

    /**
     * 识别号码
     * 示例值：22114665084
     */
    private String abn;

    /**
     * 门牌号
     * 示例值：012545
     */
    private String houseNumber;

}
