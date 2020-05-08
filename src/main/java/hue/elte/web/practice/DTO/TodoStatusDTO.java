package hue.elte.web.practice.DTO;

import java.util.ArrayList;
import java.util.List;

import hue.elte.web.practice.ToDo.entity.TodoEntity;

public class TodoStatusDTO {
    private List<TodoEntity> todos = new ArrayList<>();
 
    // default and parameterized constructor
 
    public void addBook(TodoEntity book) {
        this.todos.add(book);
    }

    
     
    // getter and setter

    public void setTodos(List<TodoEntity> todos) {
		this.todos = todos;
    }
    

    public List<TodoEntity> getTodos(){
        return this.todos;
    }
    
}