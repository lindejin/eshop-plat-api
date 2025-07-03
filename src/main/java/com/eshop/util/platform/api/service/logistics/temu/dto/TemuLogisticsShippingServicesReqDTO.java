package com.eshop.util.platform.api.service.logistics.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShippingServicesReqDTO {

    //warehouseId	STRING	True	Warehouse ID.
    private String warehouseId;
    //orderSnList	STRING[]	True	Product List in this package.
    private List<String> orderSnList;


    //weight	STRING	True	The weight of the package. For local U.S. orders, this filed should be input with integer and the decimal places should be input by extendWeight. For Non-local U.S. orders, two decimal places are filled in by default.
    private String weight;
    //weightUnit	STRING	True	The unit of the weight. The weight unit for packages in the United States is "lb" while in other countries it is "kg".
    private String weightUnit;


    //extendWeight	STRING	False	The extend weight of the package. For local U.S. orders, the decimal places are filled with integer through this parameter while extendWeightUnit is "oz".
    private String extendWeight;
    //extendWeightUnit	STRING	False	The unit of the extend weight. For local U.S. orders, the extend weight unit for packages is "oz".
    private String extendWeightUnit;


    //length	STRING	True	The length of the package, the length should be input with two decimal places.
    private String length;
    //width	STRING	True	width of the package, width should be input with two decimal places.
    private String width;
    //height	STRING	True	height of the package, height should be input with two decimal places
    private String height;
    //dimensionUnit	STRING	True	dimension(eg:length/width/height) Unit. The dimension unit for packages in the United States is "in". while in other countries it is "cm"
    private String dimensionUnit;


    //signatureOnDelivery	BOOLEAN	False	Is Signature Required for Delivery Confirmation?
    private boolean signatureOnDelivery;
}
