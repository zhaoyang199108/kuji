package com.kuji.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/questionFive")
public class fiveController {
	@RequestMapping(value = "/five", method = RequestMethod.GET)
	public String five(){
		return "five";
	}
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String five(HttpServletRequest request){
		String upload = request.getParameter("ep_file");
		System.out.println(upload);
		return "five";
	}
}
