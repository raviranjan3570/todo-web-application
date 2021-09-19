package com.example.springboot.todo.service;

import com.example.springboot.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static final List<Todo> todos = new ArrayList<>();
    private static final int todosCount = 3;

    static {
        todos.add(new Todo(1, "Golu", "Spring", new Date(), false));
        todos.add(new Todo(1, "Golu", "Android", new Date(), false));
        todos.add(new Todo(2, "Shubham", "Spring", new Date(), false));
        todos.add(new Todo(3, "Sunny", "Spring", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user){
        List<Todo> filteredTodos = new ArrayList<>();
        for(Todo todo : todos){
            if(todo.getUser().equals(user)){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(int id, String user, String desc, Date date, boolean isFinished){
        todos.add(new Todo(id, user, desc, date, isFinished));
    }

    public void deleteTodo(int id){
        todos.removeIf(todo -> todo.getId() == id);
    }
}
