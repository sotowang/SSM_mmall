package com.soto.mmall.controller.portal;

import com.soto.mmall.common.Const;
import com.soto.mmall.common.ResponseCode;
import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.pojo.User;
import com.soto.mmall.service.ICategortService;
import com.soto.mmall.service.IUserService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategortService iCategortService;

    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请选登陆");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //是管理员
            //增加处理分类逻辑
            return iCategortService.addCategory(categoryName, parentId);

        } else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }
    @RequestMapping("set_categoryName.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请选登陆");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //更新categoryName
            return iCategortService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }
    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallerCategory(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请选登陆");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询子节点的category信息,并且不递归,保持平级
            return iCategortService.getChildrenParalleCategory(parentId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildren(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请选登陆");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询当前节点的id,递归子节点的id
            return iCategortService.selectCategoryAndChildrenById(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }
}