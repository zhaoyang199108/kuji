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

import com.kuji.entity.Mandara;
import com.kuji.service.MandaraService;

/**
 * 曼陀罗
 * @author wudi
 *
 */

@Controller
@RequestMapping("/mandara")
public class mandaraController {
	
	private @Autowired MandaraService mandaraService;
	@RequestMapping(value = "/mandara", method = RequestMethod.GET)
	public String mandara(Model model){
		List<Mandara> list_mandara = mandaraService.findAll();
		model.addAttribute("mandara", list_mandara);
		return "mandara";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String  id = request.getParameter("id");
		String  type = request.getParameter("type");//类型
		String  exerciseId = request.getParameter("exerciseId");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String  score = request.getParameter("score");//分数
//		try {
//			type = new String(type.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e2) {
//			e2.printStackTrace();
//		}
		String errorNumber=request.getParameter("errorNumber");//错误次数
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		if(errorNumber == null || "".equals(errorNumber)){
			resMap.put("code", "1");
			resMap.put("message", "请填写错误次数!");
			return resMap;
		}
		
		if(score == null || "".equals(score)){
			resMap.put("code", "1");
			resMap.put("message", "请填写分值!");
			return resMap;
		}
		
		if(id==null || "".equals(id)){
			Mandara mandara = new Mandara();
			mandara.setType(type);//类型
			mandara.setExerciseId(Long.parseLong(exerciseId));//所属类别
			mandara.setWhichDay(whichDay);//第几天
			mandara.setErrorNumber(errorNumber);//错误次数
			mandara.setScore(score);//分数
		    Mandara mandara_find = mandaraService.findMandaraByDayAndTypeAndExerciseId(mandara);
		    if(mandara_find != null){
		    	resMap.put("code",1);
		    	resMap.put("message", "已存在该记录");
		    	return resMap;
		    }else{
		    	int count = mandaraService.insertIntoMandara(mandara);//保存数据	
		    	if(count>0){
					resMap.put("code", "0");
					resMap.put("message", "增加成功");
					return resMap;
				}else{
					resMap.put("code", "1");
					resMap.put("message", "操作失败");
					return resMap;
				}
		    }
		}else{
			Mandara mandara = new Mandara();
			mandara.setType(type);//类型
			mandara.setExerciseId(Long.parseLong(exerciseId));//所属类别
			mandara.setWhichDay(whichDay);//第几天
			mandara.setErrorNumber(errorNumber);//错误次数
			mandara.setScore(score);//分数
			mandara.setId(Long.parseLong(id));
			int count = mandaraService.updateMandara(mandara);
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
	
	@RequestMapping(value = "/findMandaraById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMandaraById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		Mandara mandara = mandaraService.findMandaraById(Long.parseLong(id));
		if(mandara == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", mandara);
		}
		return resMap;
	}
	
	@RequestMapping(value = "/findMandaraByExerciseAndWhichDayAndType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMandaraByExerciseAndWhichDayAndType(HttpServletRequest request,HttpServletResponse response){
		 Map<String,Object>  map = new HashMap<String, Object>();
		 String exerciseId = request.getParameter("exerciseId");
		 String type = request.getParameter("type");
		 try {
				type = new String(type.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e2) {
				e2.printStackTrace();
			}
		 String whichDay = request.getParameter("whichDay");
		 Mandara mandara = new Mandara();
		 mandara.setType(type);//类型
		 mandara.setExerciseId(Long.parseLong(exerciseId));//所属类别
		 mandara.setWhichDay(whichDay);//第几天
		 Mandara mandara_find = mandaraService.findMandaraByDayAndTypeAndExerciseId(mandara);
		if(mandara_find == null ||"".equals(mandara_find)){
			map.put("code", "0");
			map.put("message", "该天没有数据");
			return map;
		}
		map.put("code", "0");
		map.put("message", "查询成功");
		map.put("data", mandara_find);
		 return map;
	}

}
