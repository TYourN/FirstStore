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
		// TODO Auto-generated method stub  ִ��Handler֮��
		//ͳһ���쳣����ͳһ����־����
		System.out.println("1.3");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub ����modelAndView֮ǰ
		
		System.out.println("1.2");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub ����֮ǰ
		//���������֤�������Ȩ
		
		System.out.println("1.1");
		
		return true;
	}
   
}
