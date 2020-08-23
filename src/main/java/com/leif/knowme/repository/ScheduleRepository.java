package com.leif.knowme.repository;

import com.leif.knowme.mapper.ScheduleMapper;
import com.leif.knowme.model.ScheduleDo;
import com.leif.knowme.model.ScheduleItemDo;
import com.leif.knowme.po.SchedulePo;
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

    public int saveSchedule(SchedulePo schedulePo) {
        ScheduleDo scheduleDo = extractScheduleDo(schedulePo);
        scheduleDo.setScheduleId(UUIDUtils.generateUUID());
        List<ScheduleItemDo> scheduleItemDos = extractScheduleItemDos(schedulePo);
        scheduleMapper.createSchedule(scheduleDo);
        return scheduleMapper.saveScheduleItems(scheduleItemDos);
    }

    private List<ScheduleItemDo> extractScheduleItemDos(SchedulePo schedulePo) {
        return schedulePo.getScheduleItemPos().stream().map(item -> {
            ScheduleItemDo itemDo = new ScheduleItemDo();
            BeanUtils.copyProperties(item, itemDo);
            return itemDo;
        }).collect(Collectors.toList());
    }

    private ScheduleDo extractScheduleDo(SchedulePo schedulePo) {
        ScheduleDo scheduleDo = new ScheduleDo();
        BeanUtils.copyProperties(schedulePo, scheduleDo);
        return scheduleDo;
    }
}
