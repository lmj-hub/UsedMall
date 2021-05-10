package org.gdut.idlegoods.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gdut.idlegoods.bean.Message;
import org.gdut.idlegoods.bean.Requirement;
import org.gdut.idlegoods.dao.RequirementsDao;
import org.gdut.idlegoods.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public Message releaseRequirments(Requirement re,HttpServletRequest request) {
		String userId =(String) request.getSession().getAttribute("userId");
		re.setUserId(Integer.parseInt(userId));
		System.out.println(re);
		boolean result = requirementsService.saveRequirements(re);
		if(result) {
			return Message.success();
		}
		return Message.fail();
	}

}
