package com.kuji.dao;

import java.util.List;

import com.kuji.entity.Five;

public interface FiveDao {
	int insertIntoFive(Five five);
	
	Five findFiveByDayAndTypeAndExerciseId(Five five);

	List<Five> findAll();

	int deleteFiveById(long id);

	Five findFiveById(long id);

	int updateFive(Five five);
}
