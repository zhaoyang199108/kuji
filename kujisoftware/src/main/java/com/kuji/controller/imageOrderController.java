package com.kuji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/imageOrder")
public class imageOrderController {
	@RequestMapping(value = "/imgOrder", method = RequestMethod.GET)
	public String imgOrder(){
		return "imgOrder";
	}
}
