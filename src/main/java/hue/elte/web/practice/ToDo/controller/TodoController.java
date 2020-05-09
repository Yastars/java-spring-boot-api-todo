package hue.elte.web.practice.ToDo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

import hue.elte.web.practice.DTO.TodoStatusDTO;
import hue.elte.web.practice.ToDo.configuration.AuthenticatedUser;
import hue.elte.web.practice.ToDo.entity.TodoEntity;
import hue.elte.web.practice.ToDo.entity.TodoEntity.Category;
import hue.elte.web.practice.ToDo.entity.TodoEntity.Status;
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
        TodoStatusDTO todosDTO = new TodoStatusDTO();
        todosDTO.setTodos(todoRepository.findByUser(authenticatedUser.getUser()));
        model.addAttribute("todosDTO", todosDTO);
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

    @PostMapping("/updatecheck")
    public String updatecheck(@RequestParam(required = false) Integer[]  status, @RequestParam(required = false) Integer[] todosViewd,
            Model model) {

        List<TodoEntity> userTodos = todoRepository.findByUser(authenticatedUser.getUser());
        for (TodoEntity todo : userTodos) 
        { 
            if(Arrays.asList(todosViewd).contains((todo.getId())))
                todo.setStatus(Status.NEW);
                try {
                    if(status.length >0 && Arrays.asList(status).contains((todo.getId()))){
                        todo.setStatus(Status.DONE);
                    }
                    
                } catch (Exception e) {
                    //TODO: handle exception
                }
                todoRepository.save(todo);
        }
        TodoStatusDTO todosDTO = new TodoStatusDTO();
        todosDTO.setTodos(todoRepository.findByUser(authenticatedUser.getUser()));
        model.addAttribute("todosDTO", todosDTO);
        return "redirect:/todos";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam("filterOption") String  filterOption, Model model ) {

        Category category = Category.valueOf(filterOption);

        List<TodoEntity> userTodos = todoRepository.findByUser(authenticatedUser.getUser());
        List<TodoEntity> filteredTodos = new ArrayList<>();
        
        for (TodoEntity todo : userTodos) 
            if(todo.getCategory().name() == category.name()) 
                filteredTodos.add(todo);
           
            System.out.println(filteredTodos.size());
                
        
        TodoStatusDTO todosDTO = new TodoStatusDTO();
        todosDTO.setTodos(filteredTodos);
        model.addAttribute("title", "Filtering : " + filterOption);
        model.addAttribute("todosDTO", todosDTO);
        return "todolist";
    }

}