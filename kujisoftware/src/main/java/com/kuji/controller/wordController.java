package com.kuji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/word")
public class wordController {
	@RequestMapping(value = "/word", method = RequestMethod.GET)
	public String five(){
		return "words";
	}
}
