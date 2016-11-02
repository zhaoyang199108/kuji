package com.kuji.service.ExerciseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.ExerciseDao;
import com.kuji.entity.ExerciseType;
import com.kuji.service.ExerciseService;
@Service
public class ExerciseServiceImpl implements ExerciseService{

	private @Autowired ExerciseDao exerciseDao;
	public List<ExerciseType> findAllExercise() {
		// TODO Auto-generated method stub
		return 	exerciseDao.findAllExercise();
	}

}
