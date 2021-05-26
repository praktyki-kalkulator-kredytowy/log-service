package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.web.message.models.ScheduleConfiguration;

public interface ScheduleConfigurationConverter {

    ScheduleConfigurationEntity convertToEntity(ScheduleConfiguration scheduleConfiguration);

}
