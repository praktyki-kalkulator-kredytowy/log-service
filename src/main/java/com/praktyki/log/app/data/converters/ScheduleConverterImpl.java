package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleSummaryEntity;
import com.praktyki.log.web.message.models.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConverterImpl implements ScheduleConverter {

    @Override
    public ScheduleSummaryEntity convertToSummaryEntity(Schedule schedule) {
        return new ScheduleSummaryEntity(
                schedule.getSumUpCapitalInstallment(),
                schedule.getLoanPaidOutAmount(),
                schedule.getCommissionAmount(),
                schedule.getInsuranceTotalAmount(),
                schedule.getLoanTotalCost(),
                schedule.getAPRC()
        );
    }

}
