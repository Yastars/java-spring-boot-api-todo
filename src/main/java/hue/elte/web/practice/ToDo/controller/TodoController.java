package hue.elte.web.practice.ToDo.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hue.elte.web.practice.ToDo.configuration.AuthenticatedUser;
import hue.elte.web.practice.ToDo.entity.TodoEntity;
import hue.elte.web.practice.ToDo.repository.TodoRepository;
import hue.elte.web.practice.ToDo.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Autowired
    public TodoService todoService;

    @Autowired
    public TodoRepository todoRepository;

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("title", "Todo List");
        // model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("todos", todoRepository.findByUser(authenticatedUser.getUser()));
        return "todolist";
    }

    @GetMapping("/new")
    public String addForm(Model model) {
        model.addAttribute("todo", new TodoEntity());

        return "todo-form";
    }

    @PostMapping("/new")
    public String addTodo(@Valid TodoEntity todo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "todo-form";
        }

        todo.setUser(authenticatedUser.getUser());
        todoService.insert(todo);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @Secured({ "ROLE_ADMIN" })
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model) {
        Optional<TodoEntity> dbTodo = todoRepository.findById(id);

        if (dbTodo.isEmpty()) {
            return "redirect:/todos";
        }

        model.addAttribute("todo", todoRepository.findById(id).get());

        return "todo-form";
    }

    @Secured({ "ROLE_ADMIN" })
    @PostMapping("/{id}/edit")
    public String edittodo(@PathVariable Integer id, @Valid TodoEntity todo, BindingResult bindingResult, Model model) {
        Optional<TodoEntity> dbTodo = todoRepository.findById(id);

        if (dbTodo.isEmpty()) {
            return "redirect:/todos";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "todo-form";
        }

        todo.setUser(dbTodo.get().getUser());
        todoRepository.save(todo);

        return "redirect:/todos";
    }

}