package com.leif.knowme.controller;

import com.leif.knowme.api.request.CreateScheduleRequest;
import com.leif.knowme.api.request.SchedulePreviewRequest;
import com.leif.knowme.api.response.SchedulePreviewResponse;
import com.leif.knowme.base.BaseContext;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.exception.AuthException;
import com.leif.knowme.factory.ScheduleFactory;
import com.leif.knowme.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public int createSchedule(@RequestBody KmRequest<CreateScheduleRequest> kmRequest) throws AuthException, AppException {
        ScheduleDto scheduleDto = ScheduleFactory.buildFromCreateRequest(kmRequest);
        return scheduleService.createSchedule(new BaseContext(kmRequest), scheduleDto, kmRequest.getData().getTodoIds());
    }

    @GetMapping(value = "/preview")
    public SchedulePreviewResponse previewSchedule(@RequestBody KmRequest<SchedulePreviewRequest> kmRequest) throws
            AppException {
        SchedulePreviewRequest previewPo = kmRequest.getData();
        ScheduleDto scheduleDto = scheduleService
                .previewSchedule(new BaseContext(kmRequest), previewPo.getPlanStartTime(), previewPo.getTodoIds());
        return new SchedulePreviewResponse(scheduleDto);
    }
}
