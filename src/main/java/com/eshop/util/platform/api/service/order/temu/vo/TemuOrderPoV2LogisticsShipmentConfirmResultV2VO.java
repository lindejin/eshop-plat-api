package com.eshop.util.platform.api.service.order.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoV2LogisticsShipmentConfirmResultV2VO {

    //assistantAgreementText	STRING	Enables intelligent trajectory assistant to detect and correct potential mistakes in carrier entries.
    private String assistantAgreementText;
    //warningMessage	STRING[]	Provides relevant prompts related to the current shipping request.

    private List<String> warningMessage;

}
