package com.soto.mmall.service;

import com.soto.mmall.common.ServerResponse;

public interface ICategortService {
    ServerResponse addCategory(String categoryName, Integer parentId);


    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
}
