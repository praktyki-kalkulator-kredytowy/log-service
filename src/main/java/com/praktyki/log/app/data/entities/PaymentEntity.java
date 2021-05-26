package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    public int paymentId;

    @Column(name = "payment_index")
    public int installmentIndex;

    @Column(name = "payment_date")
    public LocalDate installmentDate;

    @Column(name = "capital_payment")
    public BigDecimal capitalInstallment;

    @Column(name = "interest_payment")
    public BigDecimal interestInstallment;

    @Column(name = "remaining_debt")
    public BigDecimal remainingDebt;

    @Column(name = "insurance_premium_value")
    public BigDecimal insurancePremiumValue;

    @ManyToOne
    @JoinColumn(name = "schedule_calculation_event_id")
    public ScheduleCalculationEventEntity scheduleCalculationEventEntity;

    public PaymentEntity() {
    }

    public PaymentEntity(
            ScheduleCalculationEventEntity scheduleCalculationEventEntity, int installmentIndex,
            LocalDate installmentDate, BigDecimal capitalInstallment,
            BigDecimal interestInstallment, BigDecimal remainingDebt, BigDecimal insurancePremiumValue)
    {
        this.scheduleCalculationEventEntity = scheduleCalculationEventEntity;
        this.installmentIndex = installmentIndex;
        this.installmentDate = installmentDate;
        this.capitalInstallment = capitalInstallment;
        this.interestInstallment = interestInstallment;
        this.remainingDebt = remainingDebt;
        this.insurancePremiumValue = insurancePremiumValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                installmentIndex, installmentDate, capitalInstallment,
                interestInstallment, remainingDebt, insurancePremiumValue
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Installment {\n");

        sb.append("    index: ").append(toIndentedString(installmentIndex)).append("\n");
        sb.append("    date: ").append(toIndentedString(installmentDate)).append("\n");
        sb.append("    capitalInstallment: ").append(toIndentedString(capitalInstallment)).append("\n");
        sb.append("    interestInstallment: ").append(toIndentedString(interestInstallment)).append("\n");
        sb.append("    remainingDebt: ").append(toIndentedString(remainingDebt)).append("\n");
        sb.append("    insurancePremiumValue: ").append(toIndentedString(insurancePremiumValue)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
