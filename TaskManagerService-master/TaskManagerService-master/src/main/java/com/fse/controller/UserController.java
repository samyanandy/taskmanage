package com.fse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.model.Project;
import com.fse.model.User;
import com.fse.service.ProjectService;
import com.fse.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="getAllUser")
	public List<User> getAllUser(){
		
		return userService.getAllUser();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="addUser",method=RequestMethod.POST,consumes="application/json")
	public boolean adduser(@RequestBody User user) {
					
		return userService.addUser(user);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="deleteUser",method=RequestMethod.POST,consumes="application/json")
	public boolean deleteUser(@RequestBody User user) {
					
		return userService.deleteUser(user);
	}
	@RequestMapping(value="findUser/{id}")
	public Optional<User> findUserById(@PathVariable int id){
		
		return userService.findById(id);
	}
	
	@RequestMapping(value="getAllUserOrderByFname")
	public List<User> getAllUserOrderByFname(){
		
		return userService.getAllUserOrderByFnameAsc();
	}
	
	@RequestMapping(value="getAllUserOrderByLname")
	public List<User> getAllUserOrderByLname(){
		
		return userService.getAllUserOrderByLnameAsc();
	}
	
	@RequestMapping(value="getAllUserOrderByEmployeeId")
	public List<User> getAllUserOrderByEmployeeId(){
		
		return userService.getAllUserOrderByEmployeeIdAsc();
	}
	
	
	@RequestMapping(value="getAllProject")
	public List<Project> getAllProject(){
		
		return projectService.getAllProject();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="addProject",method=RequestMethod.POST,consumes="application/json")
	public boolean addProject(@RequestBody Project project) {
					
		return projectService.addProject(project);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="deleteProject",method=RequestMethod.POST,consumes="application/json")
	public boolean deleteProject(@RequestBody Project project) {
					
		return projectService.deleteProject(project);
	}
	@RequestMapping(value="getAllProjectOrderByPriority")
	public List<Project> getAllProjectOrderByPriority(){
		
		return projectService.getAllProjectOrderByPriority();
	}
	@RequestMapping(value="getAllProjectOrderByStartDate")
	public List<Project> getAllProjectOrderByStartDate(){
		
		return projectService.getAllProjectOrderByStartDate();
	}
	@RequestMapping(value="getAllProjectOrderByEndDate")
	public List<Project> getAllProjectOrderByEndDate(){
		
		return projectService.getAllProjectOrderByEndDate();
	}
}
