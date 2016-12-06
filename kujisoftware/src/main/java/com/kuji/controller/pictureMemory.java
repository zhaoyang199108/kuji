package com.kuji.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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

import com.kuji.dto.FiveContentView;
import com.kuji.dto.LearnExplainView;
import com.kuji.dto.PictureMemoryImgView;
import com.kuji.dto.PictureMemoryView;
import com.kuji.entity.Five;
import com.kuji.entity.LearnExplain;
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
	//private final String path = "E:\\apache-tomcat-7.0.57\\wtpwebapps\\kujisoftware\\upload\\picture\\";
	private final String path = "/usr/software/tomcat/apache-tomcat-7.0.65/webapps/kujisoftware/upload/picture/";
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
//		String  imgName = request.getParameter("imgName");//图片名称
//		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
//		List<MultipartFile> list = multipartRequest.getFiles("images[]");
//		System.out.println(list.size());
//		System.out.println(list);
		String  score = request.getParameter("score");//分数
		StringBuffer sb = new StringBuffer();
		if(files!=null && files.length>0){  
			 for(int i = 0;i<files.length;i++){  
	                MultipartFile file = files[i];  

	                try {
	                	InputStream is = file.getInputStream();
	                	File fileDir = new File(path);
	                	//判断文件夹是否存在,如果不存在则创建文件夹
		      			  if (!fileDir.exists()) {
		      				  fileDir.mkdir();
		      			  }
	                    //获取存取路径
	                    String filePath = path + file.getOriginalFilename();
	                    if(sb.length() == 0){
	                    	sb  = sb.append(filePath);
	                    }else{
	                    sb = sb.append(";"+filePath);
	                    }
	                    FileOutputStream fos = new FileOutputStream(path+URLDecoder.decode(file.getOriginalFilename(), "UTF-8"));
	                    byte[] b = new byte[1024*1024];
	        			while((is.read(b)) != -1){
	        			fos.write(b);
	        			}
	        			is.close();
	        			fos.close();
	                    // 转存文件  
//	                    file.transferTo(new File(filePath)); 
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }  
	            }
			 
			 
		}

		PictureMemory pictureMemory = new PictureMemory();
		pictureMemory.setExerciseId(1);
		pictureMemory.setPictureMemoryType(type);//类型
		pictureMemory.setPictureMemoryWhichDay(whichDay);//第几天
		pictureMemory.setPictureMemoryErrorNumber(errorNumber);//错误次数
		pictureMemory.setPictureMemoryCategory(category);//所属类别
		pictureMemory.setPictureMemoryNumber(number);//答题数量
		//pictureMemory.setImgName(imgName);//图片名字
		pictureMemory.setPictureMemoryImgName(sb.toString());
		System.out.println(sb.toString());
		pictureMemory.setPictureMemoryScore(score);//分数
	    if("1000".equals(pictureMemory.getPictureMemoryCategory())){//所属类别
	    	pictureMemory.setExerciseId(1000);//21天训练
	    }else{
	    	pictureMemory.setExerciseId(1001);//90天
	    }
		int count = pictureMemoryService.insertIntoPictureMemory(pictureMemory);//添加
		Map<String,Object> resMap = new HashMap<String, Object>();	
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}
	@RequestMapping(value = "/findAllPictureMemory", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findAllPictureMemory(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		List<PictureMemory> list_picture = pictureMemoryService.findAll();
		if(list_picture.size() == 0){
			resMap.put("code", "0");
			resMap.put("message", "无数据");
			return resMap;
		}
//		List<PictureMemoryView> listRes = new ArrayList<PictureMemoryView>();
//		for(PictureMemory i : list_picture){
//			PictureMemoryImgView piv = new PictureMemoryImgView();
//			piv.key = i
//			lev.id = i;
//			lev.url = "http://123.56.190.160:8999/kujisoftware/learnExplain/downloadLearnExplainVoice?id="+i.getLearnExplainId();
//			lev.imgUrl = "http://123.56.190.160:8999/kujisoftware/upload/explain/"+i.getLearnExplainImgPath().substring(78);
//			lev.name = i.getLearnExplainVoiceName();
//			//File f= new File(request.getSession().getServletContext().getRealPath("/") + "upload/" + i.getLearnExplainVoicePath().substring(63));  
//			File f = new File(path+i.getLearnExplainVoiceName());
//			lev.fileLength = f.length();
//			//lev.version = i.getExerciseId();
//			listRes.add(lev);
//		}
		resMap.put("code", "0");
		resMap.put("message", "查询成功");
		resMap.put("data", list_picture);
		return resMap;
	}
	@RequestMapping(value = "/findPictureByExerciseAndWhichDayAndType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findPictureByExerciseAndWhichDayAndType(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String, Object>();
		 String exerciseId = request.getParameter("exerciseId");
		 String type = request.getParameter("Type");
		 try {
				type = new String(type.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e2) {
				e2.printStackTrace();
			}
		 String whichDay = request.getParameter("whichDay");
		 PictureMemory pictureMemory = new PictureMemory();
		 pictureMemory.setPictureMemoryType(type);
		 pictureMemory.setExerciseId(Long.parseLong(exerciseId));
		 pictureMemory.setPictureMemoryWhichDay(whichDay);
		 PictureMemory picMemory =  pictureMemoryService.findPictureMemoryByExerciseAndWhichDayAndType(pictureMemory);
		if(picMemory == null || "".equals(picMemory)){
			map.put("code", "0");
			map.put("message", "该天没有数据");
			return map;
		}
		List<PictureMemoryImgView> listContentView = new ArrayList<PictureMemoryImgView>();
		String[] str = picMemory.getPictureMemoryImgName().split(";");
		for(int i = 0 ; i < str.length ; i++){
			PictureMemoryImgView piv = new PictureMemoryImgView();
			piv.key = (i+1)+"";
			piv.url = "http://123.56.190.160:8999/kujisoftware/upload/picture/"+str[i].substring(78);//win 63
			listContentView.add(piv);
		}
		PictureMemoryView pmv = new PictureMemoryView();
		pmv.pictureMemory = picMemory;
		pmv.list = listContentView;
		map.put("data", pmv);
		return map;
	}
}
