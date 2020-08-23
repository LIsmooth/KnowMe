package com.leif.knowme.service;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.factory.ScheduleFactory;
import com.leif.knowme.po.SchedulePo;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.repository.ScheduleRepository;
import com.leif.knowme.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepo;
    @Autowired
    TodoRepository todoRepo;
    @Autowired
    ScheduleFactory scheduleFactory;

    @Transactional(rollbackFor = Exception.class)
    public int createSchedule(SchedulePo schedulePo) {
        return scheduleRepo.saveSchedule(schedulePo);
    }

    public SchedulePo previewSchedule(BaseContext context, Date planStartTime, List<String> todoIds) throws
            AppException {
        List<TodoPo> todoPos = todoRepo.getTodosByIds(context.getAccountId(), todoIds);
        return scheduleFactory.buildFromTodos(planStartTime, todoPos);
    }
}
