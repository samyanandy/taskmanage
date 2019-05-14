package com.fse.service;

import java.util.List;
import java.util.Optional;

import com.fse.model.ParentTask;
import com.fse.model.Task;
import com.fse.model.Task;

public interface TaskService {
	
	public List<Task> getAllTask();
	
	public Task addTask(Task task);
	
	public Optional<Task> deleteTask(int id );
	
	public List<ParentTask> getAllParentTask();

	public ParentTask addParentTask(ParentTask pt);
	
	public List<Task> getAllTaskOrderByPriority();
	
	public List<Task> getAllTaskOrderByStartDate();
		
		public List<Task> getAllTaskOrderByEndDate();
		
		public List<Task> getAllTaskOrderByStatus();
		
		public List<Task> findByProjectid(int projectId);
		
		public int countByCompleted(int projectId);
}
