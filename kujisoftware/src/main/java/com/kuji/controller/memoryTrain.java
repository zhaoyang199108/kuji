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

import com.kuji.entity.MemoryTrain;
import com.kuji.service.MemoryTrainService;

@Controller
@RequestMapping("/memoryTrain")
public class memoryTrain {
	
	@Autowired
	private  MemoryTrainService memoryTrainService;
	@RequestMapping(value = "/memoryTrain", method = RequestMethod.GET)
	public String five(){
		return "memoryTrain";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
//		String  a = request.getParameter("a");
		String  type = request.getParameter("type");//类型
		String  category = request.getParameter("category");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String errorNumber=request.getParameter("errorNumber");//错误次数
		String  words = request.getParameter("words");//词语
//		String  anwserTime = request.getParameter("anwserTime");//答题时间
		String  number = request.getParameter("number");//答题数量
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
		MemoryTrain memoryTrain = new MemoryTrain();
		memoryTrain.setType(type);//类型
		memoryTrain.setWhichDay(whichDay);//第几天
		memoryTrain.setErrorNumber(errorNumber);//错误次数
		memoryTrain.setCategory(category);//所属类别
		memoryTrain.setWords(words);//词语
		memoryTrain.setNumber(number);//答题数量
//		memoryTrain.setAnwserTime(anwserTime);//答题时间
		memoryTrain.setScore(score);//分数
	    if("1".equals(memoryTrain.getCategory())){//所属类别
	    	memoryTrain.setExerciseId(1000);//21天训练
	    }else{
	    	memoryTrain.setExerciseId(1001);//90天
	    }
		int count = memoryTrainService.insertIntoMemoryTrain(memoryTrain);//添加
		Map<String,Object> resMap = new HashMap<String, Object>();	
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}

}
