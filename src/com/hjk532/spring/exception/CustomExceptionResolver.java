package com.hjk532.spring.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		// 解析异常类型，做对应处理
		CustomException customException=null;
		if(arg3 instanceof CustomException) {
			customException=(CustomException)arg3;
		}else {
			customException=new CustomException("发生未知错误！请重试");
		}
		String message=customException.getMessage();
		ModelAndView model=new ModelAndView();
		model.addObject("message",message);
		model.setViewName("/WEB-INF/err.jsp");
		return model;
		
	}
	
}
