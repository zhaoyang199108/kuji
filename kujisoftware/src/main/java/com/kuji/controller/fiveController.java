package com.kuji.controller;

import java.io.UnsupportedEncodingException;
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
		String  type = request.getParameter("type");//类型
		String  category = request.getParameter("category");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String  score = request.getParameter("score");//分数
		try {
			category = new String(category.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			type = new String(type.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String errorNumber=request.getParameter("errorNumber");//错误次数
		Five five = new Five();
		five.setFiveContent(a);
	    five.setType(type);//类型
	    five.setCategory(category);//所属类别
	    five.setWhichDay(whichDay);//第几天
	    five.setErrorNumber(errorNumber);//错误次数
	    five.setScore(score);//分数
	    if("1".equals(five.getCategory())){//所属类别
	    	five.setExerciseId(1000);//21天训练
	    }else{
	    	five.setExerciseId(1001);//90天
	    }
		int count = fiveService.insertIntoFive(five);//保存数据
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}
}
