package com.soto.mmall.service.impl;

import com.google.common.collect.Lists;
import com.soto.mmall.common.Const;
import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.dao.CartMapper;
import com.soto.mmall.pojo.Cart;
import com.soto.mmall.service.ICartService;
import com.soto.mmall.vo.CartProductVo;
import com.soto.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    public ServerResponse add(Integer userId, Integer productId, Integer count) {
        Cart cart = cartMapper.selectByUserIdProductId(userId, productId);
        if (cart == null) {
            //这个产品不在购物车,需要新增一个产品记录
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setProductId(productId);
            cartItem.setUserId(userId);

            cartMapper.insertSelective(cartItem);
        } else {
            //这个产品已经在购物车里
            //产品如果存在,数量相加
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return null;
    }


    private CartVo getCartVoList(Integer userId) {
        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();
        BigDecimal cartTotalPrice = new BigDecimal("0");
        return null;
    }

}
