package com.akechsalim.demo.todo;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(username, description, targetDate, done);
        return todoRepository.save(todo);
    }

    public void deleteById(int id) {
        todoRepository.deleteById((int) id);
    }

    public Todo findById(int id) {
        return todoRepository.findById((int) id).orElse(null);
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}