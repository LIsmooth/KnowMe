package com.leif.knowme.mapper;

import com.leif.knowme.model.TodoDo;
import com.leif.knowme.po.TodoPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoMapper {
    int createTodo(TodoDo todoDo);

    int deleteAllByUserId(TodoDo todoDo);

    int deleteByTodoId(TodoDo todoDo);

    List<TodoDo> getTodos(@Param("todo") TodoDo todoDo, String[] status);

    List<TodoDo> getTodosByIds(String userId, List<String> todoIds);
}
