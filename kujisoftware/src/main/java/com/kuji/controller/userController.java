package com.kuji.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kuji.entity.User;
import com.kuji.service.UserService;
import com.kuji.until.MD5Util;


@Controller
@RequestMapping("/user")
public class userController {
	
	public static final String USER = "userSession";// 登录人
	
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
		HttpSession session = request.getSession();
		String loginId = request.getParameter("loginId");
		String psw = request.getParameter("psw");
		String upwd = request.getParameter("upwd");
		String newPwdMd5 = MD5Util.getStringMD5(psw);
		Map<String,Object> map = new HashMap<String, Object>();
		User user = userService.findUserByUserName(loginId);
		session.setAttribute("user", user);
		session.setAttribute("upwd", newPwdMd5);
		System.out.print(newPwdMd5);
//		if(user == null){
//			map.put("code", "0");
//			map.put("message", "没有当前用户");
//			//model.addAllAttributes("data",map);
//			return "../index";
//		}
		if(MD5Util.getStringMD5(user.getPassword()).equals(newPwdMd5)){
			map.put("code", "0");
			map.put("message", "登陆成功");
			map.put("data", user);
			return "firstPage";
		}
		return "";
	}
	
	/**
	 * 设置用户到session
	 * @param session
	 * @param user
	 */

	public static void saveUserSession(HttpSession session, User user) {
		session.setAttribute(USER, user);
	}
	
	public static User getUserSession(HttpSession session){
		return (User)session.getAttribute(USER);
	}
	
	/**
	 * 退出
	 * @param session
	 */
	public static void logout(HttpSession session) {
		session.removeAttribute(USER);
	} 
	
}
