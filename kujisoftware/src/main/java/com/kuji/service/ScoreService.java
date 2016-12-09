package com.kuji.service;

import java.util.List;

import com.kuji.entity.Score;

public interface ScoreService {
	int insertIntoScore(Score score);
	List<Score> findScoreById(String device);
	Score findScoreByWhichDayAndTypeAndExerciseIdAndDevice(Score score);
}
