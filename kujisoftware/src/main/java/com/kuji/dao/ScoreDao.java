package com.kuji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.Score;

public interface ScoreDao {
	 int insertIntoScore(Score score);
	 List<Score> findScoreById(@Param("device") String device);
	 Score findScoreByWhichDayAndTypeAndExerciseIdAndDevice(Score score);
}
