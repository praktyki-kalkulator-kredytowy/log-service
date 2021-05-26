package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduleCalculationEventConverterImpl implements ScheduleCalculationEventConverter {

    @Autowired
    private ScheduleConverter mScheduleConverter;

    @Autowired
    private ScheduleConfigurationConverter mScheduleConfigurationConverter;

    @Override
    public ScheduleCalculationEventEntity convertToEntity(ScheduleCalculationEvent scheduleCalculationEvent) {

        return new ScheduleCalculationEventEntity(
                scheduleCalculationEvent.id,
                scheduleCalculationEvent.calculationDate,
                mScheduleConfigurationConverter.convertToEntity(
                        scheduleCalculationEvent.schedule.getScheduleConfiguration()
                ),
                mScheduleConverter.convertToSummaryEntity(scheduleCalculationEvent.schedule)
        );

    }

}
