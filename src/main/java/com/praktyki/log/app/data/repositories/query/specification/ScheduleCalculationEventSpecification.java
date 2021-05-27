package com.praktyki.log.app.data.repositories.query.specification;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduleCalculationEventSpecification {

    public static Specification<ScheduleCalculationEventEntity> ageAboveOrEqual(Integer age) {

        return (root, query, criteriaBuilder) -> {
            if(age == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("age"), age
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> ageBelowOrEqual(Integer age) {

        return (root, query, criteriaBuilder) -> {
            if(age == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("age"), age
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> aprcAboveOrEqual(Double aprc) {

        return (root, query, criteriaBuilder) -> {
            if(aprc == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleSummaryEntity").get("aprc"), aprc
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> aprcBelowOrEqual(Double aprc) {

        return (root, query, criteriaBuilder) -> {
            if(aprc == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleSummaryEntity").get("aprc"), aprc
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> insuranceSumAboveOrEqual(BigDecimal insuranceSum) {

        return (root, query, criteriaBuilder) -> {
            if(insuranceSum == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleSummaryEntity").get("insuranceTotalAmount"), insuranceSum
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> insuranceSumBelowOrEqual(BigDecimal insuranceSum) {

        return (root, query, criteriaBuilder) -> {
            if(insuranceSum == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleSummaryEntity").get("insuranceTotalAmount"), insuranceSum
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> interestRateAboveOrEqual(Double interestRate) {

        return (root, query, criteriaBuilder) -> {
            if(interestRate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("interestRate"), interestRate
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> interestRateBelowOrEqual(Double interestRate) {

        return (root, query, criteriaBuilder) -> {
            if(interestRate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("interestRate"), interestRate
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> installmentAmountAboveOrEqual(Integer installmentAmount) {

        return (root, query, criteriaBuilder) -> {
            if(installmentAmount == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("installmentAmount"), installmentAmount
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> installmentAmountBelowOrEqual(Integer installmentAmount) {

        return (root, query, criteriaBuilder) -> {
            if(installmentAmount == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("installmentAmount"), installmentAmount
            );
        };

    }
    public static Specification<ScheduleCalculationEventEntity> capitalAboveOrEqual(BigDecimal capital) {

        return (root, query, criteriaBuilder) -> {
            if(capital == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("capital"), capital
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> capitalBelowOrEqual(BigDecimal capital) {

        return (root, query, criteriaBuilder) -> {
            if(capital == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("capital"), capital
            );
        };

    }
    public static Specification<ScheduleCalculationEventEntity> withdrawalDateAboveOrEqual(LocalDate withdrawalDate) {

        return (root, query, criteriaBuilder) -> {
            if(withdrawalDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("withdrawalDate"), withdrawalDate
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> withdrawalDateBelowOrEqual(LocalDate withdrawalDate) {

        return (root, query, criteriaBuilder) -> {
            if(withdrawalDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("scheduleConfigurationEntity").get("withdrawalDate"), withdrawalDate
            );
        };

    }
    public static Specification<ScheduleCalculationEventEntity> calculationDateAboveOrEqual(LocalDate calculationDate) {

        return (root, query, criteriaBuilder) -> {
            if(calculationDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("orderDate"), calculationDate
            );
        };

    }

    public static Specification<ScheduleCalculationEventEntity> calculationDateBelowOrEqual(LocalDate calculationDate) {

        return (root, query, criteriaBuilder) -> {
            if(calculationDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("orderDate"), calculationDate
            );
        };

    }
}
