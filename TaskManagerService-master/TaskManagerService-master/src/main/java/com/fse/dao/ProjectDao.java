package com.fse.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.model.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{
	
	
	public List<Project> findAllByOrderByPriorityAsc();
	
	public List<Project> findAllByOrderByStartDateAsc();
	
	public List<Project> findAllByOrderByEndDateAsc();
	
}