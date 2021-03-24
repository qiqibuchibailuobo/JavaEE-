package edu.hhxy.jsj.service;

import edu.hhxy.jsj.dao.UserDao;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		this.userDao.say();
		System.out.println("userService hello");
	}

}
