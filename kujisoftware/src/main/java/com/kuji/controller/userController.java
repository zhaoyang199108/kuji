package com.kuji.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class userController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/currentUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> currentUser(HttpServletRequest request,HttpServletResponse response) {
		// ��ȡ�б�ҳ
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", "����һ����ˢ��");
		return map;
	}
}
