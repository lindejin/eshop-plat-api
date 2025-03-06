package com.eshop.service;

import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

public interface DhGateCategoryCallService {

    DhCategoryListVO getCategoryList(DhAppClientDTO publicDto, DhCategoryListDTO dto) throws Exception;
}
