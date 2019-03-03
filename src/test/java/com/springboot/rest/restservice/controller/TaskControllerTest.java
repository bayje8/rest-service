package com.springboot.rest.restservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.controller.TaskController;
import com.springboot.rest.restservice.entity.CommonTask;
import com.springboot.rest.restservice.service.ITaskService;
import com.springboot.rest.restservice.service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfiguration.class)
@AutoConfigureMockMvc
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ITaskService service;
	
	List<CommonTask> tasklist;
	CommonTask task1;
	CommonTask task2;
	String allTasksJSONres;
	String aTaskJSONRes;
	
	@Before
	public void setUp() {
		task1 = new CommonTask(16, 15, "Task 1", "2019-01-01", "2019-03-01", 10, "P Task 1");
		allTasksJSONres = "[{\"task_id\":16,\"parent_id\":15,\"task\":\"Task 1\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-03-01\",\"priority\":10,\"parentTask\":\"P Task 1\"},{\"task_id\":18,\"parent_id\":17,\"task\":\"Task 2\",\"startDate\":\"2019-02-02\",\"endDate\":\"2019-03-01\",\"priority\":2,\"parentTask\":\"Edited P Task 2\"}]";
		aTaskJSONRes = "{\"task_id\":16,\"parent_id\":15,\"task\":\"Task 1\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-03-01\",\"priority\":10,\"parentTask\":\"P Task 1\"}";
		task2 = new CommonTask(18, 17, "Task 2", "2019-02-02", "2019-03-01", 2, "Edited P Task 2");
		tasklist = new ArrayList<CommonTask>();
		tasklist.add(task1);
		tasklist.add(task2);
	}
	
	@Test
	public void retrieveAllTasksTest() throws Exception{
		Mockito.when(service.retrieveAllTasks()).thenReturn(tasklist);
		
		RequestBuilder builder =  MockMvcRequestBuilders.get("/tasks").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		
		JSONAssert.assertEquals(allTasksJSONres, mvcResult.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void retrieveTaskByIdTest() throws Exception{
		Mockito.when(service.retrieveTaskById(16)).thenReturn(task1);
		
		RequestBuilder builder =  MockMvcRequestBuilders.get("/tasks/16").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		
		JSONAssert.assertEquals(aTaskJSONRes, mvcResult.getResponse().getContentAsString(), false);
	}

}
