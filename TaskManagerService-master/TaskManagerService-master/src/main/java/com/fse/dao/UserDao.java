package com.fse.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.model.Project;
import com.fse.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	
	public List<User> findAllByOrderByFnameAsc();
	public List<User> findAllByOrderByLnameAsc();
	public List<User> findAllByOrderByEmployeeIdAsc();
}
