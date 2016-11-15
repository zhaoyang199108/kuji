package com.kuji.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.kuji.entity.User;

public interface UserDao {
	User findUserByUserName(@Param("userName")String userName);
	
	/**
	 * 更新 账号  密码
	 * @param model
	 */
	@Update("update user set upwd=#{mdl.upwd}, password=#{mdl.password}  "
			+ "WHERE ID=#{mdl.id}")
	public int updatePwd(@Param("mdl")User model);
	
}
