package com.kuji.service;

import java.util.List;

import com.kuji.entity.MemoryTrain;

public interface MemoryTrainService {

	int   insertIntoMemoryTrain(MemoryTrain memoryTrain);//添加

	MemoryTrain findMemoryTrainByExerciseAndWhichDayAndType(MemoryTrain memoryTrain);

	List<MemoryTrain> findAll();

	MemoryTrain findMemoryTrainById(long id);

	int deleteMemoryTrainById(long id);

	int query(String memoryTrainType, String memoryTrainWhichDay,String exerciseId);

	int updateMemoryTrain(MemoryTrain memoryTrain);
	
}
