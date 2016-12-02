package com.kuji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.MemoryTrain;

public interface MemoryTrainDao {

	int insertIntoMemoryTrain(MemoryTrain memoryTrain);

	MemoryTrain findMemoryTrainByExerciseAndWhichDayAndType(MemoryTrain memoryTrain);

	List<MemoryTrain> findAll();

	MemoryTrain findMemoryTrainById(long id);

	int deleteMemoryTrainById(long id);

	int query(@Param("memoryTrainType") String memoryTrainType, @Param("memoryTrainWhichDay") String memoryTrainWhichDay,
			@Param("exerciseId") String exerciseId);

	int updateMemoryTrain(MemoryTrain memoryTrain);
}
