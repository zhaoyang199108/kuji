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
		String  id = request.getParameter("id");
		String  a = request.getParameter("a");
		String  b = request.getParameter("b");
		String  c = request.getParameter("c");
		String  d = request.getParameter("d");
		String  e = request.getParameter("e");
		String  f = request.getParameter("f");
		String  g = request.getParameter("g");
		String  h = request.getParameter("h");
		String  i = request.getParameter("i");
		String  j = request.getParameter("j");
		String  k = request.getParameter("k");
		String  l = request.getParameter("l");
		String  m = request.getParameter("m");
		String  n = request.getParameter("n");
		String  o = request.getParameter("o");
		String  p = request.getParameter("p");
		String  q = request.getParameter("q");
		String  r = request.getParameter("r");
		String  s = request.getParameter("s");
		String  t = request.getParameter("t");
		String  u = request.getParameter("u");
		String  v = request.getParameter("v");
		String  w = request.getParameter("w");
		String  x = request.getParameter("x");
		
		String content=a+";"+b+";"+c+";"+d+";"+e+";"+f+";"+g+";"+h+";"+i+";"+j+";"+k+";"+l+";"+m+";"+n+";"+o+";"+p+";"+q+";"+r+";"+s+";"+t+";"+u+";"+v+";"+w+";"+x;
		System.out.println(content);
		String  type = request.getParameter("type");//类型
		String  category = request.getParameter("category");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String  score = request.getParameter("score");//分数
		try {
			category = new String(category.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			type = new String(type.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		String errorNumber=request.getParameter("errorNumber");//错误次数
		Five five = new Five();
		five.setFiveContent(content);
	    five.setType(type);//类型
	    five.setExerciseId(Long.parseLong(category));//所属类别
	    five.setWhichDay(whichDay);//第几天
	    five.setErrorNumber(errorNumber);//错误次数
	    five.setScore(score);//分数
	    Five five_find = fiveService.findFiveByDayAndTypeAndExerciseId(five);
	    if(five_find != null){
	    	Map<String,Object> resMap = new HashMap<String, Object>();
	    	resMap.put("code",1);
	    	resMap.put("message", "已存在该记录");
	    	return resMap;
	    }
	    int	 count = 0;
	    if(id == null){
	    	 count = fiveService.insertIntoFive(five);//保存数据	
	    }else{
//	    	update
	    }
		
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(count>0){
			resMap.put("code", 0);
			resMap.put("message", "保存成功");
		}else{
			resMap.put("code", 1);
			resMap.put("message", "保存失败");
		}
		return resMap;
	}
}
