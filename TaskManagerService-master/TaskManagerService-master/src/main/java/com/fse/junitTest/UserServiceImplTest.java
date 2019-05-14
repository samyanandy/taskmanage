	package com.fse.junitTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.dao.UserDao;
import com.fse.model.User;
import com.fse.service.impl.UserServiceImpl;

import junit.framework.Assert;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	@Autowired
	UserDao userDao;
	UserServiceImpl userServiceImpl;
	@org.junit.Before
	public void init() {
		userServiceImpl =new UserServiceImpl();
		userServiceImpl.setUserDao(userDao);
	}
 @Test
 public void testGetAllUser(){
	 List<User> output = userServiceImpl.getAllUser();
	 Assert.assertNotNull(output);
 }
 
 @Test
 public void testGetAllUserOrderByEmployeeIdAsc() {
	 List<User> output =userServiceImpl.getAllUserOrderByEmployeeIdAsc();
	 Assert.assertNotNull(output);
 }
 @Test
 public void testGetAllUserOrderByLnameAsc() {
	 List<User> output =userServiceImpl.getAllUserOrderByLnameAsc();
	 Assert.assertNotNull(output);
 }
 @Test
 public void testAllUserOrderByFnameAsc() {
	 List<User> output =userServiceImpl.getAllUserOrderByFnameAsc();
	 Assert.assertNotNull(output);
 }
}
