package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEvent;

public interface ScheduleCalculationEventConverter {

    ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEvent scheduleCalculationEvent);

}
