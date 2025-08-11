package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuSensitiveLimitReqDTO {

    //maxBatteryCapacityHp	INTEGER	否	最大电池容量 (mWh)
    //maxBatteryCapacity	INTEGER	否	最大电池容量 (Wh)
    //maxLiquidCapacity	INTEGER	否	最大液体容量 (mL)
    //maxLiquidCapacityHp	INTEGER	否	最大液体容量 (μL)
    //maxKnifeLength	INTEGER	否	最大刀具长度 (mm)
    //maxKnifeLengthHp	INTEGER	否	最大刀具长度 (μm)
    //knifeTipAngle	OBJECT	否	刀尖角度

    private Long maxBatteryCapacityHp;
    private Long maxBatteryCapacity;
    private Long maxLiquidCapacity;
    private Long maxLiquidCapacityHp;
    private Long maxKnifeLength;
    private Long maxKnifeLengthHp;
    private TemuGoodsAddProductSkuKnifeTipAngleReqDTO knifeTipAngle;
}
