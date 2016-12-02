package com.kuji.service.MemoryTrainImpl;

import java.util.List;

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
			return 1;
		}else{
			return 0;
		}
	}

	public MemoryTrain findMemoryTrainByExerciseAndWhichDayAndType(
			MemoryTrain memoryTrain) {
		return memoryTrainDao.findMemoryTrainByExerciseAndWhichDayAndType(memoryTrain);
	}

	public List<MemoryTrain> findAll() {
		return memoryTrainDao.findAll();
	}

	public MemoryTrain findMemoryTrainById(long id) {
		return memoryTrainDao.findMemoryTrainById(id);
	}

	public int deleteMemoryTrainById(long id) {
		return memoryTrainDao.deleteMemoryTrainById(id);
	}

	public int query(String memoryTrainType,
			String memoryTrainWhichDay, String exerciseId) {
		int count = memoryTrainDao.query(memoryTrainType,memoryTrainWhichDay,exerciseId);
		if(count > 0){
            return 0;
        }else{
            return 1;
        }
	}

	public int updateMemoryTrain(MemoryTrain memoryTrain) {
		try{
			int count = memoryTrainDao.updateMemoryTrain(memoryTrain);
			if(count>0){
				return 1;
			}else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

}
