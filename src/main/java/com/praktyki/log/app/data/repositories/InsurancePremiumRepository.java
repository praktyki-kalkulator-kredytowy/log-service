package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.InsurancePremiumEntity;
import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePremiumRepository extends CrudRepository<InsurancePremiumEntity, Integer> {

    @Query(value = "SELECT * FROM insurance_premiums WHERE schedule_calculation_event_id = :id", nativeQuery = true)
    Iterable<InsurancePremiumEntity> findAllByEventId(Integer id);

}
