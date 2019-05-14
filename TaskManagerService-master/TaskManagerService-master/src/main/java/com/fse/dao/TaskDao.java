package com.fse.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fse.model.ParentTask;
import com.fse.model.Project;
import com.fse.model.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Task t set t.status =1 WHERE t.id = ?1")
	void updateDeleteFlag(int id);
	
	
	public List<Task> findAllByOrderByPriorityAsc();
	
	public List<Task> findAllByOrderByStartDateAsc();
	
	public List<Task> findAllByOrderByEndDateAsc();
	
	
	public List<Task> findAllByOrderByStatusAsc();
	
	public List<Task> findByProject_ProjectId(int projectId);
	
	@Transactional
	@Query("SELECT Count(*) from Task t where t.project.projectId  =?1 and t.status=1")
	public int countByCompleted(int projectId);
	
	@Transactional
	@Query("SELECT Count(*) from Task t where t.status =0 and  t.id = ?1")
	int countExistingTask(int id);
}
