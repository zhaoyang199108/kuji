package com.kuji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.LearnExplain;

public interface LearnExplainDao {

	int insertIntoLearnExplain(LearnExplain learnExplain);

	int query(@Param("learnExplainType") String learnExplainType, @Param("exerciseId") String exerciseId,@Param("learnExplainWhichDay") String learnExplainWhichDay);

	List<LearnExplain> findAll();
	
	LearnExplain findLearnExplainById(@Param("id") long id);
	int deleteLearnExplainById(@Param("id") long id);

	int updateLearnExplain(LearnExplain learnExplain);
}
