package com.kuji.dao;

import com.kuji.entity.Five;

public interface FiveDao {
	int insertIntoFive(Five five);
	
	Five findFiveByDayAndTypeAndExerciseId(Five five);
}
