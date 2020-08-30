package com.leif.knowme.service;

import com.leif.knowme.base.BaseContext;
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

    public int deleteAllByAccountId(String accountId) {
        return todoRepo.deleteAllByAccountId(accountId);
    }

    public int deleteByTodoId(BaseContext baseContext, String todoId) {
        return todoRepo.deleteByTodoId(baseContext.getAccountId(),todoId);
    }

    public List<TodoPo> getAccountAllTodos(String accountId, List<Integer> status, int pageNo) {
        return todoRepo.getAccountAllTodos(accountId,status);
    }

}
