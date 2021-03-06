package com.kuji.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kuji.entity.EduCounse;
import com.kuji.service.EduCounseService;

/**
 * 教育资讯
 * @author wudi
 * 
 */
@Controller
@RequestMapping("/eduCounse")
public class eduCounseController {
	
	//private final String path = "D:\\apache-tomcat-7.0.57\\wtpwebapps\\kujisoftware\\upload\\edu\\";
	private final String path = "/usr/software/apache-tomcat-7.0.65/webapps/kujisoftware/upload/edu/";
	
	@Autowired
	private EduCounseService eduCounseService;
	
	@RequestMapping(value = "/eduCounse", method = RequestMethod.GET)
	public String eduCounse(Model model){
		String pageSize="";
		String currentPage="";
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "0";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		List<EduCounse> list_eduCounse = eduCounseService.findAll(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
		model.addAttribute("eduCounse", list_eduCounse);
		return "eduCounse";
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String  saveOrUpdate(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files){
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;             // 获得文件：         
		Map<String,Object> resMap = new HashMap<String, Object>();
		String  eduCounseTitle = request.getParameter("eduCounseTitle");
		String  eduCounseContent = request.getParameter("eduCounseContent");
		String eduCounseId = request.getParameter("id");
//		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
//		List<MultipartFile> list = multipartRequest.getFiles("images[]");
//		try {
//			eduCounseTitle = new String(eduCounseTitle.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		try {
//			eduCounseContent = new String(eduCounseContent.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
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
//		String  eduCounseImg = request.getParameter(sb.toString());
	 if(eduCounseId==null || "".equals(eduCounseId)){
				if(eduCounseTitle==null || "".equals(eduCounseTitle)){
					resMap.put("code", "3");
					resMap.put("message", "请填写标题!");
					return "redirect:eduCounse";
				}
			if(sb.toString()==null || "".equals(sb.toString())){//判断上传图片是否为空
				resMap.put("code", "3");
				resMap.put("message", "请填加图片");
				return "redirect:eduCounse";
			}else{
				EduCounse  eduCounse = new EduCounse();
				eduCounse.setEduCounseTitle(eduCounseTitle);
				eduCounse.setEduCounseImg(sb.toString());
				eduCounse.setEduCounseContent(eduCounseContent);
				EduCounse  eduCou = eduCounseService.query(eduCounseTitle);
					if(eduCou==null){
						int count = eduCounseService.insertIntoEduCounse(eduCounse);//添加
							if(count>0){
								resMap.put("code", "0");
								resMap.put("message", "增加成功");
								return "redirect:eduCounse";
							}else{
								resMap.put("code", "1");
								resMap.put("message", "操作失败");
								return "redirect:eduCounse";
							}
					}else{
						resMap.put("code", "1");
						resMap.put("message", "数据已存在");
						return "redirect:eduCounse";
					}
			}
		}else{
			if(sb.toString()==null || "".equals(sb.toString())){//判断上传图片是否为空
				resMap.put("code", "3");
				resMap.put("message", "请填加图片");
				return "redirect:eduCounse";
			}else{
				//修改,编辑
				EduCounse  eduCounse = new EduCounse();
				eduCounse.setEduCounseTitle(eduCounseTitle);
				eduCounse.setEduCounseImg(sb.toString());
				eduCounse.setEduCounseContent(eduCounseContent);
				eduCounse.setEduCounseId(Long.parseLong(eduCounseId));
//				EduCounse  eduCou = eduCounseService.query(eduCounseTitle);
//			if(eduCou==null){
				int count = eduCounseService.updateEduCounse(eduCounse);
				if(count>0){
					resMap.put("code", "0");
					resMap.put("message", "修改成功");
					return "redirect:eduCounse";
				}else{
					resMap.put("code", "1");
					resMap.put("message", "操作失败");
					return "redirect:eduCounse";
				}
//			}else{
//				resMap.put("code", "1");
//				resMap.put("message", "数据已存在");
//				return resMap;
//			}
		  }
		}
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
 		EduCounse  eduCounse = eduCounseService.findEduCounseById(Long.parseLong(id));
		if(eduCounse == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", eduCounse);
		}
		return resMap;
	
	}
	
	@RequestMapping(value = "/findEduCounseAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findEduCounseAll(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "0";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		List<EduCounse> list_eduCounse = eduCounseService.findAll(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", list_eduCounse);
		return resMap;
	}
	
	@RequestMapping(value = "/deleteEduCounse", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteEduCounse(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String eduCounseId = request.getParameter("id");
		if(eduCounseId == null || "".equals(eduCounseId)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		EduCounse  eduCounse  = eduCounseService.findEduCounseById(Long.parseLong(eduCounseId));
		if(eduCounse == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+eduCounseId+"的数据");
		}
		int count = eduCounseService.deleteEduCounseById(Long.parseLong(eduCounseId));
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
	
	@RequestMapping(value = "/findEduCounseByTitle", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findEduCounseBTitle(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		String  eduCounseTitle = request.getParameter("eduCounseTitle");//规则名称
		if(eduCounseTitle == null || "".equals(eduCounseTitle)){
			resMap.put("code", "1");
			resMap.put("message", "参数不能为空");
			return resMap;
		}
		EduCounse  eduCounse = eduCounseService.query(eduCounseTitle);
		if(eduCounse == null){
			resMap.put("code", "0");
			resMap.put("message", "没有此类型的数据");
			return resMap;
		}
		resMap.put("code", "0");
		resMap.put("message", "查询成功");
		resMap.put("data", eduCounse);
		return resMap;
	}
	
	
}
