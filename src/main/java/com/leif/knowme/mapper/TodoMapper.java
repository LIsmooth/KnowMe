package com.leif.knowme.mapper;

import com.leif.knowme.model.TodoDo;
import com.leif.knowme.po.TodoPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoMapper {
    int createTodo(TodoDo todoDo);

    int updateStatusByTodoIdAccountId(TodoDo todoDo);

    List<TodoDo> getTodos(@Param("todo") TodoDo todoDo, String[] status);

    List<TodoDo> getTodosByIds(@Param("accountId") String accountId,@Param("todoIds") List<String> todoIds);
}
