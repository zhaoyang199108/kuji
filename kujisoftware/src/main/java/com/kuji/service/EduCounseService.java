package com.kuji.service;

import java.util.List;

import com.kuji.entity.EduCounse;
import com.kuji.entity.TypeRules;

public interface EduCounseService {

	int query(String eduCounseTitle);//校验有无重复

	int insertIntoEduCounse(EduCounse  eduCounse);//添加

	List<EduCounse> findAll();

	TypeRules findEduCounseById(long id);
}
