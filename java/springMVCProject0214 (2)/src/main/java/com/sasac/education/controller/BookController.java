package com.sasac.education.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sasac.education.model.LoginDAO;

import kr.co.sasac.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	List<BookVO> blist = new ArrayList<>();
	
	public BookController() {
		
		blist.add(new BookVO(1, "java", "이현지", "새싹출판사", "2022-02-08"));
		blist.add(new BookVO(2, "java", "원윤서", "새싹출판사", "2022-02-08"));
		blist.add(new BookVO(3, "java", "유규원", "새싹출판사", "2022-02-08"));
		blist.add(new BookVO(4, "java", "이미나", "새싹출판사", "2022-02-08"));
		blist.add(new BookVO(5, "java", "양서영", "새싹출판사", "2022-02-08"));
	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bookInsert() {
		//
		return "book/bookInsertForm";
	}
	
	//@RequestParam : int bookNo = Integer.parseInt(request.getParamter("bno"))
	//@RequestParam은 변수이름과 파라메터이름이 같다면 생략한다. 
	//@ModelAttribute("book") : 파라메터로 받은 값을 View값을 전달하기 
	//== model.addAttribute("book2", book3);
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(
			@RequestParam("bno") int bookNo, 
			@RequestParam String title, 
			String author, 
			String pub, 
			String pubDate, 
			int status, 
			@ModelAttribute("book") BookVO book, 
			BookVO book3,  
			Model model, RedirectAttributes redirectAttr) {
		 
		model.addAttribute("myname", "jin");
		model.addAttribute("book2", book3);
		blist.add(book3);
		redirectAttr.addFlashAttribute("message", "입력성공");
		return "redirect:/book/list";
	} 
	
	/*
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(BookVO book) {
		System.out.println(book);
		return "book/bookResult";
	}
	*/
	
	/*하나의 controller에서의 Exception처리 
	@ExceptionHandler(Exception.class)
	public String processException(Exception ex) {
		ex.printStackTrace();
		System.out.println("오류:" + ex.getMessage());
		return "error/errorPage500";
	}*/
	
	
	@RequestMapping("/list")
	public String booklist(Model model, HttpServletRequest request) {
		
		//int a=10/0;
		//System.out.println(a);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap !=null) {
			String msg = (String)flashMap.get("message");
			System.out.println(msg);
			model.addAttribute("message", msg);
		}
		model.addAttribute("booklist", blist);
		return "book/booklist";
	}
	
	@RequestMapping("/detail")
	public String bookDetail(int bno , Model model) {
		//List에서 bno찾는다.
		BookVO book = null;
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				book = b;break;
			}
		}
		
		//정보를 model에 저장한다.
		model.addAttribute("book", book);
		//detail페에지에 forward한다.
		return "book/bookdetail";  //forward 위임하다 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BookVO book , RedirectAttributes redirectAttr) {
		System.out.println("수정된Book:" + book);
		for(BookVO b : blist) {
			if(b.getBno() == book.getBno()) {
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setStatus(book.getStatus());
				b.setTitle(book.getTitle());
				break;
			}
		}
		redirectAttr.addFlashAttribute("message", "수정성공");
		return "redirect:/book/list";  //새로운 요청 
	
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int bno , RedirectAttributes redirectAttr) {
	 
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				blist.remove(b) ;
				break;
			}
		}
		redirectAttr.addFlashAttribute("message", "수정성공");
		return "redirect:/book/list";  //새로운 요청 
	
	}
	
	
	

}





