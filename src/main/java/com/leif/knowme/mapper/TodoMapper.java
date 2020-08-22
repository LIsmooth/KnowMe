package com.leif.knowme.mapper;

import com.leif.knowme.model.TodoDo;
import com.leif.knowme.po.TodoPo;

import java.util.List;

public interface TodoMapper {
    int createTodo(TodoDo todoDo);

    boolean deleteAllByUserId(String userId);

    boolean deleteByTodoId(String todoId);

    List<TodoDo> getUserAllTodos(String userId);
}
