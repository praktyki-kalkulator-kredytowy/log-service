package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.web.message.models.ScheduleConfigurationModel;

public interface ScheduleConfigurationConverter {

    ScheduleConfigurationEntity convertToEntity(ScheduleConfigurationModel scheduleConfigurationModel);

    ScheduleConfigurationModel convertToModel(ScheduleConfigurationEntity scheduleConfigurationEntity);

}
