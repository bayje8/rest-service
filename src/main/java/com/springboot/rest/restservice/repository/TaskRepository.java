package com.springboot.rest.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.restservice.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
