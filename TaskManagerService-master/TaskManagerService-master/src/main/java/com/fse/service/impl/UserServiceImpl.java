package com.fse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.UserDao;
import com.fse.model.User;
import com.fse.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
		return true;
	}

	@Override
	public Optional<User> findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<User> getAllUserOrderByFnameAsc() {
		// TODO Auto-generated method stub
		return userDao.findAllByOrderByFnameAsc();
	}

	@Override
	public List<User> getAllUserOrderByLnameAsc() {
		// TODO Auto-generated method stub
		return userDao.findAllByOrderByLnameAsc();
	}

	@Override
	public List<User> getAllUserOrderByEmployeeIdAsc() {
		// TODO Auto-generated method stub
		return userDao.findAllByOrderByEmployeeIdAsc();
	}

}
