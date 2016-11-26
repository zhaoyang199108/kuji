package com.kuji.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuji.entity.Help;
import com.kuji.service.HelpService;

@Controller
@RequestMapping("/help")
public class helpController {
	private @Autowired HelpService helpService;
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help(Model model){
		List<Help> list_help = helpService.findAll();
		model.addAttribute("help", list_help);
		return "help";
	}
	@RequestMapping(value = "/saveHelp", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveHelp(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String whichExercise = request.getParameter("whichExercise");
		String content = request.getParameter("content");
		if(whichExercise == null || "".equals(whichExercise)){
			resMap.put("code", "1");
			resMap.put("message", "参数不能为空");
			return resMap;
		}
		if(content == null || "".equals(content)){
			resMap.put("code", "1");
			resMap.put("message", "参数不能为空");
			return resMap;
		}
		try {
			content = new String(content.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if(id==null || "".equals(id)){
		
		
		Help help = new Help();
		help.setHelpContent(content);
		help.setExerciseId(Long.parseLong(whichExercise));
		Help help_find = helpService.findHelpByExerciseId(Long.parseLong(whichExercise));
		if(help_find == null){
			int count = helpService.insertIntoHelp(help);
			if(count>0){
				resMap.put("code", "0");
				resMap.put("message", "增加成功");
				return resMap;
			}else{
				resMap.put("code", "1");
				resMap.put("message", "操作失败");
				return resMap;
			}
		}else{
			resMap.put("code", "1");
			resMap.put("message", "数据已存在");
			return resMap;
		}
		}else{
			Help help = new Help();
			help.setHelpContent(content);
			help.setExerciseId(Long.parseLong(whichExercise));
			help.setHelpId(Long.parseLong(id));
			int count = helpService.updateHelp(help);
			if(count>0){
				resMap.put("code", "0");
				resMap.put("message", "修改成功");
				return resMap;
			}else{
				resMap.put("code", "1");
				resMap.put("message", "操作失败");
				return resMap;
			}
		}
		  
	}
	@RequestMapping(value = "/findHelpByExerciseId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findHelpByExerciseId(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		String whichExercise = request.getParameter("whichExercise");
		if(whichExercise == null || "".equals(whichExercise)){
			resMap.put("code", "1");
			resMap.put("message", "参数不能为空");
			return resMap;
		}
		Help help_find = helpService.findHelpByExerciseId(Long.parseLong(whichExercise));
		if(help_find == null){
			resMap.put("code", "0");
			resMap.put("message", "没有此类型的数据");
			return resMap;
		}
		resMap.put("code", "0");
		resMap.put("message", "查询成功");
		resMap.put("data", help_find);
		return resMap;
	}
	
	@RequestMapping(value = "/deleteHelp", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteHelp(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		Help help = helpService.findHelpById(Long.parseLong(id));
		if(help == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}
		int count = helpService.deleteHelpById(Long.parseLong(id));
		if(count > 0){
			resMap.put("code","0");
			resMap.put("message", "删除成功");
			return resMap;
		}else{
			resMap.put("code","0");
			resMap.put("message", "删除失败");
			return resMap;
		}
	
	}
	
	@RequestMapping(value = "/findHelpById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findHelpById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		Help help = helpService.findHelpById(Long.parseLong(id));
		if(help == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", help);
		}
		return resMap;
	
	}
}
