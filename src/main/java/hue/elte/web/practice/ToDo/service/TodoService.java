package hue.elte.web.practice.ToDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hue.elte.web.practice.ToDo.entity.TodoEntity;
import hue.elte.web.practice.ToDo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> getAllTodos(){
        return todoRepository.findAll();
    }

    public TodoEntity getById(int id){
        return todoRepository.findById(id);
    }

    public <S extends TodoEntity>TodoEntity insert(TodoEntity todo){
        return todoRepository.save(todo);
    }

    public void delete(int id){
        todoRepository.deleteById(id);
    }
}