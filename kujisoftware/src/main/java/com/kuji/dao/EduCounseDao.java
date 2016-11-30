package com.kuji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.EduCounse;

public interface EduCounseDao {

	
	EduCounse query( @Param("eduCounseTitle") String eduCounseTitle);

	int insertIntoEduCounse(EduCounse  eduCounse);

	List<EduCounse> findAll(@Param("currentPage") int currentPage,@Param("pageSize")int pageSize);

	EduCounse findEduCounseById(long id);

	int updateEduCounse(EduCounse eduCounse);

	int deleteEduCounseById(long id);
	
}
