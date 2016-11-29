package com.kuji.service;

import java.util.List;

import com.kuji.entity.LearnExplain;

public interface LearnExplainService {

	int   insertIntoLearnExplain(LearnExplain learnExplain);//添加

	int query(String learnExplainType, String exerciseId,
			String learnExplainWhichDay);
	List<LearnExplain> findAll();
	LearnExplain findLearnExplainById(long id);
	int deleteLearnExplainById(long id);
}
