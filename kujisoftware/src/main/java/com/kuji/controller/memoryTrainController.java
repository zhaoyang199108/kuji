package com.kuji.controller;

import java.io.UnsupportedEncodingException;
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

import com.kuji.dto.MemoryTrainView;
import com.kuji.dto.MemoryTrainWordsView;
import com.kuji.entity.MemoryTrain;
import com.kuji.service.MemoryTrainService;

@Controller
@RequestMapping("/memoryTrain")
public class memoryTrainController {
	
	@Autowired
	private  MemoryTrainService memoryTrainService;
	@RequestMapping(value = "/memoryTrain", method = RequestMethod.GET)
	public String memoryTrain(Model model){
		List<MemoryTrain> list_memoryTrain = memoryTrainService.findAll();
		model.addAttribute("memoryTrain", list_memoryTrain);
		return "memoryTrain";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();	
		String  id = request.getParameter("id");//id
		String  exerciseId = request.getParameter("exerciseId");//类型
		String  memoryTrainType = request.getParameter("type");//类型
		String  memoryTrainWhichDay = request.getParameter("whichDay");//第几天
		String memoryTrainErrorNumber=request.getParameter("errorNumber");//错误次数
		String  memoryTrainWords = request.getParameter("words");//词语
		String  memoryTrainNumber = request.getParameter("number");//答题数量
		String  memoryTrainScore = request.getParameter("score");//分数
		try {
			memoryTrainType = new String(memoryTrainType.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(memoryTrainWords==null || "".equals(memoryTrainWords)){
			resMap.put("code", "1");
			resMap.put("message", "请填写词语!");
			return resMap;
		}
		if(memoryTrainNumber==null || "".equals(memoryTrainNumber)){
			resMap.put("code", "1");
			resMap.put("message", "请填写数量!");
			return resMap;
		}
		if(memoryTrainErrorNumber==null || "".equals(memoryTrainErrorNumber)){
			resMap.put("code", "1");
			resMap.put("message", "请填写错误次数!");
			return resMap;
		}
		if(memoryTrainScore==null || "".equals(memoryTrainScore)){
			resMap.put("code", "1");
			resMap.put("message", "请填写分值!");
			return resMap;
		}
		if(id==null || "".equals(id)){
			MemoryTrain memoryTrain = new MemoryTrain();
			memoryTrain.setMemoryTrainType(memoryTrainType);//类型
			memoryTrain.setMemoryTrainWhichDay(memoryTrainWhichDay);//第几天
			memoryTrain.setMemoryTrainErrorNumber(memoryTrainErrorNumber);//错误次数
			memoryTrain.setMemoryTrainWords(memoryTrainWords);//词语
			memoryTrain.setMemoryTrainNumber(memoryTrainNumber);//答题数量
			memoryTrain.setMemoryTrainScore(memoryTrainScore);//分数
			memoryTrain.setExerciseId(Long.parseLong(exerciseId));//所属类别
			int  count_find = memoryTrainService.query(memoryTrainType, memoryTrainWhichDay, exerciseId);//校验此题型是否重复
			if(count_find==0){
				resMap.put("code", "1");
				resMap.put("message", "该题型已存在!");
				return resMap;
			}else{
				int count = memoryTrainService.insertIntoMemoryTrain(memoryTrain);//添加
				if(count>0){
					resMap.put("code", 	"0");
					resMap.put("message", "添加成功!");
					resMap.put("memoryTrain", memoryTrain);
					return resMap;
				}else{
					resMap.put("code", "1");
					resMap.put("message", "添加失败!");
				}
			}
		}else{
			MemoryTrain memoryTrain = new MemoryTrain();
			memoryTrain.setMemoryTrainType(memoryTrainType);//类型
			memoryTrain.setMemoryTrainWhichDay(memoryTrainWhichDay);//第几天
			memoryTrain.setMemoryTrainErrorNumber(memoryTrainErrorNumber);//错误次数
			memoryTrain.setMemoryTrainWords(memoryTrainWords);//词语
			memoryTrain.setMemoryTrainNumber(memoryTrainNumber);//答题数量
			memoryTrain.setMemoryTrainScore(memoryTrainScore);//分数
			memoryTrain.setExerciseId(Long.parseLong(exerciseId));//所属类别
			memoryTrain.setMemoryTrainId(Long.parseLong(id));
			int count = memoryTrainService.updateMemoryTrain(memoryTrain);//修改
			if(count>0){
				resMap.put("memoryTrain", memoryTrain);
				resMap.put("code", "0");
				resMap.put("message", "修改成功!");
			}else{
				resMap.put("memoryTrain", memoryTrain);
				resMap.put("code", "1");
				resMap.put("message", "操作失败!");
			}
		}
		return resMap;
	}
	
	@RequestMapping(value = "/findMemoryTrainByExerciseAndWhichDayAndType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMemoryTrainByExerciseAndWhichDayAndType(HttpServletRequest request,HttpServletResponse response){
		 Map<String,Object>  map = new HashMap<String, Object>();
		 String exerciseId = request.getParameter("exerciseId");
		 String type = request.getParameter("type");
		 String whichDay = request.getParameter("whichDay");
//		String s= request.getSession().getServletContext().getRealPath("/") + "upload/";
//		System.out.print(s);
		 MemoryTrain memoryTrain = new MemoryTrain();
		 try {
				type = new String(type.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e2) {
				e2.printStackTrace();
			}
			memoryTrain.setMemoryTrainType(type);//类型
			memoryTrain.setMemoryTrainWhichDay(whichDay);//第几天
		 memoryTrain.setExerciseId(Long.parseLong(exerciseId));//所属类别
		 MemoryTrain memoryTrain_find = memoryTrainService.findMemoryTrainByExerciseAndWhichDayAndType(memoryTrain);
		if(memoryTrain_find == null ||"".equals(memoryTrain_find)){
			map.put("code", "0");
			map.put("message", "该天没有数据");
			return map;
		}
		map.put("code", "0");
		map.put("message", "查询成功");
		map.put("data", memoryTrain_find);
		List<MemoryTrainWordsView> listWordsView = new ArrayList<MemoryTrainWordsView>();
		String memoryTrainWords = memoryTrain_find.getMemoryTrainWords();
		String[] rightWords = memoryTrainWords.split(";");
		for(int i = 0; i < rightWords.length; i++){
			MemoryTrainWordsView mcv = new MemoryTrainWordsView();
			mcv.key = (i+1)+"";
			mcv.value = rightWords[i];
			listWordsView.add(mcv);
		}
		MemoryTrainView mv = new MemoryTrainView();
		mv.memoryTrain = memoryTrain_find;
		mv.memoryTrainWordsView = listWordsView;
		map.put("code", "0");
		map.put("message", "查询成功");
		map.put("data", mv);
		
		 return map;
	}
	
	@RequestMapping(value = "/deleteMemoryTrain", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteMemoryTrain(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		 MemoryTrain memoryTrain = memoryTrainService.findMemoryTrainById(Long.parseLong(id));
		if(memoryTrain == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}
		int count = memoryTrainService.deleteMemoryTrainById(Long.parseLong(id));
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
	
	@RequestMapping(value = "/findMemoryTrainById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMemoryTrainById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		MemoryTrain memoryTrain= memoryTrainService.findMemoryTrainById(Long.parseLong(id));
		
		if(memoryTrain == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", memoryTrain);
		}
		return resMap;
	
	}

}
