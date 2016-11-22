package com.kuji.service.fiveServiceImpl;

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
		// TODO Auto-generated method stub
		return fiveDao.findFiveByDayAndTypeAndExerciseId(five);
	}

}
