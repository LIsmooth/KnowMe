package com.leif.knowme.repository;

import com.leif.knowme.mapper.TodoMapper;
import com.leif.knowme.model.TodoDo;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return todoMapper.deleteAllByUserId(userId);
    }

    public int deleteByTodoId(String todoId) {
        return todoMapper.deleteByTodoId(todoId);
    }

    public List<TodoPo> getUserAllTodos(String userId) {
        List<TodoDo> todoDos = todoMapper.getUserAllTodos(userId);
        if (todoDos != null) {
            return todoDos.stream().map(todoDo -> {
                TodoPo todoPo = new TodoPo();
                BeanUtils.copyProperties(todoDo, todoPo);
                return todoPo;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
