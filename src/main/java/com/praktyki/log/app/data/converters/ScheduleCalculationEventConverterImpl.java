package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleCalculationEventConverterImpl implements ScheduleCalculationEventConverter {

    @Autowired
    private ScheduleConverter mScheduleConverter;

    @Autowired
    private ScheduleConfigurationConverter mScheduleConfigurationConverter;

    @Override
    public ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEventModel scheduleCalculationEventModel) {

        return new ScheduleCalculationEventEntity(
                scheduleCalculationEventModel.id,
                scheduleCalculationEventModel.calculationDate,
                mScheduleConfigurationConverter.convertToEntity(
                        scheduleCalculationEventModel.schedule.scheduleConfiguration
                ),
                mScheduleConverter.convertToSummaryEntity(scheduleCalculationEventModel.schedule)
        );

    }

    @Override
    public ScheduleCalculationEventModel convertToModel(
            ScheduleCalculationEventEntity scheduleCalculationEventEntity,
            List<PaymentEntity> paymentEntityList)
    {
        return new ScheduleCalculationEventModel(
                scheduleCalculationEventEntity.scheduleCalculationEventId,
                mScheduleConverter.convertToScheduleModel(
                        scheduleCalculationEventEntity.scheduleSummaryEntity,
                        scheduleCalculationEventEntity.scheduleConfigurationEntity,
                        paymentEntityList
                ),
                scheduleCalculationEventEntity.orderDate
        );
    }

}
