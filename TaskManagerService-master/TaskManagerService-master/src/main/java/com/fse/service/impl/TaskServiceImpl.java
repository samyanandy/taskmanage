package com.fse.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.ParentTaskDao;
import com.fse.dao.TaskDao;
import com.fse.model.ParentTask;
import com.fse.model.Task;
import com.fse.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskDao;
	
	@Autowired
	ParentTaskDao parentTaskDao;
	
	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		
		return taskDao.findAll();
	}

	@Override
	public boolean addTask(Task task) {
		// TODO Auto-generated method stub
		
	
		List<ParentTask> ptList = new ArrayList();
		ptList = getAllParentTask();
		if(!ptList.isEmpty()) {
			 for (ParentTask pt : ptList) 
		            if(task.getParent().getParentTask().toLowerCase().equals(pt.getParentTask().toLowerCase())) {
		            	task.setParent(parentTaskDao.findByParentTask(task.getParent().getParentTask()));
		            }
			
		}
		
		taskDao.save(task);
		return true;
	}

	@Override
	public Optional<Task> deleteTask(int id) {
		// TODO Auto-generated method stub
		taskDao.updateDeleteFlag(id);
		return taskDao.findById(id);
	}

	@Override
	public List<ParentTask> getAllParentTask() {
		// TODO Auto-generated method stub
		return  parentTaskDao.findAll();
	}

}
