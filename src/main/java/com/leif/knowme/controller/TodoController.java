package com.leif.knowme.controller;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping(headers = "Accept=application/json")
    public String createTodo(@RequestBody KmRequest<TodoPo> request) {
        return todoService.createTodo(request.getData());
    }

    @DeleteMapping("/{todoId}")
    public int deleteByTodoId(@RequestBody KmRequest<Object> request,@PathVariable String todoId) {
        return todoService.deleteByTodoId(new BaseContext(request),todoId);
    }

    @DeleteMapping("/account/{accountId}")
    public int deleteAllByAccountId(@RequestBody KmRequest<Object> request,@PathVariable String accountId) {
        return todoService.deleteAllByAccountId(accountId);
    }

    @PutMapping
    public int updateTodo(@RequestBody TodoPo todoPo) {
        return 0;//TODO updateTodo
    }

    @GetMapping("/account/{accountId}/status/{status}/{pageNo}")
    public List<TodoPo> getAccountAllTodos(@PathVariable String accountId, @PathVariable String status,
                                           @PathVariable int pageNo) {
        return todoService.getAccountAllTodos(accountId, status.split("-"), pageNo);
    }

/*

    @GetMapping(value = "/showschedule/{userId}/{beginTime}")
    public String showSchedule(@PathVariable String userId,
                               @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmm") Date beginTime)
            throws AppException {
        return todoService.showSchedule(userId, beginTime);
    }
*/

}
