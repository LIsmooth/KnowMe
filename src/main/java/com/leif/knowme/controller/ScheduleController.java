package com.leif.knowme.controller;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.po.ScheduleItemPo;
import com.leif.knowme.po.SchedulePo;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping(headers = "Accept=application/json")
    public int createSchedule(@RequestBody KmRequest<SchedulePo> kmRequest) {
        return scheduleService.createSchedule(kmRequest.getData());
    }

    @GetMapping(value = "/preview")
    public SchedulePo previewSchedule(@RequestBody KmRequest<SchedulePo> kmRequest) throws AppException {
        SchedulePo schedulePo = kmRequest.getData();
        List<String> todoIds = schedulePo.getScheduleItemPos().stream()
                .sorted(Comparator.comparingInt(ScheduleItemPo::getOrderNo))
                .map(ScheduleItemPo::getTodoId).collect(Collectors.toList());
        return scheduleService.previewSchedule(new BaseContext(kmRequest), schedulePo.getPlanStartTime(), todoIds);
    }
}
