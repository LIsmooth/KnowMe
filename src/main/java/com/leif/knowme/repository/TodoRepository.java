package com.leif.knowme.repository;

import com.leif.knowme.dao.TodoMapper;
import com.leif.knowme.entity.Todo;
import com.leif.knowme.entity.TodoExample;
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
        Todo todo = getTodo(todoPo);
        todo.setTodoId(UUIDUtils.generateUUID());
        todoMapper.insertSelective(todo);
        return todo.getTodoId();
    }

    private Todo getTodo(TodoPo todoPo) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoPo, todo);
        return todo;
    }

    public int deleteAllByAccountId(String accountId) {
        Todo todo = new Todo();
        todo.setStatus(TodoPo.STATUS_DELETED);

        TodoExample example = new TodoExample();
        example.createCriteria().andAccountIdEqualTo(accountId);
        return todoMapper.updateByExampleSelective(todo, example);
    }

    public int deleteByTodoId(String accountId, String todoId) {
        Todo todo = new Todo();
        todo.setTodoId(todoId);
        todo.setStatus(TodoPo.STATUS_DELETED);

        TodoExample example = new TodoExample();
        example.createCriteria().andAccountIdEqualTo(accountId).andTodoIdEqualTo(todoId);
        return todoMapper.updateByExampleSelective(todo, example);
    }

    public List<TodoPo> getAccountAllTodos(String accountId, List<Integer> status) {
        TodoExample example = new TodoExample();
        example.createCriteria().andAccountIdEqualTo(accountId).andStatusIn(status);
        example.setOrderByClause("created");
        List<Todo> todos = todoMapper.selectByExample(example);
        return convertToTodoPos(todos);
    }

    private List<TodoPo> convertToTodoPos(List<Todo> todos) {
        if (CollectionUtils.isEmpty(todos)) {
            return null;
        }
        return todos.stream().map(todo -> {
            TodoPo todoPo = new TodoPo();
            BeanUtils.copyProperties(todo, todoPo);
            return todoPo;
        }).collect(Collectors.toList());
    }

    public List<TodoPo> getTodosByIds(String accountId, List<String> todoIds) {
        TodoExample example = new TodoExample();
        example.createCriteria().andAccountIdEqualTo(accountId).andTodoIdIn(todoIds);
        example.setOrderByClause("created");
        List<Todo> todos = todoMapper.selectByExample(example);
        return convertToTodoPos(todos);
    }
}
