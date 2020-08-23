package com.leif.knowme.mapper;

import com.leif.knowme.model.ScheduleDo;
import com.leif.knowme.model.ScheduleItemDo;
import com.leif.knowme.po.SchedulePo;

import java.util.List;

public interface ScheduleMapper {

    int createSchedule(ScheduleDo scheduleDo);

    int saveScheduleItems(List<ScheduleItemDo> scheduleItemDos);
}
