package com.kuji.service;

import com.kuji.entity.Five;


public interface FiveService {

	int   insertIntoFive(Five five);
	Five findFiveByDayAndTypeAndExerciseId(Five five);
}
