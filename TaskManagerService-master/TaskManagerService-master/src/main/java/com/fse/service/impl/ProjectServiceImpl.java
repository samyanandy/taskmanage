package com.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.ProjectDao;
import com.fse.model.Project;
import com.fse.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return projectDao.findAll();
	}

	@Override
	public boolean addProject(Project project) {
		// TODO Auto-generated method stub
		projectDao.save(project);
		return true;
	}

	@Override
	public boolean deleteProject(Project project) {
		// TODO Auto-generated method stub
		projectDao.delete(project);
		return true;
	}

	@Override
	public List<Project> getAllProjectOrderByPriority() {
		// TODO Auto-generated method stub
		return projectDao.findAllByOrderByPriorityAsc();
	}

	@Override
	public List<Project> getAllProjectOrderByStartDate() {
		// TODO Auto-generated method stub
		return projectDao.findAllByOrderByStartDateAsc();
	}

	@Override
	public List<Project> getAllProjectOrderByEndDate() {
		// TODO Auto-generated method stub
		return projectDao.findAllByOrderByEndDateAsc();
	}

}
