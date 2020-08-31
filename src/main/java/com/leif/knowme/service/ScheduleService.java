package com.leif.knowme.service;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.factory.ScheduleFactory;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.dto.TodoDto;
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

    @Transactional(rollbackFor = Exception.class)
    public int createSchedule(BaseContext context, ScheduleDto scheduleDto, List<String> todoIds) throws AppException {
        List<TodoDto> todoDtos = todoRepo.getTodosByIds(scheduleDto.getAccountId(), todoIds);
        ScheduleFactory.assembleTodos(scheduleDto, todoDtos);
        return scheduleRepo.saveSchedule(scheduleDto);
    }

    public ScheduleDto previewSchedule(BaseContext context, Date planStartTime, List<String> todoIds) throws
            AppException {
        List<TodoDto> todoDtos = todoRepo.getTodosByIds(context.getAccountId(), todoIds);
        return ScheduleFactory.buildFromTodos(planStartTime, todoDtos);
    }
}
