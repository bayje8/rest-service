package com.springboot.rest.restservice.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.restservice.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class TaskRepositoryTest {
	
	@Autowired
	TaskRepository repo;
	
	@Test
	public void assertAutoWiredTaskRepository() {
		assertNotNull(repo);
	}

}
