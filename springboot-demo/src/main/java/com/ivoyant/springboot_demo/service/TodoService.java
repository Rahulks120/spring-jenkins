package com.ivoyant.springboot_demo.service;

import com.ivoyant.springboot_demo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class TodoService {

    private final List<Todo> todos;
    private static int count = 0;

    public TodoService() {
        todos = new ArrayList<>();
        todos.add(new Todo(++count, "user1", "Complete Spring Boot tutorial", LocalDate.of(2024, 9, 10)));
        todos.add(new Todo(++count, "user2", "Read Spring documentation", LocalDate.of(2024, 9, 12)));
        todos.add(new Todo(++count, "user3", "Write a blog post", LocalDate.of(2024, 9, 15)));
        todos.add(new Todo(++count, "user4", "Prepare presentation slides", LocalDate.of(2024, 9, 20)));
        todos.add(new Todo(++count, "user5", "Update GitHub repository", LocalDate.of(2024, 9, 25)));
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate) {
        Todo todo = new Todo(++count, username, description, targetDate);
        todos.add(todo);
    }


    public void deleteTodoById(int id) {
        log.info("log id :{}", id);
        todos.removeIf(todo -> todo.getId() == id);
    }
}
