package com.fse.service;

import java.util.List;
import java.util.Optional;

import com.fse.model.User;

public interface UserService {

	public List<User> getAllUser();
	
	public boolean addUser(User user);
	
	public boolean deleteUser(User user);
	
	public Optional<User>  findById(int id);
	
	public List<User> getAllUserOrderByFnameAsc();
	
	public List<User> getAllUserOrderByLnameAsc();
	
	public List<User> getAllUserOrderByEmployeeIdAsc();
}
