package com.soto.mmall.service;

import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.pojo.Product;
import com.soto.mmall.vo.ProductDetailVo;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
}
