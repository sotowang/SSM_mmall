package com.soto.mmall.service;

import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.pojo.Product;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
}
