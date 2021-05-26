package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleConfigurationEntity;
import com.praktyki.log.app.data.entities.ScheduleSummaryEntity;
import com.praktyki.log.web.message.models.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleConverterImpl implements ScheduleConverter {

    @Autowired
    private ScheduleConfigurationConverter mScheduleConfigurationConverter;

    @Autowired
    private PaymentConverter mPaymentConverter;

    @Override
    public ScheduleSummaryEntity convertToSummaryEntity(ScheduleModel scheduleModel) {
        return new ScheduleSummaryEntity(
                scheduleModel.capitalInstallmentSum,
                scheduleModel.loanPaidOutAmount,
                scheduleModel.commissionAmount,
                scheduleModel.insuranceTotalAmount,
                scheduleModel.loanTotalCost,
                scheduleModel.aprc
        );
    }

    @Override
    public ScheduleModel convertToScheduleModel(
            ScheduleSummaryEntity scheduleSummaryEntity,
            ScheduleConfigurationEntity scheduleConfiguration,
            List<PaymentEntity> paymentList
    )
    {
        return new ScheduleModel(
                mScheduleConfigurationConverter.convertToModel(scheduleConfiguration),
                mPaymentConverter.convertListToModel(paymentList),
                scheduleSummaryEntity.sumUpCapitalInstallment,
                scheduleSummaryEntity.loanPaidOutAmount,
                scheduleSummaryEntity.commissionAmount,
                scheduleSummaryEntity.insuranceTotalAmount,
                scheduleSummaryEntity.loanTotalCost,
                scheduleSummaryEntity.aprc
        );
    }

}
