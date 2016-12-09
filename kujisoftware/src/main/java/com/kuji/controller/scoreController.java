package com.kuji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuji.entity.Score;
import com.kuji.service.ScoreService;

@Controller
@RequestMapping("/score")
public class scoreController {
	private @Autowired ScoreService scoreService;
	@RequestMapping(value = "/saveScore", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveScore(HttpServletRequest request,HttpServletResponse response){
		 Map<String,Object>  resMap = new HashMap<String, Object>();
		 String score = request.getParameter("score");
		 String whichDay = request.getParameter("whichDay");
		 String type = request.getParameter("type");
		 String exerciseId = request.getParameter("exerciseId");
		 String device = request.getParameter("device");
		 if(score == null || "".equals(score)){
			 resMap.put("code", "1");
			 resMap.put("messgae", "分数为空");
			 return resMap;
		 }
		 if(whichDay == null || "".equals(whichDay)){
			 resMap.put("code", "1");
			 resMap.put("messgae", "第几天为空");
			 return resMap;
		 }
		 if(type == null || "".equals(type)){
			 resMap.put("code", "1");
			 resMap.put("messgae", "题型为空");
			 return resMap;
		 }
		 if(exerciseId == null || "".equals(exerciseId)){
			 resMap.put("code", "1");
			 resMap.put("messgae", "类别为空");
			 return resMap;
		 }
		 if(device == null || "".equals(device)){
			 resMap.put("code", "1");
			 resMap.put("messgae", "设备编号为空");
			 return resMap;
		 }
		 Score sc = new Score();
		 sc.setDevice(device);
		 sc.setExerciseId(Long.parseLong(exerciseId));
		 sc.setScore(score);
		 sc.setType(type);
		 sc.setWhichDay(whichDay);
		 Score s =  scoreService.findScoreByWhichDayAndTypeAndExerciseIdAndDevice(sc);
		 if(s != null || "".equals(s)){
			 resMap.put("code", "0");
			 resMap.put("message", "插入失败，已存在数据");
			 return resMap;
		 }
		 int count = scoreService.insertIntoScore(sc);
		 if(count>0){
			 resMap.put("code", "0");
			 resMap.put("message", "插入成功");
			 return resMap;
		 }else{
			 resMap.put("code", "1");
			 resMap.put("message", "插入失败");
			 return resMap; 
		 }
	}
	@RequestMapping(value = "/findScoreByDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findScoreById(HttpServletRequest request,HttpServletResponse response){
		 Map<String,Object>  resMap = new HashMap<String, Object>();
		 String device = request.getParameter("device");
		 if(device == null || "".equals(device)){
			 resMap.put("code", "1");
			 resMap.put("message", "device为空");
			 return resMap;
		 }
		 List<Score> score = scoreService.findScoreById(device);
		 int count = 0;
		 for(Score i : score){
			 count = count + Integer.parseInt(i.getScore());
		 }
		 if(score == null || "".equals(score)){
			 resMap.put("code", "0");
			 resMap.put("message", "未查询device="+device+"的数据");
			 return resMap;
		 }
		 resMap.put("code", "0");
		 resMap.put("message", "查询成功");
		 resMap.put("data", score);
		 resMap.put("AllScore", count);
		 return resMap; 
	}
}
