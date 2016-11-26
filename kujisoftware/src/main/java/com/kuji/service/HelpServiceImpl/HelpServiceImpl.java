package com.kuji.service.HelpServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.HelpDao;
import com.kuji.entity.Help;
import com.kuji.service.HelpService;
@Service
public class HelpServiceImpl implements HelpService {
	private @Autowired HelpDao helpDao;
	public Help findHelpByExerciseId(Long exerciseId) {
		return helpDao.findHelpByExerciseId(exerciseId);
	}
	public int insertIntoHelp(Help help) {
		int count = helpDao.insertIntoHelp(help);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}
	public List<Help> findAll() {
		// TODO Auto-generated method stub
		return helpDao.findAll();
	}
	public Help findHelpById(Long id) {
		// TODO Auto-generated method stub
		return helpDao.findHelpById(id);
	}
	public int deleteHelpById(Long id) {
		// TODO Auto-generated method stub
		int count = helpDao.deleteHelpById(id);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}
	public int updateHelp(Help help) {
		// TODO Auto-generated method stub
		int count = helpDao.updateHelp(help);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

}
