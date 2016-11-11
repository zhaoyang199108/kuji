package com.kuji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 速度训练
 * @author wudi
 *
 */
@Controller
@RequestMapping("/speed")
public class speedController {

	@RequestMapping(value = "/speed", method = RequestMethod.GET)
	public String speed(){
		return "speed";
	}
}
