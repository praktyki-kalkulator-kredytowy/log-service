package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.InstallmentEntity;
import com.praktyki.log.app.data.entities.InsurancePremiumEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends CrudRepository<InstallmentEntity, Integer> {

    @Query(value = "SELECT * FROM installments WHERE schedule_calculation_event_id = :id", nativeQuery = true)
    Iterable<InstallmentEntity> findAllByEventId(Integer id);

}
