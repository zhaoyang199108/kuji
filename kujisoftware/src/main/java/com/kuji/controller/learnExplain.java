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

import com.kuji.entity.LearnExplain;
import com.kuji.service.LearnExplainService;

/**
 * 学习记忆
 * @author wudi
 *
 */
@Controller
@RequestMapping("/learnExplain")
public class learnExplain {

	@Autowired
	private  LearnExplainService learnExplainService;
	@RequestMapping(value = "/learnExplain", method = RequestMethod.GET)
	public String five(){
		return "learnExplain";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		String  type = request.getParameter("type");//类型
		String  category = request.getParameter("category");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
//		String  imgPath = request.getParameter("imgPath");//图片路径
		String  imgName = request.getParameter("imgName");//图片名称
//		String  voicePath = request.getParameter("voicePath");//语音路径
		String  voiceName = request.getParameter("voiceName");//语音名字
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
		LearnExplain learnExplain = new LearnExplain();
		learnExplain.setType(type);//类型
		learnExplain.setWhichDay(whichDay);//第几天
		learnExplain.setCategory(category);//所属类别
		learnExplain.setVoiceName(voiceName);//语音名字
//		learnExplain.setVoicePath(voicePath);//语音路径
		learnExplain.setImgName(imgName);//图片名字
//		learnExplain.setImgPath(imgPath);//图片路径
		learnExplain.setScore(score);//分数
		if("1".equals(learnExplain.getCategory())){//所属类别
			learnExplain.setExerciseId(1000);//21天训练
	    }else{
	    	learnExplain.setExerciseId(1001);//90天
	    }
		int count = learnExplainService.insertIntoLearnExplain(learnExplain);//添加
		Map<String,Object> resMap = new HashMap<String, Object>();	
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}
	
}
