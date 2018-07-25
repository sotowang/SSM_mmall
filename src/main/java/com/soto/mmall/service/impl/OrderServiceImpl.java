package com.soto.mmall.service.impl;

import com.google.common.collect.Maps;
import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService {
    public ServerResponse pay(Long orderNo, Integer userId, String path) {
        Map<String, Object> resultMap = Maps.newHashMap();
        return null;
    }
}
