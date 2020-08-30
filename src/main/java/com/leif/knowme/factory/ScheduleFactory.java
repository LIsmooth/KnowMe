package com.leif.knowme.factory;


import com.leif.knowme.exception.AppException;
import com.leif.knowme.dto.ScheduleItemDto;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.dto.TodoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleFactory {

    public ScheduleDto buildFromTodos(Date planStartTime, List<TodoDto> todoDtos) throws AppException {
        if (todoDtos == null || todoDtos.size() == 0) {
            throw new AppException("No todo");
        }
        List<ScheduleItemDto> items = new ArrayList<>(todoDtos.size());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(planStartTime);
        int orderNo = 1;
        for (TodoDto todo : todoDtos) {
            items.add(generateScheduleItemPo(todo, calendar, orderNo++));
        }
        ScheduleDto schedule = new ScheduleDto();
        schedule.setPlanStartTime(planStartTime);
        schedule.setPlanEndTime(calendar.getTime());
        schedule.setScheduleItemDtos(items);
        return schedule;
    }

    private ScheduleItemDto generateScheduleItemPo(TodoDto todo, Calendar calendar, int orderNo) {
        Date startTime = calendar.getTime();
        calendar.add(Calendar.MINUTE, todo.getPlanConsumed());
        Date endTime = calendar.getTime();
        return new ScheduleItemDto(todo, startTime, endTime, orderNo);
    }
}
