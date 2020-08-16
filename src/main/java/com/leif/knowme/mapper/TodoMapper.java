package com.leif.knowme.mapper;

import com.leif.knowme.model.TodoDo;

import java.util.List;

public interface TodoMapper {
    int createTodo(TodoDo todoDo);

    List<TodoDo> generateSchedule(String userId);

    boolean deleteAll(String userId);
}
