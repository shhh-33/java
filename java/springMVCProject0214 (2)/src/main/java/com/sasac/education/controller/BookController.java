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
		
		blist.add(new BookVO(1, "java", "������", "�������ǻ�", "2022-02-08"));
		blist.add(new BookVO(2, "java", "������", "�������ǻ�", "2022-02-08"));
		blist.add(new BookVO(3, "java", "���Կ�", "�������ǻ�", "2022-02-08"));
		blist.add(new BookVO(4, "java", "�̹̳�", "�������ǻ�", "2022-02-08"));
		blist.add(new BookVO(5, "java", "�缭��", "�������ǻ�", "2022-02-08"));
	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bookInsert() {
		//
		return "book/bookInsertForm";
	}
	
	//@RequestParam : int bookNo = Integer.parseInt(request.getParamter("bno"))
	//@RequestParam�� �����̸��� �Ķ�����̸��� ���ٸ� �����Ѵ�. 
	//@ModelAttribute("book") : �Ķ���ͷ� ���� ���� View���� �����ϱ� 
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
		redirectAttr.addFlashAttribute("message", "�Է¼���");
		return "redirect:/book/list";
	} 
	
	/*
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(BookVO book) {
		System.out.println(book);
		return "book/bookResult";
	}
	*/
	
	/*�ϳ��� controller������ Exceptionó�� 
	@ExceptionHandler(Exception.class)
	public String processException(Exception ex) {
		ex.printStackTrace();
		System.out.println("����:" + ex.getMessage());
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
		//List���� bnoã�´�.
		BookVO book = null;
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				book = b;break;
			}
		}
		
		//������ model�� �����Ѵ�.
		model.addAttribute("book", book);
		//detail�信���� forward�Ѵ�.
		return "book/bookdetail";  //forward �����ϴ� 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BookVO book , RedirectAttributes redirectAttr) {
		System.out.println("������Book:" + book);
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
		redirectAttr.addFlashAttribute("message", "��������");
		return "redirect:/book/list";  //���ο� ��û 
	
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int bno , RedirectAttributes redirectAttr) {
	 
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				blist.remove(b) ;
				break;
			}
		}
		redirectAttr.addFlashAttribute("message", "��������");
		return "redirect:/book/list";  //���ο� ��û 
	
	}
	
	
	

}





