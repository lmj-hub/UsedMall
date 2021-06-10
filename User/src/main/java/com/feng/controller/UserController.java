package com.feng.controller;


import com.feng.model.User;
import com.feng.service.UserService;
import com.feng.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user1
     * @return
     */
    @RequestMapping(value = "/addUser")
    public String addUser(HttpServletRequest request, @ModelAttribute("user") User user1) {
        String url = request.getHeader("Referer");
        User user = userService.getUserByPhone(user1.getPhone());
        if (user == null) {// 检测该用户是否已经注册
            String t = DateUtil.getNowDate();
            String str = user1.getPassword();
            user1.setRdate(t);// 创建开始时间
            user1.setPassword(str);
            userService.addUser(user1);
        }
        return "redirect:" + url;
    }

    /**
     * 注册验证账号
     * @param request
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request){
        String phone=request.getParameter("phone");
        User user = userService.getUserByPhone(phone);
        if(user==null) {
            return "{\"success\":true,\"flag\":false}";//用户存在，注册失败
        }else {
            return "{\"success\":true,\"flag\":true}";//用户不存在，可以注册
        }
    }

    /**
     * 登陆验证密码
     * @param request
     * @return
     */
	/*@RequestMapping(value = "/password",method = RequestMethod.POST)
	@ResponseBody
	public String password(HttpServletRequest request){
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		if((phone==null||phone=="")&&(password==null||password=="")) {
			return "{\"success\":false,\"flag\":true}";
		}else {
			User user = userService.getUserByPhone(phone);
			if(user==null) {
				return "{\"success\":false,\"flag\":false}";//账号错误
			}
			String pwd = MD5.md5(password);
			if (pwd.equals(user.getPassword())) {
				return "{\"success\":true,\"flag\":false}";//密码正确
			}else {
				return "{\"success\":true,\"flag\":true}";//密码错误
			}
		}

	}*/


    /**
     * 验证登录
     * @param request
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginValidate(HttpServletRequest request, HttpServletResponse response, User user,
                                      ModelMap modelMap) {
        User cur_user = userService.getUserByPhone(user.getPhone());
        String url = request.getHeader("Referer");
        if (cur_user != null) {
            String pwd = user.getPassword();
            if (pwd.equals(cur_user.getPassword())) {
                request.getSession().setAttribute("cur_user", cur_user);
                return new ModelAndView("redirect:" + url);
            }
        }
        return new ModelAndView("redirect:" + url);
    }

    /**
     * 更改用户名
     *
     * @param request
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/changeName")
    public ModelAndView changeName(HttpServletRequest request, User user, ModelMap modelMap) {
        String url = request.getHeader("Referer");
        // 从session中获取出当前用户
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());// 更改当前用户的用户名
        userService.updateUserName(cur_user);// 执行修改操作
        request.getSession().setAttribute("cur_user", cur_user);// 修改session值
        return new ModelAndView("redirect:" + url);
    }

    /**
     * 完善或修改信息
     *
     * @param request
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/updateInfo")
    public ModelAndView updateInfo(HttpServletRequest request, User user, ModelMap modelMap) {
        // 从session中获取出当前用户
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());
        cur_user.setSno(user.getSno());
        cur_user.setAddress(user.getAddress());
        cur_user.setRealname(user.getRealname());
        cur_user.setClazz(user.getClazz());
        userService.updateUserName(cur_user);// 执行修改操作
        request.getSession().setAttribute("cur_user", cur_user);// 修改session值
        return new ModelAndView("redirect:/user/basic");
    }

    /**
     * 用户退出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("cur_user", null);
        return "redirect:/";
    }

    /**
     * 个人信息设置
     *
     * @return
     */
    @RequestMapping(value = "/basic")
    public ModelAndView basic(HttpServletRequest request) {
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        Integer userId = cur_user.getId();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/basic");
        return mv;
    }

   
  
}