package com.kuji.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	private final String path = "D:\\apache-tomcat-7.0.57\\wtpwebapps\\kujisoftware\\upload\\";
	
	@Autowired
	private  LearnExplainService learnExplainService;
	@RequestMapping(value = "/learnExplain", method = RequestMethod.GET)
	public String five(){
		return "learnExplain";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response,MultipartFile file){
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        //  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile imgFile1  =  multipartRequest.getFile("ep_file");//图片
        MultipartFile imgFile2  =  multipartRequest.getFile("vo_file");//语音
        try {
			InputStream is = imgFile1.getInputStream();
			InputStream is1 = imgFile2.getInputStream();
			 File fileDir = new File(path);
			  //判断文件夹是否存在,如果不存在则创建文件夹
			  if (!fileDir.exists()) {
				  fileDir.mkdir();
			  }
			FileOutputStream fos = new FileOutputStream(path+imgFile1.getOriginalFilename());
			FileOutputStream fos1 = new FileOutputStream(path+imgFile2.getOriginalFilename());
			byte[] b = new byte[1024*1024];
			while((is.read(b)) != -1){
			fos.write(b);
			}
			while((is1.read(b)) != -1){
				fos1.write(b);
				}
			is.close();
			fos.close();
			is1.close();
			fos1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String  type = request.getParameter("type");//类型
        System.out.println(type);
		String  category = request.getParameter("category");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String  imgPath = path+imgFile1.getOriginalFilename();//图片路径
//		String  imgName = request.getParameter("imgName");//图片名称
		String  voicePath = path+imgFile2.getOriginalFilename();//语音路径
//		String  voiceName = request.getParameter("voiceName");//语音名字
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
		try {
			imgPath = new String(imgPath.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			voicePath = new String(voicePath.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.print(imgPath);
		LearnExplain learnExplain = new LearnExplain();
		learnExplain.setType(type);//类型
		learnExplain.setWhichDay(whichDay);//第几天
		learnExplain.setCategory(category);//所属类别
//		learnExplain.setVoiceName(voiceName);//语音名字
		learnExplain.setVoicePath(voicePath);//语音路径
//		learnExplain.setImgName(imgName);//图片名字
		learnExplain.setImgPath(imgPath);//图片路径
		learnExplain.setScore(score);//分数
		if("1".equals(learnExplain.getCategory())){//所属类别
			learnExplain.setExerciseId(1000);//21天训练
	    }else{
	    	learnExplain.setExerciseId(1001);//90天
	    }
		int count = learnExplainService.insertIntoLearnExplain(learnExplain);//添加
		Map<String,Object> resMap = new HashMap<String, Object>();	
		if(count>0){
			resMap.put("learnExplain", learnExplain);
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}
	
	
}
