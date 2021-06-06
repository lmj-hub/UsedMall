package com.feng.controller;


import com.feng.model.User;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //处理登录逻辑
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@Valid User target,BindingResult result, HttpServletRequest request, Model model) {
    	//校验失败，直接返回false
    	if(result.hasErrors()) {
    		return false;
    	}
        User user = userService.selectUserByUserName(target.getUsername(),target.getPassword());
        if (user!= null) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getUserId());
                //方便同一个Tomcat下不同web实例共享Session
                session.getServletContext().setAttribute(session.getId(),session);
                return true;
            }
        return false;
    }

    //处理注册逻辑
    @ResponseBody
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public boolean register(@Valid User user,BindingResult result){
    	//校验失败，直接返回false
    	if(result.hasErrors()) {
    		return false;
    	}
    	String rdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    	user.setRdate(rdate);
        boolean flag = userService.insertUser(user);
        return flag;
    }

    @RequestMapping(value = "/delUser" , method = RequestMethod.POST)
    public String delUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request,Model model){
        System.out.println("输入的信息"+username+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean flag=userService.delUser(user);
        System.out.println(flag);
        return "/loginSuccess";
    }
   
  
}