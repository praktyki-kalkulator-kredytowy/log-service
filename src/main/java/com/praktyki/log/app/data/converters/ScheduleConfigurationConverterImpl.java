package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.web.message.models.ScheduleConfigurationModel;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfigurationConverterImpl implements ScheduleConfigurationConverter {

    @Override
    public ScheduleConfigurationEntity convertToEntity(ScheduleConfigurationModel scheduleConfigurationModel) {
        return new ScheduleConfigurationEntity(
                scheduleConfigurationModel.capital,
                scheduleConfigurationModel.installmentType,
                scheduleConfigurationModel.installmentAmount,
                scheduleConfigurationModel.interestRate,
                scheduleConfigurationModel.withdrawalDate,
                scheduleConfigurationModel.commissionRate,
                scheduleConfigurationModel.age,
                scheduleConfigurationModel.insurance
        );
    }

    @Override
    public ScheduleConfigurationModel convertToModel(ScheduleConfigurationEntity scheduleConfigurationEntity) {
        return new ScheduleConfigurationModel(
                scheduleConfigurationEntity.capital,
                scheduleConfigurationEntity.installmentType,
                scheduleConfigurationEntity.installmentAmount,
                scheduleConfigurationEntity.interestRate,
                scheduleConfigurationEntity.withdrawalDate,
                scheduleConfigurationEntity.commissionRate,
                scheduleConfigurationEntity.age,
                scheduleConfigurationEntity.insurance
        );
    }

}
