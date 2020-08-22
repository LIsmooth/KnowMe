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

    public String createTodo(TodoPo todoPo) {
        return todoRepo.createTodo(todoPo);
    }

    public int deleteAllByUserId(String userId) {
        return todoRepo.deleteAllByUserId(userId);
    }

    public int deleteByTodoId(String todoId) {
        return todoRepo.deleteByTodoId(todoId);
    }

    public List<TodoPo> getUserAllTodos(String userId, int status, int pageNo) {
        return todoRepo.getUserAllTodos(userId);
    }

}
