package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.PaymentModel;

import java.util.List;

public interface PaymentConverter {

    PaymentEntity convertToEntity(PaymentModel paymentModel, ScheduleCalculationEventEntity scheduleCalculationEvent);

    List<PaymentEntity> convertListToEntity(List<PaymentModel> paymentModel, ScheduleCalculationEventEntity scheduleCalculationEvent);

    PaymentModel convertToModel(PaymentEntity paymentEntity);

    List<PaymentModel> convertListToModel(List<PaymentEntity> paymentEntity);

}
