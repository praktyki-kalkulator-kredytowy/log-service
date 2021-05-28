package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.app.data.entities.ScheduleSummaryEntity;
import com.praktyki.log.web.message.models.ScheduleModel;

import java.util.List;

public interface ScheduleConverter {

    ScheduleSummaryEntity convertToSummaryEntity(ScheduleModel scheduleModel);

    ScheduleModel convertToScheduleModel(
            ScheduleCalculationEventEntity entity
    );

}
