package com.kuji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 修改密码
 * @author wudi
 *
 */
@Controller
@RequestMapping("/modiPass")
public class modiPassController {


	@RequestMapping(value = "/modiPass", method = RequestMethod.GET)
	public String modiPass(){
		return "modiPass";
	}
}
