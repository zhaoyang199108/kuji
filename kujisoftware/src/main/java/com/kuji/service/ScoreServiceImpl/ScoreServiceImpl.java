package com.kuji.service.ScoreServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.ScoreDao;
import com.kuji.entity.Score;
import com.kuji.service.ScoreService;
@Service
public class ScoreServiceImpl implements ScoreService {
	private @Autowired ScoreDao scoreDao;
	public int insertIntoScore(Score score) {
		// TODO Auto-generated method stub
		return scoreDao.insertIntoScore(score);
	}
	public List<Score> findScoreById(String device) {
		// TODO Auto-generated method stub
		return scoreDao.findScoreById(device);
	}
	public Score findScoreByWhichDayAndTypeAndExerciseIdAndDevice(Score score) {
		// TODO Auto-generated method stub
		return scoreDao.findScoreByWhichDayAndTypeAndExerciseIdAndDevice(score);
	}

}
