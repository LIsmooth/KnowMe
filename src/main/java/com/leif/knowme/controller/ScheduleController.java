package com.leif.knowme.controller;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.po.ScheduleItemPo;
import com.leif.knowme.po.SchedulePo;
import com.leif.knowme.po.SchedulePreviewPo;
import com.leif.knowme.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public SchedulePo previewSchedule(@RequestBody KmRequest<SchedulePreviewPo> kmRequest) throws AppException {
        SchedulePreviewPo previewPo = kmRequest.getData();
        return scheduleService.previewSchedule(new BaseContext(kmRequest), previewPo.getPlanStartTime(), previewPo.getTodoIds());
    }
}
