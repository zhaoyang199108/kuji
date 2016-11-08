package com.kuji.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuji.entity.Five;
import com.kuji.service.FiveService;

@Controller
@RequestMapping("/questionFive")
public class fiveController {
	
	private @Autowired FiveService fiveService;
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
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		String  a = request.getParameter("a");
		Five five = new Five();
		five.setExerciseId(1);
		five.setFiveContent(a);
		five.setErrorNumber("5");
		int count = fiveService.insertIntoFive(five);
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		
		
		
		return resMap;
	}
}
