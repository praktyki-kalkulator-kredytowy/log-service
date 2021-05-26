package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;

import java.util.List;

public interface ScheduleCalculationEventConverter {

    ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEventModel scheduleCalculationEventModel);

    ScheduleCalculationEventModel convertToModel(
            ScheduleCalculationEventEntity scheduleCalculationEventEntity,
            List<PaymentEntity> paymentEntityList
    );

}
