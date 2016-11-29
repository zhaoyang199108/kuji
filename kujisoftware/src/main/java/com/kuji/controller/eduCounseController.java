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

import com.kuji.entity.EduCounse;
import com.kuji.entity.TypeRules;
import com.kuji.service.EduCounseService;

/**
 * 教育资讯
 * @author wudi
 *
 */
@Controller
@RequestMapping("/eduCounse")
public class eduCounseController {
	
	@Autowired
	private EduCounseService eduCounseService;
	
	@RequestMapping(value = "/eduCounse", method = RequestMethod.GET)
	public String eduCounse(Model model){
		List<EduCounse> list_eduCounse = eduCounseService.findAll();
		model.addAttribute("eduCounse", list_eduCounse);
		return "eduCounse";
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		String  eduCounseTitle = request.getParameter("eduCounseTitle");
		String  eduCounseImg = request.getParameter("eduCounseImg");
		String  eduCounseContent = request.getParameter("eduCounseContent");
		try {
			eduCounseTitle = new String(eduCounseTitle.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			eduCounseContent = new String(eduCounseContent.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		EduCounse  eduCounse = new EduCounse();
		eduCounse.setEduCounseTitle(eduCounseTitle);
		eduCounse.setEduCounseImg(eduCounseImg);
		eduCounse.setEduCounseContent(eduCounseContent);
		if(eduCounseTitle==null || "".equals(eduCounseTitle)){
			resMap.put("code", "3");
			resMap.put("message", "请填写标题!");
		}
		if(eduCounseImg==null || "".equals(eduCounseImg)){
			resMap.put("code", "3");
			resMap.put("message", "请填加图片");
		}else{
			int count1 = eduCounseService.query(eduCounseTitle);
        	if(count1==0){
		    	resMap.put("code", "2");
		    	resMap.put("message", "该规则说明已存在!");
		    }else{
				int count = eduCounseService.insertIntoEduCounse(eduCounse);//添加
				if(count>0){
					resMap.put("eduCounse", eduCounse);
					resMap.put("code", 0);
				}else{
					resMap.put("code", 1);
				}
		    }
		}
		return resMap;
	}
	
	@RequestMapping(value = "/findEduCounseById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findEduCounseById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		TypeRules typeRules = eduCounseService.findEduCounseById(Long.parseLong(id));
		if(typeRules == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", typeRules);
		}
		return resMap;
	
	}
	
	@RequestMapping(value = "/findEduCounseAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findEduCounseAll(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		List<EduCounse> list_eduCounse = eduCounseService.findAll();
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", list_eduCounse);
		return resMap;
	}
}
