package com.soto.mmall.service.impl;

import com.google.common.collect.Maps;
import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.dao.ShippingMapper;
import com.soto.mmall.pojo.Shipping;
import com.soto.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;


    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0) {
            Map result = Maps.newHashMap();
            result.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功", result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }
    public ServerResponse<String> del(Integer userId, Integer shippingId) {
        int resultCount = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }
}
