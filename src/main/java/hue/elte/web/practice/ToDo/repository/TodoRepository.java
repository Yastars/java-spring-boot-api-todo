package hue.elte.web.practice.ToDo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hue.elte.web.practice.ToDo.entity.TodoEntity;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Integer>{
    List<TodoEntity> findAll();
    <S extends TodoEntity>TodoEntity save(TodoEntity todo);
    TodoEntity findById(int id);
    void deleteById(int id);
}