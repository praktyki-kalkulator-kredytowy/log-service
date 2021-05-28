package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEventDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleCalculationEventDetailsConverterImpl implements ScheduleCalculationEventDetailsConverter {

    @Autowired
    private ScheduleConverter mScheduleConverter;

    @Autowired
    private ScheduleConfigurationConverter mScheduleConfigurationConverter;

    @Autowired
    private PaymentConverter mPaymentConverter;

    @Override
    public ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEventDetailsModel scheduleCalculationEventDetailsModel) {

        return new ScheduleCalculationEventEntity(
                scheduleCalculationEventDetailsModel.id,
                scheduleCalculationEventDetailsModel.calculationDate,
                mScheduleConfigurationConverter.convertToEntity(
                        scheduleCalculationEventDetailsModel.schedule.scheduleConfiguration
                ),
                mScheduleConverter.convertToSummaryEntity(scheduleCalculationEventDetailsModel.schedule),
                mPaymentConverter.convertListToEntity(scheduleCalculationEventDetailsModel.schedule.payments)
        );

    }

    @Override
    public ScheduleCalculationEventDetailsModel convertToModel(
            ScheduleCalculationEventEntity scheduleCalculationEventEntity)
    {
        return new ScheduleCalculationEventDetailsModel(
                scheduleCalculationEventEntity.eventId,
                mScheduleConverter.convertToScheduleModel(
                        scheduleCalculationEventEntity
                ),
                scheduleCalculationEventEntity.orderDate
        );
    }

}
