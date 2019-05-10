package com.fse.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = 8907785850151451137L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	Integer userId;
	
	@Column(name="fname")
	String fname;
	
	@Column(name="lname")
	String lname;
		
	@Column(name="employee_id")
	int employeeId;
	
	@Column(name="project_id")
	int projectId;
	
	@Column(name="task_id")
	int taskId;
	
	
//	@JoinColumn(name="projectId", referencedColumnName="project_id")
//	@ManyToOne(cascade=CascadeType.ALL)
//	Project project;
//	
//	@JoinColumn(name="taskId", referencedColumnName="task_id")
//	@ManyToOne(cascade=CascadeType.ALL)
//	Task task;


	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}
//
//	public Task getTask() {
//		return task;
//	}
//
//	public void setTask(Task task) {
//		this.task = task;
//	}
}
