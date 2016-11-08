package com.kuji.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.UserDao;
import com.kuji.entity.User;
import com.kuji.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	private @Autowired UserDao userDao;
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(userName);
	}

}
