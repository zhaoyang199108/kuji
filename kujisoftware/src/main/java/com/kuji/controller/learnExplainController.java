package com.kuji.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kuji.dto.LearnExplainView;
import com.kuji.dto.MusicView;
import com.kuji.entity.LearnExplain;
import com.kuji.entity.MusicUpload;
import com.kuji.service.LearnExplainService;

/**
 * 学习记忆
 * @author wudi
 *
 */
@Controller
@RequestMapping("/learnExplain")
public class learnExplainController {

	//private final String path = "E:\\apache-tomcat-7.0.57\\wtpwebapps\\kujisoftware\\upload\\explain\\";
	private final String path = "/usr/software/tomcat/apache-tomcat-7.0.65/webapps/kujisoftware/upload/explain/";
	@Autowired
	private  LearnExplainService learnExplainService;
	@RequestMapping(value = "/learnExplain", method = RequestMethod.GET)
	public String learnExplain(Model model){
		List<LearnExplain> list_help = learnExplainService.findAll();
		model.addAttribute("help", list_help);
		return "learnExplain";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String saveOrUpdate(HttpServletRequest request,HttpServletResponse response,MultipartFile file){
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		Map<String,Object> resMap = new HashMap<String, Object>();	
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
//			FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("\\") + "upload\\explain\\"+imgFile1.getOriginalFilename());
//			FileOutputStream fos1 = new FileOutputStream(request.getSession().getServletContext().getRealPath("\\") + "upload\\explain\\"+imgFile2.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(path+URLDecoder.decode(imgFile1.getOriginalFilename(), "UTF-8"));
			FileOutputStream fos1 = new FileOutputStream(path+URLDecoder.decode(imgFile2.getOriginalFilename(), "UTF-8")); 
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
		String  learnExplainType = request.getParameter("learnExplainType");//类型
		String  exerciseId = request.getParameter("exerciseId");//所属类别
		String  learnExplainWhichDay = request.getParameter("learnExplainWhichDay");//第几天
		String  learnExplainImgPath = request.getSession().getServletContext().getRealPath("/") + "upload/explain/"+imgFile1.getOriginalFilename();//图片路径
		String  learnExplainVoicePath = request.getSession().getServletContext().getRealPath("/") + "upload/explain/"+imgFile2.getOriginalFilename();//语音路径
		String  learnExplainScore = request.getParameter("learnExplainScore");//分数
		try {
			learnExplainType = new String(learnExplainType.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			learnExplainImgPath = new String(learnExplainImgPath.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			learnExplainVoicePath = new String(learnExplainVoicePath.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		LearnExplain learnExplain = new LearnExplain();
		learnExplain.setLearnExplainType(learnExplainType);//类型
		learnExplain.setLearnExplainWhichDay(learnExplainWhichDay);//第几天
		learnExplain.setExerciseId(Long.parseLong(exerciseId));//所属类别
		learnExplain.setLearnExplainVoicePath(learnExplainVoicePath);//语音路径
		learnExplain.setLearnExplainImgPath(learnExplainImgPath);//图片路径
		learnExplain.setLearnExplainScore(learnExplainScore);//分数
		learnExplain.setLearnExplainVoiceName(imgFile2.getOriginalFilename());
		  if(imgFile1.getOriginalFilename()==null || "".equals(imgFile1.getOriginalFilename())||
			  imgFile2.getOriginalFilename()==null || "".equals(imgFile2.getOriginalFilename())){
	        	resMap.put("code", "3");
	        	resMap.put("message", "请上传图片或语音！");
	        }else{
	        	int count1 = learnExplainService.query(learnExplainType,exerciseId,learnExplainWhichDay);
	        	if(count1==0){
			    	resMap.put("code", "2");
			    	resMap.put("message", "该题型已存在");
			    }else{
					int count = learnExplainService.insertIntoLearnExplain(learnExplain);//添加
					if(count>0){
						resMap.put("learnExplain", learnExplain);
						resMap.put("code", 0);
					}else{
						resMap.put("code", 1);
					}
			    }
	        }
		return "learnExplain";
	}
	
	@RequestMapping(value = "/deleteLearnExplain", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteLearnExplain(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		LearnExplain learnExplain = learnExplainService.findLearnExplainById(Long.parseLong(id));
		if(learnExplain == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}
		int count = learnExplainService.deleteLearnExplainById(Long.parseLong(id));
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
	@RequestMapping(value = "/findAllLearnExplain", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findAllLearnExplain(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		List<LearnExplain> list_explain = learnExplainService.findAll();
		if(list_explain.size() == 0){
			resMap.put("code", "0");
			resMap.put("message", "无数据");
			return resMap;
		}
		List<LearnExplainView> listRes = new ArrayList<LearnExplainView>();
		for(LearnExplain i : list_explain){
			LearnExplainView lev = new LearnExplainView();
			lev.id = i.getLearnExplainId();
			lev.url = "http://123.56.190.160:8999/kujisoftware/learnExplain/downloadLearnExplainVoice?id="+i.getLearnExplainId();
			lev.name = i.getLearnExplainVoiceName();
			//File f= new File(request.getSession().getServletContext().getRealPath("/") + "upload/" + i.getLearnExplainVoicePath().substring(63));  
			File f = new File(path+i.getLearnExplainVoiceName());
			lev.fileLength = f.length();
			//lev.version = i.getExerciseId();
			listRes.add(lev);
		}
		resMap.put("code", "0");
		resMap.put("message", "查询成功");
		resMap.put("data", listRes);
		return resMap;
		
	}
	@RequestMapping(value = "/findLearnExplainById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findLearnExplainById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message", "参数不能为空");
			return resMap;
		}
		LearnExplain learnExplain = learnExplainService.findLearnExplainById(Long.parseLong(id));
		if(learnExplain == null){
			resMap.put("code", "0");
			resMap.put("message", "未查询到数据");
			return resMap;
		}
		resMap.put("code", "0");
		resMap.put("message", "查询成功");
		resMap.put("data", learnExplain);
		return resMap;
		
	}
	@RequestMapping(value = "/downloadLearnExplainVoice", method = RequestMethod.GET)
	public String  downloadMusic(HttpServletRequest request,HttpServletResponse response){
		
		String id = request.getParameter("id");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		if(id==null || "".equals(id)){
			return "";
		}
		LearnExplain learnExplain = learnExplainService.findLearnExplainById(Long.parseLong(id));
		//System.out.println(learnExplain.getLearnExplainVoicePath().split("\\")[0]);
		 try {
			InputStream fis = new BufferedInputStream(new FileInputStream(path+learnExplain.getLearnExplainVoiceName()));
			byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="+learnExplain.getLearnExplainVoiceName());
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/downloadLearnExplainImgPath", method = RequestMethod.GET)
	public String  downloadLearnExplainImgPath(HttpServletRequest request,HttpServletResponse response){
		
		String id = request.getParameter("id");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		if(id==null || "".equals(id)){
			return "";
		}
		LearnExplain learnExplain = learnExplainService.findLearnExplainById(Long.parseLong(id));
		System.out.println(learnExplain.getLearnExplainImgPath().substring(55));
		 try {
			InputStream fis = new BufferedInputStream(new FileInputStream(request.getSession().getServletContext().getRealPath("\\") + "upload\\explain\\"+"/"+learnExplain.getLearnExplainVoicePath().substring(63)));
			byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="+learnExplain.getLearnExplainImgPath().substring(63));
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
