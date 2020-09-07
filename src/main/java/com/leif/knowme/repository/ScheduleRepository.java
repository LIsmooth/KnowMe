package com.leif.knowme.repository;

import com.leif.knowme.dao.ScheduleItemMapper;
import com.leif.knowme.dao.ScheduleMapper;
import com.leif.knowme.entity.Schedule;
import com.leif.knowme.entity.ScheduleItem;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ScheduleRepository {
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    ScheduleItemMapper scheduleItemMapper;

    public int saveSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = extractSchedule(scheduleDto);
        String scheduleId = UUIDUtils.generateUUID();
        schedule.setScheduleId(scheduleId);

        List<ScheduleItem> scheduleItemDos = extractScheduleItems(scheduleId,scheduleDto);
        scheduleMapper.insertSelective(schedule);
        return scheduleItemMapper.insertItems(scheduleItemDos);
    }

    private List<ScheduleItem> extractScheduleItems(String scheduleId, ScheduleDto scheduleDto) {
        return scheduleDto.getScheduleItemDtos().stream().map(item -> {
            ScheduleItem scheduleItem = new ScheduleItem();
            BeanUtils.copyProperties(item, scheduleItem);
            scheduleItem.setScheduleId(scheduleId);
            scheduleItem.setTodoId(item.getTodoDto().getTodoId());
            return scheduleItem;
        }).collect(Collectors.toList());
    }

    private Schedule extractSchedule(ScheduleDto scheduleDto) {
        Schedule scheduleDo = new Schedule();
        BeanUtils.copyProperties(scheduleDto, scheduleDo);
        return scheduleDo;
    }

    public ScheduleDto getLatestSchedule(String accountId) {
        return scheduleMapper.getLatestSchedule(accountId);
    }
}
