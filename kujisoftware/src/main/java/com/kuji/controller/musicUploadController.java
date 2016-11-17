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

import com.kuji.entity.MusicUpload;
import com.kuji.service.MusicUploadService;

/**
 * 音乐上传
 * @author wudi
 *
 */
@Controller
@RequestMapping("/musicUpload")
public class musicUploadController {
	
	private final String path = "D:\\apache-tomcat-7.0.57\\wtpwebapps\\kujisoftware\\upload\\";
	
	@Autowired
	private  MusicUploadService musicUploadService;
	
	@RequestMapping(value = "/musicUpload", method = RequestMethod.GET)
	public String musicUpload(){
		return "musicUpload";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        //  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile imgFile1  =  multipartRequest.getFile("music_file");//音乐
        try {
			InputStream is = imgFile1.getInputStream();
			 File fileDir = new File(path);
			  //判断文件夹是否存在,如果不存在则创建文件夹
			  if (!fileDir.exists()) {
				  fileDir.mkdir();
			  }
			FileOutputStream fos = new FileOutputStream(path+imgFile1.getOriginalFilename());
			byte[] b = new byte[1024*1024];
			while((is.read(b)) != -1){
			fos.write(b);
			}
			is.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String  type = request.getParameter("type");//类型
		String  playOrder = request.getParameter("playOrder");//播放顺序
		String  musicPath = path+imgFile1.getOriginalFilename();//音乐
		try {
			type = new String(type.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			musicPath = new String(musicPath.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MusicUpload musicUpload = new MusicUpload();
		musicUpload.setMusic(musicPath);//音乐路径
		musicUpload.setPlayOrder(playOrder);//播放顺序
		musicUpload.setType(type);//类型
		int count = musicUploadService.insertIntoMusicUpload(musicUpload);//保存数据
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}
	
}
