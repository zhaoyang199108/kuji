package com.kuji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/images")
public class imagesController {
	@RequestMapping(value = "/images", method = RequestMethod.GET)
	public String five(){
		return "images";
	}
	

}
