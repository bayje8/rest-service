package com.springboot.rest.restservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.repository.ParentTaskRepository;

@Service
public class ParentTaskService implements IParentTaskService{
	
	@Autowired
	ParentTaskRepository parentTaskRepository;
	
	public ParentTask createParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}
	
	public Optional<ParentTask> retrieveParentTaskById(int id) {
		return parentTaskRepository.findById(id);
	}
	
	public ParentTask updateParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}

}
