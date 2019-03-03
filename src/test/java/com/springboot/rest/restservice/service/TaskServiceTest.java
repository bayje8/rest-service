package com.springboot.rest.restservice.service;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.entity.CommonTask;
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class TaskServiceTest {

	@MockBean
	TaskRepository repository;
	
	@MockBean
	IParentTaskService parentTaskService;
	
	@Autowired
	ITaskService taskService;
	
	Task task;
	ParentTask parentTask;
	CommonTask cTask;
	Optional<Task> optTask;
	Optional<ParentTask> optParentTask;

	@Before
	public void setUp() throws Exception {
		task = new Task(16, 15, "Task 1", "2019-01-01", "2019-03-01", 10);
		parentTask = new ParentTask(15, "P Task 1");
		cTask = new CommonTask(16, 15, "Task 1", "2019-01-01", "2019-03-01", 10, "P Task 1");
		optTask = Optional.of(task);
		optParentTask = Optional.of(parentTask);
	}

	@Test
	public void testRetrieveTaskById() {
		Mockito.when(repository.findById(16)).thenReturn(optTask);
		Mockito.when(parentTaskService.retrieveParentTaskById(15)).thenReturn(optParentTask);
		CommonTask actual = taskService.retrieveTaskById(16);
		assertEquals(cTask.getParentTask(),actual.getParentTask());
		assertEquals(cTask.getTask(), actual.getTask());

	}

}
