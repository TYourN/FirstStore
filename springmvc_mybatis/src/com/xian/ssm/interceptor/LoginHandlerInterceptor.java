package com.xian.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub  执行Handler之后
		//统一的异常处理，统一的日志处理
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub 返回modelAndView之前
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub 进入之前
		//用于身份认证和身份授权
		
		StringBuffer url=request.getRequestURL();
		//判断URL是否为公开地址（实际情况下是配置在配置文件中的）
		if(url.indexOf("login.action")>=0){
			return true;
		}				
		
		//对session进行判断
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		if(username!=null){
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
   
}
