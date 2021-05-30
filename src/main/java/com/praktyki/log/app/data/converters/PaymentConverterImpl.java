package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.web.message.models.PaymentModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentConverterImpl implements PaymentConverter {


    @Override
    public PaymentEntity convertToEntity(PaymentModel paymentModel) {
        return new PaymentEntity(
                paymentModel.index,
                paymentModel.date,
                paymentModel.capitalInstallment,
                paymentModel.interestInstallment,
                paymentModel.remainingDebt,
                paymentModel.insurancePremium
        );
    }

    @Override
    public List<PaymentEntity> convertListToEntity(List<PaymentModel> paymentModel) {
        return paymentModel.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentModel convertToModel(PaymentEntity paymentEntity) {
        return new PaymentModel(
                paymentEntity.installmentIndex,
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
