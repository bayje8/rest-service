package com.springboot.rest.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.restservice.entity.ParentTask;

public interface ParentTaskRepository extends CrudRepository<ParentTask, Integer> {

}
