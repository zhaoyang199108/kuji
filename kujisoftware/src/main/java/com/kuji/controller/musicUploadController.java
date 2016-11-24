package com.kuji.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kuji.dto.MusicView;
import com.kuji.entity.MusicUpload;
import com.kuji.service.MusicUploadService;
import com.sun.org.apache.bcel.internal.generic.AALOAD;

/**
 * 音乐上传
 * @author wudi
 *
 */
@Controller
@RequestMapping("/musicUpload")
public class musicUploadController {
	
	private final String path = "E:\\apache-tomcat-7.0.57\\wtpwebapps\\kujisoftware\\upload\\";
	
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
		byte[] b = new byte[1024*1024];
        try {
			InputStream is = imgFile1.getInputStream();
//			byteContent = readStream(is);
			 File fileDir = new File(path);
			  //判断文件夹是否存在,如果不存在则创建文件夹
			  if (!fileDir.exists()) {
				  fileDir.mkdir();
			  }
			FileOutputStream fos = new FileOutputStream(path+imgFile1.getOriginalFilename());

			while((is.read(b)) != -1){
			fos.write(b);
			}
			is.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		musicUpload.setMusicUploadMusic(musicPath);//音乐路径
		musicUpload.setMusicUploadPlayOrder(playOrder);//播放顺序
		musicUpload.setMusicUploadType(type);//类型
		musicUpload.setMusicUploadName(imgFile1.getOriginalFilename());
		int count = musicUploadService.insertIntoMusicUpload(musicUpload);//保存数据
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(count>0){
			resMap.put("code", 0);
		}else{
			resMap.put("code", 1);
		}
		return resMap;
	}
	
    public  byte[] readStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len=inStream.read(buffer))!=-1){
            outStream.write(buffer,0,len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }
	@RequestMapping(value = "/findMusic", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMusic(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		List<MusicUpload> list = musicUploadService.findAllMusic();
		System.out.println(request.getContextPath());
		System.out.println();
		String code = null;
		String message = null;
		code = list == null ?  "0":"0";
		message = list == null ?  "未上传音乐":"查询成功";
		
		List<MusicView> listRes = new ArrayList<MusicView>();
		for(MusicUpload i : list){
			MusicView mv = new MusicView();
			mv.name = i.getMusicUploadName();
			mv.url = "http://localhost:8080/kujisoftware/upload/"+i.getMusicUploadName();
			listRes.add(mv);
		}
		resMap.put("code", code);
		resMap.put("message", message);
		resMap.put("music", listRes);
		return resMap;
	}
	
	@RequestMapping(value = "/downloadMusic", method = RequestMethod.GET)
	@ResponseBody
	public String downloadMusic(HttpServletRequest request,HttpServletResponse response){
		
		return "";
	}
	
}
