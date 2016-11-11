package com.kuji.service.MemoryTrainImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.MemoryTrainDao;
import com.kuji.entity.MemoryTrain;
import com.kuji.service.MemoryTrainService;

@Service
public class MemoryTrainImpl  implements MemoryTrainService{
	@Autowired 
	private MemoryTrainDao memoryTrainDao;
	
	public int insertIntoMemoryTrain(MemoryTrain memoryTrain) {
		int count = memoryTrainDao.insertIntoMemoryTrain(memoryTrain);
		if(count>0){
			return 0;
		}else{
			return 1;
		}
	}

}
