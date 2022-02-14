package com.sasac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
//2.@ControllerAdvice �� �̿��ؼ� ���� Exceptionó�� 
@ControllerAdvice //����Exception
public class ExceptionController {

//	@ExceptionHandler(Exception.class)
//	public String handler500(HttpServletRequest request, Model model) {
//		model.addAttribute("aaa", "��������");
// 		return "error/errorPage500";
//	}
	
		
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(HttpServletRequest request, Model model) {
		model.addAttribute("message", "���������ʴ� �������Դϴ�.");
		model.addAttribute("url", request.getRequestURL());
		return "error/errorPage404";
		
	}
}
