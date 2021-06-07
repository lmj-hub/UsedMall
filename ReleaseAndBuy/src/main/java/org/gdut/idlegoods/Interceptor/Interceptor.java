package org.gdut.idlegoods.Interceptor;

import javax.management.relation.Relation;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gdut.idlegoods.service.GoodsService;
import org.springframework.web.servlet.HandlerInterceptor;

//Ìí¼Ó¹ýÂËÆ÷
public class Interceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		ServletContext context = request.getSession().getServletContext();
		ServletContext targetContext = context.getContext("/User");
		HttpSession session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
		if(session==null) {
			response.sendRedirect("/User/LoginAndRegister.jsp");
			return false;
		}
		return true;
	}
	

}
