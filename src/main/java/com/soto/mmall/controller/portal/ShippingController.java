package com.soto.mmall.controller.portal;

import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private IShippingService iShippingService;

    public ServerResponse add(HttpSession session) {
        return null;
    }


}
