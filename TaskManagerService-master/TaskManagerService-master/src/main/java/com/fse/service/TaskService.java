package com.fse.service;

import java.util.List;
import java.util.Optional;

import com.fse.model.ParentTask;
import com.fse.model.Task;

public interface TaskService {
	
	public List<Task> getAllTask();
	
	public boolean addTask(Task task);
	
	public Optional<Task> deleteTask(int id );
	
	public List<ParentTask> getAllParentTask();

	
}
