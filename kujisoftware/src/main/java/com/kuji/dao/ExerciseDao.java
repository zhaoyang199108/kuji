package com.kuji.dao;

import java.util.List;

import com.kuji.entity.ExerciseType;

public interface ExerciseDao {

	List<ExerciseType> findAllExercise();
}
