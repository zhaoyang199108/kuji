package com.kuji.service;

import com.kuji.entity.User;

public interface UserService {
	User findUserByUserName(String userName);
}
