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
	public Task addTask(@RequestBody Task task) {
		
			
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="addParentTask",method=RequestMethod.POST,consumes="application/json")
	public ParentTask addParentTask(@RequestBody ParentTask pt) {
		
			
		return taskService.addParentTask(pt);
	}
	
	@RequestMapping(value="getAllTaskOrderByPriority")
	public List<Task> getAllTaskOrderByPriority(){
		
		return taskService.getAllTaskOrderByPriority();
	}
	@RequestMapping(value="getAllTaskOrderByStartDate")
	public List<Task> getAllProjectOrderByStartDate(){
		
		return taskService.getAllTaskOrderByStartDate();
	}
	@RequestMapping(value="getAllTaskOrderByEndDate")
	public List<Task> getAllProjectOrderByEndDate(){
		
		return taskService.getAllTaskOrderByEndDate();
	}
	@RequestMapping(value="getAllTaskOrderByStatus")
	public List<Task> getAllProjectOrderByStatus(){
		
		return taskService.getAllTaskOrderByStatus();
	}
	@RequestMapping(value="findByProjectId/{projectId}")
	public List<Task> findByProjectId(@PathVariable int projectId){
		
		return taskService.findByProjectid(projectId);
	}
	
	@RequestMapping(value="countByProjectid/{projectId}")
	public int countByProjectid(@PathVariable int projectId) {
		return taskService.findByProjectid(projectId).size();
	}
	
	@RequestMapping(value="countCompleted/{projectId}")
	public int countCompleted(@PathVariable int projectId) {
		return taskService.countByCompleted(projectId);
	}
}
