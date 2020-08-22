package com.leif.knowme.controller;

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
    public int createTodo(@RequestBody TodoPo todoPo) {
        return todoService.createTodo(todoPo);
    }

    @DeleteMapping("/{todoId}")
    public boolean deleteByTodoId(@PathVariable String todoId) {
        return todoService.deleteByTodoId(todoId);
    }

    @DeleteMapping("/user/{userId}")
    public boolean deleteAllByUserId(@PathVariable String userId) {
        return todoService.deleteAllByUserId(userId);
    }

    @PutMapping
    public boolean updateTodo(@RequestBody TodoPo todoPo) {
        return false;//TODO updateTodo
    }

    @GetMapping("/user/{userId}/status/{status}/{pageNo}")
    public List<TodoPo> getUserAllTodos(@PathVariable String userId, @PathVariable int status, @PathVariable int pageNo) {
        return todoService.getUserAllTodos(userId,status,pageNo);
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
