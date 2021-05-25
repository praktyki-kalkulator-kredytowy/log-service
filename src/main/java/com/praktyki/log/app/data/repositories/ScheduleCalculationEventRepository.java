package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.InstallmentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleCalculationEventRepository extends CrudRepository<ScheduleCalculationEventEntity, Integer> {
}
