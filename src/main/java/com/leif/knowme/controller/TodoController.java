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
    public String createTodo(@RequestBody TodoPo todoPo) {
        return todoService.createTodo(todoPo);
    }

    @DeleteMapping("/{todoId}")
    public int deleteByTodoId(@PathVariable String todoId) {
        return todoService.deleteByTodoId(todoId);
    }

    @DeleteMapping("/user/{userId}")
    public int deleteAllByUserId(@PathVariable String userId) {
        return todoService.deleteAllByUserId(userId);
    }

    @PutMapping
    public int updateTodo(@RequestBody TodoPo todoPo) {
        return 0;//TODO updateTodo
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
