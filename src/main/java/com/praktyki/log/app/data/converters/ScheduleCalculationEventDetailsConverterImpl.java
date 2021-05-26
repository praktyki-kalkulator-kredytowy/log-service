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

    @Override
    public ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEventDetailsModel scheduleCalculationEventDetailsModel) {

        return new ScheduleCalculationEventEntity(
                scheduleCalculationEventDetailsModel.id,
                scheduleCalculationEventDetailsModel.calculationDate,
                mScheduleConfigurationConverter.convertToEntity(
                        scheduleCalculationEventDetailsModel.schedule.scheduleConfiguration
                ),
                mScheduleConverter.convertToSummaryEntity(scheduleCalculationEventDetailsModel.schedule)
        );

    }

    @Override
    public ScheduleCalculationEventDetailsModel convertToModel(
            ScheduleCalculationEventEntity scheduleCalculationEventEntity,
            List<PaymentEntity> paymentEntityList)
    {
        return new ScheduleCalculationEventDetailsModel(
                scheduleCalculationEventEntity.eventId,
                mScheduleConverter.convertToScheduleModel(
                        scheduleCalculationEventEntity.scheduleSummaryEntity,
                        scheduleCalculationEventEntity.scheduleConfigurationEntity,
                        paymentEntityList
                ),
                scheduleCalculationEventEntity.orderDate
        );
    }

}
