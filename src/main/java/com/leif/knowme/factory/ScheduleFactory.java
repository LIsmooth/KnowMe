package com.leif.knowme.factory;


import com.leif.knowme.exception.AppException;
import com.leif.knowme.po.ScheduleItemPo;
import com.leif.knowme.po.SchedulePo;
import com.leif.knowme.po.TodoPo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleFactory {

    public SchedulePo buildFromTodos(Date planStartTime, List<TodoPo> todoPos) throws AppException {
        if (todoPos == null || todoPos.size() == 0) {
            throw new AppException("No todo");
        }
        List<ScheduleItemPo> items = new ArrayList<>(todoPos.size());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(planStartTime);
        int orderNo = 1;
        for (TodoPo todo : todoPos) {
            items.add(generateScheduleItemPo(todo, calendar, orderNo++));
        }
        SchedulePo schedule = new SchedulePo();
        schedule.setPlanStartTime(planStartTime);
        schedule.setPlanEndTime(calendar.getTime());
        schedule.setScheduleItemPos(items);
        return schedule;
    }

    private ScheduleItemPo generateScheduleItemPo(TodoPo todo, Calendar calendar, int orderNo) {
        Date startTime = calendar.getTime();
        calendar.add(Calendar.MINUTE, todo.getPlanConsumed());
        Date endTime = calendar.getTime();
        return new ScheduleItemPo(todo, startTime, endTime, orderNo);
    }
}
