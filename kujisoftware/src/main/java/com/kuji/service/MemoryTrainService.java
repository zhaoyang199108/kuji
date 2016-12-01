package com.kuji.service;

import com.kuji.entity.MemoryTrain;

public interface MemoryTrainService {

	int   insertIntoMemoryTrain(MemoryTrain memoryTrain);//添加

	MemoryTrain findMemoryTrainByExerciseAndWhichDayAndType(MemoryTrain memoryTrain);
	
}
