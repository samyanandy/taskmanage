package com.fse.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fse.model.ParentTask;
import com.fse.model.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Task t set t.deleteFlag =1 WHERE t.id = ?1")
	void updateDeleteFlag(int id);

	
}
