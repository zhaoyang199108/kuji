package com.kuji.controller;

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

import com.kuji.dto.FiveContentView;
import com.kuji.dto.FiveView;
import com.kuji.entity.Five;
import com.kuji.service.FiveService;

@Controller
@RequestMapping("/questionFive")
public class fiveController {
	
	private @Autowired FiveService fiveService;
	@RequestMapping(value = "/five", method = RequestMethod.GET)
	public String five(Model model){
		List<Five> list_five = fiveService.findAll();
		model.addAttribute("five", list_five);
		return "five";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String five(HttpServletRequest request){
		String upload = request.getParameter("ep_file");
		System.out.println(upload);
		return "five";
	}
	
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveOrUpdate(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String  id = request.getParameter("id");
		String  a = request.getParameter("a");
		String  b = request.getParameter("b");
		String  c = request.getParameter("c");
		String  d = request.getParameter("d");
		String  e = request.getParameter("e");
		String  f = request.getParameter("f");
		String  g = request.getParameter("g");
		String  h = request.getParameter("h");
		String  i = request.getParameter("i");
		String  j = request.getParameter("j");
		String  k = request.getParameter("k");
		String  l = request.getParameter("l");
		String  m = request.getParameter("m");
		String  n = request.getParameter("n");
		String  o = request.getParameter("o");
		String  p = request.getParameter("p");
		String  q = request.getParameter("q");
		String  r = request.getParameter("r");
		String  s = request.getParameter("s");
		String  t = request.getParameter("t");
		String  u = request.getParameter("u");
		String  v = request.getParameter("v");
		String  w = request.getParameter("w");
		String  x = request.getParameter("x");
		String  y = request.getParameter("y");
//		try {
//			a = new String(a.getBytes("iso-8859-1"),"utf-8");
//			//a = URLDecoder.decode(a);
//			b = new String(b.getBytes("iso-8859-1"),"utf-8");
//			c = new String(c.getBytes("iso-8859-1"),"utf-8");
//			d = new String(d.getBytes("iso-8859-1"),"utf-8");
//			e = new String(e.getBytes("iso-8859-1"),"utf-8");
//			f = new String(f.getBytes("iso-8859-1"),"utf-8");
//			g = new String(g.getBytes("iso-8859-1"),"utf-8");
//			h = new String(h.getBytes("iso-8859-1"),"utf-8");
//			i = new String(i.getBytes("iso-8859-1"),"utf-8");
//			j = new String(j.getBytes("iso-8859-1"),"utf-8");
//			k = new String(k.getBytes("iso-8859-1"),"utf-8");
//			l = new String(l.getBytes("iso-8859-1"),"utf-8");
//			m = new String(m.getBytes("iso-8859-1"),"utf-8");
//			n = new String(n.getBytes("iso-8859-1"),"utf-8");
//			o = new String(o.getBytes("iso-8859-1"),"utf-8");
//			p = new String(p.getBytes("iso-8859-1"),"utf-8");
//			q = new String(q.getBytes("iso-8859-1"),"utf-8");
//			r = new String(r.getBytes("iso-8859-1"),"utf-8");
//			s = new String(s.getBytes("iso-8859-1"),"utf-8");
//			t = new String(t.getBytes("iso-8859-1"),"utf-8");
//			u = new String(u.getBytes("iso-8859-1"),"utf-8");
//			v = new String(v.getBytes("iso-8859-1"),"utf-8");
//			w = new String(w.getBytes("iso-8859-1"),"utf-8");
//			x = new String(x.getBytes("iso-8859-1"),"utf-8");
//			y = new String(y.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		if((a == null || "".equals(a))
				||(b == null || "".equals(b))
				||(c == null || "".equals(c))
				||(d == null || "".equals(d))
				||(e == null || "".equals(e))
				||(f == null || "".equals(f))
				||(g == null || "".equals(g))
				||(h == null || "".equals(h))
				||(i == null || "".equals(i))
				||(j == null || "".equals(j))
				||(k == null || "".equals(k))
				||(l == null || "".equals(l))
				||(m == null || "".equals(m))
				||(n == null || "".equals(n))
				||(o == null || "".equals(o))
				||(p == null || "".equals(p))
				||(q == null || "".equals(q))
				||(r == null || "".equals(r))
				||(s == null || "".equals(s))
				||(t == null || "".equals(t))
				||(u == null || "".equals(u))
				||(v == null || "".equals(v))
				||(w == null || "".equals(w))
				||(x == null || "".equals(x))
				||(y == null || "".equals(y))
			){
			 Map<String,Object> map = new HashMap<String, Object>();
			 map.put("code", "1");
			 map.put("message", "内容存在空值！");
			return map;
		}
		String content=a+";"+b+";"+c+";"+d+";"+e+";"+f+";"+g+";"+h+";"+i+";"+j+";"+k+";"+l+";"+m+";"+n+";"+o+";"+p+";"+q+";"+r+";"+s+";"+t+";"+u+";"+v+";"+w+";"+x+";"+y;
		content = URLDecoder.decode(content);
		System.out.println(content);
		String  type = request.getParameter("type");//类型
		String  exerciseId = request.getParameter("exerciseId");//所属类别
		String  whichDay = request.getParameter("whichDay");//第几天
		String  score = request.getParameter("score");//分数
		try {
			type = new String(type.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		String errorNumber=request.getParameter("errorNumber");//错误次数
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		if(content == null || "".equals(content)){
			resMap.put("code", "1");
			resMap.put("message", "请填写内容!");
			return resMap;
		}
		if(errorNumber == null || "".equals(errorNumber)){
			resMap.put("code", "1");
			resMap.put("message", "请填写错误次数");
			return resMap;
		}
		if(id==null || "".equals(id)){
			Five five = new Five();
			five.setFiveContent(content);
		    five.setFiveType(type);//类型
		    five.setExerciseId(Long.parseLong(exerciseId));//所属类别
		    five.setFiveWhichDay(whichDay);//第几天
		    five.setErrorNumber(errorNumber);//错误次数
		    five.setFiveScore(score);//分数
		    Five five_find = fiveService.findFiveByDayAndTypeAndExerciseId(five);
		    if(five_find != null){
		    	resMap.put("code",1);
		    	resMap.put("message", "已存在该记录");
		    	return resMap;
		    }else{
		    	int count = fiveService.insertIntoFive(five);//保存数据	
		    	if(count>0){
					resMap.put("code", "0");
					resMap.put("message", "增加成功");
					return resMap;
				}else{
					resMap.put("code", "1");
					resMap.put("message", "操作失败");
					return resMap;
				}
		    }
		}else{
			Five five = new Five();
			five.setFiveContent(content);
		    five.setFiveType(type);//类型
		    five.setExerciseId(Long.parseLong(exerciseId));//所属类别
		    five.setFiveWhichDay(whichDay);//第几天
		    five.setErrorNumber(errorNumber);//错误次数
		    five.setFiveScore(score);//分数
			five.setFiveId(Long.parseLong(id));
//		    Five five_find = fiveService.findFiveByDayAndTypeAndExerciseId(five);
//		    if(five_find != null){
//		    	resMap.put("code",1);
//		    	resMap.put("message", "已存在该记录");
//		    	return resMap;
//		    }else{
			int count = fiveService.updateFive(five);
			if(count>0){
				resMap.put("code", "0");
				resMap.put("message", "修改成功");
				return resMap;
			}else{
				resMap.put("code", "1");
				resMap.put("message", "操作失败");
				return resMap;
			}
		}
//	 }
	}
	@RequestMapping(value = "/findFiveByExerciseAndWhichDayAndType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findFiveByExerciseAndWhichDayAndType(HttpServletRequest request,HttpServletResponse response){
		 Map<String,Object>  map = new HashMap<String, Object>();
		 String exerciseId = request.getParameter("exerciseId");
		 String type = request.getParameter("Type");
		 try {
				type = new String(type.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e2) {
				e2.printStackTrace();
			}
		 String whichDay = request.getParameter("whichDay");
		 Five five = new Five();
		    five.setFiveType(type);//类型
		    five.setExerciseId(Long.parseLong(exerciseId));//所属类别
		    five.setFiveWhichDay(whichDay);//第几天
		Five five_find = fiveService.findFiveByDayAndTypeAndExerciseId(five);
		if(five_find == null ||"".equals(five_find)){
			map.put("code", "0");
			map.put("message", "该天没有数据");
			return map;
		}
		List<FiveContentView> listContentView = new ArrayList<FiveContentView>();
		
		String fiveContent = five_find.getFiveContent();
		String[] rightContent = fiveContent.split(";");
		for(int i = 0; i < rightContent.length; i++){
			FiveContentView fcv = new FiveContentView();
			fcv.key = (i+1)+"";
			fcv.value = rightContent[i];
			listContentView.add(fcv);
		}
		FiveView fv = new FiveView();
		fv.five = five_find;
		fv.fiveContentView = listContentView;
		map.put("code", "0");
		map.put("message", "查询成功");
		map.put("data", fv);
		 return map;
	}
	
	@RequestMapping(value = "/deleteFive", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteFive(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		Five five = fiveService.findFiveById(Long.parseLong(id));
			if(five == null){
				resMap.put("code","1");
				resMap.put("message", "没有id="+id+"的数据");
			}
			int count = fiveService.deleteFiveById(Long.parseLong(id));
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
	
	@RequestMapping(value = "/findFiveById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findFiveById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		Five five = fiveService.findFiveById(Long.parseLong(id));
		if(five == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", five);
		}
		return resMap;
	
	}
}
