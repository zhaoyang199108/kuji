package com.kuji.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kuji.entity.PictureMemory;
import com.kuji.service.PictureMemoryService;

/**
 * 图片记忆
 * @author wudi
 *
 */
@Controller
@RequestMapping("/pictureMemory")
public class pictureMemory {

	@Autowired
	private  PictureMemoryService pictureMemoryService;
	@RequestMapping(value = "/pictureMemory", method = RequestMethod.GET)
	public String five(){
		return "pictureMemory";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response,@RequestParam("files") MultipartFile[] files){
		String  type = request.getParameter("type");//类型
		String  category = request.getParameter("category");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String errorNumber=request.getParameter("errorNumber");//错误次数
		String  number = request.getParameter("number");//答题数量
//		String  imgName = request.getParameter("imgName");//图片名称
//		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
//		List<MultipartFile> list = multipartRequest.getFiles("images[]");
//		System.out.println(list.size());
//		System.out.println(list);
		String  score = request.getParameter("score");//分数
		if(files!=null && files.length>0){  
			 for(int i = 0;i<files.length;i++){  
	                MultipartFile file = files[i];  

	                try {
	                    //获取存取路径
	                    String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();
	                    System.out.println(filePath);
	                    // 转存文件  
	                    file.transferTo(new File(filePath)); 
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }  
	            }
		}
//		try {
//			category = new String(category.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		try {
//			type = new String(type.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		PictureMemory pictureMemory = new PictureMemory();
//		pictureMemory.setExerciseId(1);
//		pictureMemory.setType(type);//类型
//		pictureMemory.setWhichDay(whichDay);//第几天
//		pictureMemory.setErrorNumber(errorNumber);//错误次数
//		pictureMemory.setCategory(category);//所属类别
//		pictureMemory.setNumber(number);//答题数量
//		//pictureMemory.setImgName(imgName);//图片名字
//		pictureMemory.setScore(score);//分数
//	    if("1".equals(pictureMemory.getCategory())){//所属类别
//	    	pictureMemory.setExerciseId(1000);//21天训练
//	    }else{
//	    	pictureMemory.setExerciseId(1001);//90天
//	    }
//		int count = pictureMemoryService.insertIntoPictureMemory(pictureMemory);//添加
		Map<String,Object> resMap = new HashMap<String, Object>();	
//		if(count>0){
//			resMap.put("code", 0);
//		}else{
//			resMap.put("code", 1);
//		}
		return resMap;
	}

	
}
