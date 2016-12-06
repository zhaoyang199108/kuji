package com.kuji.service.fiveServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.FiveDao;
import com.kuji.entity.Five;
import com.kuji.service.FiveService;
@Service
public class fiveServiceImpl implements FiveService {
	private @Autowired FiveDao fiveDao;
	public int insertIntoFive(Five five) {
		int count = fiveDao.insertIntoFive(five);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}
	public Five findFiveByDayAndTypeAndExerciseId(Five five) {
		return fiveDao.findFiveByDayAndTypeAndExerciseId(five);
	}
	
	public List<Five> findAll() {
		return fiveDao.findAll();
	}
	
	
	public int deleteFiveById(long id) {
			int count = fiveDao.deleteFiveById(id);
			if(count>0){
				return 1;
			}else{
				return 0;
			}
	}
	
	public Five findFiveById(long id) {
		return fiveDao.findFiveById(id);
	}
	public int updateFive(Five five) {
		int count = fiveDao.updateFive(five);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

}
