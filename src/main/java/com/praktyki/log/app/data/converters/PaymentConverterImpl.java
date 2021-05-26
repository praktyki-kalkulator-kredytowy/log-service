package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.web.message.models.Payment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentConverterImpl implements PaymentConverter {


    @Override
    public PaymentEntity convertToEntity(Payment payment, ScheduleCalculationEventEntity scheduleCalculationEvent) {
        return new PaymentEntity(
        scheduleCalculationEvent,
                payment.getIndex(),
                payment.getInstallmentDate(),
                payment.getCapitalInstallment(),
                payment.getInterestInstallment(),
                payment.getRemainingDebt(),
                payment.getInsurancePremiumValue()
        );
    }

    @Override
    public List<PaymentEntity> convertListToEntity(List<Payment> payment, ScheduleCalculationEventEntity scheduleCalculationEvent) {
        return payment.stream()
                .map(i -> convertToEntity(i, scheduleCalculationEvent))
                .collect(Collectors.toList());
    }
}
