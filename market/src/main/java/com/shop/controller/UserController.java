package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.po.User;
import com.shop.service.UserService;
import com.shop.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/User")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model,User user){
        String sql="select * from user where 1=1 ";
        if(!isEmpty(user.getName())){
            sql+=" and userName like '%"+user.getName()+"%'" ;
        }
        Pager<User> pagers=userService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",user);
        return "user/user";
    }
}
