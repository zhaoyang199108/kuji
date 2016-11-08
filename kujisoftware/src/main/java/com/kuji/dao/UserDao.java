package com.kuji.dao;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.User;

public interface UserDao {
	User findUserByUserName(@Param("userName")String userName);
}
