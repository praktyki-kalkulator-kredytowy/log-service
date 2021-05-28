package com.praktyki.log.app.interactors;

import com.praktyki.log.app.data.entities.*;
import com.praktyki.log.app.data.repositories.ScheduleCalculationEventRepository;
import com.praktyki.log.app.data.utils.SpecUtils;
import com.praktyki.log.web.exceptions.NotSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class AuditDataInteractor {

    @Autowired
    private ScheduleCalculationEventRepository mAuditRepository;

    public Collection<ScheduleCalculationEventEntity> filterAuditData(
            LocalDate calculationStartDate,
            LocalDate calculationEndDate,
            LocalDate withdrawalStartDate,
            LocalDate withdrawalEndDate,
            Double capitalStart,
            Double capitalEnd,
            Integer installmentAmountStart,
            Integer installmentAmountEnd,
            Double interestRateStart,
            Double interestRateEnd,
            Double insuranceSumStart,
            Double insuranceSumEnd,
            Integer clientAgeStart,
            Integer clientAgeEnd,
            Double aprcStart,
            Double aprcEnd
    ) {

        Specification<ScheduleCalculationEventEntity> spec =
                SpecUtils.gte(calculationStartDate, r -> r.get(ScheduleCalculationEventEntity_.orderDate))
                .and(SpecUtils.lte(calculationEndDate, r -> r.get(ScheduleCalculationEventEntity_.orderDate)))
                .and(SpecUtils.gte(withdrawalStartDate, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.withdrawalDate)))
                .and(SpecUtils.lte(withdrawalEndDate, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.withdrawalDate)))
                .and(SpecUtils.gte(capitalStart, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.capital)))
                .and(SpecUtils.lte(capitalEnd, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.capital)))
                .and(SpecUtils.gte(installmentAmountStart, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.installmentAmount)))
                .and(SpecUtils.lte(installmentAmountEnd, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.installmentAmount)))
                .and(SpecUtils.gte(interestRateStart, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.interestRate)))
                .and(SpecUtils.lte(interestRateEnd, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.interestRate)))
                .and(SpecUtils.gte(insuranceSumStart, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleSummaryEntity)
                        .get(ScheduleSummaryEntity_.insuranceTotalAmount)))
                .and(SpecUtils.lte(insuranceSumEnd, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleSummaryEntity)
                        .get(ScheduleSummaryEntity_.insuranceTotalAmount)))
                .and(SpecUtils.gte(clientAgeStart, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.age)))
                .and(SpecUtils.lte(clientAgeEnd, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleConfigurationEntity)
                        .get(ScheduleConfigurationEntity_.age)))
                .and(SpecUtils.gte(aprcStart, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleSummaryEntity)
                        .get(ScheduleSummaryEntity_.aprc)))
                .and(SpecUtils.lte(aprcEnd, r -> r
                        .get(ScheduleCalculationEventEntity_.scheduleSummaryEntity)
                        .get(ScheduleSummaryEntity_.aprc)));


        return mAuditRepository.findAll(spec);
    }

    public ScheduleCalculationEventEntity getEventById(int id) throws NotSuchEntityException {
        return mAuditRepository.findById(id).orElseThrow(NotSuchEntityException::new);
    }


    public void saveEvent(ScheduleCalculationEventEntity entity) {
        mAuditRepository.save(entity);
    }
}
