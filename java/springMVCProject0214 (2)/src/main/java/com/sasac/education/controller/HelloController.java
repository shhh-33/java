package com.sasac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sasac.vo.BookVO;

@Controller
@RequestMapping("/test") //type level�� ��û�ּ� �ۼ��ϱ� 
public class HelloController {

	@RequestMapping("/hello1")//method level�� ��û�ּ� �ۼ��ϱ�
	public String hello1(HttpServletRequest request) {
		System.out.println("Hello1��û");
		
		return "helloPage1"; //page�� forward�ȴ�. 
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/helloPage1.jsp");
		 * rd.forward(request, response)
		 * WEB-INF/views/helloPage1.jsp
		 * 
		 */
	}
	@RequestMapping("/hello2")
	public ModelAndView test2(HttpServletRequest request) {
		System.out.println("Hello2��û");
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "SpringFrameWork�н�");
		mv.addObject("price", 5000);
		mv.addObject("book", new BookVO(10, "java", "�輼��", null, null));
		
		mv.setViewName("helloPage1");
		return mv;  
		 
	}
	
	@RequestMapping(value = {"/hello3","/hello4.do","/hello4.test"})
	public String hello3(Model model) {
		model.addAttribute("myname", "jin");
		model.addAttribute("phone", "010-1234-7896");
		return "helloPage3";
	}
	
	@RequestMapping(value = {"/hello5"})
	public void aaaaa(Model model) {
		model.addAttribute("myname", "jin");
		model.addAttribute("phone", "010-1234-7896");
		///WEB-INF/views/test/hello5.jsp
	}
	// method = RequestMethod.GET�������� 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(String userid, String userpass , Model model) {
		
		System.out.println("userid:" + userid);
		System.out.println("userpass:" + userpass);
		if(userid==null) {
			model.addAttribute("message", "�α��ξ��̵� �����ϴ�.");
		}else {
			model.addAttribute("message", "�α��� �����Ͽ����ϴ�.");
		}
		
		
		return "user/loginResult";
	}
	
	@RequestMapping(value = {"helloParam.do"},
			params = {"userid=sesac", "userpass", "!email"}, 
			method = RequestMethod.GET)
	public String helloParam(Model model, String userid, String userpass) {
		System.out.println("userid:" + userid);
		System.out.println("userpass:" + userpass);
	 
		model.addAttribute("message", "helloParam.do�α��� �����Ͽ����ϴ�.");
		return "user/loginResult";
	}
}






