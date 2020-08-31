package com.leif.knowme.factory;


import com.leif.knowme.api.request.CreateScheduleRequest;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.dto.ScheduleItemDto;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.dto.TodoDto;
import com.leif.knowme.exception.AuthException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleFactory {

    public static ScheduleDto assembleTodos(ScheduleDto schedule, List<TodoDto> todoDtos) throws AppException {
        if (todoDtos == null || todoDtos.size() == 0) {
            throw new AppException("No todo");
        }
        List<ScheduleItemDto> items = new ArrayList<>(todoDtos.size());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(schedule.getPlanStartTime());
        int orderNo = 1;
        for (TodoDto todo : todoDtos) {
            items.add(generateScheduleItemPo(todo, calendar, orderNo++));
        }
        if (schedule.getPlanEndTime() == null) {
            schedule.setPlanEndTime(calendar.getTime());
        }
        schedule.setScheduleItemDtos(items);
        return schedule;
    }

    public static ScheduleDto buildFromTodos(Date planStartTime, List<TodoDto> todoDtos) throws AppException {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setPlanStartTime(planStartTime);
        return assembleTodos(scheduleDto, todoDtos);
    }

    private static ScheduleItemDto generateScheduleItemPo(TodoDto todo, Calendar calendar, int orderNo) {
        Date startTime = calendar.getTime();
        calendar.add(Calendar.MINUTE, todo.getPlanConsumed());
        Date endTime = calendar.getTime();
        return new ScheduleItemDto(todo, startTime, endTime, orderNo);
    }

    public static ScheduleDto buildFromCreateRequest(KmRequest<CreateScheduleRequest> kmRequest) throws AuthException {
        CreateScheduleRequest request = kmRequest.getData();
        if (request.getAccountId() == null || !request.getAccountId().equals(kmRequest.getHeader().getAccountId())) {
            throw new AuthException("Not your account, asshole");
        }
        return new ScheduleDto(request.getAccountId(), request.getScheduleName(),
                request.getScheduleNote(), request.getPlanStartTime(), request.getPlanEndTime());
    }
}
