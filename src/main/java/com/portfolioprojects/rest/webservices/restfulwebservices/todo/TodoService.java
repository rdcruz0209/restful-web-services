package com.portfolioprojects.rest.webservices.restfulwebservices.todo;

//import com.portfolioprojects.rest.webservices.restfulwebservices.exception.TodoNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class TodoService {

    private final static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Robert", "Get AWS Certified 1",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++todosCount, "Robert", "Learn Spring 1",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++todosCount, "Robert", "Learn React 1",
                LocalDate.now().plusYears(1), false));


    }

    public List<Todo> findByUserName(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
//        if (todos.stream().noneMatch(todos -> todos.getUsername().equals(username))) {
//            throw new UserNotFoundException("User Not Found");
//        }

        return todos.stream().filter(predicate).toList();
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean isCompleted) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, isCompleted);
        todos.add(todo);
        return todo;
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todos -> todos.getId() == id);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public Todo findTodoByUserNameAndId(String username, int id) {
        Optional<Todo> optionalTodo = findByUserName(username).stream().filter(todo -> todo.getId() == id).findFirst();
        return optionalTodo.get();
    }

    public void deleteTodoByUsernameAndId(String username, int id) {
        todos.removeIf(todo -> todo.getUsername().equals(username) && todo.getId() == id);
    }

    public void updateTodo(Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);

    }
}
