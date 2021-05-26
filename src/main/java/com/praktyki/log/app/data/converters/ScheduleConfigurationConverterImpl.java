package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.web.message.models.ScheduleConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfigurationConverterImpl implements ScheduleConfigurationConverter {

    @Override
    public ScheduleConfigurationEntity convertToEntity(ScheduleConfiguration scheduleConfiguration) {
        return new ScheduleConfigurationEntity(
                scheduleConfiguration.getCapital(),
                scheduleConfiguration.getInstallmentType(),
                scheduleConfiguration.getInstallmentAmount(),
                scheduleConfiguration.getInterestRate(),
                scheduleConfiguration.getWithdrawalDate(),
                scheduleConfiguration.getCommissionRate(),
                scheduleConfiguration.getAge(),
                scheduleConfiguration.isInsurance()
        );
    }

}
