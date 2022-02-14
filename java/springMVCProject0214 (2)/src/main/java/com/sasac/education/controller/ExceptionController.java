package com.sasac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
//2.@ControllerAdvice 를 이용해서 전역 Exception처리 
@ControllerAdvice //전역Exception
public class ExceptionController {

//	@ExceptionHandler(Exception.class)
//	public String handler500(HttpServletRequest request, Model model) {
//		model.addAttribute("aaa", "문법오류");
// 		return "error/errorPage500";
//	}
	
		
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(HttpServletRequest request, Model model) {
		model.addAttribute("message", "존재하지않는 페이지입니다.");
		model.addAttribute("url", request.getRequestURL());
		return "error/errorPage404";
		
	}
}
