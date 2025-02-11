package com.eshop.util.platform.api.client.temu;


import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuClient {

    TemuResponse execute(TemuRequest temuRequest, TemuAppClientDTO publicDTO) throws Exception;

    TemuResponse tokenCreateAndRefresh(TemuRequest temuRequest, TemuAppClientDTO publicDTO) throws Exception;

}
