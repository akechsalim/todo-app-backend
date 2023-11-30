package com.akechsalim.demo.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
//
//	private static final List<Todo> todos = new ArrayList<>();
//
//	static {
//		todos.add(new Todo("akechsalim","Get AWS Certified", LocalDate.now().plusYears(1), false ));
//		todos.add(new Todo("akechsalim","Learn DevOps", LocalDate.now().plusYears(1), false ));
//		todos.add(new Todo("akechsalim","Learn Full Stack Development", LocalDate.now().plusYears(2), false ));
//	}

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