package com.fse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.model.ParentTask;
import com.fse.model.Task;
import com.fse.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@RequestMapping(value="getAllTask")
	public List<Task> getAllTask(){
		
		return taskService.getAllTask();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="addTask",method=RequestMethod.POST,consumes="application/json")
	public boolean addTask(@RequestBody Task task) {
		
			
		return taskService.addTask(task);
	}
	
	@RequestMapping(value="deleteTask/{id}")
	public Optional<Task> deleteTask(@PathVariable int id) {
		return taskService.deleteTask(id);
	}
	
	@RequestMapping(value="getAllParentTask")
	public List<ParentTask> getAllParentTask(){
		
		return taskService.getAllParentTask();
	}
}
