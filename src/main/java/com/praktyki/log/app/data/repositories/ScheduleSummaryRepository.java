package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.ScheduleSummaryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleSummaryRepository extends CrudRepository<ScheduleSummaryEntity, Integer> {

    @Query(value = "SELECT * FROM schedule_summary WHERE schedule_calculation_event_id = :id", nativeQuery = true)
    ScheduleSummaryEntity findByEventId(Integer id);

}
