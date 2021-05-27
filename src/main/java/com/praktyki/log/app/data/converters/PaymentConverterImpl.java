package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.PaymentModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentConverterImpl implements PaymentConverter {


    @Override
    public PaymentEntity convertToEntity(PaymentModel paymentModel, ScheduleCalculationEventEntity scheduleCalculationEvent) {
        return new PaymentEntity(
                scheduleCalculationEvent,
                paymentModel.index,
                paymentModel.date,
                paymentModel.capitalInstallment,
                paymentModel.interestInstallment,
                paymentModel.remainingDebt,
                paymentModel.insurancePremiumValue
        );
    }

    @Override
    public List<PaymentEntity> convertListToEntity(List<PaymentModel> paymentModel, ScheduleCalculationEventEntity scheduleCalculationEvent) {
        return paymentModel.stream()
                .map(i -> convertToEntity(i, scheduleCalculationEvent))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentModel convertToModel(PaymentEntity paymentEntity) {
        return new PaymentModel(
                paymentEntity.paymentId,
                paymentEntity.installmentDate,
                paymentEntity.capitalInstallment,
                paymentEntity.interestInstallment,
                paymentEntity.remainingDebt,
                paymentEntity.insurancePremiumValue
        );
    }

    @Override
    public List<PaymentModel> convertListToModel(List<PaymentEntity> paymentEntity) {
        return paymentEntity.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }
}
