package org.gdut.idlegoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.executor.ReuseExecutor;
import org.gdut.idlegoods.bean.Goods;
import org.gdut.idlegoods.bean.Message;
import org.gdut.idlegoods.bean.Requirement;
import org.gdut.idlegoods.dao.RequirementsDao;
import org.gdut.idlegoods.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author mj
 *需求控制器,负责与前端交换
 */
@Controller
public class RequirementsController {
	
	@Autowired
	RequirementsService requirementsService;
	

	@ResponseBody
	@RequestMapping("/publishRequirement")
	public Message releaseRequirments(@Valid Requirement re,BindingResult errors,HttpServletRequest request) {
		if(errors.hasErrors()) {
			return Message.fail();
		}
		String userId = getUserId(request);
		re.setUserId(Integer.parseInt(userId));
		boolean result = requirementsService.saveRequirements(re);
		if(result) {
			return Message.success();
		}
		return Message.fail();
	}
	
	//获取某一个特定用户发布的需求
	@RequestMapping(value="/getMyRequirements",method=RequestMethod.GET)
	@ResponseBody
	public Message getMyRequirements(@RequestParam(value="pn", defaultValue="1") Integer pn,HttpServletRequest request) {
		Integer userId = Integer.parseInt(getUserId(request));
		//pn为当前页，每页放5条数据
		PageHelper.startPage(pn,5);
		//查询数据(默认是分页查询)
		List<Requirement> reList = requirementsService.getMyRequirements(userId);
		//pageInfo封装了数据信息，里面包含了详细的分页信息，包括当前页的数据
		PageInfo<Requirement> pageInfo = new PageInfo<Requirement>(reList,5);
		return Message.success().add("pageInfo", pageInfo);
	}
	
	//获取用户id
	public String getUserId(HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		ServletContext targetContext = context.getContext("/User");
		HttpSession session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
		Integer userId =(Integer) session.getAttribute("userId");
		String idstr=userId.intValue()+"";
		return idstr;
	}
	
	//通过商品id查找商品
	@ResponseBody
	@RequestMapping(value="/getOneRequirement/{re_currentId}",method = RequestMethod.GET)
	public Message getOneGoods(@PathVariable("re_currentId") String reId) {
		Requirement re = requirementsService.getOneRequirement(reId);
		return Message.success().add("re", re);
	}
	
	//更新商品
	@ResponseBody
	@RequestMapping(value="/updateRe",method=RequestMethod.POST)
	public Message updateRe(@Valid Requirement re,BindingResult errors,
	HttpServletRequest request) throws IOException {
		if(errors.hasErrors()) {
			return Message.fail();
		}
		boolean result;
	    result =requirementsService.updateRe(re);
		if(result) {
			return Message.success();
		}else {
				return Message.fail();
	}
}
	
	//删除需求
	@ResponseBody
	@RequestMapping(value="/deleteRe/{reId}",method=RequestMethod.DELETE)
public Message delete(@PathVariable(value = "reId") String reId) {
		if(reId.contains("-")) {
			//删除多个
				String[] ids=reId.split("-");
				for(int i =0;i<ids.length;i++) {
					requirementsService.delete(ids[i]);
				}
				return Message.success();
		}else {
			//删除单个
					boolean result = requirementsService.delete(reId);
					if(result) {
						return Message.success();
					}
				}
		return Message.fail();
	}
	
	//清空所有发布的需求
			@ResponseBody
			@RequestMapping(value="/clearPublishedRe",method = RequestMethod.DELETE)
			public Message clearPublishedRe(HttpServletRequest request) {
				String userId = getUserId(request);
				boolean result = requirementsService.clearRe(userId);
				if(result) {
					return Message.success();
				}
				return Message.fail();
			}

	
}
