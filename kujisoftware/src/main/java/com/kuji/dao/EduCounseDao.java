package com.kuji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.EduCounse;
import com.kuji.entity.TypeRules;

public interface EduCounseDao {

	
	int query(@Param("eduCounseTitle")  String eduCounseTitle);

	int insertIntoEduCounse(EduCounse  eduCounse);

	List<EduCounse> findAll();

	TypeRules findEduCounseById(long id);
	
}
