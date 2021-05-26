package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleSummaryEntity;
import com.praktyki.log.web.message.models.Schedule;

public interface ScheduleConverter {

    ScheduleSummaryEntity convertToSummaryEntity(Schedule schedule);

}
