package com.fse.junitTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fse.TaskManagerApplication;
import com.fse.dao.ParentTaskDao;
import com.fse.dao.TaskDao;
import com.fse.model.ParentTask;
import com.fse.model.Task;
import com.fse.model.User;
import com.fse.service.impl.TaskServiceImpl;


import junit.framework.Assert;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TaskServiceImplTest {
	@Autowired
	TaskDao taskDao;
	@Autowired
	ParentTaskDao parentTaskDao;
	TaskServiceImpl taskServiceImpl;
	
	@org.junit.Before
	public void init() {
		taskServiceImpl =new TaskServiceImpl();
		taskServiceImpl.setTaskDao(taskDao);	
		taskServiceImpl.setParentTaskDao(parentTaskDao);
	}
		
	@Test
	public  void testGetAllTask() {
		
		
		//getAllTask
		 List<Task>output =taskServiceImpl.getAllTask();
		Assert.assertNotNull(output);
		
		
		
		
	}
	
	@Test 
	public void testDeleteTask() {
		int input=5;
		int taskCount=taskDao.countExistingTask(input);
		if (taskCount!=0) {
			taskServiceImpl.deleteTask(input);
			Assert.assertEquals(0,taskDao.countExistingTask(input));
		}
	}
	
	@Test
	public void testGetAllParentTask() {
		List<ParentTask> output=	parentTaskDao.findAll();
		Assert.assertNotNull(output);
	}
	
	@Test
	 public void testgetAllTaskOrderByPriority() {
		 List<Task> output =taskServiceImpl.getAllTaskOrderByPriority();
		 Assert.assertNotNull(output);
	 }
	
	@Test
	 public void testgetAllTaskOrderByStartDate() {
		 List<Task> output =taskServiceImpl.getAllTaskOrderByStartDate();
		 Assert.assertNotNull(output);
	 }
	
	@Test
	 public void testgetAllTaskOrderByEndDate() {
		 List<Task> output =taskServiceImpl.getAllTaskOrderByEndDate();
		 Assert.assertNotNull(output);
	 }
	
	@Test
	 public void testgetAllTaskOrderByStatus() {
		 List<Task> output =taskServiceImpl.getAllTaskOrderByStatus();
		 Assert.assertNotNull(output);
	 }
	
}


