package com.kuji.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuji.entity.User;
import com.kuji.service.UserService;

/**
 * 修改密码
 * @author wudi
 *
 */
@Controller
@RequestMapping("/modiPass")
public class modiPassController {
	
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value = "/modiPass", method = RequestMethod.GET)
	public String modiPass(){
		return "modiPass";
	}
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/mofifyPassword", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> mofifyPassword(HttpServletRequest request,HttpServletResponse response,
			Model model) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String  oldPwd = request.getParameter("oldPassword");//旧密码
		String  newPwd = request.getParameter("newPassword");//新密码
		String re =request.getParameter("re");//新密码
		User user=(User)session.getAttribute("user"); 
		if(user==null){
			resMap.put("code", "2");
			resMap.put("message", "用户未登录");
			
			return resMap;
		}
		User user_find= userService.findUserByUserName(user.getUserName());
		if(oldPwd == null  ||  "".equals(oldPwd)){
			resMap.put("code", "1");
			resMap.put("message", "原密码为空");
			return resMap;
		}
		if(newPwd == null  ||  "".equals(newPwd)){
			resMap.put("code", "1");
			resMap.put("message", "新密码为空");
			return resMap;
		}
		if(re == null  ||  "".equals(re)){
			resMap.put("code", "1");
			resMap.put("message", "再次输入密码为空");
			return resMap;
		}
		if(!re.equals(newPwd)){
			resMap.put("code", "1");
			resMap.put("message", "两次输入密码不一致");
			return resMap;
		}
		System.out.println(user.getUpwd());
		int count = userService.updatePwd(user, oldPwd, newPwd);
		if(count>0){		
			resMap.put("code", "0");
			resMap.put("message", "修改成功");
			return resMap;
		}
		resMap.put("code", "1");
		resMap.put("message", "修改失败");
		return resMap;
	}
}
