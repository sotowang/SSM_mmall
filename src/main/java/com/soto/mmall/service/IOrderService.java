package com.soto.mmall.service;

import com.soto.mmall.common.ServerResponse;

public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);
}
