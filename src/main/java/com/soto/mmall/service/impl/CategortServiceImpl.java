package com.soto.mmall.service.impl;

import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.dao.CategoryMapper;
import com.soto.mmall.pojo.Category;
import com.soto.mmall.service.ICategortService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategortServiceImpl implements ICategortService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if (parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加商品种类参数有误");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);

        category.setStatus(true);//分类可用

        int rowCount = categoryMapper.insertSelective(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加商品种类成功");
        }
        return ServerResponse.createByErrorMessage("添加商品种类失败");
    }

    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("更新种类参数有误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);

        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("更新商品种类成功");
        }
        return ServerResponse.createByErrorMessage("更新商品种类失败");
    }
}