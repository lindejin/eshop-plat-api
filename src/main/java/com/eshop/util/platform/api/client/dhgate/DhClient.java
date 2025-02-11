package com.eshop.util.platform.api.client.dhgate;

import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/12 10:47
 * @Description: ...
 * @Version 1.0
 */
@Service
public interface DhClient {

    DhResponse execute(DhRequest dhRequest, DhAppClientDTO publicDTO) throws Exception;
}
