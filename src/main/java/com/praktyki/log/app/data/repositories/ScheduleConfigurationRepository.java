package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.app.data.entities.ScheduleSummaryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleConfigurationRepository extends CrudRepository<ScheduleConfigurationEntity, Integer> {

    @Query(value = "SELECT * FROM schedule_configurations WHERE schedule_calculation_event_id = :id", nativeQuery = true)
    ScheduleConfigurationEntity findByEventId(Integer id);

}
