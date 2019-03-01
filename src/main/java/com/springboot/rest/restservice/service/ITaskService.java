package com.springboot.rest.restservice.service;

import java.util.List;

import com.springboot.rest.restservice.entity.CommonTask;

public interface ITaskService {
	List<CommonTask> retrieveAllTasks();

	CommonTask retrieveTaskById(int id);

	CommonTask createTask(CommonTask task);

	CommonTask editTask(CommonTask task);

	void deleteTask(int id);
}
