package com.kuji.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuji.entity.User;
import com.kuji.service.UserService;


@Controller
@RequestMapping("/user")
public class userController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private @Autowired UserService userService;
	@RequestMapping(value = "/firstPage", method = RequestMethod.GET)
	//@ResponseBody
	public String currentUser(Model model) {
		Map<String,Object> map = new HashMap<String, Object>();
		return "firstPage";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,HttpServletResponse response,Model model) {
		String loginId = request.getParameter("loginId");
		String psw = request.getParameter("psw");
		Map<String,Object> map = new HashMap<String, Object>();
		User user = userService.findUserByUserName(loginId);
		
//		if(user == null){
//			map.put("code", "0");
//			map.put("message", "没有当前用户");
//			//model.addAllAttributes("data",map);
//			return "../index";
//		}
		if(user.getPassword().equals(psw)){
			map.put("code", "0");
			map.put("message", "登陆成功");
			map.put("data", user);
			return "firstPage";
		}
		return "";
	}
}
