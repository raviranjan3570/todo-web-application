package com.example.springboot.todo.controller;

import com.example.springboot.todo.jpa.Todo;
import com.example.springboot.todo.jpa.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {

    @Autowired
    TodoRepository repository;

    // It is used to set date format across the application.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName();
        model.put("todos", repository.findByUser(name));
        return "list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    // model.addAttribute adds object to the model.
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodo(ModelMap model) {
        model.addAttribute("todo", new Todo(0, getLoggedInUserName(),
                "", new Date(), false));
        return "todo";
    }

    // BindingResult checks if the validation is succeeding or not.
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(getLoggedInUserName());
        repository.save(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        repository.deleteById(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = repository.findById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(getLoggedInUserName());
        repository.save(todo);
        return "redirect:/list-todos";
    }
}
