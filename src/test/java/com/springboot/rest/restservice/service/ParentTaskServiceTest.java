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
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.repository.ParentTaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfiguration.class)
public class ParentTaskServiceTest {
	
	@Autowired
	IParentTaskService parentTaskService;
	
	@MockBean
	ParentTaskRepository parentTaskRepository;

	ParentTask parentTask;
	Optional<ParentTask> optParentTask;
	
	@Before
	public void setUp() throws Exception {
		parentTask = new ParentTask(15, "P Task 1");
		optParentTask = Optional.of(parentTask);
	}

	@Test
	public void testRetrieveParentTaskById() {
		Mockito.when(parentTaskRepository.findById(15)).thenReturn(optParentTask);
		ParentTask actual = parentTaskService.retrieveParentTaskById(15).get();
		assertEquals(parentTask.getParent_id(), actual.getParent_id());
		assertEquals(parentTask.getParent_task(), actual.getParent_task());
	}

}
