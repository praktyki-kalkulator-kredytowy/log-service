package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEventDetailsModel;

import java.util.List;

public interface ScheduleCalculationEventDetailsConverter {

    ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEventDetailsModel scheduleCalculationEventDetailsModel);

    ScheduleCalculationEventDetailsModel convertToModel(
            ScheduleCalculationEventEntity scheduleCalculationEventEntity
    );


}
