package com.leif.knowme.dto.mapper;

import com.leif.knowme.api.response.ScheduleResponse;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.dto.ScheduleItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleDtoMr {
    ScheduleDtoMr INSTANCE= Mappers.getMapper( ScheduleDtoMr.class );

    @Mapping(target = "type", source = "todoDto.type")
    @Mapping(target = "planConsumed", source = "todoDto.planConsumed")
    @Mapping(target = "realConsumed", source = "todoDto.realConsumed")
    @Mapping(target = "eventMsg", source = "todoDto.eventMsg")
    ScheduleResponse.ScheduleItemVo scheduleItemDto2ScheduleItemVo(ScheduleItemDto scheduleItemDto);

    @Mapping(target = "items", source = "scheduleItemDtos")
    ScheduleResponse scheduleDto2ScheduleResponse(ScheduleDto scheduleDto);
}
