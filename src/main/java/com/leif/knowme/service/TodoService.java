package com.leif.knowme.service;

import com.leif.knowme.entity.Schedule;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.factory.ScheduleFactory;
import com.leif.knowme.mapper.TodoMapper;
import com.leif.knowme.model.TodoDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private ScheduleFactory scheduleFactory;

    public int createTodo(TodoDo todoDo) {
        return todoMapper.createTodo(todoDo);
    }

    public Schedule generateSchedule(String userId, Date beginTime) throws AppException {
        List<TodoDo> todoDos = todoMapper.generateSchedule(userId);
        return scheduleFactory.buildFromTodos(beginTime, todoDos);
    }

    public boolean deleteAll(String userId) {
        return todoMapper.deleteAll(userId);
    }

    public String showSchedule(String userId, Date beginTime) throws AppException {
        return generateSchedule(userId,beginTime).toString();
    }

    public boolean deleteById(long todoId){
        return todoMapper.deleteById(todoId);
    }
}
