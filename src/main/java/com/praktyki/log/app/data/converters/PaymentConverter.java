package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.Payment;
import com.praktyki.log.web.message.models.ScheduleCalculationEvent;

import java.util.List;

public interface PaymentConverter {

    PaymentEntity convertToEntity(Payment payment, ScheduleCalculationEventEntity scheduleCalculationEvent);

    List<PaymentEntity> convertListToEntity(List<Payment> payment, ScheduleCalculationEventEntity scheduleCalculationEvent);

}
