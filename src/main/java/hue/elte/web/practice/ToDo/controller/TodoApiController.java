package hue.elte.web.practice.ToDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hue.elte.web.practice.ToDo.entity.TodoEntity;
import hue.elte.web.practice.ToDo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {

    @Autowired
    private TodoService todoService;

    @GetMapping("")
    private List<TodoEntity> getTodos(@RequestParam(required = false) String category){
        return todoService.getByCategory(category);
    }


    @GetMapping("/{id}")
    private TodoEntity getById(@PathVariable int id){
        return todoService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable int id){
        todoService.delete(id);
    }

    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    private void insertTodo (@RequestBody TodoEntity todo){
        todoService.insert(todo);
    }
}