package com.fse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fse.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	
	public List<User> findAllByOrderByFnameAsc();
	public List<User> findAllByOrderByLnameAsc();
	public List<User> findAllByOrderByEmployeeIdAsc();
	
	@Query("SELECT DISTINCT u.fname , u.lname, u.employeeId FROM User u")
	public ArrayList findDistinctUser();
}
