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

    public int deleteAllByAccountId(String accountId) {
        TodoDo todoDo = new TodoDo();
        todoDo.setAccountId(accountId);
        todoDo.setStatus(TodoPo.STATUS_DELETED);
        return todoMapper.updateStatusByTodoIdAccountId(todoDo);
    }

    public int deleteByTodoId(String accountId, String todoId) {
        TodoDo todoDo = new TodoDo();
        todoDo.setTodoId(todoId);
        todoDo.setStatus(TodoPo.STATUS_DELETED);
        todoDo.setAccountId(accountId);
        return todoMapper.updateStatusByTodoIdAccountId(todoDo);
    }

    public List<TodoPo> getAccountAllTodos(String accountId, String[] status) {
        TodoDo todo = new TodoDo();
        todo.setAccountId(accountId);
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

    public List<TodoPo> getTodosByIds(String accountId,List<String> todoIds) {
        List<TodoDo> todoDos = todoMapper.getTodosByIds(accountId, todoIds);
        return convertToTodoPos(todoDos);
    }
}
