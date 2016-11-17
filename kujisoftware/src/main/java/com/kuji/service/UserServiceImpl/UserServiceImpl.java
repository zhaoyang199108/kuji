package com.kuji.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.UserDao;
import com.kuji.entity.User;
import com.kuji.service.UserService;
import com.kuji.until.MD5Util;
@Service
public class UserServiceImpl implements UserService{

	private @Autowired UserDao userDao;
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	
	public int updatePwd(User userSession, String oldPwd, String newPwd) {
		String oldPwdMd5 = MD5Util.getStringMD5(oldPwd);
//		if(!(oldPwdMd5.equals(userSession.getUpwd()) )){
//			return "旧密码输入错误！";
//		}
		String newPwdMd5 = MD5Util.getStringMD5(newPwd);
		User model = new User();
//		model.setUpwd(newPwdMd5);
		model.setId(userSession.getId());
		model.setPassword(newPwd);
		int count = userDao.updatePwd(model);
//		System.out.println(count);
		return count;
	}
	
}
