package com.leif.knowme.service;

import com.leif.knowme.factory.ScheduleFactory;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

@Autowired
private TodoRepository todoRepo;
    @Autowired
    private ScheduleFactory scheduleFactory;

    public int createTodo(TodoPo todoPo) {
        return todoRepo.createTodo(todoPo);
    }

    public boolean deleteAllByUserId(String userId) {
        return todoRepo.deleteAllByUserId(userId);
    }

    public boolean deleteByTodoId(String todoId){
        return todoRepo.deleteByTodoId(todoId);
    }

    public List<TodoPo> getUserAllTodos(String userId, int status, int pageNo) {
        return todoRepo.getUserAllTodos(userId);
    }

/*    public Schedule generateSchedule(String userId, Date beginTime) throws AppException {
        List<TodoDo> todoDos = todoMapper.generateSchedule(userId);
        return scheduleFactory.buildFromTodos(beginTime, todoDos);
    }

    public String showSchedule(String userId, Date beginTime) throws AppException {
        return generateSchedule(userId,beginTime).toString();
    }*/

}
