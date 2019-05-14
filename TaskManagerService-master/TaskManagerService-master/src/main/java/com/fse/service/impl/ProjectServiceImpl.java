package com.fse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.ProjectDao;
import com.fse.dao.UserDao;
import com.fse.model.Project;
import com.fse.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return projectDao.findAll();
	}

	@Override
	public Project addProject(Project project) {
		
		// TODO Auto-generated method stub
		
		
		return projectDao.save(project);
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

	@Override
	public Optional<Project> findById(int id) {
		// TODO Auto-generated method stub
		return projectDao.findById(id);
	}

}
