package com.kuji.service;

import com.kuji.entity.User;

public interface UserService {
	User findUserByUserName(String userName);
	
	//密码更新
	int updatePwd(User userSession, String oldPwd, String newPwd);
}
