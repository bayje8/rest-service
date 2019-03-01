package com.springboot.rest.restservice.service;

import java.util.Optional;

import com.springboot.rest.restservice.entity.ParentTask;

public interface IParentTaskService {
	ParentTask createParentTask(ParentTask parentTask);

	Optional<ParentTask> retrieveParentTaskById(int id);
	
	ParentTask updateParentTask(ParentTask parentTask);
}
