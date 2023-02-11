package com.codestates.todoappv2.controller;

import com.codestates.todoappv2.dto.TodoDto;
import com.codestates.todoappv2.entity.Todo;
import com.codestates.todoappv2.service.TodoService;
import com.codestates.todoappv2.mapper.TodoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoDto.TodoPostDto todoPostDto) {

        Todo todo = mapper.todoPostDtoToTodo(todoPostDto);

        Todo response = todoService.createTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") long todoId,
                                    @RequestBody TodoDto.TodoPatchDto todoPatchDto) {
        todoPatchDto.setTodoId(todoId);

        Todo response = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId) {
        Todo response = todoService.findTodo(todoId);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.findTodos();

        List<TodoDto.TodoResponseDto> response =
                todos.stream()
                        .map(todo -> mapper.todoToTodoResponseDto(todo))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") long todoId) {
        System.out.println("# todoId");
        todoService.deleteTodo(todoId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos() {
        todoService.deleteTodos();

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
