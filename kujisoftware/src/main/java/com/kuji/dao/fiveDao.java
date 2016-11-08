package com.kuji.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface fiveDao {
	int insertIntoFive(@Param("fiveContent")String fiveContent,@Param("createTime")Date createTime,@Param("answerTime")Date answerTime);
}
