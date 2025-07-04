package com.example.todos.service;

import com.example.todos.request.TodoRequest;
import com.example.todos.response.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
    List<TodoResponse> getAllTodos();
    TodoResponse toggleTodoCompletion(Long id);
    void deleteTodo(long id);
}
