package com.codestates.todoappv2.repository;

import com.codestates.todoappv2.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
