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
		// TODO Auto-generated method stub  ִ��Handler֮��
		//ͳһ���쳣����ͳһ����־����
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub ����modelAndView֮ǰ
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub ����֮ǰ
		//���������֤�������Ȩ
		
		StringBuffer url=request.getRequestURL();
		//�ж�URL�Ƿ�Ϊ������ַ��ʵ��������������������ļ��еģ�
		if(url.indexOf("login.action")>=0){
			return true;
		}				
		
		//��session�����ж�
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		if(username!=null){
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
   
}
