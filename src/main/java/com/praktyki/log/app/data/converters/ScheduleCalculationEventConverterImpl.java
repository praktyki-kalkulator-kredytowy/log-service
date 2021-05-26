package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCalculationEventConverterImpl implements ScheduleCalculationEventConverter {
    @Override
    public ScheduleCalculationEventModel convertToModel(ScheduleCalculationEventEntity scheduleCalculationEventEntity) {
        return new ScheduleCalculationEventModel(
                scheduleCalculationEventEntity.eventId,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.capital,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.installmentType,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.installmentAmount,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.interestRate,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.withdrawalDate,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.commissionRate,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.age,
                scheduleCalculationEventEntity.scheduleConfigurationEntity.insurance,
                scheduleCalculationEventEntity.scheduleSummaryEntity.sumUpCapitalInstallment,
                scheduleCalculationEventEntity.scheduleSummaryEntity.loanPaidOutAmount,
                scheduleCalculationEventEntity.scheduleSummaryEntity.commissionAmount,
                scheduleCalculationEventEntity.scheduleSummaryEntity.insuranceTotalAmount,
                scheduleCalculationEventEntity.scheduleSummaryEntity.loanTotalCost,
                scheduleCalculationEventEntity.scheduleSummaryEntity.aprc,
                scheduleCalculationEventEntity.orderDate
        );
    }
}
