package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;

public interface ScheduleCalculationEventConverter {

    ScheduleCalculationEventModel convertToModel(ScheduleCalculationEventEntity scheduleCalculationEventEntity);

}
