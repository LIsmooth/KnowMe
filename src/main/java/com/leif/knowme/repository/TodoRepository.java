package com.leif.knowme.repository;

import com.leif.knowme.mapper.TodoMapper;
import com.leif.knowme.model.TodoDo;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    @Autowired
    private TodoMapper todoMapper;

    public String createTodo(TodoPo todoPo) {
        TodoDo todoDo = getTodoDo(todoPo);
        todoDo.setTodoId(UUIDUtils.generateUUID());
        todoMapper.createTodo(todoDo);
        return todoDo.getTodoId();
    }

    private TodoDo getTodoDo(TodoPo todoPo) {
        TodoDo todoDo = new TodoDo();
        BeanUtils.copyProperties(todoPo, todoDo);
        return todoDo;
    }

    public int deleteAllByUserId(String userId) {
        TodoDo todoDo = new TodoDo();
        todoDo.setUserId(userId);
        todoDo.setStatus(TodoPo.STATUS_DELETED);
        return todoMapper.deleteAllByUserId(todoDo);
    }

    public int deleteByTodoId(String todoId) {
        TodoDo todoDo = new TodoDo();
        todoDo.setTodoId(todoId);
        todoDo.setStatus(TodoPo.STATUS_DELETED);
        return todoMapper.deleteByTodoId(todoDo);
    }

    public List<TodoPo> getUserAllTodos(String userId, String[] status) {
        TodoDo todo = new TodoDo();
        todo.setUserId(userId);
        List<TodoDo> todoDos = todoMapper.getTodos(todo, status);
        return convertToTodoPos(todoDos);
    }

    private List<TodoPo> convertToTodoPos(List<TodoDo> todoDos) {
        if (CollectionUtils.isEmpty(todoDos)) {
            return null;
        }
        return todoDos.stream().map(todoDo -> {
            TodoPo todoPo = new TodoPo();
            BeanUtils.copyProperties(todoDo, todoPo);
            return todoPo;
        }).collect(Collectors.toList());
    }

    public List<TodoPo> getTodosByIds(String userId,List<String> todoIds) {
        List<TodoDo> todoDos = todoMapper.getTodosByIds(userId, todoIds);
        return convertToTodoPos(todoDos);
    }
}
