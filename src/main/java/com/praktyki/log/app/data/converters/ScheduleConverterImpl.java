package com.praktyki.log.app.data.converters;

import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
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
    public ScheduleModel convertToScheduleModel(ScheduleCalculationEventEntity entity)
    {
        return new ScheduleModel(
                mScheduleConfigurationConverter.convertToModel(entity.scheduleConfigurationEntity),
                mPaymentConverter.convertListToModel(entity.payments),
                entity.scheduleSummaryEntity.sumUpCapitalInstallment,
                entity.scheduleSummaryEntity.loanPaidOutAmount,
                entity.scheduleSummaryEntity.commissionAmount,
                entity.scheduleSummaryEntity.insuranceTotalAmount,
                entity.scheduleSummaryEntity.loanTotalCost,
                entity.scheduleSummaryEntity.aprc
        );
    }

}
