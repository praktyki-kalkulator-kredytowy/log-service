package com.praktyki.log.app.data.repositories;

import com.praktyki.log.app.data.entities.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends CrudRepository<PaymentEntity, Integer> {

    @Query(value = "SELECT * FROM payments WHERE schedule_calculation_event_id = :id",nativeQuery = true)
    Iterable<PaymentEntity> getAllPaymentsByEventId(Integer id);

}
