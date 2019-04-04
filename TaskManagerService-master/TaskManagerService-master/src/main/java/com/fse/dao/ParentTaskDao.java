package com.fse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fse.model.ParentTask;

@Repository
public interface ParentTaskDao extends JpaRepository<ParentTask, Integer>{
	
	
	ParentTask findByParentTask(String parent_task);
}