package com.codestates.todoappv2.mapper;

import com.codestates.todoappv2.dto.TodoDto;
import com.codestates.todoappv2.entity.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoDto.TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoDto.TodoPatchDto todoPatchDto);
    TodoDto.TodoResponseDto todoToTodoResponseDto(Todo todo);
}
