package com.springboot.rest.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parenttask")
public class ParentTask {
	@Id
	@GeneratedValue
	private int parent_id;
	private String parent_task;
	
	
	
	public ParentTask() {
	}

	public ParentTask(int parent_id, String parent_task) {
		super();
		this.parent_id = parent_id;
		this.parent_task = parent_task;
	}
	
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_task() {
		return parent_task;
	}
	public void setParent_task(String parent_task) {
		this.parent_task = parent_task;
	}
	
	
}
