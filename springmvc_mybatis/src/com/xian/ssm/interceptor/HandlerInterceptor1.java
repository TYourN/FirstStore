package com.xian.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub  执行Handler之后
		//统一的异常处理，统一的日志处理
		System.out.println("1.3");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub 返回modelAndView之前
		
		System.out.println("1.2");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub 进入之前
		//用于身份认证和身份授权
		
		System.out.println("1.1");
		
		return true;
	}
   
}
