package com.springboot.rest.restservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.restservice.entity.CommonTask;
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private IParentTaskService parentTaskService;

	public List<CommonTask> retrieveAllTasks() {
		List<CommonTask> list = new ArrayList<CommonTask>();
		Iterable<Task> iterable = taskRepository.findAll();
		for (Task task : iterable) {
			list.add(new CommonTask(task.getTask_id(), task.getParent_id(), task.getTask(), task.getStart_date(),
					task.getEnd_date(), task.getPriority(),
					parentTaskService.retrieveParentTaskById(task.getParent_id()).get().getParent_task()));
		}
		return list;
	}

	public CommonTask retrieveTaskById(int id) {
		Task task = taskRepository.findById(id).get();
		return new CommonTask(task.getTask_id(), task.getParent_id(), task.getTask(), task.getStart_date(),
				task.getEnd_date(), task.getPriority(),
				parentTaskService.retrieveParentTaskById(task.getParent_id()).get().getParent_task());

	}

	public CommonTask createTask(CommonTask task) {
		ParentTask parentTask = new ParentTask(task.getParent_id(), task.getParentTask());
		ParentTask savedPTask = parentTaskService.createParentTask(parentTask);

		taskRepository.save(new Task(task.getTask_id(), savedPTask.getParent_id(), task.getTask(), task.getStartDate(),
				task.getEndDate(), task.getPriority()));

		return task;
	}

	public CommonTask editTask(CommonTask task) {
		Optional<ParentTask> parentTaskOptional = parentTaskService.retrieveParentTaskById(task.getParent_id());
		ParentTask savedPTask;
		if (!parentTaskOptional.isPresent()) {
			ParentTask parentTask = new ParentTask(task.getParent_id(), task.getParentTask());
			savedPTask = parentTaskService.createParentTask(parentTask);
		} else {
			ParentTask parentTask = new ParentTask(task.getParent_id(), task.getParentTask());
			savedPTask = parentTaskService.updateParentTask(parentTask);
		}

		Optional<Task> taskOptional = taskRepository.findById(task.getTask_id());
		if (taskOptional.isPresent()) {
			taskRepository.save(new Task(task.getTask_id(), savedPTask.getParent_id(), task.getTask(),
					task.getStartDate(), task.getEndDate(), task.getPriority()));
		}
		return task;
	}

	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}

}
