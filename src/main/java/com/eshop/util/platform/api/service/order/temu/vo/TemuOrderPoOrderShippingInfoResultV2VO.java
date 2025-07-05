package com.eshop.util.platform.api.service.order.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoOrderShippingInfoResultV2VO {

    //receiptName	STRING	Name
    private String receiptName;
    //receiptAdditionalName	STRING	Additional Name
    private String receiptAdditionalName;

    //mobile	STRING	Phone Number
    private String mobile;

    //backupMobile	STRING	Alternate Phone
    private String backupMobile;

    //mail	STRING	Virtual Email
    private String mail;

    //taxCode	STRING	Personal Tax identification number. For Brazil local sellers: It is called Cadastro de Pessoa Física and format is XXX.XXX.XXX-YY.
    private String taxCode;

    //regionName1	STRING	First-Level Administrative Division Name
    private String regionName1;

    //regionName2	STRING	Secondary Administrative Division Name
    private String regionName2;

    //regionName3	STRING	Third-Level Administrative Division Name
    private String regionName3;

    //regionName4	STRING	Fourth-Level Administrative Division Name
    private String regionName4;

    //addressLine1	STRING	Address Line 1
    private String addressLine1;

    //addressLine2	STRING	Address Line 2
    private String addressLine2;

    //addressLine3	STRING	Address Line 3
    private String addressLine3;

    //postCode	STRING	Postal Code
    private String postCode;

    //addressLineAll	STRING	Address Line 1 + Line 2 + Line 3
    private String addressLineAll;

    //warning	OBJECT	warning information
    private TemuOrderPoOrderShippingInfoResultWarningV2VO warning;

}
