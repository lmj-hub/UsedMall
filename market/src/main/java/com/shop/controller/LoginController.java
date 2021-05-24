package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.po.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.NamingEnumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping("/res")
    public String res(){
        return "login/res";
    }

    //执行用户注册
    @RequestMapping("/toRes")
    public String toRes(User u){
        userService.insert(u);
        return "login/ulogin";//返回登陆页面
    }
    //登录入口
    @RequestMapping("/ulogin")
    public String ulogin(){
        return "login/ulogin";
    }

    //执行用户登录
    @RequestMapping("/utologin")
    public String utoLogin(User u, HttpServletRequest request){
        User byEntity = userService.getByEntity(u);
        if(byEntity==null){
            return "redirect:/login/res.action";
        }else {
            request.getSession().setAttribute("name",byEntity.getName());
            return "redirect:/login/uIndex.action";//返回至首页
        }
    }


    //前端用户退出
    @RequestMapping("/uTui")
    public String uTui(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login/uIndex.action";
    }

    /**
     * 修改密码入口
     */
    @RequestMapping("/pass")
    public String pass(HttpServletRequest request){
        Object attribute = request.getSession().getAttribute("name");
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userName = Integer.valueOf(attribute.toString());
        User load = userService.load(userName);
        request.setAttribute("obj",load);
        return "login/pass";
    }

//    /**
//     * 修改密码操作
//     */
//    @RequestMapping("/upass")
//    @ResponseBody
//    public String upass(String password,HttpServletRequest request){
//        Object attribute = request.getSession().getAttribute("name");
//        JSONObject js = new JSONObject();
//        if(attribute==null){
//            js.put(Consts.RES,0);
//            return js.toString();
//        }
//        Integer userName = Integer.valueOf(attribute.toString());
//        User load = userService.load(userName);
//        load.setPassword(password);
//        userService.updateByName(load);
//        js.put("res",1);
//        return js.toString();
//    }

}
