package com.leif.knowme.factory;

import com.leif.knowme.entity.Schedule;
import com.leif.knowme.entity.ScheduleItem;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.model.TodoDo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleFactory {

    public Schedule buildFromTodos(Date beginTime, List<TodoDo> todoDos) throws AppException {
        if (todoDos == null || todoDos.size() == 0) {
            throw new AppException("someThing wrong");
        }
        List<ScheduleItem> items=new ArrayList<>(todoDos.size());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(beginTime);
        for (TodoDo todo : todoDos) {
            items.add(new ScheduleItem(todo,calendar));
        }
        Schedule schedule=new Schedule();
        schedule.setBeginTime(beginTime);
        schedule.setScheduleItems(items);
        return schedule;
    }
}
