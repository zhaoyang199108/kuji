package com.kuji.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuji.service.ExerciseService;

@Controller
@RequestMapping("/exercise")
public class exerciseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private @Autowired ExerciseService exerciseService;
	@RequestMapping(value = "/findAllExercise", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findAllExercise(HttpServletRequest request,HttpServletResponse response) {
		// 获取列表页
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", exerciseService.findAllExercise());
		return map;
	}
}
