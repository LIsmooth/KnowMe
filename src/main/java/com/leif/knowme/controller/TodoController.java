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

    @PutMapping(headers = "Accept=application/json")
    public int save(@RequestBody TodoDo todoDo) {
        return todoService.createTodo(todoDo);
    }

    @GetMapping(value = "/show/{userId}/{beginTime}")
    public Schedule generateTodos(@PathVariable String userId,
                                  @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmm") Date beginTime)
            throws AppException {
        System.out.println(beginTime);
        return todoService.generateSchedule(userId, beginTime);
    }
}
