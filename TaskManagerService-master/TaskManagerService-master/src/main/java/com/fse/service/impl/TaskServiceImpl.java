package com.fse.service.impl;

import java.util.ArrayList;
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
	
	public ParentTaskDao getParentTaskDao() {
		return parentTaskDao;
	}

	public void setParentTaskDao(ParentTaskDao parentTaskDao) {
		this.parentTaskDao = parentTaskDao;
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		
		return taskDao.findAll();
	}

	@Override
	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		
	
//		List<ParentTask> ptList = new ArrayList();
//		ptList = getAllParentTask();
//		if(!ptList.isEmpty()) {
//			 for (ParentTask pt : ptList) 
//		            if(task.getParent().getParentTask().toLowerCase().equals(pt.getParentTask().toLowerCase())) {
//		            	task.setParent(parentTaskDao.findByParentTask(task.getParent().getParentTask()));
//		            }
//			
//		}
		
		
		return taskDao.save(task);
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

	
	
	public TaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public ParentTask addParentTask(ParentTask pt) {
		// TODO Auto-generated method stub
		return parentTaskDao.save(pt);
	}

	@Override
	public List<Task> getAllTaskOrderByPriority() {
		// TODO Auto-generated method stub
		return taskDao.findAllByOrderByPriorityAsc();
	}

	@Override
	public List<Task> getAllTaskOrderByStartDate() {
		// TODO Auto-generated method stub
		return taskDao.findAllByOrderByStartDateAsc();
	}

	@Override
	public List<Task> getAllTaskOrderByEndDate() {
		// TODO Auto-generated method stub
		return taskDao.findAllByOrderByEndDateAsc();
	}

	@Override
	public List<Task> getAllTaskOrderByStatus() {
		// TODO Auto-generated method stub
		return taskDao.findAllByOrderByStatusAsc();
	}

	@Override
	public List<Task> findByProjectid(int projectId) {
		// TODO Auto-generated method stub
		return taskDao.findByProject_ProjectId(projectId);
	}

	@Override
	public int countByCompleted(int projectId) {
		// TODO Auto-generated method stub
		return taskDao.countByCompleted(projectId);
	}

}
