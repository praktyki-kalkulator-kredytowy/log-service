package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleCalculationEventRepository extends JpaRepository<ScheduleCalculationEventEntity, Integer>,
        JpaSpecificationExecutor<ScheduleCalculationEventEntity> {

}
