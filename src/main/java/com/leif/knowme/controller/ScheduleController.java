package com.leif.knowme.controller;

import com.leif.knowme.po.SchedulePo;
import com.leif.knowme.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping(headers = "Accept=application/json")
    public int createSchedule(@RequestBody SchedulePo SchedulePo){
        return 0;
    }
}
