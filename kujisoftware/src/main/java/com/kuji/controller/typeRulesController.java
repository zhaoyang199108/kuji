package com.kuji.controller;

import java.io.UnsupportedEncodingException;
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

import com.kuji.entity.TypeRules;
import com.kuji.service.TypeRulesService;

/**
 * 题型规则
 * @author wudi
 *
 */
@Controller
@RequestMapping("/typeRules")
public class typeRulesController {
	
	@Autowired
	private TypeRulesService typeRulesService;
	
	@RequestMapping(value = "/typeRules", method = RequestMethod.GET)
	public String typeRules(Model model){
		List<TypeRules> list_typeRules = typeRulesService.findAll();
		model.addAttribute("typeRules", list_typeRules);
		return "typeRules";
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> typeRules(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		String  typeRulesName = request.getParameter("typeRulesName");//规则名称
		String  typeRulesContent = request.getParameter("typeRulesContent");//规则内容
		String typeRulesId = request.getParameter("id");
//		try {
//			typeRulesContent = new String(typeRulesContent.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		if(typeRulesContent==null || "".equals(typeRulesContent)){
			resMap.put("code", "1");
			resMap.put("message", "请填写规则说明!");
			return resMap;
		}
      if(typeRulesId==null || "".equals(typeRulesId)){
				TypeRules typeRules = new TypeRules();
				typeRules.setTypeRulesName(typeRulesName);
				typeRules.setTypeRulesContent(typeRulesContent);
				TypeRules typeRul = typeRulesService.query(typeRulesName);
				if(typeRul==null){
						int count = typeRulesService.insertIntoTypeRules(typeRules);//添加
						if(count>0){
							resMap.put("typeRules", typeRules);
							resMap.put("code", 0);
							resMap.put("message", "操作成功!");
						}else{
							resMap.put("typeRules", typeRules);
							resMap.put("code", 1);
							resMap.put("message", "操作失败!");
						}
				}else{
					resMap.put("code", "1");
					resMap.put("message", "此规则说明已存在");
					return resMap;
				}
	}else{
			TypeRules typeRules = new TypeRules();
			typeRules.setTypeRulesName(typeRulesName);
			typeRules.setTypeRulesContent(typeRulesContent);
			typeRules.setTypeRulesId(Long.parseLong(typeRulesId));
			int count = typeRulesService.updateTypeRules(typeRules);//添加
			if(count>0){
				resMap.put("typeRules", typeRules);
				resMap.put("code", 0);
				resMap.put("message", "修改成功!");
			}else{
				resMap.put("typeRules", typeRules);
				resMap.put("code", 1);
				resMap.put("message", "操作失败!");
			}
		}
	    return resMap;  
 	  }
	
	@RequestMapping(value = "/findTypeRulesByTypeRulesName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findTypeRulesByTypeRulesName(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		String  typeRulesName = request.getParameter("typeRulesName");//规则名称
		if(typeRulesName == null || "".equals(typeRulesName)){
			resMap.put("code", "1");
			resMap.put("message", "参数不能为空");
			return resMap;
		}
		TypeRules typeRul = typeRulesService.query(typeRulesName);
		if(typeRul == null){
			resMap.put("code", "0");
			resMap.put("message", "没有此类型的数据");
			return resMap;
		}
		resMap.put("code", "0");
		resMap.put("message", "查询成功");
		resMap.put("data", typeRul);
		return resMap;
	}
	
	@RequestMapping(value = "/deleteTypeRules", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteTypeRules(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		TypeRules typeRules = typeRulesService.findTypeRulesById(Long.parseLong(id));
		if(typeRules == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}
		int count = typeRulesService.deleteTypeRulesById(Long.parseLong(id));
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
	
	@RequestMapping(value = "/findTypeRulesById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findTypeRulesById(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入参数不正确");
			return resMap;
		}
		TypeRules typeRules = typeRulesService.findTypeRulesById(Long.parseLong(id));
		if(typeRules == null){
			resMap.put("code","1");
			resMap.put("message", "没有id="+id+"的数据");
		}else{
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", typeRules);
		}
		return resMap;
	
	}
	
	@RequestMapping(value = "/findTypeRulesAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findTypeRulesAll(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap =new HashMap<String, Object>();
		List<TypeRules> list_typeRules = typeRulesService.findAll();
//		if(list_typeRules==null){
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", list_typeRules);
//		}
//		resMap.put("list", typeRulesService.findAll());
		return resMap;
	}
	
	
	}
	
	
