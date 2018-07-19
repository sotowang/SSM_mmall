package com.soto.mmall.service;

import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.pojo.Category;

import java.util.List;

public interface ICategortService {
    ServerResponse addCategory(String categoryName, Integer parentId);


    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParalleCategory(Integer categoryId);

    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
