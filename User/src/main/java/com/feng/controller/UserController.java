package com.feng.controller;



import com.feng.controller.token.TokenProccessor;
import com.feng.controller.tool.StringUtils;
import com.feng.model.User;
import com.feng.model.UserPassword;
import com.feng.service.UserPasswordService;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserPasswordService userPasswordService;

    //进入登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,Model model){
        String token = TokenProccessor.getInstance().makeToken();
        log.info("进入登陆界面，token为："+token);
        request.getSession().setAttribute("token",token);
        model.addAttribute("token",token);
        return "redirect:/";
    }

    //退出
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        try{
            request.getSession().removeAttribute("user");
            request.getSession().removeAttribute("uid");
            System.out.println("logout");
        }catch(Exception e){
            e.printStackTrace();
            return "redirect:/home";
        }
        return "redirect:/";
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model, @RequestParam String username,@RequestParam String password,@RequestParam String phone){
        User user=new User();
        user.setUsername(username);//用户名
        user.setPassword(password);//密码
        user.setPhone(phone);//电话
        user.setRdate(new Date());//注册时间
        user.setModify(new Date());//修改时间
        if(userService.insertSelective(user) == 1){
            int uid=userService.selectUseridByPhone(phone);
            UserPassword userPassword = new UserPassword();
            userPassword.setModify(new Date());
            password = StringUtils.getInstance().getMD5(password);
            userPassword.setPassword(password);
            userPassword.setUid(uid);
            int result = userPasswordService.insertSelective(userPassword);
            if(result !=1){
                model.addAttribute("result","fall");
                return "success";
            }
            model.addAttribute("result","success");
            return "success";
        }
        model.addAttribute("result","fail");
        return "success";
    }

    //验证登录
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request,
                        @RequestParam String token,@RequestParam String password,@RequestParam String phone) {
        String loginToken = (String)request.getSession().getAttribute("token");
        if(StringUtils.getInstance().isNullOrEmpty(phone) || StringUtils.getInstance().isNullOrEmpty(password)){
            return "redirect:/login";
        }
        if (StringUtils.getInstance().isNullOrEmpty(token)||!token.equals(loginToken)){
            return "redirect:/login";
        }
//        boolean b= getId(request,password,phone);
//        if(!b){
//            return "redirect:/login?msg=该号码不存在";
//        }
        return "redirect:/";
    }

//    //处理登录逻辑
//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@Valid User target,BindingResult result, HttpServletRequest request, Model model) {
//    	//校验失败，直接返回false
//    	if(result.hasErrors()) {
//    		return false;
//    	}
//        User user = userService.selectUserByUserName(target.getUsername(),target.getPassword());
//        if (user!= null) {
//                HttpSession session = request.getSession();
//                session.setAttribute("userId", user.getUserId());
//                //方便同一个Tomcat下不同web实例共享Session
//                session.getServletContext().setAttribute(session.getId(),session);
//                return true;
//            }
//        return false;
//    }
//
//    //处理注册逻辑
//    @ResponseBody
//    @RequestMapping(value ="/register", method = RequestMethod.POST)
//    public boolean register(@Valid User user,BindingResult result){
//    	//校验失败，直接返回false
//    	if(result.hasErrors()) {
//    		return false;
//    	}
//        boolean flag = userService.insertUser(user);
//        return flag;
//    }
//
//    @RequestMapping(value = "/delUser" , method = RequestMethod.POST)
//    public String delUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request,Model model){
//        System.out.println("输入的信息"+username+password);
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        boolean flag=userService.delUser(user);
//        System.out.println(flag);
//        return "/loginSuccess";
//    }
   
  
}