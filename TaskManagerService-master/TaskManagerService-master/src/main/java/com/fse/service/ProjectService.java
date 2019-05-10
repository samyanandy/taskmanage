package com.fse.service;

import java.util.List;

import com.fse.model.Project;

public interface ProjectService {

	public List<Project> getAllProject();
	
	public boolean addProject(Project project);
	
	public boolean deleteProject(Project project);
	
	public List<Project> getAllProjectOrderByPriority();
	
public List<Project> getAllProjectOrderByStartDate();
	
	public List<Project> getAllProjectOrderByEndDate();
}