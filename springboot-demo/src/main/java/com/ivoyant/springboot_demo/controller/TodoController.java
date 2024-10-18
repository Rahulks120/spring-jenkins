package com.ivoyant.springboot_demo.controller;

import com.ivoyant.springboot_demo.Todo;
import com.ivoyant.springboot_demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo-list")
    public String listAllTodos(Model model) {
        List<Todo> allTodos = todoService.getAllTodos();
        model.addAttribute("todos", allTodos);
        return "listtodos";
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(@Valid @ModelAttribute Todo todo) {
        todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.getTargetDate());
        return "redirect:/todo-list";
    }

    @GetMapping("/delete-todo/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodoById(id);
        return "redirect:/todo-list";
    }
}
