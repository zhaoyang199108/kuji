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
	
	@Autowired
	private  MusicUploadService musicUploadService;
	
	@RequestMapping(value = "/musicUpload", method = RequestMethod.GET)
	public String musicUpload(){
		return "musicUpload";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		String  type = request.getParameter("type");//类型
		String  playOrder = request.getParameter("playOrder");//播放顺序
		String  music = request.getParameter("music");//音乐
		try {
			type = new String(type.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MusicUpload musicUpload = new MusicUpload();
		musicUpload.setMusic(music);//音乐
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
