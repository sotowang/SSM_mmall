package com.soto.mmall.service;

import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.vo.CartVo;

public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
}
