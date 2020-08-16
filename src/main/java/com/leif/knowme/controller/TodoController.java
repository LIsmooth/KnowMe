package com.leif.knowme.controller;

import com.leif.knowme.entity.Schedule;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.model.TodoDo;
import com.leif.knowme.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {


    @Autowired
    TodoService todoService;

    @PutMapping(value = "/create" ,headers = "Accept=application/json")
    public int createTodo(@RequestBody TodoDo todoDo) {
        return todoService.createTodo(todoDo);
    }

    @GetMapping(value = "/show/{userId}/{beginTime}")
    public Schedule generateTodos(@PathVariable String userId,
                                  @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmm") Date beginTime)
            throws AppException {
        return todoService.generateSchedule(userId, beginTime);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public boolean deleteAll(@PathVariable String userId) {
        return todoService.deleteAll(userId);
    }

    @GetMapping(value = "/showschedule/{userId}/{beginTime}")
    public String showSchedule(@PathVariable String userId,
                               @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmm") Date beginTime)
            throws AppException {
        return todoService.showSchedule(userId, beginTime);
    }
}
