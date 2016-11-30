package com.kuji.service;

import java.util.List;

import com.kuji.entity.EduCounse;

public interface EduCounseService {

	EduCounse query(String eduCounseTitle);//校验有无重复

	int insertIntoEduCounse(EduCounse  eduCounse);//添加

	List<EduCounse> findAll();

	EduCounse findEduCounseById(long id);

	int updateEduCounse(EduCounse eduCounse);

	int deleteEduCounseById(long id);
}
